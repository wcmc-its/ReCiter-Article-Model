package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to clustering analysis of articles.
 * <p>
 * This class contains various metrics associated with clustering, such as 
 * the total score without clustering, average cluster score, reliability score,
 * score modification due to clustering, and the cluster identifier.
 * </p>
 * @author ved4006
 */
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
/**
	AverageClusteringEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class AverageClusteringEvidence {
	
	/** The total article score calculated without applying clustering. */
    private double totalArticleScoreWithoutClustering;

    /** The average score for the cluster. */
    private double clusterScoreAverage;

    /** The reliability score of the cluster. */
    private double clusterReliabilityScore;

    /** The modification applied to the total score due to clustering. */
    private double clusterScoreModificationOfTotalScore;

    /** The identifier for the cluster. */
    private long clusterIdentifier;
}
