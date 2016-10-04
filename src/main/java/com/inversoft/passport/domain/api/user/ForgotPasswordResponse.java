/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api.user;

import com.inversoft.json.JacksonConstructor;

/**
 * Forgot password response object.
 *
 * @author Daniel DeGroff
 */
public class ForgotPasswordResponse {

  public String verificationId;

  @JacksonConstructor
  public ForgotPasswordResponse() {
  }

  public ForgotPasswordResponse(String verificationId) {
    this.verificationId = verificationId;
  }
}
