package io.fabric.sdk.android.services.settings;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DefaultSettingsSpiCall */
class l extends a implements w {
    boolean jb(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public l(h hVar, String str, String str2, c cVar) {
        this(hVar, str, str2, cVar, HttpMethod.GET);
    }

    l(h hVar, String str, String str2, c cVar, HttpMethod httpMethod) {
        super(hVar, str, str2, cVar, httpMethod);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad  */
    public org.json.JSONObject a(io.fabric.sdk.android.services.settings.v r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.b(r8);	 Catch:{ HttpRequestException -> 0x007a, all -> 0x0075 }
        r2 = r7.J(r1);	 Catch:{ HttpRequestException -> 0x007a, all -> 0x0075 }
        r8 = r7.a(r2, r8);	 Catch:{ HttpRequestException -> 0x0072, all -> 0x006f }
        r2 = io.fabric.sdk.android.c.aUg();	 Catch:{ HttpRequestException -> 0x006d }
        r3 = "Fabric";
        r4 = new java.lang.StringBuilder;	 Catch:{ HttpRequestException -> 0x006d }
        r4.<init>();	 Catch:{ HttpRequestException -> 0x006d }
        r5 = "Requesting settings from ";
        r4.append(r5);	 Catch:{ HttpRequestException -> 0x006d }
        r5 = r7.getUrl();	 Catch:{ HttpRequestException -> 0x006d }
        r4.append(r5);	 Catch:{ HttpRequestException -> 0x006d }
        r4 = r4.toString();	 Catch:{ HttpRequestException -> 0x006d }
        r2.d(r3, r4);	 Catch:{ HttpRequestException -> 0x006d }
        r2 = io.fabric.sdk.android.c.aUg();	 Catch:{ HttpRequestException -> 0x006d }
        r3 = "Fabric";
        r4 = new java.lang.StringBuilder;	 Catch:{ HttpRequestException -> 0x006d }
        r4.<init>();	 Catch:{ HttpRequestException -> 0x006d }
        r5 = "Settings query params were: ";
        r4.append(r5);	 Catch:{ HttpRequestException -> 0x006d }
        r4.append(r1);	 Catch:{ HttpRequestException -> 0x006d }
        r1 = r4.toString();	 Catch:{ HttpRequestException -> 0x006d }
        r2.d(r3, r1);	 Catch:{ HttpRequestException -> 0x006d }
        r1 = r7.b(r8);	 Catch:{ HttpRequestException -> 0x006d }
        if (r8 == 0) goto L_0x006b;
    L_0x004b:
        r0 = io.fabric.sdk.android.c.aUg();
        r2 = "Fabric";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Settings request ID: ";
        r3.append(r4);
        r4 = "X-REQUEST-ID";
        r8 = r8.header(r4);
        r3.append(r8);
        r8 = r3.toString();
        r0.d(r2, r8);
    L_0x006b:
        r0 = r1;
        goto L_0x00a9;
    L_0x006d:
        r1 = move-exception;
        goto L_0x007c;
    L_0x006f:
        r0 = move-exception;
        r8 = r2;
        goto L_0x00ab;
    L_0x0072:
        r1 = move-exception;
        r8 = r2;
        goto L_0x007c;
    L_0x0075:
        r8 = move-exception;
        r6 = r0;
        r0 = r8;
        r8 = r6;
        goto L_0x00ab;
    L_0x007a:
        r1 = move-exception;
        r8 = r0;
    L_0x007c:
        r2 = io.fabric.sdk.android.c.aUg();	 Catch:{ all -> 0x00aa }
        r3 = "Fabric";
        r4 = "Settings request failed.";
        r2.e(r3, r4, r1);	 Catch:{ all -> 0x00aa }
        if (r8 == 0) goto L_0x00a9;
    L_0x0089:
        r1 = io.fabric.sdk.android.c.aUg();
        r2 = "Fabric";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Settings request ID: ";
        r3.append(r4);
        r4 = "X-REQUEST-ID";
        r8 = r8.header(r4);
        r3.append(r8);
        r8 = r3.toString();
        r1.d(r2, r8);
    L_0x00a9:
        return r0;
    L_0x00aa:
        r0 = move-exception;
    L_0x00ab:
        if (r8 == 0) goto L_0x00cd;
    L_0x00ad:
        r1 = io.fabric.sdk.android.c.aUg();
        r2 = "Fabric";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Settings request ID: ";
        r3.append(r4);
        r4 = "X-REQUEST-ID";
        r8 = r8.header(r4);
        r3.append(r8);
        r8 = r3.toString();
        r1.d(r2, r8);
    L_0x00cd:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.settings.l.a(io.fabric.sdk.android.services.settings.v):org.json.JSONObject");
    }

    JSONObject b(HttpRequest httpRequest) {
        int code = httpRequest.code();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Settings result was: ");
        stringBuilder.append(code);
        io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder.toString());
        if (jb(code)) {
            return lQ(httpRequest.aVv());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to retrieve settings from ");
        stringBuilder2.append(getUrl());
        io.fabric.sdk.android.c.aUg().e("Fabric", stringBuilder2.toString());
        return null;
    }

    private JSONObject lQ(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse settings JSON from ");
            stringBuilder.append(getUrl());
            io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder.toString(), e);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Settings response ");
            stringBuilder2.append(str);
            io.fabric.sdk.android.c.aUg().d("Fabric", stringBuilder2.toString());
            return null;
        }
    }

    private Map<String, String> b(v vVar) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", vVar.eoY);
        hashMap.put("display_version", vVar.eoX);
        hashMap.put(b.SOURCE, Integer.toString(vVar.epa));
        if (vVar.epW != null) {
            hashMap.put("icon_hash", vVar.epW);
        }
        String str = vVar.epV;
        if (!CommonUtils.bc(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private HttpRequest a(HttpRequest httpRequest, v vVar) {
        a(httpRequest, "X-CRASHLYTICS-API-KEY", vVar.sO);
        a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.rR.getVersion());
        a(httpRequest, "Accept", "application/json");
        a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", vVar.ti);
        a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", vVar.epT);
        a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", vVar.epU);
        a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", vVar.te);
        return httpRequest;
    }

    private void a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.aS(str, str2);
        }
    }
}
