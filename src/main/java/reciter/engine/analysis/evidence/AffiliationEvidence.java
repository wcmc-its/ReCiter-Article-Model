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
public class AffiliationEvidence {
	
	private List<TargetAuthorScopusAffiliation> scopusTargetAuthorAffiliation;
	private TargetAuthorPubmedAffiliation pubmedTargetAuthorAffiliation;
	private NonTargetAuthorScopusAffiliation scopusNonTargetAuthorAffiliation;
	
	public enum InstitutionalAffiliationSource {
		SCOPUS,
		PUBMED
	}
	
	public enum InstitutionalAffiliationMatchType {
		POSITIVE_MATCH_INDIVIDUAL,
		POSITIVE_MATCH_INSTITUTION,
		NULL_MATCH,
		NO_MATCH
	}
}
