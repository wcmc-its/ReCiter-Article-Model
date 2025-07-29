package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to author affiliation .
 * <p>
 * This class encapsulates details about target and non-target author affiliations
 * as found in Scopus and PubMed, as well as enums describing the source and the
 * type of institutional affiliation match.
 * </p>
 * @author ved4006
 */

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
/**
	AffiliationEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class AffiliationEvidence {

	  /**
     * List of Scopus affiliations for the target author.
     */	
	private List<TargetAuthorScopusAffiliation> scopusTargetAuthorAffiliation;
	
	/**
     * PubMed affiliation for the target author.
     */
	private TargetAuthorPubmedAffiliation pubmedTargetAuthorAffiliation;
	
	/**
     * Scopus affiliation for the non-target author.
     */
	private NonTargetAuthorScopusAffiliation scopusNonTargetAuthorAffiliation;
	
	/**
     * Enum representing the source of institutional affiliation.
     */
	public enum InstitutionalAffiliationSource {
		/** Affiliation derived from Scopus. */
		SCOPUS,
		/** Affiliation derived from PubMed. */
		PUBMED
	}
	
	/**
     * Enum representing the type of institutional affiliation match.
     */
	public enum InstitutionalAffiliationMatchType {
		/** Positive match at the individual type. */
		POSITIVE_MATCH_INDIVIDUAL,
		 /** Positive match at the institution type. */
		POSITIVE_MATCH_INSTITUTION,
		 /** Null match (not enough information to determine a match). */
		NULL_MATCH,
		/** No match found. */
		NO_MATCH
	}
}
