package reciter.model.article;

import lombok.Getter;

/**
 * Represents the identity feedback score details for a ReCiter article.
 *
 * <p>This class encapsulates information about the feedback identity scores
 * given to a particular article within the ReCiter system.</p>
 * @author ved4006
 */
@Getter
public class ReCiterArticleFeedbackIdentityScore {

	/** The article id. */
	private long   articleId;
	
	/** The feedback score cites. */
	private double feedbackScoreCites;
	
	/** The feedback score co author name. */
	private double feedbackScoreCoAuthorName;
	
	/** The feedback score email. */
	private double feedbackScoreEmail;
	
	/** The feedback score institution. */
	private double feedbackScoreInstitution;
	
	/** The feedback score journal. */
	private double feedbackScoreJournal;
	
	/** The feedback score journal sub field. */
	private double feedbackScoreJournalSubField;
	
	/** The feedback score keyword. */
	private double feedbackScoreKeyword;
	
	/** The feedback score orcid. */
	private double feedbackScoreOrcid;
	
	/** The feedback score orcid co author. */
	private double feedbackScoreOrcidCoAuthor;
	
	/** The feedback score organization. */
	private double feedbackScoreOrganization;
	
	/** The feedback score target author name. */
	private double feedbackScoreTargetAuthorName;
	
	/** The feedback score year. */
	private double feedbackScoreYear;
	
	/** The article count score. */
	private double articleCountScore;
	
	/** The author count score. */
	private double authorCountScore;
	
	/** The discrepancy degree year score. */
	private double discrepancyDegreeYearScore;
	
	/** The email match score. */
	private double emailMatchScore;
	
	/** The gender score identity article discrepancy. */
	private double genderScoreIdentityArticleDiscrepancy;
	
	/** The grant match score. */
	private double grantMatchScore;
	
	/** The journal subfield score. */
	private double journalSubfieldScore;
	
	/** The name match first score. */
	private double nameMatchFirstScore;
	
	/** The name match last score. */
	private double nameMatchLastScore;
	
	/** The name match middle score. */
	private double nameMatchMiddleScore;
	
	/** The name match modifier score. */
	private double nameMatchModifierScore;
	
	/** The organizational unit matching score. */
	private double organizationalUnitMatchingScore;
	
	/** The scopus non target author institutional affiliation score. */
	private double scopusNonTargetAuthorInstitutionalAffiliationScore;
	
	/** The target author institutional affiliation match type score. */
	private double targetAuthorInstitutionalAffiliationMatchTypeScore;
	
	/** The pubmed target author institutional affiliation match type score. */
	private double pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore;
	
	/** The relationship positive match score. */
	private double relationshipPositiveMatchScore;
	
	/** The relationship negative match score. */
	private double relationshipNegativeMatchScore;
	
	/** The relationship identity count. */
	private long relationshipIdentityCount;
	
	/** The count accepted. */
	private int countAccepted;
	
	/** The count rejected. */
	private int countRejected;
	
	/** The user assertion. */
	private String userAssertion;
	
    
	/**
	 * Instantiates a new re citer article feedback identity score.
	 */
	public ReCiterArticleFeedbackIdentityScore() {
		super();
	}
			
	
	/**
	 * Instantiates a new re citer article feedback identity score.
	 *
	 * @param articleId the article id
	 * @param articleCountScore the article count score
	 * @param authorCountScore the author count score
	 * @param discrepancyDegreeYearScore the discrepancy degree year score
	 * @param emailMatchScore the email match score
	 * @param genderScoreIdentityArticleDiscrepancy the gender score identity article discrepancy
	 * @param grantMatchScore the grant match score
	 * @param journalSubfieldScore the journal subfield score
	 * @param nameMatchFirstScore the name match first score
	 * @param nameMatchLastScore the name match last score
	 * @param nameMatchMiddleScore the name match middle score
	 * @param nameMatchModifierScore the name match modifier score
	 * @param organizationalUnitMatchingScore the organizational unit matching score
	 * @param relationshipPositiveMatchScore the relationship positive match score
	 * @param relationshipNegativeMatchScore the relationship negative match score
	 * @param relationshipIdentityCount the relationship identity count
	 * @param scopusNonTargetAuthorInstitutionalAffiliationScore the scopus non target author institutional affiliation score
	 * @param targetAuthorInstitutionalAffiliationMatchTypeScore the target author institutional affiliation match type score
	 * @param pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore the pubmed target author institutional affiliation match type score
	 * @param userAssertion the user assertion
	 */
	public ReCiterArticleFeedbackIdentityScore(long articleId, double articleCountScore,double authorCountScore,
			double discrepancyDegreeYearScore, double emailMatchScore, double genderScoreIdentityArticleDiscrepancy,
			double grantMatchScore, double journalSubfieldScore, double nameMatchFirstScore, double nameMatchLastScore,
			double nameMatchMiddleScore, double nameMatchModifierScore, double organizationalUnitMatchingScore,
			double relationshipPositiveMatchScore, double relationshipNegativeMatchScore, long relationshipIdentityCount, 
			double scopusNonTargetAuthorInstitutionalAffiliationScore,
			double targetAuthorInstitutionalAffiliationMatchTypeScore,
			double pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore, String userAssertion) {
		  	
			this.articleId = articleId;
			this.articleCountScore = articleCountScore;
			this.authorCountScore = authorCountScore;
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
	        this.relationshipPositiveMatchScore = relationshipPositiveMatchScore;
	        this.relationshipNegativeMatchScore = relationshipNegativeMatchScore; 
	        this.relationshipIdentityCount = relationshipIdentityCount;
	        this.scopusNonTargetAuthorInstitutionalAffiliationScore = scopusNonTargetAuthorInstitutionalAffiliationScore;
	        this.targetAuthorInstitutionalAffiliationMatchTypeScore = targetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore = pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.userAssertion = userAssertion;

	}

	/**
	 * Instantiates a new re citer article feedback identity score.
	 *
	 * @param articleId the article id
	 * @param feedbackScoreCites the feedback score cites
	 * @param feedbackScoreCoAuthorName the feedback score co author name
	 * @param feedbackScoreEmail the feedback score email
	 * @param feedbackScoreInstitution the feedback score institution
	 * @param feedbackScoreJournal the feedback score journal
	 * @param feedbackScoreJournalSubField the feedback score journal sub field
	 * @param feedbackScoreKeyword the feedback score keyword
	 * @param feedbackScoreOrcid the feedback score orcid
	 * @param feedbackScoreOrcidCoAuthor the feedback score orcid co author
	 * @param feedbackScoreOrganization the feedback score organization
	 * @param feedbackScoreTargetAuthorName the feedback score target author name
	 * @param feedbackScoreYear the feedback score year
	 * @param articleCountScore the article count score
	 * @param authorCountScore the author count score
	 * @param discrepancyDegreeYearScore the discrepancy degree year score
	 * @param emailMatchScore the email match score
	 * @param genderScoreIdentityArticleDiscrepancy the gender score identity article discrepancy
	 * @param grantMatchScore the grant match score
	 * @param journalSubfieldScore the journal subfield score
	 * @param nameMatchFirstScore the name match first score
	 * @param nameMatchLastScore the name match last score
	 * @param nameMatchMiddleScore the name match middle score
	 * @param nameMatchModifierScore the name match modifier score
	 * @param organizationalUnitMatchingScore the organizational unit matching score
	 * @param relationshipPositiveMatchScore the relationship positive match score
	 * @param relationshipNegativeMatchScore the relationship negative match score
	 * @param relationshipIdentityCount the relationship identity count
	 * @param scopusNonTargetAuthorInstitutionalAffiliationScore the scopus non target author institutional affiliation score
	 * @param targetAuthorInstitutionalAffiliationMatchTypeScore the target author institutional affiliation match type score
	 * @param pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore the pubmed target author institutional affiliation match type score
	 * @param countAccepted the count accepted
	 * @param countRejected the count rejected
	 * @param userAssertion the user assertion
	 */
	public ReCiterArticleFeedbackIdentityScore(long articleId, double feedbackScoreCites,
			double feedbackScoreCoAuthorName, double feedbackScoreEmail, double feedbackScoreInstitution,
			double feedbackScoreJournal, double feedbackScoreJournalSubField, double feedbackScoreKeyword,
			double feedbackScoreOrcid, double feedbackScoreOrcidCoAuthor, double feedbackScoreOrganization,
			double feedbackScoreTargetAuthorName, double feedbackScoreYear, double articleCountScore,double authorCountScore,
			double discrepancyDegreeYearScore, double emailMatchScore, double genderScoreIdentityArticleDiscrepancy,
			double grantMatchScore, double journalSubfieldScore, double nameMatchFirstScore, double nameMatchLastScore,
			double nameMatchMiddleScore, double nameMatchModifierScore, double organizationalUnitMatchingScore,
			double relationshipPositiveMatchScore, double relationshipNegativeMatchScore, long relationshipIdentityCount, 
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
	        this.authorCountScore = authorCountScore;
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
	        this.relationshipPositiveMatchScore = relationshipPositiveMatchScore;
	        this.relationshipNegativeMatchScore = relationshipNegativeMatchScore; 
	        this.relationshipIdentityCount = relationshipIdentityCount;
	        this.scopusNonTargetAuthorInstitutionalAffiliationScore = scopusNonTargetAuthorInstitutionalAffiliationScore;
	        this.targetAuthorInstitutionalAffiliationMatchTypeScore = targetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore = pubmedTargetAuthorInstitutionalAffiliationMatchTypeScore;
	        this.countAccepted = countAccepted;
	        this.countRejected = countRejected;
	        this.userAssertion = userAssertion;
	        
	      
	}
	
}
