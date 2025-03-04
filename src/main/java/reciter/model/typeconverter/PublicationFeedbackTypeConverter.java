package reciter.model.typeconverter;

import reciter.engine.analysis.ReCiterArticleFeature;
import reciter.engine.analysis.ReCiterArticleFeature.PublicationFeedback;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class PublicationFeedbackTypeConverter implements AttributeConverter<ReCiterArticleFeature.PublicationFeedback>{

	    @Override
	    public AttributeValue transformFrom(ReCiterArticleFeature.PublicationFeedback input) {
	        return AttributeValue.builder().s(input.name()).build();
	    }

	    @Override
	    public ReCiterArticleFeature.PublicationFeedback transformTo(AttributeValue input) {
	        return ReCiterArticleFeature.PublicationFeedback.valueOf(input.s());
	    }

		@Override
		public EnhancedType<PublicationFeedback> type() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public AttributeValueType attributeValueType() {
			// TODO Auto-generated method stub
			return null;
		}
}
