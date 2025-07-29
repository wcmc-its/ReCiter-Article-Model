/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package reciter.model.article;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;

import reciter.engine.analysis.evidence.AcceptedRejectedEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.ArticleCountEvidence;
import reciter.engine.analysis.evidence.AuthorCountEvidence;
import reciter.engine.analysis.evidence.AuthorNameEvidence;
import reciter.engine.analysis.evidence.AverageClusteringEvidence;
import reciter.engine.analysis.evidence.ClusteringEvidence;
import reciter.engine.analysis.evidence.EducationYearEvidence;
import reciter.engine.analysis.evidence.EmailEvidence;
import reciter.engine.analysis.evidence.FeedbackEvidence;
import reciter.engine.analysis.evidence.GenderEvidence;
import reciter.engine.analysis.evidence.Grant;
import reciter.engine.analysis.evidence.GrantEvidence;
import reciter.engine.analysis.evidence.JournalCategoryEvidence;
import reciter.engine.analysis.evidence.OrganizationalUnitEvidence;
import reciter.engine.analysis.evidence.PersonTypeEvidence;
import reciter.engine.analysis.evidence.RelationshipEvidence;
import reciter.model.identity.AuthorName;
import reciter.model.identity.KnownRelationship;
import reciter.model.scopus.ScopusArticle;

/**
 * The Class ReCiterArticle.
 * @author ved4006
 */
public class ReCiterArticle implements Comparable<ReCiterArticle> {

    /**
     * Article id: (usually PMID).
     */
    private final long articleId;


    /**
     * Article title.
     */
    private String articleTitle;

    /**
     * Co-authors of this article.
     */
    private ReCiterArticleAuthors articleCoAuthors;

    /**
     * Journal that this article belongs to.
     */
    private ReCiterJournal journal;

    /**
     * Keywords associated with this article.
     */
    private ReCiterArticleKeywords articleKeywords;

    /**
     * How "complete" this article is. (Please refer to the ReCiter paper).
     */
    private double completenessScore;
    
    /** Populate features of a article based on journal title and meshMajor and co-authors. */
    private ReCiterArticleFeatures reCiterArticleFeatures;

    /**
     * Scopus Article.
     */
    @Transient
    private ScopusArticle scopusArticle;
    
    /** The co author name feedback score. */
    //Feedback final scores
    private double coAuthorNameFeedbackScore;
    
    /** The keyword feedack score. */
    private double keywordFeedackScore;
    
    /** The journal feedack score. */
    private double journalFeedackScore;
    
    /** The journal domain feedback score. */
    private double journalDomainFeedbackScore;
    
    /** The journal field feedback score. */
    private double journalFieldFeedbackScore;
    
    /** The journal sub field feedback score. */
    private double journalSubFieldFeedbackScore;
    
    /** The orcid feedback score. */
    private double orcidFeedbackScore;
    
    /** The orcid co author feedback score. */
    private double orcidCoAuthorFeedbackScore;
    
    /** The cites feedback score. */
    private double citesFeedbackScore;
    
    /** The email feedback score. */
    private double emailFeedbackScore;
    
    /** The institution feedback score. */
    private double institutionFeedbackScore;
    
    /** The organization feedback score. */
    private double organizationFeedbackScore;
    
    /** The target author name feedback score. */
    private double targetAuthorNameFeedbackScore;
    
    /** The year feedback score. */
    private double yearFeedbackScore;
    
    /** The feedback total score. */
    private double feedbackTotalScore;
    
    /** The exported co author name feedback score. */
    private String exportedCoAuthorNameFeedbackScore;
    
    /** The exported keyword feedack score. */
    private String exportedKeywordFeedackScore;
    
    /** The exported journal feedack score. */
    private String exportedJournalFeedackScore;
    
    /** The exported journal domain feedback score. */
    private String exportedJournalDomainFeedbackScore;
    
    /** The exported journal field feedback score. */
    private String exportedJournalFieldFeedbackScore;
    
    /** The exported journal sub field feedback score. */
    private String exportedJournalSubFieldFeedbackScore;
    
    /** The exported orcid feedback score. */
    private String exportedOrcidFeedbackScore;
    
    /** The exported orcid co author feedback score. */
    private String exportedOrcidCoAuthorFeedbackScore;
    
    /** The exported cites feedback score. */
    private String exportedCitesFeedbackScore;
    
    /** The exported email feedback score. */
    private String exportedEmailFeedbackScore;
    
    /** The exported institution feedback score. */
    private String exportedInstitutionFeedbackScore;
    
    /** The exported organization feedback score. */
    private String exportedOrganizationFeedbackScore;
    
    /** The exported target author name feedback score. */
    private String exportedTargetAuthorNameFeedbackScore;
    
    /** The exported year feedback score. */
    private String exportedYearFeedbackScore; 
    
    /** The article feedback scores map list. */
    private List<Map<String,List<ReCiterArticleFeedbackScore>>> articleFeedbackScoresMapList;
    
    /** The authorship likelihood score. */
    private double authorshipLikelihoodScore;
    
    
	/**
     * Grant List.

     */
    private List<ReCiterArticleGrant> grantList;
    
    /** The matching grant list. */
    private List<ReCiterArticleGrant> matchingGrantList = new ArrayList<>(0);

    /** The should remove value. */
    private boolean shouldRemoveValue;
    
    /** The found author with same first name value. */
    private boolean foundAuthorWithSameFirstNameValue;
    
    /** The found matching author value. */
    private boolean foundMatchingAuthorValue;

    /**
     * Text containing how it's clustered.
     */
    @Transient
    private String clusterInfo = "";
    
    /** The total article score without clustering. */
    private double totalArticleScoreWithoutClustering;
    
    /** The total article score non standardized. */
    private double totalArticleScoreNonStandardized;
    
    /** The total article score standardized. */
    private double totalArticleScoreStandardized;

    /**
     * Gets the total article score standardized.
     *
     * @return the total article score standardized
     */
    public double getTotalArticleScoreStandardized() {
		return totalArticleScoreStandardized;
	}

	/**
	 * Sets the total article score standardized.
	 *
	 * @param totalArticleScoreStandardized the new total article score standardized
	 */
	public void setTotalArticleScoreStandardized(double totalArticleScoreStandardized) {
		this.totalArticleScoreStandardized = totalArticleScoreStandardized;
	}

	/**
	 * Gets the relationship evidences.
	 *
	 * @return the relationship evidences
	 */
	public RelationshipEvidence getRelationshipEvidences() {
		return relationshipEvidences;
	}

	/**
	 * Sets the relationship evidences.
	 *
	 * @param relationshipEvidences the new relationship evidences
	 */
	public void setRelationshipEvidences(RelationshipEvidence relationshipEvidences) {
		this.relationshipEvidences = relationshipEvidences;
	}

	/**
	 * Gets the total article score non standardized.
	 *
	 * @return the total article score non standardized
	 */
	public double getTotalArticleScoreNonStandardized() {
		return totalArticleScoreNonStandardized;
	}

	/**
	 * Sets the total article score non standardized.
	 *
	 * @param totalArticleScoreNonStandardized the new total article score non standardized
	 */
	public void setTotalArticleScoreNonStandardized(double totalArticleScoreNonStandardized) {
		this.totalArticleScoreNonStandardized = totalArticleScoreNonStandardized;
	}

	/** The email strategy score. */
	private double emailStrategyScore;
    
    /** The matching emails. */
    private List<String> matchingEmails = new ArrayList<>(0);
    
    /** The department strategy score. */
    private double departmentStrategyScore;
    
    /** The matching department. */
    private String matchingDepartment;
    
    /** The publication type pubmed. */
    private List<String> publicationTypePubmed;
    
    /** The publication type scopus. */
    private ReCiterPublicationTypeScopus publicationTypeScopus;
    
    /** The publication type canonical. */
    private String publicationTypeCanonical;
    
    /** The times cited. */
    private Long timesCited;
    
    /** The publication abstract. */
    private String publicationAbstract;
    
    /** The scopus doc id. */
    private String scopusDocId;
    

    /** The known coinvestigator score. */
    private double knownCoinvestigatorScore;
    
    /** The known relationship. */
    private List<KnownRelationship> knownRelationship = new ArrayList<>(0);
    
    /** The affiliation score. */
    private double affiliationScore;
    
    /** The scopus strategy score. */
    private double scopusStrategyScore;
    
    /** The coauthor strategy score. */
    private double coauthorStrategyScore;
    
    /** The journal strategy score. */
    private double journalStrategyScore;
    
    /** The citizenship strategy score. */
    private double citizenshipStrategyScore;

    /** The name strategy score. */
    private double nameStrategyScore;
    
    /** The board certification strategy score. */
    private double boardCertificationStrategyScore;
    
    /** The internship and residence strategy score. */
    private double internshipAndResidenceStrategyScore;
    
    /** The bachelors year discrepancy score. */
    private double bachelorsYearDiscrepancyScore;
    
    /** The doctoral year discrepancy score. */
    private double doctoralYearDiscrepancyScore;
    
    /** The bachelors year discrepancy. */
    private int bachelorsYearDiscrepancy;
    
    /** The published prior academic degree bachelors. */
    private String publishedPriorAcademicDegreeBachelors;
    
    /** The doctoral year discrepancy. */
    private int doctoralYearDiscrepancy;
    
    /** The published prior academic degree doctoral. */
    private String publishedPriorAcademicDegreeDoctoral;
    
    /** The is article title start with bracket. */
    private boolean isArticleTitleStartWithBracket;
    
    /** The education strategy score. */
    private double educationStrategyScore;
    
    /** The mesh major strategy score. */
    private double meshMajorStrategyScore;
    
    /** The overlapping me SH major negative articles. */
    private Set<String> overlappingMeSHMajorNegativeArticles = new HashSet<>();

    /** The gold standard. */
    private int goldStandard;
    
    /** The comments corrections pmids. */
    private Set<Long> commentsCorrectionsPmids = new HashSet<>();
    
    /** The mesh headings. */
    private List<ReCiterArticleMeshHeading> meshHeadings = new ArrayList<>();

    /** The known relationships. */
    private List<ReCiterAuthor> knownRelationships = new ArrayList<>();
    
    /** The frequent institutional collaborators. */
    private List<String> frequentInstitutionalCollaborators = new ArrayList<>();

    /** The citations. */
    private List<Long> citations = new ArrayList<>();
    
    /** The matching name. */
    private AuthorName matchingName;

    /** The co citation. */
    private List<CoCitation> coCitation = new ArrayList<>();

    /** The correct author rank. */
    private int correctAuthorRank;
    
    /** The num authors. */
    private int numAuthors;
    
    /** The journal category. */
    private ReCiterJournalCategory journalCategory;

    /** The mesh major info. */
    private StringBuilder meshMajorInfo;
    
    /** The cites info. */
    private StringBuilder citesInfo;
    
    /** The cited by info. */
    private StringBuilder citedByInfo;
    
    /** The co citation info. */
    private StringBuilder coCitationInfo;
    
    /** The journal title info. */
    private StringBuilder journalTitleInfo;

    /** The publication date standardized. */
    private String publicationDateStandardized;
    
    /** The date publication added to entrez. */
    private String datePublicationAddedToEntrez;
    
    /** The publication date display. */
    private String publicationDateDisplay;
    
    
    /** The organizational unit evidences. */
    private List<OrganizationalUnitEvidence> organizationalUnitEvidences;
    
    /** The education year evidence. */
    private EducationYearEvidence educationYearEvidence;
    
    /** The affiliation evidence. */
    private AffiliationEvidence affiliationEvidence;
    
    /** The grant evidence. */
    private GrantEvidence grantEvidence;
    
    /** The author name evidence. */
    private AuthorNameEvidence authorNameEvidence;
    
    /** The journal category evidence. */
    private JournalCategoryEvidence journalCategoryEvidence;
    
    /** The email evidence. */
    private EmailEvidence emailEvidence;
    
    /** The accepted rejected evidence. */
    private AcceptedRejectedEvidence acceptedRejectedEvidence;
    
    /** The article count evidence. */
    private ArticleCountEvidence articleCountEvidence;
    
    /** The person type evidence. */
    private PersonTypeEvidence personTypeEvidence;
    
    /** The average clustering evidence. */
    private AverageClusteringEvidence averageClusteringEvidence;
    
    /** The gender evidence. */
    private GenderEvidence genderEvidence;
    
    /** The feedback evidence. */
    private FeedbackEvidence feedbackEvidence;
    
    /** The author count evidence. */
    private AuthorCountEvidence authorCountEvidence;
    
    /** The target author count. */
    private long targetAuthorCount;
    
    /** The target author count penalty. */
    private double targetAuthorCountPenalty;
    
    /**
     * Gets the average clustering evidence.
     *
     * @return the average clustering evidence
     */
    public AverageClusteringEvidence getAverageClusteringEvidence() {
		return averageClusteringEvidence;
	}

	/**
	 * Sets the average clustering evidence.
	 *
	 * @param averageClusteringEvidence the new average clustering evidence
	 */
	public void setAverageClusteringEvidence(AverageClusteringEvidence averageClusteringEvidence) {
		this.averageClusteringEvidence = averageClusteringEvidence;
	}

	/** The relationship evidences. */
	private RelationshipEvidence relationshipEvidences;

    /** The volume. */
    private String volume;
    
    /** The issue. */
    private String issue;
    
    /** The pmcid. */
    private String pmcid;
    
    /** The pages. */
    private String pages;
    
    /** The doi. */
    private String doi;

    /**
     * Gets the doi.
     *
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * Sets the doi.
     *
     * @param doi the new doi
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * Gets the journal category.
     *
     * @return the journal category
     */
    public ReCiterJournalCategory getJournalCategory() {
        return journalCategory;
    }

    /**
     * Sets the journal category.
     *
     * @param journalCategory the new journal category
     */
    public void setJournalCategory(ReCiterJournalCategory journalCategory) {
        this.journalCategory = journalCategory;
    }

    /**
     * Gets the pages.
     *
     * @return the pages
     */
    public String getPages() {
        return pages;
    }

    /**
     * Sets the pages.
     *
     * @param pages the new pages
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * Gets the pmcid.
     *
     * @return the pmcid
     */
    public String getPmcid() {
        return pmcid;
    }

    /**
     * Sets the pmcid.
     *
     * @param pmcid the new pmcid
     */
    public void setPmcid(String pmcid) {
        this.pmcid = pmcid;
    }

    /**
     * Gets the issue.
     *
     * @return the issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * Sets the issue.
     *
     * @param issue the new issue
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * Gets the volume.
     *
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Sets the volume.
     *
     * @param volume the new volume
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * Gets the clustering evidence.
     *
     * @return the clustering evidence
     */
    public ClusteringEvidence getClusteringEvidence() {
        return clusteringEvidence;
    }

    /**
     * Sets the clustering evidence.
     *
     * @param clusteringEvidence the new clustering evidence
     */
    public void setClusteringEvidence(ClusteringEvidence clusteringEvidence) {
        this.clusteringEvidence = clusteringEvidence;
    }

    /** The clustering evidence. */
    private ClusteringEvidence clusteringEvidence = new ClusteringEvidence();

    /**
     * Gets the education year evidence.
     *
     * @return the education year evidence
     */
    public EducationYearEvidence getEducationYearEvidence() {
        return educationYearEvidence;
    }

    /**
     * Sets the education year evidence.
     *
     * @param educationYearEvidence the new education year evidence
     */
    public void setEducationYearEvidence(EducationYearEvidence educationYearEvidence) {
        this.educationYearEvidence = educationYearEvidence;
    }

    /**
     * Gets the relationship evidence.
     *
     * @return the relationship evidence
     */
    public RelationshipEvidence getRelationshipEvidence() {
        return relationshipEvidences;
    }

    /**
     * Sets the relationship evidence.
     *
     * @param relationshipEvidences the new relationship evidence
     */
    public void setRelationshipEvidence(RelationshipEvidence relationshipEvidences) {
        this.relationshipEvidences = relationshipEvidences;
    }

    /**
     * Gets the grant evidence.
     *
     * @return the grant evidence
     */
    public GrantEvidence getGrantEvidence() {
        return grantEvidence;
    }

    /**
     * Sets the grant evidence.
     *
     * @param grantEvidence the new grant evidence
     */
    public void setGrantEvidence(GrantEvidence grantEvidence) {
        this.grantEvidence = grantEvidence;
    }


    /**
     * Gets the affiliation evidence.
     *
     * @return the affiliation evidence
     */
    public AffiliationEvidence getAffiliationEvidence() {
        return affiliationEvidence;
    }

    /**
     * Sets the affiliation evidence.
     *
     * @param affiliationEvidence the new affiliation evidence
     */
    public void setAffiliationEvidence(AffiliationEvidence affiliationEvidence) {
        this.affiliationEvidence = affiliationEvidence;
    }

    /**
     * Gets the author name evidence.
     *
     * @return the author name evidence
     */
    public AuthorNameEvidence getAuthorNameEvidence() {
		return authorNameEvidence;
	}

	/**
	 * Sets the author name evidence.
	 *
	 * @param authorNameEvidence the new author name evidence
	 */
	public void setAuthorNameEvidence(AuthorNameEvidence authorNameEvidence) {
		this.authorNameEvidence = authorNameEvidence;
	}

    /**
     * Gets the publication date standardized.
     *
     * @return the publication date standardized
     */
    public String getPublicationDateStandardized() {
		return publicationDateStandardized;
	}

	/**
	 * Sets the publication date standardized.
	 *
	 * @param publicationDateStandardized the new publication date standardized
	 */
	public void setPublicationDateStandardized(String publicationDateStandardized) {
		this.publicationDateStandardized = publicationDateStandardized;
	}

	/**
	 * Gets the date publication added to entrez.
	 *
	 * @return the date publication added to entrez
	 */
	public String getDatePublicationAddedToEntrez() {
		return datePublicationAddedToEntrez;
	}

	/**
	 * Sets the date publication added to entrez.
	 *
	 * @param datePublicationAddedToEntrez the new date publication added to entrez
	 */
	public void setDatePublicationAddedToEntrez(String datePublicationAddedToEntrez) {
		this.datePublicationAddedToEntrez = datePublicationAddedToEntrez;
	}

	/**
	 * Gets the publication date display.
	 *
	 * @return the publication date display
	 */
	public String getPublicationDateDisplay() {
		return publicationDateDisplay;
	}

	/**
	 * Sets the publication date display.
	 *
	 * @param publicationDateDisplay the new publication date display
	 */
	public void setPublicationDateDisplay(String publicationDateDisplay) {
		this.publicationDateDisplay = publicationDateDisplay;
	}

	/**
	 * Gets the mesh major info.
	 *
	 * @return the mesh major info
	 */
	public StringBuilder getMeshMajorInfo() {
        if (meshMajorInfo == null) {
            meshMajorInfo = new StringBuilder();
        }
        return meshMajorInfo;
    }

    /**
     * Sets the mesh major info.
     *
     * @param meshMajorInfo the new mesh major info
     */
    public void setMeshMajorInfo(StringBuilder meshMajorInfo) {
        this.meshMajorInfo = meshMajorInfo;
    }

    /**
     * Gets the cites info.
     *
     * @return the cites info
     */
    public StringBuilder getCitesInfo() {
        if (citesInfo == null) {
            citesInfo = new StringBuilder();
        }
        return citesInfo;
    }

    /**
     * Sets the cites info.
     *
     * @param citesInfo the new cites info
     */
    public void setCitesInfo(StringBuilder citesInfo) {
        this.citesInfo = citesInfo;
    }

    /**
     * Gets the cited by info.
     *
     * @return the cited by info
     */
    public StringBuilder getCitedByInfo() {
        if (citedByInfo == null) {
            citedByInfo = new StringBuilder();
        }
        return citedByInfo;
    }

    /**
     * Sets the cited by info.
     *
     * @param citedByInfo the new cited by info
     */
    public void setCitedByInfo(StringBuilder citedByInfo) {
        this.citedByInfo = citedByInfo;
    }

    /**
     * Gets the co citation info.
     *
     * @return the co citation info
     */
    public StringBuilder getCoCitationInfo() {
        if (coCitationInfo == null) {
            coCitationInfo = new StringBuilder();
        }
        return coCitationInfo;
    }
    
    /**
     * Gets the grant evidence total score.
     *
     * @return the grant evidence total score
     */
    public double getGrantEvidenceTotalScore() {
    	if(this.grantEvidence == null) {
    		return 0;
    	}
    	return this.grantEvidence.getGrants().stream().mapToDouble(Grant::getGrantMatchScore).sum();
    }
    
    /**
     * Gets the relationship evidences total score.
     *
     * @return the relationship evidences total score
     */
    public double getRelationshipEvidencesTotalScore() {
    	return 0;
    }
    
    
    
    /**
     * Gets the journal category evidence.
     *
     * @return the journal category evidence
     */
    public JournalCategoryEvidence getJournalCategoryEvidence() {
		return journalCategoryEvidence;
	}

	/**
	 * Sets the journal category evidence.
	 *
	 * @param journalCategoryEvidence the new journal category evidence
	 */
	public void setJournalCategoryEvidence(JournalCategoryEvidence journalCategoryEvidence) {
		this.journalCategoryEvidence = journalCategoryEvidence;
	}

	/**
	 * Gets the organizational evidences total score.
	 *
	 * @return the organizational evidences total score
	 */
	public double getOrganizationalEvidencesTotalScore() {
    	if(this.organizationalUnitEvidences == null) {
    		return 0;
    	}
    	return this.organizationalUnitEvidences.stream().mapToDouble(organizationalUnitEvidence -> organizationalUnitEvidence.getOrganizationalUnitMatchingScore() +
    			organizationalUnitEvidence.getOrganizationalUnitModifierScore()).sum();
    }

    /**
     * Sets the co citation info.
     *
     * @param coCitationInfo the new co citation info
     */
    public void setCoCitationInfo(StringBuilder coCitationInfo) {
        this.coCitationInfo = coCitationInfo;
    }

    /**
     * Gets the journal title info.
     *
     * @return the journal title info
     */
    public StringBuilder getJournalTitleInfo() {
        if (journalTitleInfo == null) {
            journalTitleInfo = new StringBuilder();
        }
        return journalTitleInfo;
    }

    /**
     * Sets the journal title info.
     *
     * @param journalTitleInfo the new journal title info
     */
    public void setJournalTitleInfo(StringBuilder journalTitleInfo) {
        this.journalTitleInfo = journalTitleInfo;
    }

    /**
     * Sets the education strategy score.
     *
     * @param educationStrategyScore the new education strategy score
     */
    public void setEducationStrategyScore(double educationStrategyScore) {
        this.educationStrategyScore = educationStrategyScore;
    }

    /**
     * The Class CoCitation.
     */
    public static class CoCitation {
        
        /** The pmid. */
        private long pmid;
        
        /** The pmids. */
        private List<Long> pmids;

        /**
         * Gets the pmid.
         *
         * @return the pmid
         */
        public long getPmid() {
            return pmid;
        }

        /**
         * Sets the pmid.
         *
         * @param pmid the new pmid
         */
        public void setPmid(long pmid) {
            this.pmid = pmid;
        }

        /**
         * Gets the pmids.
         *
         * @return the pmids
         */
        public List<Long> getPmids() {
            return pmids;
        }

        /**
         * Sets the pmids.
         *
         * @param pmids the new pmids
         */
        public void setPmids(List<Long> pmids) {
            this.pmids = pmids;
        }
    }
    
    /**
     * Instantiates a new re citer article.
     *
     * @param articleId the article id
     */
    @JsonCreator
    public ReCiterArticle(long articleId) {
        this.articleId = articleId;
        this.articleFeedbackScoresMapList = new ArrayList<>();
    }

    /**
     * Compare to.
     *
     * @param otherArticle the other article
     * @return the int
     */
    @Override
    public int compareTo(ReCiterArticle otherArticle) {
        double x = this.getCompletenessScore();
        double y = otherArticle.getCompletenessScore();
        if (x > y) {
            return -1;
        } else if (x < y) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public long getArticleId() {
        return articleId;
    }

    /**
     * Gets the article title.
     *
     * @return the article title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle the new article title
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets the article co authors.
     *
     * @return the article co authors
     */
    public ReCiterArticleAuthors getArticleCoAuthors() {
        return articleCoAuthors;
    }

    /**
     * Sets the article co authors.
     *
     * @param articleCoAuthors the new article co authors
     */
    public void setArticleCoAuthors(ReCiterArticleAuthors articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
    }

    /**
     * Gets the journal.
     *
     * @return the journal
     */
    public ReCiterJournal getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal the new journal
     */
    public void setJournal(ReCiterJournal journal) {
        this.journal = journal;
    }

    /**
     * Gets the article keywords.
     *
     * @return the article keywords
     */
    public ReCiterArticleKeywords getArticleKeywords() {
        return articleKeywords;
    }

    /**
     * Sets the article keywords.
     *
     * @param articleKeywords the new article keywords
     */
    public void setArticleKeywords(ReCiterArticleKeywords articleKeywords) {
        this.articleKeywords = articleKeywords;
    }

    /**
     * Gets the completeness score.
     *
     * @return the completeness score
     */
    public double getCompletenessScore() {
        return completenessScore;
    }

    /**
     * Sets the completeness score.
     *
     * @param completenessScore the new completeness score
     */
    public void setCompletenessScore(double completenessScore) {
        this.completenessScore = completenessScore;
    }

    /**
     * Gets the scopus article.
     *
     * @return the scopus article
     */
    public ScopusArticle getScopusArticle() {
        return scopusArticle;
    }

    /**
     * Sets the scopus article.
     *
     * @param scopusArticle the new scopus article
     */
    public void setScopusArticle(ScopusArticle scopusArticle) {
        this.scopusArticle = scopusArticle;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (articleId ^ (articleId >>> 32));
        return result;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReCiterArticle other = (ReCiterArticle) obj;
        if (articleId != other.articleId)
            return false;
        return true;
    }

    /**
     * Gets the cluster info.
     *
     * @return the cluster info
     */
    public String getClusterInfo() {
        return clusterInfo;
    }

    /**
     * Sets the cluster info.
     *
     * @param clusterInfo the new cluster info
     */
    public void setClusterInfo(String clusterInfo) {
        this.clusterInfo = clusterInfo;
    }

    /**
     * Append cluster info.
     *
     * @param clusterInfo the cluster info
     */
    public void appendClusterInfo(String clusterInfo) {
        this.clusterInfo += " | " + clusterInfo;
    }

    /**
     * Gets the email strategy score.
     *
     * @return the email strategy score
     */
    public double getEmailStrategyScore() {
        return emailStrategyScore;
    }

    /**
     * Sets the email strategy score.
     *
     * @param emailStrategyScore the new email strategy score
     */
    public void setEmailStrategyScore(double emailStrategyScore) {
        this.emailStrategyScore = emailStrategyScore;
    }

    /**
     * Gets the department strategy score.
     *
     * @return the department strategy score
     */
    public double getDepartmentStrategyScore() {
        return departmentStrategyScore;
    }

    /**
     * Sets the department strategy score.
     *
     * @param departmentStrategyScore the new department strategy score
     */
    public void setDepartmentStrategyScore(double departmentStrategyScore) {
        this.departmentStrategyScore = departmentStrategyScore;
    }

    /**
     * Gets the known coinvestigator score.
     *
     * @return the known coinvestigator score
     */
    public double getKnownCoinvestigatorScore() {
        return knownCoinvestigatorScore;
    }

    /**
     * Sets the known coinvestigator score.
     *
     * @param knownCoinvestigatorScore the new known coinvestigator score
     */
    public void setKnownCoinvestigatorScore(double knownCoinvestigatorScore) {
        this.knownCoinvestigatorScore = knownCoinvestigatorScore;
    }

    /**
     * Gets the affiliation score.
     *
     * @return the affiliation score
     */
    public double getAffiliationScore() {
        return affiliationScore;
    }

    /**
     * Sets the affiliation score.
     *
     * @param affiliationScore the new affiliation score
     */
    public void setAffiliationScore(double affiliationScore) {
        this.affiliationScore = affiliationScore;
    }

    /**
     * Gets the scopus strategy score.
     *
     * @return the scopus strategy score
     */
    public double getScopusStrategyScore() {
        return scopusStrategyScore;
    }

    /**
     * Sets the scopus strategy score.
     *
     * @param scopusStrategyScore the new scopus strategy score
     */
    public void setScopusStrategyScore(double scopusStrategyScore) {
        this.scopusStrategyScore = scopusStrategyScore;
    }

    /**
     * Gets the coauthor strategy score.
     *
     * @return the coauthor strategy score
     */
    public double getCoauthorStrategyScore() {
        return coauthorStrategyScore;
    }

    /**
     * Sets the coauthor strategy score.
     *
     * @param coauthorStrategyScore the new coauthor strategy score
     */
    public void setCoauthorStrategyScore(double coauthorStrategyScore) {
        this.coauthorStrategyScore = coauthorStrategyScore;
    }

    /**
     * Gets the journal strategy score.
     *
     * @return the journal strategy score
     */
    public double getJournalStrategyScore() {
        return journalStrategyScore;
    }

    /**
     * Sets the journal strategy score.
     *
     * @param journalStrategyScore the new journal strategy score
     */
    public void setJournalStrategyScore(double journalStrategyScore) {
        this.journalStrategyScore = journalStrategyScore;
    }

    /**
     * Gets the citizenship strategy score.
     *
     * @return the citizenship strategy score
     */
    public double getCitizenshipStrategyScore() {
        return citizenshipStrategyScore;
    }

    /**
     * Sets the citizenship strategy score.
     *
     * @param citizenshipStrategyScore the new citizenship strategy score
     */
    public void setCitizenshipStrategyScore(double citizenshipStrategyScore) {
        this.citizenshipStrategyScore = citizenshipStrategyScore;
    }

    /**
     * Gets the name strategy score.
     *
     * @return the name strategy score
     */
    public double getNameStrategyScore() {
        return nameStrategyScore;
    }

    /**
     * Sets the name strategy score.
     *
     * @param nameStrategyScore the new name strategy score
     */
    public void setNameStrategyScore(double nameStrategyScore) {
        this.nameStrategyScore = nameStrategyScore;
    }

    /**
     * Gets the board certification strategy score.
     *
     * @return the board certification strategy score
     */
    public double getBoardCertificationStrategyScore() {
        return boardCertificationStrategyScore;
    }

    /**
     * Sets the board certification strategy score.
     *
     * @param boardCertificationStrategyScore the new board certification strategy score
     */
    public void setBoardCertificationStrategyScore(double boardCertificationStrategyScore) {
        this.boardCertificationStrategyScore = boardCertificationStrategyScore;
    }

    /**
     * Gets the internship and residence strategy score.
     *
     * @return the internship and residence strategy score
     */
    public double getInternshipAndResidenceStrategyScore() {
        return internshipAndResidenceStrategyScore;
    }

    /**
     * Sets the internship and residence strategy score.
     *
     * @param internshipAndResidenceStrategyScore the new internship and residence strategy score
     */
    public void setInternshipAndResidenceStrategyScore(double internshipAndResidenceStrategyScore) {
        this.internshipAndResidenceStrategyScore = internshipAndResidenceStrategyScore;
    }

    /**
     * Gets the gold standard.
     *
     * @return the gold standard
     */
    public int getGoldStandard() {
        return goldStandard;
    }

    /**
     * Sets the gold standard.
     *
     * @param goldStandard the new gold standard
     */
    public void setGoldStandard(int goldStandard) {
        this.goldStandard = goldStandard;
    }

    /**
     * Gets the grant list.
     *
     * @return the grant list
     */
    public List<ReCiterArticleGrant> getGrantList() {
        return grantList;
    }

    /**
     * Sets the grant list.
     *
     * @param grantList the new grant list
     */
    public void setGrantList(List<ReCiterArticleGrant> grantList) {
        this.grantList = grantList;
    }

    /**
     * Gets the bachelors year discrepancy score.
     *
     * @return the bachelors year discrepancy score
     */
    public double getBachelorsYearDiscrepancyScore() {
        return bachelorsYearDiscrepancyScore;
    }

    /**
     * Sets the bachelors year discrepancy score.
     *
     * @param bachelorsYearDiscrepancyScore the new bachelors year discrepancy score
     */
    public void setBachelorsYearDiscrepancyScore(double bachelorsYearDiscrepancyScore) {
        this.bachelorsYearDiscrepancyScore = bachelorsYearDiscrepancyScore;
    }

    /**
     * Gets the doctoral year discrepancy score.
     *
     * @return the doctoral year discrepancy score
     */
    public double getDoctoralYearDiscrepancyScore() {
        return doctoralYearDiscrepancyScore;
    }

    /**
     * Sets the doctoral year discrepancy score.
     *
     * @param doctoralYearDiscrepancyScore the new doctoral year discrepancy score
     */
    public void setDoctoralYearDiscrepancyScore(double doctoralYearDiscrepancyScore) {
        this.doctoralYearDiscrepancyScore = doctoralYearDiscrepancyScore;
    }

    /**
     * Checks if is article title start with bracket.
     *
     * @return true, if is article title start with bracket
     */
    public boolean isArticleTitleStartWithBracket() {
        return isArticleTitleStartWithBracket;
    }

    /**
     * Sets the article title start with bracket.
     *
     * @param isArticleTitleStartWithBracket the new article title start with bracket
     */
    public void setArticleTitleStartWithBracket(boolean isArticleTitleStartWithBracket) {
        this.isArticleTitleStartWithBracket = isArticleTitleStartWithBracket;
    }

    /**
     * Gets the education strategy score.
     *
     * @return the education strategy score
     */
    public double getEducationStrategyScore() {
        return educationStrategyScore;
    }

    /**
     * Sets the education score.
     *
     * @param educationStrategyScore the new education score
     */
    public void setEducationScore(double educationStrategyScore) {
        this.educationStrategyScore = educationStrategyScore;
    }

    /**
     * Gets the comments corrections pmids.
     *
     * @return the comments corrections pmids
     */
    public Set<Long> getCommentsCorrectionsPmids() {
        return commentsCorrectionsPmids;
    }

    /**
     * Sets the comments corrections pmids.
     *
     * @param commentsCorrectionsPmids the new comments corrections pmids
     */
    public void setCommentsCorrectionsPmids(Set<Long> commentsCorrectionsPmids) {
        this.commentsCorrectionsPmids = commentsCorrectionsPmids;
    }

    /**
     * Gets the mesh headings.
     *
     * @return the mesh headings
     */
    public List<ReCiterArticleMeshHeading> getMeshHeadings() {
        return meshHeadings;
    }

    /**
     * Sets the mesh headings.
     *
     * @param meshHeadings the new mesh headings
     */
    public void setMeshHeadings(List<ReCiterArticleMeshHeading> meshHeadings) {
        this.meshHeadings = meshHeadings;
    }

    /**
     * Gets the bachelors year discrepancy.
     *
     * @return the bachelors year discrepancy
     */
    public int getBachelorsYearDiscrepancy() {
        return bachelorsYearDiscrepancy;
    }

    /**
     * Sets the bachelors year discrepancy.
     *
     * @param bachelorsYearDiscrepancy the new bachelors year discrepancy
     */
    public void setBachelorsYearDiscrepancy(int bachelorsYearDiscrepancy) {
        this.bachelorsYearDiscrepancy = bachelorsYearDiscrepancy;
    }

    /**
     * Gets the doctoral year discrepancy.
     *
     * @return the doctoral year discrepancy
     */
    public int getDoctoralYearDiscrepancy() {
        return doctoralYearDiscrepancy;
    }

    /**
     * Sets the doctoral year discrepancy.
     *
     * @param doctoralYearDiscrepancy the new doctoral year discrepancy
     */
    public void setDoctoralYearDiscrepancy(int doctoralYearDiscrepancy) {
        this.doctoralYearDiscrepancy = doctoralYearDiscrepancy;
    }

    /**
     * Checks if is should remove value.
     *
     * @return true, if is should remove value
     */
    public boolean isShouldRemoveValue() {
        return shouldRemoveValue;
    }

    /**
     * Sets the should remove value.
     *
     * @param shouldRemoveValue the new should remove value
     */
    public void setShouldRemoveValue(boolean shouldRemoveValue) {
        this.shouldRemoveValue = shouldRemoveValue;
    }

    /**
     * Checks if is found author with same first name value.
     *
     * @return true, if is found author with same first name value
     */
    public boolean isFoundAuthorWithSameFirstNameValue() {
        return foundAuthorWithSameFirstNameValue;
    }

    /**
     * Sets the found author with same first name value.
     *
     * @param foundAuthorWithSameFirstNameValue the new found author with same first name value
     */
    public void setFoundAuthorWithSameFirstNameValue(boolean foundAuthorWithSameFirstNameValue) {
        this.foundAuthorWithSameFirstNameValue = foundAuthorWithSameFirstNameValue;
    }

    /**
     * Checks if is found matching author value.
     *
     * @return true, if is found matching author value
     */
    public boolean isFoundMatchingAuthorValue() {
        return foundMatchingAuthorValue;
    }

    /**
     * Sets the found matching author value.
     *
     * @param foundMatchingAuthorValue the new found matching author value
     */
    public void setFoundMatchingAuthorValue(boolean foundMatchingAuthorValue) {
        this.foundMatchingAuthorValue = foundMatchingAuthorValue;
    }

    /**
     * Gets the known relationships.
     *
     * @return the known relationships
     */
    public List<ReCiterAuthor> getKnownRelationships() {
        return knownRelationships;
    }

    /**
     * Sets the known relationships.
     *
     * @param knownRelationships the new known relationships
     */
    public void setKnownRelationships(List<ReCiterAuthor> knownRelationships) {
        this.knownRelationships = knownRelationships;
    }

    /**
     * Gets the frequent institutional collaborators.
     *
     * @return the frequent institutional collaborators
     */
    public List<String> getFrequentInstitutionalCollaborators() {
        return frequentInstitutionalCollaborators;
    }

    /**
     * Sets the frequent institutional collaborators.
     *
     * @param frequentInstitutionalCollaborators the new frequent institutional collaborators
     */
    public void setFrequentInstitutionalCollaborators(List<String> frequentInstitutionalCollaborators) {
        this.frequentInstitutionalCollaborators = frequentInstitutionalCollaborators;
    }

    /**
     * Gets the mesh major strategy score.
     *
     * @return the mesh major strategy score
     */
    public double getMeshMajorStrategyScore() {
        return meshMajorStrategyScore;
    }

    /**
     * Sets the mesh major strategy score.
     *
     * @param meshMajorStrategyScore the new mesh major strategy score
     */
    public void setMeshMajorStrategyScore(double meshMajorStrategyScore) {
        this.meshMajorStrategyScore = meshMajorStrategyScore;
    }

    /**
     * Gets the overlapping me SH major negative articles.
     *
     * @return the overlapping me SH major negative articles
     */
    public Set<String> getOverlappingMeSHMajorNegativeArticles() {
        return overlappingMeSHMajorNegativeArticles;
    }

    /**
     * Sets the overlapping me SH major negative articles.
     *
     * @param overlappingMeSHMajorNegativeArticles the new overlapping me SH major negative articles
     */
    public void setOverlappingMeSHMajorNegativeArticles(Set<String> overlappingMeSHMajorNegativeArticles) {
        this.overlappingMeSHMajorNegativeArticles = overlappingMeSHMajorNegativeArticles;
    }

    /**
     * Gets the matching name.
     *
     * @return the matching name
     */
    public AuthorName getMatchingName() {
        return matchingName;
    }

    /**
     * Sets the matching name.
     *
     * @param matchingName the new matching name
     */
    public void setMatchingName(AuthorName matchingName) {
        this.matchingName = matchingName;
    }

    /**
     * Gets the citations.
     *
     * @return the citations
     */
    public List<Long> getCitations() {
        return citations;
    }

    /**
     * Sets the citations.
     *
     * @param citations the new citations
     */
    public void setCitations(List<Long> citations) {
        this.citations = citations;
    }

    /**
     * Gets the co citation.
     *
     * @return the co citation
     */
    public List<CoCitation> getCoCitation() {
        return coCitation;
    }

    /**
     * Sets the co citation.
     *
     * @param coCitation the new co citation
     */
    public void setCoCitation(List<CoCitation> coCitation) {
        this.coCitation = coCitation;
    }

    /**
     * Gets the correct author rank.
     *
     * @return the correct author rank
     */
    public int getCorrectAuthorRank() {
        return correctAuthorRank;
    }

    /**
     * Sets the correct author rank.
     *
     * @param correctAuthorRank the new correct author rank
     */
    public void setCorrectAuthorRank(int correctAuthorRank) {
        this.correctAuthorRank = correctAuthorRank;
    }

    /**
     * Gets the num authors.
     *
     * @return the num authors
     */
    public int getNumAuthors() {
        return numAuthors;
    }

    /**
     * Sets the num authors.
     *
     * @param numAuthors the new num authors
     */
    public void setNumAuthors(int numAuthors) {
        this.numAuthors = numAuthors;
    }

    /**
     * Gets the matching department.
     *
     * @return the matching department
     */
    public String getMatchingDepartment() {
        return matchingDepartment;
    }

    /**
     * Sets the matching department.
     *
     * @param matchingDepartment the new matching department
     */
    public void setMatchingDepartment(String matchingDepartment) {
        this.matchingDepartment = matchingDepartment;
    }

    /**
     * Gets the known relationship.
     *
     * @return the known relationship
     */
    public List<KnownRelationship> getKnownRelationship() {
        return knownRelationship;
    }

    /**
     * Sets the known relationship.
     *
     * @param knownRelationship the new known relationship
     */
    public void setKnownRelationship(List<KnownRelationship> knownRelationship) {
        this.knownRelationship = knownRelationship;
    }

    /**
     * Gets the matching grant list.
     *
     * @return the matching grant list
     */
    public List<ReCiterArticleGrant> getMatchingGrantList() {
        return matchingGrantList;
    }

    /**
     * Sets the matching grant list.
     *
     * @param matchingGrantList the new matching grant list
     */
    public void setMatchingGrantList(List<ReCiterArticleGrant> matchingGrantList) {
        this.matchingGrantList = matchingGrantList;
    }

    /**
     * Gets the matching emails.
     *
     * @return the matching emails
     */
    public List<String> getMatchingEmails() {
        return matchingEmails;
    }

    /**
     * Sets the matching emails.
     *
     * @param matchingEmails the new matching emails
     */
    public void setMatchingEmails(List<String> matchingEmails) {
        this.matchingEmails = matchingEmails;
    }

    /**
     * Gets the published prior academic degree bachelors.
     *
     * @return the published prior academic degree bachelors
     */
    public String getPublishedPriorAcademicDegreeBachelors() {
        return publishedPriorAcademicDegreeBachelors;
    }

    /**
     * Sets the published prior academic degree bachelors.
     *
     * @param publishedPriorAcademicDegreeBachelors the new published prior academic degree bachelors
     */
    public void setPublishedPriorAcademicDegreeBachelors(String publishedPriorAcademicDegreeBachelors) {
        this.publishedPriorAcademicDegreeBachelors = publishedPriorAcademicDegreeBachelors;
    }

    /**
     * Gets the published prior academic degree doctoral.
     *
     * @return the published prior academic degree doctoral
     */
    public String getPublishedPriorAcademicDegreeDoctoral() {
        return publishedPriorAcademicDegreeDoctoral;
    }

    /**
     * Sets the published prior academic degree doctoral.
     *
     * @param publishedPriorAcademicDegreeDoctoral the new published prior academic degree doctoral
     */
    public void setPublishedPriorAcademicDegreeDoctoral(String publishedPriorAcademicDegreeDoctoral) {
        this.publishedPriorAcademicDegreeDoctoral = publishedPriorAcademicDegreeDoctoral;
    }

	/**
	 * Gets the re citer article features.
	 *
	 * @return the re citer article features
	 */
	public ReCiterArticleFeatures getReCiterArticleFeatures() {
		return reCiterArticleFeatures;
	}

	/**
	 * Sets the re citer article features.
	 *
	 * @param reCiterArticleFeatures the new re citer article features
	 */
	public void setReCiterArticleFeatures(ReCiterArticleFeatures reCiterArticleFeatures) {
		this.reCiterArticleFeatures = reCiterArticleFeatures;
	}

	/**
	 * Gets the email evidence.
	 *
	 * @return the email evidence
	 */
	public EmailEvidence getEmailEvidence() {
		return emailEvidence;
	}

	/**
	 * Sets the email evidence.
	 *
	 * @param emailEvidence the new email evidence
	 */
	public void setEmailEvidence(EmailEvidence emailEvidence) {
		this.emailEvidence = emailEvidence;
	}

	/**
	 * Gets the article count evidence.
	 *
	 * @return the article count evidence
	 */
	public ArticleCountEvidence getArticleCountEvidence() {
		return articleCountEvidence;
	}

	/**
	 * Sets the article count evidence.
	 *
	 * @param articleCountEvidence the new article count evidence
	 */
	public void setArticleCountEvidence(ArticleCountEvidence articleCountEvidence) {
		this.articleCountEvidence = articleCountEvidence;
	}

	/**
	 * Gets the person type evidence.
	 *
	 * @return the person type evidence
	 */
	public PersonTypeEvidence getPersonTypeEvidence() {
		return personTypeEvidence;
	}

	/**
	 * Sets the person type evidence.
	 *
	 * @param personTypeEvidence the new person type evidence
	 */
	public void setPersonTypeEvidence(PersonTypeEvidence personTypeEvidence) {
		this.personTypeEvidence = personTypeEvidence;
	}

	/**
	 * Gets the organizational unit evidences.
	 *
	 * @return the organizational unit evidences
	 */
	public List<OrganizationalUnitEvidence> getOrganizationalUnitEvidences() {
		return organizationalUnitEvidences;
	}

	/**
	 * Sets the organizational unit evidences.
	 *
	 * @param organizationalEvidences the new organizational unit evidences
	 */
	public void setOrganizationalUnitEvidences(List<OrganizationalUnitEvidence> organizationalEvidences) {
		this.organizationalUnitEvidences = organizationalEvidences;
	}

	/**
	 * Gets the accepted rejected evidence.
	 *
	 * @return the accepted rejected evidence
	 */
	public AcceptedRejectedEvidence getAcceptedRejectedEvidence() {
		return acceptedRejectedEvidence;
	}

	/**
	 * Sets the accepted rejected evidence.
	 *
	 * @param acceptedRejectedEvidence the new accepted rejected evidence
	 */
	public void setAcceptedRejectedEvidence(AcceptedRejectedEvidence acceptedRejectedEvidence) {
		this.acceptedRejectedEvidence = acceptedRejectedEvidence;
	}

	/**
	 * Gets the total article score without clustering.
	 *
	 * @return the total article score without clustering
	 */
	public double getTotalArticleScoreWithoutClustering() {
		return totalArticleScoreWithoutClustering;
	}

	/**
	 * Sets the total article score without clustering.
	 *
	 * @param totalArticleScoreWithoutClustering the new total article score without clustering
	 */
	public void setTotalArticleScoreWithoutClustering(double totalArticleScoreWithoutClustering) {
		this.totalArticleScoreWithoutClustering = totalArticleScoreWithoutClustering;
	}

	/**
	 * Gets the publication type pubmed.
	 *
	 * @return the publication type pubmed
	 */
	public List<String> getPublicationTypePubmed() {
		return publicationTypePubmed;
	}

	/**
	 * Sets the publication type pubmed.
	 *
	 * @param publicationTypePubmed the new publication type pubmed
	 */
	public void setPublicationTypePubmed(List<String> publicationTypePubmed) {
		this.publicationTypePubmed = publicationTypePubmed;
	}

	/**
	 * Gets the publication type scopus.
	 *
	 * @return the publication type scopus
	 */
	public ReCiterPublicationTypeScopus getPublicationTypeScopus() {
		return publicationTypeScopus;
	}

	/**
	 * Sets the publication type scopus.
	 *
	 * @param publicationTypeScopus the new publication type scopus
	 */
	public void setPublicationTypeScopus(ReCiterPublicationTypeScopus publicationTypeScopus) {
		this.publicationTypeScopus = publicationTypeScopus;
	}

	/**
	 * Gets the publication type canonical.
	 *
	 * @return the publication type canonical
	 */
	public String getPublicationTypeCanonical() {
		return publicationTypeCanonical;
	}

	/**
	 * Sets the publication type canonical.
	 *
	 * @param publicationTypeCanonical the new publication type canonical
	 */
	public void setPublicationTypeCanonical(String publicationTypeCanonical) {
		this.publicationTypeCanonical = publicationTypeCanonical;
	}

	/**
	 * Gets the times cited.
	 *
	 * @return the times cited
	 */
	public Long getTimesCited() {
		return timesCited;
	}

	/**
	 * Sets the times cited.
	 *
	 * @param timesCited the new times cited
	 */
	public void setTimesCited(Long timesCited) {
		this.timesCited = timesCited;
	}

	/**
	 * Gets the publication abstract.
	 *
	 * @return the publication abstract
	 */
	public String getPublicationAbstract() {
		return publicationAbstract;
	}

	/**
	 * Sets the publication abstract.
	 *
	 * @param publicationAbstract the new publication abstract
	 */
	public void setPublicationAbstract(String publicationAbstract) {
		this.publicationAbstract = publicationAbstract;
	}

	/**
	 * Gets the scopus doc id.
	 *
	 * @return the scopus doc id
	 */
	public String getScopusDocId() {
		return scopusDocId;
	}

	/**
	 * Sets the scopus doc id.
	 *
	 * @param scopusDocId the new scopus doc id
	 */
	public void setScopusDocId(String scopusDocId) {
		this.scopusDocId = scopusDocId;
	}

	/**
	 * Gets the gender evidence.
	 *
	 * @return the gender evidence
	 */
	public GenderEvidence getGenderEvidence() {
		return genderEvidence;
	}

	/**
	 * Sets the gender evidence.
	 *
	 * @param genderEvidence the new gender evidence
	 */
	public void setGenderEvidence(GenderEvidence genderEvidence) {
		this.genderEvidence = genderEvidence;
	}
	
	/**
	 * Gets the co author name feedback score.
	 *
	 * @return the co author name feedback score
	 */
	public double getCoAuthorNameFeedbackScore() {
		return coAuthorNameFeedbackScore;
	}

	/**
	 * Sets the co author name feedback score.
	 *
	 * @param coAuthorNameFeedbackScore the new co author name feedback score
	 */
	public void setCoAuthorNameFeedbackScore(double coAuthorNameFeedbackScore) {
		this.coAuthorNameFeedbackScore = coAuthorNameFeedbackScore;
	}

	/**
	 * Gets the keyword feedack score.
	 *
	 * @return the keyword feedack score
	 */
	public double getKeywordFeedackScore() {
		return keywordFeedackScore;
	}

	/**
	 * Sets the keyword feedack score.
	 *
	 * @param keywordFeedackScore the new keyword feedack score
	 */
	public void setKeywordFeedackScore(double keywordFeedackScore) {
		this.keywordFeedackScore = keywordFeedackScore;
	}

	/**
	 * Gets the journal domain feedback score.
	 *
	 * @return the journal domain feedback score
	 */
	public double getJournalDomainFeedbackScore() {
		return journalDomainFeedbackScore;
	}

	/**
	 * Sets the journal domain feedback score.
	 *
	 * @param journalDomainFeedbackScore the new journal domain feedback score
	 */
	public void setJournalDomainFeedbackScore(double journalDomainFeedbackScore) {
		this.journalDomainFeedbackScore = journalDomainFeedbackScore;
	}

	/**
	 * Gets the journal field feedback score.
	 *
	 * @return the journal field feedback score
	 */
	public double getJournalFieldFeedbackScore() {
		return journalFieldFeedbackScore;
	}

	/**
	 * Sets the journal field feedback score.
	 *
	 * @param journalFieldFeedbackScore the new journal field feedback score
	 */
	public void setJournalFieldFeedbackScore(double journalFieldFeedbackScore) {
		this.journalFieldFeedbackScore = journalFieldFeedbackScore;
	}

	/**
	 * Gets the journal sub field feedback score.
	 *
	 * @return the journal sub field feedback score
	 */
	public double getJournalSubFieldFeedbackScore() {
		return journalSubFieldFeedbackScore;
	}

	/**
	 * Sets the journal sub field feedback score.
	 *
	 * @param journalSubFieldFeedbackScore the new journal sub field feedback score
	 */
	public void setJournalSubFieldFeedbackScore(double journalSubFieldFeedbackScore) {
		this.journalSubFieldFeedbackScore = journalSubFieldFeedbackScore;
	}

	/**
	 * Gets the orcid feedback score.
	 *
	 * @return the orcid feedback score
	 */
	public double getOrcidFeedbackScore() {
		return orcidFeedbackScore;
	}

	/**
	 * Sets the orcid feedback score.
	 *
	 * @param orcidFeedbackScore the new orcid feedback score
	 */
	public void setOrcidFeedbackScore(double orcidFeedbackScore) {
		this.orcidFeedbackScore = orcidFeedbackScore;
	}

	/**
	 * Gets the orcid co author feedback score.
	 *
	 * @return the orcid co author feedback score
	 */
	public double getOrcidCoAuthorFeedbackScore() {
		return orcidCoAuthorFeedbackScore;
	}

	/**
	 * Sets the orcid co author feedback score.
	 *
	 * @param orcidCoAuthorFeedbackScore the new orcid co author feedback score
	 */
	public void setOrcidCoAuthorFeedbackScore(double orcidCoAuthorFeedbackScore) {
		this.orcidCoAuthorFeedbackScore = orcidCoAuthorFeedbackScore;
	}

	/**
	 * Gets the cites feedback score.
	 *
	 * @return the cites feedback score
	 */
	public double getCitesFeedbackScore() {
		return citesFeedbackScore;
	}

	/**
	 * Sets the cites feedback score.
	 *
	 * @param citesFeedbackScore the new cites feedback score
	 */
	public void setCitesFeedbackScore(double citesFeedbackScore) {
		this.citesFeedbackScore = citesFeedbackScore;
	}

	/**
	 * Gets the email feedback score.
	 *
	 * @return the email feedback score
	 */
	public double getEmailFeedbackScore() {
		return emailFeedbackScore;
	}

	/**
	 * Sets the email feedback score.
	 *
	 * @param emailFeedbackScore the new email feedback score
	 */
	public void setEmailFeedbackScore(double emailFeedbackScore) {
		this.emailFeedbackScore = emailFeedbackScore;
	}

	/**
	 * Gets the institution feedback score.
	 *
	 * @return the institution feedback score
	 */
	public double getInstitutionFeedbackScore() {
		return institutionFeedbackScore;
	}

	/**
	 * Sets the institution feedback score.
	 *
	 * @param institutionFeedbackScore the new institution feedback score
	 */
	public void setInstitutionFeedbackScore(double institutionFeedbackScore) {
		this.institutionFeedbackScore = institutionFeedbackScore;
	}

	/**
	 * Gets the organization feedback score.
	 *
	 * @return the organization feedback score
	 */
	public double getOrganizationFeedbackScore() {
		return organizationFeedbackScore;
	}

	/**
	 * Sets the organization feedback score.
	 *
	 * @param organizationFeedbackScore the new organization feedback score
	 */
	public void setOrganizationFeedbackScore(double organizationFeedbackScore) {
		this.organizationFeedbackScore = organizationFeedbackScore;
	}

	/**
	 * Gets the target author name feedback score.
	 *
	 * @return the target author name feedback score
	 */
	public double getTargetAuthorNameFeedbackScore() {
		return targetAuthorNameFeedbackScore;
	}

	/**
	 * Sets the target author name feedback score.
	 *
	 * @param targetAuthorNameFeedbackScore the new target author name feedback score
	 */
	public void setTargetAuthorNameFeedbackScore(double targetAuthorNameFeedbackScore) {
		this.targetAuthorNameFeedbackScore = targetAuthorNameFeedbackScore;
	}

	/**
	 * Gets the year feedback score.
	 *
	 * @return the year feedback score
	 */
	public double getYearFeedbackScore() {
		return yearFeedbackScore;
	}

	/**
	 * Sets the year feedback score.
	 *
	 * @param yearFeedbackScore the new year feedback score
	 */
	public void setYearFeedbackScore(double yearFeedbackScore) {
		this.yearFeedbackScore = yearFeedbackScore;
	}

	/**
	 * Gets the journal feedack score.
	 *
	 * @return the journal feedack score
	 */
	public double getJournalFeedackScore() {
		return journalFeedackScore;
	}

	/**
	 * Sets the journal feedack score.
	 *
	 * @param journalFeedackScore the new journal feedack score
	 */
	public void setJournalFeedackScore(double journalFeedackScore) {
		this.journalFeedackScore = journalFeedackScore;
	}

	/**
	 * Gets the exported co author name feedback score.
	 *
	 * @return the exported co author name feedback score
	 */
	public String getExportedCoAuthorNameFeedbackScore() {
		return exportedCoAuthorNameFeedbackScore;
	}

	/**
	 * Sets the exported co author name feedback score.
	 *
	 * @param exportedCoAuthorNameFeedbackScore the new exported co author name feedback score
	 */
	public void setExportedCoAuthorNameFeedbackScore(String exportedCoAuthorNameFeedbackScore) {
		this.exportedCoAuthorNameFeedbackScore = exportedCoAuthorNameFeedbackScore;
	}

	/**
	 * Gets the exported keyword feedack score.
	 *
	 * @return the exported keyword feedack score
	 */
	public String getExportedKeywordFeedackScore() {
		return exportedKeywordFeedackScore;
	}

	/**
	 * Sets the exported keyword feedack score.
	 *
	 * @param exportedKeywordFeedackScore the new exported keyword feedack score
	 */
	public void setExportedKeywordFeedackScore(String exportedKeywordFeedackScore) {
		this.exportedKeywordFeedackScore = exportedKeywordFeedackScore;
	}

	/**
	 * Gets the exported journal feedack score.
	 *
	 * @return the exported journal feedack score
	 */
	public String getExportedJournalFeedackScore() {
		return exportedJournalFeedackScore;
	}

	/**
	 * Sets the exported journal feedack score.
	 *
	 * @param exportedJournalFeedackScore the new exported journal feedack score
	 */
	public void setExportedJournalFeedackScore(String exportedJournalFeedackScore) {
		this.exportedJournalFeedackScore = exportedJournalFeedackScore;
	}

	/**
	 * Gets the exported journal domain feedback score.
	 *
	 * @return the exported journal domain feedback score
	 */
	public String getExportedJournalDomainFeedbackScore() {
		return exportedJournalDomainFeedbackScore;
	}

	/**
	 * Sets the exported journal domain feedback score.
	 *
	 * @param exportedJournalDomainFeedbackScore the new exported journal domain feedback score
	 */
	public void setExportedJournalDomainFeedbackScore(String exportedJournalDomainFeedbackScore) {
		this.exportedJournalDomainFeedbackScore = exportedJournalDomainFeedbackScore;
	}

	/**
	 * Gets the exported journal field feedback score.
	 *
	 * @return the exported journal field feedback score
	 */
	public String getExportedJournalFieldFeedbackScore() {
		return exportedJournalFieldFeedbackScore;
	}

	/**
	 * Sets the exported journal field feedback score.
	 *
	 * @param exportedJournalFieldFeedbackScore the new exported journal field feedback score
	 */
	public void setExportedJournalFieldFeedbackScore(String exportedJournalFieldFeedbackScore) {
		this.exportedJournalFieldFeedbackScore = exportedJournalFieldFeedbackScore;
	}

	/**
	 * Gets the exported journal sub field feedback score.
	 *
	 * @return the exported journal sub field feedback score
	 */
	public String getExportedJournalSubFieldFeedbackScore() {
		return exportedJournalSubFieldFeedbackScore;
	}

	/**
	 * Sets the exported journal sub field feedback score.
	 *
	 * @param exportedJournalSubFieldFeedbackScore the new exported journal sub field feedback score
	 */
	public void setExportedJournalSubFieldFeedbackScore(String exportedJournalSubFieldFeedbackScore) {
		this.exportedJournalSubFieldFeedbackScore = exportedJournalSubFieldFeedbackScore;
	}

	/**
	 * Gets the exported orcid feedback score.
	 *
	 * @return the exported orcid feedback score
	 */
	public String getExportedOrcidFeedbackScore() {
		return exportedOrcidFeedbackScore;
	}

	/**
	 * Sets the exported orcid feedback score.
	 *
	 * @param exportedOrcidFeedbackScore the new exported orcid feedback score
	 */
	public void setExportedOrcidFeedbackScore(String exportedOrcidFeedbackScore) {
		this.exportedOrcidFeedbackScore = exportedOrcidFeedbackScore;
	}

	/**
	 * Gets the exported orcid co author feedback score.
	 *
	 * @return the exported orcid co author feedback score
	 */
	public String getExportedOrcidCoAuthorFeedbackScore() {
		return exportedOrcidCoAuthorFeedbackScore;
	}

	/**
	 * Sets the exported orcid co author feedback score.
	 *
	 * @param exportedOrcidCoAuthorFeedbackScore the new exported orcid co author feedback score
	 */
	public void setExportedOrcidCoAuthorFeedbackScore(String exportedOrcidCoAuthorFeedbackScore) {
		this.exportedOrcidCoAuthorFeedbackScore = exportedOrcidCoAuthorFeedbackScore;
	}

	/**
	 * Gets the exported cites feedback score.
	 *
	 * @return the exported cites feedback score
	 */
	public String getExportedCitesFeedbackScore() {
		return exportedCitesFeedbackScore;
	}

	/**
	 * Sets the exported cites feedback score.
	 *
	 * @param exportedCitesFeedbackScore the new exported cites feedback score
	 */
	public void setExportedCitesFeedbackScore(String exportedCitesFeedbackScore) {
		this.exportedCitesFeedbackScore = exportedCitesFeedbackScore;
	}

	/**
	 * Gets the exported email feedback score.
	 *
	 * @return the exported email feedback score
	 */
	public String getExportedEmailFeedbackScore() {
		return exportedEmailFeedbackScore;
	}

	/**
	 * Sets the exported email feedback score.
	 *
	 * @param exportedEmailFeedbackScore the new exported email feedback score
	 */
	public void setExportedEmailFeedbackScore(String exportedEmailFeedbackScore) {
		this.exportedEmailFeedbackScore = exportedEmailFeedbackScore;
	}

	/**
	 * Gets the exported institution feedback score.
	 *
	 * @return the exported institution feedback score
	 */
	public String getExportedInstitutionFeedbackScore() {
		return exportedInstitutionFeedbackScore;
	}

	/**
	 * Sets the exported institution feedback score.
	 *
	 * @param exportedInstitutionFeedbackScore the new exported institution feedback score
	 */
	public void setExportedInstitutionFeedbackScore(String exportedInstitutionFeedbackScore) {
		this.exportedInstitutionFeedbackScore = exportedInstitutionFeedbackScore;
	}

	/**
	 * Gets the exported organization feedback score.
	 *
	 * @return the exported organization feedback score
	 */
	public String getExportedOrganizationFeedbackScore() {
		return exportedOrganizationFeedbackScore;
	}

	/**
	 * Sets the exported organization feedback score.
	 *
	 * @param exportedOrganizationFeedbackScore the new exported organization feedback score
	 */
	public void setExportedOrganizationFeedbackScore(String exportedOrganizationFeedbackScore) {
		this.exportedOrganizationFeedbackScore = exportedOrganizationFeedbackScore;
	}

	/**
	 * Gets the exported target author name feedback score.
	 *
	 * @return the exported target author name feedback score
	 */
	public String getExportedTargetAuthorNameFeedbackScore() {
		return exportedTargetAuthorNameFeedbackScore;
	}

	/**
	 * Sets the exported target author name feedback score.
	 *
	 * @param exportedTargetAuthorNameFeedbackScore the new exported target author name feedback score
	 */
	public void setExportedTargetAuthorNameFeedbackScore(String exportedTargetAuthorNameFeedbackScore) {
		this.exportedTargetAuthorNameFeedbackScore = exportedTargetAuthorNameFeedbackScore;
	}

	/**
	 * Gets the exported year feedback score.
	 *
	 * @return the exported year feedback score
	 */
	public String getExportedYearFeedbackScore() {
		return exportedYearFeedbackScore;
	}

	/**
	 * Sets the exported year feedback score.
	 *
	 * @param exportedYearFeedbackScore the new exported year feedback score
	 */
	public void setExportedYearFeedbackScore(String exportedYearFeedbackScore) {
		this.exportedYearFeedbackScore = exportedYearFeedbackScore;
	}

	/**
	 * Gets the article feedback scores map.
	 *
	 * @return the article feedback scores map
	 */
	public List<Map<String,List<ReCiterArticleFeedbackScore>>> getArticleFeedbackScoresMap() {
		return articleFeedbackScoresMapList;
	}

	/**
	 * Adds the article feedback scores map.
	 *
	 * @param articleFeedbackScoresMapList the article feedback scores map list
	 */
	public void addArticleFeedbackScoresMap(Map<String, List<ReCiterArticleFeedbackScore>> articleFeedbackScoresMapList) {
		this.articleFeedbackScoresMapList.add(articleFeedbackScoresMapList); 
	
	}

	/**
	 * Gets the feedback evidence.
	 *
	 * @return the feedback evidence
	 */
	public FeedbackEvidence getFeedbackEvidence() {
		return feedbackEvidence;
	}

	/**
	 * Sets the feedback evidence.
	 *
	 * @param feedbackEvidence the new feedback evidence
	 */
	public void setFeedbackEvidence(FeedbackEvidence feedbackEvidence) {
		this.feedbackEvidence = feedbackEvidence;
	}
	
	/**
	 * Gets the feedback total score.
	 *
	 * @return the feedback total score
	 */
	public double getFeedbackTotalScore() {
		return feedbackTotalScore;
	}

	/**
	 * Sets the feedback total score.
	 *
	 * @param feedbackTotalScore the new feedback total score
	 */
	public void setFeedbackTotalScore(double feedbackTotalScore) {
		this.feedbackTotalScore = feedbackTotalScore;
	}

	/**
	 * Gets the authorship likelihood score.
	 *
	 * @return the authorship likelihood score
	 */
	public double getAuthorshipLikelihoodScore() {
		return authorshipLikelihoodScore;
	}

	/**
	 * Sets the authorship likelihood score.
	 *
	 * @param authorshipLikelihoodScore the new authorship likelihood score
	 */
	public void setAuthorshipLikelihoodScore(double authorshipLikelihoodScore) {
		this.authorshipLikelihoodScore = authorshipLikelihoodScore;
	}

	/**
	 * Gets the author count evidence.
	 *
	 * @return the author count evidence
	 */
	public AuthorCountEvidence getAuthorCountEvidence() {
		return authorCountEvidence;
	}

	/**
	 * Sets the author count evidence.
	 *
	 * @param authorCountEvidence the new author count evidence
	 */
	public void setAuthorCountEvidence(AuthorCountEvidence authorCountEvidence) {
		this.authorCountEvidence = authorCountEvidence;
	}

	/**
	 * Gets the target author count.
	 *
	 * @return the target author count
	 */
	public long getTargetAuthorCount() {
		return targetAuthorCount;
	}

	/**
	 * Sets the target author count.
	 *
	 * @param targetAuthorCount the new target author count
	 */
	public void setTargetAuthorCount(long targetAuthorCount) {
		this.targetAuthorCount = targetAuthorCount;
	}

	/**
	 * Gets the target author count penalty.
	 *
	 * @return the target author count penalty
	 */
	public double getTargetAuthorCountPenalty() {
		return targetAuthorCountPenalty;
	}

	/**
	 * Sets the target author count penalty.
	 *
	 * @param targetAuthorCountPenalty the new target author count penalty
	 */
	public void setTargetAuthorCountPenalty(double targetAuthorCountPenalty) {
		this.targetAuthorCountPenalty = targetAuthorCountPenalty;
	}
}
