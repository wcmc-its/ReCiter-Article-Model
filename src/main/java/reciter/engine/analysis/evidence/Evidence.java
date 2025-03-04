package reciter.engine.analysis.evidence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class Evidence {
	private AcceptedRejectedEvidence acceptedRejectedEvidence;
	private AuthorNameEvidence authorNameEvidence;
	private EmailEvidence emailEvidence;
	private List<OrganizationalUnitEvidence> organizationalUnitEvidence;
	private JournalCategoryEvidence journalCategoryEvidence;
	private AffiliationEvidence affiliationEvidence; 
	private RelationshipEvidence relationshipEvidence;
    private GrantEvidence grantEvidence;
    private EducationYearEvidence educationYearEvidence;
    private PersonTypeEvidence personTypeEvidence;
    private GenderEvidence genderEvidence;
    private ArticleCountEvidence articleCountEvidence;
    private AverageClusteringEvidence averageClusteringEvidence;
    private ClusteringEvidence clusteringEvidence;
    private FeedbackEvidence feedbackEvidence;
    private AuthorCountEvidence authorCountEvidence;
    private long targetAuthorCount;
    private double targetAuthorCountPenalty; 
}
