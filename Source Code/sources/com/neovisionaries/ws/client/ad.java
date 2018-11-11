package com.neovisionaries.ws.client;

/* compiled from: StatusLine */
public class ad {
    private final String dZt;
    private final String eaI;
    private final String eaJ;
    private final int mStatusCode;

    ad(String str) {
        String[] split = str.split(" +", 3);
        if (split.length < 2) {
            throw new IllegalArgumentException();
        }
        this.eaI = split[0];
        this.mStatusCode = Integer.parseInt(split[1]);
        this.eaJ = split.length == 3 ? split[2] : null;
        this.dZt = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String toString() {
        return this.dZt;
    }
}
