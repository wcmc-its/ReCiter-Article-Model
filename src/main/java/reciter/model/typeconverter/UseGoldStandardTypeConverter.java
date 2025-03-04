package reciter.model.typeconverter;

import reciter.api.parameters.UseGoldStandard;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class UseGoldStandardTypeConverter implements AttributeConverter<UseGoldStandard> {

	@Override
	public AttributeValue transformFrom(UseGoldStandard input) {
		return AttributeValue.builder().s(input.name()).build();
	}

	@Override
	public UseGoldStandard transformTo(AttributeValue input) {
		return UseGoldStandard.valueOf(input.s());
	}

	@Override
	public EnhancedType<UseGoldStandard> type() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeValueType attributeValueType() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
