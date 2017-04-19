/*
 * Copyright (c) 2017, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

import java.util.Objects;

import com.inversoft.json.ToString;

/**
 * Password Encryption Scheme Configuration
 *
 * @author Daniel DeGroff
 */
public class PasswordEncryptionConfiguration implements Buildable<PasswordEncryptionConfiguration> {

  public String encryptionScheme;

  public int encryptionSchemeFactor;

  public boolean modifyEncryptionSchemeOnLogin;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasswordEncryptionConfiguration that = (PasswordEncryptionConfiguration) o;
    return modifyEncryptionSchemeOnLogin == that.modifyEncryptionSchemeOnLogin &&
        Objects.equals(encryptionScheme, that.encryptionScheme) &&
        Objects.equals(encryptionSchemeFactor, that.encryptionSchemeFactor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptionScheme, encryptionSchemeFactor, modifyEncryptionSchemeOnLogin);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
