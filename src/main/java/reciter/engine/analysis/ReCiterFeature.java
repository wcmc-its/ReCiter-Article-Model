package reciter.engine.analysis;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.api.parameters.UseGoldStandard;
import reciter.model.typeconverter.UseGoldStandardTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterFeature {
    private String personIdentifier;
    private Instant  dateAdded;
    private Instant  dateUpdated;
    private UseGoldStandard mode;
    private Double overallAccuracy;
    private Double precision;
    private Double recall;
    private List<Long> inGoldStandardButNotRetrieved;
    private int countSuggestedArticles;
    private long countPendingArticles;
    private List<ReCiterArticleFeature.ArticleKeyword> articleKeywordsAcceptedArticles;
    private List<ReCiterArticleFeature> reCiterArticleFeatures;
    
    @DynamoDbConvertedBy(UseGoldStandardTypeConverter.class)
	public UseGoldStandard getMode() {
		return mode;
	}
    
}
