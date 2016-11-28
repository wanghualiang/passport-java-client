/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain.search;


import java.util.ArrayList;
import java.util.List;

import com.inversoft.json.ToString;

/**
 * @author Daniel DeGroff
 */
public class SortFields {

  public List<String> fields = new ArrayList<>(1);

  /**
   * Sets the value when a field is missing. Can also be set to <code>_last</code> or
   * <code>_first</code> to sort missing last or first respectively.
   */
  public String missing = "_last";

  /**
   * Sort ascending or descending;
   */
  public Sort order = Sort.asc;

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
