package reciter.model.typeconverter;

import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationMatchType;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class InstitutionalAffiliationMatchTypeConverter implements AttributeConverter<AffiliationEvidence.InstitutionalAffiliationMatchType> {

	@Override
	public AttributeValue transformFrom(AffiliationEvidence.InstitutionalAffiliationMatchType input) {
		return AttributeValue.builder().s(input.name()).build();
	}

	@Override
	public AffiliationEvidence.InstitutionalAffiliationMatchType transformTo(AttributeValue input) {
		return AffiliationEvidence.InstitutionalAffiliationMatchType.valueOf(input.s());
	}

	@Override
	public EnhancedType<InstitutionalAffiliationMatchType> type() {
		return EnhancedType.of(AffiliationEvidence.InstitutionalAffiliationMatchType.class);
	}

	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}

}
