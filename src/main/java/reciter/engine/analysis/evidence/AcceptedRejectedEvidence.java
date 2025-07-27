package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
/**
 * Represents evidence scores associated with accepted, rejected, and null feedback.
 * <p>
 * This class stores feedback scores for each feedback category and can be used
 * to evaluate or compare the performance of different feedback types.
 * </p>
 * @author ved4006
 */

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class AcceptedRejectedEvidence {
	
	/** Feedback score for accepted article. */
	private Double feedbackScoreAccepted;
	
	/** Feedback score for rejected article. */
	private Double feedbackScoreRejected;
	
	/** Feedback score for null (suggested article). */
	private Double feedbackScoreNull;
}
