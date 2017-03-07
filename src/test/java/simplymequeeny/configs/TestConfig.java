package simplymequeeny.configs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import simplymequeeny.stubs.StubAWSCredentials;
import simplymequeeny.stubs.StubAmazonDynamoDBClient;

@Import(WebAppConfig.class)
@Configurable
@PropertySource("classpath:application.properties")
public class TestConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDbClient() {
        return new StubAmazonDynamoDBClient();
    }

    @Bean
    public AWSCredentials awsCredentials() {
        return new StubAWSCredentials();
    }

}
