package reciter.engine.analysis.evidence;

import lombok.Data;
import lombok.ToString;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDBDocument
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
}
