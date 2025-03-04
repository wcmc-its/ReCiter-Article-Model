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

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterArticleFeature {
	private long pmid;
    private PublicationFeedback userAssertion;
    private double authorshipLikelihoodScore;
    private String pmcid;
    private String publicationDateDisplay;
    private String publicationDateStandardized;
    private String datePublicationAddedToEntrez;
    private String doi;
    private ReCiterArticlePublicationType publicationType;
    private Long timesCited;
    private String publicationAbstract;
    private List<ReCiterArticleFeature.ArticleKeyword> articleKeywords;
    private ReCiterFeatureCluster reCiterCluster;
    private String scopusDocID;
    private String journalTitleVerbose;
    private List<MedlineCitationJournalISSN> issn;
    private String journalTitleISOabbreviation;
    private String articleTitle;
    private List<ReCiterArticleAuthorFeature> reCiterArticleAuthorFeatures;
    private String volume;
    private String issue;
    private String pages;
    private Evidence evidence;
    
    @DynamoDbConvertedBy(PublicationFeedbackTypeConverter.class)
    public PublicationFeedback getUserAssertion() {
		return userAssertion;
	}
    
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @DynamoDbBean
    public static class ArticleKeyword {
      private String keyword;
      private KeywordType type;
      private Long count;
      
	  @DynamoDbConvertedBy(KeywordTypeConverter.class)
      public KeywordType getType() {
		return type;
	}

	public enum KeywordType {
        MESH_MAJOR //Mesh Major type
      }

    }
    
    public enum PublicationFeedback {
		ACCEPTED, // This publication is in the gold standard
		REJECTED, // This publications was rejected 
		NULL // No action
	}
}
