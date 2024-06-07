package reciter.model.article;

import java.util.Date;

import lombok.Data;

@Data
public class ReCiterFeedbackScoreYear {

	private String personIdentifier;
	private long articleId;
	private int countAccepted;
	private int countRejected;
	private int countNull;
	private double scoreAll;
	private double scoreWithout1Accepted;
	private double scoreWithout1Rejected;
	private int goldStandard;
	private long articleYear;
	
}
