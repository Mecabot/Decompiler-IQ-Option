package com.iqoption.system.c;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.common.base.j;
import com.google.common.util.concurrent.n;
import java.lang.ref.WeakReference;

/* compiled from: ReferenceFutureCallback */
public abstract class b<T, V> implements n<V> {
    protected final WeakReference<T> aSh;
    @Nullable
    private j<? super T> dsd;
    private final Class<V> dse;

    public void c(@NonNull T t, Throwable th) {
    }

    public void z(@NonNull T t, @Nullable V v) {
    }

    public b(T t) {
        this.aSh = new WeakReference(t);
        this.dse = null;
    }

    public b(WeakReference<T> weakReference) {
        this.aSh = weakReference;
        this.dse = null;
    }

    public b(T t, Class<V> cls) {
        this.aSh = new WeakReference(t);
        this.dse = cls;
    }

    public void f(@Nullable j<? super T> jVar) {
        this.dsd = jVar;
    }

    public void onSuccess(V v) {
        if (v != null || (this.dse != null && (this.dse.isInstance(Void.class) || !this.dse.isInstance(Object.class)))) {
            Object aEu = aEu();
            if (aEu != null) {
                z(aEu, v);
                return;
            }
            return;
        }
        l(new NullPointerException("not parse"));
    }

    public void l(Throwable th) {
        Object aEu = aEu();
        if (aEu != null) {
            c(aEu, th);
        }
    }

    private T aEu() {
        T t = this.aSh.get();
        if (t == null) {
            return null;
        }
        if (this.dsd == null) {
            return t;
        }
        if (!this.dsd.apply(t)) {
            t = null;
        }
        return t;
    }

    public T getReferent() {
        return this.aSh.get();
    }
}
