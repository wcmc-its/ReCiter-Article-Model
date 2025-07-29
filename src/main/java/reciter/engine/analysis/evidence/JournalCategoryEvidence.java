package reciter.engine.analysis.evidence;

/**
 * Represents evidence related to the categorization of a journal.
 * <p>
 * This class stores information about the journal's subfield label and ID (using Science-Metrix ),
 * the department associated with the subfield, and a score reflecting the relevance or match of the subfield.
 * </p>
 * @author ved4006
 */

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@ToString
@DynamoDbBean
public class JournalCategoryEvidence {
	
	/** The label of the journal subfield, according to Science-Metrix classification. */
    private String journalSubfieldScienceMetrixLabel;

    /** The Science-Metrix ID for the journal subfield. */
    private int journalSubfieldScienceMetrixID;

    /** The department associated with the journal subfield. */
    private String journalSubfieldDepartment;

    /** The score representing the relevance or match of the journal subfield. */
    private double journalSubfieldScore;
}
