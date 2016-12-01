/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.jwt;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inversoft.json.ToString;
import com.inversoft.passport.domain.Application;
import com.inversoft.passport.domain.Buildable;

/**
 * Internal representation of our refresh token.
 *
 * @author Daniel DeGroff
 */
public class RefreshToken implements Buildable<RefreshToken> {

  @JsonIgnore
  public Application application;

  public UUID applicationId;

  public String device;

  public ZonedDateTime insertInstant;

  public MetaData metaData = new MetaData();

  public String token;

  public UUID userId;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefreshToken that = (RefreshToken) o;
    return Objects.equals(applicationId, that.applicationId) &&
        Objects.equals(device, that.device) &&
        Objects.equals(insertInstant, that.insertInstant) &&
        Objects.equals(metaData, that.metaData) &&
        Objects.equals(token, that.token) &&
        Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationId, device, insertInstant, metaData, token, userId);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }

  public static class MetaData implements Buildable<MetaData> {
    public DeviceInfo device = new DeviceInfo();
  }
}
