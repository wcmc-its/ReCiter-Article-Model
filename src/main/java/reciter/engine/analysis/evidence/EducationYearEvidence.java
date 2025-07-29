package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to the comparison of education years between identity records and articles.
 * <p>
 * This class stores the bachelor's and doctoral graduation years from identity records,
 * the article's year, and the discrepancies (and their scores) between degree years and article year.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
/**
	EducationYearEvidence class
*/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class EducationYearEvidence {
	
	/** The year of obtaining a bachelor's degree from the identity record. */
	private Integer identityBachelorYear;
	
	/** The year of obtaining a doctoral degree from the identity record. */
	private Integer identityDoctoralYear;
	
	/** The year associated with the article (e.g., publication year). */
	private Integer articleYear;
	
	/** Year of bachelor’s degree . */
    private Integer discrepancyDegreeYearBachelor;
    
    /** Score of bachelor’s degree . */
    private double discrepancyDegreeYearBachelorScore;
    
    /** Year of Doctoral's degree . */
    private Integer discrepancyDegreeYearDoctoral;
    
    /** Score of Doctoral's degree . */
    private double discrepancyDegreeYearDoctoralScore;
    
}
