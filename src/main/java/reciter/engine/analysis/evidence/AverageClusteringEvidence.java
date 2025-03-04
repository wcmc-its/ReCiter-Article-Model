package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class AverageClusteringEvidence {
	private double totalArticleScoreWithoutClustering;
	private double clusterScoreAverage;
	private double clusterReliabilityScore;
	private double clusterScoreModificationOfTotalScore;
	private long clusterIdentifier; 
}
