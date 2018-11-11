package com.iqoption.service.websocket.a;

import android.support.annotation.Nullable;
import com.google.common.util.concurrent.y;
import com.iqoption.mobbtech.connect.RequestManager.Method;
import java.util.UUID;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestHandler */
public class b {
    @Nullable
    public final String cPL;
    @Nullable
    public final com.iqoption.mobbtech.connect.request.a.a.b dqx;
    @Nullable
    public final y dqy;
    private final long dqz;

    b(com.iqoption.mobbtech.connect.request.a.a.b bVar, y yVar, long j) {
        String auD = bVar.auD();
        if (auD == null) {
            auD = UUID.randomUUID().toString();
        }
        this.cPL = auD;
        this.dqx = bVar;
        this.dqy = yVar;
        this.dqz = j;
    }

    b(long j) {
        this.cPL = null;
        this.dqx = null;
        this.dqy = null;
        this.dqz = j;
    }

    @Nullable
    public String aDF() {
        return this.dqx != null ? this.dqx.auH().url().encodedPath().replaceAll("[-/]", "_").substring(1) : null;
    }

    public String aDG() {
        return this.dqx != null ? this.dqx.auC() : "";
    }

    public JSONObject aDH() {
        if (this.dqx == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        Request auH = this.dqx.auH();
        try {
            int i = 0;
            if (auH.method().equalsIgnoreCase(Method.GET.name())) {
                HttpUrl url = auH.url();
                while (i < url.querySize()) {
                    jSONObject.put(url.queryParameterName(i), url.queryParameterValue(i));
                    i++;
                }
            } else if (auH.body() instanceof FormBody) {
                FormBody formBody = (FormBody) auH.body();
                while (i < formBody.size()) {
                    String name = formBody.name(i);
                    if (name.endsWith("[]")) {
                        name = (name.length() - 1);
                    }
                    jSONObject.put(name, formBody.value(i));
                    i++;
                }
            }
        } catch (JSONException unused) {
            return jSONObject;
        }
    }

    public long aDI() {
        return this.dqz;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public static com.iqoption.service.websocket.a.a a(java.lang.String r2, java.lang.String r3, java.util.Map<java.lang.String, java.lang.Object> r4) {
        /*
        r0 = r2.hashCode();
        r1 = -714599587; // 0xffffffffd568135d float:-1.59481164E13 double:NaN;
        if (r0 == r1) goto L_0x0028;
    L_0x0009:
        r1 = 691453791; // 0x2936bf5f float:4.0578106E-14 double:3.41623564E-315;
        if (r0 == r1) goto L_0x001e;
    L_0x000e:
        r1 = 1427230710; // 0x5511cff6 float:1.00201482E13 double:7.051456625E-315;
        if (r0 == r1) goto L_0x0014;
    L_0x0013:
        goto L_0x0032;
    L_0x0014:
        r0 = "unsubscribeMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x001c:
        r2 = 2;
        goto L_0x0033;
    L_0x001e:
        r0 = "sendMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0026:
        r2 = 0;
        goto L_0x0033;
    L_0x0028:
        r0 = "subscribeMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0030:
        r2 = 1;
        goto L_0x0033;
    L_0x0032:
        r2 = -1;
    L_0x0033:
        switch(r2) {
            case 0: goto L_0x0044;
            case 1: goto L_0x003e;
            case 2: goto L_0x0038;
            default: goto L_0x0036;
        };
    L_0x0036:
        r2 = 0;
        goto L_0x0049;
    L_0x0038:
        r2 = new com.iqoption.service.websocket.a.e;
        r2.<init>(r3, r4);
        goto L_0x0049;
    L_0x003e:
        r2 = new com.iqoption.service.websocket.a.d;
        r2.<init>(r3, r4);
        goto L_0x0049;
    L_0x0044:
        r2 = new com.iqoption.service.websocket.a.c;
        r2.<init>(r3, r4);
    L_0x0049:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.service.websocket.a.b.a(java.lang.String, java.lang.String, java.util.Map):com.iqoption.service.websocket.a.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public static com.iqoption.service.websocket.a.a a(java.lang.String r2, com.iqoption.mobbtech.connect.request.a.a.b r3, com.google.common.util.concurrent.y r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
        r0 = r2.hashCode();
        r1 = -714599587; // 0xffffffffd568135d float:-1.59481164E13 double:NaN;
        if (r0 == r1) goto L_0x0028;
    L_0x0009:
        r1 = 691453791; // 0x2936bf5f float:4.0578106E-14 double:3.41623564E-315;
        if (r0 == r1) goto L_0x001e;
    L_0x000e:
        r1 = 1427230710; // 0x5511cff6 float:1.00201482E13 double:7.051456625E-315;
        if (r0 == r1) goto L_0x0014;
    L_0x0013:
        goto L_0x0032;
    L_0x0014:
        r0 = "unsubscribeMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x001c:
        r2 = 2;
        goto L_0x0033;
    L_0x001e:
        r0 = "sendMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0026:
        r2 = 0;
        goto L_0x0033;
    L_0x0028:
        r0 = "subscribeMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0030:
        r2 = 1;
        goto L_0x0033;
    L_0x0032:
        r2 = -1;
    L_0x0033:
        switch(r2) {
            case 0: goto L_0x0044;
            case 1: goto L_0x003e;
            case 2: goto L_0x0038;
            default: goto L_0x0036;
        };
    L_0x0036:
        r2 = 0;
        goto L_0x0049;
    L_0x0038:
        r2 = new com.iqoption.service.websocket.a.e;
        r2.<init>(r3, r4, r5, r6);
        goto L_0x0049;
    L_0x003e:
        r2 = new com.iqoption.service.websocket.a.d;
        r2.<init>(r3, r4, r5, r6);
        goto L_0x0049;
    L_0x0044:
        r2 = new com.iqoption.service.websocket.a.c;
        r2.<init>(r3, r4, r5, r6);
    L_0x0049:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.service.websocket.a.b.a(java.lang.String, com.iqoption.mobbtech.connect.request.a.a.b, com.google.common.util.concurrent.y, java.lang.String, java.util.Map):com.iqoption.service.websocket.a.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    public static com.iqoption.service.websocket.a.a a(java.lang.String r2, com.iqoption.mobbtech.connect.request.a.a.b r3, com.google.common.util.concurrent.y r4, java.lang.String r5, org.json.JSONObject r6) {
        /*
        r0 = r2.hashCode();
        r1 = -714599587; // 0xffffffffd568135d float:-1.59481164E13 double:NaN;
        if (r0 == r1) goto L_0x0028;
    L_0x0009:
        r1 = 691453791; // 0x2936bf5f float:4.0578106E-14 double:3.41623564E-315;
        if (r0 == r1) goto L_0x001e;
    L_0x000e:
        r1 = 1427230710; // 0x5511cff6 float:1.00201482E13 double:7.051456625E-315;
        if (r0 == r1) goto L_0x0014;
    L_0x0013:
        goto L_0x0032;
    L_0x0014:
        r0 = "unsubscribeMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x001c:
        r2 = 2;
        goto L_0x0033;
    L_0x001e:
        r0 = "sendMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0026:
        r2 = 0;
        goto L_0x0033;
    L_0x0028:
        r0 = "subscribeMessage";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0032;
    L_0x0030:
        r2 = 1;
        goto L_0x0033;
    L_0x0032:
        r2 = -1;
    L_0x0033:
        switch(r2) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0040;
            case 2: goto L_0x0038;
            default: goto L_0x0036;
        };
    L_0x0036:
        r2 = 0;
        goto L_0x004d;
    L_0x0038:
        r2 = new java.lang.RuntimeException;
        r3 = "not supported for TYPE_UNSUBSCRIBE";
        r2.<init>(r3);
        throw r2;
    L_0x0040:
        r2 = new java.lang.RuntimeException;
        r3 = "not supported for TYPE_SUBSCRIBE";
        r2.<init>(r3);
        throw r2;
    L_0x0048:
        r2 = new com.iqoption.service.websocket.a.c;
        r2.<init>(r3, r4, r5, r6);
    L_0x004d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.service.websocket.a.b.a(java.lang.String, com.iqoption.mobbtech.connect.request.a.a.b, com.google.common.util.concurrent.y, java.lang.String, org.json.JSONObject):com.iqoption.service.websocket.a.a");
    }

    public static b a(com.iqoption.mobbtech.connect.request.a.a.b bVar, y yVar, long j) {
        return new b(bVar, yVar, j);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RequestHandler{requestId='");
        stringBuilder.append(this.cPL);
        stringBuilder.append('\'');
        stringBuilder.append(", requestTask=");
        stringBuilder.append(this.dqx);
        stringBuilder.append(", settableFuture=");
        stringBuilder.append(this.dqy);
        stringBuilder.append(", requestTimeout=");
        stringBuilder.append(this.dqz);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
