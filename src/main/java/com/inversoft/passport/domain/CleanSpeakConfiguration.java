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

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.inversoft.passport.domain.util.Normalizer.trim;

/**
 * CleanSpeak configuration at the system and application level.
 *
 * @author Brian Pontarelli
 */
public class CleanSpeakConfiguration {
  public String apiKey;

  public List<UUID> applicationIds = new ArrayList<>();

  public URI url;

  public UUID usernameApplicationId;

  public CleanSpeakConfiguration() {
  }

  public CleanSpeakConfiguration(String apiKey, UUID usernameApplicationId, URI url, UUID... applicationIds) {
    this.apiKey = apiKey;
    this.usernameApplicationId = usernameApplicationId;
    this.url = url;
    Collections.addAll(this.applicationIds, applicationIds);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CleanSpeakConfiguration)) {
      return false;
    }
    CleanSpeakConfiguration that = (CleanSpeakConfiguration) o;
    return Objects.equals(apiKey, that.apiKey) &&
        Objects.equals(usernameApplicationId, that.usernameApplicationId) &&
        Objects.equals(url, that.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKey, usernameApplicationId, url);
  }

  public void normalize() {
    apiKey = trim(apiKey);
  }
}
