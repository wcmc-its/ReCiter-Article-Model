package reciter.engine.analysis.evidence;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

/**
 * @author szd2013
 * This class contains details about negative matches in relationship strategy(Matches are made against relationship
 * defined in Identity)
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDBDocument
public class RelationshipNegativeMatch {
	
	/**
	 * This has count for non matching non target author for an article
	 */
	private double relationshipNonMatchCount;
	/**
	 * Score for non matching authors
	 */
	private double relationshipNonMatchScore;
	/**
	 * Minimum score for that article if the amount of non matching authors goes way over. This does not jeopardize
	 * the other scores of the article 
	 */
	private double relationshipMinimumTotalScore;
}
