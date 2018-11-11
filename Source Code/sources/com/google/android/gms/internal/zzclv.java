package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzclv implements Callable<String> {
    private /* synthetic */ zzclk zzjpy;

    zzclv(zzclk zzclk) {
        this.zzjpy = zzclk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    public final /* synthetic */ java.lang.Object call() {
        /*
        r10 = this;
        r0 = r10.zzjpy;
        r0 = r0.zzayq();
        r0 = r0.zzbbf();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r10.zzjpy;
        r0 = r0.zzayd();
        r1 = r0.zzayo();
        r1 = r1.zzbbk();
        r2 = 0;
        if (r1 == 0) goto L_0x002c;
    L_0x001e:
        r0 = r0.zzayp();
        r0 = r0.zzbau();
        r1 = "Cannot retrieve app instance id from analytics worker thread";
    L_0x0028:
        r0.log(r1);
        goto L_0x0068;
    L_0x002c:
        r0.zzayo();
        r1 = com.google.android.gms.internal.zzcke.zzas();
        if (r1 == 0) goto L_0x0040;
    L_0x0035:
        r0 = r0.zzayp();
        r0 = r0.zzbau();
        r1 = "Cannot retrieve app instance id from main thread";
        goto L_0x0028;
    L_0x0040:
        r1 = r0.zzxx();
        r1 = r1.elapsedRealtime();
        r3 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r5 = r0.zzbd(r3);
        r6 = r0.zzxx();
        r6 = r6.elapsedRealtime();
        r8 = r6 - r1;
        if (r5 != 0) goto L_0x0067;
    L_0x005b:
        r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x0067;
    L_0x005f:
        r1 = r3 - r8;
        r0 = r0.zzbd(r1);
        r2 = r0;
        goto L_0x0068;
    L_0x0067:
        r2 = r5;
    L_0x0068:
        if (r2 != 0) goto L_0x0070;
    L_0x006a:
        r0 = new java.util.concurrent.TimeoutException;
        r0.<init>();
        throw r0;
    L_0x0070:
        r0 = r10.zzjpy;
        r0 = r0.zzayq();
        r0.zzjx(r2);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclv.call():java.lang.Object");
    }
}
