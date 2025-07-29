package reciter.engine.analysis.evidence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * The Class RelationshipEvidence.
 *
 * @author szd2013
 * This class contains the relationship evidence coming out of the relationship strategy
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class RelationshipEvidence {
	
	/** The relationship evidence total score. */
	private double relationshipEvidenceTotalScore;
	
	/** The relationship negative match. */
	private RelationshipNegativeMatch relationshipNegativeMatch; 
    
    /** The relationship positive match. */
    private List<RelationshipPostiveMatch> relationshipPositiveMatch;
    
    /** The relationship positive match score. */
    private double relationshipPositiveMatchScore;
    
    /** The relationship negative match score. */
    private double relationshipNegativeMatchScore;
    
    /** The relationship identity count. */
    private long relationshipIdentityCount;
}
