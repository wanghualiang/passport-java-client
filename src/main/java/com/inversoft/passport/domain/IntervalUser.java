/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.ToString;

/**
 * A user over an interval (for daily and monthly active user calculations).
 *
 * @author Brian Pontarelli
 */
public class IntervalUser {
  public UUID applicationId;

  public int interval;

  public UUID userId;

  public IntervalUser() {
  }

  public IntervalUser(UUID applicationId, int interval, UUID userId) {
    this.applicationId = applicationId;
    this.interval = interval;
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
        Objects.equals(interval, other.interval) &&
        Objects.equals(userId, other.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, interval, userId);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
