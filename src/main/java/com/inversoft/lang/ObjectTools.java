/*
 * Copyright (c) 2015, Inversoft Inc., All Rights Reserved
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
package com.inversoft.lang;

import java.util.function.Supplier;

/**
 * @author Daniel DeGroff
 */
public class ObjectTools {

  /**
   * If the provided object is null the supplier result will be returned.
   *
   * @param t        The object, may be null.
   * @param supplier The supplier which is expected to return a non null object of type T.
   * @param <T>
   * @return The provided object if non null, or the result of the supplier.
   */
  public static <T> T defaultIfNull(T t, Supplier<T> supplier) {
    return t == null ? supplier.get() : t;
  }
}