package com.appsflyer;

import android.os.Build.VERSION;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class a {
    private static a pe;
    private Executor pf;
    private ScheduledExecutorService pg;

    private a() {
    }

    public static a fp() {
        if (pe == null) {
            pe = new a();
        }
        return pe;
    }

    public Executor fq() {
        Object obj = (this.pf == null || ((this.pf instanceof ThreadPoolExecutor) && (((ThreadPoolExecutor) this.pf).isShutdown() || ((ThreadPoolExecutor) this.pf).isTerminated() || ((ThreadPoolExecutor) this.pf).isTerminating()))) ? 1 : null;
        if (obj != null) {
            if (VERSION.SDK_INT < 11) {
                return Executors.newSingleThreadExecutor();
            }
            this.pf = Executors.newFixedThreadPool(2);
        }
        return this.pf;
    }

    final ScheduledThreadPoolExecutor fr() {
        Object obj = (this.pg == null || this.pg.isShutdown() || this.pg.isTerminated()) ? 1 : null;
        if (obj != null) {
            this.pg = Executors.newScheduledThreadPool(2);
        }
        return (ScheduledThreadPoolExecutor) this.pg;
    }

    final void fs() {
        try {
            a(this.pg);
            if (this.pf instanceof ThreadPoolExecutor) {
                a((ThreadPoolExecutor) this.pf);
            }
        } catch (Throwable th) {
            AFLogger.a("failed to stop Executors", th);
        }
    }

    /* JADX WARNING: Missing block: B:9:?, code:
            com.appsflyer.AFLogger.ak("InterruptedException!!!");
     */
    /* JADX WARNING: Missing block: B:11:0x0029, code:
            if (r3.isTerminated() == false) goto L_0x002b;
     */
    /* JADX WARNING: Missing block: B:12:0x002b, code:
            com.appsflyer.AFLogger.ak("killing non-finished tasks");
     */
    /* JADX WARNING: Missing block: B:13:0x0030, code:
            r3.shutdownNow();
     */
    /* JADX WARNING: Missing block: B:14:0x0033, code:
            return;
     */
    /* JADX WARNING: Missing block: B:16:0x0038, code:
            if (r3.isTerminated() == false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:17:0x003a, code:
            com.appsflyer.AFLogger.ak("killing non-finished tasks");
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code:
            r3.shutdownNow();
     */
    private static void a(java.util.concurrent.ExecutorService r3) {
        /*
        r0 = "shut downing executor ...";
        com.appsflyer.AFLogger.ak(r0);	 Catch:{ InterruptedException -> 0x0020 }
        r3.shutdown();	 Catch:{ InterruptedException -> 0x0020 }
        r0 = 10;
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x0020 }
        r3.awaitTermination(r0, r2);	 Catch:{ InterruptedException -> 0x0020 }
        r0 = r3.isTerminated();
        if (r0 != 0) goto L_0x001a;
    L_0x0015:
        r0 = "killing non-finished tasks";
        com.appsflyer.AFLogger.ak(r0);
    L_0x001a:
        r3.shutdownNow();
        return;
    L_0x001e:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0020:
        r0 = "InterruptedException!!!";
        com.appsflyer.AFLogger.ak(r0);	 Catch:{ all -> 0x001e }
        r0 = r3.isTerminated();
        if (r0 != 0) goto L_0x0030;
    L_0x002b:
        r0 = "killing non-finished tasks";
        com.appsflyer.AFLogger.ak(r0);
    L_0x0030:
        r3.shutdownNow();
        return;
    L_0x0034:
        r1 = r3.isTerminated();
        if (r1 != 0) goto L_0x003f;
    L_0x003a:
        r1 = "killing non-finished tasks";
        com.appsflyer.AFLogger.ak(r1);
    L_0x003f:
        r3.shutdownNow();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.a.a(java.util.concurrent.ExecutorService):void");
    }
}
