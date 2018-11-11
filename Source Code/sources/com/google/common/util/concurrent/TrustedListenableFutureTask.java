package com.google.common.util.concurrent;

import com.google.common.base.i;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

class TrustedListenableFutureTask<V> extends h<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> Xo;

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.callable = (Callable) i.checkNotNull(callable);
        }

        final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        V vU() {
            return this.callable.call();
        }

        void b(V v, Throwable th) {
            if (th == null) {
                TrustedListenableFutureTask.this.a(v);
            } else {
                TrustedListenableFutureTask.this.a(th);
            }
        }

        public String toString() {
            return this.callable.toString();
        }
    }

    static <V> TrustedListenableFutureTask<V> d(Callable<V> callable) {
        return new TrustedListenableFutureTask(callable);
    }

    static <V> TrustedListenableFutureTask<V> b(Runnable runnable, V v) {
        return new TrustedListenableFutureTask(Executors.callable(runnable, v));
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.Xo = new TrustedFutureInterruptibleTask(callable);
    }

    public void run() {
        InterruptibleTask interruptibleTask = this.Xo;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.Xo = null;
    }

    protected void vC() {
        super.vC();
        if (vE()) {
            InterruptibleTask interruptibleTask = this.Xo;
            if (interruptibleTask != null) {
                interruptibleTask.vD();
            }
        }
        this.Xo = null;
    }

    protected String vB() {
        InterruptibleTask interruptibleTask = this.Xo;
        if (interruptibleTask == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("task=[");
        stringBuilder.append(interruptibleTask);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
