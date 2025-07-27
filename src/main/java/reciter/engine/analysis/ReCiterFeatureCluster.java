package reciter.engine.analysis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import reciter.model.article.ReCiterCitedBy;
import reciter.model.article.ReCiterCites;
import reciter.model.article.ReCiterJournalCategory;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * The Class ReCiterFeatureCluster.
 * @author ved4006
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterFeatureCluster {
    
    /** The journal category. */
    private ReCiterJournalCategory journalCategory;
    
    /** The re citer cites. */
    private ReCiterCites reCiterCites;
    
    /** The re citer cited by. */
    private ReCiterCitedBy reCiterCitedBy;
    
    /** The grant identifiers. */
    private List<String> grantIdentifiers;
}
