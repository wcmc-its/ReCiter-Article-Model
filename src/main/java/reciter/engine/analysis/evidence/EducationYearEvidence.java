package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class EducationYearEvidence {
	private Integer identityBachelorYear;
	private Integer identityDoctoralYear;
	private Integer articleYear;
    private Integer discrepancyDegreeYearBachelor;
    private double discrepancyDegreeYearBachelorScore;
    private Integer discrepancyDegreeYearDoctoral;
    private double discrepancyDegreeYearDoctoralScore;
    
}
