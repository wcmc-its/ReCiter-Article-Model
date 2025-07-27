package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to the organizational unit associated with an identity and an article.
 * <p>
 * This class stores the organizational unit from the identity record, the article's affiliation,
 * the type of organizational unit, matching scores, and any modifiers with their scores.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import reciter.model.identity.OrganizationalUnit.OrganizationalUnitType;
import reciter.model.typeconverter.OrganizationalUnitTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class OrganizationalUnitEvidence {
	
	/** The organizational unit as recorded in the identity. */
    private String identityOrganizationalUnit;

    /** The affiliation as stated in the article. */
    private String articleAffiliation;

    /** The type of organizational unit (e.g., department, division). */
    private OrganizationalUnitType organizationalUnitType;

    /** The score representing how well the organizational units match. */
    private double organizationalUnitMatchingScore;

    /** Any modifier for the organizational unit (e.g., sub-division, campus). */
    private String organizationalUnitModifier;

    /** Score representing the significance of the modifier match. */
    private double organizationalUnitModifierScore;
	
    /**
     * Gets the type of organizational unit.
     * <p>
     * This method is annotated for DynamoDB conversion.
     * </p>
     * @return the organizational unit type
     */
	@DynamoDbConvertedBy(OrganizationalUnitTypeConverter.class)
	public OrganizationalUnitType getOrganizationalUnitType() {
		return organizationalUnitType;
	}
}
