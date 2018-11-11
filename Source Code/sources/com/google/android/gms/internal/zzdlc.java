package com.google.android.gms.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.dynamite.DynamiteModule;

@Hide
public abstract class zzdlc<T> {
    private final Context mContext;
    private final Object mLock = new Object();
    private final String mTag;
    private boolean zzlhu = false;
    private T zzlhv;

    public zzdlc(Context context, String str) {
        this.mContext = context;
        this.mTag = str;
    }

    public final boolean isOperational() {
        return zzblo() != null;
    }

    protected abstract T zza(DynamiteModule dynamiteModule, Context context);

    protected abstract void zzbll();

    public final void zzbln() {
        synchronized (this.mLock) {
            if (this.zzlhv == null) {
                return;
            }
            try {
                zzbll();
            } catch (Throwable e) {
                Log.e(this.mTag, "Could not finalize native handle", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A:{Splitter: B:8:0x000b, ExcHandler: com.google.android.gms.dynamite.DynamiteModule.zzc (r1_5 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:10:0x001e, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            android.util.Log.e(r4.mTag, "Error creating remote native handle", r1);
     */
    protected final T zzblo() {
        /*
        r4 = this;
        r0 = r4.mLock;
        monitor-enter(r0);
        r1 = r4.zzlhv;	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x000b;
    L_0x0007:
        r1 = r4.zzlhv;	 Catch:{ all -> 0x004c }
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        return r1;
    L_0x000b:
        r1 = r4.mContext;	 Catch:{ zzc -> 0x001e, zzc -> 0x001e }
        r2 = com.google.android.gms.dynamite.DynamiteModule.zzhdm;	 Catch:{ zzc -> 0x001e, zzc -> 0x001e }
        r3 = "com.google.android.gms.vision.dynamite";
        r1 = com.google.android.gms.dynamite.DynamiteModule.zza(r1, r2, r3);	 Catch:{ zzc -> 0x001e, zzc -> 0x001e }
        r2 = r4.mContext;	 Catch:{ zzc -> 0x001e, zzc -> 0x001e }
        r1 = r4.zza(r1, r2);	 Catch:{ zzc -> 0x001e, zzc -> 0x001e }
        r4.zzlhv = r1;	 Catch:{ zzc -> 0x001e, zzc -> 0x001e }
        goto L_0x0026;
    L_0x001e:
        r1 = move-exception;
        r2 = r4.mTag;	 Catch:{ all -> 0x004c }
        r3 = "Error creating remote native handle";
        android.util.Log.e(r2, r3, r1);	 Catch:{ all -> 0x004c }
    L_0x0026:
        r1 = r4.zzlhu;	 Catch:{ all -> 0x004c }
        if (r1 != 0) goto L_0x0039;
    L_0x002a:
        r1 = r4.zzlhv;	 Catch:{ all -> 0x004c }
        if (r1 != 0) goto L_0x0039;
    L_0x002e:
        r1 = r4.mTag;	 Catch:{ all -> 0x004c }
        r2 = "Native handle not yet available. Reverting to no-op handle.";
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x004c }
        r1 = 1;
        r4.zzlhu = r1;	 Catch:{ all -> 0x004c }
        goto L_0x0048;
    L_0x0039:
        r1 = r4.zzlhu;	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x0048;
    L_0x003d:
        r1 = r4.zzlhv;	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x0048;
    L_0x0041:
        r1 = r4.mTag;	 Catch:{ all -> 0x004c }
        r2 = "Native handle is now available.";
        android.util.Log.w(r1, r2);	 Catch:{ all -> 0x004c }
    L_0x0048:
        r1 = r4.zzlhv;	 Catch:{ all -> 0x004c }
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        return r1;
    L_0x004c:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdlc.zzblo():T");
    }
}
