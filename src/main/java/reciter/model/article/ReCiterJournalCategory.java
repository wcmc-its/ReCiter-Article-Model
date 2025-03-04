package reciter.model.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterJournalCategory {
    private int journalCategoryID;
    private String journalCategoryLabel;
}
