package reciter.engine.analysis.evidence;

/**
 * Represents comprehensive evidence data for author and article evaluation.
 * <p>
 * This class aggregates various types of evidence, including author name matching,
 * email, affiliation, organizational unit, journal category, relationships,
 * grants, education years, person type, gender, article and author counts,
 * clustering, feedback, and penalties related to target author count.
 * </p>
 * @author ved4006
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
/**
	Evidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class Evidence {
	
	/** Evidence of accepted and rejected feedback. */
    private AcceptedRejectedEvidence acceptedRejectedEvidence;

    /** Evidence related to author name matching. */
    private AuthorNameEvidence authorNameEvidence;

    /** Evidence related to email matching. */
    private EmailEvidence emailEvidence;

    /** Evidence for organizational unit associations. */
    private List<OrganizationalUnitEvidence> organizationalUnitEvidence;

    /** Evidence related to the journal category. */
    private JournalCategoryEvidence journalCategoryEvidence;

    /** Evidence related to institutional affiliation. */
    private AffiliationEvidence affiliationEvidence;

    /** Evidence about author relationships. */
    private RelationshipEvidence relationshipEvidence;

    /** Evidence related to grant information. */
    private GrantEvidence grantEvidence;

    /** Evidence related to education years. */
    private EducationYearEvidence educationYearEvidence;

    /** Evidence about the type of person (e.g., academic-faculty-weillfulltime, student-md-new-york). */
    private PersonTypeEvidence personTypeEvidence;

    /** Evidence related to gender. */
    private GenderEvidence genderEvidence;

    /** Evidence about the number of articles retrieved and associated scores. */
    private ArticleCountEvidence articleCountEvidence;

    /** Evidence from clustering analysis (averages and metrics). */
    private AverageClusteringEvidence averageClusteringEvidence;

    /** Evidence regarding various clustering types and identifiers. */
    private ClusteringEvidence clusteringEvidence;

    /** Evidence from feedback data. */
    private FeedbackEvidence feedbackEvidence;

    /** Evidence about the number of authors and associated scores. */
    private AuthorCountEvidence authorCountEvidence;

    /** The number of target authors. */
    private long targetAuthorCount;

    /** Penalty applied based on target author count. */
    private double targetAuthorCountPenalty;
}
