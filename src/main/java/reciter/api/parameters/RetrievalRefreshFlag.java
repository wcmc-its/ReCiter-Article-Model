package reciter.api.parameters;

/**
 * User would be able to select one of the refresh flag for retrieval.
 * If "All publications" - re-import all publications
 * If "Only newly added publications" - add publications from a date
 * If "False" (default) - retrieve existing records from eSearchResults
 * 
 * @author Sarbajit Dutta (szd2013) 
 */
public enum RetrievalRefreshFlag {
	
	/** The all publications. */
	ALL_PUBLICATIONS,
	
	/** The only newly added publications. */
	ONLY_NEWLY_ADDED_PUBLICATIONS,
	
	/** The false. */
	FALSE
}
