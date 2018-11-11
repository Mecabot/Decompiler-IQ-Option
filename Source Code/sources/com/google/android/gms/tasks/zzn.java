package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzn<TResult> {
    private final Object mLock = new Object();
    private Queue<zzm<TResult>> zzlej;
    private boolean zzlek;

    zzn() {
    }

    public final void zza(@NonNull zzm<TResult> zzm) {
        synchronized (this.mLock) {
            if (this.zzlej == null) {
                this.zzlej = new ArrayDeque();
            }
            this.zzlej.add(zzm);
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0010, code:
            r1 = r2.mLock;
     */
    /* JADX WARNING: Missing block: B:10:0x0012, code:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:12:?, code:
            r0 = (com.google.android.gms.tasks.zzm) r2.zzlej.poll();
     */
    /* JADX WARNING: Missing block: B:13:0x001b, code:
            if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Missing block: B:14:0x001d, code:
            r2.zzlek = false;
     */
    /* JADX WARNING: Missing block: B:15:0x0020, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:16:0x0021, code:
            return;
     */
    /* JADX WARNING: Missing block: B:17:0x0022, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:18:0x0023, code:
            r0.onComplete(r3);
     */
    public final void zzb(@android.support.annotation.NonNull com.google.android.gms.tasks.Task<TResult> r3) {
        /*
        r2 = this;
        r0 = r2.mLock;
        monitor-enter(r0);
        r1 = r2.zzlej;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x002a;
    L_0x0007:
        r1 = r2.zzlek;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x002a;
    L_0x000c:
        r1 = 1;
        r2.zzlek = r1;	 Catch:{ all -> 0x002c }
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
    L_0x0010:
        r1 = r2.mLock;
        monitor-enter(r1);
        r0 = r2.zzlej;	 Catch:{ all -> 0x0027 }
        r0 = r0.poll();	 Catch:{ all -> 0x0027 }
        r0 = (com.google.android.gms.tasks.zzm) r0;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x0022;
    L_0x001d:
        r3 = 0;
        r2.zzlek = r3;	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        return;
    L_0x0022:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        r0.onComplete(r3);
        goto L_0x0010;
    L_0x0027:
        r3 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r3;
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        return;
    L_0x002c:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002c }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzn.zzb(com.google.android.gms.tasks.Task):void");
    }
}
