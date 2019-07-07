import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DynamoDBClient {
    public DynamoDB dynamoDB;
    private final static Logger LOGGER = Logger.getLogger(DynamoDBClient.class);

    public DynamoDBClient(String awsKeyId, String awsAccessKey) {
        AWSCredentials credentials = new BasicAWSCredentials(awsKeyId, awsAccessKey);

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
        dynamoDB = new DynamoDB(client);
    }

}
