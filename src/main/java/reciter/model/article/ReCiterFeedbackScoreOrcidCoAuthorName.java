package reciter.model.article;

import lombok.Data;

@Data
public class ReCiterFeedbackScoreOrcidCoAuthorName  /*extends ReCiterFeedbackScoreArticle*/{

	private String coAuthorOrcid;
	private double feedbackScoreCoAuthorOrcid;
	private double sumAccepted;
	private double sumRejected;
}
