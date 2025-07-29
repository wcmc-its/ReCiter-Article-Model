package reciter.model.typeconverter;

/**
 * A custom converter for storing and retrieving {@link KeywordType} enum values
 * as string attributes in AWS DynamoDB using the Enhanced Client (SDK v2).
 *
 * <p>This converter maps {@code ReCiterArticleFeature.ArticleKeyword.KeywordType}
 * enum constants to their string names when saving to DynamoDB and vice versa
 * when reading from DynamoDB.</p>
 * @author ved4006
 */

import reciter.engine.analysis.ReCiterArticleFeature;
import reciter.engine.analysis.ReCiterArticleFeature.ArticleKeyword.KeywordType;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class KeywordTypeConverter implements AttributeConverter<ReCiterArticleFeature.ArticleKeyword.KeywordType> {

	
	 /**
     * Converts a {@link KeywordType} enum constant to a DynamoDB {@link AttributeValue}.
     *
     * @param input the KeywordType enum value.
     * @return a string representation of the enum inside a DynamoDB AttributeValue.
     */
    @Override
    public AttributeValue transformFrom(ReCiterArticleFeature.ArticleKeyword.KeywordType input) {
        return AttributeValue.builder().s(input.name()).build();
    }

    /**
     * Converts a string {@link AttributeValue} from DynamoDB into a {@link KeywordType} enum constant.
     *
     * @param input the string AttributeValue from DynamoDB.
     * @return the corresponding {@link KeywordType} enum constant.
     * @throws IllegalArgumentException if the string does not match any enum value.
     */
    @Override
    public ReCiterArticleFeature.ArticleKeyword.KeywordType transformTo(AttributeValue input) {
        return ReCiterArticleFeature.ArticleKeyword.KeywordType.valueOf(input.s());
    }

    /**
     * Returns the enhanced type handled by this converter.
     *
     * @return the {@link EnhancedType} of {@link KeywordType}.
     */
	@Override
	public EnhancedType<KeywordType> type() {
		 return EnhancedType.of(ReCiterArticleFeature.ArticleKeyword.KeywordType.class);
	}

	/**
     * Specifies the DynamoDB attribute value type, which in this case is a string.
     *
     * @return {@link AttributeValueType#S} to represent a string type in DynamoDB.
     */
	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}
}
