package reciter.model.typeconverter;

/**
* A custom converter for DynamoDB to convert between the enum
* {@link AffiliationEvidence.InstitutionalAffiliationMatchType} and
* its string representation in the database.
*
* <p>This allows storing the enum values as strings in DynamoDB,
* and retrieving them back as enum values during deserialization.</p>
* @author ved4006
*/
import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationMatchType;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class InstitutionalAffiliationMatchTypeConverter implements AttributeConverter<AffiliationEvidence.InstitutionalAffiliationMatchType> {

	 /**
     * Converts the enum value to a DynamoDB {@link AttributeValue} as a string.
     *
     * @param input the enum value to convert.
     * @return an AttributeValue containing the name of the enum as a string.
     */
	@Override
	public AttributeValue transformFrom(AffiliationEvidence.InstitutionalAffiliationMatchType input) {
		return AttributeValue.builder().s(input.name()).build();
	}
	
	/**
     * Converts a DynamoDB {@link AttributeValue} string back into the enum value.
     *
     * @param input the AttributeValue containing the string.
     * @return the corresponding enum value.
     * @throws IllegalArgumentException if the string does not match an enum constant.
     */
	@Override
	public AffiliationEvidence.InstitutionalAffiliationMatchType transformTo(AttributeValue input) {
		return AffiliationEvidence.InstitutionalAffiliationMatchType.valueOf(input.s());
	}

	/**
     * Returns the enhanced type of the enum.
     *
     * @return the {@link EnhancedType} of the enum.
     */
	@Override
	public EnhancedType<InstitutionalAffiliationMatchType> type() {
		return EnhancedType.of(AffiliationEvidence.InstitutionalAffiliationMatchType.class);
	}

	 /**
     * Specifies that the value is stored as a DynamoDB String attribute.
     *
     * @return {@link AttributeValueType#S}.
     */
	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}

}
