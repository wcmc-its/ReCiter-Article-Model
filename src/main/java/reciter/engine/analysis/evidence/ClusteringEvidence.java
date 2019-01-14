package reciter.engine.analysis.evidence;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDBDocument
public class ClusteringEvidence {
    private List<Long> tepidClustering;
    private List<Long> citesClustering;
    private List<Long> meshMajorClustering;
    private List<Long> emailClustering;
    private List<Long> grantsClustering;
    
	private enum ClusteringType {
		TEPID,
		CITES,
		MESHMAJOR,
		EMAIL,
		GRANTS
	}
    
}
