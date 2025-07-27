package reciter.model.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * The Class ReCiterPublicationTypeScopusBuilder.
 * @author ved4006
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterPublicationTypeScopus {
	
	/** The publication type scopus abbreviation. */
	private String publicationTypeScopusAbbreviation;
	
	/** The publication type scopus label. */
	private String publicationTypeScopusLabel;
	
}
