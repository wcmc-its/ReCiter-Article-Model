package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class AcceptedRejectedEvidence {
	
	private Double feedbackScoreAccepted;
	private Double feedbackScoreRejected;
	private Double feedbackScoreNull;
}
