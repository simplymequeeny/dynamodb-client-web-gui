package simplymequeeny.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import simplymequeeny.configs.WebAppConfig;
import simplymequeeny.utils.ConnectionType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
public class HelperServiceTest {

    @Autowired
    private HelperService helperService;

    @Test
    public void shouldReturnLocalConnectionTypeWhenEndpointUrlIsProvided() {
        ReflectionTestUtils.setField(helperService, "ENDPOINT_URL", "localhost");
        Assert.assertEquals(ConnectionType.LOCAL, helperService.getConnectionType());
    }

    @Test
    public void shouldReturnAwsConnectionTypeWhenEndpointUrlIsNotProvided() {
        ReflectionTestUtils.setField(helperService, "ENDPOINT_URL", "");
        Assert.assertEquals(ConnectionType.AWS, helperService.getConnectionType());
    }
}
