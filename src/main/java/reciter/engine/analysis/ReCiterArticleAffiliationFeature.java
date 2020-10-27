package reciter.engine.analysis;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;

/**
 * This class contains affiliation statements from multiple sources
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@DynamoDBDocument
public class ReCiterArticleAffiliationFeature {
    /**
     * Affiliation Statement from Pubmed
     */
    private String affiliationStatementLabel;
    /**
     * Affiliation Source (PUBMED)
     */
    @DynamoDBTyped(DynamoDBAttributeType.S)
    private InstitutionalAffiliationSource affiliationStatementLabelSource;
    /**
     * List of affiliations for the author
     */
    private List<ReCiterArticleAffiliationInstitution> affiliationInstitutions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @DynamoDBDocument
    public class ReCiterArticleAffiliationInstitution {
        /**
         * Affiliation Label from SCOPUS
         */
        private String affiliationInstitutionLabel;
        /**
         * Affiliation IDs
         */
        private Integer affiliationInstitutionId;
        /**
         * Affiliation Source (SCOPUS)
         */
        @DynamoDBTyped(DynamoDBAttributeType.S)
        private InstitutionalAffiliationSource affiliationInstitutionSource;
    }
}
