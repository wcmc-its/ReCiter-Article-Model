package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class FeedbackEvidence {
	
	private Double feedbackScoreCites;
	private Double feedbackScoreCoAuthorName;
	private Double feedbackScoreEmail;
	private Double feedbackScoreInstitution;
	private Double feedbackScoreJournal;
	private Double feedbackScoreJournalSubField;
	private Double feedbackScoreKeyword;
	private Double feedbackScoreOrcid;
	private Double feedbackScoreOrcidCoAuthor;
	private Double feedbackScoreOrganization;
	private Double feedbackScoreTargetAuthorName;
	private Double feedbackScoreYear;
}
