package com.google.firebase.iid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

final class d implements Runnable {
    private final z XO;
    private final long XZ;
    private final WakeLock Ya = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId Yb;

    d(FirebaseInstanceId firebaseInstanceId, z zVar, long j) {
        this.Yb = firebaseInstanceId;
        this.XO = zVar;
        this.XZ = j;
        this.Ya.setReferenceCounted(false);
    }

    /* JADX WARNING: Missing block: B:19:0x0044, code:
            android.util.Log.d(r7, r2);
     */
    /* JADX WARNING: Missing block: B:20:0x0047, code:
            return true;
     */
    private final boolean cX(java.lang.String r7) {
        /*
        r6 = this;
        r0 = "!";
        r7 = r7.split(r0);
        r0 = r7.length;
        r1 = 1;
        r2 = 2;
        if (r0 != r2) goto L_0x0079;
    L_0x000b:
        r0 = 0;
        r2 = r7[r0];
        r7 = r7[r1];
        r3 = -1;
        r4 = r2.hashCode();	 Catch:{ IOException -> 0x0058 }
        r5 = 83;
        if (r4 == r5) goto L_0x0028;
    L_0x0019:
        r5 = 85;
        if (r4 == r5) goto L_0x001e;
    L_0x001d:
        goto L_0x0031;
    L_0x001e:
        r4 = "U";
        r2 = r2.equals(r4);	 Catch:{ IOException -> 0x0058 }
        if (r2 == 0) goto L_0x0031;
    L_0x0026:
        r3 = 1;
        goto L_0x0031;
    L_0x0028:
        r4 = "S";
        r2 = r2.equals(r4);	 Catch:{ IOException -> 0x0058 }
        if (r2 == 0) goto L_0x0031;
    L_0x0030:
        r3 = 0;
    L_0x0031:
        switch(r3) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0035;
            default: goto L_0x0034;
        };	 Catch:{ IOException -> 0x0058 }
    L_0x0034:
        return r1;
    L_0x0035:
        r2 = r6.Yb;	 Catch:{ IOException -> 0x0058 }
        r2.cQ(r7);	 Catch:{ IOException -> 0x0058 }
        r7 = com.google.firebase.iid.FirebaseInstanceId.wp();	 Catch:{ IOException -> 0x0058 }
        if (r7 == 0) goto L_0x0079;
    L_0x0040:
        r7 = "FirebaseInstanceId";
        r2 = "unsubscribe operation succeeded";
    L_0x0044:
        android.util.Log.d(r7, r2);	 Catch:{ IOException -> 0x0058 }
        return r1;
    L_0x0048:
        r2 = r6.Yb;	 Catch:{ IOException -> 0x0058 }
        r2.cP(r7);	 Catch:{ IOException -> 0x0058 }
        r7 = com.google.firebase.iid.FirebaseInstanceId.wp();	 Catch:{ IOException -> 0x0058 }
        if (r7 == 0) goto L_0x0079;
    L_0x0053:
        r7 = "FirebaseInstanceId";
        r2 = "subscribe operation succeeded";
        goto L_0x0044;
    L_0x0058:
        r7 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Topic sync failed: ";
        r7 = r7.getMessage();
        r7 = java.lang.String.valueOf(r7);
        r3 = r7.length();
        if (r3 == 0) goto L_0x0070;
    L_0x006b:
        r7 = r2.concat(r7);
        goto L_0x0075;
    L_0x0070:
        r7 = new java.lang.String;
        r7.<init>(r2);
    L_0x0075:
        android.util.Log.e(r1, r7);
        return r0;
    L_0x0079:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.d.cX(java.lang.String):boolean");
    }

    /* JADX WARNING: Missing block: B:10:0x001c, code:
            if (cX(r1) != false) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:12:0x001f, code:
            return false;
     */
    private final boolean wA() {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.Yb;
        monitor-enter(r0);
        r1 = com.google.firebase.iid.FirebaseInstanceId.wo();	 Catch:{ all -> 0x0028 }
        r1 = r1.wx();	 Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0017;
    L_0x000d:
        r1 = "FirebaseInstanceId";
        r2 = "topic sync succeeded";
        android.util.Log.d(r1, r2);	 Catch:{ all -> 0x0028 }
        r1 = 1;
        monitor-exit(r0);	 Catch:{ all -> 0x0028 }
        return r1;
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x0028 }
        r0 = r3.cX(r1);
        if (r0 != 0) goto L_0x0020;
    L_0x001e:
        r0 = 0;
        return r0;
    L_0x0020:
        r0 = com.google.firebase.iid.FirebaseInstanceId.wo();
        r0.cR(r1);
        goto L_0x0000;
    L_0x0028:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0028 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.d.wA():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A:{Splitter: B:6:0x0017, ExcHandler: java.io.IOException (r0_6 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing block: B:20:0x0063, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:21:0x0064, code:
            r1 = "FirebaseInstanceId";
            r3 = "Token retrieval failed: ";
            r0 = java.lang.String.valueOf(r0.getMessage());
     */
    /* JADX WARNING: Missing block: B:22:0x0074, code:
            if (r0.length() != 0) goto L_0x0076;
     */
    /* JADX WARNING: Missing block: B:23:0x0076, code:
            r0 = r3.concat(r0);
     */
    /* JADX WARNING: Missing block: B:24:0x007b, code:
            r0 = new java.lang.String(r3);
     */
    /* JADX WARNING: Missing block: B:25:0x0080, code:
            android.util.Log.e(r1, r0);
     */
    /* JADX WARNING: Missing block: B:26:0x0083, code:
            return false;
     */
    private final boolean wz() {
        /*
        r6 = this;
        r0 = r6.Yb;
        r0 = r0.wm();
        r1 = 1;
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r2 = r6.XO;
        r2 = r2.wK();
        r2 = r0.cW(r2);
        if (r2 != 0) goto L_0x0016;
    L_0x0015:
        return r1;
    L_0x0016:
        r2 = 0;
        r3 = r6.Yb;	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r3 = r3.wn();	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        if (r3 != 0) goto L_0x0027;
    L_0x001f:
        r0 = "FirebaseInstanceId";
        r1 = "Token retrieval failed: null";
        android.util.Log.e(r0, r1);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        return r2;
    L_0x0027:
        r4 = "FirebaseInstanceId";
        r5 = 3;
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        if (r4 == 0) goto L_0x0037;
    L_0x0030:
        r4 = "FirebaseInstanceId";
        r5 = "Token successfully retrieved";
        android.util.Log.d(r4, r5);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
    L_0x0037:
        if (r0 == 0) goto L_0x0043;
    L_0x0039:
        if (r0 == 0) goto L_0x0062;
    L_0x003b:
        r0 = r0.XY;	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r0 = r3.equals(r0);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        if (r0 != 0) goto L_0x0062;
    L_0x0043:
        r0 = r6.getContext();	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r3 = new android.content.Intent;	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r4 = "com.google.firebase.iid.TOKEN_REFRESH";
        r3.<init>(r4);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r4 = new android.content.Intent;	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r5 = "com.google.firebase.INSTANCE_ID_EVENT";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r5 = com.google.firebase.iid.FirebaseInstanceIdReceiver.class;
        r4.setClass(r0, r5);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r5 = "wrapped_intent";
        r4.putExtra(r5, r3);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
        r0.sendBroadcast(r4);	 Catch:{ IOException -> 0x0063, IOException -> 0x0063 }
    L_0x0062:
        return r1;
    L_0x0063:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r3 = "Token retrieval failed: ";
        r0 = r0.getMessage();
        r0 = java.lang.String.valueOf(r0);
        r4 = r0.length();
        if (r4 == 0) goto L_0x007b;
    L_0x0076:
        r0 = r3.concat(r0);
        goto L_0x0080;
    L_0x007b:
        r0 = new java.lang.String;
        r0.<init>(r3);
    L_0x0080:
        android.util.Log.e(r1, r0);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.d.wz():boolean");
    }

    final Context getContext() {
        return this.Yb.wl().getApplicationContext();
    }

    public final void run() {
        this.Ya.acquire();
        try {
            FirebaseInstanceId firebaseInstanceId;
            boolean z = true;
            this.Yb.ah(true);
            if (this.XO.wJ() == 0) {
                z = false;
            }
            if (z) {
                if (!wB()) {
                    new e(this).wC();
                } else if (wz() && wA()) {
                    firebaseInstanceId = this.Yb;
                } else {
                    this.Yb.M(this.XZ);
                }
                this.Ya.release();
            }
            firebaseInstanceId = this.Yb;
            firebaseInstanceId.ah(false);
            this.Ya.release();
        } catch (Throwable th) {
            this.Ya.release();
        }
    }

    final boolean wB() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
