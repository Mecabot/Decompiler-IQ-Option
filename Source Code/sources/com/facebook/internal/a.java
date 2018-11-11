package com.facebook.internal;

import java.util.UUID;

/* compiled from: AppCall */
public class a {
    private static a Bx;
    private UUID By;
    private int Bz;

    public static a lu() {
        return Bx;
    }

    /* JADX WARNING: Missing block: B:13:0x0021, code:
            return null;
     */
    public static synchronized com.facebook.internal.a a(java.util.UUID r4, int r5) {
        /*
        r0 = com.facebook.internal.a.class;
        monitor-enter(r0);
        r1 = lu();	 Catch:{ all -> 0x0022 }
        r2 = 0;
        if (r1 == 0) goto L_0x0020;
    L_0x000a:
        r3 = r1.lv();	 Catch:{ all -> 0x0022 }
        r4 = r3.equals(r4);	 Catch:{ all -> 0x0022 }
        if (r4 == 0) goto L_0x0020;
    L_0x0014:
        r4 = r1.getRequestCode();	 Catch:{ all -> 0x0022 }
        if (r4 == r5) goto L_0x001b;
    L_0x001a:
        goto L_0x0020;
    L_0x001b:
        a(r2);	 Catch:{ all -> 0x0022 }
        monitor-exit(r0);
        return r1;
    L_0x0020:
        monitor-exit(r0);
        return r2;
    L_0x0022:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.a.a(java.util.UUID, int):com.facebook.internal.a");
    }

    private static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            a lu = lu();
            Bx = aVar;
            z = lu != null;
        }
        return z;
    }

    public UUID lv() {
        return this.By;
    }

    public int getRequestCode() {
        return this.Bz;
    }
}
