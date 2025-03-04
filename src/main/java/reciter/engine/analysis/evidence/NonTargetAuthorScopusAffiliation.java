package reciter.engine.analysis.evidence;

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
	
	private InstitutionalAffiliationSource nonTargetAuthorInstitutionalAffiliationSource;
	private List<String> nonTargetAuthorInstitutionalAffiliationMatchKnownInstitution;
	private List<String> nonTargetAuthorInstitutionalAffiliationMatchCollaboratingInstitution; 
	private double nonTargetAuthorInstitutionalAffiliationScore;
	
	@DynamoDbConvertedBy(InstitutionalAffiliationSourceTypeConverter.class)
	public List<String> getNonTargetAuthorInstitutionalAffiliationMatchCollaboratingInstitution() {
		return nonTargetAuthorInstitutionalAffiliationMatchCollaboratingInstitution;
	}
}
