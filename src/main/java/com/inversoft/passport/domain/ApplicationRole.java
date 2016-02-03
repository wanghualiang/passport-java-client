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

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.primeframework.json.ToString;

import java.util.Objects;
import java.util.UUID;

import static com.inversoft.passport.domain.util.Normalizer.trim;

/**
 * A role given to a user for a specific application.
 *
 * @author Seth Musselman
 */
public class ApplicationRole implements Comparable<ApplicationRole>, Buildable<ApplicationRole> {
  @JsonIgnore
  public UUID applicationId;

  public String description;

  public UUID id;

  public boolean isDefault;

  public String name;

  public ApplicationRole() {
  }

  public ApplicationRole(String roleName) {
    this(null, null, roleName, false, null);
  }

  public ApplicationRole(UUID id, UUID applicationId, String roleName, boolean isDefault, String description) {
    this.id = id;
    this.applicationId = applicationId;
    this.name = roleName;
    this.isDefault = isDefault;
    this.description = description;
  }

  @Override
  public int compareTo(ApplicationRole o) {
    return name.compareTo(o.name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApplicationRole)) {
      return false;
    }
    ApplicationRole that = (ApplicationRole) o;
    return Objects.equals(isDefault, that.isDefault) &&
        Objects.equals(applicationId, that.applicationId) &&
        Objects.equals(description, that.description) &&
        Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, description, isDefault, name);
  }

  public void normalize() {
    description = trim(description);
    name = trim(name);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
