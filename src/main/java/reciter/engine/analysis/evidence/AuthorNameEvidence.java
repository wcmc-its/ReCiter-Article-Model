package reciter.engine.analysis.evidence;
/**
 * Represents evidence related to author name matching between institutional and article sources.
 * <p>
 * This class contains details of the institutional and article author names, as well as
 * various scores and match types for each component of the name (first, middle, last, and modifier).
 * </p>
 * @author ved4006
 */


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.model.identity.AuthorName;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class AuthorNameEvidence {

    /** The author's name as listed in the institutional records. */
    private AuthorName institutionalAuthorName;

    /** The author's name as listed in the article. */
    private AuthorName articleAuthorName;

    /** Total score representing the overall article author names. */
    private double nameScoreTotal;

    /** The type of match for the first name . */
    private String nameMatchFirstType;

    /** The score for the first name match. */
    private double nameMatchFirstScore;

    /** The type of match for the middle name . */
    private String nameMatchMiddleType;

    /** The score for the middle name match. */
    private double nameMatchMiddleScore;

    /** The type of match for the last name . */
    private String nameMatchLastType;

    /** The score for the last name match. */
    private double nameMatchLastScore;

    /** The match type for the name modifier.  */
    private String nameMatchModifier;

    /** The score for the name modifier match. */
    private double nameMatchModifierScore;
}
