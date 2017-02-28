/*
 * Copyright (c) 2017, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.event;

import java.util.Objects;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import com.inversoft.passport.domain.Buildable;
import com.inversoft.passport.domain.User;

/**
 * Models the User Deactivate Event (and can be converted to JSON).
 *
 * @author Brian Pontarelli
 */
public class UserDeactivateEvent extends BaseEvent implements Buildable<UserDeactivateEvent> {
  public User user;

  @JacksonConstructor
  public UserDeactivateEvent() {
  }

  public UserDeactivateEvent(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDeactivateEvent that = (UserDeactivateEvent) o;
    return Objects.equals(user, that.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user);
  }

  public String toString() {
    return ToString.toString(this);
  }

  @Override
  public EventType type() {
    return EventType.UserDeactivate;
  }
}
