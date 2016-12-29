/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api.jwt;

import com.inversoft.json.JacksonConstructor;
import org.primeframework.jwt.domain.JWT;

/**
 * @author Daniel DeGroff
 */
public class ValidateResponse {
  public JWT jwt;

  public String token;

  public ValidateResponse(JWT jwt, String token) {
    this.jwt = jwt;
    this.token = token;
  }

  @JacksonConstructor
  public ValidateResponse() {
  }
}
