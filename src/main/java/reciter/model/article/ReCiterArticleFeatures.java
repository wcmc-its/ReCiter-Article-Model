package reciter.model.article;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

/**
 * @author szd2013
 * This class checks for all the features of a articles
 */
@Data
public class ReCiterArticleFeatures {
	
	private String journalName;
	private List<String> coAuthors = new ArrayList<>();
	private List<String> meshMajor = new ArrayList<>();
	private Set<Integer> affiliationIds = new HashSet<>();
	private int featureCount = 0;

}
