package com.google.common.util.concurrent;

import com.google.common.base.i;
import java.util.concurrent.Executor;

/* compiled from: ForwardingListenableFuture */
public abstract class m<V> extends l<V> implements s<V> {

    /* compiled from: ForwardingListenableFuture */
    public static abstract class a<V> extends m<V> {
        private final s<V> WJ;

        protected a(s<V> sVar) {
            this.WJ = (s) i.checkNotNull(sVar);
        }

        /* renamed from: vS */
        protected final s<V> vR() {
            return this.WJ;
        }
    }

    /* renamed from: vS */
    protected abstract s<? extends V> vR();

    protected m() {
    }

    public void a(Runnable runnable, Executor executor) {
        vR().a(runnable, executor);
    }
}
