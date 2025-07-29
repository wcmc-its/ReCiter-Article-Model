package reciter.engine.analysis.evidence;

/**
 * Represents information about a grant and its matching score.
 * <p>
 * This class contains the grant information as listed by the institution,
 * the grant as mentioned in the article, and a score indicating the quality
 * or strength of the match between them.
 * </p>
 * @author ved4006
 */

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
	Grant Evidence
*/
@Data
@ToString
@DynamoDbBean
public class Grant {
	
	/** The grant information from the institution's records. */
    private String institutionGrant;

    /** The grant article. */
    private String articleGrant;

    /** The score indicating how well the grants match. */
    private double grantMatchScore;
}
