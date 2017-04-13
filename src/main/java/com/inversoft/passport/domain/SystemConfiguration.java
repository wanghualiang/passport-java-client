/*
 * Copyright (c) 2015-2017, Inversoft Inc., All Rights Reserved
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

import java.net.URI;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import com.inversoft.passport.domain.event.EventType;

/**
 * @author Brian Pontarelli
 */
public class SystemConfiguration implements Buildable<SystemConfiguration> {
  public CleanSpeakConfiguration cleanSpeakConfiguration = new CleanSpeakConfiguration();

  @JsonUnwrapped
  public SystemConfigurationData data = new SystemConfigurationData();

  public EmailConfiguration emailConfiguration = new EmailConfiguration();

  /**
   * Id of the User Action used when a user reaches the threshold defined by <code>tooManyAttempts</code>.
   */
  public UUID failedAuthenticationUserActionId;

  public UUID forgotEmailTemplateId;

  /**
   * Time in seconds until an inactive session will be invalidated. Used when creating a new session in the
   * Passport-FrontEnd.
   * <p>
   * Default is 60 minutes.
   */
  public int httpSessionMaxInactiveInterval = 3600;

  /**
   * Logout redirect URL when calling the <code>/oauth2/logout</code> endpoint. If this the
   * <code>Application.oauthConfiguration.logoutURL</code> is defined it will be used instead.
   */
  public URI logoutURL;

  public URI passportFrontendURL;

  public Integer passwordExpirationDays;

  public PasswordValidationRules passwordValidationRules = new PasswordValidationRules();

  public ZoneId reportTimezone;

  public UUID setPasswordEmailTemplateId;

  public boolean useOauthForBackend;

  public UUID verificationEmailTemplateId;

  public boolean verifyEmail;

  public boolean verifyEmailWhenChanged;

  public SystemConfiguration() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SystemConfiguration)) {
      return false;
    }
    SystemConfiguration that = (SystemConfiguration) o;
    return Objects.equals(cleanSpeakConfiguration, that.cleanSpeakConfiguration) &&
        Objects.equals(emailConfiguration, that.emailConfiguration) &&
        Objects.equals(data, that.data) &&
        Objects.equals(failedAuthenticationUserActionId, that.failedAuthenticationUserActionId) &&
        Objects.equals(forgotEmailTemplateId, that.forgotEmailTemplateId) &&
        Objects.equals(httpSessionMaxInactiveInterval, that.httpSessionMaxInactiveInterval) &&
        Objects.equals(logoutURL, that.logoutURL) &&
        Objects.equals(reportTimezone, that.reportTimezone) &&
        Objects.equals(passportFrontendURL, that.passportFrontendURL) &&
        Objects.equals(passwordExpirationDays, that.passwordExpirationDays) &&
        Objects.equals(passwordValidationRules, that.passwordValidationRules) &&
        Objects.equals(setPasswordEmailTemplateId, that.setPasswordEmailTemplateId) &&
        Objects.equals(useOauthForBackend, that.useOauthForBackend) &&
        Objects.equals(verifyEmail, that.verifyEmail) &&
        Objects.equals(verifyEmailWhenChanged, that.verifyEmailWhenChanged) &&
        Objects.equals(verificationEmailTemplateId, that.verificationEmailTemplateId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cleanSpeakConfiguration, data, failedAuthenticationUserActionId, forgotEmailTemplateId, httpSessionMaxInactiveInterval,
                        logoutURL, reportTimezone, passportFrontendURL, passwordExpirationDays, passwordValidationRules,
                        setPasswordEmailTemplateId, useOauthForBackend, verificationEmailTemplateId, verifyEmail, verifyEmailWhenChanged);
  }

  public void normalize() {
    if (cleanSpeakConfiguration != null) {
      cleanSpeakConfiguration.normalize();
    }

    // Normalize Line returns in the public / private keys
    if (data.jwtConfiguration != null) {
      data.jwtConfiguration.normalize();
    }
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }

  public static class EmailConfiguration implements Buildable<EmailConfiguration> {
    public String host = "localhost";

    public String password;

    public int port = 25;

    public EmailSecurityType security;

    public String username;

    public EmailConfiguration() {
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof EmailConfiguration)) {
        return false;
      }
      EmailConfiguration that = (EmailConfiguration) o;
      return Objects.equals(port, that.port) &&
          Objects.equals(host, that.host) &&
          Objects.equals(password, that.password) &&
          security == that.security &&
          Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
      return Objects.hash(host, password, port, security, username);
    }

    public enum EmailSecurityType {
      NONE,
      SSL,
      TLS
    }
  }

  public static class SystemConfigurationData {
    /**
     * List of one or more Passport Backend Servers. This list of systems is used to distribute cache reload
     * notifications.
     */
    public List<URI> backendServers = new ArrayList<>(1);

    /**
     * Base64 encoded Initialization Vector for prime-mvc. This is currently only used to encrypt and de-crypt saved
     * request cookies.
     */
    public String cookieEncryptionIV;

    /**
     * Base64 encoded Encryption Key for prime-mvc. This is currently only used to encrypt and de-crypt saved request
     * cookies.
     */
    public String cookieEncryptionKey;

    public EventConfiguration eventConfiguration = new EventConfiguration();

    /**
     * Failed Authentication Cache.
     */
    public FailedAuthenticationConfiguration failedAuthenticationConfiguration = new FailedAuthenticationConfiguration();

    /**
     * Global System JWT Configuration used to sign and drop a JWT cookie on a successful login.
     */
    public JWTConfiguration jwtConfiguration = new JWTConfiguration();

    public PasswordEncryptionConfiguration passwordEncryptionConfiguration = new PasswordEncryptionConfiguration();

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      SystemConfigurationData that = (SystemConfigurationData) o;
      return Objects.equals(backendServers, that.backendServers) &&
          Objects.equals(cookieEncryptionIV, that.cookieEncryptionIV) &&
          Objects.equals(cookieEncryptionKey, that.cookieEncryptionKey) &&
          Objects.equals(failedAuthenticationConfiguration, that.failedAuthenticationConfiguration) &&
          Objects.equals(jwtConfiguration, that.jwtConfiguration) &&
          Objects.equals(passwordEncryptionConfiguration, that.passwordEncryptionConfiguration);
    }

    @Override
    public int hashCode() {
      return Objects.hash(backendServers, cookieEncryptionIV, cookieEncryptionKey, failedAuthenticationConfiguration, jwtConfiguration, passwordEncryptionConfiguration);
    }

    @Override
    public String toString() {
      return ToString.toString(this);
    }

    public static class EventConfiguration implements Buildable<EventConfiguration> {
      public Map<EventType, EventConfigurationData> events = new HashMap<>();

      public static class EventConfigurationData {
        public boolean enabled;

        public TransactionType transactionType;

        @JacksonConstructor
        public EventConfigurationData() {
        }

        public EventConfigurationData(boolean enabled, TransactionType transactionType) {
          this.enabled = enabled;
          this.transactionType = transactionType;
        }
      }
    }
  }
}
