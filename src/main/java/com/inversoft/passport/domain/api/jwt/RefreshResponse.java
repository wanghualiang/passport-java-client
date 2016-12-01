/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api.jwt;

import java.util.List;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.passport.domain.jwt.RefreshToken;
import com.inversoft.passport.domain.oauth2.AccessToken;

/**
 * @author Daniel DeGroff
 */
public class RefreshResponse {

  public List<RefreshToken> refreshTokens;

  public AccessToken token;

  @JacksonConstructor
  public RefreshResponse() {
  }

  public RefreshResponse(AccessToken token) {
    this.token = token;
  }

  public RefreshResponse(List<RefreshToken> refreshTokens) {
    this.refreshTokens = refreshTokens;
  }
}
