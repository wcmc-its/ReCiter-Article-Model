package reciter.model.article;

import lombok.Data;

@Data
public class ReCiterFeedbackScoreJournal  /*extends ReCiterFeedbackScoreArticle*/{

	private String journalTitle;
	private String journalDomain;
	private String journalField;
	private String journalSubField;
	private double feedbackScoreJournal;
	private double feedbackScoreJournalDomain;
	private double feedbackScoreJournalField;
	private double feedbackScoreJournalSubField;
}
	