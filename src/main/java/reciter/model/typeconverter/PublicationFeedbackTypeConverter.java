package reciter.model.typeconverter;

/**
 * A custom DynamoDB attribute converter for the {@link PublicationFeedback} enum
 * used in {@link ReCiterArticleFeature}.
 *
 * <p>This converter serializes and deserializes enum values as strings
 * for compatibility with AWS DynamoDB's
 *  @author ved4006
 */
import reciter.engine.analysis.ReCiterArticleFeature;
import reciter.engine.analysis.ReCiterArticleFeature.PublicationFeedback;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
	PublicationFeedbackTypeConverter class
*/
public class PublicationFeedbackTypeConverter implements AttributeConverter<ReCiterArticleFeature.PublicationFeedback>{

                
	    /**
    	 * Transform from.
    	 *
    	 * @param input the input
    	 * @return the attribute value
    	 */
    	@Override
	    public AttributeValue transformFrom(ReCiterArticleFeature.PublicationFeedback input) {
	        return AttributeValue.builder().s(input.name()).build();
	    }

	    /**
    	 * Transform to.
    	 *
    	 * @param input the input
    	 * @return the re citer article feature. publication feedback
    	 */
    	@Override
	    public ReCiterArticleFeature.PublicationFeedback transformTo(AttributeValue input) {
	        return ReCiterArticleFeature.PublicationFeedback.valueOf(input.s());
	    }

		/**
		 * Type.
		 *
		 * @return the enhanced type
		 */
		@Override
		public EnhancedType<PublicationFeedback> type() {
			return EnhancedType.of(ReCiterArticleFeature.PublicationFeedback.class);
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
