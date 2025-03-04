package reciter.model.article;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterPublicationTypeScopus {
	
	private String publicationTypeScopusAbbreviation;
	private String publicationTypeScopusLabel;
	
}
