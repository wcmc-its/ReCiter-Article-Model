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
import reciter.model.typeconverter.InstitutionalAffiliationSourceConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

/**
	NonTargetAuthorScopusAffiliation class
*/
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
	 * Retrieves the institutional affiliation source associated with non-target authors.
	 * {@link InstitutionalAffiliationSource} The institutional affiliation source of the 
	 *         non-target author. This object contains information about the author's institution(s),
	 *         which could be relevant in various contexts, such as collaborative research.
	 */
	@DynamoDbConvertedBy(InstitutionalAffiliationSourceConverter.class)
	public InstitutionalAffiliationSource getNonTargetAuthorInstitutionalAffiliationSource() {
		return nonTargetAuthorInstitutionalAffiliationSource;
	}
}
