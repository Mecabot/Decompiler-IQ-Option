package com.a.b;

import android.content.Context;

/* compiled from: AssetsZoneRulesInitializer */
final class b extends org.threeten.bp.zone.b {
    private final Context context;

    b(Context context) {
        this.context = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A:{SYNTHETIC, Splitter: B:20:0x0032} */
    protected void aOC() {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.context;	 Catch:{ IOException -> 0x0027 }
        r1 = r1.getAssets();	 Catch:{ IOException -> 0x0027 }
        r2 = "org/threeten/bp/TZDB.dat";
        r1 = r1.open(r2);	 Catch:{ IOException -> 0x0027 }
        r0 = new org.threeten.bp.zone.a;	 Catch:{ IOException -> 0x0020, all -> 0x001b }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0020, all -> 0x001b }
        if (r1 == 0) goto L_0x0017;
    L_0x0014:
        r1.close();	 Catch:{ IOException -> 0x0017 }
    L_0x0017:
        org.threeten.bp.zone.c.a(r0);
        return;
    L_0x001b:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0030;
    L_0x0020:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0028;
    L_0x0025:
        r1 = move-exception;
        goto L_0x0030;
    L_0x0027:
        r1 = move-exception;
    L_0x0028:
        r2 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0025 }
        r3 = "TZDB.dat missing from assets.";
        r2.<init>(r3, r1);	 Catch:{ all -> 0x0025 }
        throw r2;	 Catch:{ all -> 0x0025 }
    L_0x0030:
        if (r0 == 0) goto L_0x0035;
    L_0x0032:
        r0.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0035:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.b.b.aOC():void");
    }
}
