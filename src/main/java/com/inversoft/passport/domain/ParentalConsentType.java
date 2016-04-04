/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

/**
 * Models the current parental consent type that a parent has given for a child.
 *
 * @author Brian Pontarelli
 */
public enum ParentalConsentType {
  /**
   * Older email only consent type.
   */
  EMAIL,

  /**
   * Email plus consent type from COPPA.
   */
  EMAIL_PLUS,

  /**
   * Full verifiable consent.
   */
  FULL,

  /**
   * The parent has revoked their consent for the child.
   */
  REVOKED
}
