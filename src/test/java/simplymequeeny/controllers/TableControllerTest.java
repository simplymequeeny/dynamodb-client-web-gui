package simplymequeeny.controllers;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;
import simplymequeeny.configs.TestConfig;
import simplymequeeny.configs.WebAppConfig;
import simplymequeeny.services.HelperService;

import java.util.*;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, WebAppConfig.class})
public class TableControllerTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private AmazonDynamoDB amazonDynamoDB;

    @Mock
    private ScanRequest scanRequest;

    private ScanResult scanResult;

    @Autowired
    private HelperService helperService;

    @Autowired
    @InjectMocks
    private TableController tableController;

    @Before
    public void setup() {
        Mockito.reset(amazonDynamoDB);
        scanResult = new ScanResult();
    }

    @Test
    public void tableNamesShouldNotBeEmpty() throws Exception {
        when(amazonDynamoDB.listTables().getTableNames()).thenReturn(Arrays.asList(new String[]{"table1"}));
        Assert.notEmpty(tableController.names());
    }

    @Test
    public void tableNamesShouldBeEmptyWhenExceptionOccurred() {
        when(amazonDynamoDB.listTables().getTableNames()).thenThrow(new AmazonDynamoDBException("test"));
        org.junit.Assert.assertEquals(Collections.EMPTY_LIST, tableController.names());
    }

    @Test
    public void tableDefinitionShouldNotBeNull() {
        ReflectionTestUtils.setField(tableController, "names", Arrays.asList(new String[]{"table1"}));
        when(amazonDynamoDB.describeTable("table1").getTable()).thenReturn(new TableDescription());
        Assert.notNull(tableController.definition("table1"));
    }

    @Test
    public void tableDefinitionShouldBeNullWhenTablesIsEmpty() {
        ReflectionTestUtils.setField(tableController, "names", Collections.EMPTY_LIST);
        Assert.isNull(tableController.definition("table1"));
    }

    @Test
    public void tableDefinitionShouldBeNullWhenExceptionIsRaised() {
        when(amazonDynamoDB.describeTable("table1").getTable())
                .thenThrow(new AmazonDynamoDBException("test"));
        Assert.isNull(tableController.definition("table1"));
    }

    @Test
    public void itemsShouldNotBeEmpty() throws Exception {
        Map<String, AttributeValue> data = new HashMap<>();
        data.put("key1", new AttributeValue("value1"));

        List<Map<String, AttributeValue>> list = new ArrayList<>();
        list.add(data);

        when(amazonDynamoDB.scan(scanRequest).getItems()).thenReturn(list);
        // no idea why .getItems not being stubbed
        Assert.notEmpty(tableController.items("table1"));
    }

    @Test
    public void itemsShouldBeEmptyWhenTableHasNoData() throws Exception {
        List<Map<String, AttributeValue>> list = new ArrayList<>();
        when(amazonDynamoDB.scan(scanRequest).getItems()).thenReturn(list);
        org.junit.Assert.assertEquals(Collections.EMPTY_LIST, tableController.items("table1"));
    }

    @Test
    public void shouldNotBeNulllWhenEndpointIsProvided() {
        ReflectionTestUtils.setField(helperService, "ENDPOINT_URL", "localhost");
        Assert.notNull(tableController.connectionType());
    }
}
