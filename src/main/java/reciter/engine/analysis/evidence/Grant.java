package reciter.engine.analysis.evidence;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@ToString
@DynamoDbBean
public class Grant {
    private String institutionGrant;
    private String articleGrant;
	private double grantMatchScore;
}
