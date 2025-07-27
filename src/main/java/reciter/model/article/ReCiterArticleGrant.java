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
 * Represents a grant associated with a ReCiter article.
 * <p>
 * This class contains information about the grant, such as grant ID, acronym,
 * agency, country, and a sanitized version of the grant ID.
 * </p>
 * @author ved4006
 */

import lombok.Data;

@Data
public class ReCiterArticleGrant {

    /** The grant's identifier. */
    private String grantID;

    /** The acronym of the grant. */
    private String acronym;

    /** The agency or organization providing the grant. */
    private String agency;

    /** The country associated with the grant. */
    private String country;

    /** A sanitized version of the grant ID.*/
    private String sanitizedGrantID;
}
