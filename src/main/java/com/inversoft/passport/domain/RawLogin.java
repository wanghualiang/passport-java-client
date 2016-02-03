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
package com.inversoft.passport.domain;

import org.primeframework.json.ToString;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Raw login information for each time a user logs into an application.
 *
 * @author Brian Pontarelli
 */
public class RawLogin {
  public UUID applicationId;

  public ZonedDateTime instant;

  public String ipAddress;

  public UUID userId;

  public RawLogin() {
  }

  public RawLogin(UUID applicationId, ZonedDateTime instant, String ipAddress, UUID userId) {
    this.applicationId = applicationId;
    this.instant = instant;
    this.ipAddress = ipAddress;
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RawLogin)) {
      return false;
    }
    RawLogin rawLogin = (RawLogin) o;
    return Objects.equals(applicationId, rawLogin.applicationId) &&
        Objects.equals(instant, rawLogin.instant) &&
        Objects.equals(ipAddress, rawLogin.ipAddress) &&
        Objects.equals(userId, rawLogin.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, instant, ipAddress, userId);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}