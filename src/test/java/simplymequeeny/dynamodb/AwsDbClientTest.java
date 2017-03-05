package simplymequeeny.dynamodb;

import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import simplymequeeny.AbstractBaseTest;

public class AwsDbClientTest extends AbstractBaseTest {

    @Autowired
    AwsDbClient dbClient;

    @Test
    public void shouldConnectToDb() {
        List<String> tables = dbClient.listTables().getTableNames();
        Assert.assertNotNull(tables);
    }   
}
