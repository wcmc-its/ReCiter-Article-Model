package reciter.model.typeconverter;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import reciter.model.identity.OrganizationalUnit;
import reciter.model.identity.OrganizationalUnit.OrganizationalUnitType;

public class OrganizationalUnitTypeConverter implements AttributeConverter<OrganizationalUnit.OrganizationalUnitType> {

	@Override
	public AttributeValue transformFrom(OrganizationalUnitType input) {
		 return AttributeValue.builder().s(input.name()).build();
	}

	@Override
	public OrganizationalUnitType transformTo(AttributeValue input) {
		 return OrganizationalUnitType.valueOf(input.s());
	}

	@Override
	public EnhancedType<OrganizationalUnitType> type() {
		return EnhancedType.of(OrganizationalUnitType.class);
	}

	@Override
	public AttributeValueType attributeValueType() {
		// TODO Auto-generated method stub
		 return AttributeValueType.S;
	}


}
