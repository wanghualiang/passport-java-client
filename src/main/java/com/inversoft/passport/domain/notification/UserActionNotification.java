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
package com.inversoft.passport.domain.notification;


import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.ToString;
import com.inversoft.passport.domain.Buildable;
import com.inversoft.passport.domain.email.Email;

/**
 * Models the user action notification (and can be converted to JSON).
 *
 * @author Brian Pontarelli
 */
public class UserActionNotification implements Buildable<UserActionNotification> {
  public static ZonedDateTime Infinite = ZonedDateTime.ofInstant(Instant.ofEpochMilli(Long.MAX_VALUE), ZoneOffset.UTC);

  public final List<UUID> applicationIds = new ArrayList<>();

  public String action;

  public UUID actionId;

  public UUID actioneeUserId;

  public UUID actionerUserId;

  public String comment;

  /**
   * Added so we can show when the action was taken in the front end
   */
  public ZonedDateTime createInstant;

  /**
   * The email that the notification server should email to the user. This should only be included if notifyUser is true
   * (i think)
   */
  public Email email;

  public ZonedDateTime expiry;

  public String localizedAction;

  public String localizedDuration;

  public String localizedOption;

  public String localizedReason;

  public boolean notifyUser;

  public String option;

  public boolean passportEmailedUser;

  public UserActionPhase phase;

  public String reason;

  public String reasonCode;

  public UserActionNotification() {
  }

  /**
   * @param actionId            The id that tracks this user action (the log id).
   * @param actioneeUserId      The user id of the person being actioned.
   * @param actionerUserId      The user id of the person that took the action.
   * @param applicationIds      The ids of the applications the action is being performed in.
   * @param action              the user action
   * @param localizedAction     The localized action.
   * @param option              the action option
   * @param localizedOption     The localized option.
   * @param reason              The user action   reason.
   * @param localizedReason     The localized reason.
   * @param reasonCode          The user action reason code.
   * @param expiry              The expiration instant.
   * @param localizedDuration   The localized duration text.
   * @param phase               The phase for time-based user actions.
   * @param comment             A comment from the moderator.
   * @param notifyUser          A flag to tell the notifications server to notify user of the action.
   * @param passportEmailedUser A flag indicating that passport should email the user.
   * @param email               The email that should be sent to the end user.
   */
  public UserActionNotification(UUID actionId, UUID actioneeUserId, UUID actionerUserId, List<UUID> applicationIds,
                                String action, String localizedAction, String option, String localizedOption,
                                String reason, String localizedReason, String reasonCode, ZonedDateTime expiry,
                                String localizedDuration, UserActionPhase phase, String comment, boolean notifyUser,
                                boolean passportEmailedUser, Email email) {
    this.actionId = actionId;
    this.action = action;
    this.actioneeUserId = actioneeUserId;
    this.actionerUserId = actionerUserId;
    this.comment = comment;
    this.expiry = expiry;
    this.localizedAction = localizedAction;
    this.localizedDuration = localizedDuration;
    this.localizedOption = localizedOption;
    this.localizedReason = localizedReason;
    this.notifyUser = notifyUser;
    this.option = option;
    this.phase = phase;
    this.reason = reason;
    this.reasonCode = reasonCode;
    this.passportEmailedUser = passportEmailedUser;
    this.email = email;

    if (applicationIds != null) {
      this.applicationIds.addAll(applicationIds);
      Collections.sort(this.applicationIds);
    }
  }

  public boolean active() {
    return expiry != null && ZonedDateTime.now(ZoneOffset.UTC).isBefore(expiry);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserActionNotification)) {
      return false;
    }
    UserActionNotification that = (UserActionNotification) o;
    return
        Objects.equals(actionId, that.actionId) &&
            Objects.equals(notifyUser, that.notifyUser) &&
            Objects.equals(passportEmailedUser, that.passportEmailedUser) &&
            Objects.equals(applicationIds, that.applicationIds) &&
            Objects.equals(action, that.action) &&
            Objects.equals(actioneeUserId, that.actioneeUserId) &&
            Objects.equals(actionerUserId, that.actionerUserId) &&
            Objects.equals(comment, that.comment) &&
            Objects.equals(createInstant, that.createInstant) &&
            Objects.equals(email, that.email) &&
            Objects.equals(expiry, that.expiry) &&
            Objects.equals(localizedAction, that.localizedAction) &&
            Objects.equals(localizedDuration, that.localizedDuration) &&
            Objects.equals(localizedOption, that.localizedOption) &&
            Objects.equals(localizedReason, that.localizedReason) &&
            Objects.equals(option, that.option) &&
            Objects.equals(phase, that.phase) &&
            Objects.equals(reason, that.reason) &&
            Objects.equals(reasonCode, that.reasonCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actionId, applicationIds, action, actioneeUserId, actionerUserId, comment, createInstant, email, expiry,
        localizedAction, localizedDuration, localizedOption, localizedReason, notifyUser, option, passportEmailedUser,
        phase, reason, reasonCode);
  }

  public String toString() {
    return ToString.toString(this);
  }
}
