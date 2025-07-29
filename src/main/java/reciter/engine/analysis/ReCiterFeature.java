package reciter.engine.analysis;

/**
 * Represents the features and evaluation metrics for a ReCiter person profile.
 * <p>
 * This class contains metadata and statistics relevant to the profile, including
 * identifiers, date information, evaluation mode, accuracy, precision, recall,
 * and article features.
 * </p>
 * @author ved4006
 */

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reciter.api.parameters.UseGoldStandard;
import reciter.model.typeconverter.DateAttributeConverter;
import reciter.model.typeconverter.UseGoldStandardTypeConverter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

/**
	ReCiterFeature class
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDbBean
public class ReCiterFeature {
	
	/** Unique identifier for the person. */
	private String personIdentifier;

	/** Date and time when this feature was added. */
	private Instant   dateAdded;
	
	/** Date and time when this feature was last updated. */
	private Instant   dateUpdated;
	
	/** Mode used for evaluation; utilizes gold standard if applicable. */
	private UseGoldStandard mode;
	
	/** Overall accuracy metric for the pimd. */
	private Double overallAccuracy;
	
	/** Precision metric for the pimd. */
	private Double precision;
	
	/** Recall metric for the pimd. */
	private Double recall;
	
	/** List of Pubmed IDs present in the gold standard but not retrieved. */
	private List<Long> inGoldStandardButNotRetrieved;
	
	/** Count of suggested articles for the person. */
	private int countSuggestedArticles;
	
	 /** Count of pending articles for the person. */
	private long countPendingArticles;
	
	/** List of accepted article keywords for accepted articles. */
	private List<ReCiterArticleFeature.ArticleKeyword> articleKeywordsAcceptedArticles;
	
	/** List of article features associated with the pimd. */
	private List<ReCiterArticleFeature> reCiterArticleFeatures;

	/**
     * Gets the evaluation mode.
     * 
     * @return the mode used for evaluation
     */
	@DynamoDbConvertedBy(UseGoldStandardTypeConverter.class)
	public UseGoldStandard getMode() {
		return mode;
	}

	/**
     * Gets the date and time when this feature was added.
     * 
     * @return the date added
     */
	@DynamoDbConvertedBy(DateAttributeConverter.class)
	public Instant   getDateAdded() {
		return dateAdded;
	}

	/**
     * Gets the date and time when this feature was last updated.
     * 
     * @return the date updated
     */
	@DynamoDbConvertedBy(DateAttributeConverter.class)
	public Instant   getDateUpdated() {
		return dateUpdated;
	}
}
