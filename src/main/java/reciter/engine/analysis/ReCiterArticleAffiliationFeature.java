package reciter.engine.analysis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import reciter.model.typeconverter.InstitutionalAffiliationSourceTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

/**
 * This class contains affiliation statements from multiple sources.
 * @author ved4006
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@DynamoDbBean
public class ReCiterArticleAffiliationFeature {
    
    /** Affiliation Statement from Pubmed. */
    private String affiliationStatementLabel;
    
    /** Affiliation Source (PUBMED). */
    private InstitutionalAffiliationSource affiliationStatementLabelSource;
    
    /**
     * Gets the affiliation statement label source.
     *
     * @return the affiliation statement label source
     */
    @DynamoDbConvertedBy(InstitutionalAffiliationSourceTypeConverter.class)
    public InstitutionalAffiliationSource getAffiliationStatementLabelSource() {
		return affiliationStatementLabelSource;
	}

    
    /** List of affiliations for the author. */
    private List<ReCiterArticleAffiliationFeature.ReCiterArticleAffiliationInstitution> affiliationInstitutions;

    /**
     * The Class ReCiterArticleAffiliationInstitution.
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @DynamoDbBean
    public static class ReCiterArticleAffiliationInstitution {
        
        /** Affiliation Label from SCOPUS. */ 
		
		/**
         * Affiliation IDs
         */
        private Integer affiliationInstitutionId;
        
        /** Affiliation Source (SCOPUS). */
        private InstitutionalAffiliationSource affiliationInstitutionSource;
        
        /** The affiliation institution label. */
        private String affiliationInstitutionLabel;
        
        /**
         * Gets the affiliation institution source.
         *
         * @return the affiliation institution source
         */
        @DynamoDbConvertedBy(InstitutionalAffiliationSourceTypeConverter.class)
        public InstitutionalAffiliationSource getAffiliationInstitutionSource() {
			return affiliationInstitutionSource;
		}
    }
}
