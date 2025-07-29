package reciter.engine.analysis;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.model.article.ReCiterPublicationTypeScopus;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * Represents various standardized and source-specific publication types for a ReCiter article.
 *
 * <p>This class encapsulates the canonical publication type as well as publication types
 * as defined by external bibliographic sources such as PubMed and Scopus.
 * @author ved4006
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterArticlePublicationType {
	
	/** The publication type canonical. */
	private String publicationTypeCanonical;
	
	/** The publication type pub med. */
	private List<String> publicationTypePubMed;
	
	/** Publication type information as represented in Scopus.. */
	private ReCiterPublicationTypeScopus publicationTypeScopus;
}
