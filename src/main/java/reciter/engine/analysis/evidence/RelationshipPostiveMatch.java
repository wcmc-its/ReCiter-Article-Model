package reciter.engine.analysis.evidence;

/**
 * Represents evidence of a positive relationship match between authors.
 * <p>
 * This class stores the names from the article and identity profiles, types of relationships,
 * match type, matching scores, modifier scores for various relationship types, and the total
 * count of matching relationships.
 * </p>
 * @author ved4006
 */

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.model.identity.AuthorName;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
	RelationshipPostiveMatch class
*/

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class RelationshipPostiveMatch {
	
	/** The author's name as listed in the article. */
    private AuthorName relationshipNameArticle;

    /** The author's name as listed in the identity profile. */
    private AuthorName relationshipNameIdentity;

    /** Set of relationship types (e.g., co-author, mentor, manager). */
    private Set<String> relationshipType;

    /** The type of relationship match (e.g., verbose, initial). */
    private String relationshipMatchType;

    /** The score representing the strength of the relationship match. */
    private double relationshipMatchingScore;

    /** Additional verbose match modifier score. */
    private double relationshipVerboseMatchModifierScore;

    /** Modifier score for mentor relationship type. */
    private double relationshipMatchModifierMentor;

    /** Modifier score for mentor as senior author relationship type. */
    private double relationshipMatchModifierMentorSeniorAuthor;

    /** Modifier score for manager relationship type. */
    private double relationshipMatchModifierManager;

    /** Modifier score for manager as senior author relationship type. */
    private double relationshipMatchModifierManagerSeniorAuthor;

    /** The count of matching relationships found. */
    private long relationshipMatchingCount;
}
