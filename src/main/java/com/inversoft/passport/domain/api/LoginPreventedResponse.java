/*
 * Copyright (c) 2017, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.passport.domain.Buildable;
import com.inversoft.passport.domain.UserActionLog;

/**
 * The summary of the action that is preventing login to be returned on the login response.
 *
 * @author Daniel DeGroff
 */
public class LoginPreventedResponse implements Buildable<LoginPreventedResponse> {
  public UUID actionId;

  public UUID actionerUserId;

  public ZonedDateTime expiry;

  public String localizedName;

  public String localizedOption;

  public String localizedReason;

  public String name;

  public String option;

  public String reason;

  public String reasonCode;

  public LoginPreventedResponse(UserActionLog userActionLog) {
    this.actionId = userActionLog.userActionId;
    this.actionerUserId = userActionLog.actionerUserId;
    this.expiry = userActionLog.expiry;
    this.localizedName = userActionLog.localizedName;
    this.localizedReason = userActionLog.localizedReason;
    this.name = userActionLog.name;
    this.reason = userActionLog.reason;
    this.reasonCode = userActionLog.reasonCode;
  }

  @JacksonConstructor
  public LoginPreventedResponse() {
  }
}
