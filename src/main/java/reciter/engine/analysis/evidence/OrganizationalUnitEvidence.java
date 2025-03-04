package reciter.engine.analysis.evidence;

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
	
	private String identityOrganizationalUnit;
	private String articleAffiliation;
	private OrganizationalUnitType organizationalUnitType;
	private double organizationalUnitMatchingScore;
	private String organizationalUnitModifier;
	private double organizationalUnitModifierScore;
	
	@DynamoDbConvertedBy(OrganizationalUnitTypeConverter.class)
	public OrganizationalUnitType getOrganizationalUnitType() {
		return organizationalUnitType;
	}
}
