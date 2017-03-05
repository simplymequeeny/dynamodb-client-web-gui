package simplymequeeny.dynamodb;

import com.amazonaws.AmazonClientException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import simplymequeeny.AbstractBaseTest;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class DbClientTest extends AbstractBaseTest {

    @Spy
    private AwsDbClient dbClient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldConnectToDynamoDbLocal() {
        doReturn(AwsDbClient.ConnectionType.LOCAL).when(dbClient).getConnectionType();

        Assert.assertEquals(AwsDbClient.ConnectionType.LOCAL, dbClient.getConnectionType());

        verify(dbClient, times(1)).getConnectionType();
    }

    @Test
    public void shouldGetTableNames() {
        doReturn(Collections.EMPTY_LIST).when(dbClient).getTableNames();

        Assert.assertNotNull(dbClient.getTableNames());

        verify(dbClient, times(1)).getTableNames();
    }

    @Test
    public void shouldConnectToAwsDynamoDb() {
        Assert.assertEquals(AwsDbClient.ConnectionType.AWS, dbClient.getConnectionType());
    }

    @Test(expected=AmazonClientException.class)
    public void shouldReturnAmazonClientExceptionWhenNoCredentialsLoaded() {
        dbClient.getTableNames();
    }
}
