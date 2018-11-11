package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzccl {
    private boolean zzarf = false;
    private zzccm zzhqe = null;

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028 A:{Splitter: B:6:0x0007, ExcHandler: com.google.android.gms.dynamite.DynamiteModule.zzc (r3_3 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:8:0x0028, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:10:?, code:
            android.util.Log.w("FlagValueProvider", "Failed to initialize flags module.", r3);
     */
    /* JADX WARNING: Missing block: B:12:0x0031, code:
            return;
     */
    public final void initialize(android.content.Context r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.zzarf;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0007:
        r0 = com.google.android.gms.dynamite.DynamiteModule.zzhdn;	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r1 = "com.google.android.gms.flags";
        r0 = com.google.android.gms.dynamite.DynamiteModule.zza(r3, r0, r1);	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r1 = "com.google.android.gms.flags.impl.FlagProviderImpl";
        r0 = r0.zzhk(r1);	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r0 = com.google.android.gms.internal.zzccn.asInterface(r0);	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r2.zzhqe = r0;	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r0 = r2.zzhqe;	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r3 = com.google.android.gms.dynamic.zzn.zzz(r3);	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r0.init(r3);	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        r3 = 1;
        r2.zzarf = r3;	 Catch:{ zzc -> 0x0028, zzc -> 0x0028 }
        goto L_0x0030;
    L_0x0028:
        r3 = move-exception;
        r0 = "FlagValueProvider";
        r1 = "Failed to initialize flags module.";
        android.util.Log.w(r0, r1, r3);	 Catch:{ all -> 0x0032 }
    L_0x0030:
        monitor-exit(r2);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0032:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0032 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzccl.initialize(android.content.Context):void");
    }

    public final <T> T zzb(zzcce<T> zzcce) {
        synchronized (this) {
            if (this.zzarf) {
                return zzcce.zza(this.zzhqe);
            }
            T zzje = zzcce.zzje();
            return zzje;
        }
    }
}
