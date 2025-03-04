package reciter.engine.analysis.evidence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * @author szd2013
 * This class contains the relationship evidence coming out of the relationship strategy
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class RelationshipEvidence {
	
	private double relationshipEvidenceTotalScore;
	private RelationshipNegativeMatch relationshipNegativeMatch; 
    private List<RelationshipPostiveMatch> relationshipPositiveMatch;
    private double relationshipPositiveMatchScore;
    private double relationshipNegativeMatchScore;
    private long relationshipIdentityCount;
}
