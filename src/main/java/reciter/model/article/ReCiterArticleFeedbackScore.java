package reciter.model.article;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ReCiterArticleFeedbackScore {

	private int acceptedCount;
	private int rejectedCount;
	private int countNull;
	private double scoreAll;
	private double scoreWithout1Accepted;
	private double scoreWithout1Rejected;
	private long articleId;
	private String feedbackScoreFieldValue;
	private double feedbackScore;
	private int goldStandard;
	private String exportedFeedbackScore;
}

