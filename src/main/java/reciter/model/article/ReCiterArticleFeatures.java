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
	private List<String> coAuthors = new ArrayList<String>();
	private List<String> meshMajor = new ArrayList<String>();
	private Set<Integer> affiliationIds = new HashSet<Integer>();
	private int featureCount = 0;

}
