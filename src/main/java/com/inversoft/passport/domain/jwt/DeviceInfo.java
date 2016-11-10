/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.jwt;

import java.net.InetAddress;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.inversoft.json.ToString;
import com.inversoft.passport.domain.Buildable;

/**
 * @author Daniel DeGroff
 */
public class DeviceInfo implements Buildable<DeviceInfo> {

  public String description;

  public InetAddress lastAccessedAddress;

  public ZonedDateTime lastAccessedInstant;

  public String name;

  public Type type = Type.UNKNOWN;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceInfo device = (DeviceInfo) o;
    return Objects.equals(description, device.description) &&
        Objects.equals(lastAccessedAddress, device.lastAccessedAddress) &&
        Objects.equals(lastAccessedInstant, device.lastAccessedInstant) &&
        Objects.equals(name, device.name) &&
        type == device.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, lastAccessedAddress, lastAccessedInstant, name, type);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }

  public enum Type {
    DESKTOP,
    LAPTOP,
    MOBILE,
    OTHER,
    SERVER,
    TABLET,
    TV,
    UNKNOWN
  }
}
