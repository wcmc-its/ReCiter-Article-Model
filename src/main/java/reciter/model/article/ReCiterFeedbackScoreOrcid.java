package reciter.model.article;

import lombok.Data;

@Data
public class ReCiterFeedbackScoreOrcid {

	private String uid;
	private long articleId;
	private int countAccepted;
	private int countRejected;
	private int countNull;
	private double scoreAll;
	private double scoreWithout1Accepted;
	private double scoreWithout1Rejected;
	private int goldStandard;
	private String orcid;
	
}
