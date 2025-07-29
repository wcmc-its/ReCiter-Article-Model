package reciter.model.article;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

/**
 * The Class ReCiterArticleFeatures.
 *
 * @author szd2013
 * This class checks for all the features of a articles
 */
@Data
public class ReCiterArticleFeatures {
	
	/** The journal name. */
	private String journalName;
	
	/** The co authors. */
	private List<String> coAuthors = new ArrayList<>();
	
	/** The mesh major. */
	private List<String> meshMajor = new ArrayList<>();
	
	/** The affiliation ids. */
	private Set<Integer> affiliationIds = new HashSet<>();
	
	/** The feature count. */
	private int featureCount = 0;

}
