/*
 * Copyright (c) 2016-2017, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api.jwt;

import com.inversoft.json.JacksonConstructor;

/**
 * @author Daniel DeGroff
 */
public class RefreshRequest {

  public String refreshToken;

  @JacksonConstructor
  public RefreshRequest() {
  }

  public RefreshRequest(String token) {
    this.refreshToken = token;
  }
}
