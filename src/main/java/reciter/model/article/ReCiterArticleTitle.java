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
 * ReCiterArticle title field.
 * <p>
 * This class encapsulates the title of a ReCiter article and provides utility methods
 * to check the existence of the title and to retrieve it.
 * </p>
 * @author ved4006
 *
 */
public class ReCiterArticleTitle {
	
	 /** The title of the article (immutable). */
    private final String title;

    /**
     * Constructs a ReCiterArticleTitle with the specified title.
     * @param title the article title
     */
    public ReCiterArticleTitle(String title) {
        this.title = title;
    }

    /**
     * Checks if the title exists (is not null).
     * @return true if the title exists, false otherwise
     */
    public boolean exist() {
        return title != null;
    }

    /**
     * Gets the article title.
     * @return the title string
     */
    public String getTitle() {
        return title;
    }	
}
