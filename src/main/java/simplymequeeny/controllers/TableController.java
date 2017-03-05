package simplymequeeny.controllers;

import com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import java.util.ArrayList;
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
    AwsDbClient dbClient;

    @RequestMapping("/names")
    public @ResponseBody
    List<String> names() {
        return dbClient.getTableNames();
    }

    @RequestMapping("/describe/{name}")
    public @ResponseBody
    TableDescription definition(@PathVariable String name) {
        TableDescription description = new TableDescription();
        if (!dbClient.getTableNames().isEmpty())
            description = dbClient.describeTable(name).getTable();
        return description;
    }

    @RequestMapping("/scan/{name}/items")
    public @ResponseBody
    List<Map<String, Object>> items(@PathVariable String name) {
        LOGGER.info("Getting items for " + name);
        ScanRequest scanRequest = new ScanRequest()
                .withTableName(name);
        List<Map<String, Object>> list = new ArrayList<>();
        dbClient.scan(scanRequest).getItems().stream().forEach(
                (Map<String, AttributeValue> map) -> {
            list.add(InternalUtils.toSimpleMapValue(map));
        });
        return list;
    }
    
    @RequestMapping("/connection-type")
    public @ResponseBody ConnectionType connectionType() {
        return dbClient.getConnectionType();
    }
}
