package simplymequeeny.stubs;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.waiters.AmazonDynamoDBWaiters;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StubAmazonDynamoDBClient implements AmazonDynamoDB {


    @Override
    public void setEndpoint(String s) {

    }

    @Override
    public void setRegion(Region region) {

    }

    @Override
    public BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) {
        return null;
    }

    @Override
    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map, String s) {
        return null;
    }

    @Override
    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map) {
        return null;
    }

    @Override
    public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) {
        return null;
    }

    @Override
    public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> map) {
        return null;
    }

    @Override
    public CreateTableResult createTable(CreateTableRequest createTableRequest) {
        return null;
    }

    @Override
    public CreateTableResult createTable(
            List<AttributeDefinition> list, String s,
            List<KeySchemaElement> list1, ProvisionedThroughput provisionedThroughput) {
        return null;
    }

    @Override
    public DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) {
        return null;
    }

    @Override
    public DeleteItemResult deleteItem(String s, Map<String, AttributeValue> map) {
        return null;
    }

    @Override
    public DeleteItemResult deleteItem(String s, Map<String, AttributeValue> map, String s1) {
        return null;
    }

    @Override
    public DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) {
        return null;
    }

    @Override
    public DeleteTableResult deleteTable(String s) {
        return null;
    }

    @Override
    public DescribeLimitsResult describeLimits(DescribeLimitsRequest describeLimitsRequest) {
        return null;
    }

    @Override
    public DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) {
        return null;
    }

    @Override
    public DescribeTableResult describeTable(String s) {
        return null;
    }

    @Override
    public DescribeTimeToLiveResult describeTimeToLive(DescribeTimeToLiveRequest describeTimeToLiveRequest) {
        return null;
    }

    @Override
    public GetItemResult getItem(GetItemRequest getItemRequest) {
        return null;
    }

    @Override
    public GetItemResult getItem(String s, Map<String, AttributeValue> map) {
        return null;
    }

    @Override
    public GetItemResult getItem(String s, Map<String, AttributeValue> map, Boolean aBoolean) {
        return null;
    }

    @Override
    public ListTablesResult listTables(ListTablesRequest listTablesRequest) {
        return null;
    }

    @Override
    public ListTablesResult listTables() {
        return new ListTablesResult();
    }

    @Override
    public ListTablesResult listTables(String s) {
        return new ListTablesResult();
    }

    @Override
    public ListTablesResult listTables(String s, Integer integer) {
        return null;
    }

    @Override
    public ListTablesResult listTables(Integer integer) {
        return null;
    }

    @Override
    public ListTagsOfResourceResult listTagsOfResource(ListTagsOfResourceRequest listTagsOfResourceRequest) {
        return null;
    }

    @Override
    public PutItemResult putItem(PutItemRequest putItemRequest) {
        return null;
    }

    @Override
    public PutItemResult putItem(String s, Map<String, AttributeValue> map) {
        return null;
    }

    @Override
    public PutItemResult putItem(String s, Map<String, AttributeValue> map, String s1) {
        return null;
    }

    @Override
    public QueryResult query(QueryRequest queryRequest) {
        return null;
    }

    @Override
    public ScanResult scan(ScanRequest scanRequest) {
        return null;
    }

    @Override
    public ScanResult scan(String s, List<String> list) {
        return null;
    }

    @Override
    public ScanResult scan(String s, Map<String, Condition> map) {
        return null;
    }

    @Override
    public ScanResult scan(String s, List<String> list, Map<String, Condition> map) {
        return null;
    }

    @Override
    public TagResourceResult tagResource(TagResourceRequest tagResourceRequest) {
        return null;
    }

    @Override
    public UntagResourceResult untagResource(UntagResourceRequest untagResourceRequest) {
        return null;
    }

    @Override
    public UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) {
        return null;
    }

    @Override
    public UpdateItemResult updateItem(String s, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map1) {
        return null;
    }

    @Override
    public UpdateItemResult updateItem(String s, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map1, String s1) {
        return null;
    }

    @Override
    public UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) {
        return null;
    }

    @Override
    public UpdateTableResult updateTable(String s, ProvisionedThroughput provisionedThroughput) {
        return null;
    }

    @Override
    public UpdateTimeToLiveResult updateTimeToLive(UpdateTimeToLiveRequest updateTimeToLiveRequest) {
        return null;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    @Override
    public AmazonDynamoDBWaiters waiters() {
        return null;
    }
}
