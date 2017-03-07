package simplymequeeny.configs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

@Import(WebAppConfig.class)
@Configuration
public class AwsConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsConfig.class);

    private ProfileCredentialsProvider profileCredentialsProvider;

    @Value("${endpoint.url}")
    private String ENDPOINT_URL;

    @Value("${profile}")
    private String PROFILE;

    @Bean
    @DependsOn("properties")
    public AWSCredentials awsCredentials(ProfileCredentialsProvider profileCredentialsProvider) {
        AWSCredentials credentials;

        if (!ENDPOINT_URL.isEmpty()) {
            LOGGER.info("Basic Credentials Used");
            // The secret key doesn't need to be valid, DynamoDB Local doesn't care.
            credentials = new BasicAWSCredentials("dynamo", "testDummyKey");
        } else {
            LOGGER.info("Profile Credentials Used");
            credentials = profileCredentialsProvider.getCredentials();
        }

        return credentials;
    }

    @Bean
    @DependsOn("awsCredentials")
    public AmazonDynamoDB amazonDynamoDBClient(AWSCredentials awsCredentials) {
        AmazonDynamoDBClient awsClient = new AmazonDynamoDBClient(awsCredentials);
        if (!ENDPOINT_URL.isEmpty()) {
            LOGGER.info("END POINT " + ENDPOINT_URL);
            awsClient.setEndpoint(ENDPOINT_URL);
            awsClient.setSignerRegionOverride("local");
        }
        return awsClient;
    }

    @Bean
    public ProfileCredentialsProvider profileCredentialsProvider() {
        ProfileCredentialsProvider profileCredentialsProvider = new ProfileCredentialsProvider();
        if (!PROFILE.isEmpty()) profileCredentialsProvider = new ProfileCredentialsProvider(PROFILE);
        return profileCredentialsProvider;
    }
}
