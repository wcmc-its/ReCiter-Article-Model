package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationMatchType;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import reciter.model.typeconverter.InstitutionalAffiliationMatchTypeConverter;
import reciter.model.typeconverter.InstitutionalAffiliationSourceTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class TargetAuthorScopusAffiliation {
	
	private InstitutionalAffiliationSource targetAuthorInstitutionalAffiliationSource;
	private String targetAuthorInstitutionalAffiliationIdentity;
	private String targetAuthorInstitutionalAffiliationArticleScopusLabel;
	private int targetAuthorInstitutionalAffiliationArticleScopusAffiliationId;
	private InstitutionalAffiliationMatchType targetAuthorInstitutionalAffiliationMatchType;
	private double targetAuthorInstitutionalAffiliationMatchTypeScore;
	
	@DynamoDbConvertedBy(InstitutionalAffiliationSourceTypeConverter.class)
	public InstitutionalAffiliationSource getTargetAuthorInstitutionalAffiliationSource() {
		return targetAuthorInstitutionalAffiliationSource;
	}
	@DynamoDbConvertedBy(InstitutionalAffiliationMatchTypeConverter.class)
	public InstitutionalAffiliationMatchType getTargetAuthorInstitutionalAffiliationMatchType() {
		return targetAuthorInstitutionalAffiliationMatchType;
	}
}
