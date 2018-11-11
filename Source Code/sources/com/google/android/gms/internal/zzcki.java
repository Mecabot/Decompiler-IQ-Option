package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;

final class zzcki extends Thread {
    private /* synthetic */ zzcke zzjnm;
    private final Object zzjnp = new Object();
    private final BlockingQueue<zzckh<?>> zzjnq;

    public zzcki(zzcke zzcke, String str, BlockingQueue<zzckh<?>> blockingQueue) {
        this.zzjnm = zzcke;
        zzbq.checkNotNull(str);
        zzbq.checkNotNull(blockingQueue);
        this.zzjnq = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzjnm.zzayp().zzbaw().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* JADX WARNING: Missing block: B:37:0x0065, code:
            r1 = r6.zzjnm.zzjnh;
     */
    /* JADX WARNING: Missing block: B:38:0x006b, code:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:40:?, code:
            r6.zzjnm.zzjni.release();
            r6.zzjnm.zzjnh.notifyAll();
     */
    /* JADX WARNING: Missing block: B:41:0x0084, code:
            if (r6 != r6.zzjnm.zzjnb) goto L_0x008c;
     */
    /* JADX WARNING: Missing block: B:42:0x0086, code:
            r6.zzjnm.zzjnb = null;
     */
    /* JADX WARNING: Missing block: B:44:0x0092, code:
            if (r6 != r6.zzjnm.zzjnc) goto L_0x009a;
     */
    /* JADX WARNING: Missing block: B:45:0x0094, code:
            r6.zzjnm.zzjnc = null;
     */
    /* JADX WARNING: Missing block: B:46:0x009a, code:
            r6.zzjnm.zzayp().zzbau().log("Current scheduler thread is neither worker nor network");
     */
    /* JADX WARNING: Missing block: B:47:0x00a9, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:48:0x00aa, code:
            return;
     */
    public final void run() {
        /*
        r6 = this;
        r0 = 0;
    L_0x0001:
        if (r0 != 0) goto L_0x0013;
    L_0x0003:
        r1 = r6.zzjnm;	 Catch:{ InterruptedException -> 0x000e }
        r1 = r1.zzjni;	 Catch:{ InterruptedException -> 0x000e }
        r1.acquire();	 Catch:{ InterruptedException -> 0x000e }
        r0 = 1;
        goto L_0x0001;
    L_0x000e:
        r1 = move-exception;
        r6.zza(r1);
        goto L_0x0001;
    L_0x0013:
        r0 = 0;
        r1 = android.os.Process.myTid();	 Catch:{ all -> 0x00b7 }
        r1 = android.os.Process.getThreadPriority(r1);	 Catch:{ all -> 0x00b7 }
    L_0x001c:
        r2 = r6.zzjnq;	 Catch:{ all -> 0x00b7 }
        r2 = r2.poll();	 Catch:{ all -> 0x00b7 }
        r2 = (com.google.android.gms.internal.zzckh) r2;	 Catch:{ all -> 0x00b7 }
        if (r2 == 0) goto L_0x0035;
    L_0x0026:
        r3 = r2.zzjno;	 Catch:{ all -> 0x00b7 }
        if (r3 == 0) goto L_0x002c;
    L_0x002a:
        r3 = r1;
        goto L_0x002e;
    L_0x002c:
        r3 = 10;
    L_0x002e:
        android.os.Process.setThreadPriority(r3);	 Catch:{ all -> 0x00b7 }
        r2.run();	 Catch:{ all -> 0x00b7 }
        goto L_0x001c;
    L_0x0035:
        r2 = r6.zzjnp;	 Catch:{ all -> 0x00b7 }
        monitor-enter(r2);	 Catch:{ all -> 0x00b7 }
        r3 = r6.zzjnq;	 Catch:{ all -> 0x00b4 }
        r3 = r3.peek();	 Catch:{ all -> 0x00b4 }
        if (r3 != 0) goto L_0x0054;
    L_0x0040:
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00b4 }
        r3 = r3.zzjnj;	 Catch:{ all -> 0x00b4 }
        if (r3 != 0) goto L_0x0054;
    L_0x0048:
        r3 = r6.zzjnp;	 Catch:{ InterruptedException -> 0x0050 }
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r3.wait(r4);	 Catch:{ InterruptedException -> 0x0050 }
        goto L_0x0054;
    L_0x0050:
        r3 = move-exception;
        r6.zza(r3);	 Catch:{ all -> 0x00b4 }
    L_0x0054:
        monitor-exit(r2);	 Catch:{ all -> 0x00b4 }
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00b7 }
        r2 = r2.zzjnh;	 Catch:{ all -> 0x00b7 }
        monitor-enter(r2);	 Catch:{ all -> 0x00b7 }
        r3 = r6.zzjnq;	 Catch:{ all -> 0x00b1 }
        r3 = r3.peek();	 Catch:{ all -> 0x00b1 }
        if (r3 != 0) goto L_0x00ae;
    L_0x0064:
        monitor-exit(r2);	 Catch:{ all -> 0x00b1 }
        r1 = r6.zzjnm;
        r1 = r1.zzjnh;
        monitor-enter(r1);
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r2 = r2.zzjni;	 Catch:{ all -> 0x00ab }
        r2.release();	 Catch:{ all -> 0x00ab }
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r2 = r2.zzjnh;	 Catch:{ all -> 0x00ab }
        r2.notifyAll();	 Catch:{ all -> 0x00ab }
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r2 = r2.zzjnb;	 Catch:{ all -> 0x00ab }
        if (r6 != r2) goto L_0x008c;
    L_0x0086:
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r2.zzjnb = null;	 Catch:{ all -> 0x00ab }
        goto L_0x00a9;
    L_0x008c:
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r2 = r2.zzjnc;	 Catch:{ all -> 0x00ab }
        if (r6 != r2) goto L_0x009a;
    L_0x0094:
        r2 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r2.zzjnc = null;	 Catch:{ all -> 0x00ab }
        goto L_0x00a9;
    L_0x009a:
        r0 = r6.zzjnm;	 Catch:{ all -> 0x00ab }
        r0 = r0.zzayp();	 Catch:{ all -> 0x00ab }
        r0 = r0.zzbau();	 Catch:{ all -> 0x00ab }
        r2 = "Current scheduler thread is neither worker nor network";
        r0.log(r2);	 Catch:{ all -> 0x00ab }
    L_0x00a9:
        monitor-exit(r1);	 Catch:{ all -> 0x00ab }
        return;
    L_0x00ab:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00ab }
        throw r0;
    L_0x00ae:
        monitor-exit(r2);	 Catch:{ all -> 0x00b1 }
        goto L_0x001c;
    L_0x00b1:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00b1 }
        throw r1;	 Catch:{ all -> 0x00b7 }
    L_0x00b4:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00b4 }
        throw r1;	 Catch:{ all -> 0x00b7 }
    L_0x00b7:
        r1 = move-exception;
        r2 = r6.zzjnm;
        r2 = r2.zzjnh;
        monitor-enter(r2);
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r3 = r3.zzjni;	 Catch:{ all -> 0x00fe }
        r3.release();	 Catch:{ all -> 0x00fe }
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r3 = r3.zzjnh;	 Catch:{ all -> 0x00fe }
        r3.notifyAll();	 Catch:{ all -> 0x00fe }
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r3 = r3.zzjnb;	 Catch:{ all -> 0x00fe }
        if (r6 != r3) goto L_0x00df;
    L_0x00d9:
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r3.zzjnb = null;	 Catch:{ all -> 0x00fe }
        goto L_0x00fc;
    L_0x00df:
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r3 = r3.zzjnc;	 Catch:{ all -> 0x00fe }
        if (r6 != r3) goto L_0x00ed;
    L_0x00e7:
        r3 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r3.zzjnc = null;	 Catch:{ all -> 0x00fe }
        goto L_0x00fc;
    L_0x00ed:
        r0 = r6.zzjnm;	 Catch:{ all -> 0x00fe }
        r0 = r0.zzayp();	 Catch:{ all -> 0x00fe }
        r0 = r0.zzbau();	 Catch:{ all -> 0x00fe }
        r3 = "Current scheduler thread is neither worker nor network";
        r0.log(r3);	 Catch:{ all -> 0x00fe }
    L_0x00fc:
        monitor-exit(r2);	 Catch:{ all -> 0x00fe }
        throw r1;
    L_0x00fe:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00fe }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcki.run():void");
    }

    public final void zzsl() {
        synchronized (this.zzjnp) {
            this.zzjnp.notifyAll();
        }
    }
}
