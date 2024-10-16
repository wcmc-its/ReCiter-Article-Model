package reciter.engine.analysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.api.parameters.UseGoldStandard;

import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDBDocument
public class ReCiterFeature {
    private String personIdentifier;
    private Date dateAdded;
    private Date dateUpdated;
    @DynamoDBTyped(DynamoDBAttributeType.S)
    private UseGoldStandard mode;
    private Double overallAccuracy;
    private Double precision;
    private Double recall;
    private List<Long> inGoldStandardButNotRetrieved;
    private int countSuggestedArticles;
    private long countPendingArticles;
    private List<ReCiterArticleFeature.ArticleKeyword> articleKeywordsAcceptedArticles;
    private List<ReCiterArticleFeature> reCiterArticleFeatures;
}
