/*
 * Copyright (c) 2015-2016, Inversoft Inc., All Rights Reserved
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
package com.inversoft.passport.domain.oauth2;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inversoft.json.ToString;
import static com.inversoft.passport.domain.util.Normalizer.removeEmpty;
import static com.inversoft.passport.domain.util.Normalizer.trim;

/**
 * @author Daniel DeGroff
 */
// Ignore grantType, it is deprecated it may still exist in the database.
@JsonIgnoreProperties({"grantType"})
public class OAuth2Configuration {
  public List<URI> authorizedOriginURLs = new ArrayList<>();

  public List<URI> authorizedRedirectURLs = new ArrayList<>();

  public String clientId;

  public String clientSecret;

  /**
   * Length of time in seconds after the authorization code has been generated that it will be considered valid for
   * exchange for an access token. <p>Must be less than or equal to 600 seconds - or 10 minutes.</p>
   */
  public int codeExpiresInSeconds = 30;

  /**
   * Logout redirect URL when calling the <code>/oauth2/logout</code> endpoint. If this is left null,
   * <code>Application.oauthConfiguration.logoutURL</code> will be used instead.
   */
  public URI logoutURL;

  /**
   * Length of time in seconds after the exchange of an authorization code for an access token that the access token is
   * valid.
   */
  public int tokenExpiresInSeconds = 3600;

  public OAuth2Configuration() {
  }

  public OAuth2Configuration(String clientId, String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OAuth2Configuration)) {
      return false;
    }
    OAuth2Configuration that = (OAuth2Configuration) o;
    return Objects.equals(authorizedOriginURLs, that.authorizedOriginURLs) &&
        Objects.equals(authorizedRedirectURLs, that.authorizedRedirectURLs) &&
        Objects.equals(clientId, that.clientId) &&
        Objects.equals(clientSecret, that.clientSecret) &&
        Objects.equals(codeExpiresInSeconds, that.codeExpiresInSeconds) &&
        Objects.equals(logoutURL, that.logoutURL) &&
        Objects.equals(tokenExpiresInSeconds, that.tokenExpiresInSeconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorizedOriginURLs, authorizedRedirectURLs, clientId, clientSecret, codeExpiresInSeconds,
        logoutURL, tokenExpiresInSeconds);
  }

  public void normalize() {
    removeEmpty(authorizedOriginURLs);
    removeEmpty(authorizedRedirectURLs);
    clientId = trim(clientId);
    clientSecret = trim(clientSecret);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
