package reciter.engine.analysis.evidence;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDBDocument
public class ClusteringEvidence {
    private List<Long> tepidClustering;
    private List<Long> emailClustering;
    private List<Long> grantsClustering;
    private List<Long> citesClustering;
    private List<Long> meshMajorClustering;
    
	public enum ClusteringType {
		TEPID,
		CITES,
		MESHMAJOR,
		EMAIL,
		GRANTS
	}
    
}
