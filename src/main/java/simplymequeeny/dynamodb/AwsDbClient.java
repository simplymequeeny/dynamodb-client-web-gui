package simplymequeeny.dynamodb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AwsDbClient extends AmazonDynamoDBClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsDbClient.class);

    public enum ConnectionType {
        LOCAL, AWS
    }

    @Value("${endpoint.url}")
    private String ENDPOINT_URL;

    private ConnectionType type = ConnectionType.AWS;
    private List<String> tableNames;

    public AwsDbClient() {
    }

    public void init() {
        LOGGER.info("ENDPOINT_URL ", ENDPOINT_URL);

        withRegion(Regions.US_EAST_1);

        if (!ENDPOINT_URL.isEmpty()) {
            type = ConnectionType.LOCAL;
            withEndpoint(ENDPOINT_URL);
        }
    }

    public List<String> getTableNames() throws AmazonClientException {
        return listTables().getTableNames();
    }

    public ConnectionType getConnectionType() {
        return type;
    }
}
