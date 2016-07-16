/*
 * Copyright (c) 2016, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Defines the format and allowable values for the free-form user data attributes on the Application and User objects.
 *
 * @author Brian Pontarelli
 */
public class DataDefinition implements Buildable<DataDefinition> {
  public Object defaultValue;

  public String displayName;

  public DataDefinition elements;

  public Number max;

  public Number min;

  public List<Object> options = new ArrayList<>();

  public Map<String, DataDefinition> properties = new LinkedHashMap<>();

  public String regex;

  public Boolean required;

  public DataType type;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DataDefinition)) {
      return false;
    }
    DataDefinition that = (DataDefinition) o;
    return Objects.equals(required, that.required) &&
        Objects.equals(defaultValue, that.defaultValue) &&
        Objects.equals(displayName, that.displayName) &&
        Objects.equals(elements, that.elements) &&
        Objects.equals(max, that.max) &&
        Objects.equals(min, that.min) &&
        Objects.equals(options, that.options) &&
        Objects.equals(properties, that.properties) &&
        Objects.equals(regex, that.regex) &&
        type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultValue, displayName, elements, max, min, options, properties, regex, required, type);
  }

  public enum DataType {
    string,
    number,
    decimal,
    integer,
    array,
    object,
    bool;

    @JsonCreator
    public static DataType forValue(String value) {
      if (value.equals("boolean")) {
        return DataType.bool;
      }
      return DataType.valueOf(value);
    }

    public String toString() {
      if (this == bool) {
        return "boolean";
      }

      return super.toString();
    }
  }
}
