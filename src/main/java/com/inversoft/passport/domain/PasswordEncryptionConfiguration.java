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

  public String defaultEncryptionScheme;

  public int defaultEncryptionSchemeFactor;

  public boolean upgradeEncryptionSchemeOnLogin;

  public String upgradedEncryptionScheme;

  public int upgradedEncryptionSchemeFactor;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PasswordEncryptionConfiguration that = (PasswordEncryptionConfiguration) o;
    return upgradeEncryptionSchemeOnLogin == that.upgradeEncryptionSchemeOnLogin &&
        Objects.equals(defaultEncryptionScheme, that.defaultEncryptionScheme) &&
        Objects.equals(defaultEncryptionSchemeFactor, that.defaultEncryptionSchemeFactor) &&
        Objects.equals(upgradedEncryptionScheme, that.upgradedEncryptionScheme) &&
        Objects.equals(upgradedEncryptionSchemeFactor, that.upgradedEncryptionSchemeFactor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultEncryptionScheme, defaultEncryptionSchemeFactor, upgradedEncryptionScheme, upgradedEncryptionSchemeFactor, upgradeEncryptionSchemeOnLogin);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
