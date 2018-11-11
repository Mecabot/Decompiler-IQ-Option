package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.firebase.a;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
    private static final long XK = TimeUnit.HOURS.toSeconds(8);
    private static b XL;
    private static ScheduledThreadPoolExecutor XM;
    private static Map<String, FirebaseInstanceId> Xu = new ArrayMap();
    private final a XN;
    private final z XO;
    private final aa XP;
    private KeyPair XQ;
    private boolean XR = false;
    private boolean XS;

    private FirebaseInstanceId(a aVar, z zVar) {
        if (z.b(aVar) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        this.XN = aVar;
        this.XO = zVar;
        this.XP = new aa(aVar.getApplicationContext(), zVar);
        this.XS = wt();
        if (wv()) {
            wk();
        }
    }

    static void a(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (XM == null) {
                XM = new ScheduledThreadPoolExecutor(1);
            }
            XM.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    private final String c(String str, String str2, Bundle bundle) {
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", getId());
        bundle.putString("gmp_app_id", this.XN.wd().it());
        bundle.putString("gmsv", Integer.toString(this.XO.wM()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.XO.wK());
        bundle.putString("app_ver_name", this.XO.wL());
        bundle.putString("cliv", "fiid-12211000");
        Bundle J = this.XP.J(bundle);
        if (J == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        str2 = J.getString("registration_id");
        if (str2 != null) {
            return str2;
        }
        str2 = J.getString("unregistered");
        if (str2 != null) {
            return str2;
        }
        str2 = J.getString("error");
        if ("RST".equals(str2)) {
            wr();
            throw new IOException("INSTANCE_ID_RESET");
        } else if (str2 != null) {
            throw new IOException(str2);
        } else {
            str = String.valueOf(J);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 21);
            stringBuilder.append("Unexpected response: ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull a aVar) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) Xu.get(aVar.wd().it());
            if (firebaseInstanceId == null) {
                if (XL == null) {
                    XL = new b(aVar.getApplicationContext());
                }
                firebaseInstanceId = new FirebaseInstanceId(aVar, new z(aVar.getApplicationContext()));
                Xu.put(aVar.wd().it(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    private final synchronized void startSync() {
        if (!this.XR) {
            M(0);
        }
    }

    public static FirebaseInstanceId wj() {
        return getInstance(a.we());
    }

    private final void wk() {
        c wm = wm();
        if (wm == null || wm.cW(this.XO.wK()) || XL.wx() != null) {
            startSync();
        }
    }

    static b wo() {
        return XL;
    }

    static boolean wp() {
        return Log.isLoggable("FirebaseInstanceId", 3) || (VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3));
    }

    private final synchronized KeyPair wq() {
        if (this.XQ == null) {
            this.XQ = XL.cU("");
        }
        if (this.XQ == null) {
            this.XQ = XL.cS("");
        }
        return this.XQ;
    }

    private final boolean wt() {
        Context applicationContext = this.XN.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return sharedPreferences.getBoolean("auto_init", true);
        }
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                    return applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
                }
            }
        } catch (NameNotFoundException unused) {
            return wu();
        }
    }

    private final boolean wu() {
        try {
            Class.forName("com.google.firebase.messaging.a");
            return true;
        } catch (ClassNotFoundException unused) {
            Context applicationContext = this.XN.getApplicationContext();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(applicationContext.getPackageName());
            ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
            return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
        }
    }

    final synchronized void M(long j) {
        a(new d(this, this.XO, Math.min(Math.max(30, j << 1), XK)), j);
        this.XR = true;
    }

    @WorkerThread
    public String P(String str, String str2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        c f = XL.f("", str, str2);
        if (f != null && !f.cW(this.XO.wK())) {
            return f.XY;
        }
        String c = c(str, str2, new Bundle());
        if (c != null) {
            XL.a("", str, str2, c, this.XO.wK());
        }
        return c;
    }

    final synchronized void ah(boolean z) {
        this.XR = z;
    }

    @Hide
    public final synchronized void cO(String str) {
        XL.cO(str);
        startSync();
    }

    final void cP(String str) {
        c wm = wm();
        if (wm == null || wm.cW(this.XO.wK())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str3 = wm.XY;
        str2 = String.valueOf("/topics/");
        str = String.valueOf(str);
        c(str3, str.length() != 0 ? str2.concat(str) : new String(str2), bundle);
    }

    final void cQ(String str) {
        c wm = wm();
        if (wm == null || wm.cW(this.XO.wK())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", "1");
        String str3 = wm.XY;
        str2 = String.valueOf("/topics/");
        str = String.valueOf(str);
        c(str3, str.length() != 0 ? str2.concat(str) : new String(str2), bundle);
    }

    @WorkerThread
    public String getId() {
        wk();
        return z.a(wq());
    }

    @Nullable
    public String getToken() {
        c wm = wm();
        if (wm == null || wm.cW(this.XO.wK())) {
            startSync();
        }
        return wm != null ? wm.XY : null;
    }

    final a wl() {
        return this.XN;
    }

    @Nullable
    final c wm() {
        return XL.f("", z.b(this.XN), "*");
    }

    @Hide
    final String wn() {
        return P(z.b(this.XN), "*");
    }

    final synchronized void wr() {
        XL.wy();
        this.XQ = null;
        if (wv()) {
            startSync();
        }
    }

    final void ws() {
        XL.cT("");
        startSync();
    }

    @Hide
    public final synchronized boolean wv() {
        return this.XS;
    }
}
