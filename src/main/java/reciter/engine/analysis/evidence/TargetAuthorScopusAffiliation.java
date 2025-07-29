package reciter.engine.analysis.evidence;
/**
 * Represents the Scopus affiliation information for a target author.
 * <p>
 * This class stores the institutional affiliation source, identity affiliation, article affiliation label and ID,
 * match type, and a score representing the quality of the match for the target author using Scopus data.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationMatchType;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import reciter.model.typeconverter.InstitutionalAffiliationMatchTypeConverter;
import reciter.model.typeconverter.InstitutionalAffiliationSourceTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class TargetAuthorScopusAffiliation {

    /** The source of the institutional affiliation for the target author. */
    private InstitutionalAffiliationSource targetAuthorInstitutionalAffiliationSource;

    /** The institutional affiliation of the target author from the identity record. */
    private String targetAuthorInstitutionalAffiliationIdentity;

    /** The affiliation label for the target author as stated in the Scopus article. */
    private String targetAuthorInstitutionalAffiliationArticleScopusLabel;

    /** The Scopus affiliation ID for the target author's article affiliation. */
    private int targetAuthorInstitutionalAffiliationArticleScopusAffiliationId;

    /** The match type for the institutional affiliation (e.g., "POSITIVE_MATCH_INDIVIDUAL", "POSITIVE_MATCH_INSTITUTION"). */
    private InstitutionalAffiliationMatchType targetAuthorInstitutionalAffiliationMatchType;

    /** The score representing the strength or quality of the affiliation match. */
    private double targetAuthorInstitutionalAffiliationMatchTypeScore;

    /**
     * Gets the institutional affiliation source for the target author.
     * <p>
     * This method is annotated for DynamoDB conversion.
     * </p>
     * @return the institutional affiliation source
     */
    @DynamoDbConvertedBy(InstitutionalAffiliationSourceTypeConverter.class)
    public InstitutionalAffiliationSource getTargetAuthorInstitutionalAffiliationSource() {
        return targetAuthorInstitutionalAffiliationSource;
    }

    /**
     * Gets the institutional affiliation match type for the target author.
     * <p>
     * This method is annotated for DynamoDB conversion.
     * </p>
     * @return the institutional affiliation match type
     */
    @DynamoDbConvertedBy(InstitutionalAffiliationMatchTypeConverter.class)
    public InstitutionalAffiliationMatchType getTargetAuthorInstitutionalAffiliationMatchType() {
        return targetAuthorInstitutionalAffiliationMatchType;
    }
}