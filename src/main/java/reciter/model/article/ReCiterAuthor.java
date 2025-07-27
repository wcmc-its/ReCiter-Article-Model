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

import reciter.model.identity.AuthorName;

/**
 * The Class ReCiterAuthor.
 *
 * @author jil3004
 */
public class ReCiterAuthor {
	
	/** The name. */
	private AuthorName name;
	
	/** The affiliation. */
	private String affiliation;
	
	/** The rank. */
	private int rank;
	
	/** The target author. */
	private boolean targetAuthor;
	
	/** The valid email. */
	private String validEmail;
	
	/** The orcid. */
	private String orcid;
	
	/** The equal contrib. */
	private String equalContrib;
	
	/**
	 * Instantiates a new re citer author.
	 *
	 * @param name the name
	 * @param affiliation the affiliation
	 */
	public ReCiterAuthor(AuthorName name, String affiliation) {
		this.name = name;
		this.affiliation = affiliation;
	}
	
	/**
	 * Gets the affiliation.
	 *
	 * @return the affiliation
	 */
	public String getAffiliation() {
		return affiliation;
	}
	
	/**
	 * Gets the author name.
	 *
	 * @return the author name
	 */
	public AuthorName getAuthorName() {
		return name;
	}

	/**
	 * Checks if is target author.
	 *
	 * @return true, if is target author
	 */
	public boolean isTargetAuthor() {
		return targetAuthor;
	}

	/**
	 * Sets the target author.
	 *
	 * @param targetAuthor the new target author
	 */
	public void setTargetAuthor(boolean targetAuthor) {
		this.targetAuthor = targetAuthor;
	}

	/**
	 * Gets the valid email.
	 *
	 * @return the valid email
	 */
	public String getValidEmail() {
		return validEmail;
	}

	/**
	 * Sets the valid email.
	 *
	 * @param validEmail the new valid email
	 */
	public void setValidEmail(String validEmail) {
		this.validEmail = validEmail;
	}

	/**
	 * Gets the rank.
	 *
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Sets the rank.
	 *
	 * @param rank the new rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

    /**
     * Gets the orcid.
     *
     * @return String return the orcid
     */
    public String getOrcid() {
        return orcid;
    }

    /**
     * Sets the orcid.
     *
     * @param orcid the orcid to set
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }
    
    /**
     * Gets the equal contrib.
     *
     * @return the equal contrib
     */
    public String getEqualContrib() {
		return equalContrib;
	}

	/**
	 * Sets the equal contrib.
	 *
	 * @param equalContrib the new equal contrib
	 */
	public void setEqualContrib(String equalContrib) {
		this.equalContrib = equalContrib;
	}
}