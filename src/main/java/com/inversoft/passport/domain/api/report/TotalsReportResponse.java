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
package com.inversoft.passport.domain.api.report;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;

/**
 * The response from the total report. This report stores the total numbers for each application.
 *
 * @author Brian Pontarelli
 */
public class TotalsReportResponse {
  public Map<UUID, Totals> applicationTotals = new HashMap<>();

  public long globalRegistrations;

  public static class Totals {
    public long logins;

    public long registrations;

    @JacksonConstructor
    public Totals() {
    }

    public Totals(long logins, long registrations) {
      this.logins = logins;
      this.registrations = registrations;
    }
  }
}
