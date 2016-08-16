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
package com.inversoft.passport.domain.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inversoft.json.JacksonConstructor;
import com.inversoft.passport.domain.Application;
import com.inversoft.passport.domain.ApplicationRole;

/**
 * The Application API response.
 *
 * @author Brian Pontarelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationResponse {
  public Application application;

  public List<Application> applications;

  public ApplicationRole role;

  @JacksonConstructor
  public ApplicationResponse() {
  }

  public ApplicationResponse(Application application) {
    this.application = application;
  }

  public ApplicationResponse(List<Application> applications) {
    this.applications = applications;
  }

  public ApplicationResponse(ApplicationRole role) {
    this.role = role;
  }
}
