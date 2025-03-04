package reciter.model.typeconverter;

import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class InstitutionalAffiliationSourceTypeConverter implements AttributeConverter<AffiliationEvidence.InstitutionalAffiliationSource> {

	@Override
	public AttributeValue transformFrom(AffiliationEvidence.InstitutionalAffiliationSource input) {
		return AttributeValue.builder().s(input.name()).build();
	}

	@Override
	public AffiliationEvidence.InstitutionalAffiliationSource transformTo(AttributeValue input) {
		return AffiliationEvidence.InstitutionalAffiliationSource.valueOf(input.s());
	}

	@Override
	public EnhancedType<InstitutionalAffiliationSource> type() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeValueType attributeValueType() {
		// TODO Auto-generated method stub
		return null;
	}

}
