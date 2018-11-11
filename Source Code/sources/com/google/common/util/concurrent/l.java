package com.google.common.util.concurrent;

import com.google.common.collect.o;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingFuture */
public abstract class l<V> extends o implements Future<V> {
    /* renamed from: vR */
    protected abstract Future<? extends V> qB();

    protected l() {
    }

    public boolean cancel(boolean z) {
        return qB().cancel(z);
    }

    public boolean isCancelled() {
        return qB().isCancelled();
    }

    public boolean isDone() {
        return qB().isDone();
    }

    public V get() {
        return qB().get();
    }

    public V get(long j, TimeUnit timeUnit) {
        return qB().get(j, timeUnit);
    }
}
