package reciter.engine.analysis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import reciter.model.article.ReCiterCitedBy;
import reciter.model.article.ReCiterCites;
import reciter.model.article.ReCiterJournalCategory;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterFeatureCluster {
    private ReCiterJournalCategory journalCategory;
    private ReCiterCites reCiterCites;
    private ReCiterCitedBy reCiterCitedBy;
    private List<String> grantIdentifiers;
}
