package reciter.model.typeconverter;

/**
 * Custom DynamoDB converter for mapping the {@link OrganizationalUnitType}
 * enum to a string for persistence in DynamoDB, and back from string to enum
 * when reading.
 *
 * <p>This converter is used in conjunction with the AWS SDK v2 Enhanced Client.</p>
 *  @author ved4006
 */

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import reciter.model.identity.OrganizationalUnit;
import reciter.model.identity.OrganizationalUnit.OrganizationalUnitType;

/**
	OrganizationalUnitTypeConverter class
*/
public class OrganizationalUnitTypeConverter implements AttributeConverter<OrganizationalUnit.OrganizationalUnitType> {

	 /**
     * Converts the {@link OrganizationalUnitType} enum value into a string-based {@link AttributeValue}
     * for storage in DynamoDB.
     *
     * @param input the OrganizationalUnitType enum instance
     * @return the corresponding DynamoDB AttributeValue with string representation
     */
	@Override
	public AttributeValue transformFrom(OrganizationalUnitType input) {
		 return AttributeValue.builder().s(input.name()).build();
	}

	 /**
     * Converts a DynamoDB string {@link AttributeValue} back into a {@link OrganizationalUnitType} enum value.
     *
     * @param input the string AttributeValue from DynamoDB
     * @return the corresponding enum constant
     * @throws IllegalArgumentException if the value does not match any enum constant
     */
	@Override
	public OrganizationalUnitType transformTo(AttributeValue input) {
		 return OrganizationalUnitType.valueOf(input.s());
	}

	
	/**
     * Specifies the enhanced Java type handled by this converter.
     *
     * @return the {@link EnhancedType} of {@link OrganizationalUnitType}
     */
	@Override
	public EnhancedType<OrganizationalUnitType> type() {
		return EnhancedType.of(OrganizationalUnitType.class);
	}

	
	 /**
     * Specifies that the underlying DynamoDB type is a string.
     *
     * @return {@link AttributeValueType#S}
     */
	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}


}
