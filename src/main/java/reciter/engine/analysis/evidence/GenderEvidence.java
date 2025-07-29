package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to gender identification scores.
 * <p>
 * This class stores gender scores based on article data, identity records, and the discrepancy
 * between the two. These scores can be used to assess the consistency of gender information
 * across different sources.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
	GenderEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class GenderEvidence {
	
	/** Gender score determined from the article. */
    private Double genderScoreArticle;

    /** Gender score determined from the identity record. */
    private Double genderScoreIdentity;

    /** Discrepancy score for the identity gender. */
    private Double genderScoreIdentityArticleDiscrepancy;
}
