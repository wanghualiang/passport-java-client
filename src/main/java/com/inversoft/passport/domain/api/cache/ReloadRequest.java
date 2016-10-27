/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.api.cache;

import com.inversoft.json.JacksonConstructor;

/**
 * @author Daniel DeGroff
 */
public class ReloadRequest {
  public String name;

  @JacksonConstructor
  public ReloadRequest() {
  }

  public ReloadRequest(String name) {
    this.name = name;
  }
}
