package reciter.engine.analysis;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;


@DynamoDbBean
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReCiterArticleAuthorFeature {
    private int rank;
    private String lastName;
    private String firstName;
    private String initials;
    private ReCiterArticleAffiliationFeature affiliations;
    private boolean isTargetAuthor;
    private String email;
    private String orcid;
    private String equalContrib;
}
