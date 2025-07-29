package reciter.model.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * The Class ReCiterJournalCategory.
 * @author ved4006
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterJournalCategory {
    
    /** The journal category ID. */
    private int journalCategoryID;
    
    /** The journal category label. */
    private String journalCategoryLabel;
}
