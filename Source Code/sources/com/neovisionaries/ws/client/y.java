package com.neovisionaries.ws.client;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.SocketFactory;

/* compiled from: ProxySettings */
public class y {
    private boolean dZD;
    private String dZr;
    private int dZs;
    private final ai eai;
    private final ac eaj = new ac();
    private String eak;
    private String[] eal;
    private final Map<String, List<String>> mHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private String mId;

    y(ai aiVar) {
        this.eai = aiVar;
        aQw();
    }

    public y aQw() {
        this.dZD = false;
        this.dZr = null;
        this.dZs = -1;
        this.mId = null;
        this.eak = null;
        this.mHeaders.clear();
        this.eal = null;
        return this;
    }

    public boolean isSecure() {
        return this.dZD;
    }

    public String getHost() {
        return this.dZr;
    }

    public int getPort() {
        return this.dZs;
    }

    public String getId() {
        return this.mId;
    }

    public String getPassword() {
        return this.eak;
    }

    public Map<String, List<String>> getHeaders() {
        return this.mHeaders;
    }

    SocketFactory aQx() {
        return this.eaj.fQ(this.dZD);
    }

    public String[] aQy() {
        return this.eal;
    }
}
