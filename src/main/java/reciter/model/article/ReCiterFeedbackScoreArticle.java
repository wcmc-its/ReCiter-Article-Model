package reciter.model.article;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReCiterFeedbackScoreArticle {

	//private String personIdentifier;
	private int acceptedCount;
	private int rejectedCount;
	private int countNull;
	private double scoreAll;
	private long citedPmid;
	private List<String> coAuthorNameList;
	private String email;
	private String institution;
	private String journalTitle;
	private String journalDomain;
	private String journalField;
	private String journalSubField;
	private String keyword;
	private String orcid;
	private String coAuthorOrcid;
	private double sumAccepted;
	private double sumRejected;
	private String organization;
	private long articleYear;
	
	
	
   //Feedback countAccepted scoring
	private double countAccepted;
	//Feedback countRejected scoring
	private double countRejected;
	//Feedback countScoreAll scoring
	private double countScoreAll;
	//Feedback scoreWithout1Accepted scoring
	private double scoreWithout1Accepted;
	//Feedback ScoreWithout1Rejected scoring
	private double scoreWithout1Rejected;
			
	//Feedback journal level scoring
	private double feedbackScoreJournal;
	//Feedback Orcid level scoring
	private double feedbackScoreOrcid;
	//Feedback Year level scoring
	private double feedbackScoreYear;
	//Feedback Email level scoring
	private double feedbackScoreEmail;
	//Feedback Journal Domain level scoring
	private double feedbackScoreJournalDomain;
	//Feedback Journal Field level scoring
	private double feedbackScoreJournalField;
	//Feedback Journal Sub Field level scoring
	private double feedbackScoreJournalSubField;
	//Feedback Keyword level scoring
    private double feedbackScoreKeyword;
    //Feedback TargetAuthorName level scoring
    private double feedbackScoreTargetAuthorName;
    //Feedback TargetAuthorName level scoring
    private double feedbackScoreInstitution;
    //Feedback TargetAuthorName level scoring
    private double feedbackScoreOrganization;
  //Feedback CoAuthorName level scoring
    private double feedbackScoreCoAuthorName;
  //Feedback OrcidCoAuthorName level scoring
    private double feedbackScoreOrcidCoAuthor;
    //Feedback OrcidCoAuthorName level scoring
    private double feedbackScoreCitedPmid;
  //Feedback feedbackScoreCoAuthorOrcid level scoring
	private double feedbackScoreCoAuthorOrcid;
	//Feedback feedbackScoreCites level scoring
	private double feedbackScoreCites;
	//Feedback articleTargetAuthorName scoring
	private String articleTargetAuthorName;
	
	public ReCiterFeedbackScoreArticle()
	{
		coAuthorNameList = new ArrayList<>();
	}
	
	// Setter method for count that prevents direct setting
    public void addToCoAuthorNameList(String coAuthorName) {
        this.coAuthorNameList.add(coAuthorName);
    }

    
}
