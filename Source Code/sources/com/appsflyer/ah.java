package com.appsflyer;

import android.content.pm.PackageManager;
import android.os.AsyncTask;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ah {
    private static ah rm;
    private boolean pP;
    private final String pk;
    private final String po;
    private final String pp;
    private final String pq;
    private boolean qh;
    private boolean qn;
    private final String rA;
    private final String rB;
    private final String rC;
    private final String rD;
    private final String rE;
    private JSONObject rF;
    private JSONArray rG;
    private int rH;
    private String rI;
    private final String rn;
    private final String ro;
    private final String rp;
    private final String rq;
    private final String rr;
    private final String rs;
    private final String rt;
    private final String ru;
    private final String rv;
    private final String rw;
    private final String rx;
    private final String ry;
    private final String rz;
    private final String ʼ;
    private final String ᐝ;

    private ah() {
        this.qh = true;
        this.qn = true;
        this.po = "brand";
        this.pk = "model";
        this.ʼ = "platform";
        this.pq = "platform_version";
        this.pp = "advertiserId";
        this.rn = "imei";
        this.ᐝ = "android_id";
        this.ro = "sdk_version";
        this.rp = "devkey";
        this.rq = "originalAppsFlyerId";
        this.rr = "uid";
        this.rs = "app_id";
        this.rt = "app_version";
        this.ru = "channel";
        this.rv = "preInstall";
        this.rw = "data";
        this.rx = "r_debugging_off";
        this.ry = "r_debugging_on";
        this.rz = "public_api_call";
        this.rA = "exception";
        this.rB = "server_request";
        this.rC = "server_response";
        this.rD = "yyyy-MM-dd HH:mm:ssZ";
        this.rE = "MM-dd HH:mm:ss.SSS";
        this.rH = 0;
        this.rI = "-1";
        this.rG = new JSONArray();
        this.rH = 0;
        this.pP = false;
    }

    static ah ge() {
        if (rm == null) {
            rm = new ah();
        }
        return rm;
    }

    final synchronized void ah(String str) {
        this.rI = str;
    }

    final synchronized void fO() {
        this.pP = true;
        a("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    final synchronized void fz() {
        a("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.pP = false;
        this.qh = false;
    }

    final synchronized void ft() {
        this.rF = null;
        this.rG = null;
        rm = null;
    }

    private synchronized void a(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.rF.put("brand", str);
            this.rF.put("model", str2);
            this.rF.put("platform", "Android");
            this.rF.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.rF.put("advertiserId", str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.rF.put("imei", str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.rF.put("android_id", str6);
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void a(String str, String str2, String str3, String str4) {
        try {
            this.rF.put("sdk_version", str);
            if (str2 != null && str2.length() > 0) {
                this.rF.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.rF.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.rF.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void b(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.rF.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.rF.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.rF.put("channel", str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.rF.put("preInstall", str4);
        }
    }

    final void a(String str, String... strArr) {
        a("public_api_call", str, strArr);
    }

    final void b(Throwable th) {
        String[] strArr;
        Throwable cause = th.getCause();
        String str = "exception";
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        int i = 1;
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[(stackTrace.length + 1)];
            strArr2[0] = message;
            while (i < stackTrace.length) {
                strArr2[i] = stackTrace[i].toString();
                i++;
            }
            strArr = strArr2;
        }
        a(str, simpleName, strArr);
    }

    final void j(String str, String str2) {
        a("server_request", str, str2);
    }

    final void a(String str, int i, String str2) {
        a("server_response", str, String.valueOf(i), str2);
    }

    final void h(String str, String str2) {
        a(null, str, str2);
    }

    private synchronized String gf() {
        String jSONObject;
        try {
            this.rF.put("data", this.rG);
            jSONObject = this.rF.toString();
            try {
                gg();
            } catch (JSONException unused) {
                return jSONObject;
            }
        } catch (JSONException unused2) {
            jSONObject = null;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:14:?, code:
            r10.rF.put("launch_counter", r10.rI);
     */
    /* JADX WARNING: Missing block: B:16:0x007a, code:
            return;
     */
    private synchronized void b(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = com.appsflyer.i.fF();	 Catch:{ all -> 0x0081 }
        r1 = com.appsflyer.h.fA();	 Catch:{ all -> 0x0081 }
        r2 = "remote_debug_static_data";
        r2 = r0.getString(r2);	 Catch:{ all -> 0x0081 }
        if (r2 == 0) goto L_0x0019;
    L_0x0011:
        r11 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0070 }
        r11.<init>(r2);	 Catch:{ Throwable -> 0x0070 }
        r10.rF = r11;	 Catch:{ Throwable -> 0x0070 }
        goto L_0x0070;
    L_0x0019:
        r2 = new org.json.JSONObject;	 Catch:{ all -> 0x0081 }
        r2.<init>();	 Catch:{ all -> 0x0081 }
        r10.rF = r2;	 Catch:{ all -> 0x0081 }
        r4 = android.os.Build.BRAND;	 Catch:{ all -> 0x0081 }
        r5 = android.os.Build.MODEL;	 Catch:{ all -> 0x0081 }
        r6 = android.os.Build.VERSION.RELEASE;	 Catch:{ all -> 0x0081 }
        r2 = "advertiserId";
        r7 = r0.getString(r2);	 Catch:{ all -> 0x0081 }
        r8 = r1.pk;	 Catch:{ all -> 0x0081 }
        r9 = r1.pJ;	 Catch:{ all -> 0x0081 }
        r3 = r10;
        r3.a(r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0081 }
        r1 = "4.8.15.395";
        r2 = "AppsFlyerKey";
        r2 = r0.getString(r2);	 Catch:{ all -> 0x0081 }
        r3 = "KSAppsFlyerId";
        r3 = r0.getString(r3);	 Catch:{ all -> 0x0081 }
        r4 = "uid";
        r4 = r0.getString(r4);	 Catch:{ all -> 0x0081 }
        r10.a(r1, r2, r3, r4);	 Catch:{ all -> 0x0081 }
        r1 = 0;
        r12 = r12.getPackageInfo(r11, r1);	 Catch:{ Throwable -> 0x0065 }
        r12 = r12.versionCode;	 Catch:{ Throwable -> 0x0065 }
        r1 = "channel";
        r1 = r0.getString(r1);	 Catch:{ Throwable -> 0x0065 }
        r2 = "preInstallName";
        r2 = r0.getString(r2);	 Catch:{ Throwable -> 0x0065 }
        r12 = java.lang.String.valueOf(r12);	 Catch:{ Throwable -> 0x0065 }
        r10.b(r11, r12, r1, r2);	 Catch:{ Throwable -> 0x0065 }
    L_0x0065:
        r11 = "remote_debug_static_data";
        r12 = r10.rF;	 Catch:{ all -> 0x0081 }
        r12 = r12.toString();	 Catch:{ all -> 0x0081 }
        r0.set(r11, r12);	 Catch:{ all -> 0x0081 }
    L_0x0070:
        r11 = r10.rF;	 Catch:{ JSONException -> 0x007b }
        r12 = "launch_counter";
        r0 = r10.rI;	 Catch:{ JSONException -> 0x007b }
        r11.put(r12, r0);	 Catch:{ JSONException -> 0x007b }
        monitor-exit(r10);
        return;
    L_0x007b:
        r11 = move-exception;
        r11.printStackTrace();	 Catch:{ all -> 0x0081 }
        monitor-exit(r10);
        return;
    L_0x0081:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.ah.b(java.lang.String, android.content.pm.PackageManager):void");
    }

    private synchronized void gg() {
        this.rG = null;
        this.rG = new JSONArray();
        this.rH = 0;
    }

    final synchronized void gh() {
        this.qh = false;
        gg();
    }

    final boolean gi() {
        return this.pP;
    }

    static void a(String str, PackageManager packageManager) {
        try {
            if (rm == null) {
                rm = new ah();
            }
            rm.b(str, packageManager);
            if (rm == null) {
                rm = new ah();
            }
            String gf = rm.gf();
            AsyncTask abVar = new ab(null, h.fA().fB());
            abVar.pJ = gf;
            abVar.fz();
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(q.aA("https://monitorsdk.%s/remote-debug?app_id="));
            stringBuilder.append(str);
            strArr[0] = stringBuilder.toString();
            abVar.execute(strArr);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing block: B:31:0x00b4, code:
            return;
     */
    private synchronized void a(java.lang.String r12, java.lang.String r13, java.lang.String... r14) {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r11.qn;	 Catch:{ all -> 0x00b5 }
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x0007:
        r0 = r11.qh;	 Catch:{ all -> 0x00b5 }
        if (r0 != 0) goto L_0x000f;
    L_0x000b:
        r0 = r11.pP;	 Catch:{ all -> 0x00b5 }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        r0 = 1;
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        if (r0 == 0) goto L_0x00b3;
    L_0x0014:
        r0 = r11.rH;	 Catch:{ all -> 0x00b5 }
        r3 = 98304; // 0x18000 float:1.37753E-40 double:4.85686E-319;
        if (r0 < r3) goto L_0x001d;
    L_0x001b:
        goto L_0x00b3;
    L_0x001d:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00b1 }
        r0 = "";
        r5 = r14.length;	 Catch:{ Throwable -> 0x00b1 }
        if (r5 <= 0) goto L_0x0045;
    L_0x0026:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b1 }
        r0.<init>();	 Catch:{ Throwable -> 0x00b1 }
        r5 = r14.length;	 Catch:{ Throwable -> 0x00b1 }
        r5 = r5 - r2;
    L_0x002d:
        if (r5 <= 0) goto L_0x003c;
    L_0x002f:
        r6 = r14[r5];	 Catch:{ Throwable -> 0x00b1 }
        r0.append(r6);	 Catch:{ Throwable -> 0x00b1 }
        r6 = ", ";
        r0.append(r6);	 Catch:{ Throwable -> 0x00b1 }
        r5 = r5 + -1;
        goto L_0x002d;
    L_0x003c:
        r14 = r14[r1];	 Catch:{ Throwable -> 0x00b1 }
        r0.append(r14);	 Catch:{ Throwable -> 0x00b1 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00b1 }
    L_0x0045:
        r14 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x00b1 }
        r5 = "MM-dd HH:mm:ss.SSS";
        r6 = java.util.Locale.ENGLISH;	 Catch:{ Throwable -> 0x00b1 }
        r14.<init>(r5, r6);	 Catch:{ Throwable -> 0x00b1 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ Throwable -> 0x00b1 }
        r14 = r14.format(r3);	 Catch:{ Throwable -> 0x00b1 }
        r3 = 5;
        r4 = 4;
        r5 = 3;
        r6 = 2;
        if (r12 == 0) goto L_0x0080;
    L_0x005c:
        r7 = "%18s %5s _/%s [%s] %s %s";
        r8 = 6;
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x00b1 }
        r8[r1] = r14;	 Catch:{ Throwable -> 0x00b1 }
        r14 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x00b1 }
        r9 = r14.getId();	 Catch:{ Throwable -> 0x00b1 }
        r14 = java.lang.Long.valueOf(r9);	 Catch:{ Throwable -> 0x00b1 }
        r8[r2] = r14;	 Catch:{ Throwable -> 0x00b1 }
        r14 = "AppsFlyer_4.8.15";
        r8[r6] = r14;	 Catch:{ Throwable -> 0x00b1 }
        r8[r5] = r12;	 Catch:{ Throwable -> 0x00b1 }
        r8[r4] = r13;	 Catch:{ Throwable -> 0x00b1 }
        r8[r3] = r0;	 Catch:{ Throwable -> 0x00b1 }
        r12 = java.lang.String.format(r7, r8);	 Catch:{ Throwable -> 0x00b1 }
        goto L_0x00a0;
    L_0x0080:
        r12 = "%18s %5s %s/%s %s";
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00b1 }
        r3[r1] = r14;	 Catch:{ Throwable -> 0x00b1 }
        r14 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x00b1 }
        r7 = r14.getId();	 Catch:{ Throwable -> 0x00b1 }
        r14 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x00b1 }
        r3[r2] = r14;	 Catch:{ Throwable -> 0x00b1 }
        r3[r6] = r13;	 Catch:{ Throwable -> 0x00b1 }
        r13 = "AppsFlyer_4.8.15";
        r3[r5] = r13;	 Catch:{ Throwable -> 0x00b1 }
        r3[r4] = r0;	 Catch:{ Throwable -> 0x00b1 }
        r12 = java.lang.String.format(r12, r3);	 Catch:{ Throwable -> 0x00b1 }
    L_0x00a0:
        r13 = r11.rG;	 Catch:{ Throwable -> 0x00b1 }
        r13.put(r12);	 Catch:{ Throwable -> 0x00b1 }
        r13 = r11.rH;	 Catch:{ Throwable -> 0x00b1 }
        r12 = r12.getBytes();	 Catch:{ Throwable -> 0x00b1 }
        r12 = r12.length;	 Catch:{ Throwable -> 0x00b1 }
        r13 = r13 + r12;
        r11.rH = r13;	 Catch:{ Throwable -> 0x00b1 }
        monitor-exit(r11);
        return;
    L_0x00b1:
        monitor-exit(r11);
        return;
    L_0x00b3:
        monitor-exit(r11);
        return;
    L_0x00b5:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.ah.a(java.lang.String, java.lang.String, java.lang.String[]):void");
    }
}
