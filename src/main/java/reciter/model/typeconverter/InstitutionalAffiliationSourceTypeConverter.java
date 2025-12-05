package reciter.model.typeconverter;

import java.util.Optional;

/**
 * A custom DynamoDB converter for mapping between the
 * {@link AffiliationEvidence.InstitutionalAffiliationSource} enum and a string attribute in DynamoDB.
 *
 * <p>This converter allows the enum to be stored as a string in DynamoDB, enabling easy readability
 * and retrieval when used with the AWS SDK v2 Enhanced DynamoDB Client.</p>
 * @author ved4006
 */
import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
	InstitutionalAffiliationSourceTypeConverter class
*/
public class InstitutionalAffiliationSourceTypeConverter implements AttributeConverter<AffiliationEvidence.InstitutionalAffiliationSource> {

	
	 /**
     * Converts an {@link InstitutionalAffiliationSource} enum into a DynamoDB {@link AttributeValue}.
     *
     * @param input the enum value to be converted.
     * @return the string representation of the enum wrapped in an AttributeValue.
     */
	@Override
	public AttributeValue transformFrom(AffiliationEvidence.InstitutionalAffiliationSource input) {
		return AttributeValue.builder().s(input.name()).build();
	}

	/**
     * Converts a string {@link AttributeValue} from DynamoDB into an {@link InstitutionalAffiliationSource} enum.
     *
     * @param input the attribute value containing the enum name as a string.
     * @return the corresponding enum constant.
     * @throws IllegalArgumentException if the value does not match any enum constant.
     */
	@Override
	public AffiliationEvidence.InstitutionalAffiliationSource transformTo(AttributeValue input) {
		return Optional.ofNullable(input.s())
        .map(InstitutionalAffiliationSource::valueOf)
        .orElse(null);
	}

	/**
    * Specifies the enhanced Java type handled by this converter.
    *
    * @return the {@link EnhancedType} of {@link InstitutionalAffiliationSource}.
    */
	@Override
	public EnhancedType<InstitutionalAffiliationSource> type() {
		 return EnhancedType.of(AffiliationEvidence.InstitutionalAffiliationSource.class);
	}

	
	/**
     * Specifies the DynamoDB attribute type used to store the value.
     *
     * @return {@link AttributeValueType#S} indicating a String.
     */
	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}

}
