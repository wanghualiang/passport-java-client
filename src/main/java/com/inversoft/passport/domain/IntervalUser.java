/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.ToString;

/**
 * A user over an period (for daily and monthly active user calculations).
 *
 * @author Brian Pontarelli
 */
public class IntervalUser {
  public UUID applicationId;

  public int period;

  public UUID userId;

  public IntervalUser() {
  }

  public IntervalUser(UUID applicationId, int period, UUID userId) {
    this.applicationId = applicationId;
    this.period = period;
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IntervalUser)) {
      return false;
    }
    IntervalUser other = (IntervalUser) o;
    return Objects.equals(applicationId, other.applicationId) &&
        Objects.equals(period, other.period) &&
        Objects.equals(userId, other.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, period, userId);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
