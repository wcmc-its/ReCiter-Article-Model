package reciter.engine.analysis.evidence;

import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.model.identity.AuthorName;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDBDocument
public class RelationshipPostiveMatch {
	
	private AuthorName relationshipNameArticle;
    private AuthorName relationshipNameIdentity;
    private Set<String> relationshipType;
    private String relationshipMatchType;
    private double relationshipMatchingScore;
    private double relationshipVerboseMatchModifierScore;
    private double relationshipMatchModifierMentor;
    private double relationshipMatchModifierMentorSeniorAuthor;
    private double relationshipMatchModifierManager;
    private double relationshipMatchModifierManagerSeniorAuthor;
}
