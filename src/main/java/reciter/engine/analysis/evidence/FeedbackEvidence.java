package reciter.engine.analysis.evidence;

/**
 * Represents evidence scores derived from various feedback categories.
 * <p>
 * This class stores feedback scores based on citations, co-author names, emails, institution,
 * journal, journal subfield, keywords, ORCID, ORCID co-authors, organization, target author name,
 * and year. These scores can be used to evaluate or validate different aspects of an author's profile or an article.
 * </p>
 * @author ved4006
 */
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
	FeedbackEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class FeedbackEvidence {
	
	/** Feedback score based on article citations. */
    private Double feedbackScoreCites;

    /** Feedback score based on co-author name matches. */
    private Double feedbackScoreCoAuthorName;

    /** Feedback score based on email matches. */
    private Double feedbackScoreEmail;

    /** Feedback score based on institutional matches. */
    private Double feedbackScoreInstitution;

    /** Feedback score based on the journal. */
    private Double feedbackScoreJournal;

    /** Feedback score based on the subfield of the journal. */
    private Double feedbackScoreJournalSubField;

    /** Feedback score based on keyword matches. */
    private Double feedbackScoreKeyword;

    /** Feedback score based on ORCID. */
    private Double feedbackScoreOrcid;

    /** Feedback score based on ORCID of co-authors. */
    private Double feedbackScoreOrcidCoAuthor;

    /** Feedback score based on organization matches. */
    private Double feedbackScoreOrganization;

    /** Feedback score based on the target author's name. */
    private Double feedbackScoreTargetAuthorName;

    /** Feedback score based on publication year or other year-based feedback. */
    private Double feedbackScoreYear;
}
