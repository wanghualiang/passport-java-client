/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inversoft.json.JacksonConstructor;

/**
 * JWT Response Object
 *
 * @author Daniel DeGroff
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JWTResponse {

  public String publicKey;

  @JacksonConstructor
  public JWTResponse() {
  }

  public JWTResponse(String publicKey) {
    this.publicKey = publicKey;
  }
}
