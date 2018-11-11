package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask */
public class e<V> extends FutureTask<V> implements a<i>, f, i {
    final Object delegate;

    public e(Callable<V> callable) {
        super(callable);
        this.delegate = bT(callable);
    }

    public e(Runnable runnable, V v) {
        super(runnable, v);
        this.delegate = bT(runnable);
    }

    public int compareTo(Object obj) {
        return ((f) aVb()).compareTo(obj);
    }

    /* renamed from: a */
    public void bS(i iVar) {
        ((a) ((f) aVb())).bS(iVar);
    }

    public Collection<i> aUq() {
        return ((a) ((f) aVb())).aUq();
    }

    public boolean aUW() {
        return ((a) ((f) aVb())).aUW();
    }

    public Priority hA() {
        return ((f) aVb()).hA();
    }

    public void gr(boolean z) {
        ((i) ((f) aVb())).gr(z);
    }

    public boolean isFinished() {
        return ((i) ((f) aVb())).isFinished();
    }

    public void P(Throwable th) {
        ((i) ((f) aVb())).P(th);
    }

    public <T extends a<i> & f & i> T aVb() {
        return (a) this.delegate;
    }

    protected <T extends a<i> & f & i> T bT(Object obj) {
        if (g.bU(obj)) {
            return (a) obj;
        }
        return new g();
    }
}
