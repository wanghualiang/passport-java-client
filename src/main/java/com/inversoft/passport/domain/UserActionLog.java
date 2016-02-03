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
import com.inversoft.passport.domain.notification.UserActionNotification;
import org.primeframework.json.ToString;

import java.time.ZonedDateTime;
import java.util.*;

import static com.inversoft.passport.domain.util.Normalizer.trim;

/**
 * A log for an action that was taken on a User.
 *
 * @author Brian Pontarelli
 */
public class UserActionLog implements Buildable<UserActionLog> {
  public UUID actioneeUserId;

  public UUID actionerUserId;

  public List<UUID> applicationIds = new ArrayList<>();

  public String comment;

  public ZonedDateTime createInstant;

  /**
   * Passport will email the user when the action ends.
   */
  public boolean emailUserOnEnd;

  public Boolean endNotificationSent;

  public ZonedDateTime expiry;

  public LogHistory history;

  public UUID id;

  public String localizedOption;

  public String localizedReason;

  public UserActionNotification notification;

  /**
   * Notification servers will use this to determine if they should notify the user
   */
  public boolean notifyUserOnEnd;

  public String option;

  public String reason;

  public String reasonCode;

  public UUID userActionId;

  public UserActionLog() {
  }

  public UserActionLog(UUID actioneeUserId, UUID actionerUserId, UUID userActionId, List<UUID> applicationIds,
                       String comment, ZonedDateTime expiry, String option, String localizedOption, String reason,
                       String localizedReason, String reasonCode, ZonedDateTime createInstant,
                       Boolean endNotificationSent, LogHistory history, boolean notifyUserOnEnd,
                       boolean emailUserOnEnd) {
    this.actioneeUserId = actioneeUserId;
    this.actionerUserId = actionerUserId;
    this.userActionId = userActionId;

    if (applicationIds != null) {
      this.applicationIds = applicationIds;
    }

    this.comment = comment;
    this.expiry = expiry;
    this.option = option;
    this.reason = reason;
    this.reasonCode = reasonCode;
    this.createInstant = createInstant;
    this.endNotificationSent = endNotificationSent;
    this.history = history;
    this.localizedOption = localizedOption;
    this.localizedReason = localizedReason;
    this.emailUserOnEnd = emailUserOnEnd;
    this.notifyUserOnEnd = notifyUserOnEnd;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserActionLog)) {
      return false;
    }
    UserActionLog that = (UserActionLog) o;
    Collections.sort(this.applicationIds);
    Collections.sort(that.applicationIds);
    return Objects.equals(emailUserOnEnd, that.emailUserOnEnd) &&
        Objects.equals(actioneeUserId, that.actioneeUserId) &&
        Objects.equals(actionerUserId, that.actionerUserId) &&
        Objects.equals(applicationIds, that.applicationIds) &&
        Objects.equals(comment, that.comment) &&
        Objects.equals(createInstant, that.createInstant) &&
        Objects.equals(endNotificationSent, that.endNotificationSent) &&
        Objects.equals(notifyUserOnEnd, that.notifyUserOnEnd) &&
        Objects.equals(expiry, that.expiry) &&
        Objects.equals(history, that.history) &&
        Objects.equals(localizedOption, that.localizedOption) &&
        Objects.equals(localizedReason, that.localizedReason) &&
        Objects.equals(option, that.option) &&
        Objects.equals(reason, that.reason) &&
        Objects.equals(reasonCode, that.reasonCode) &&
        Objects.equals(userActionId, that.userActionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actioneeUserId, actionerUserId, applicationIds, comment, createInstant, endNotificationSent, expiry,
        history, localizedOption, localizedReason, emailUserOnEnd, option, reason, reasonCode, userActionId, notifyUserOnEnd);
  }

  @JsonIgnore
  public boolean isActive() {
    return expiry != null && expiry.isAfter(ZonedDateTime.now());
  }

  public void normalize() {
    comment = trim(comment);
  }

  public String toString() {
    return ToString.toString(this);
  }
}
