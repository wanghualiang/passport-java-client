/*
 * Copyright (c) 2017, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

/**
 * The transaction types for Webhooks and other event systems within Passport.
 *
 * @author Brian Pontarelli
 */
public enum TransactionType {
  None,
  Any,
  SimpleMajority,
  SuperMajority,
  AbsoluteMajority;

  public boolean success(int size, int successCount) {
    switch (this) {
      case None:
        return true;
      case Any:
        return successCount > 0;
      case SimpleMajority:
        return successCount >= ((double) size / 2.0d);
      case SuperMajority:
        return successCount >= ((double) size / 3.0d) * 2.0d;
      case AbsoluteMajority:
        return successCount == size;
    }

    return false;
  }
}
