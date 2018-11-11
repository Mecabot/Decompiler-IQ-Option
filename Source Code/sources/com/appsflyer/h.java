package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.appsflyer.AFLogger.LogLevel;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private static h pH = new h();
    static final String po = "4.8.15".substring(0, "4.8.15".indexOf("."));
    private static String pp;
    private static String pq;
    static final String pr;
    private static final List<String> pu = Arrays.asList(new String[]{"is_cache"});
    private static final List<String> pv = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    private static f px;
    static g py;
    private static j pz;
    private static String ʼ;
    private static final String ᐝ;
    private t pA = null;
    private Map<String, String> pB;
    private boolean pC = false;
    private long pD;
    private ScheduledExecutorService pE = null;
    private long pF;
    private long pG;
    private b pI;
    String pJ;
    private Uri pK = null;
    private long pL;
    private boolean pM = false;
    private boolean pN = false;
    private String pO;
    private boolean pP;
    private boolean pQ;
    private r pR = new r();
    private boolean pS = false;
    private boolean pT = false;
    String pk;
    private long ps = -1;
    private long pt = -1;
    private long pw = TimeUnit.SECONDS.toMillis(5);

    class a implements Runnable {
        private String pJ;
        private WeakReference<Context> pV;
        private final Intent pY;
        private String pZ;
        private String pk;
        private ExecutorService qa;
        private boolean qb;
        private boolean qc;
        private String ᐝ;

        /* synthetic */ a(h hVar, WeakReference weakReference, String str, String str2, String str3, String str4, ExecutorService executorService, boolean z, Intent intent, byte b) {
            this(weakReference, str, str2, str3, str4, executorService, z, intent);
        }

        private a(WeakReference<Context> weakReference, String str, String str2, String str3, String str4, boolean z, boolean z2, Intent intent) {
            this.pV = weakReference;
            this.pk = str;
            this.pZ = str2;
            this.pJ = str3;
            this.ᐝ = str4;
            this.qb = true;
            this.qa = z;
            this.qc = z2;
            this.pY = intent;
        }

        public final void run() {
            h.a(h.this, (Context) this.pV.get(), this.pk, this.pZ, this.pJ, this.ᐝ, this.qb, this.qc, this.pY);
        }
    }

    class c implements Runnable {
        private WeakReference<Context> pV = null;

        public c(Context context) {
            this.pV = new WeakReference(context);
        }

        public final void run() {
            if (!h.this.pC) {
                h.this.pD = System.currentTimeMillis();
                if (this.pV != null) {
                    h.this.pC = true;
                    try {
                        String aw = i.fF().getString("AppsFlyerKey");
                        synchronized (this.pV) {
                            for (com.appsflyer.a.b bVar : com.appsflyer.a.a.fP().A((Context) this.pV.get())) {
                                StringBuilder stringBuilder = new StringBuilder("resending request: ");
                                stringBuilder.append(bVar.fR());
                                AFLogger.an(stringBuilder.toString());
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long parseLong = Long.parseLong(bVar.fS(), 10);
                                    h hVar = h.this;
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(bVar.fR());
                                    stringBuilder2.append("&isCachedRequest=true&timeincache=");
                                    stringBuilder2.append(Long.toString((currentTimeMillis - parseLong) / 1000));
                                    h.a(hVar, stringBuilder2.toString(), bVar.fQ(), aw, this.pV, bVar.fS(), false);
                                } catch (Throwable e) {
                                    AFLogger.a("Failed to resend cached request", e);
                                }
                            }
                        }
                    } catch (Throwable e2) {
                        try {
                            AFLogger.a("failed to check cache. ", e2);
                        } catch (Throwable th) {
                            h.this.pC = false;
                        }
                    }
                    h.this.pC = false;
                    h.this.pE.shutdown();
                    h.this.pE = null;
                }
            }
        }
    }

    class d implements Runnable {
        private WeakReference<Context> pV;
        private String pZ;
        private Map<String, Object> qg;
        private boolean qh;
        private int ॱ;

        /* synthetic */ d(h hVar, String str, Map map, Context context, boolean z, int i, byte b) {
            this(str, map, context, z, i);
        }

        private d(String str, Map<String, Object> map, Context context, boolean z, int i) {
            this.pV = null;
            this.pZ = str;
            this.qg = map;
            this.pV = new WeakReference(context);
            this.qh = z;
            this.ॱ = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A:{Splitter: B:10:0x0028, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:15:0x004b, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:16:0x004c, code:
            r9 = r1;
            r1 = r0;
            r0 = r9;
     */
        /* JADX WARNING: Missing block: B:17:0x0050, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:18:0x0051, code:
            com.appsflyer.AFLogger.a(r0.getMessage(), r0);
     */
        /* JADX WARNING: Missing block: B:19:0x0058, code:
            return;
     */
        public final void run() {
            /*
            r10 = this;
            r0 = com.appsflyer.h.this;
            r0 = r0.fB();
            if (r0 == 0) goto L_0x0009;
        L_0x0008:
            return;
        L_0x0009:
            r0 = 0;
            r1 = r10.qh;
            if (r1 == 0) goto L_0x0028;
        L_0x000e:
            r1 = r10.ॱ;
            r2 = 2;
            if (r1 > r2) goto L_0x0028;
        L_0x0013:
            r1 = com.appsflyer.h.this;
            r1 = com.appsflyer.h.a(r1);
            if (r1 == 0) goto L_0x0028;
        L_0x001b:
            r1 = r10.qg;
            r2 = "rfr";
            r3 = com.appsflyer.h.this;
            r3 = r3.pB;
            r1.put(r2, r3);
        L_0x0028:
            r1 = r10.qg;	 Catch:{ IOException -> 0x0059, Throwable -> 0x0050 }
            r2 = "appsflyerKey";
            r1 = r1.get(r2);	 Catch:{ IOException -> 0x0059, Throwable -> 0x0050 }
            r5 = r1;
            r5 = (java.lang.String) r5;	 Catch:{ IOException -> 0x0059, Throwable -> 0x0050 }
            r1 = r10.qg;	 Catch:{ IOException -> 0x0059, Throwable -> 0x0050 }
            r1 = com.appsflyer.b.c(r1);	 Catch:{ IOException -> 0x0059, Throwable -> 0x0050 }
            r1 = r1.toString();	 Catch:{ IOException -> 0x0059, Throwable -> 0x0050 }
            r2 = com.appsflyer.h.this;	 Catch:{ IOException -> 0x004b, Throwable -> 0x0050 }
            r3 = r10.pZ;	 Catch:{ IOException -> 0x004b, Throwable -> 0x0050 }
            r6 = r10.pV;	 Catch:{ IOException -> 0x004b, Throwable -> 0x0050 }
            r7 = 0;
            r8 = r10.qh;	 Catch:{ IOException -> 0x004b, Throwable -> 0x0050 }
            r4 = r1;
            com.appsflyer.h.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ IOException -> 0x004b, Throwable -> 0x0050 }
            return;
        L_0x004b:
            r0 = move-exception;
            r9 = r1;
            r1 = r0;
            r0 = r9;
            goto L_0x005a;
        L_0x0050:
            r0 = move-exception;
            r1 = r0.getMessage();
            com.appsflyer.AFLogger.a(r1, r0);
            return;
        L_0x0059:
            r1 = move-exception;
        L_0x005a:
            r2 = "Exception while sending request to server. ";
            com.appsflyer.AFLogger.a(r2, r1);
            if (r0 == 0) goto L_0x008e;
        L_0x0061:
            r2 = r10.pV;
            if (r2 == 0) goto L_0x008e;
        L_0x0065:
            r2 = r10.pZ;
            r3 = "&isCachedRequest=true&timeincache=";
            r2 = r2.contains(r3);
            if (r2 != 0) goto L_0x008e;
        L_0x006f:
            r2 = com.appsflyer.a.a.fP();
            r3 = new com.appsflyer.a.b;
            r4 = r10.pZ;
            r5 = "4.8.15";
            r3.<init>(r4, r0, r5);
            r0 = r10.pV;
            r0 = r0.get();
            r0 = (android.content.Context) r0;
            r2.a(r3, r0);
            r0 = r1.getMessage();
            com.appsflyer.AFLogger.a(r0, r1);
        L_0x008e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.d.run():void");
        }
    }

    abstract class e implements Runnable {
        private String pk;
        WeakReference<Context> qj = null;
        private ScheduledExecutorService qk;
        private AtomicInteger ql = new AtomicInteger(0);

        public abstract String fE();

        protected abstract void h(Map<String, String> map);

        protected abstract void j(String str, int i);

        e(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            this.qj = new WeakReference(context);
            this.pk = str;
            if (scheduledExecutorService == null) {
                this.qk = a.fp().fr();
            } else {
                this.qk = scheduledExecutorService;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:81:0x0258  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0233 A:{Catch:{ all -> 0x0229 }} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0248  */
        /* JADX WARNING: Missing block: B:83:0x025c, code:
            return;
     */
        public void run() {
            /*
            r13 = this;
            r0 = r13.pk;
            if (r0 == 0) goto L_0x025c;
        L_0x0004:
            r0 = r13.pk;
            r0 = r0.length();
            if (r0 != 0) goto L_0x000e;
        L_0x000c:
            goto L_0x025c;
        L_0x000e:
            r0 = com.appsflyer.h.this;
            r0 = r0.fB();
            if (r0 == 0) goto L_0x0017;
        L_0x0016:
            return;
        L_0x0017:
            r0 = r13.ql;
            r0.incrementAndGet();
            r0 = 0;
            r1 = 0;
            r2 = r13.qj;	 Catch:{ Throwable -> 0x022c }
            r2 = r2.get();	 Catch:{ Throwable -> 0x022c }
            r2 = (android.content.Context) r2;	 Catch:{ Throwable -> 0x022c }
            if (r2 != 0) goto L_0x002e;
        L_0x0028:
            r0 = r13.ql;
            r0.decrementAndGet();
            return;
        L_0x002e:
            r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x022c }
            r5 = new java.lang.ref.WeakReference;	 Catch:{ Throwable -> 0x022c }
            r5.<init>(r2);	 Catch:{ Throwable -> 0x022c }
            r5 = com.appsflyer.h.b(r5);	 Catch:{ Throwable -> 0x022c }
            r5 = com.appsflyer.h.h(r2, r5);	 Catch:{ Throwable -> 0x022c }
            r6 = "";
            r7 = 1;
            if (r5 == 0) goto L_0x006a;
        L_0x0044:
            r8 = com.appsflyer.h.pv;	 Catch:{ Throwable -> 0x022c }
            r9 = r5.toLowerCase();	 Catch:{ Throwable -> 0x022c }
            r8 = r8.contains(r9);	 Catch:{ Throwable -> 0x022c }
            if (r8 != 0) goto L_0x005d;
        L_0x0052:
            r6 = "-";
            r5 = java.lang.String.valueOf(r5);	 Catch:{ Throwable -> 0x022c }
            r6 = r6.concat(r5);	 Catch:{ Throwable -> 0x022c }
            goto L_0x006a;
        L_0x005d:
            r8 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.";
            r9 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x022c }
            r9[r1] = r5;	 Catch:{ Throwable -> 0x022c }
            r5 = java.lang.String.format(r8, r9);	 Catch:{ Throwable -> 0x022c }
            com.appsflyer.AFLogger.ao(r5);	 Catch:{ Throwable -> 0x022c }
        L_0x006a:
            r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x022c }
            r5.<init>();	 Catch:{ Throwable -> 0x022c }
            r8 = r13.fE();	 Catch:{ Throwable -> 0x022c }
            r5.append(r8);	 Catch:{ Throwable -> 0x022c }
            r8 = r2.getPackageName();	 Catch:{ Throwable -> 0x022c }
            r5.append(r8);	 Catch:{ Throwable -> 0x022c }
            r5.append(r6);	 Catch:{ Throwable -> 0x022c }
            r6 = "?devkey=";
            r5.append(r6);	 Catch:{ Throwable -> 0x022c }
            r6 = r13.pk;	 Catch:{ Throwable -> 0x022c }
            r5.append(r6);	 Catch:{ Throwable -> 0x022c }
            r6 = "&device_id=";
            r5.append(r6);	 Catch:{ Throwable -> 0x022c }
            r6 = new java.lang.ref.WeakReference;	 Catch:{ Throwable -> 0x022c }
            r6.<init>(r2);	 Catch:{ Throwable -> 0x022c }
            r6 = com.appsflyer.af.c(r6);	 Catch:{ Throwable -> 0x022c }
            r5.append(r6);	 Catch:{ Throwable -> 0x022c }
            r6 = com.appsflyer.ah.ge();	 Catch:{ Throwable -> 0x022c }
            r8 = r5.toString();	 Catch:{ Throwable -> 0x022c }
            r9 = "";
            r6.j(r8, r9);	 Catch:{ Throwable -> 0x022c }
            r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x022c }
            r8 = "Calling server for attribution url: ";
            r6.<init>(r8);	 Catch:{ Throwable -> 0x022c }
            r8 = r5.toString();	 Catch:{ Throwable -> 0x022c }
            r6.append(r8);	 Catch:{ Throwable -> 0x022c }
            r6 = r6.toString();	 Catch:{ Throwable -> 0x022c }
            com.appsflyer.z.AnonymousClass1.ah(r6);	 Catch:{ Throwable -> 0x022c }
            r6 = new java.net.URL;	 Catch:{ Throwable -> 0x022c }
            r8 = r5.toString();	 Catch:{ Throwable -> 0x022c }
            r6.<init>(r8);	 Catch:{ Throwable -> 0x022c }
            r6 = r6.openConnection();	 Catch:{ Throwable -> 0x022c }
            r6 = (java.net.HttpURLConnection) r6;	 Catch:{ Throwable -> 0x022c }
            r0 = "GET";
            r6.setRequestMethod(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r6.setConnectTimeout(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = "Connection";
            r8 = "close";
            r6.setRequestProperty(r0, r8);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r6.connect();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = r6.getResponseCode();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r8 = com.appsflyer.h.a(r6);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r9 = com.appsflyer.ah.ge();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r10 = r5.toString();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r9.a(r10, r0, r8);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r0 != r9) goto L_0x01ed;
        L_0x00f7:
            r9 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = "appsflyerGetConversionDataTiming";
            r5 = 0;
            r11 = r9 - r3;
            r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r11 = r11 / r3;
            com.appsflyer.h.a(r2, r0, r11);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = "Attribution data: ";
            r3 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = r0.concat(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.z.AnonymousClass1.ah(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = r8.length();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r0 <= 0) goto L_0x0219;
        L_0x0119:
            if (r2 == 0) goto L_0x0219;
        L_0x011b:
            r0 = com.appsflyer.h.as(r8);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = "iscache";
            r3 = r0.get(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r3 == 0) goto L_0x013c;
        L_0x0129:
            r4 = java.lang.Boolean.toString(r1);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4 = r4.equals(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r4 == 0) goto L_0x013c;
        L_0x0133:
            r4 = "appsflyerConversionDataCacheExpiration";
            r9 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.h.a(r2, r4, r9);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x013c:
            r4 = "af_siteid";
            r4 = r0.containsKey(r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r4 == 0) goto L_0x0179;
        L_0x0144:
            r4 = "af_channel";
            r4 = r0.containsKey(r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r4 == 0) goto L_0x0166;
        L_0x014c:
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = "[Invite] Detected App-Invite via channel: ";
            r4.<init>(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = "af_channel";
            r5 = r0.get(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4.append(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4 = r4.toString();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.AFLogger.am(r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            goto L_0x0179;
        L_0x0166:
            r4 = "[CrossPromotion] App was installed via %s's Cross Promotion";
            r5 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r9 = "af_siteid";
            r9 = r0.get(r9);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5[r1] = r9;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4 = java.lang.String.format(r4, r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.AFLogger.am(r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x0179:
            r4 = "af_siteid";
            r4 = r0.containsKey(r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r4 == 0) goto L_0x019a;
        L_0x0181:
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = "[Invite] Detected App-Invite via channel: ";
            r4.<init>(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = "af_channel";
            r5 = r0.get(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4.append(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4 = r4.toString();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.AFLogger.am(r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x019a:
            r4 = "is_first_launch";
            r5 = java.lang.Boolean.toString(r1);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0.put(r4, r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4.<init>(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4 = r4.toString();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r4 == 0) goto L_0x01b4;
        L_0x01ae:
            r5 = "attributionId";
            com.appsflyer.h.a(r2, r5, r4);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            goto L_0x01b9;
        L_0x01b4:
            r4 = "attributionId";
            com.appsflyer.h.a(r2, r4, r8);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x01b9:
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r5 = "iscache=";
            r4.<init>(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r4.append(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = " caching conversion data";
            r4.append(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = r4.toString();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.AFLogger.am(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = com.appsflyer.h.px;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r3 == 0) goto L_0x0219;
        L_0x01d5:
            r3 = r13.ql;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = r3.intValue();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r3 > r7) goto L_0x0219;
        L_0x01dd:
            r2 = com.appsflyer.h.o(r2);	 Catch:{ l -> 0x01e3 }
            r0 = r2;
            goto L_0x01e9;
        L_0x01e3:
            r2 = move-exception;
            r3 = "Exception while trying to fetch attribution data. ";
            com.appsflyer.AFLogger.a(r3, r2);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x01e9:
            r13.h(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            goto L_0x0219;
        L_0x01ed:
            r2 = com.appsflyer.h.px;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            if (r2 == 0) goto L_0x0200;
        L_0x01f3:
            r2 = "Error connection to server: ";
            r3 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r2 = r2.concat(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r13.j(r2, r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x0200:
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r3 = "AttributionIdFetcher response code: ";
            r2.<init>(r3);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r2.append(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = "  url: ";
            r2.append(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r2.append(r5);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            r0 = r2.toString();	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
            com.appsflyer.z.AnonymousClass1.ah(r0);	 Catch:{ Throwable -> 0x0226, all -> 0x0224 }
        L_0x0219:
            r0 = r13.ql;
            r0.decrementAndGet();
            if (r6 == 0) goto L_0x024b;
        L_0x0220:
            r6.disconnect();
            goto L_0x024b;
        L_0x0224:
            r1 = move-exception;
            goto L_0x0251;
        L_0x0226:
            r2 = move-exception;
            r0 = r6;
            goto L_0x022d;
        L_0x0229:
            r1 = move-exception;
            r6 = r0;
            goto L_0x0251;
        L_0x022c:
            r2 = move-exception;
        L_0x022d:
            r3 = com.appsflyer.h.px;	 Catch:{ all -> 0x0229 }
            if (r3 == 0) goto L_0x023a;
        L_0x0233:
            r3 = r2.getMessage();	 Catch:{ all -> 0x0229 }
            r13.j(r3, r1);	 Catch:{ all -> 0x0229 }
        L_0x023a:
            r1 = r2.getMessage();	 Catch:{ all -> 0x0229 }
            com.appsflyer.AFLogger.a(r1, r2);	 Catch:{ all -> 0x0229 }
            r1 = r13.ql;
            r1.decrementAndGet();
            if (r0 == 0) goto L_0x024b;
        L_0x0248:
            r0.disconnect();
        L_0x024b:
            r0 = r13.qk;
            r0.shutdown();
            return;
        L_0x0251:
            r0 = r13.ql;
            r0.decrementAndGet();
            if (r6 == 0) goto L_0x025b;
        L_0x0258:
            r6.disconnect();
        L_0x025b:
            throw r1;
        L_0x025c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.e.run():void");
        }
    }

    class b extends e {
        public b(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            super(context, str, scheduledExecutorService);
        }

        public final String fE() {
            return q.aA("https://api.%s/install_data/v3/");
        }

        protected final void h(Map<String, String> map) {
            map.put("is_first_launch", Boolean.toString(true));
            h.px.e(map);
            h.b((Context) this.qj.get(), "appsflyerConversionDataRequestRetries", 0);
        }

        protected final void j(String str, int i) {
            h.px.ap(str);
            if (i >= 400 && i < 500) {
                h.b((Context) this.qj.get(), "appsflyerConversionDataRequestRetries", h.t((Context) this.qj.get()).getInt("appsflyerConversionDataRequestRetries", 0) + 1);
            }
        }
    }

    static /* synthetic */ void g(Map map) {
        if (px != null) {
            try {
                px.f(map);
            } catch (Throwable th) {
                AFLogger.a(th.getLocalizedMessage(), th);
            }
        }
    }

    static /* synthetic */ void a(h hVar, String str, String str2, String str3, WeakReference weakReference, String str4, boolean z) {
        URL url = new URL(str);
        StringBuilder stringBuilder = new StringBuilder("url: ");
        stringBuilder.append(url.toString());
        AFLogger.an(stringBuilder.toString());
        com.appsflyer.z.AnonymousClass1.ah("data: ".concat(String.valueOf(str2)));
        a((Context) weakReference.get(), "AppsFlyer_4.8.15", "EVENT_DATA", str2);
        try {
            hVar.a(url, str2, str3, weakReference, str4, z);
        } catch (Throwable e) {
            AFLogger.a("Exception in sendRequestToServer. ", e);
            if (i.fF().getBoolean("useHttpFallback", false)) {
                hVar.a(new URL(str.replace("https:", "http:")), str2, str3, weakReference, str4, z);
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder("failed to send requeset to server. ");
            stringBuilder2.append(e.getLocalizedMessage());
            AFLogger.an(stringBuilder2.toString());
            a((Context) weakReference.get(), "AppsFlyer_4.8.15", "ERROR", e.getLocalizedMessage());
            throw e;
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(po);
        stringBuilder.append("/androidevent?buildnumber=4.8.15&app_id=");
        ᐝ = stringBuilder.toString();
        stringBuilder = new StringBuilder("https://attr.%s/api/v");
        stringBuilder.append(ᐝ);
        pp = stringBuilder.toString();
        stringBuilder = new StringBuilder("https://t.%s/api/v");
        stringBuilder.append(ᐝ);
        ʼ = stringBuilder.toString();
        stringBuilder = new StringBuilder("https://events.%s/api/v");
        stringBuilder.append(ᐝ);
        pq = stringBuilder.toString();
        stringBuilder = new StringBuilder("https://register.%s/api/v");
        stringBuilder.append(ᐝ);
        pr = stringBuilder.toString();
    }

    final void fz() {
        this.pF = System.currentTimeMillis();
    }

    final void fs() {
        this.pG = System.currentTimeMillis();
    }

    final void d(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("shouldMonitor");
        if (stringExtra != null) {
            AFLogger.an("Turning on monitoring.");
            i.fF().c("shouldMonitor", stringExtra.equals("true"));
            a(context, null, "START_TRACKING", context.getPackageName());
            return;
        }
        AFLogger.an("****** onReceive called *******");
        i.fF().fG();
        String stringExtra2 = intent.getStringExtra("referrer");
        AFLogger.an("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            if ("AppsFlyer_Test".equals(intent.getStringExtra("TestIntegrationMode"))) {
                Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
                edit.clear();
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                i.fF().B(false);
                AFLogger.an("Test mode started..");
                this.pL = System.currentTimeMillis();
            }
            Editor edit2 = context.getSharedPreferences("appsflyer-data", 0).edit();
            edit2.putString("referrer", stringExtra2);
            if (VERSION.SDK_INT >= 9) {
                edit2.apply();
            } else {
                edit2.commit();
            }
            i.fF().setReferrer(stringExtra2);
            if (i.fF().fH()) {
                AFLogger.an("onReceive: isLaunchCalled");
                if (stringExtra2 != null && stringExtra2.length() > 5) {
                    ScheduledExecutorService fr = a.fp().fr();
                    a(fr, new a(this, new WeakReference(context.getApplicationContext()), null, null, null, stringExtra2, fr, true, intent, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARNING: Can't wrap try/catch for R(5:3|4|5|(3:8|9|6)|36) */
    /* JADX WARNING: Can't wrap try/catch for R(7:15|16|17|18|(5:22|(3:26|27|(3:44|29|42)(1:30))|37|20|19)|47|12) */
    /* JADX WARNING: Missing block: B:1:0x0009, code:
            r3 = 0;
     */
    /* JADX WARNING: Missing block: B:2:0x000e, code:
            if (r1.hasNext() != false) goto L_0x0010;
     */
    /* JADX WARNING: Missing block: B:5:?, code:
            r4 = new org.json.JSONArray((java.lang.String) r14.get((java.lang.String) r1.next()));
     */
    /* JADX WARNING: Missing block: B:7:0x0025, code:
            if (r3 < r4.length()) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:8:0x0027, code:
            r0.add(java.lang.Long.valueOf(r4.getLong(r3)));
     */
    /* JADX WARNING: Missing block: B:9:0x0032, code:
            r3 = r3 + 1;
     */
    /* JADX WARNING: Missing block: B:10:0x0035, code:
            java.util.Collections.sort(r0);
            r1 = r14.keys();
     */
    /* JADX WARNING: Missing block: B:11:0x003d, code:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:13:0x0042, code:
            if (r1.hasNext() != false) goto L_0x0044;
     */
    /* JADX WARNING: Missing block: B:15:0x0046, code:
            r5 = (java.lang.String) r1.next();
     */
    /* JADX WARNING: Missing block: B:17:?, code:
            r6 = new org.json.JSONArray((java.lang.String) r14.get(r5));
     */
    /* JADX WARNING: Missing block: B:18:0x0057, code:
            r7 = r4;
            r4 = 0;
     */
    /* JADX WARNING: Missing block: B:21:0x005d, code:
            if (r4 < r6.length()) goto L_0x005f;
     */
    /* JADX WARNING: Missing block: B:28:0x0099, code:
            if (r6.getLong(r4) == ((java.lang.Long) r0.get(r0.size() - 1)).longValue()) goto L_0x009b;
     */
    /* JADX WARNING: Missing block: B:30:0x009c, code:
            r4 = r4 + 1;
            r7 = r5;
     */
    /* JADX WARNING: Missing block: B:31:0x00a0, code:
            r4 = r7;
     */
    /* JADX WARNING: Missing block: B:32:0x00a2, code:
            if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Missing block: B:33:0x00a4, code:
            r14.remove(r4);
     */
    /* JADX WARNING: Missing block: B:45:0x003e, code:
            continue;
     */
    /* JADX WARNING: Missing block: B:48:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:49:?, code:
            return;
     */
    private static void b(org.json.JSONObject r14) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r14.keys();
    L_0x0009:
        r2 = r1.hasNext();
        r3 = 0;
        if (r2 == 0) goto L_0x0035;
    L_0x0010:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r4 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0009 }
        r2 = r14.get(r2);	 Catch:{ JSONException -> 0x0009 }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x0009 }
        r4.<init>(r2);	 Catch:{ JSONException -> 0x0009 }
    L_0x0021:
        r2 = r4.length();	 Catch:{ JSONException -> 0x0009 }
        if (r3 >= r2) goto L_0x0009;
    L_0x0027:
        r5 = r4.getLong(r3);	 Catch:{ JSONException -> 0x0009 }
        r2 = java.lang.Long.valueOf(r5);	 Catch:{ JSONException -> 0x0009 }
        r0.add(r2);	 Catch:{ JSONException -> 0x0009 }
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x0035:
        java.util.Collections.sort(r0);
        r1 = r14.keys();
        r2 = 0;
    L_0x003d:
        r4 = r2;
    L_0x003e:
        r5 = r1.hasNext();
        if (r5 == 0) goto L_0x00a2;
    L_0x0044:
        if (r4 != 0) goto L_0x00a2;
    L_0x0046:
        r5 = r1.next();
        r5 = (java.lang.String) r5;
        r6 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x003e }
        r7 = r14.get(r5);	 Catch:{ JSONException -> 0x003e }
        r7 = (java.lang.String) r7;	 Catch:{ JSONException -> 0x003e }
        r6.<init>(r7);	 Catch:{ JSONException -> 0x003e }
        r7 = r4;
        r4 = 0;
    L_0x0059:
        r8 = r6.length();	 Catch:{ JSONException -> 0x00a0 }
        if (r4 >= r8) goto L_0x00a0;
    L_0x005f:
        r8 = r6.getLong(r4);	 Catch:{ JSONException -> 0x00a0 }
        r10 = r0.get(r3);	 Catch:{ JSONException -> 0x00a0 }
        r10 = (java.lang.Long) r10;	 Catch:{ JSONException -> 0x00a0 }
        r10 = r10.longValue();	 Catch:{ JSONException -> 0x00a0 }
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r12 == 0) goto L_0x003d;
    L_0x0071:
        r8 = r6.getLong(r4);	 Catch:{ JSONException -> 0x00a0 }
        r10 = 1;
        r11 = r0.get(r10);	 Catch:{ JSONException -> 0x00a0 }
        r11 = (java.lang.Long) r11;	 Catch:{ JSONException -> 0x00a0 }
        r11 = r11.longValue();	 Catch:{ JSONException -> 0x00a0 }
        r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1));
        if (r13 == 0) goto L_0x003d;
    L_0x0084:
        r8 = r6.getLong(r4);	 Catch:{ JSONException -> 0x00a0 }
        r11 = r0.size();	 Catch:{ JSONException -> 0x00a0 }
        r11 = r11 - r10;
        r10 = r0.get(r11);	 Catch:{ JSONException -> 0x00a0 }
        r10 = (java.lang.Long) r10;	 Catch:{ JSONException -> 0x00a0 }
        r10 = r10.longValue();	 Catch:{ JSONException -> 0x00a0 }
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 != 0) goto L_0x009c;
    L_0x009b:
        goto L_0x003d;
    L_0x009c:
        r4 = r4 + 1;
        r7 = r5;
        goto L_0x0059;
    L_0x00a0:
        r4 = r7;
        goto L_0x003e;
    L_0x00a2:
        if (r4 == 0) goto L_0x00a7;
    L_0x00a4:
        r14.remove(r4);
    L_0x00a7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.b(org.json.JSONObject):void");
    }

    static void e(Context context, String str) {
        AFLogger.am("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject;
            JSONArray jSONArray;
            long currentTimeMillis = System.currentTimeMillis();
            String string = context.getSharedPreferences("appsflyer-data", 0).getString("extraReferrers", null);
            if (string == null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                jSONObject = jSONObject2;
                jSONArray = jSONArray2;
            } else {
                jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                b(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject3 = jSONObject.toString();
            Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
            edit.putString("extraReferrers", jSONObject3);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Couldn't save referrer - ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            AFLogger.a(stringBuilder.toString(), th);
        }
    }

    private h() {
        e.init();
    }

    public static h fA() {
        return pH;
    }

    private void b(Application application) {
        i.fF().y(application.getApplicationContext());
        if (VERSION.SDK_INT < 14) {
            AFLogger.an("SDK<14 call trackEvent manually");
            AFLogger.an("onBecameForeground");
            fA().pF = System.currentTimeMillis();
            fA().b((Context) application, null, null);
            AFLogger.fy();
        } else if (VERSION.SDK_INT >= 14 && this.pI == null) {
            ad.ga();
            this.pI = new b() {
                public final void f(Activity activity) {
                    if (2 > h.a(h.t(activity))) {
                        z G = z.G(activity);
                        G.qM.post(G.qU);
                        G.qM.post(G.qT);
                    }
                    AFLogger.an("onBecameForeground");
                    h.fA().fz();
                    h.fA().b((Context) activity, null, null);
                    AFLogger.fy();
                }

                public final void a(WeakReference<Context> weakReference) {
                    s.z((Context) weakReference.get());
                    z G = z.G((Context) weakReference.get());
                    G.qM.post(G.qU);
                }
            };
            ad.gb().a(application, this.pI);
        }
    }

    public void A(boolean z) {
        ah.ge().a("setDebugLog", String.valueOf(z));
        i.fF().c("shouldLog", z);
        i.fF().set("logLevel", (z ? LogLevel.DEBUG : LogLevel.NONE).getLevel());
    }

    public void e(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            String[] strArr = new String[2];
            strArr[0] = activity.getLocalClassName();
            StringBuilder stringBuilder = new StringBuilder("activity_intent_");
            stringBuilder.append(activity.getIntent().toString());
            strArr[1] = stringBuilder.toString();
            ah.ge().a("sendDeepLinkData", strArr);
        } else if (activity != null) {
            ah.ge().a("sendDeepLinkData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            ah.ge().a("sendDeepLinkData", "activity_null");
        }
        try {
            b(activity.getApplication());
            StringBuilder stringBuilder2 = new StringBuilder("getDeepLinkData with activity ");
            stringBuilder2.append(activity.getIntent().getDataString());
            AFLogger.an(stringBuilder2.toString());
        } catch (Exception e) {
            AFLogger.an("getDeepLinkData Exception: ".concat(String.valueOf(e)));
        }
    }

    public h a(String str, f fVar) {
        ah ge = ah.ge();
        String str2 = "init";
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = fVar == null ? "null" : "conversionDataListener";
        ge.a(str2, strArr);
        AFLogger.al(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"4.8.15", "395"}));
        this.pQ = true;
        i.fF().set("AppsFlyerKey", str);
        com.appsflyer.z.AnonymousClass1.aj(str);
        px = fVar;
        return this;
    }

    private static boolean n(@NonNull Context context) {
        if (a(context.getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false) > 2) {
            AFLogger.ak("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("com.android.b.a.a");
            if (a.j(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.am("Install referrer is allowed");
                return true;
            }
            AFLogger.am("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            AFLogger.ak("Class com.android.installreferrer.api.InstallReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.a("An error occurred while trying to verify manifest : com.android.installreferrer.api.InstallReferrerClient", th);
            return false;
        }
    }

    public void c(Application application) {
        if (this.pQ) {
            a(application, null);
        } else {
            AFLogger.ao("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking(Application)' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
        }
    }

    public void a(Application application, String str) {
        a(application, str, null);
    }

    public void a(Application application, String str, j jVar) {
        ah.ge().a("startTracking", str);
        AFLogger.an(String.format("Starting AppsFlyer Tracking: (v%s.%s)", new Object[]{"4.8.15", "395"}));
        AFLogger.an("Build Number: 395");
        i.fF().y(application.getApplicationContext());
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(i.fF().getString("AppsFlyerKey"))) {
                AFLogger.ao("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
                return;
            }
        }
        i.fF().set("AppsFlyerKey", str);
        com.appsflyer.z.AnonymousClass1.aj(str);
        if (jVar != null) {
            pz = jVar;
        }
        b(application);
    }

    public void ar(String str) {
        ah.ge().a("setCurrencyCode", str);
        i.fF().set("currencyCode", str);
    }

    final void a(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.an("app went to background");
            SharedPreferences sharedPreferences = ((Context) weakReference.get()).getSharedPreferences("appsflyer-data", 0);
            i.fF().b(sharedPreferences);
            long j = this.pG - this.pF;
            Map hashMap = new HashMap();
            String string = i.fF().getString("AppsFlyerKey");
            if (string == null) {
                AFLogger.ao("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            Object string2 = i.fF().getString("KSAppsFlyerId");
            if (i.fF().getBoolean("deviceTrackingDisabled", false)) {
                hashMap.put("deviceTrackingDisabled", "true");
            }
            n b = o.b(((Context) weakReference.get()).getContentResolver());
            if (b != null) {
                hashMap.put("amazon_aid", b.fN());
                hashMap.put("amazon_aid_limit", String.valueOf(b.fZ()));
            }
            String string3 = i.fF().getString("advertiserId");
            if (string3 != null) {
                hashMap.put("advertiserId", string3);
            }
            hashMap.put("app_id", ((Context) weakReference.get()).getPackageName());
            hashMap.put("devkey", string);
            hashMap.put("uid", af.c(weakReference));
            hashMap.put("time_in_app", String.valueOf(j / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(a(sharedPreferences, "appsFlyerCount", false)));
            hashMap.put("gcd_conversion_data_timing", Long.toString(sharedPreferences.getLong("appsflyerGetConversionDataTiming", 0)));
            String str = "channel";
            Object string4 = i.fF().getString("channel");
            if (string4 == null) {
                string4 = a((WeakReference) weakReference, "CHANNEL");
            }
            hashMap.put(str, string4);
            String str2 = "originalAppsflyerId";
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put(str2, string2);
            if (this.pS) {
                try {
                    AsyncTask abVar = new ab(null, fB());
                    abVar.qg = hashMap;
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        AFLogger.am("Main thread detected. Running callStats task in a new thread.");
                        abVar.execute(new String[]{q.aA("https://stats.%s/stats")});
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder("Running callStats task (on current thread: ");
                    stringBuilder.append(Thread.currentThread().toString());
                    stringBuilder.append(" )");
                    AFLogger.am(stringBuilder.toString());
                    abVar.onPreExecute();
                    abVar.onPostExecute(abVar.doInBackground(q.aA("https://stats.%s/stats")));
                    return;
                } catch (Throwable th) {
                    AFLogger.a("Could not send callStats request", th);
                    return;
                }
            }
            AFLogger.am("Stats call is disabled, ignore ...");
        }
    }

    public void a(Context context, String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject(map == null ? new HashMap() : map);
        ah.ge().a("trackEvent", str, jSONObject.toString());
        b(context, str, (Map) map);
    }

    final void b(Context context, String str, Map<String, Object> map) {
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (i.fF().getString("AppsFlyerKey") == null) {
            AFLogger.ao("[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        JSONObject jSONObject = new JSONObject(map2);
        String x = i.fF().x(context);
        String jSONObject2 = jSONObject.toString();
        if (x == null) {
            x = "";
        }
        a(context, null, str, jSONObject2, x, intent);
    }

    private static void a(Context context, String str, String str2, String str3) {
        if (i.fF().getBoolean("shouldMonitor", false)) {
            Intent intent = new Intent("com.appsflyer.MonitorBroadcast");
            intent.setPackage("com.appsflyer.nightvision");
            intent.putExtra("message", str2);
            intent.putExtra(com.google.firebase.analytics.FirebaseAnalytics.b.VALUE, str3);
            intent.putExtra("packageName", "true");
            intent.putExtra("pid", new Integer(Process.myPid()));
            intent.putExtra("eventIdentifier", str);
            intent.putExtra("sdk", "4.8.15");
            context.sendBroadcast(intent);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001f  */
    final void f(android.content.Context r11, java.lang.String r12) {
        /*
        r10 = this;
        r0 = "waitForCustomerId";
        r1 = com.appsflyer.i.fF();
        r2 = 0;
        r0 = r1.getBoolean(r0, r2);
        r1 = 1;
        if (r0 == 0) goto L_0x001c;
    L_0x000e:
        r0 = "AppUserId";
        r3 = com.appsflyer.i.fF();
        r0 = r3.getString(r0);
        if (r0 != 0) goto L_0x001c;
    L_0x001a:
        r0 = 1;
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        if (r0 == 0) goto L_0x0025;
    L_0x001f:
        r11 = "CustomerUserId not set, Tracking is disabled";
        com.appsflyer.AFLogger.a(r11, r1);
        return;
    L_0x0025:
        r0 = new java.util.HashMap;
        r0.<init>();
        r3 = "AppsFlyerKey";
        r4 = com.appsflyer.i.fF();
        r3 = r4.getString(r3);
        if (r3 != 0) goto L_0x003c;
    L_0x0036:
        r11 = "[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.";
        com.appsflyer.AFLogger.ao(r11);
        return;
    L_0x003c:
        r4 = r11.getPackageManager();
        r5 = r11.getPackageName();
        r6 = r4.getPackageInfo(r5, r2);	 Catch:{ Throwable -> 0x008c }
        r7 = "app_version_code";
        r8 = r6.versionCode;	 Catch:{ Throwable -> 0x008c }
        r8 = java.lang.Integer.toString(r8);	 Catch:{ Throwable -> 0x008c }
        r0.put(r7, r8);	 Catch:{ Throwable -> 0x008c }
        r7 = "app_version_name";
        r8 = r6.versionName;	 Catch:{ Throwable -> 0x008c }
        r0.put(r7, r8);	 Catch:{ Throwable -> 0x008c }
        r7 = r6.applicationInfo;	 Catch:{ Throwable -> 0x008c }
        r4 = r4.getApplicationLabel(r7);	 Catch:{ Throwable -> 0x008c }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x008c }
        r7 = "app_name";
        r0.put(r7, r4);	 Catch:{ Throwable -> 0x008c }
        r6 = r6.firstInstallTime;	 Catch:{ Throwable -> 0x008c }
        r4 = "yyyy-MM-dd_HHmmssZ";
        r8 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x008c }
        r9 = java.util.Locale.US;	 Catch:{ Throwable -> 0x008c }
        r8.<init>(r4, r9);	 Catch:{ Throwable -> 0x008c }
        r4 = "installDate";
        r9 = "UTC";
        r9 = java.util.TimeZone.getTimeZone(r9);	 Catch:{ Throwable -> 0x008c }
        r8.setTimeZone(r9);	 Catch:{ Throwable -> 0x008c }
        r9 = new java.util.Date;	 Catch:{ Throwable -> 0x008c }
        r9.<init>(r6);	 Catch:{ Throwable -> 0x008c }
        r6 = r8.format(r9);	 Catch:{ Throwable -> 0x008c }
        r0.put(r4, r6);	 Catch:{ Throwable -> 0x008c }
        goto L_0x0092;
    L_0x008c:
        r4 = move-exception;
        r6 = "Exception while collecting application version info.";
        com.appsflyer.AFLogger.a(r6, r4);
    L_0x0092:
        a(r11, r0);
        r4 = "AppUserId";
        r6 = com.appsflyer.i.fF();
        r4 = r6.getString(r4);
        if (r4 == 0) goto L_0x00a6;
    L_0x00a1:
        r6 = "appUserId";
        r0.put(r6, r4);
    L_0x00a6:
        r4 = "model";
        r6 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x00b5 }
        r0.put(r4, r6);	 Catch:{ Throwable -> 0x00b5 }
        r4 = "brand";
        r6 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x00b5 }
        r0.put(r4, r6);	 Catch:{ Throwable -> 0x00b5 }
        goto L_0x00bb;
    L_0x00b5:
        r4 = move-exception;
        r6 = "Exception while collecting device brand and model.";
        com.appsflyer.AFLogger.a(r6, r4);
    L_0x00bb:
        r4 = com.appsflyer.i.fF();
        r6 = "deviceTrackingDisabled";
        r4 = r4.getBoolean(r6, r2);
        if (r4 == 0) goto L_0x00ce;
    L_0x00c7:
        r4 = "deviceTrackingDisabled";
        r6 = "true";
        r0.put(r4, r6);
    L_0x00ce:
        r4 = r11.getContentResolver();
        r4 = com.appsflyer.o.b(r4);
        if (r4 == 0) goto L_0x00ee;
    L_0x00d8:
        r6 = "amazon_aid";
        r7 = r4.fN();
        r0.put(r6, r7);
        r6 = "amazon_aid_limit";
        r4 = r4.fZ();
        r4 = java.lang.String.valueOf(r4);
        r0.put(r6, r4);
    L_0x00ee:
        r4 = com.appsflyer.i.fF();
        r6 = "advertiserId";
        r4 = r4.getString(r6);
        if (r4 == 0) goto L_0x00ff;
    L_0x00fa:
        r6 = "advertiserId";
        r0.put(r6, r4);
    L_0x00ff:
        r4 = "devkey";
        r0.put(r4, r3);
        r3 = "uid";
        r4 = new java.lang.ref.WeakReference;
        r4.<init>(r11);
        r4 = com.appsflyer.af.c(r4);
        r0.put(r3, r4);
        r3 = "af_gcm_token";
        r0.put(r3, r12);
        r12 = "appsflyer-data";
        r12 = r11.getSharedPreferences(r12, r2);
        r3 = "appsFlyerCount";
        r12 = a(r12, r3, r2);
        r3 = "launch_counter";
        r12 = java.lang.Integer.toString(r12);
        r0.put(r3, r12);
        r12 = "sdk";
        r3 = android.os.Build.VERSION.SDK_INT;
        r3 = java.lang.Integer.toString(r3);
        r0.put(r12, r3);
        r12 = new java.lang.ref.WeakReference;
        r12.<init>(r11);
        r3 = com.appsflyer.i.fF();
        r4 = "channel";
        r3 = r3.getString(r4);
        if (r3 != 0) goto L_0x014e;
    L_0x0148:
        r3 = "CHANNEL";
        r3 = a(r12, r3);
    L_0x014e:
        if (r3 == 0) goto L_0x0155;
    L_0x0150:
        r12 = "channel";
        r0.put(r12, r3);
    L_0x0155:
        r12 = new com.appsflyer.ab;	 Catch:{ Throwable -> 0x017d }
        r3 = r10.fB();	 Catch:{ Throwable -> 0x017d }
        r12.<init>(r11, r3);	 Catch:{ Throwable -> 0x017d }
        r12.qg = r0;	 Catch:{ Throwable -> 0x017d }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x017d }
        r11.<init>();	 Catch:{ Throwable -> 0x017d }
        r0 = pr;	 Catch:{ Throwable -> 0x017d }
        r0 = com.appsflyer.q.aA(r0);	 Catch:{ Throwable -> 0x017d }
        r11.append(r0);	 Catch:{ Throwable -> 0x017d }
        r11.append(r5);	 Catch:{ Throwable -> 0x017d }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x017d }
        r0 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x017d }
        r0[r2] = r11;	 Catch:{ Throwable -> 0x017d }
        r12.execute(r0);	 Catch:{ Throwable -> 0x017d }
        return;
    L_0x017d:
        r11 = move-exception;
        r12 = r11.getMessage();
        com.appsflyer.AFLogger.a(r12, r11);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.f(android.content.Context, java.lang.String):void");
    }

    private static Map<String, String> o(Context context) {
        String string = context.getSharedPreferences("appsflyer-data", 0).getString("attributionId", null);
        if (string != null && string.length() > 0) {
            return as(string);
        }
        throw new l();
    }

    private static Map<String, String> g(Context context, String str) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        Object obj = null;
        for (String str2 : str.split("&")) {
            Object substring;
            int indexOf = str2.indexOf("=");
            Object substring2 = indexOf > 0 ? str2.substring(0, indexOf) : str2;
            if (!linkedHashMap.containsKey(substring2)) {
                if (substring2.equals("c")) {
                    substring2 = com.google.firebase.analytics.FirebaseAnalytics.b.CAMPAIGN;
                } else if (substring2.equals("pid")) {
                    substring2 = "media_source";
                } else if (substring2.equals("af_prt")) {
                    substring2 = "agency";
                    obj = 1;
                }
                linkedHashMap.put(substring2, "");
            }
            if (indexOf > 0) {
                indexOf++;
                if (str2.length() > indexOf) {
                    substring = str2.substring(indexOf);
                    linkedHashMap.put(substring2, substring);
                }
            }
            substring = null;
            linkedHashMap.put(substring2, substring);
        }
        try {
            if (!linkedHashMap.containsKey("install_time")) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                long j = packageInfo.firstInstallTime;
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                linkedHashMap.put("install_time", simpleDateFormat.format(new Date(j)));
            }
        } catch (Throwable e) {
            AFLogger.a("Could not fetch install time. ", e);
        }
        if (!linkedHashMap.containsKey("af_status")) {
            linkedHashMap.put("af_status", "Non-organic");
        }
        if (obj != null) {
            linkedHashMap.remove("media_source");
        }
        return linkedHashMap;
    }

    private static Map<String, String> as(String str) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!pu.contains(str2)) {
                    CharSequence string = jSONObject.getString(str2);
                    if (!(TextUtils.isEmpty(string) || "null".equals(string))) {
                        hashMap.put(str2, string);
                    }
                }
            }
            return hashMap;
        } catch (Throwable e) {
            AFLogger.a(e.getMessage(), e);
            return null;
        }
    }

    private void a(Context context, String str, String str2, String str3, String str4, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        boolean z = false;
        Object obj = str2 == null ? 1 : null;
        if (i.fF().getBoolean("waitForCustomerId", false)) {
            if (i.fF().getString("AppUserId") == null) {
                z = true;
            }
        }
        if (z) {
            AFLogger.a("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        h hVar;
        if (obj != null) {
            if (!i.fF().getBoolean("launchProtectEnabled", true)) {
                AFLogger.an("Allowing multiple launches within a 5 second time window.");
            } else if (fu()) {
                return;
            }
            hVar = this;
            hVar.ps = System.currentTimeMillis();
        } else {
            hVar = this;
        }
        ScheduledExecutorService fr = a.fp().fr();
        a(fr, new a(hVar, new WeakReference(applicationContext), str, str2, str3, str4, fr, false, intent, (byte) 0), 150, TimeUnit.MILLISECONDS);
    }

    private boolean fu() {
        if (this.ps > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.ps;
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j = this.ps;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(j));
            j = this.pt;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format2 = simpleDateFormat.format(new Date(j));
            if (currentTimeMillis < this.pw && !fB()) {
                AFLogger.an(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.pw)}));
                return true;
            } else if (!fB()) {
                AFLogger.an(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!fB()) {
            AFLogger.an("Sending first launch for this session!");
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:158:0x046f A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x06dc A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x06d1 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x06d1 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x06dc A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0666 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x065b A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x06cb A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x06dc A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x06d1 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x065b A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0666 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x067f A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x06cb A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x06d1 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x06dc A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x085c A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x086c A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x087d A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x08a7 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x08b2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x08d2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0937 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0981 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x09ba A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x09e2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0a48 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a46 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0a6f A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0ab7 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0c16 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x085c A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x086c A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x087d A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x08a7 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x08b2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x08d2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0937 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0972 A:{SKIP, Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0981 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x09ba A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x09e2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a46 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0a48 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0a6f A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0ab7 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0c16 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x05a9 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x05c4 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x05bb A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x06ec A:{Catch:{ Exception -> 0x06f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0765 A:{SYNTHETIC, Splitter: B:302:0x0765} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x07ac A:{Catch:{ Throwable -> 0x084b }} */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x07d0 A:{Catch:{ Throwable -> 0x084b }} */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x085c A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x086c A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x087d A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x08a7 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x08b2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x08d2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0937 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0972 A:{SKIP, Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x0981 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x09ba A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x09e2 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0a48 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0a46 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x0a6f A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0ab7 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0c16 A:{Catch:{ Exception -> 0x00ac, Throwable -> 0x0c3a }} */
    final java.util.Map<java.lang.String, java.lang.Object> a(android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24, android.content.SharedPreferences r25, boolean r26, android.content.Intent r27) {
        /*
        r18 = this;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r4 = r21;
        r5 = r22;
        r6 = r25;
        r7 = r26;
        r8 = new java.util.HashMap;
        r8.<init>();
        com.appsflyer.o.a(r2, r8);
        r9 = new java.util.Date;
        r9.<init>();
        r9 = r9.getTime();
        r11 = "af_timestamp";
        r12 = java.lang.Long.toString(r9);
        r8.put(r11, r12);
        r9 = com.appsflyer.u.a(r2, r9);
        if (r9 == 0) goto L_0x0033;
    L_0x002e:
        r10 = "cksm_v1";
        r8.put(r10, r9);
    L_0x0033:
        r9 = r18.fB();	 Catch:{ Throwable -> 0x0c3a }
        if (r9 != 0) goto L_0x0051;
    L_0x0039:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r10 = "******* sendTrackingWithEvent: ";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0c3a }
        if (r7 == 0) goto L_0x0045;
    L_0x0042:
        r10 = "Launch";
        goto L_0x0046;
    L_0x0045:
        r10 = r4;
    L_0x0046:
        r9.append(r10);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.an(r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0056;
    L_0x0051:
        r9 = "SDK tracking has been stopped";
        com.appsflyer.AFLogger.an(r9);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0056:
        r9 = "AppsFlyer_4.8.15";
        r10 = "EVENT_CREATED_WITH_NAME";
        if (r7 == 0) goto L_0x005f;
    L_0x005c:
        r11 = "Launch";
        goto L_0x0060;
    L_0x005f:
        r11 = r4;
    L_0x0060:
        a(r2, r9, r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r9 = com.appsflyer.a.a.fP();	 Catch:{ Throwable -> 0x0c3a }
        r9.init(r2);	 Catch:{ Throwable -> 0x0c3a }
        r9 = 0;
        r10 = r19.getPackageManager();	 Catch:{ Exception -> 0x00ac }
        r11 = r19.getPackageName();	 Catch:{ Exception -> 0x00ac }
        r12 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r10 = r10.getPackageInfo(r11, r12);	 Catch:{ Exception -> 0x00ac }
        r10 = r10.requestedPermissions;	 Catch:{ Exception -> 0x00ac }
        r10 = java.util.Arrays.asList(r10);	 Catch:{ Exception -> 0x00ac }
        r11 = "android.permission.INTERNET";
        r11 = r10.contains(r11);	 Catch:{ Exception -> 0x00ac }
        if (r11 != 0) goto L_0x0091;
    L_0x0087:
        r11 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml";
        com.appsflyer.AFLogger.ao(r11);	 Catch:{ Exception -> 0x00ac }
        r11 = "PERMISSION_INTERNET_MISSING";
        a(r2, r9, r11, r9);	 Catch:{ Exception -> 0x00ac }
    L_0x0091:
        r11 = "android.permission.ACCESS_NETWORK_STATE";
        r11 = r10.contains(r11);	 Catch:{ Exception -> 0x00ac }
        if (r11 != 0) goto L_0x009e;
    L_0x0099:
        r11 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml";
        com.appsflyer.AFLogger.ao(r11);	 Catch:{ Exception -> 0x00ac }
    L_0x009e:
        r11 = "android.permission.ACCESS_WIFI_STATE";
        r10 = r10.contains(r11);	 Catch:{ Exception -> 0x00ac }
        if (r10 != 0) goto L_0x00b3;
    L_0x00a6:
        r10 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml";
        com.appsflyer.AFLogger.ao(r10);	 Catch:{ Exception -> 0x00ac }
        goto L_0x00b3;
    L_0x00ac:
        r0 = move-exception;
        r10 = r0;
        r11 = "Exception while validation permissions. ";
        com.appsflyer.AFLogger.a(r11, r10);	 Catch:{ Throwable -> 0x0c3a }
    L_0x00b3:
        if (r24 == 0) goto L_0x00bc;
    L_0x00b5:
        r10 = "af_events_api";
        r11 = "1";
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
    L_0x00bc:
        r10 = "brand";
        r11 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "device";
        r11 = android.os.Build.DEVICE;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "product";
        r11 = android.os.Build.PRODUCT;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "sdk";
        r11 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0c3a }
        r11 = java.lang.Integer.toString(r11);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "model";
        r11 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "deviceType";
        r11 = android.os.Build.TYPE;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "deviceRm";
        r11 = android.os.Build.DISPLAY;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r13 = 0;
        r15 = 1;
        r12 = 0;
        if (r7 == 0) goto L_0x0274;
    L_0x00f7:
        r10 = "appsflyer-data";
        r10 = r2.getSharedPreferences(r10, r12);	 Catch:{ Throwable -> 0x0c3a }
        r11 = "appsFlyerCount";
        r10 = r10.contains(r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = r10 ^ r15;
        if (r10 == 0) goto L_0x0226;
    L_0x0106:
        r10 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r10 = r10.fK();	 Catch:{ Throwable -> 0x0c3a }
        if (r10 != 0) goto L_0x0199;
    L_0x0110:
        r10 = "af_sdks";
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r11.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r15 = "com.tune.Tune";
        r9 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r9.aD(r15);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.adjust.sdk.Adjust";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.kochava.android.tracker.Feature";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "io.branch.referral.Branch";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.apsalar.sdk.Apsalar";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.localytics.android.Localytics";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.tenjin.android.TenjinSDK";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "place holder for TD";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "it.partytrack.sdk.Track";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "jp.appAdForce.android.LtvManager";
        r15 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r9 = r15.aD(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11.append(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r11.toString();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = v(r19);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "batteryLevel";
        r9 = java.lang.String.valueOf(r9);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r10, r9);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0199:
        r9 = 18;
        r10 = "OPPO";
        r11 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x0c3a }
        r10 = r10.equals(r11);	 Catch:{ Throwable -> 0x0c3a }
        if (r10 == 0) goto L_0x01ac;
    L_0x01a5:
        r9 = 23;
        r10 = "OPPO device found";
        com.appsflyer.AFLogger.ak(r10);	 Catch:{ Throwable -> 0x0c3a }
    L_0x01ac:
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0c3a }
        if (r10 < r9) goto L_0x020e;
    L_0x01b0:
        r9 = "keyPropDisableAFKeystore";
        r10 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r9 = r10.getBoolean(r9, r12);	 Catch:{ Throwable -> 0x0c3a }
        if (r9 != 0) goto L_0x020e;
    L_0x01bc:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r10 = "OS SDK is=";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0c3a }
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0c3a }
        r9.append(r10);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "; use KeyStore";
        r9.append(r10);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.ak(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = new com.appsflyer.c;	 Catch:{ Throwable -> 0x0c3a }
        r9.<init>(r2);	 Catch:{ Throwable -> 0x0c3a }
        r10 = r9.fu();	 Catch:{ Throwable -> 0x0c3a }
        if (r10 != 0) goto L_0x01ec;
    L_0x01df:
        r10 = new java.lang.ref.WeakReference;	 Catch:{ Throwable -> 0x0c3a }
        r10.<init>(r2);	 Catch:{ Throwable -> 0x0c3a }
        r10 = com.appsflyer.af.c(r10);	 Catch:{ Throwable -> 0x0c3a }
        r9.ah(r10);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x01ef;
    L_0x01ec:
        r9.ft();	 Catch:{ Throwable -> 0x0c3a }
    L_0x01ef:
        r10 = "KSAppsFlyerId";
        r11 = r9.fw();	 Catch:{ Throwable -> 0x0c3a }
        r15 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r15.set(r10, r11);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "KSAppsFlyerRICounter";
        r9 = r9.fx();	 Catch:{ Throwable -> 0x0c3a }
        r9 = java.lang.String.valueOf(r9);	 Catch:{ Throwable -> 0x0c3a }
        r11 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r11.set(r10, r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0226;
    L_0x020e:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r10 = "OS SDK is=";
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0c3a }
        r10 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0c3a }
        r9.append(r10);	 Catch:{ Throwable -> 0x0c3a }
        r10 = "; no KeyStore usage";
        r9.append(r10);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.ak(r9);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0226:
        r9 = "timepassedsincelastlaunch";
        r10 = "appsflyer-data";
        r10 = r2.getSharedPreferences(r10, r12);	 Catch:{ Throwable -> 0x0c3a }
        r11 = "AppsFlyerTimePassedSincePrevLaunch";
        r10 = r10.getLong(r11, r13);	 Catch:{ Throwable -> 0x0c3a }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0c3a }
        r14 = "AppsFlyerTimePassedSincePrevLaunch";
        a(r2, r14, r12);	 Catch:{ Throwable -> 0x0c3a }
        r14 = 0;
        r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r16 <= 0) goto L_0x024a;
    L_0x0243:
        r14 = r12 - r10;
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r14 / r10;
        goto L_0x024c;
    L_0x024a:
        r10 = -1;
    L_0x024c:
        r10 = java.lang.Long.toString(r10);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r9, r10);	 Catch:{ Throwable -> 0x0c3a }
        r9 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r10 = "oneLinkSlug";
        r9 = r9.getString(r10);	 Catch:{ Throwable -> 0x0c3a }
        if (r9 == 0) goto L_0x02e8;
    L_0x025f:
        r10 = "onelink_id";
        r8.put(r10, r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "ol_ver";
        r10 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r11 = "onelinkVersion";
        r10 = r10.getString(r11);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r9, r10);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x02e8;
    L_0x0274:
        r9 = "appsflyer-data";
        r10 = 0;
        r9 = r2.getSharedPreferences(r9, r10);	 Catch:{ Throwable -> 0x0c3a }
        r10 = r9.edit();	 Catch:{ Throwable -> 0x0c3a }
        r11 = "prev_event_name";
        r12 = 0;
        r11 = r9.getString(r11, r12);	 Catch:{ Exception -> 0x02e1 }
        if (r11 == 0) goto L_0x02c0;
    L_0x0288:
        r12 = new org.json.JSONObject;	 Catch:{ Exception -> 0x02e1 }
        r12.<init>();	 Catch:{ Exception -> 0x02e1 }
        r13 = "prev_event_timestamp";
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02e1 }
        r14.<init>();	 Catch:{ Exception -> 0x02e1 }
        r15 = "prev_event_timestamp";
        r6 = -1;
        r6 = r9.getLong(r15, r6);	 Catch:{ Exception -> 0x02e1 }
        r14.append(r6);	 Catch:{ Exception -> 0x02e1 }
        r6 = r14.toString();	 Catch:{ Exception -> 0x02e1 }
        r12.put(r13, r6);	 Catch:{ Exception -> 0x02e1 }
        r6 = "prev_event_value";
        r7 = "prev_event_value";
        r13 = 0;
        r7 = r9.getString(r7, r13);	 Catch:{ Exception -> 0x02e1 }
        r12.put(r6, r7);	 Catch:{ Exception -> 0x02e1 }
        r6 = "prev_event_name";
        r12.put(r6, r11);	 Catch:{ Exception -> 0x02e1 }
        r6 = "prev_event";
        r7 = r12.toString();	 Catch:{ Exception -> 0x02e1 }
        r8.put(r6, r7);	 Catch:{ Exception -> 0x02e1 }
    L_0x02c0:
        r6 = "prev_event_name";
        r10.putString(r6, r4);	 Catch:{ Exception -> 0x02e1 }
        r6 = "prev_event_value";
        r10.putString(r6, r5);	 Catch:{ Exception -> 0x02e1 }
        r6 = "prev_event_timestamp";
        r11 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x02e1 }
        r10.putLong(r6, r11);	 Catch:{ Exception -> 0x02e1 }
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x02e1 }
        r7 = 9;
        if (r6 < r7) goto L_0x02dd;
    L_0x02d9:
        r10.apply();	 Catch:{ Exception -> 0x02e1 }
        goto L_0x02e8;
    L_0x02dd:
        r10.commit();	 Catch:{ Exception -> 0x02e1 }
        goto L_0x02e8;
    L_0x02e1:
        r0 = move-exception;
        r6 = r0;
        r7 = "Error while processing previous event.";
        com.appsflyer.AFLogger.a(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x02e8:
        r6 = "KSAppsFlyerId";
        r7 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r7.getString(r6);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "KSAppsFlyerRICounter";
        r9 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = r9.getString(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0314;
    L_0x02fe:
        if (r7 == 0) goto L_0x0314;
    L_0x0300:
        r9 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r9.intValue();	 Catch:{ Throwable -> 0x0c3a }
        if (r9 <= 0) goto L_0x0314;
    L_0x030a:
        r9 = "reinstallCounter";
        r8.put(r9, r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "originalAppsflyerId";
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0314:
        r6 = "additionalCustomData";
        r7 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r7.getString(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0325;
    L_0x0320:
        r7 = "customData";
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0325:
        r6 = r19.getPackageManager();	 Catch:{ Exception -> 0x0339 }
        r7 = r19.getPackageName();	 Catch:{ Exception -> 0x0339 }
        r6 = r6.getInstallerPackageName(r7);	 Catch:{ Exception -> 0x0339 }
        if (r6 == 0) goto L_0x0340;
    L_0x0333:
        r7 = "installer_package";
        r8.put(r7, r6);	 Catch:{ Exception -> 0x0339 }
        goto L_0x0340;
    L_0x0339:
        r0 = move-exception;
        r6 = r0;
        r7 = "Exception while getting the app's installer package. ";
        com.appsflyer.AFLogger.a(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0340:
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = "sdkExtension";
        r6 = r6.getString(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0357;
    L_0x034c:
        r7 = r6.length();	 Catch:{ Throwable -> 0x0c3a }
        if (r7 <= 0) goto L_0x0357;
    L_0x0352:
        r7 = "sdkExtension";
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0357:
        r6 = new java.lang.ref.WeakReference;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r2);	 Catch:{ Throwable -> 0x0c3a }
        r7 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r9 = "channel";
        r7 = r7.getString(r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x036e;
    L_0x0368:
        r7 = "CHANNEL";
        r7 = a(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x036e:
        r6 = h(r2, r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0379;
    L_0x0374:
        r9 = "channel";
        r8.put(r9, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0379:
        if (r6 == 0) goto L_0x0381;
    L_0x037b:
        r9 = r6.equals(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r9 == 0) goto L_0x0385;
    L_0x0381:
        if (r6 != 0) goto L_0x038a;
    L_0x0383:
        if (r7 == 0) goto L_0x038a;
    L_0x0385:
        r6 = "af_latestchannel";
        r8.put(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x038a:
        r6 = "appsflyer-data";
        r7 = 0;
        r6 = r2.getSharedPreferences(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "INSTALL_STORE";
        r7 = r6.contains(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r7 == 0) goto L_0x03a1;
    L_0x0399:
        r7 = "INSTALL_STORE";
        r9 = 0;
        r6 = r6.getString(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x03be;
    L_0x03a1:
        r6 = "appsflyer-data";
        r7 = 0;
        r6 = r2.getSharedPreferences(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "appsFlyerCount";
        r6 = r6.contains(r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = 1;
        r6 = r6 ^ r7;
        if (r6 == 0) goto L_0x03b8;
    L_0x03b2:
        r9 = r(r19);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r9;
        goto L_0x03b9;
    L_0x03b8:
        r6 = 0;
    L_0x03b9:
        r7 = "INSTALL_STORE";
        a(r2, r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x03be:
        if (r6 == 0) goto L_0x03c9;
    L_0x03c0:
        r7 = "af_installstore";
        r6 = r6.toLowerCase();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x03c9:
        r6 = "appsflyer-data";
        r7 = 0;
        r6 = r2.getSharedPreferences(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "preInstallName";
        r9 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = r9.getString(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x048c;
    L_0x03dc:
        r9 = "preInstallName";
        r9 = r6.contains(r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r9 == 0) goto L_0x03ee;
    L_0x03e4:
        r7 = "preInstallName";
        r9 = 0;
        r6 = r6.getString(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r7 = r6;
        goto L_0x0481;
    L_0x03ee:
        r6 = "appsflyer-data";
        r9 = 0;
        r6 = r2.getSharedPreferences(r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "appsFlyerCount";
        r6 = r6.contains(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = 1;
        r6 = r6 ^ r9;
        if (r6 == 0) goto L_0x047a;
    L_0x03ff:
        r6 = "ro.appsflyer.preinstall.path";
        r6 = at(r6);	 Catch:{ Throwable -> 0x0c3a }
        r6 = au(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0414;
    L_0x040b:
        r7 = r6.exists();	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x0412;
    L_0x0411:
        goto L_0x0414;
    L_0x0412:
        r7 = 0;
        goto L_0x0415;
    L_0x0414:
        r7 = 1;
    L_0x0415:
        if (r7 == 0) goto L_0x0429;
    L_0x0417:
        r6 = "AF_PRE_INSTALL_PATH";
        r7 = r19.getPackageManager();	 Catch:{ Throwable -> 0x0c3a }
        r9 = r19.getPackageName();	 Catch:{ Throwable -> 0x0c3a }
        r6 = a(r6, r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r6 = au(r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0429:
        if (r6 == 0) goto L_0x0434;
    L_0x042b:
        r7 = r6.exists();	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x0432;
    L_0x0431:
        goto L_0x0434;
    L_0x0432:
        r7 = 0;
        goto L_0x0435;
    L_0x0434:
        r7 = 1;
    L_0x0435:
        if (r7 == 0) goto L_0x043d;
    L_0x0437:
        r6 = "/data/local/tmp/pre_install.appsflyer";
        r6 = au(r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x043d:
        if (r6 == 0) goto L_0x0448;
    L_0x043f:
        r7 = r6.exists();	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x0446;
    L_0x0445:
        goto L_0x0448;
    L_0x0446:
        r7 = 0;
        goto L_0x0449;
    L_0x0448:
        r7 = 1;
    L_0x0449:
        if (r7 == 0) goto L_0x0451;
    L_0x044b:
        r6 = "/etc/pre_install.appsflyer";
        r6 = au(r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0451:
        if (r6 == 0) goto L_0x045c;
    L_0x0453:
        r7 = r6.exists();	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x045a;
    L_0x0459:
        goto L_0x045c;
    L_0x045a:
        r7 = 0;
        goto L_0x045d;
    L_0x045c:
        r7 = 1;
    L_0x045d:
        if (r7 != 0) goto L_0x046b;
    L_0x045f:
        r7 = r19.getPackageName();	 Catch:{ Throwable -> 0x0c3a }
        r9 = b(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r9 == 0) goto L_0x046b;
    L_0x0469:
        r7 = r9;
        goto L_0x046c;
    L_0x046b:
        r7 = 0;
    L_0x046c:
        if (r7 == 0) goto L_0x046f;
    L_0x046e:
        goto L_0x047a;
    L_0x046f:
        r6 = new java.lang.ref.WeakReference;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r2);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "AF_PRE_INSTALL_NAME";
        r7 = a(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x047a:
        if (r7 == 0) goto L_0x0481;
    L_0x047c:
        r6 = "preInstallName";
        a(r2, r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0481:
        if (r7 == 0) goto L_0x048c;
    L_0x0483:
        r6 = "preInstallName";
        r9 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r9.set(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x048c:
        if (r7 == 0) goto L_0x0497;
    L_0x048e:
        r6 = "af_preinstall_name";
        r7 = r7.toLowerCase();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0497:
        r6 = r(r19);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x04a6;
    L_0x049d:
        r7 = "af_currentstore";
        r6 = r6.toLowerCase();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x04a6:
        if (r3 == 0) goto L_0x04b4;
    L_0x04a8:
        r6 = r20.length();	 Catch:{ Throwable -> 0x0c3a }
        if (r6 < 0) goto L_0x04b4;
    L_0x04ae:
        r6 = "appsflyerKey";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x04cb;
    L_0x04b4:
        r3 = "AppsFlyerKey";
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r6.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0c27;
    L_0x04c0:
        r6 = r3.length();	 Catch:{ Throwable -> 0x0c3a }
        if (r6 < 0) goto L_0x0c27;
    L_0x04c6:
        r6 = "appsflyerKey";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x04cb:
        r3 = "AppUserId";
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r6.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x04dc;
    L_0x04d7:
        r6 = "appUserId";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x04dc:
        r3 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = "userEmails";
        r3 = r3.getString(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x04ee;
    L_0x04e8:
        r6 = "user_emails";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0503;
    L_0x04ee:
        r3 = "userEmail";
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r6.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0503;
    L_0x04fa:
        r6 = "sha1_el";
        r3 = com.appsflyer.ae.aF(r3);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0503:
        if (r4 == 0) goto L_0x0511;
    L_0x0505:
        r3 = "eventName";
        r8.put(r3, r4);	 Catch:{ Throwable -> 0x0c3a }
        if (r5 == 0) goto L_0x0511;
    L_0x050c:
        r3 = "eventValue";
        r8.put(r3, r5);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0511:
        r3 = "appid";
        r5 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r5.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x052c;
    L_0x051d:
        r3 = "appid";
        r5 = "appid";
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r5 = r6.getString(r5);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r3, r5);	 Catch:{ Throwable -> 0x0c3a }
    L_0x052c:
        r3 = "currencyCode";
        r5 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r5.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        r5 = 3;
        if (r3 == 0) goto L_0x055a;
    L_0x0539:
        r6 = r3.length();	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == r5) goto L_0x0555;
    L_0x053f:
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r7 = "WARNING: currency code should be 3 characters!!! '";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0c3a }
        r6.append(r3);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "' is not a legal value.";
        r6.append(r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.ao(r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0555:
        r6 = "currency";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x055a:
        r3 = "IS_UPDATE";
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r6.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x056b;
    L_0x0566:
        r6 = "isUpdate";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x056b:
        r3 = r18.s(r19);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "af_preinstalled";
        r3 = java.lang.Boolean.toString(r3);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
        r3 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = "collectFacebookAttrId";
        r7 = 1;
        r3 = r3.getBoolean(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x05ae;
    L_0x0585:
        r3 = r19.getPackageManager();	 Catch:{ NameNotFoundException -> 0x05a1, Throwable -> 0x0598 }
        r6 = "com.facebook.katana";
        r7 = 0;
        r3.getApplicationInfo(r6, r7);	 Catch:{ NameNotFoundException -> 0x05a1, Throwable -> 0x0598 }
        r3 = r19.getContentResolver();	 Catch:{ NameNotFoundException -> 0x05a1, Throwable -> 0x0598 }
        r9 = r1.a(r3);	 Catch:{ NameNotFoundException -> 0x05a1, Throwable -> 0x0598 }
        goto L_0x05a7;
    L_0x0598:
        r0 = move-exception;
        r3 = r0;
        r6 = "Exception while collecting facebook's attribution ID. ";
        com.appsflyer.AFLogger.a(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x059f:
        r9 = 0;
        goto L_0x05a7;
    L_0x05a1:
        r3 = "Exception while collecting facebook's attribution ID. ";
        com.appsflyer.AFLogger.ao(r3);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x059f;
    L_0x05a7:
        if (r9 == 0) goto L_0x05ae;
    L_0x05a9:
        r3 = "fb";
        r8.put(r3, r9);	 Catch:{ Throwable -> 0x0c3a }
    L_0x05ae:
        r3 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = "deviceTrackingDisabled";
        r7 = 0;
        r3 = r3.getBoolean(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x05c4;
    L_0x05bb:
        r3 = "deviceTrackingDisabled";
        r6 = "true";
        r8.put(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x06e1;
    L_0x05c4:
        r3 = "appsflyer-data";
        r6 = 0;
        r3 = r2.getSharedPreferences(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = "collectIMEI";
        r9 = 1;
        r6 = r6.getBoolean(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "imeiCached";
        r9 = 0;
        r7 = r3.getString(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0651;
    L_0x05df:
        r6 = r1.pk;	 Catch:{ Throwable -> 0x0c3a }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0651;
    L_0x05e7:
        r6 = q(r19);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0658;
    L_0x05ed:
        r6 = "phone";
        r6 = r2.getSystemService(r6);	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r6 = (android.telephony.TelephonyManager) r6;	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r9 = r6.getClass();	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r10 = "getDeviceId";
        r11 = 0;
        r12 = new java.lang.Class[r11];	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r9 = r9.getMethod(r10, r12);	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r10 = new java.lang.Object[r11];	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r6 = r9.invoke(r6, r10);	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r9 = r6;
        r9 = (java.lang.String) r9;	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        if (r9 == 0) goto L_0x060e;
    L_0x060d:
        goto L_0x0659;
    L_0x060e:
        if (r7 == 0) goto L_0x0658;
    L_0x0610:
        r6 = "use cached IMEI: ";
        r9 = java.lang.String.valueOf(r7);	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r6 = r6.concat(r9);	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        com.appsflyer.AFLogger.am(r6);	 Catch:{ InvocationTargetException -> 0x0639, Exception -> 0x061f }
        r9 = r7;
        goto L_0x0659;
    L_0x061f:
        r0 = move-exception;
        r6 = r0;
        if (r7 == 0) goto L_0x0632;
    L_0x0623:
        r9 = "use cached IMEI: ";
        r10 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r9.concat(r10);	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.am(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r7;
        goto L_0x0633;
    L_0x0632:
        r9 = 0;
    L_0x0633:
        r7 = "WARNING: other reason: ";
        com.appsflyer.AFLogger.a(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0659;
    L_0x0639:
        if (r7 == 0) goto L_0x064a;
    L_0x063b:
        r6 = "use cached IMEI: ";
        r9 = java.lang.String.valueOf(r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.concat(r9);	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.am(r6);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r7;
        goto L_0x064b;
    L_0x064a:
        r9 = 0;
    L_0x064b:
        r6 = "WARNING: READ_PHONE_STATE is missing.";
        com.appsflyer.AFLogger.ao(r6);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0659;
    L_0x0651:
        r6 = r1.pk;	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0658;
    L_0x0655:
        r9 = r1.pk;	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0659;
    L_0x0658:
        r9 = 0;
    L_0x0659:
        if (r9 == 0) goto L_0x0666;
    L_0x065b:
        r6 = "imeiCached";
        a(r2, r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "imei";
        r8.put(r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x066b;
    L_0x0666:
        r6 = "IMEI was not collected.";
        com.appsflyer.AFLogger.an(r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x066b:
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = "collectAndroidId";
        r9 = 1;
        r6 = r6.getBoolean(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "androidIdCached";
        r9 = 0;
        r3 = r3.getString(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x06c7;
    L_0x067f:
        r6 = r1.pJ;	 Catch:{ Throwable -> 0x0c3a }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x06c7;
    L_0x0687:
        r6 = q(r19);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x06ce;
    L_0x068d:
        r6 = r19.getContentResolver();	 Catch:{ Exception -> 0x06ab }
        r7 = "android_id";
        r9 = android.provider.Settings.Secure.getString(r6, r7);	 Catch:{ Exception -> 0x06ab }
        if (r9 == 0) goto L_0x069a;
    L_0x0699:
        goto L_0x06cf;
    L_0x069a:
        if (r3 == 0) goto L_0x06ce;
    L_0x069c:
        r6 = "use cached AndroidId: ";
        r7 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x06ab }
        r6 = r6.concat(r7);	 Catch:{ Exception -> 0x06ab }
        com.appsflyer.AFLogger.am(r6);	 Catch:{ Exception -> 0x06ab }
        r9 = r3;
        goto L_0x06cf;
    L_0x06ab:
        r0 = move-exception;
        r6 = r0;
        if (r3 == 0) goto L_0x06be;
    L_0x06af:
        r7 = "use cached AndroidId: ";
        r9 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x0c3a }
        r7 = r7.concat(r9);	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.am(r7);	 Catch:{ Throwable -> 0x0c3a }
        r9 = r3;
        goto L_0x06bf;
    L_0x06be:
        r9 = 0;
    L_0x06bf:
        r3 = r6.getMessage();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.a(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x06cf;
    L_0x06c7:
        r3 = r1.pJ;	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x06ce;
    L_0x06cb:
        r9 = r1.pJ;	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x06cf;
    L_0x06ce:
        r9 = 0;
    L_0x06cf:
        if (r9 == 0) goto L_0x06dc;
    L_0x06d1:
        r3 = "androidIdCached";
        a(r2, r3, r9);	 Catch:{ Throwable -> 0x0c3a }
        r3 = "android_id";
        r8.put(r3, r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x06e1;
    L_0x06dc:
        r3 = "Android ID was not collected.";
        com.appsflyer.AFLogger.an(r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x06e1:
        r3 = new java.lang.ref.WeakReference;	 Catch:{ Exception -> 0x06f2 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x06f2 }
        r3 = com.appsflyer.af.c(r3);	 Catch:{ Exception -> 0x06f2 }
        if (r3 == 0) goto L_0x0709;
    L_0x06ec:
        r6 = "uid";
        r8.put(r6, r3);	 Catch:{ Exception -> 0x06f2 }
        goto L_0x0709;
    L_0x06f2:
        r0 = move-exception;
        r3 = r0;
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r7 = "ERROR: could not get uid ";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = r3.getMessage();	 Catch:{ Throwable -> 0x0c3a }
        r6.append(r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.a(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0709:
        r3 = "lang";
        r6 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0717 }
        r6 = r6.getDisplayLanguage();	 Catch:{ Exception -> 0x0717 }
        r8.put(r3, r6);	 Catch:{ Exception -> 0x0717 }
        goto L_0x071e;
    L_0x0717:
        r0 = move-exception;
        r3 = r0;
        r6 = "Exception while collecting display language name. ";
        com.appsflyer.AFLogger.a(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x071e:
        r3 = "lang_code";
        r6 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x072c }
        r6 = r6.getLanguage();	 Catch:{ Exception -> 0x072c }
        r8.put(r3, r6);	 Catch:{ Exception -> 0x072c }
        goto L_0x0733;
    L_0x072c:
        r0 = move-exception;
        r3 = r0;
        r6 = "Exception while collecting display language code. ";
        com.appsflyer.AFLogger.a(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0733:
        r3 = "country";
        r6 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0741 }
        r6 = r6.getCountry();	 Catch:{ Exception -> 0x0741 }
        r8.put(r3, r6);	 Catch:{ Exception -> 0x0741 }
        goto L_0x0748;
    L_0x0741:
        r0 = move-exception;
        r3 = r0;
        r6 = "Exception while collecting country name. ";
        com.appsflyer.AFLogger.a(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0748:
        r3 = "platformextension";
        r6 = r1.pR;	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.fE();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
        a(r2, r8);	 Catch:{ Throwable -> 0x0c3a }
        r3 = "yyyy-MM-dd_HHmmssZ";
        r6 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x0c3a }
        r7 = java.util.Locale.US;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r3, r7);	 Catch:{ Throwable -> 0x0c3a }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0c3a }
        r7 = 9;
        if (r3 < r7) goto L_0x0793;
    L_0x0765:
        r3 = r19.getPackageManager();	 Catch:{ Exception -> 0x078c }
        r7 = r19.getPackageName();	 Catch:{ Exception -> 0x078c }
        r9 = 0;
        r3 = r3.getPackageInfo(r7, r9);	 Catch:{ Exception -> 0x078c }
        r9 = r3.firstInstallTime;	 Catch:{ Exception -> 0x078c }
        r3 = "installDate";
        r7 = "UTC";
        r7 = java.util.TimeZone.getTimeZone(r7);	 Catch:{ Exception -> 0x078c }
        r6.setTimeZone(r7);	 Catch:{ Exception -> 0x078c }
        r7 = new java.util.Date;	 Catch:{ Exception -> 0x078c }
        r7.<init>(r9);	 Catch:{ Exception -> 0x078c }
        r7 = r6.format(r7);	 Catch:{ Exception -> 0x078c }
        r8.put(r3, r7);	 Catch:{ Exception -> 0x078c }
        goto L_0x0793;
    L_0x078c:
        r0 = move-exception;
        r3 = r0;
        r7 = "Exception while collecting install date. ";
        com.appsflyer.AFLogger.a(r7, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0793:
        r3 = r19.getPackageManager();	 Catch:{ Throwable -> 0x084d }
        r7 = r19.getPackageName();	 Catch:{ Throwable -> 0x084d }
        r9 = 0;
        r3 = r3.getPackageInfo(r7, r9);	 Catch:{ Throwable -> 0x084d }
        r7 = "versionCode";
        r10 = r25;
        r7 = r10.getInt(r7, r9);	 Catch:{ Throwable -> 0x084b }
        r11 = r3.versionCode;	 Catch:{ Throwable -> 0x084b }
        if (r11 <= r7) goto L_0x07b8;
    L_0x07ac:
        r7 = "appsflyerConversionDataRequestRetries";
        b(r2, r7, r9);	 Catch:{ Throwable -> 0x084b }
        r7 = "versionCode";
        r9 = r3.versionCode;	 Catch:{ Throwable -> 0x084b }
        b(r2, r7, r9);	 Catch:{ Throwable -> 0x084b }
    L_0x07b8:
        r7 = "app_version_code";
        r9 = r3.versionCode;	 Catch:{ Throwable -> 0x084b }
        r9 = java.lang.Integer.toString(r9);	 Catch:{ Throwable -> 0x084b }
        r8.put(r7, r9);	 Catch:{ Throwable -> 0x084b }
        r7 = "app_version_name";
        r9 = r3.versionName;	 Catch:{ Throwable -> 0x084b }
        r8.put(r7, r9);	 Catch:{ Throwable -> 0x084b }
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x084b }
        r9 = 9;
        if (r7 < r9) goto L_0x0856;
    L_0x07d0:
        r11 = r3.firstInstallTime;	 Catch:{ Throwable -> 0x084b }
        r13 = r3.lastUpdateTime;	 Catch:{ Throwable -> 0x084b }
        r3 = "date1";
        r7 = "UTC";
        r7 = java.util.TimeZone.getTimeZone(r7);	 Catch:{ Throwable -> 0x084b }
        r6.setTimeZone(r7);	 Catch:{ Throwable -> 0x084b }
        r7 = new java.util.Date;	 Catch:{ Throwable -> 0x084b }
        r7.<init>(r11);	 Catch:{ Throwable -> 0x084b }
        r7 = r6.format(r7);	 Catch:{ Throwable -> 0x084b }
        r8.put(r3, r7);	 Catch:{ Throwable -> 0x084b }
        r3 = "date2";
        r7 = "UTC";
        r7 = java.util.TimeZone.getTimeZone(r7);	 Catch:{ Throwable -> 0x084b }
        r6.setTimeZone(r7);	 Catch:{ Throwable -> 0x084b }
        r7 = new java.util.Date;	 Catch:{ Throwable -> 0x084b }
        r7.<init>(r13);	 Catch:{ Throwable -> 0x084b }
        r7 = r6.format(r7);	 Catch:{ Throwable -> 0x084b }
        r8.put(r3, r7);	 Catch:{ Throwable -> 0x084b }
        r3 = "appsflyer-data";
        r7 = 0;
        r3 = r2.getSharedPreferences(r3, r7);	 Catch:{ Throwable -> 0x084b }
        r9 = "appsFlyerFirstInstall";
        r11 = 0;
        r3 = r3.getString(r9, r11);	 Catch:{ Throwable -> 0x084b }
        if (r3 != 0) goto L_0x0838;
    L_0x0812:
        r3 = "appsflyer-data";
        r3 = r2.getSharedPreferences(r3, r7);	 Catch:{ Throwable -> 0x084b }
        r7 = "appsFlyerCount";
        r3 = r3.contains(r7);	 Catch:{ Throwable -> 0x084b }
        r7 = 1;
        r3 = r3 ^ r7;
        if (r3 == 0) goto L_0x0831;
    L_0x0822:
        r3 = "AppsFlyer: first launch detected";
        com.appsflyer.AFLogger.am(r3);	 Catch:{ Throwable -> 0x084b }
        r3 = new java.util.Date;	 Catch:{ Throwable -> 0x084b }
        r3.<init>();	 Catch:{ Throwable -> 0x084b }
        r3 = r6.format(r3);	 Catch:{ Throwable -> 0x084b }
        goto L_0x0833;
    L_0x0831:
        r3 = "";
    L_0x0833:
        r6 = "appsFlyerFirstInstall";
        a(r2, r6, r3);	 Catch:{ Throwable -> 0x084b }
    L_0x0838:
        r6 = "AppsFlyer: first launch date: ";
        r7 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x084b }
        r6 = r6.concat(r7);	 Catch:{ Throwable -> 0x084b }
        com.appsflyer.AFLogger.an(r6);	 Catch:{ Throwable -> 0x084b }
        r6 = "firstLaunchDate";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x084b }
        goto L_0x0856;
    L_0x084b:
        r0 = move-exception;
        goto L_0x0850;
    L_0x084d:
        r0 = move-exception;
        r10 = r25;
    L_0x0850:
        r3 = r0;
        r6 = "Exception while collecting app version data ";
        com.appsflyer.AFLogger.a(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0856:
        r3 = r23.length();	 Catch:{ Throwable -> 0x0c3a }
        if (r3 <= 0) goto L_0x0863;
    L_0x085c:
        r3 = "referrer";
        r6 = r23;
        r8.put(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0863:
        r3 = "extraReferrers";
        r6 = 0;
        r3 = r10.getString(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0871;
    L_0x086c:
        r6 = "extraReferrers";
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0871:
        r3 = "afUninstallToken";
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r3 = r6.getString(r3);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x088a;
    L_0x087d:
        r3 = com.appsflyer.s.aB(r3);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "af_gcm_token";
        r3 = r3.fv();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r6, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x088a:
        r3 = com.appsflyer.ag.p(r19);	 Catch:{ Throwable -> 0x0c3a }
        r1.pP = r3;	 Catch:{ Throwable -> 0x0c3a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r6 = "didConfigureTokenRefreshService=";
        r3.<init>(r6);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r1.pP;	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r6);	 Catch:{ Throwable -> 0x0c3a }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0c3a }
        com.appsflyer.AFLogger.am(r3);	 Catch:{ Throwable -> 0x0c3a }
        r3 = r1.pP;	 Catch:{ Throwable -> 0x0c3a }
        if (r3 != 0) goto L_0x08ae;
    L_0x08a7:
        r3 = "tokenRefreshConfigured";
        r6 = java.lang.Boolean.FALSE;	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x08ae:
        r3 = r26;
        if (r3 == 0) goto L_0x08d0;
    L_0x08b2:
        r6 = r1.pO;	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x08cd;
    L_0x08b6:
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0c3a }
        r7 = r1.pO;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "isPush";
        r9 = "true";
        r6.put(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "af_deeplink";
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x08cd:
        r6 = 0;
        r1.pO = r6;	 Catch:{ Throwable -> 0x0c3a }
    L_0x08d0:
        if (r3 == 0) goto L_0x0933;
    L_0x08d2:
        if (r27 == 0) goto L_0x08e5;
    L_0x08d4:
        r7 = "android.intent.action.VIEW";
        r9 = r27.getAction();	 Catch:{ Throwable -> 0x0c3a }
        r7 = r7.equals(r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r7 == 0) goto L_0x08e5;
    L_0x08e0:
        r9 = r27.getData();	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x08e6;
    L_0x08e5:
        r9 = 0;
    L_0x08e6:
        if (r9 == 0) goto L_0x092a;
    L_0x08e8:
        r6 = a(r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0926;
    L_0x08ee:
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = "consumeAfDeepLink";
        r11 = 0;
        r6 = r6.getBoolean(r7, r11);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0926;
    L_0x08fb:
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = "prevDPURI";
        r6 = r6.getString(r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = r9.toString();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r7.equals(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0915;
    L_0x090f:
        r6 = "Skipping execution of previously consumed AppsFlyer deep link";
        com.appsflyer.AFLogger.an(r6);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0933;
    L_0x0915:
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r7 = "prevDPURI";
        r11 = r9.toString();	 Catch:{ Throwable -> 0x0c3a }
        r6.set(r7, r11);	 Catch:{ Throwable -> 0x0c3a }
        r1.a(r2, r8, r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0933;
    L_0x0926:
        r1.a(r2, r8, r9);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0933;
    L_0x092a:
        r6 = r1.pK;	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0933;
    L_0x092e:
        r6 = r1.pK;	 Catch:{ Throwable -> 0x0c3a }
        r1.a(r2, r8, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0933:
        r6 = r1.pN;	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x095b;
    L_0x0937:
        r6 = "testAppMode_retargeting";
        r7 = "true";
        r8.put(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0c3a }
        r7 = new android.content.Intent;	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.appsflyer.testIntgrationBroadcast";
        r7.<init>(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "params";
        r7.putExtra(r9, r6);	 Catch:{ Throwable -> 0x0c3a }
        r2.sendBroadcast(r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "Sent retargeting params to test app";
        com.appsflyer.AFLogger.an(r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x095b:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0c3a }
        r11 = r1.pL;	 Catch:{ Throwable -> 0x0c3a }
        r9 = 0;
        r13 = r6 - r11;
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.x(r2);	 Catch:{ Throwable -> 0x0c3a }
        r11 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
        if (r7 > 0) goto L_0x097e;
    L_0x0972:
        if (r6 == 0) goto L_0x097e;
    L_0x0974:
        r7 = "AppsFlyer_Test";
        r6 = r6.contains(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x097e;
    L_0x097c:
        r6 = 1;
        goto L_0x097f;
    L_0x097e:
        r6 = 0;
    L_0x097f:
        if (r6 == 0) goto L_0x09ae;
    L_0x0981:
        r6 = "testAppMode";
        r7 = "true";
        r8.put(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0c3a }
        r7 = new android.content.Intent;	 Catch:{ Throwable -> 0x0c3a }
        r9 = "com.appsflyer.testIntgrationBroadcast";
        r7.<init>(r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "params";
        r7.putExtra(r9, r6);	 Catch:{ Throwable -> 0x0c3a }
        r2.sendBroadcast(r7);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "Sent params to test app";
        com.appsflyer.AFLogger.an(r6);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "Test mode ended!";
        com.appsflyer.AFLogger.an(r6);	 Catch:{ Throwable -> 0x0c3a }
        r6 = 0;
        r1.pL = r6;	 Catch:{ Throwable -> 0x0c3a }
    L_0x09ae:
        r6 = "advertiserId";
        r7 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r7.getString(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 != 0) goto L_0x09d8;
    L_0x09ba:
        com.appsflyer.o.a(r2, r8);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "advertiserId";
        r7 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r7.getString(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x09d1;
    L_0x09c9:
        r6 = "GAID_retry";
        r7 = "true";
        r8.put(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x09d8;
    L_0x09d1:
        r6 = "GAID_retry";
        r7 = "false";
        r8.put(r6, r7);	 Catch:{ Throwable -> 0x0c3a }
    L_0x09d8:
        r6 = r19.getContentResolver();	 Catch:{ Throwable -> 0x0c3a }
        r6 = com.appsflyer.o.b(r6);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x09f8;
    L_0x09e2:
        r7 = "amazon_aid";
        r9 = r6.fN();	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "amazon_aid_limit";
        r6 = r6.fZ();	 Catch:{ Throwable -> 0x0c3a }
        r6 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x09f8:
        r6 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.x(r2);	 Catch:{ Throwable -> 0x0c3a }
        if (r6 == 0) goto L_0x0a15;
    L_0x0a02:
        r7 = r6.length();	 Catch:{ Throwable -> 0x0c3a }
        if (r7 <= 0) goto L_0x0a15;
    L_0x0a08:
        r7 = "referrer";
        r7 = r8.get(r7);	 Catch:{ Throwable -> 0x0c3a }
        if (r7 != 0) goto L_0x0a15;
    L_0x0a10:
        r7 = "referrer";
        r8.put(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0a15:
        r6 = "true";
        r7 = "sentSuccessfully";
        r9 = "";
        r7 = r10.getString(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r6 = r6.equals(r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "sentRegisterRequestToAF";
        r9 = 0;
        r7 = r10.getBoolean(r7, r9);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "registeredUninstall";
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r9, r7);	 Catch:{ Throwable -> 0x0c3a }
        r7 = "appsFlyerCount";
        r7 = a(r10, r7, r3);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "counter";
        r11 = java.lang.Integer.toString(r7);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r9, r11);	 Catch:{ Throwable -> 0x0c3a }
        r9 = "iaecounter";
        if (r4 == 0) goto L_0x0a48;
    L_0x0a46:
        r4 = 1;
        goto L_0x0a49;
    L_0x0a48:
        r4 = 0;
    L_0x0a49:
        r11 = "appsFlyerInAppEventCount";
        r4 = a(r10, r11, r4);	 Catch:{ Throwable -> 0x0c3a }
        r4 = java.lang.Integer.toString(r4);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r9, r4);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0a79;
    L_0x0a58:
        r4 = 1;
        if (r7 != r4) goto L_0x0a79;
    L_0x0a5b:
        r4 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r4.fI();	 Catch:{ Throwable -> 0x0c3a }
        r4 = "waitForCustomerId";
        r9 = com.appsflyer.i.fF();	 Catch:{ Throwable -> 0x0c3a }
        r11 = 0;
        r4 = r9.getBoolean(r4, r11);	 Catch:{ Throwable -> 0x0c3a }
        if (r4 == 0) goto L_0x0a79;
    L_0x0a6f:
        r4 = "wait_cid";
        r9 = 1;
        r11 = java.lang.Boolean.toString(r9);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r4, r11);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0a79:
        r4 = "isFirstCall";
        r9 = 1;
        r6 = r6 ^ r9;
        r6 = java.lang.Boolean.toString(r6);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r4, r6);	 Catch:{ Throwable -> 0x0c3a }
        r4 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0c3a }
        r4.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r6 = "cpu_abi";
        r9 = "ro.product.cpu.abi";
        r9 = at(r9);	 Catch:{ Throwable -> 0x0c3a }
        r4.put(r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "cpu_abi2";
        r9 = "ro.product.cpu.abi2";
        r9 = at(r9);	 Catch:{ Throwable -> 0x0c3a }
        r4.put(r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "arch";
        r9 = "os.arch";
        r9 = at(r9);	 Catch:{ Throwable -> 0x0c3a }
        r4.put(r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        r6 = "build_display_id";
        r9 = "ro.build.display.id";
        r9 = at(r9);	 Catch:{ Throwable -> 0x0c3a }
        r4.put(r6, r9);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0b32;
    L_0x0ab7:
        r3 = r1.pM;	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0afa;
    L_0x0abb:
        r3 = com.appsflyer.w.a.qC;	 Catch:{ Throwable -> 0x0c3a }
        r3 = com.appsflyer.w.E(r19);	 Catch:{ Throwable -> 0x0c3a }
        r6 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0c3a }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x0c3a }
        if (r3 == 0) goto L_0x0aef;
    L_0x0ac8:
        r5 = "lat";
        r11 = r3.getLatitude();	 Catch:{ Throwable -> 0x0c3a }
        r9 = java.lang.String.valueOf(r11);	 Catch:{ Throwable -> 0x0c3a }
        r6.put(r5, r9);	 Catch:{ Throwable -> 0x0c3a }
        r5 = "lon";
        r11 = r3.getLongitude();	 Catch:{ Throwable -> 0x0c3a }
        r9 = java.lang.String.valueOf(r11);	 Catch:{ Throwable -> 0x0c3a }
        r6.put(r5, r9);	 Catch:{ Throwable -> 0x0c3a }
        r5 = "ts";
        r11 = r3.getTime();	 Catch:{ Throwable -> 0x0c3a }
        r3 = java.lang.String.valueOf(r11);	 Catch:{ Throwable -> 0x0c3a }
        r6.put(r5, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0aef:
        r3 = r6.isEmpty();	 Catch:{ Throwable -> 0x0c3a }
        if (r3 != 0) goto L_0x0afa;
    L_0x0af5:
        r3 = "loc";
        r4.put(r3, r6);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0afa:
        r3 = com.appsflyer.v.b.qB;	 Catch:{ Throwable -> 0x0c3a }
        r3 = r3.D(r2);	 Catch:{ Throwable -> 0x0c3a }
        r5 = "btl";
        r6 = r3.fT();	 Catch:{ Throwable -> 0x0c3a }
        r6 = java.lang.Float.toString(r6);	 Catch:{ Throwable -> 0x0c3a }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x0c3a }
        r5 = r3.fw();	 Catch:{ Throwable -> 0x0c3a }
        if (r5 == 0) goto L_0x0b1c;
    L_0x0b13:
        r5 = "btch";
        r3 = r3.fw();	 Catch:{ Throwable -> 0x0c3a }
        r4.put(r5, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0b1c:
        r3 = 2;
        if (r3 < r7) goto L_0x0b32;
    L_0x0b1f:
        r3 = com.appsflyer.z.G(r19);	 Catch:{ Throwable -> 0x0c3a }
        r3 = r3.fV();	 Catch:{ Throwable -> 0x0c3a }
        r5 = r3.isEmpty();	 Catch:{ Throwable -> 0x0c3a }
        if (r5 != 0) goto L_0x0b32;
    L_0x0b2d:
        r5 = "sensors";
        r4.put(r5, r3);	 Catch:{ Throwable -> 0x0c3a }
    L_0x0b32:
        r2 = com.appsflyer.d.m(r19);	 Catch:{ Throwable -> 0x0c3a }
        r3 = "dim";
        r4.put(r3, r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "deviceData";
        r8.put(r2, r4);	 Catch:{ Throwable -> 0x0c3a }
        r2 = new com.appsflyer.ae;	 Catch:{ Throwable -> 0x0c3a }
        r2.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r2 = "appsflyerKey";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0c3a }
        r3 = "af_timestamp";
        r3 = r8.get(r3);	 Catch:{ Throwable -> 0x0c3a }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0c3a }
        r4 = "uid";
        r4 = r8.get(r4);	 Catch:{ Throwable -> 0x0c3a }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x0c3a }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r5.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r6 = 7;
        r7 = 0;
        r2 = r2.substring(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
        r5.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r4.substring(r7, r6);	 Catch:{ Throwable -> 0x0c3a }
        r5.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r3.length();	 Catch:{ Throwable -> 0x0c3a }
        r2 = r2 - r6;
        r2 = r3.substring(r2);	 Catch:{ Throwable -> 0x0c3a }
        r5.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r5.toString();	 Catch:{ Throwable -> 0x0c3a }
        r2 = com.appsflyer.ae.aF(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3 = "af_v";
        r8.put(r3, r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = new com.appsflyer.ae;	 Catch:{ Throwable -> 0x0c3a }
        r2.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r2 = "appsflyerKey";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0c3a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r3.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "af_timestamp";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0c3a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r3.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "uid";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0c3a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r3.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "installDate";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0c3a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r3.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "counter";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0c3a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0c3a }
        r3.<init>();	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "iaecounter";
        r2 = r8.get(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3.append(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x0c3a }
        r2 = com.appsflyer.ae.aG(r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = com.appsflyer.ae.aF(r2);	 Catch:{ Throwable -> 0x0c3a }
        r3 = "af_v2";
        r8.put(r3, r2);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "is_stop_tracking_used";
        r2 = r10.contains(r2);	 Catch:{ Throwable -> 0x0c3a }
        if (r2 == 0) goto L_0x0c43;
    L_0x0c16:
        r2 = "istu";
        r3 = "is_stop_tracking_used";
        r4 = 0;
        r3 = r10.getBoolean(r3, r4);	 Catch:{ Throwable -> 0x0c3a }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x0c3a }
        r8.put(r2, r3);	 Catch:{ Throwable -> 0x0c3a }
        goto L_0x0c43;
    L_0x0c27:
        r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ";
        com.appsflyer.AFLogger.an(r3);	 Catch:{ Throwable -> 0x0c3a }
        r3 = "AppsFlyer_4.8.15";
        r4 = "DEV_KEY_MISSING";
        r5 = 0;
        a(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x0c3a }
        r2 = "AppsFlyer will not track this event.";
        com.appsflyer.AFLogger.an(r2);	 Catch:{ Throwable -> 0x0c3a }
        return r5;
    L_0x0c3a:
        r0 = move-exception;
        r2 = r0;
        r3 = r2.getLocalizedMessage();
        com.appsflyer.AFLogger.a(r3, r2);
    L_0x0c43:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, android.content.SharedPreferences, boolean, android.content.Intent):java.util.Map<java.lang.String, java.lang.Object>");
    }

    private static void a(Context context, Map<String, ? super String> map) {
        y yVar = b.qI;
        a F = y.F(context);
        map.put("network", F.fN());
        if (F.fw() != null) {
            map.put("operator", F.fw());
        }
        if (F.fE() != null) {
            map.put("carrier", F.fE());
        }
    }

    private void a(Context context, Map<String, Object> map, Uri uri) {
        Map g;
        map.put("af_deeplink", uri.toString());
        if (uri.getQueryParameter("af_deeplink") != null) {
            boolean z = "AppsFlyer_Test".equals(uri.getQueryParameter("media_source")) && Boolean.parseBoolean(uri.getQueryParameter("is_retargeting"));
            this.pN = z;
            g = g(context, uri.getQuery());
            String str = "path";
            String path = uri.getPath();
            if (path != null) {
                g.put(str, path);
            }
            str = "scheme";
            path = uri.getScheme();
            if (path != null) {
                g.put(str, path);
            }
            str = "host";
            path = uri.getHost();
            if (path != null) {
                g.put(str, path);
            }
        } else {
            g = new HashMap();
            g.put("link", uri.toString());
        }
        final WeakReference weakReference = new WeakReference(context);
        Runnable acVar = new ac(uri, this);
        acVar.a(new com.appsflyer.p.a());
        if (acVar.fZ()) {
            acVar.a(new a() {
                public final void aj(String str) {
                    if (h.px != null) {
                        g(g);
                        h.px.aq(str);
                    }
                }

                private void g(Map<String, String> map) {
                    if (weakReference.get() != null) {
                        h.a((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map).toString());
                    }
                }

                public final void h(Map<String, String> map) {
                    for (String str : map.keySet()) {
                        g.put(str, map.get(str));
                    }
                    g(g);
                    h.g(g);
                }
            });
            a.fp().fq().execute(acVar);
            return;
        }
        if (px != null) {
            try {
                px.f(g);
            } catch (Throwable th) {
                AFLogger.a(th.getLocalizedMessage(), th);
            }
        }
    }

    private static boolean p(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.a("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (Throwable e) {
            AFLogger.a("WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    private static boolean q(Context context) {
        Object obj = (i.fF().getBoolean("collectAndroidIdForceByUser", false) || i.fF().getBoolean("collectIMEIForceByUser", false)) ? 1 : null;
        if (obj == null && p(context)) {
            return false;
        }
        return true;
    }

    private static String r(Context context) {
        String string = i.fF().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String a = a(new WeakReference(context), "AF_STORE");
        return a != null ? a : null;
    }

    private static String at(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.a(th.getMessage(), th);
            return null;
        }
    }

    @Nullable
    private static String a(WeakReference<Context> weakReference, String str) {
        if (weakReference.get() == null) {
            return null;
        }
        return a(str, ((Context) weakReference.get()).getPackageManager(), ((Context) weakReference.get()).getPackageName());
    }

    @Nullable
    private static String a(String str, PackageManager packageManager, String str2) {
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Could not find ");
            stringBuilder.append(str);
            stringBuilder.append(" value in the manifest");
            AFLogger.a(stringBuilder.toString(), th);
            return null;
        }
    }

    private static boolean a(Uri uri) {
        String toLowerCase = uri.toString().toLowerCase();
        for (CharSequence contains : com.appsflyer.b.a.rl) {
            if (toLowerCase.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A:{SYNTHETIC, Splitter: B:18:0x0034} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060 A:{SYNTHETIC, Splitter: B:31:0x0060} */
    private static java.lang.String b(java.io.File r4, java.lang.String r5) {
        /*
        r0 = 0;
        r1 = new java.util.Properties;	 Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
        r1.<init>();	 Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
        r2 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
        r2.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0041, Throwable -> 0x0029, all -> 0x0026 }
        r1.load(r2);	 Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
        r3 = "Found PreInstall property!";
        com.appsflyer.AFLogger.an(r3);	 Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
        r5 = r1.getProperty(r5);	 Catch:{ FileNotFoundException -> 0x0042, Throwable -> 0x0024 }
        r2.close();	 Catch:{ Throwable -> 0x001b }
        goto L_0x0023;
    L_0x001b:
        r4 = move-exception;
        r0 = r4.getMessage();
        com.appsflyer.AFLogger.a(r0, r4);
    L_0x0023:
        return r5;
    L_0x0024:
        r4 = move-exception;
        goto L_0x002b;
    L_0x0026:
        r4 = move-exception;
        r2 = r0;
        goto L_0x005e;
    L_0x0029:
        r4 = move-exception;
        r2 = r0;
    L_0x002b:
        r5 = r4.getMessage();	 Catch:{ all -> 0x005d }
        com.appsflyer.AFLogger.a(r5, r4);	 Catch:{ all -> 0x005d }
        if (r2 == 0) goto L_0x005c;
    L_0x0034:
        r2.close();	 Catch:{ Throwable -> 0x0038 }
        goto L_0x005c;
    L_0x0038:
        r4 = move-exception;
        r5 = r4.getMessage();
        com.appsflyer.AFLogger.a(r5, r4);
        goto L_0x005c;
    L_0x0041:
        r2 = r0;
    L_0x0042:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005d }
        r1 = "PreInstall file wasn't found: ";
        r5.<init>(r1);	 Catch:{ all -> 0x005d }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x005d }
        r5.append(r4);	 Catch:{ all -> 0x005d }
        r4 = r5.toString();	 Catch:{ all -> 0x005d }
        com.appsflyer.AFLogger.am(r4);	 Catch:{ all -> 0x005d }
        if (r2 == 0) goto L_0x005c;
    L_0x0059:
        r2.close();	 Catch:{ Throwable -> 0x0038 }
    L_0x005c:
        return r0;
    L_0x005d:
        r4 = move-exception;
    L_0x005e:
        if (r2 == 0) goto L_0x006c;
    L_0x0060:
        r2.close();	 Catch:{ Throwable -> 0x0064 }
        goto L_0x006c;
    L_0x0064:
        r5 = move-exception;
        r0 = r5.getMessage();
        com.appsflyer.AFLogger.a(r0, r5);
    L_0x006c:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.b(java.io.File, java.lang.String):java.lang.String");
    }

    private static File au(String str) {
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    return new File(str.trim());
                }
            } catch (Throwable th) {
                AFLogger.a(th.getMessage(), th);
            }
        }
        return null;
    }

    public boolean s(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            AFLogger.a("Could not check if app is pre installed", e);
        }
    }

    private static String h(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("appsflyer-data", 0);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", null);
        }
        a(context, "CACHED_CHANNEL", str);
        return str;
    }

    public String a(ContentResolver contentResolver) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[]{"aid"}, null, null, null);
        String str = null;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("aid"));
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable e) {
                            AFLogger.a(e.getMessage(), e);
                        }
                    }
                    str = string;
                    return str;
                }
            } catch (Throwable e2) {
                AFLogger.a("Could not collect cursor attribution. ", e2);
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable e3) {
                        AFLogger.a(e3.getMessage(), e3);
                    }
                }
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable e32) {
                        AFLogger.a(e32.getMessage(), e32);
                    }
                }
            }
        }
        if (query != null) {
            try {
                query.close();
            } catch (Throwable e322) {
                AFLogger.a(e322.getMessage(), e322);
            }
        }
        return null;
    }

    static SharedPreferences t(Context context) {
        return context.getSharedPreferences("appsflyer-data", 0);
    }

    static int a(SharedPreferences sharedPreferences) {
        return a(sharedPreferences, "appsFlyerCount", false);
    }

    private static int a(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = sharedPreferences.getInt(str, 0);
        if (z) {
            i++;
            Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
        if (ah.ge().gi()) {
            ah.ge().ah(String.valueOf(i));
        }
        return i;
    }

    public String u(Context context) {
        ah.ge().a("getAppsFlyerUID", new String[0]);
        return af.c(new WeakReference(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0228 A:{Catch:{ l -> 0x020c, all -> 0x0234 }} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0224 A:{SYNTHETIC, Splitter: B:99:0x0224} */
    private void a(java.net.URL r21, java.lang.String r22, java.lang.String r23, java.lang.ref.WeakReference<android.content.Context> r24, java.lang.String r25, boolean r26) {
        /*
        r20 = this;
        r1 = r20;
        r2 = r22;
        r3 = r23;
        r4 = r25;
        r6 = r24.get();
        r6 = (android.content.Context) r6;
        r7 = 1;
        r8 = 0;
        if (r26 == 0) goto L_0x0018;
    L_0x0012:
        r9 = px;
        if (r9 == 0) goto L_0x0018;
    L_0x0016:
        r9 = 1;
        goto L_0x0019;
    L_0x0018:
        r9 = 0;
    L_0x0019:
        r10 = 0;
        r11 = com.appsflyer.ah.ge();	 Catch:{ all -> 0x0237 }
        r12 = r21.toString();	 Catch:{ all -> 0x0237 }
        r11.j(r12, r2);	 Catch:{ all -> 0x0237 }
        r11 = r21.openConnection();	 Catch:{ all -> 0x0237 }
        r11 = (java.net.HttpURLConnection) r11;	 Catch:{ all -> 0x0237 }
        r12 = "POST";
        r11.setRequestMethod(r12);	 Catch:{ all -> 0x0234 }
        r12 = r22.getBytes();	 Catch:{ all -> 0x0234 }
        r12 = r12.length;	 Catch:{ all -> 0x0234 }
        r13 = "Content-Length";
        r12 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x0234 }
        r11.setRequestProperty(r13, r12);	 Catch:{ all -> 0x0234 }
        r12 = "Content-Type";
        r13 = "application/json";
        r11.setRequestProperty(r12, r13);	 Catch:{ all -> 0x0234 }
        r12 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r11.setConnectTimeout(r12);	 Catch:{ all -> 0x0234 }
        r11.setDoOutput(r7);	 Catch:{ all -> 0x0234 }
        r12 = new java.io.OutputStreamWriter;	 Catch:{ all -> 0x0220 }
        r13 = r11.getOutputStream();	 Catch:{ all -> 0x0220 }
        r14 = "UTF-8";
        r12.<init>(r13, r14);	 Catch:{ all -> 0x0220 }
        r12.write(r2);	 Catch:{ all -> 0x021c }
        r12.close();	 Catch:{ all -> 0x0234 }
        r2 = r11.getResponseCode();	 Catch:{ all -> 0x0234 }
        r12 = a(r11);	 Catch:{ all -> 0x0234 }
        r13 = com.appsflyer.ah.ge();	 Catch:{ all -> 0x0234 }
        r14 = r21.toString();	 Catch:{ all -> 0x0234 }
        r13.a(r14, r2, r12);	 Catch:{ all -> 0x0234 }
        r13 = "response code: ";
        r14 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0234 }
        r13 = r13.concat(r14);	 Catch:{ all -> 0x0234 }
        com.appsflyer.AFLogger.an(r13);	 Catch:{ all -> 0x0234 }
        r13 = "AppsFlyer_4.8.15";
        r14 = "SERVER_RESPONSE_CODE";
        r15 = java.lang.Integer.toString(r2);	 Catch:{ all -> 0x0234 }
        a(r6, r13, r14, r15);	 Catch:{ all -> 0x0234 }
        r13 = "appsflyer-data";
        r13 = r6.getSharedPreferences(r13, r8);	 Catch:{ all -> 0x0234 }
        r14 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r14) goto L_0x015c;
    L_0x0093:
        r2 = r24.get();	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x00aa;
    L_0x0099:
        if (r26 == 0) goto L_0x00aa;
    L_0x009b:
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0234 }
        r1.pt = r14;	 Catch:{ all -> 0x0234 }
        r2 = pz;	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x00aa;
    L_0x00a5:
        r2 = pz;	 Catch:{ all -> 0x0234 }
        r2.fL();	 Catch:{ all -> 0x0234 }
    L_0x00aa:
        r2 = "afUninstallToken";
        r5 = com.appsflyer.i.fF();	 Catch:{ all -> 0x0234 }
        r2 = r5.getString(r2);	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x00e1;
    L_0x00b6:
        r5 = "Uninstall Token exists: ";
        r14 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0234 }
        r5 = r5.concat(r14);	 Catch:{ all -> 0x0234 }
        com.appsflyer.AFLogger.am(r5);	 Catch:{ all -> 0x0234 }
        r5 = "sentRegisterRequestToAF";
        r5 = r13.getBoolean(r5, r8);	 Catch:{ all -> 0x0234 }
        if (r5 != 0) goto L_0x0101;
    L_0x00cb:
        r5 = "Resending Uninstall token to AF servers: ";
        r14 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0234 }
        r5 = r5.concat(r14);	 Catch:{ all -> 0x0234 }
        com.appsflyer.AFLogger.am(r5);	 Catch:{ all -> 0x0234 }
        r5 = new com.appsflyer.s;	 Catch:{ all -> 0x0234 }
        r5.<init>(r2);	 Catch:{ all -> 0x0234 }
        com.appsflyer.ag.a(r6, r5);	 Catch:{ all -> 0x0234 }
        goto L_0x0101;
    L_0x00e1:
        r2 = "gcmProjectNumber";
        r5 = com.appsflyer.i.fF();	 Catch:{ all -> 0x0234 }
        r2 = r5.getString(r2);	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x0101;
    L_0x00ed:
        r2 = "GCM Project number exists. Fetching token and sending to AF servers";
        com.appsflyer.AFLogger.am(r2);	 Catch:{ all -> 0x0234 }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0234 }
        r2.<init>(r6);	 Catch:{ all -> 0x0234 }
        r5 = new com.appsflyer.ag$a;	 Catch:{ all -> 0x0234 }
        r5.<init>(r2);	 Catch:{ all -> 0x0234 }
        r2 = new java.lang.Void[r8];	 Catch:{ all -> 0x0234 }
        r5.execute(r2);	 Catch:{ all -> 0x0234 }
    L_0x0101:
        r2 = r1.pK;	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x0107;
    L_0x0105:
        r1.pK = r10;	 Catch:{ all -> 0x0234 }
    L_0x0107:
        if (r4 == 0) goto L_0x0110;
    L_0x0109:
        r2 = com.appsflyer.a.a.fP();	 Catch:{ all -> 0x0234 }
        r2.a(r4, r6);	 Catch:{ all -> 0x0234 }
    L_0x0110:
        r2 = r24.get();	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x014f;
    L_0x0116:
        if (r4 != 0) goto L_0x014f;
    L_0x0118:
        r2 = "sentSuccessfully";
        r4 = "true";
        a(r6, r2, r4);	 Catch:{ all -> 0x0234 }
        r2 = r1.pC;	 Catch:{ all -> 0x0234 }
        if (r2 != 0) goto L_0x014f;
    L_0x0123:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0234 }
        r14 = r1.pD;	 Catch:{ all -> 0x0234 }
        r2 = 0;
        r16 = r4 - r14;
        r4 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r2 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0133;
    L_0x0132:
        goto L_0x014f;
    L_0x0133:
        r2 = r1.pE;	 Catch:{ all -> 0x0234 }
        if (r2 != 0) goto L_0x014f;
    L_0x0137:
        r2 = com.appsflyer.a.fp();	 Catch:{ all -> 0x0234 }
        r2 = r2.fr();	 Catch:{ all -> 0x0234 }
        r1.pE = r2;	 Catch:{ all -> 0x0234 }
        r2 = new com.appsflyer.h$c;	 Catch:{ all -> 0x0234 }
        r2.<init>(r6);	 Catch:{ all -> 0x0234 }
        r4 = r1.pE;	 Catch:{ all -> 0x0234 }
        r14 = 1;
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x0234 }
        a(r4, r2, r14, r5);	 Catch:{ all -> 0x0234 }
    L_0x014f:
        r2 = com.appsflyer.q.az(r12);	 Catch:{ all -> 0x0234 }
        r4 = "send_background";
        r2 = r2.optBoolean(r4, r8);	 Catch:{ all -> 0x0234 }
        r1.pS = r2;	 Catch:{ all -> 0x0234 }
        goto L_0x016f;
    L_0x015c:
        r4 = pz;	 Catch:{ all -> 0x0234 }
        if (r4 == 0) goto L_0x016f;
    L_0x0160:
        r4 = "Failure: ";
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0234 }
        r2 = r4.concat(r2);	 Catch:{ all -> 0x0234 }
        r4 = pz;	 Catch:{ all -> 0x0234 }
        r4.ax(r2);	 Catch:{ all -> 0x0234 }
    L_0x016f:
        r2 = "appsflyerConversionDataRequestRetries";
        r2 = r13.getInt(r2, r8);	 Catch:{ all -> 0x0234 }
        r4 = "appsflyerConversionDataCacheExpiration";
        r14 = 0;
        r4 = r13.getLong(r4, r14);	 Catch:{ all -> 0x0234 }
        r12 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r12 == 0) goto L_0x019b;
    L_0x0181:
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0234 }
        r12 = 0;
        r18 = r16 - r4;
        r4 = 5184000000; // 0x134fd9000 float:4.7229696E-7 double:2.561236308E-314;
        r12 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1));
        if (r12 <= 0) goto L_0x019b;
    L_0x0191:
        r4 = "attributionId";
        a(r6, r4, r10);	 Catch:{ all -> 0x0234 }
        r4 = "appsflyerConversionDataCacheExpiration";
        a(r6, r4, r14);	 Catch:{ all -> 0x0234 }
    L_0x019b:
        r4 = "attributionId";
        r4 = r13.getString(r4, r10);	 Catch:{ all -> 0x0234 }
        if (r4 != 0) goto L_0x01c7;
    L_0x01a3:
        if (r3 == 0) goto L_0x01c7;
    L_0x01a5:
        if (r9 == 0) goto L_0x01c7;
    L_0x01a7:
        r4 = px;	 Catch:{ all -> 0x0234 }
        if (r4 == 0) goto L_0x01c7;
    L_0x01ab:
        r4 = 5;
        if (r2 > r4) goto L_0x01c7;
    L_0x01ae:
        r2 = com.appsflyer.a.fp();	 Catch:{ all -> 0x0234 }
        r2 = r2.fr();	 Catch:{ all -> 0x0234 }
        r4 = new com.appsflyer.h$b;	 Catch:{ all -> 0x0234 }
        r5 = r6.getApplicationContext();	 Catch:{ all -> 0x0234 }
        r4.<init>(r5, r3, r2);	 Catch:{ all -> 0x0234 }
        r5 = 10;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x0234 }
        a(r2, r4, r5, r3);	 Catch:{ all -> 0x0234 }
        goto L_0x0215;
    L_0x01c7:
        if (r3 != 0) goto L_0x01cf;
    L_0x01c9:
        r2 = "AppsFlyer dev key is missing.";
        com.appsflyer.AFLogger.ao(r2);	 Catch:{ all -> 0x0234 }
        goto L_0x0215;
    L_0x01cf:
        if (r9 == 0) goto L_0x0215;
    L_0x01d1:
        r2 = px;	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x0215;
    L_0x01d5:
        r2 = "attributionId";
        r2 = r13.getString(r2, r10);	 Catch:{ all -> 0x0234 }
        if (r2 == 0) goto L_0x0215;
    L_0x01dd:
        r2 = "appsFlyerCount";
        r2 = a(r13, r2, r8);	 Catch:{ all -> 0x0234 }
        if (r2 <= r7) goto L_0x0215;
    L_0x01e5:
        r2 = o(r6);	 Catch:{ l -> 0x020c }
        if (r2 == 0) goto L_0x0215;
    L_0x01eb:
        r3 = "is_first_launch";
        r3 = r2.containsKey(r3);	 Catch:{ Throwable -> 0x0202 }
        if (r3 != 0) goto L_0x01fc;
    L_0x01f3:
        r3 = "is_first_launch";
        r4 = java.lang.Boolean.toString(r8);	 Catch:{ Throwable -> 0x0202 }
        r2.put(r3, r4);	 Catch:{ Throwable -> 0x0202 }
    L_0x01fc:
        r3 = px;	 Catch:{ Throwable -> 0x0202 }
        r3.e(r2);	 Catch:{ Throwable -> 0x0202 }
        goto L_0x0215;
    L_0x0202:
        r0 = move-exception;
        r2 = r0;
        r3 = r2.getLocalizedMessage();	 Catch:{ l -> 0x020c }
        com.appsflyer.AFLogger.a(r3, r2);	 Catch:{ l -> 0x020c }
        goto L_0x0215;
    L_0x020c:
        r0 = move-exception;
        r2 = r0;
        r3 = r2.getMessage();	 Catch:{ all -> 0x0234 }
        com.appsflyer.AFLogger.a(r3, r2);	 Catch:{ all -> 0x0234 }
    L_0x0215:
        if (r11 == 0) goto L_0x021b;
    L_0x0217:
        r11.disconnect();
        return;
    L_0x021b:
        return;
    L_0x021c:
        r0 = move-exception;
        r2 = r0;
        r10 = r12;
        goto L_0x0222;
    L_0x0220:
        r0 = move-exception;
        r2 = r0;
    L_0x0222:
        if (r10 == 0) goto L_0x0228;
    L_0x0224:
        r10.close();	 Catch:{ all -> 0x0234 }
        goto L_0x0233;
    L_0x0228:
        r3 = pz;	 Catch:{ all -> 0x0234 }
        if (r3 == 0) goto L_0x0233;
    L_0x022c:
        r3 = pz;	 Catch:{ all -> 0x0234 }
        r4 = "No Connectivity";
        r3.ax(r4);	 Catch:{ all -> 0x0234 }
    L_0x0233:
        throw r2;	 Catch:{ all -> 0x0234 }
    L_0x0234:
        r0 = move-exception;
        r2 = r0;
        goto L_0x023a;
    L_0x0237:
        r0 = move-exception;
        r2 = r0;
        r11 = r10;
    L_0x023a:
        if (r11 == 0) goto L_0x023f;
    L_0x023c:
        r11.disconnect();
    L_0x023f:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.a(java.net.URL, java.lang.String, java.lang.String, java.lang.ref.WeakReference, java.lang.String, boolean):void");
    }

    private static void a(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!(scheduledExecutorService.isShutdown() || scheduledExecutorService.isTerminated())) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (Throwable e) {
                AFLogger.a("scheduleJob failed with RejectedExecutionException Exception", e);
                return;
            } catch (Throwable e2) {
                AFLogger.a("scheduleJob failed with Exception", e2);
                return;
            }
        }
        AFLogger.ao("scheduler is null, shut downed or terminated");
    }

    public boolean fB() {
        return this.pT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A:{SYNTHETIC, Splitter: B:28:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A:{SYNTHETIC, Splitter: B:28:0x005a} */
    /* JADX WARNING: Missing block: B:30:0x005d, code:
            if (r3 != null) goto L_0x002c;
     */
    @android.support.annotation.NonNull
    static java.lang.String a(java.net.HttpURLConnection r7) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 0;
        r2 = r7.getErrorStream();	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        if (r2 != 0) goto L_0x0010;
    L_0x000c:
        r2 = r7.getInputStream();	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
    L_0x0010:
        r3 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x003d, all -> 0x003a }
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0038 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0038 }
    L_0x001a:
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x0033, all -> 0x0030 }
        if (r1 == 0) goto L_0x0029;
    L_0x0020:
        r0.append(r1);	 Catch:{ Throwable -> 0x0033, all -> 0x0030 }
        r1 = 10;
        r0.append(r1);	 Catch:{ Throwable -> 0x0033, all -> 0x0030 }
        goto L_0x001a;
    L_0x0029:
        r2.close();	 Catch:{ Throwable -> 0x0060 }
    L_0x002c:
        r3.close();	 Catch:{ Throwable -> 0x0060 }
        goto L_0x0060;
    L_0x0030:
        r7 = move-exception;
        r1 = r2;
        goto L_0x0084;
    L_0x0033:
        r1 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x003f;
    L_0x0038:
        r2 = move-exception;
        goto L_0x003f;
    L_0x003a:
        r7 = move-exception;
        r3 = r1;
        goto L_0x0084;
    L_0x003d:
        r2 = move-exception;
        r3 = r1;
    L_0x003f:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083 }
        r5 = "Could not read connection response from: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0083 }
        r7 = r7.getURL();	 Catch:{ all -> 0x0083 }
        r7 = r7.toString();	 Catch:{ all -> 0x0083 }
        r4.append(r7);	 Catch:{ all -> 0x0083 }
        r7 = r4.toString();	 Catch:{ all -> 0x0083 }
        com.appsflyer.AFLogger.a(r7, r2);	 Catch:{ all -> 0x0083 }
        if (r1 == 0) goto L_0x005d;
    L_0x005a:
        r1.close();	 Catch:{ Throwable -> 0x0060 }
    L_0x005d:
        if (r3 == 0) goto L_0x0060;
    L_0x005f:
        goto L_0x002c;
    L_0x0060:
        r7 = r0.toString();
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x006a }
        r0.<init>(r7);	 Catch:{ JSONException -> 0x006a }
        return r7;
    L_0x006a:
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "string_response";
        r0.put(r1, r7);	 Catch:{ JSONException -> 0x0079 }
        r7 = r0.toString();	 Catch:{ JSONException -> 0x0079 }
        return r7;
    L_0x0079:
        r7 = new org.json.JSONObject;
        r7.<init>();
        r7 = r7.toString();
        return r7;
    L_0x0083:
        r7 = move-exception;
    L_0x0084:
        if (r1 == 0) goto L_0x0089;
    L_0x0086:
        r1.close();	 Catch:{ Throwable -> 0x008e }
    L_0x0089:
        if (r3 == 0) goto L_0x008e;
    L_0x008b:
        r3.close();	 Catch:{ Throwable -> 0x008e }
    L_0x008e:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.h.a(java.net.HttpURLConnection):java.lang.String");
    }

    private static float v(Context context) {
        float f;
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(com.google.firebase.analytics.FirebaseAnalytics.b.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            f = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            return f;
        } catch (Throwable th) {
            AFLogger.a(th.getMessage(), th);
            f = 1.0f;
        }
    }

    public String getHost() {
        String string = i.fF().getString("custom_host");
        return string != null ? string : "appsflyer.com";
    }

    private static void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
        edit.putString(str, str2);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private static void b(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
        edit.putInt(str, i);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private static void a(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
        edit.putLong(str, j);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
