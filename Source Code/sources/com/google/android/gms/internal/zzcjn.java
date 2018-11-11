package com.google.android.gms.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzcjn extends zzcli {
    private final SSLSocketFactory sslSocketFactory;

    public zzcjn(zzckj zzckj) {
        super(zzckj);
        this.sslSocketFactory = VERSION.SDK_INT < 19 ? new zzcnp() : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    @android.support.annotation.WorkerThread
    private static byte[] zzc(java.net.HttpURLConnection r5) {
        /*
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0025 }
        r1.<init>();	 Catch:{ all -> 0x0025 }
        r5 = r5.getInputStream();	 Catch:{ all -> 0x0025 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ all -> 0x0023 }
    L_0x000e:
        r2 = r5.read(r0);	 Catch:{ all -> 0x0023 }
        if (r2 <= 0) goto L_0x0019;
    L_0x0014:
        r3 = 0;
        r1.write(r0, r3, r2);	 Catch:{ all -> 0x0023 }
        goto L_0x000e;
    L_0x0019:
        r0 = r1.toByteArray();	 Catch:{ all -> 0x0023 }
        if (r5 == 0) goto L_0x0022;
    L_0x001f:
        r5.close();
    L_0x0022:
        return r0;
    L_0x0023:
        r0 = move-exception;
        goto L_0x0029;
    L_0x0025:
        r5 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
    L_0x0029:
        if (r5 == 0) goto L_0x002e;
    L_0x002b:
        r5.close();
    L_0x002e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcjn.zzc(java.net.HttpURLConnection):byte[]");
    }

    public final boolean zzaax() {
        NetworkInfo activeNetworkInfo;
        zzyk();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected final boolean zzazq() {
        return false;
    }

    @WorkerThread
    protected final HttpURLConnection zzb(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            if (this.sslSocketFactory != null && (openConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(this.sslSocketFactory);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }
}
