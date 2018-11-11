package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

public final class zzatk {
    static Object sLock = new Object();
    private static Boolean zzdud;
    static zzcyz zzeei;

    /* JADX WARNING: Missing block: B:19:?, code:
            r0.zzed("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
     */
    @android.support.annotation.RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
        r0 = com.google.android.gms.internal.zzark.zzbl(r5);
        r0 = r0.zzxy();
        if (r6 != 0) goto L_0x0010;
    L_0x000a:
        r5 = "AnalyticsReceiver called with null intent";
        r0.zzed(r5);
        return;
    L_0x0010:
        r6 = r6.getAction();
        r1 = "Local AnalyticsReceiver got";
        r0.zza(r1, r6);
        r1 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r6 = r1.equals(r6);
        if (r6 == 0) goto L_0x0069;
    L_0x0021:
        r6 = com.google.android.gms.internal.zzatl.zzbn(r5);
        r1 = new android.content.Intent;
        r2 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r1.<init>(r2);
        r2 = new android.content.ComponentName;
        r3 = "com.google.android.gms.analytics.AnalyticsService";
        r2.<init>(r5, r3);
        r1.setComponent(r2);
        r2 = "com.google.android.gms.analytics.ANALYTICS_DISPATCH";
        r1.setAction(r2);
        r2 = sLock;
        monitor-enter(r2);
        r5.startService(r1);	 Catch:{ all -> 0x0066 }
        if (r6 != 0) goto L_0x0045;
    L_0x0043:
        monitor-exit(r2);	 Catch:{ all -> 0x0066 }
        return;
    L_0x0045:
        r6 = zzeei;	 Catch:{ SecurityException -> 0x005f }
        if (r6 != 0) goto L_0x0057;
    L_0x0049:
        r6 = new com.google.android.gms.internal.zzcyz;	 Catch:{ SecurityException -> 0x005f }
        r1 = 1;
        r3 = "Analytics WakeLock";
        r6.<init>(r5, r1, r3);	 Catch:{ SecurityException -> 0x005f }
        zzeei = r6;	 Catch:{ SecurityException -> 0x005f }
        r5 = 0;
        r6.setReferenceCounted(r5);	 Catch:{ SecurityException -> 0x005f }
    L_0x0057:
        r5 = zzeei;	 Catch:{ SecurityException -> 0x005f }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5.acquire(r3);	 Catch:{ SecurityException -> 0x005f }
        goto L_0x0064;
    L_0x005f:
        r5 = "Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.";
        r0.zzed(r5);	 Catch:{ all -> 0x0066 }
    L_0x0064:
        monitor-exit(r2);	 Catch:{ all -> 0x0066 }
        return;
    L_0x0066:
        r5 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0066 }
        throw r5;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzatk.onReceive(android.content.Context, android.content.Intent):void");
    }

    @Hide
    public static boolean zzbj(Context context) {
        zzbq.checkNotNull(context);
        if (zzdud != null) {
            return zzdud.booleanValue();
        }
        boolean zzb = zzatt.zzb(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        zzdud = Boolean.valueOf(zzb);
        return zzb;
    }
}
