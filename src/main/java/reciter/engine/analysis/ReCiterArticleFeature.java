package reciter.engine.analysis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.engine.analysis.evidence.Evidence;
import reciter.model.pubmed.MedlineCitationJournalISSN;
import reciter.model.typeconverter.KeywordTypeConverter;
import reciter.model.typeconverter.PublicationFeedbackTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

/**
* Represents detailed features of a ReCiter article, including metadata, author information,
* citation details, and associated evidence.
* @author ved4006
*/

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterArticleFeature {
	
	/** The pmid. */
	private long pmid;
    
    /** The user assertion. */
    private PublicationFeedback userAssertion;
    
    /** The authorship likelihood score. */
    private double authorshipLikelihoodScore;
    
    /** The pmcid. */
    private String pmcid;
    
    /** The publication date display. */
    private String publicationDateDisplay;
    
    /** The publication date standardized. */
    private String publicationDateStandardized;
    
    /** The date publication added to entrez. */
    private String datePublicationAddedToEntrez;
    
    /** The doi. */
    private String doi;
    
    /** The publication type. */
    private ReCiterArticlePublicationType publicationType;
    
    /** The times cited. */
    private Long timesCited;
    
    /** The publication abstract. */
    private String publicationAbstract;
    
    /** The article keywords. */
    private List<ReCiterArticleFeature.ArticleKeyword> articleKeywords;
    
    /** The re citer cluster. */
    private ReCiterFeatureCluster reCiterCluster;
    
    /** The scopus doc ID. */
    private String scopusDocID;
    
    /** The journal title verbose. */
    private String journalTitleVerbose;
    
    /** The issn. */
    private List<MedlineCitationJournalISSN> issn;
    
    /** The journal title IS oabbreviation. */
    private String journalTitleISOabbreviation;
    
    /** The article title. */
    private String articleTitle;
    
    /** The re citer article author features. */
    private List<ReCiterArticleAuthorFeature> reCiterArticleAuthorFeatures;
    
    /** The volume. */
    private String volume;
    
    /** The issue. */
    private String issue;
    
    /** The pages. */
    private String pages;
    
    /** The evidence. */
    private Evidence evidence;
    
    /**
     * Gets the user assertion.
     *
     * @return the user assertion
     */
    @DynamoDbConvertedBy(PublicationFeedbackTypeConverter.class)
    public PublicationFeedback getUserAssertion() {
		return userAssertion;
	}
    
    
    /**
     * The Class ArticleKeyword.
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @DynamoDbBean
    public static class ArticleKeyword {
      
      /** The keyword. */
      private String keyword;
      
      /** The type. */
      private KeywordType type;
      
      /** The count. */
      private Long count;
      
	  /**
  	 * Gets the type.
  	 *
  	 * @return the type
  	 */
  	@DynamoDbConvertedBy(KeywordTypeConverter.class)
      public KeywordType getType() {
		return type;
	}

	/**
	 * The Enum KeywordType.
	 */
	public enum KeywordType {
        
        /** The mesh major type. */
        MESH_MAJOR 
      }

    }
    
    /**
     * The Enum PublicationFeedback.
     */
    public enum PublicationFeedback {
		
		/** The accepted.
		 * This publication is in the gold standard */
		ACCEPTED, 
       /** The rejected. 
        * This publications was rejected */
		REJECTED, 
      /** The null.
       * No Action */
		NULL
	}
}
