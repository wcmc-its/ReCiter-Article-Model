package reciter.engine.analysis;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDBDocument
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
