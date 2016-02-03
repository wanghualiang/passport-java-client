/*
 * Copyright (c) 2015, Inversoft Inc., All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.inversoft.passport.domain.search;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * This class is the user query. It provides a build pattern as well as public fields for use on forms and in actions.
 *
 * @author Brian Pontarelli
 */
public class UserSearchCriteria extends BaseSearchCriteria {
  public Integer ageFrom;

  public Integer ageTo;

  public String email;

  public ZonedDateTime fromLastLoginInstant;

  public UUID id;

  public String fullName;

  public Sort sort = Sort.asc;

  public ZonedDateTime toLastLoginInstant;

  public String username;

  public String queryString;

  @Override
  public void prepare() {
    // No-op
  }

  /**
   * Specifies the sort
   *
   * @param sort the sort. Default is ASC
   * @return this
   */
  public UserSearchCriteria sort(Sort sort) {
    this.sort = sort;
    return this;
  }

  /**
   * The email to query. This is a lower case full match.
   *
   * @param email The email.
   * @return This query.
   */
  public UserSearchCriteria withEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Last login from..
   *
   * @param fromLastLoginInstant last login from...
   * @return this
   */
  public UserSearchCriteria withFromLastLoginInstant(ZonedDateTime fromLastLoginInstant) {
    this.fromLastLoginInstant = fromLastLoginInstant;
    return this;
  }

  /**
   * The id to query.
   *
   * @param uuid The id of the user.
   * @return This query.
   */
  public UserSearchCriteria withId(UUID uuid) {
    this.id = uuid;
    return this;
  }

  public UserSearchCriteria withName(String name) {
    this.fullName = name;
    return this;
  }

  /**
   * The number of results to display
   *
   * @param numberOfResults the number of results
   * @return this
   */
  public UserSearchCriteria withNumberOfResults(int numberOfResults) {
    this.numberOfResults = numberOfResults;
    return this;
  }

  /**
   * Last login to
   *
   * @param toLastLoginInstant last login from...
   * @return this
   */
  public UserSearchCriteria withToLastLoginInstant(ZonedDateTime toLastLoginInstant) {
    this.toLastLoginInstant = toLastLoginInstant;
    return this;
  }

  /**
   * The username to query. This is a lower case full match.
   *
   * @param username The username.
   * @return This query.
   */
  public UserSearchCriteria withUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * Enum for sorting results
   */
  public enum Sort {
    asc,
    desc
  }
}
