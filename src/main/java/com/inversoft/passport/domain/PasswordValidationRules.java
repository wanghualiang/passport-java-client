/*
 * Copyright (c) 2015-2016, Inversoft Inc., All Rights Reserved
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

import java.util.Objects;

/**
 * @author Derek Klatt
 */
public class PasswordValidationRules implements Buildable<PasswordValidationRules> {
  public int maxLength = 256;

  public int minLength = 8;

  public boolean requireMixedCase;

  public boolean requireNonAlpha;

  public PasswordValidationRules() {
  }

  public PasswordValidationRules(int minLength, int maxLength, boolean requireMixedCase,
                                 boolean requireNonAlpha) {
    this.maxLength = maxLength;
    this.minLength = minLength;
    this.requireMixedCase = requireMixedCase;
    this.requireNonAlpha = requireNonAlpha;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PasswordValidationRules)) {
      return false;
    }
    PasswordValidationRules that = (PasswordValidationRules) o;
    return Objects.equals(maxLength, that.maxLength) &&
        Objects.equals(minLength, that.minLength) &&
        Objects.equals(requireMixedCase, that.requireMixedCase) &&
        Objects.equals(requireNonAlpha, that.requireNonAlpha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxLength, minLength, requireMixedCase, requireNonAlpha);
  }
}
