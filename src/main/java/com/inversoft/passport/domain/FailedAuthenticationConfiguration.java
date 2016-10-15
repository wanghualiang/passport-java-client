/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

import java.util.Objects;

import com.inversoft.json.ToString;

/**
 * Configuration for the behavior of failed login attempts. This helps us protect against brute force password attacks.
 *
 * @author Daniel DeGroff
 */
public class FailedAuthenticationConfiguration implements Buildable<FailedAuthenticationConfiguration> {

  /**
   * The length of time in seconds the failed login attempt is kept in the cache. This essentially causes the failed
   * login count to fail after this period of time.
   */
  public int resetCountInSeconds = 60;

  /**
   * Number of failed login attempts considered to be too many.
   */
  public int tooManyAttempts = 5;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedAuthenticationConfiguration that = (FailedAuthenticationConfiguration) o;
    return tooManyAttempts == that.tooManyAttempts &&
        resetCountInSeconds == that.resetCountInSeconds;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tooManyAttempts, resetCountInSeconds);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
