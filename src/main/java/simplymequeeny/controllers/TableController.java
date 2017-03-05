package simplymequeeny.controllers;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import simplymequeeny.dynamodb.AwsDbClient;
import simplymequeeny.dynamodb.AwsDbClient.ConnectionType;

@Controller
public class TableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableController.class);

    @Autowired
    private AwsDbClient dbClient;

    @RequestMapping("/names")
    public
    @ResponseBody
    List<String> names() {
        List<String> names = Collections.EMPTY_LIST;

        try {
            names = dbClient.getTableNames();
        } catch (AmazonClientException ex) {
            LOGGER.error(ex.getMessage());
        }

        return names;
    }

    @RequestMapping("/describe/{name}")
    public
    @ResponseBody
    TableDescription definition(@PathVariable String table) {
        TableDescription description = new TableDescription();

        try {
            if (!dbClient.getTableNames().isEmpty())
                description = dbClient.describeTable(table).getTable();
        } catch (AmazonClientException ex) {
            LOGGER.error(ex.getMessage());
        }

        return description;
    }

    @RequestMapping("/scan/{name}/items")
    public
    @ResponseBody
    List<Map<String, Object>> items(@PathVariable String table) {
        LOGGER.info("Getting items for " + table);
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(table);

            dbClient.scan(scanRequest).getItems().stream().forEach(
                    (Map<String, AttributeValue> map) -> {
                        list.add(InternalUtils.toSimpleMapValue(map));
                    });
        } catch (AmazonClientException ex) {
            LOGGER.error(ex.getMessage());
        }


        return list;
    }

    @RequestMapping("/connection-type")
    public
    @ResponseBody
    ConnectionType connectionType() {
        return dbClient.getConnectionType();
    }
}
