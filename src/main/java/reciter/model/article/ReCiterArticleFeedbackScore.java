package reciter.model.article;
/**
 * Represents feedback score details for a ReCiter article.
 * <p>
 * This class stores various counts, scores, and metadata associated with feedback for an article,
 * including accepted/rejected counts, different score calculations, article ID, feedback value,
 * and feedback type information.
 * </p>
 * @author ved4006
 */
import lombok.Data;

@Data
public class ReCiterArticleFeedbackScore {

    /** The number of times the article was accepted. */
    private int acceptedCount;

    /** The number of times the article was rejected. */
    private int rejectedCount;

    /** The number of null. */
    private int countNull;

    /** The overall feedback score for the article. */
    private double scoreAll;

    /** The feedback score calculated without one accepted instance. */
    private double scoreWithout1Accepted;

    /** The feedback score calculated without one rejected instance. */
    private double scoreWithout1Rejected;

    /** The unique identifier (PMID) for the article. */
    private long articleId;

    /** The value of the feedback score field. */
    private String feedbackScoreFieldValue;

    /** The final or computed feedback score for the article. */
    private double feedbackScore;

    /** The gold standard label for this article (e.g., 1 for accepted, -1 for rejected, 0 for null). */
    private int goldStandard;

    /** The exported feedback score in string format, possibly for external use. */
    private String exportedFeedbackScore;

    /** The type/category of feedback score. */
    private String feedbackScoreType;
}

