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

/**
 * @author Brian Pontarelli
 */
public class AuditLogSearchCriteria extends BaseSearchCriteria {
  public ZonedDateTime end;

  public String message;

  public ZonedDateTime start;

  public String user;

  @Override
  public void prepare() {
    secure();
    user = toSearchString(user);
    message = toSearchString(message);
  }

  @Override
  protected String defaultOrderBy() {
    return "insert_instant DESC";
  }
}
