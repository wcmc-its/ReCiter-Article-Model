package reciter.engine.analysis.evidence;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

/**
 * @author szd2013
 * This class contains the relationship evidence coming out of the relationship strategy
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDBDocument
public class RelationshipEvidence {
	
	private double relationshipEvidenceTotalScore;
	private RelationshipNegativeMatch relationshipNegativeMatch; 
    private List<RelationshipPostiveMatch> relationshipPositiveMatch;
    private double relationshipPositiveMatchScore;
    private double relationshipNegativeMatchScore;
    private long relationshipIdentityCount;
}
