package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.model.identity.AuthorName;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class AuthorNameEvidence {
    private AuthorName institutionalAuthorName;
    private AuthorName articleAuthorName;
    private double nameScoreTotal;
    private String nameMatchFirstType;
    private double nameMatchFirstScore;
    private String nameMatchMiddleType;
    private double nameMatchMiddleScore;
    private String nameMatchLastType;
    private double nameMatchLastScore;
    private String nameMatchModifier;
    private double nameMatchModifierScore;
}
