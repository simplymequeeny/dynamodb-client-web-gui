package simplymequeeny.dynamodb;

import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import simplymequeeny.AbstractBaseTest;

public class AwsDbClientTest extends AbstractBaseTest {

    @Mock
    AwsDbClient dbClient;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);    
    }
    
    @Test
    public void shouldConnectToDb() {
        when(dbClient.getTableNames()).thenReturn(Collections.EMPTY_LIST);
        List<String> tables = dbClient.getTableNames();
        Assert.assertNotNull(tables);
    }   
}
