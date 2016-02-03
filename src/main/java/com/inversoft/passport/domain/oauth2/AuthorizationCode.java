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
package com.inversoft.passport.domain.oauth2;

import com.inversoft.passport.domain.User;
import org.primeframework.json.ToString;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * @author Daniel DeGroff
 */
public class AuthorizationCode implements Expiring {
  public String clientId;

  public String code;

  public ZonedDateTime createInstant;

  public ZonedDateTime expiresInstant;

  public URI redirectURI;

  public User user;

  public AuthorizationCode(String clientId, String code, ZonedDateTime createInstant, ZonedDateTime expiresInstant,
                           URI redirectURI, User user) {
    this.clientId = clientId;
    this.code = code;
    this.createInstant = createInstant;
    this.expiresInstant = expiresInstant;
    this.redirectURI = redirectURI;
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizationCode that = (AuthorizationCode) o;
    return Objects.equals(clientId, that.clientId) &&
        Objects.equals(code, that.code) &&
        Objects.equals(createInstant, that.createInstant) &&
        Objects.equals(expiresInstant, that.expiresInstant) &&
        Objects.equals(redirectURI, that.redirectURI) &&
        Objects.equals(user, that.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, code, createInstant, expiresInstant, redirectURI, user);
  }

  @Override
  public boolean isExpired() {
    return ZonedDateTime.now().isAfter(expiresInstant);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
