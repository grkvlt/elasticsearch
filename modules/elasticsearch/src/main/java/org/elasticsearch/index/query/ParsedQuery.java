/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.query;

import org.apache.lucene.search.Filter;
import org.apache.lucene.search.Query;
import org.elasticsearch.common.collect.ImmutableMap;
import org.elasticsearch.common.lucene.search.Queries;

/**
 * The result of parsing a query.
 *
 * @author kimchy (shay.banon)
 */
public class ParsedQuery {

    public static ParsedQuery MATCH_ALL_PARSED_QUERY = new ParsedQuery(Queries.MATCH_ALL_QUERY, ImmutableMap.<String, Filter>of());

    private final Query query;

    private final ImmutableMap<String, Filter> namedFilters;

    public ParsedQuery(Query query, ImmutableMap<String, Filter> namedFilters) {
        this.query = query;
        this.namedFilters = namedFilters;
    }

    public ParsedQuery(Query query, ParsedQuery parsedQuery) {
        this.query = query;
        this.namedFilters = parsedQuery.namedFilters;
    }

    /**
     * The query parsed.
     */
    public Query query() {
        return this.query;
    }

    public ImmutableMap<String, Filter> namedFilters() {
        return this.namedFilters;
    }
}
