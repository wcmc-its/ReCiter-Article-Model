package reciter.model.article;

import org.json.JSONObject;

import lombok.Getter;

@Getter
public class ReCiterArticleFeedbackIdentityScore {

	private long   articleId;
	private double feedbackScoreCites;
	private double feedbackScoreCoAuthorName;
	private double feedbackScoreEmail;
	private double feedbackScoreInstitution;
	private double feedbackScoreJournal;
	private double feedbackScoreJournalSubField;
	private double feedbackScoreKeyword;
	private double feedbackScoreOrcid;
	private double feedbackScoreOrcidCoAuthor;
	private double feedbackScoreOrganization;
	private double feedbackScoreTargetAuthorName;
	private double feedbackScoreYear;
	private double articleCountScore;
	private double discrepancyDegreeYearScore;
	private double emailMatchScore;
	private double genderScoreIdentityArticleDiscrepancy;
	private double grantMatchScore;
	private double journalSubfieldScore;
	private double nameMatchFirstScore;
	private double nameMatchLastScore;
	private double nameMatchMiddleScore;
	private double nameMatchModifierScore;
	private double organizationalUnitMatchingScore;
	private double relationshipEvidenceTotalScore;
	private double relationshipNonMatchScore;
	private double scopusNonTargetAuthorInstitutionalAffiliationScore;
	private double targetAuthorInstitutionalAffiliationMatchTypeScore;
	private double pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore;
	private int countAccepted;
	private int countRejected;
	private String userAssertion;
	public ReCiterArticleFeedbackIdentityScore() {
		super();
	}
			
	
	public ReCiterArticleFeedbackIdentityScore(long articleId, double articleCountScore,
			double discrepancyDegreeYearScore, double emailMatchScore, double genderScoreIdentityArticleDiscrepancy,
			double grantMatchScore, double journalSubfieldScore, double nameMatchFirstScore, double nameMatchLastScore,
			double nameMatchMiddleScore, double nameMatchModifierScore, double organizationalUnitMatchingScore,
			double relationshipEvidenceTotalScore, double relationshipNonMatchScore,
			double scopusNonTargetAuthorInstitutionalAffiliationScore,
			double targetAuthorInstitutionalAffiliationMatchTypeScore,
			double pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore, String userAssertion) {
		  	
			this.articleId = articleId;
			this.articleCountScore = articleCountScore;
	        this.discrepancyDegreeYearScore = discrepancyDegreeYearScore;
	        this.emailMatchScore = emailMatchScore;
	        this.genderScoreIdentityArticleDiscrepancy = genderScoreIdentityArticleDiscrepancy;
	        this.grantMatchScore = grantMatchScore;
	        this.journalSubfieldScore = journalSubfieldScore;
	        this.nameMatchFirstScore = nameMatchFirstScore;
	        this.nameMatchLastScore = nameMatchLastScore;
	        this.nameMatchMiddleScore = nameMatchMiddleScore;
	        this.nameMatchModifierScore = nameMatchModifierScore;
	        this.organizationalUnitMatchingScore = organizationalUnitMatchingScore;
	        this.relationshipEvidenceTotalScore = relationshipEvidenceTotalScore;
	        this.relationshipNonMatchScore = relationshipNonMatchScore;
	        this.scopusNonTargetAuthorInstitutionalAffiliationScore = scopusNonTargetAuthorInstitutionalAffiliationScore;
	        this.targetAuthorInstitutionalAffiliationMatchTypeScore = targetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore = pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.userAssertion = userAssertion;

	}

	public ReCiterArticleFeedbackIdentityScore(long articleId, double feedbackScoreCites,
			double feedbackScoreCoAuthorName, double feedbackScoreEmail, double feedbackScoreInstitution,
			double feedbackScoreJournal, double feedbackScoreJournalSubField, double feedbackScoreKeyword,
			double feedbackScoreOrcid, double feedbackScoreOrcidCoAuthor, double feedbackScoreOrganization,
			double feedbackScoreTargetAuthorName, double feedbackScoreYear, double articleCountScore,
			double discrepancyDegreeYearScore, double emailMatchScore, double genderScoreIdentityArticleDiscrepancy,
			double grantMatchScore, double journalSubfieldScore, double nameMatchFirstScore, double nameMatchLastScore,
			double nameMatchMiddleScore, double nameMatchModifierScore, double organizationalUnitMatchingScore,
			double relationshipEvidenceTotalScore, double relationshipNonMatchScore,
			double scopusNonTargetAuthorInstitutionalAffiliationScore,
			double targetAuthorInstitutionalAffiliationMatchTypeScore,
			double pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore, int countAccepted, int countRejected,
			String userAssertion) {
		
		 this.articleId = articleId;
	        this.feedbackScoreCites = feedbackScoreCites;
	        this.feedbackScoreCoAuthorName = feedbackScoreCoAuthorName;
	        this.feedbackScoreEmail = feedbackScoreEmail;
	        this.feedbackScoreInstitution = feedbackScoreInstitution;
	        this.feedbackScoreJournal = feedbackScoreJournal;
	        this.feedbackScoreJournalSubField = feedbackScoreJournalSubField;
	        this.feedbackScoreKeyword = feedbackScoreKeyword;
	        this.feedbackScoreOrcid = feedbackScoreOrcid;
	        this.feedbackScoreOrcidCoAuthor = feedbackScoreOrcidCoAuthor;
	        this.feedbackScoreOrganization = feedbackScoreOrganization;
	        this.feedbackScoreTargetAuthorName = feedbackScoreTargetAuthorName;
	        this.feedbackScoreYear = feedbackScoreYear;
	        this.articleCountScore = articleCountScore;
	        this.discrepancyDegreeYearScore = discrepancyDegreeYearScore;
	        this.emailMatchScore = emailMatchScore;
	        this.genderScoreIdentityArticleDiscrepancy = genderScoreIdentityArticleDiscrepancy;
	        this.grantMatchScore = grantMatchScore;
	        this.journalSubfieldScore = journalSubfieldScore;
	        this.nameMatchFirstScore = nameMatchFirstScore;
	        this.nameMatchLastScore = nameMatchLastScore;
	        this.nameMatchMiddleScore = nameMatchMiddleScore;
	        this.nameMatchModifierScore = nameMatchModifierScore;
	        this.organizationalUnitMatchingScore = organizationalUnitMatchingScore;
	        this.relationshipEvidenceTotalScore = relationshipEvidenceTotalScore;
	        this.relationshipNonMatchScore = relationshipNonMatchScore;
	        this.scopusNonTargetAuthorInstitutionalAffiliationScore = scopusNonTargetAuthorInstitutionalAffiliationScore;
	        this.targetAuthorInstitutionalAffiliationMatchTypeScore = targetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore = pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.countAccepted = countAccepted;
	        this.countRejected = countRejected;
	        this.userAssertion = userAssertion;
	}
	
}
