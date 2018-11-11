package com.neovisionaries.ws.client;

import java.net.InetSocketAddress;

/* compiled from: Address */
class a {
    private final String dZr;
    private final int dZs;
    private transient String dZt;

    a(String str, int i) {
        this.dZr = str;
        this.dZs = i;
    }

    InetSocketAddress aQd() {
        return new InetSocketAddress(this.dZr, this.dZs);
    }

    String getHostname() {
        return this.dZr;
    }

    public String toString() {
        if (this.dZt == null) {
            this.dZt = String.format("%s:%d", new Object[]{this.dZr, Integer.valueOf(this.dZs)});
        }
        return this.dZt;
    }
}
