package com.appsflyer;

import android.content.Context;
import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

final class s {
    private String pk;
    private final Object qr;
    private long qt;

    s() {
    }

    static void z(Context context) {
        context = context.getApplicationContext();
        AFLogger.an("onBecameBackground");
        h.fA().fs();
        AFLogger.an("callStatsBackground background call");
        h.fA().a(new WeakReference(context));
        ah ge = ah.ge();
        if (ge.gi()) {
            ge.fz();
            if (context != null) {
                ah.a(context.getPackageName(), context.getPackageManager());
            }
            ge.ft();
        } else {
            AFLogger.am("RD status is OFF");
        }
        a.fp().fs();
    }

    s(long j, String str) {
        this.qr = new Object();
        this.qt = 0;
        this.pk = "";
        this.qt = j;
        this.pk = str;
    }

    s(String str) {
        this(System.currentTimeMillis(), str);
    }

    @NonNull
    static s aB(String str) {
        if (str == null) {
            return new s(0, "");
        }
        String[] split = str.split(",");
        if (split.length < 2) {
            return new s(0, "");
        }
        return new s(Long.parseLong(split[0]), split[1]);
    }

    final boolean a(s sVar) {
        return a(sVar.qt, sVar.pk);
    }

    /* JADX WARNING: Missing block: B:19:0x0029, code:
            return false;
     */
    private boolean a(long r8, java.lang.String r10) {
        /*
        r7 = this;
        r0 = r7.qr;
        monitor-enter(r0);
        r1 = 0;
        if (r10 == 0) goto L_0x0028;
    L_0x0006:
        r2 = r7.pk;	 Catch:{ all -> 0x0025 }
        r2 = r10.equals(r2);	 Catch:{ all -> 0x0025 }
        if (r2 != 0) goto L_0x0028;
    L_0x000e:
        r2 = r7.qt;	 Catch:{ all -> 0x0025 }
        r4 = 0;
        r4 = r8 - r2;
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        r2 = 1;
        if (r6 <= 0) goto L_0x001c;
    L_0x001a:
        r3 = 1;
        goto L_0x001d;
    L_0x001c:
        r3 = 0;
    L_0x001d:
        if (r3 == 0) goto L_0x0028;
    L_0x001f:
        r7.qt = r8;	 Catch:{ all -> 0x0025 }
        r7.pk = r10;	 Catch:{ all -> 0x0025 }
        monitor-exit(r0);	 Catch:{ all -> 0x0025 }
        return r2;
    L_0x0025:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
    L_0x0028:
        monitor-exit(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.s.a(long, java.lang.String):boolean");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.qt);
        stringBuilder.append(",");
        stringBuilder.append(this.pk);
        return stringBuilder.toString();
    }

    final String fv() {
        return this.pk;
    }
}
