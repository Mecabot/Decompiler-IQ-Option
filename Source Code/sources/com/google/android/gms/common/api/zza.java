package com.google.android.gms.common.api;

final class zza implements com.google.android.gms.common.api.PendingResult.zza {
    private /* synthetic */ Batch zzfsj;

    zza(Batch batch) {
        this.zzfsj = batch;
    }

    /* JADX WARNING: Missing block: B:24:0x0067, code:
            return;
     */
    public final void zzr(com.google.android.gms.common.api.Status r5) {
        /*
        r4 = this;
        r0 = r4.zzfsj;
        r0 = r0.mLock;
        monitor-enter(r0);
        r1 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r1 = r1.isCanceled();	 Catch:{ all -> 0x0068 }
        if (r1 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r0);	 Catch:{ all -> 0x0068 }
        return;
    L_0x0011:
        r1 = r5.isCanceled();	 Catch:{ all -> 0x0068 }
        r2 = 1;
        if (r1 == 0) goto L_0x001e;
    L_0x0018:
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r5.zzfsh = true;	 Catch:{ all -> 0x0068 }
        goto L_0x0029;
    L_0x001e:
        r5 = r5.isSuccess();	 Catch:{ all -> 0x0068 }
        if (r5 != 0) goto L_0x0029;
    L_0x0024:
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r5.zzfsg = true;	 Catch:{ all -> 0x0068 }
    L_0x0029:
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r5.zzfsf = r5.zzfsf - 1;	 Catch:{ all -> 0x0068 }
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r5 = r5.zzfsf;	 Catch:{ all -> 0x0068 }
        if (r5 != 0) goto L_0x0066;
    L_0x0036:
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r5 = r5.zzfsh;	 Catch:{ all -> 0x0068 }
        if (r5 == 0) goto L_0x0044;
    L_0x003e:
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        super.zze();	 Catch:{ all -> 0x0068 }
        goto L_0x0066;
    L_0x0044:
        r5 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r5 = r5.zzfsg;	 Catch:{ all -> 0x0068 }
        if (r5 == 0) goto L_0x0054;
    L_0x004c:
        r5 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0068 }
        r1 = 13;
        r5.<init>(r1);	 Catch:{ all -> 0x0068 }
        goto L_0x0056;
    L_0x0054:
        r5 = com.google.android.gms.common.api.Status.zzftq;	 Catch:{ all -> 0x0068 }
    L_0x0056:
        r1 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r2 = new com.google.android.gms.common.api.BatchResult;	 Catch:{ all -> 0x0068 }
        r3 = r4.zzfsj;	 Catch:{ all -> 0x0068 }
        r3 = r3.zzfsi;	 Catch:{ all -> 0x0068 }
        r2.<init>(r5, r3);	 Catch:{ all -> 0x0068 }
        r1.setResult(r2);	 Catch:{ all -> 0x0068 }
    L_0x0066:
        monitor-exit(r0);	 Catch:{ all -> 0x0068 }
        return;
    L_0x0068:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0068 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zza.zzr(com.google.android.gms.common.api.Status):void");
    }
}
