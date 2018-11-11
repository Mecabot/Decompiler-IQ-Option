package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;

final class zzej extends zzbr {
    private static final String ID = zzbh.RANDOM.toString();
    private static final String zzkrt = zzbi.MIN.toString();
    private static final String zzkru = zzbi.MAX.toString();

    public zzej() {
        super(ID, new String[0]);
    }

    public final boolean zzbfh() {
        return false;
    }

    /* JADX WARNING: Missing block: B:12:0x003e, code:
            if (r0 <= r2) goto L_0x0048;
     */
    public final com.google.android.gms.internal.zzbt zzx(java.util.Map<java.lang.String, com.google.android.gms.internal.zzbt> r7) {
        /*
        r6 = this;
        r0 = zzkrt;
        r0 = r7.get(r0);
        r0 = (com.google.android.gms.internal.zzbt) r0;
        r1 = zzkru;
        r7 = r7.get(r1);
        r7 = (com.google.android.gms.internal.zzbt) r7;
        if (r0 == 0) goto L_0x0041;
    L_0x0012:
        r1 = com.google.android.gms.tagmanager.zzgk.zzbil();
        if (r0 == r1) goto L_0x0041;
    L_0x0018:
        if (r7 == 0) goto L_0x0041;
    L_0x001a:
        r1 = com.google.android.gms.tagmanager.zzgk.zzbil();
        if (r7 == r1) goto L_0x0041;
    L_0x0020:
        r0 = com.google.android.gms.tagmanager.zzgk.zze(r0);
        r7 = com.google.android.gms.tagmanager.zzgk.zze(r7);
        r1 = com.google.android.gms.tagmanager.zzgk.zzbij();
        if (r0 == r1) goto L_0x0041;
    L_0x002e:
        r1 = com.google.android.gms.tagmanager.zzgk.zzbij();
        if (r7 == r1) goto L_0x0041;
    L_0x0034:
        r0 = r0.doubleValue();
        r2 = r7.doubleValue();
        r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r7 > 0) goto L_0x0041;
    L_0x0040:
        goto L_0x0048;
    L_0x0041:
        r0 = 0;
        r2 = 4746794007244308480; // 0x41dfffffffc00000 float:NaN double:2.147483647E9;
    L_0x0048:
        r4 = java.lang.Math.random();
        r2 = r2 - r0;
        r4 = r4 * r2;
        r4 = r4 + r0;
        r0 = java.lang.Math.round(r4);
        r7 = java.lang.Long.valueOf(r0);
        r7 = com.google.android.gms.tagmanager.zzgk.zzam(r7);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzej.zzx(java.util.Map):com.google.android.gms.internal.zzbt");
    }
}
