package reciter.model.typeconverter;

import reciter.engine.analysis.ReCiterArticleFeature;
import reciter.engine.analysis.ReCiterArticleFeature.ArticleKeyword;
import reciter.engine.analysis.ReCiterArticleFeature.ArticleKeyword.KeywordType;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class KeywordTypeConverter implements AttributeConverter<ReCiterArticleFeature.ArticleKeyword.KeywordType> {

    @Override
    public AttributeValue transformFrom(ReCiterArticleFeature.ArticleKeyword.KeywordType input) {
        return AttributeValue.builder().s(input.name()).build();
    }

    @Override
    public ReCiterArticleFeature.ArticleKeyword.KeywordType transformTo(AttributeValue input) {
        return ReCiterArticleFeature.ArticleKeyword.KeywordType.valueOf(input.s());
    }

	@Override
	public EnhancedType<KeywordType> type() {
		 return EnhancedType.of(ReCiterArticleFeature.ArticleKeyword.KeywordType.class);
	}

	@Override
	public AttributeValueType attributeValueType() {
		 return AttributeValueType.S;
	}
}
