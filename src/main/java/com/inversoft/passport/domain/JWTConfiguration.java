/*
 * Copyright (c) 2016-2017, Inversoft Inc., All Rights Reserved
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

import java.util.Objects;

import com.inversoft.json.ToString;
import org.primeframework.jwt.domain.Algorithm;

/**
 * JWT Configuration.
 *
 * @author Daniel DeGroff
 */
public class JWTConfiguration implements Buildable<JWTConfiguration> {

  public Algorithm algorithm;

  /**
   * True if this configuration is active. A JWT Configuration for an application may not be active if it is using the
   * global configuration provided int he System Configuration.
   */
  public boolean enabled;

  /**
   * The Issuer of the JWT.
   */
  public String issuer;

  /**
   * RSA Private Key used for RSA algorithms.
   */
  public String privateKey;

  /**
   * RSA Public Key used for RSA algorithms.
   */
  public String publicKey;

  /**
   * The length of time in minutes a Refresh Token is valid from the time it was issued. This should be a non-zero
   * value.
   */
  public Integer refreshTokenTimeToLiveInMinutes;

  /**
   * HMAC Secret used for HMAC algorithms.
   */
  public String secret;

  /**
   * The length of time in seconds this JWT is valid from the time it was issued. This should be a non-zero value.
   */
  public int timeToLiveInSeconds;

  public JWTConfiguration() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof JWTConfiguration)) {
      return false;
    }
    JWTConfiguration that = (JWTConfiguration) o;
    return Objects.equals(algorithm, that.algorithm) &&
        Objects.equals(enabled, that.enabled) &&
        Objects.equals(issuer, that.issuer) &&
        Objects.equals(privateKey, that.privateKey) &&
        Objects.equals(publicKey, that.publicKey) &&
        Objects.equals(refreshTokenTimeToLiveInMinutes, that.refreshTokenTimeToLiveInMinutes) &&
        Objects.equals(secret, that.secret) &&
        Objects.equals(timeToLiveInSeconds, that.timeToLiveInSeconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, enabled, issuer, privateKey, publicKey, refreshTokenTimeToLiveInMinutes, secret, timeToLiveInSeconds);
  }

  public void normalize() {
    // Normalize Line returns in the public / private keys
    if (publicKey != null) {
      publicKey = publicKey.replace("\r\n", "\n").replace("\r", "\n");
    }
    if (privateKey != null) {
      privateKey = privateKey.replace("\r\n", "\n").replace("\r", "\n");
    }
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
