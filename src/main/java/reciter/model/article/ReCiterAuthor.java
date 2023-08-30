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
 * 
 * @author jil3004
 *
 */
public class ReCiterAuthor {
	
	private AuthorName name;
	private String affiliation;
	private int rank;
	private boolean targetAuthor;
	private String validEmail;
	private String orcid;
	private String equalContrib;
	
	public ReCiterAuthor(AuthorName name, String affiliation) {
		this.name = name;
		this.affiliation = affiliation;
	}
	
	public String getAffiliation() {
		return affiliation;
	}
	
	public AuthorName getAuthorName() {
		return name;
	}

	public boolean isTargetAuthor() {
		return targetAuthor;
	}

	public void setTargetAuthor(boolean targetAuthor) {
		this.targetAuthor = targetAuthor;
	}

	public String getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(String validEmail) {
		this.validEmail = validEmail;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

    /**
     * @return String return the orcid
     */
    public String getOrcid() {
        return orcid;
    }

    /**
     * @param orcid the orcid to set
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }
    public String getEqualContrib() {
		return equalContrib;
	}

	public void setEqualContrib(String equalContrib) {
		this.equalContrib = equalContrib;
	}


}
