package reciter.engine.analysis.evidence;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class JournalCategoryEvidence {
	
	private String journalSubfieldScienceMetrixLabel;
	private int journalSubfieldScienceMetrixID;
	private String journalSubfieldDepartment;
	private double journalSubfieldScore;
}
