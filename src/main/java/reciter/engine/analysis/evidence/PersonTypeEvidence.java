package reciter.engine.analysis.evidence;
/**
 * Represents evidence related to a person's type  and its score.
 * <p>
 * This class stores a person type label (e.g., "academic-faculty-weillfulltime", "student-md-new-york")
 * and a score indicating the confidence or strength of this classification.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
	PersonTypeEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class PersonTypeEvidence {
	
	/** The type of person (e.g., academic-faculty-weillfulltime, student-md-new-york). */
    private String personType;

    /** The score representing the confidence in the person type classification. */
    private double personTypeScore;
}
