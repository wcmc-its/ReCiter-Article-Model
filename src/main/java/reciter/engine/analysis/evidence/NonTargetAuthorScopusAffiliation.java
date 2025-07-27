package reciter.engine.analysis.evidence;

/**
 * Represents the Scopus affiliation information for a non-target author.
 * <p>
 * This class stores the institutional affiliation source, matches with known institutions,
 * matches with collaborating institutions, and an overall affiliation score for non-target authors.
 * </p>
 * @author ved4006
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import reciter.model.typeconverter.InstitutionalAffiliationSourceTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class NonTargetAuthorScopusAffiliation {
	
	/** The source of the institutional affiliation for the non-target author. */
	private InstitutionalAffiliationSource nonTargetAuthorInstitutionalAffiliationSource;
	
	/** List of non-target author institutional affiliations matching known institutions. */
	private List<String> nonTargetAuthorInstitutionalAffiliationMatchKnownInstitution;
	
	/** List of non-target author institutional affiliations matching collaborating institutions. */
	private List<String> nonTargetAuthorInstitutionalAffiliationMatchCollaboratingInstitution; 
	
	/** The score representing the quality of the non-target author's institutional affiliation. */
	private double nonTargetAuthorInstitutionalAffiliationScore;
	
	/**
     * Gets the list of non-target author institutional affiliations that match collaborating institutions.
     * <p>
     * This method is annotated for DynamoDB conversion.
     * </p>
     * @return List of institutional affiliations matching collaborating institutions.
     */
	@DynamoDbConvertedBy(InstitutionalAffiliationSourceTypeConverter.class)
	public List<String> getNonTargetAuthorInstitutionalAffiliationMatchCollaboratingInstitution() {
		return nonTargetAuthorInstitutionalAffiliationMatchCollaboratingInstitution;
	}
}
