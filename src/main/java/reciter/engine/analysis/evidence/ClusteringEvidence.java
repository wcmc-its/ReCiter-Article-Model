package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to various types of article clustering.
 * <p>
 * This class stores lists of cluster identifiers grouped by different clustering criteria,
 * such as tepid, email, grants, citation, and MeSH major heading clustering.
 * It also defines the types of clustering available via the {@link ClusteringType} enum.
 * </p>
 * @author ved4006
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
/**
	ClusteringEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class ClusteringEvidence {
	
	 /** List of cluster identifiers for tepid clustering. */
    private List<Long> tepidClustering;

    /** List of cluster identifiers for email clustering. */
    private List<Long> emailClustering;

    /** List of cluster identifiers for grants clustering. */
    private List<Long> grantsClustering;

    /** List of cluster identifiers for cites (citation) clustering. */
    private List<Long> citesClustering;

    /** List of cluster identifiers for MeSH major heading clustering. */
    private List<Long> meshMajorClustering;
    
    /**
     * Types of clustering available for articles.
     */
    public enum ClusteringType {
        /** Tepid type clustering. */
        TEPID,

        /** Cites type Clustering. */
        CITES,

        /**  MeSH major type Clustering. */
        MESHMAJOR,

        /** Email type Clustering. */
        EMAIL,

        /**  grant type Clustering. */
        GRANTS
    }
    
}
