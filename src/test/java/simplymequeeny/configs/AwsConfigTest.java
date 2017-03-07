package simplymequeeny.configs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;
import simplymequeeny.stubs.StubProfileCredentialsProvider;

@RunWith(SpringJUnit4ClassRunner.class)
public class AwsConfigTest {

    private AwsConfig config;

    @Before
    public void setup() {
        config = new AwsConfig();
    }

    @Test
    public void shouldHaveBasicCredentialsIntanceIsProvided() {
        ReflectionTestUtils.setField(config, "ENDPOINT_URL", "localhost");
        Assert.isInstanceOf(BasicAWSCredentials.class,
                config.awsCredentials(new StubProfileCredentialsProvider()));
    }

    @Test
    public void shouldHaveAwsCredentialsIntanceWhenEndpointUrlIsNotProvided() {
        ReflectionTestUtils.setField(config, "ENDPOINT_URL", "");
        ReflectionTestUtils.setField(config, "PROFILE", "");
        Assert.isInstanceOf(AWSCredentials.class,
                config.awsCredentials(new StubProfileCredentialsProvider()));
    }

    @Test
    public void shouldHaveAwsCredentialsIntanceWhenEndpointUrlIsNotProvidedAndProfileIsProvided() {
        ReflectionTestUtils.setField(config, "ENDPOINT_URL", "");
        ReflectionTestUtils.setField(config, "PROFILE", "default");
        Assert.isInstanceOf(AWSCredentials.class,
                config.awsCredentials(new StubProfileCredentialsProvider()));
    }

    @Test
    public void dbClientShouldNotBeNullWhenEndpointUrlIsNotProvided() {
        ReflectionTestUtils.setField(config, "ENDPOINT_URL", "");
        Assert.notNull(config.amazonDynamoDBClient(null));
    }

    @Test
    public void dbClientShouldNotBeNullWhenEndpointUrlIsProvided() {
        ReflectionTestUtils.setField(config, "ENDPOINT_URL", "localhost");
        Assert.notNull(config.amazonDynamoDBClient(null));
    }

    @Test
    public void profileCredentialProviderShouldNotBeNullWhenEndpointUrlIsNotProvided() {
        ReflectionTestUtils.setField(config, "PROFILE", "");
        Assert.notNull(config.profileCredentialsProvider());
    }

    @Test
    public void profileCredentialProviderShouldNotBeNullWhenEndpointUrlIsProvided() {
        ReflectionTestUtils.setField(config, "PROFILE", "default1");
        Assert.notNull(config.profileCredentialsProvider());
    }
}
