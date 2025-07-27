/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package reciter.model.article;

/**
 * Represents the keywords associated with a ReCiter article.
 * <p>
 * This class allows for storing, adding, checking, and retrieving a list of keywords.
 * Each keyword is wrapped in its own Keyword object.
 * </p>
 * @author ved4006
 */

import java.util.ArrayList;
import java.util.List;

public class ReCiterArticleKeywords {
	
	/**
     * Represents a single keyword.
     */
	public class Keyword {
		
		 /** The keyword string. */
		private String keyword;
		
		 /** Default constructor. */
		Keyword() {}
		
		/**
         * Constructor with keyword string.
         * @param keyword the keyword value
         */
		Keyword(String keyword) {
			this.keyword = keyword;
		}
		
		 /**
         * Gets the keyword string.
         * @return the keyword
         */
		public String getKeyword() {
			return keyword;
		}
		
		 /**
         * Sets the keyword string.
         * @param keyword the new keyword value
         */
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
	}
    /** List of keyword objects associated with the article. */
	private List<Keyword> keywords;
	
	/** Constructs an empty ReCiterArticleKeywords object. */
	public ReCiterArticleKeywords() {
		keywords = new ArrayList<Keyword>();
	}
	
	 /**
     * Checks if the keywords list exists (is not null).
     * @return true if keywords list exists, false otherwise
     */
	public boolean exist() {
		return keywords != null;
	}
	
	/**
     * Gets the list of keywords.
     * @return list of Keyword objects
     */
	public List<Keyword> getKeywords() {
		return keywords;
	}

	/**
     * Sets the list of keywords.
     * @param keywords list of Keyword objects
     */
	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}
	
	/**
     * Adds a keyword to the list.
     * @param keyword the keyword string to add
     */
	public void addKeyword(String keyword) {
		keywords.add(new Keyword(keyword));
	}
	
	 /**
     * Checks if a specific keyword exists in the list (case-insensitive).
     * @param keywordStr keyword to check for
     * @return true if the keyword exists, false otherwise
     */
	public boolean isKeywordExist(String keywordStr){
		if(exist()){
			for(Keyword k: keywords){
				if(k.getKeyword().equalsIgnoreCase(keywordStr))return true;
			}
		}
		return false;
	}
	
	  /**
     * Returns a comma-separated string of all keywords.
     * @return comma-separated keywords
     */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Keyword keyword : keywords) {
			sb.append(keyword.getKeyword());
			sb.append(",");
		}
		return sb.toString();
	}
}
