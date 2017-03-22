/*
 * Copyright (c) 2017, Inversoft Inc., All Rights Reserved
 */
package com.inversoft.passport.domain;

/**
 * @author Brian Pontarelli
 */
public class LDAPServer {
  public boolean enabled;

  public ServerInfo serverInfo;

  public static class ServerInfo {
    public String host;

    public int port;

    public String bindDN;

    public String bindPassword;
  }
}
