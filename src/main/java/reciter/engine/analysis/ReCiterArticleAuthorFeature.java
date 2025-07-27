package reciter.engine.analysis;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;


/**
 * Represents an author feature associated with a ReCiter article.
 * @author ved4006
 */
@DynamoDbBean
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReCiterArticleAuthorFeature {
    
    /** The rank. */
    private int rank;
    
    /** The last name. */
    private String lastName;
    
    /** The first name. */
    private String firstName;
    
    /** The initials. */
    private String initials;
    
    /** The affiliations. */
    private ReCiterArticleAffiliationFeature affiliations;
    
    /** The is target author. */
    private boolean isTargetAuthor;
    
    /** The email. */
    private String email;
    
    /** The orcid. */
    private String orcid;
    
    /** The equal contrib. */
    private String equalContrib;
}
