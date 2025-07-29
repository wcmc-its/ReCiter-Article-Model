package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to the count of articles retrieved and the associated score.
 * <p>
 * This class stores the total number of articles retrieved and a score that may
 * represent the quality, relevance, or another metric related to the article count.
 * </p>
 * @author ved4006
 */
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
	ArticleCountEvidence to hold the count articles retrieved and count score. 
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean	
public class ArticleCountEvidence {
	/** The number of articles retrieved. */
	private double countArticlesRetrieved;
	
	/** The score associated with the article count. */
	private double articleCountScore;
}
