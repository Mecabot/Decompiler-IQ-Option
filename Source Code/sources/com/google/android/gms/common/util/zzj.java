package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzj {
    private static Boolean zzgkq;
    private static Boolean zzgkr;
    private static Boolean zzgks;
    private static Boolean zzgkt;
    private static Boolean zzgku;

    /* JADX WARNING: Missing block: B:20:0x003c, code:
            if (zzgkr.booleanValue() != false) goto L_0x003e;
     */
    public static boolean zza(android.content.res.Resources r4) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = zzgkq;
        if (r1 != 0) goto L_0x0045;
    L_0x0008:
        r1 = r4.getConfiguration();
        r1 = r1.screenLayout;
        r1 = r1 & 15;
        r2 = 3;
        r3 = 1;
        if (r1 <= r2) goto L_0x0016;
    L_0x0014:
        r1 = 1;
        goto L_0x0017;
    L_0x0016:
        r1 = 0;
    L_0x0017:
        if (r1 != 0) goto L_0x003e;
    L_0x0019:
        r1 = zzgkr;
        if (r1 != 0) goto L_0x0036;
    L_0x001d:
        r4 = r4.getConfiguration();
        r1 = r4.screenLayout;
        r1 = r1 & 15;
        if (r1 > r2) goto L_0x002f;
    L_0x0027:
        r4 = r4.smallestScreenWidthDp;
        r1 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r4 < r1) goto L_0x002f;
    L_0x002d:
        r4 = 1;
        goto L_0x0030;
    L_0x002f:
        r4 = 0;
    L_0x0030:
        r4 = java.lang.Boolean.valueOf(r4);
        zzgkr = r4;
    L_0x0036:
        r4 = zzgkr;
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        r0 = 1;
    L_0x003f:
        r4 = java.lang.Boolean.valueOf(r0);
        zzgkq = r4;
    L_0x0045:
        r4 = zzgkq;
        r4 = r4.booleanValue();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzj.zza(android.content.res.Resources):boolean");
    }

    @TargetApi(20)
    public static boolean zzcu(Context context) {
        if (zzgks == null) {
            boolean z = zzs.zzanw() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            zzgks = Boolean.valueOf(z);
        }
        return zzgks.booleanValue();
    }

    @TargetApi(24)
    public static boolean zzcv(Context context) {
        return (!zzs.isAtLeastN() || zzcw(context)) && zzcu(context);
    }

    @TargetApi(21)
    public static boolean zzcw(Context context) {
        if (zzgkt == null) {
            boolean z = zzs.zzanx() && context.getPackageManager().hasSystemFeature("cn.google");
            zzgkt = Boolean.valueOf(z);
        }
        return zzgkt.booleanValue();
    }

    public static boolean zzcx(Context context) {
        if (zzgku == null) {
            boolean z = context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
            zzgku = Boolean.valueOf(z);
        }
        return zzgku.booleanValue();
    }
}
