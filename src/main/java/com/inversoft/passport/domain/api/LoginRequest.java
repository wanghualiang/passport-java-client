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

import java.util.UUID;

import com.inversoft.json.JacksonConstructor;

/**
 * Login API request object.
 *
 * @author Seth Musselman
 */
public class LoginRequest {
  public UUID applicationId;

  public String id;

  public String password;

  @JacksonConstructor
  public LoginRequest() {
  }

  public LoginRequest(UUID applicationId, String id, String password) {
    this.applicationId = applicationId;
    this.id = id;
    this.password = password;
  }

  public String getEmail() {
    return id;
  }

  public void setEmail(String email) {
    this.id = email;
  }

  public String getUsername() {
    return id;
  }

  public void setUsername(String username) {
    this.id = username;
  }
}