package reciter.model.typeconverter;

import reciter.engine.analysis.evidence.AffiliationEvidence;
import reciter.engine.analysis.evidence.AffiliationEvidence.InstitutionalAffiliationSource;
import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A custom implementation of {@link AttributeConverter} that handles the conversion
 * between {@link InstitutionalAffiliationSource} and DynamoDB's {@link AttributeValue}.
 */

public class InstitutionalAffiliationSourceConverter implements AttributeConverter<AffiliationEvidence.InstitutionalAffiliationSource> {

	/**
     * Converts the {@link InstitutionalAffiliationSource } to a DynamoDB {@link AttributeValue} (String type).
     *
     * @param input the InstitutionalAffiliationSource  value to convert.
     * @return an AttributeValue containing the enum name.
     */
    @Override
    public AttributeValue transformFrom(AffiliationEvidence.InstitutionalAffiliationSource input) {
        return AttributeValue.builder().s(input.name()).build();
    }

    /**
     * Converts a DynamoDB {@link AttributeValue} to a {@link InstitutionalAffiliationSource}.
     *
     * @param attributeValue the attribute value from DynamoDB.
     * @return the InstitutionalAffiliationSource  represented by the string.
     * @throws IllegalArgumentException if the string does not match any enum constant.
     */
    @Override
    public AffiliationEvidence.InstitutionalAffiliationSource transformTo(AttributeValue attributeValue) {
        return AffiliationEvidence.InstitutionalAffiliationSource.valueOf(attributeValue.s());
    }

    /**
     * Specifies the type this converter handles: {@link InstitutionalAffiliationSource}.
     *
     * @return the enhanced type representation of InstitutionalAffiliationSource.
     */
    @Override
    public EnhancedType<AffiliationEvidence.InstitutionalAffiliationSource> type() {
        return EnhancedType.of(AffiliationEvidence.InstitutionalAffiliationSource.class);
    }

    /**
     * Specifies the underlying DynamoDB type this converter uses (String).
     *
     * @return {@link AttributeValueType#S} for string type.
     */
    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S;
    }
}