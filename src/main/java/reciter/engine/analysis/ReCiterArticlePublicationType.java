package reciter.engine.analysis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.model.article.ReCiterPublicationTypeScopus;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterArticlePublicationType {
	
	private String publicationTypeCanonical;
	private List<String> publicationTypePubMed;
	private ReCiterPublicationTypeScopus publicationTypeScopus;
}
