package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to email matching.
 * <p>
 * This class stores the result of an email match and its associated score,
 * which may be used to help determine identity or association.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class EmailEvidence {
	
	/** The email match (e.g., exact, partial, no match). */
	private String emailMatch;
	
	/** The score representing the strength or quality of the email match. */
	private double emailMatchScore;
}
