package reciter.model.typeconverter;

/**
 * A custom DynamoDB attribute converter for the {@link UseGoldStandard} enum.
 * <p>
 * This converter serializes the {@link UseGoldStandard} enum as a string and
 * deserializes it back from the string format. This is useful when storing enum values
 * as string attributes in AWS DynamoDB using the Enhanced Client.
 * </p>
 * @author ved4006
 */
import reciter.api.parameters.UseGoldStandard;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
	UseGoldStandardTypeConverter class
*/
public class UseGoldStandardTypeConverter implements AttributeConverter<UseGoldStandard> {

	/**
	 * Transform from.
	 *
	 * @param input the input
	 * @return the attribute value
	 */
	@Override
	public AttributeValue transformFrom(UseGoldStandard input) {
		return AttributeValue.builder().s(input.name()).build();
	}

	/**
	 * Transform to.
	 *
	 * @param input the input
	 * @return the use gold standard
	 */
	@Override
	public UseGoldStandard transformTo(AttributeValue input) {
		return UseGoldStandard.valueOf(input.s());
	}

	/**
	 * Type.
	 *
	 * @return the enhanced type
	 */
	@Override
	public EnhancedType<UseGoldStandard> type() {
		 return EnhancedType.of(UseGoldStandard.class);
	}

	/**
	 * Attribute value type.
	 *
	 * @return the attribute value type
	 */
	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}

	

}
