package simplymequeeny.controllers;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simplymequeeny.utils.ConnectionType;
import simplymequeeny.services.HelperService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class TableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableController.class);

    @Autowired
    private HelperService helperService;

    @Autowired
    private AmazonDynamoDB amazonDynamoDBClient;

    private List<String> names;

    @RequestMapping("/names")
    public
    @ResponseBody
    List<String> names() {
        try {
            names = amazonDynamoDBClient.listTables().getTableNames();
        } catch (AmazonClientException ex) {
            names = Collections.EMPTY_LIST;
            LOGGER.error(ex.getMessage());
        }

        return names;
    }

    @RequestMapping("/describe/{table}")
    public
    @ResponseBody
    TableDescription definition(@PathVariable String table) {
        TableDescription description = null;

        try {
            if (!names.isEmpty()) {
                description = amazonDynamoDBClient.describeTable(table).getTable();
            }
        } catch (AmazonClientException ex) {
            LOGGER.error(ex.getMessage());
        }

        return description;
    }

    @RequestMapping("/scan/{table}/items")
    public
    @ResponseBody
    List<Map<String, Object>> items(@PathVariable String table) {
        LOGGER.info("Getting items for " + table);
        List<Map<String, Object>> items = new ArrayList<>();
        ScanRequest scanRequest = new ScanRequest().withTableName(table);

        try {
            List<Map<String, AttributeValue>> list = amazonDynamoDBClient.scan(scanRequest).getItems();
            LOGGER.info("raw items ", list);
            for (Map<String, AttributeValue> item : list) {
                items.add(InternalUtils.toSimpleMapValue(item));
            }
        } catch (AmazonClientException ex) {
            LOGGER.error(ex.getMessage());
        }


        return items;
    }

    @RequestMapping("/connection-type")
    public
    @ResponseBody
    ConnectionType connectionType() {
        return helperService.getConnectionType();
    }
}
