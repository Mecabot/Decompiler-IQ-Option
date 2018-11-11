package com.google.common.util.concurrent;

import com.google.common.base.i;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: TimeoutFuture */
final class aa<V> extends h<V> {
    private s<V> Xl;
    private Future<?> Xm;

    /* compiled from: TimeoutFuture */
    private static final class a<V> implements Runnable {
        aa<V> Xn;

        a(aa<V> aaVar) {
            this.Xn = aaVar;
        }

        public void run() {
            aa aaVar = this.Xn;
            if (aaVar != null) {
                s a = aaVar.Xl;
                if (a != null) {
                    this.Xn = null;
                    if (a.isDone()) {
                        aaVar.a(a);
                    } else {
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Future timed out: ");
                            stringBuilder.append(a);
                            aaVar.a(new TimeoutException(stringBuilder.toString()));
                        } finally {
                            a.cancel(true);
                        }
                    }
                }
            }
        }
    }

    static <V> s<V> b(s<V> sVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        s aaVar = new aa(sVar);
        Runnable aVar = new a(aaVar);
        aaVar.Xm = scheduledExecutorService.schedule(aVar, j, timeUnit);
        sVar.a(aVar, MoreExecutors.vV());
        return aaVar;
    }

    private aa(s<V> sVar) {
        this.Xl = (s) i.checkNotNull(sVar);
    }

    protected String vB() {
        s sVar = this.Xl;
        if (sVar == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inputFuture=[");
        stringBuilder.append(sVar);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected void vC() {
        a(this.Xl);
        Future future = this.Xm;
        if (future != null) {
            future.cancel(false);
        }
        this.Xl = null;
        this.Xm = null;
    }
}
