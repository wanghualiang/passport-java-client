/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.ToString;

/**
 * Raw login information for each time a user logs into an application.
 *
 * @author Daniel DeGroff
 */
public class PendingRawLogin {

  public UUID id;

  public RawLogin rawLogin;

  public PendingRawLogin() {
  }

  public PendingRawLogin(UUID id, RawLogin rawLogin) {
    this.id = id;
    this.rawLogin = rawLogin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PendingRawLogin)) {
      return false;
    }
    PendingRawLogin rawLogin = (PendingRawLogin) o;
    return Objects.equals(id, rawLogin.id) &&
        Objects.equals(rawLogin.rawLogin, rawLogin.rawLogin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rawLogin);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
