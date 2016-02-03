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
package com.inversoft.passport.domain.api;

import com.inversoft.passport.domain.NotificationServer;

import java.util.List;

/**
 * Notification Server API response object.
 *
 * @author Brian Pontarelli
 */
public class NotificationServerResponse {
  public NotificationServer notificationServer;

  public List<NotificationServer> notificationServers;

  public NotificationServerResponse() {
  }

  public NotificationServerResponse(NotificationServer notificationServer) {
    this.notificationServer = notificationServer;
  }

  public NotificationServerResponse(List<NotificationServer> notificationServers) {
    this.notificationServers = notificationServers;
  }
}