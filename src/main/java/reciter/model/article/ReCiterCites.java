package reciter.model.article;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * This class holds all the list of articles that the article cites
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterCites {
    /**
     * List of article identifiers
     */
    private List<Long> articleIdentifiers;
    /**
     * Article type
     */
    private String type;

}
