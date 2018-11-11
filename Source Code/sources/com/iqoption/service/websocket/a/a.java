package com.iqoption.service.websocket.a;

import com.google.common.util.concurrent.y;
import com.iqoption.mobbtech.connect.request.a.a.b;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: IQBusRequestHandler */
public abstract class a extends b {
    protected final Map<String, Object> anH;
    protected final String apiName;
    protected String cUR = null;
    protected final JSONObject cVl;
    private final String dqw;
    public String version = "1.0";

    a(String str, String str2, Map<String, Object> map, long j) {
        super(j);
        this.dqw = str;
        this.apiName = str2;
        this.anH = map;
        this.cVl = null;
    }

    a(String str, b bVar, y yVar, String str2, Map<String, Object> map, long j) {
        super(bVar, yVar, j);
        this.dqw = str;
        this.apiName = str2;
        this.anH = map;
        this.cVl = null;
    }

    a(String str, b bVar, y yVar, String str2, JSONObject jSONObject, long j) {
        super(bVar, yVar, j);
        this.dqw = str;
        this.apiName = str2;
        this.anH = null;
        this.cVl = jSONObject;
    }

    public String aDF() {
        return this.dqw;
    }

    public String aDG() {
        return this.apiName;
    }

    public a jJ(String str) {
        this.version = str;
        return this;
    }

    public a jK(String str) {
        this.cUR = str;
        return this;
    }
}
