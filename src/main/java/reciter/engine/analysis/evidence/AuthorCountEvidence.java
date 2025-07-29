package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to the number of authors and the corresponding score.
 * <p>
 * This class stores the total count of authors for an article or entity, along with
 * a score that may reflect the significance, quality, or another metric associated
 * with the author count.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class AuthorCountEvidence {
	/** The number of authors. */
	private int countAuthors;
	
	/** The score associated with the author count. */
	private double authorCountScore;
}
