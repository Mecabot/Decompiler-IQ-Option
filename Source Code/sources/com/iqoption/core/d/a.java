package com.iqoption.core.d;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.v;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: Schedulers */
public final class a {
    private static final int aSb = Runtime.getRuntime().availableProcessors();
    public static final v aSc = MoreExecutors.a(new a(aSb));
    public static v aSd = MoreExecutors.a(new a(aSb));
    public static final b aSe = new b(Looper.getMainLooper());

    /* compiled from: Schedulers */
    public static final class b extends Handler implements Executor {
        b(Looper looper) {
            super(looper);
        }

        public void execute(@NonNull Runnable runnable) {
            post(runnable);
        }
    }

    /* compiled from: Schedulers */
    private static class a extends ScheduledThreadPoolExecutor {
        a(int i) {
            super(i);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x001d A:{Splitter: B:5:0x000b, ExcHandler: java.util.concurrent.ExecutionException (r2_3 'e' java.lang.Exception)} */
        /* JADX WARNING: Missing block: B:10:0x001d, code:
            r2 = move-exception;
     */
        /* JADX WARNING: Missing block: B:11:0x001e, code:
            r3 = r2.getCause();
     */
        protected void afterExecute(java.lang.Runnable r2, java.lang.Throwable r3) {
            /*
            r1 = this;
            super.afterExecute(r2, r3);
            if (r3 != 0) goto L_0x0022;
        L_0x0005:
            r0 = r2 instanceof java.util.concurrent.Future;
            if (r0 == 0) goto L_0x0022;
        L_0x0009:
            r2 = (java.util.concurrent.Future) r2;
            r0 = r2.isDone();	 Catch:{ ExecutionException -> 0x001d, ExecutionException -> 0x001d, InterruptedException -> 0x0015 }
            if (r0 == 0) goto L_0x0022;
        L_0x0011:
            r2.get();	 Catch:{ ExecutionException -> 0x001d, ExecutionException -> 0x001d, InterruptedException -> 0x0015 }
            goto L_0x0022;
        L_0x0015:
            r2 = java.lang.Thread.currentThread();
            r2.interrupt();
            goto L_0x0022;
        L_0x001d:
            r2 = move-exception;
            r3 = r2.getCause();
        L_0x0022:
            if (r3 == 0) goto L_0x003d;
        L_0x0024:
            r2 = com.iqoption.core.f.Dp();
            r2 = r2.DJ();
            if (r2 == 0) goto L_0x0036;
        L_0x002e:
            r2 = "SCHEDULER_ERROR";
            r0 = "Error";
            com.iqoption.core.i.e(r2, r0, r3);
            goto L_0x003d;
        L_0x0036:
            r2 = r3 instanceof java.util.concurrent.CancellationException;
            if (r2 != 0) goto L_0x003d;
        L_0x003a:
            com.iqoption.core.i.r(r3);
        L_0x003d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iqoption.core.d.a.a.afterExecute(java.lang.Runnable, java.lang.Throwable):void");
        }
    }

    public static void Uf() {
        aSd.shutdownNow();
        aSd = MoreExecutors.a(new a(aSb));
    }
}
