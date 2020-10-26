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
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.data.annotation.Transient;

import reciter.engine.analysis.evidence.AcceptedRejectedEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.ArticleCountEvidence;
import reciter.engine.analysis.evidence.AuthorNameEvidence;
import reciter.engine.analysis.evidence.AverageClusteringEvidence;
import reciter.engine.analysis.evidence.ClusteringEvidence;
import reciter.engine.analysis.evidence.EducationYearEvidence;
import reciter.engine.analysis.evidence.EmailEvidence;
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
    
    /**
     * Populate features of a article based on journal title and meshMajor and co-authors
     */
    private ReCiterArticleFeatures reCiterArticleFeatures;

    /**
     * Scopus Article.
     */
    @Transient
    private ScopusArticle scopusArticle;

    /**
     * Grant List.

     */
    private List<ReCiterArticleGrant> grantList;
    private List<ReCiterArticleGrant> matchingGrantList = new ArrayList<>(0);

    private boolean shouldRemoveValue;
    private boolean foundAuthorWithSameFirstNameValue;
    private boolean foundMatchingAuthorValue;

    /**
     * Text containing how it's clustered.
     */
    @Transient
    private String clusterInfo = "";
    
    private double totalArticleScoreWithoutClustering;
    private double totalArticleScoreNonStandardized;
    private double totalArticleScoreStandardized;

    public double getTotalArticleScoreStandardized() {
		return totalArticleScoreStandardized;
	}

	public void setTotalArticleScoreStandardized(double totalArticleScoreStandardized) {
		this.totalArticleScoreStandardized = totalArticleScoreStandardized;
	}

	public RelationshipEvidence getRelationshipEvidences() {
		return relationshipEvidences;
	}

	public void setRelationshipEvidences(RelationshipEvidence relationshipEvidences) {
		this.relationshipEvidences = relationshipEvidences;
	}

	public double getTotalArticleScoreNonStandardized() {
		return totalArticleScoreNonStandardized;
	}

	public void setTotalArticleScoreNonStandardized(double totalArticleScoreNonStandardized) {
		this.totalArticleScoreNonStandardized = totalArticleScoreNonStandardized;
	}

	private double emailStrategyScore;
    private List<String> matchingEmails = new ArrayList<>(0);
    private double departmentStrategyScore;
    private String matchingDepartment;
    
    private List<String> publicationTypePubmed;
    private ReCiterPublicationTypeScopus publicationTypeScopus;
    private String publicationTypeCanonical;
    private Long timesCited;
    private String publicationAbstract;
    private String scopusDocId;
    

    private double knownCoinvestigatorScore;
    private List<KnownRelationship> knownRelationship = new ArrayList<>(0);
    private double affiliationScore;
    private double scopusStrategyScore;
    private double coauthorStrategyScore;
    private double journalStrategyScore;
    private double citizenshipStrategyScore;

    private double nameStrategyScore;
    private double boardCertificationStrategyScore;
    private double internshipAndResidenceStrategyScore;
    private double bachelorsYearDiscrepancyScore;
    private double doctoralYearDiscrepancyScore;
    private int bachelorsYearDiscrepancy;
    private String publishedPriorAcademicDegreeBachelors;
    private int doctoralYearDiscrepancy;
    private String publishedPriorAcademicDegreeDoctoral;
    private boolean isArticleTitleStartWithBracket;
    private double educationStrategyScore;
    private double meshMajorStrategyScore;
    private Set<String> overlappingMeSHMajorNegativeArticles = new HashSet<>();

    private int goldStandard;
    private Set<Long> commentsCorrectionsPmids = new HashSet<>();
    private List<ReCiterArticleMeshHeading> meshHeadings = new ArrayList<>();

    private List<ReCiterAuthor> knownRelationships = new ArrayList<>();
    private List<String> frequentInstitutionalCollaborators = new ArrayList<>();

    private List<Long> citations = new ArrayList<>();
    private AuthorName matchingName;

    private List<CoCitation> coCitation = new ArrayList<>();

    private int correctAuthorRank;
    private int numAuthors;
    private ReCiterJournalCategory journalCategory;

    private StringBuilder meshMajorInfo;
    private StringBuilder citesInfo;
    private StringBuilder citedByInfo;
    private StringBuilder coCitationInfo;
    private StringBuilder journalTitleInfo;

    private String publicationDateStandardized;
    
    private String datePublicationAddedToEntrez;
    
    private String publicationDateDisplay;
    
    
    private List<OrganizationalUnitEvidence> organizationalUnitEvidences;
    private EducationYearEvidence educationYearEvidence;
    private AffiliationEvidence affiliationEvidence;
    private GrantEvidence grantEvidence;
    private AuthorNameEvidence authorNameEvidence;
    
    private JournalCategoryEvidence journalCategoryEvidence;
    private EmailEvidence emailEvidence;
    
    private AcceptedRejectedEvidence acceptedRejectedEvidence;
    private ArticleCountEvidence articleCountEvidence;
    private PersonTypeEvidence personTypeEvidence;
    private AverageClusteringEvidence averageClusteringEvidence;
    private GenderEvidence genderEvidence;

    public AverageClusteringEvidence getAverageClusteringEvidence() {
		return averageClusteringEvidence;
	}

	public void setAverageClusteringEvidence(AverageClusteringEvidence averageClusteringEvidence) {
		this.averageClusteringEvidence = averageClusteringEvidence;
	}

	private RelationshipEvidence relationshipEvidences;

    private String volume;
    private String issue;
    private String pmcid;
    private String pages;
    private String doi;

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public ReCiterJournalCategory getJournalCategory() {
        return journalCategory;
    }

    public void setJournalCategory(ReCiterJournalCategory journalCategory) {
        this.journalCategory = journalCategory;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPmcid() {
        return pmcid;
    }

    public void setPmcid(String pmcid) {
        this.pmcid = pmcid;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public ClusteringEvidence getClusteringEvidence() {
        return clusteringEvidence;
    }

    public void setClusteringEvidence(ClusteringEvidence clusteringEvidence) {
        this.clusteringEvidence = clusteringEvidence;
    }

    private ClusteringEvidence clusteringEvidence = new ClusteringEvidence();

    public EducationYearEvidence getEducationYearEvidence() {
        return educationYearEvidence;
    }

    public void setEducationYearEvidence(EducationYearEvidence educationYearEvidence) {
        this.educationYearEvidence = educationYearEvidence;
    }

    public RelationshipEvidence getRelationshipEvidence() {
        return relationshipEvidences;
    }

    public void setRelationshipEvidence(RelationshipEvidence relationshipEvidences) {
        this.relationshipEvidences = relationshipEvidences;
    }

    public GrantEvidence getGrantEvidence() {
        return grantEvidence;
    }

    public void setGrantEvidence(GrantEvidence grantEvidence) {
        this.grantEvidence = grantEvidence;
    }


    public AffiliationEvidence getAffiliationEvidence() {
        return affiliationEvidence;
    }

    public void setAffiliationEvidence(AffiliationEvidence affiliationEvidence) {
        this.affiliationEvidence = affiliationEvidence;
    }

    public AuthorNameEvidence getAuthorNameEvidence() {
		return authorNameEvidence;
	}

	public void setAuthorNameEvidence(AuthorNameEvidence authorNameEvidence) {
		this.authorNameEvidence = authorNameEvidence;
	}

    public String getPublicationDateStandardized() {
		return publicationDateStandardized;
	}

	public void setPublicationDateStandardized(String publicationDateStandardized) {
		this.publicationDateStandardized = publicationDateStandardized;
	}

	public String getDatePublicationAddedToEntrez() {
		return datePublicationAddedToEntrez;
	}

	public void setDatePublicationAddedToEntrez(String datePublicationAddedToEntrez) {
		this.datePublicationAddedToEntrez = datePublicationAddedToEntrez;
	}

	public String getPublicationDateDisplay() {
		return publicationDateDisplay;
	}

	public void setPublicationDateDisplay(String publicationDateDisplay) {
		this.publicationDateDisplay = publicationDateDisplay;
	}

	public StringBuilder getMeshMajorInfo() {
        if (meshMajorInfo == null) {
            meshMajorInfo = new StringBuilder();
        }
        return meshMajorInfo;
    }

    public void setMeshMajorInfo(StringBuilder meshMajorInfo) {
        this.meshMajorInfo = meshMajorInfo;
    }

    public StringBuilder getCitesInfo() {
        if (citesInfo == null) {
            citesInfo = new StringBuilder();
        }
        return citesInfo;
    }

    public void setCitesInfo(StringBuilder citesInfo) {
        this.citesInfo = citesInfo;
    }

    public StringBuilder getCitedByInfo() {
        if (citedByInfo == null) {
            citedByInfo = new StringBuilder();
        }
        return citedByInfo;
    }

    public void setCitedByInfo(StringBuilder citedByInfo) {
        this.citedByInfo = citedByInfo;
    }

    public StringBuilder getCoCitationInfo() {
        if (coCitationInfo == null) {
            coCitationInfo = new StringBuilder();
        }
        return coCitationInfo;
    }
    
    public double getGrantEvidenceTotalScore() {
    	if(this.grantEvidence == null) {
    		return 0;
    	}
    	return this.grantEvidence.getGrants().stream().mapToDouble(Grant::getGrantMatchScore).sum();
    }
    
    public double getRelationshipEvidencesTotalScore() {
    	return 0;
    }
    
    
    
    public JournalCategoryEvidence getJournalCategoryEvidence() {
		return journalCategoryEvidence;
	}

	public void setJournalCategoryEvidence(JournalCategoryEvidence journalCategoryEvidence) {
		this.journalCategoryEvidence = journalCategoryEvidence;
	}

	public double getOrganizationalEvidencesTotalScore() {
    	if(this.organizationalUnitEvidences == null) {
    		return 0;
    	}
    	return this.organizationalUnitEvidences.stream().mapToDouble(organizationalUnitEvidence -> organizationalUnitEvidence.getOrganizationalUnitMatchingScore() +
    			organizationalUnitEvidence.getOrganizationalUnitModifierScore()).sum();
    }

    public void setCoCitationInfo(StringBuilder coCitationInfo) {
        this.coCitationInfo = coCitationInfo;
    }

    public StringBuilder getJournalTitleInfo() {
        if (journalTitleInfo == null) {
            journalTitleInfo = new StringBuilder();
        }
        return journalTitleInfo;
    }

    public void setJournalTitleInfo(StringBuilder journalTitleInfo) {
        this.journalTitleInfo = journalTitleInfo;
    }

    public void setEducationStrategyScore(double educationStrategyScore) {
        this.educationStrategyScore = educationStrategyScore;
    }

    public static class CoCitation {
        private long pmid;
        private List<Long> pmids;

        public long getPmid() {
            return pmid;
        }

        public void setPmid(long pmid) {
            this.pmid = pmid;
        }

        public List<Long> getPmids() {
            return pmids;
        }

        public void setPmids(List<Long> pmids) {
            this.pmids = pmids;
        }
    }
    
    @JsonCreator
    public ReCiterArticle(long articleId) {
        this.articleId = articleId;
    }

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

    public long getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public ReCiterArticleAuthors getArticleCoAuthors() {
        return articleCoAuthors;
    }

    public void setArticleCoAuthors(ReCiterArticleAuthors articleCoAuthors) {
        this.articleCoAuthors = articleCoAuthors;
    }

    public ReCiterJournal getJournal() {
        return journal;
    }

    public void setJournal(ReCiterJournal journal) {
        this.journal = journal;
    }

    public ReCiterArticleKeywords getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(ReCiterArticleKeywords articleKeywords) {
        this.articleKeywords = articleKeywords;
    }

    public double getCompletenessScore() {
        return completenessScore;
    }

    public void setCompletenessScore(double completenessScore) {
        this.completenessScore = completenessScore;
    }

    public ScopusArticle getScopusArticle() {
        return scopusArticle;
    }

    public void setScopusArticle(ScopusArticle scopusArticle) {
        this.scopusArticle = scopusArticle;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (articleId ^ (articleId >>> 32));
        return result;
    }

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

    public String getClusterInfo() {
        return clusterInfo;
    }

    public void setClusterInfo(String clusterInfo) {
        this.clusterInfo = clusterInfo;
    }

    public void appendClusterInfo(String clusterInfo) {
        this.clusterInfo += " | " + clusterInfo;
    }

    public double getEmailStrategyScore() {
        return emailStrategyScore;
    }

    public void setEmailStrategyScore(double emailStrategyScore) {
        this.emailStrategyScore = emailStrategyScore;
    }

    public double getDepartmentStrategyScore() {
        return departmentStrategyScore;
    }

    public void setDepartmentStrategyScore(double departmentStrategyScore) {
        this.departmentStrategyScore = departmentStrategyScore;
    }

    public double getKnownCoinvestigatorScore() {
        return knownCoinvestigatorScore;
    }

    public void setKnownCoinvestigatorScore(double knownCoinvestigatorScore) {
        this.knownCoinvestigatorScore = knownCoinvestigatorScore;
    }

    public double getAffiliationScore() {
        return affiliationScore;
    }

    public void setAffiliationScore(double affiliationScore) {
        this.affiliationScore = affiliationScore;
    }

    public double getScopusStrategyScore() {
        return scopusStrategyScore;
    }

    public void setScopusStrategyScore(double scopusStrategyScore) {
        this.scopusStrategyScore = scopusStrategyScore;
    }

    public double getCoauthorStrategyScore() {
        return coauthorStrategyScore;
    }

    public void setCoauthorStrategyScore(double coauthorStrategyScore) {
        this.coauthorStrategyScore = coauthorStrategyScore;
    }

    public double getJournalStrategyScore() {
        return journalStrategyScore;
    }

    public void setJournalStrategyScore(double journalStrategyScore) {
        this.journalStrategyScore = journalStrategyScore;
    }

    public double getCitizenshipStrategyScore() {
        return citizenshipStrategyScore;
    }

    public void setCitizenshipStrategyScore(double citizenshipStrategyScore) {
        this.citizenshipStrategyScore = citizenshipStrategyScore;
    }

    public double getNameStrategyScore() {
        return nameStrategyScore;
    }

    public void setNameStrategyScore(double nameStrategyScore) {
        this.nameStrategyScore = nameStrategyScore;
    }

    public double getBoardCertificationStrategyScore() {
        return boardCertificationStrategyScore;
    }

    public void setBoardCertificationStrategyScore(double boardCertificationStrategyScore) {
        this.boardCertificationStrategyScore = boardCertificationStrategyScore;
    }

    public double getInternshipAndResidenceStrategyScore() {
        return internshipAndResidenceStrategyScore;
    }

    public void setInternshipAndResidenceStrategyScore(double internshipAndResidenceStrategyScore) {
        this.internshipAndResidenceStrategyScore = internshipAndResidenceStrategyScore;
    }

    public int getGoldStandard() {
        return goldStandard;
    }

    public void setGoldStandard(int goldStandard) {
        this.goldStandard = goldStandard;
    }

    public List<ReCiterArticleGrant> getGrantList() {
        return grantList;
    }

    public void setGrantList(List<ReCiterArticleGrant> grantList) {
        this.grantList = grantList;
    }

    public double getBachelorsYearDiscrepancyScore() {
        return bachelorsYearDiscrepancyScore;
    }

    public void setBachelorsYearDiscrepancyScore(double bachelorsYearDiscrepancyScore) {
        this.bachelorsYearDiscrepancyScore = bachelorsYearDiscrepancyScore;
    }

    public double getDoctoralYearDiscrepancyScore() {
        return doctoralYearDiscrepancyScore;
    }

    public void setDoctoralYearDiscrepancyScore(double doctoralYearDiscrepancyScore) {
        this.doctoralYearDiscrepancyScore = doctoralYearDiscrepancyScore;
    }

    public boolean isArticleTitleStartWithBracket() {
        return isArticleTitleStartWithBracket;
    }

    public void setArticleTitleStartWithBracket(boolean isArticleTitleStartWithBracket) {
        this.isArticleTitleStartWithBracket = isArticleTitleStartWithBracket;
    }

    public double getEducationStrategyScore() {
        return educationStrategyScore;
    }

    public void setEducationScore(double educationStrategyScore) {
        this.educationStrategyScore = educationStrategyScore;
    }

    public Set<Long> getCommentsCorrectionsPmids() {
        return commentsCorrectionsPmids;
    }

    public void setCommentsCorrectionsPmids(Set<Long> commentsCorrectionsPmids) {
        this.commentsCorrectionsPmids = commentsCorrectionsPmids;
    }

    public List<ReCiterArticleMeshHeading> getMeshHeadings() {
        return meshHeadings;
    }

    public void setMeshHeadings(List<ReCiterArticleMeshHeading> meshHeadings) {
        this.meshHeadings = meshHeadings;
    }

    public int getBachelorsYearDiscrepancy() {
        return bachelorsYearDiscrepancy;
    }

    public void setBachelorsYearDiscrepancy(int bachelorsYearDiscrepancy) {
        this.bachelorsYearDiscrepancy = bachelorsYearDiscrepancy;
    }

    public int getDoctoralYearDiscrepancy() {
        return doctoralYearDiscrepancy;
    }

    public void setDoctoralYearDiscrepancy(int doctoralYearDiscrepancy) {
        this.doctoralYearDiscrepancy = doctoralYearDiscrepancy;
    }

    public boolean isShouldRemoveValue() {
        return shouldRemoveValue;
    }

    public void setShouldRemoveValue(boolean shouldRemoveValue) {
        this.shouldRemoveValue = shouldRemoveValue;
    }

    public boolean isFoundAuthorWithSameFirstNameValue() {
        return foundAuthorWithSameFirstNameValue;
    }

    public void setFoundAuthorWithSameFirstNameValue(boolean foundAuthorWithSameFirstNameValue) {
        this.foundAuthorWithSameFirstNameValue = foundAuthorWithSameFirstNameValue;
    }

    public boolean isFoundMatchingAuthorValue() {
        return foundMatchingAuthorValue;
    }

    public void setFoundMatchingAuthorValue(boolean foundMatchingAuthorValue) {
        this.foundMatchingAuthorValue = foundMatchingAuthorValue;
    }

    public List<ReCiterAuthor> getKnownRelationships() {
        return knownRelationships;
    }

    public void setKnownRelationships(List<ReCiterAuthor> knownRelationships) {
        this.knownRelationships = knownRelationships;
    }

    public List<String> getFrequentInstitutionalCollaborators() {
        return frequentInstitutionalCollaborators;
    }

    public void setFrequentInstitutionalCollaborators(List<String> frequentInstitutionalCollaborators) {
        this.frequentInstitutionalCollaborators = frequentInstitutionalCollaborators;
    }

    public double getMeshMajorStrategyScore() {
        return meshMajorStrategyScore;
    }

    public void setMeshMajorStrategyScore(double meshMajorStrategyScore) {
        this.meshMajorStrategyScore = meshMajorStrategyScore;
    }

    public Set<String> getOverlappingMeSHMajorNegativeArticles() {
        return overlappingMeSHMajorNegativeArticles;
    }

    public void setOverlappingMeSHMajorNegativeArticles(Set<String> overlappingMeSHMajorNegativeArticles) {
        this.overlappingMeSHMajorNegativeArticles = overlappingMeSHMajorNegativeArticles;
    }

    public AuthorName getMatchingName() {
        return matchingName;
    }

    public void setMatchingName(AuthorName matchingName) {
        this.matchingName = matchingName;
    }

    public List<Long> getCitations() {
        return citations;
    }

    public void setCitations(List<Long> citations) {
        this.citations = citations;
    }

    public List<CoCitation> getCoCitation() {
        return coCitation;
    }

    public void setCoCitation(List<CoCitation> coCitation) {
        this.coCitation = coCitation;
    }

    public int getCorrectAuthorRank() {
        return correctAuthorRank;
    }

    public void setCorrectAuthorRank(int correctAuthorRank) {
        this.correctAuthorRank = correctAuthorRank;
    }

    public int getNumAuthors() {
        return numAuthors;
    }

    public void setNumAuthors(int numAuthors) {
        this.numAuthors = numAuthors;
    }

    public String getMatchingDepartment() {
        return matchingDepartment;
    }

    public void setMatchingDepartment(String matchingDepartment) {
        this.matchingDepartment = matchingDepartment;
    }

    public List<KnownRelationship> getKnownRelationship() {
        return knownRelationship;
    }

    public void setKnownRelationship(List<KnownRelationship> knownRelationship) {
        this.knownRelationship = knownRelationship;
    }

    public List<ReCiterArticleGrant> getMatchingGrantList() {
        return matchingGrantList;
    }

    public void setMatchingGrantList(List<ReCiterArticleGrant> matchingGrantList) {
        this.matchingGrantList = matchingGrantList;
    }

    public List<String> getMatchingEmails() {
        return matchingEmails;
    }

    public void setMatchingEmails(List<String> matchingEmails) {
        this.matchingEmails = matchingEmails;
    }

    public String getPublishedPriorAcademicDegreeBachelors() {
        return publishedPriorAcademicDegreeBachelors;
    }

    public void setPublishedPriorAcademicDegreeBachelors(String publishedPriorAcademicDegreeBachelors) {
        this.publishedPriorAcademicDegreeBachelors = publishedPriorAcademicDegreeBachelors;
    }

    public String getPublishedPriorAcademicDegreeDoctoral() {
        return publishedPriorAcademicDegreeDoctoral;
    }

    public void setPublishedPriorAcademicDegreeDoctoral(String publishedPriorAcademicDegreeDoctoral) {
        this.publishedPriorAcademicDegreeDoctoral = publishedPriorAcademicDegreeDoctoral;
    }

	public ReCiterArticleFeatures getReCiterArticleFeatures() {
		return reCiterArticleFeatures;
	}

	public void setReCiterArticleFeatures(ReCiterArticleFeatures reCiterArticleFeatures) {
		this.reCiterArticleFeatures = reCiterArticleFeatures;
	}

	public EmailEvidence getEmailEvidence() {
		return emailEvidence;
	}

	public void setEmailEvidence(EmailEvidence emailEvidence) {
		this.emailEvidence = emailEvidence;
	}

	public ArticleCountEvidence getArticleCountEvidence() {
		return articleCountEvidence;
	}

	public void setArticleCountEvidence(ArticleCountEvidence articleCountEvidence) {
		this.articleCountEvidence = articleCountEvidence;
	}

	public PersonTypeEvidence getPersonTypeEvidence() {
		return personTypeEvidence;
	}

	public void setPersonTypeEvidence(PersonTypeEvidence personTypeEvidence) {
		this.personTypeEvidence = personTypeEvidence;
	}

	public List<OrganizationalUnitEvidence> getOrganizationalUnitEvidences() {
		return organizationalUnitEvidences;
	}

	public void setOrganizationalUnitEvidences(List<OrganizationalUnitEvidence> organizationalEvidences) {
		this.organizationalUnitEvidences = organizationalEvidences;
	}

	public AcceptedRejectedEvidence getAcceptedRejectedEvidence() {
		return acceptedRejectedEvidence;
	}

	public void setAcceptedRejectedEvidence(AcceptedRejectedEvidence acceptedRejectedEvidence) {
		this.acceptedRejectedEvidence = acceptedRejectedEvidence;
	}

	public double getTotalArticleScoreWithoutClustering() {
		return totalArticleScoreWithoutClustering;
	}

	public void setTotalArticleScoreWithoutClustering(double totalArticleScoreWithoutClustering) {
		this.totalArticleScoreWithoutClustering = totalArticleScoreWithoutClustering;
	}

	public List<String> getPublicationTypePubmed() {
		return publicationTypePubmed;
	}

	public void setPublicationTypePubmed(List<String> publicationTypePubmed) {
		this.publicationTypePubmed = publicationTypePubmed;
	}

	public ReCiterPublicationTypeScopus getPublicationTypeScopus() {
		return publicationTypeScopus;
	}

	public void setPublicationTypeScopus(ReCiterPublicationTypeScopus publicationTypeScopus) {
		this.publicationTypeScopus = publicationTypeScopus;
	}

	public String getPublicationTypeCanonical() {
		return publicationTypeCanonical;
	}

	public void setPublicationTypeCanonical(String publicationTypeCanonical) {
		this.publicationTypeCanonical = publicationTypeCanonical;
	}

	public Long getTimesCited() {
		return timesCited;
	}

	public void setTimesCited(Long timesCited) {
		this.timesCited = timesCited;
	}

	public String getPublicationAbstract() {
		return publicationAbstract;
	}

	public void setPublicationAbstract(String publicationAbstract) {
		this.publicationAbstract = publicationAbstract;
	}

	public String getScopusDocId() {
		return scopusDocId;
	}

	public void setScopusDocId(String scopusDocId) {
		this.scopusDocId = scopusDocId;
	}

	public GenderEvidence getGenderEvidence() {
		return genderEvidence;
	}

	public void setGenderEvidence(GenderEvidence genderEvidence) {
		this.genderEvidence = genderEvidence;
	}
}
