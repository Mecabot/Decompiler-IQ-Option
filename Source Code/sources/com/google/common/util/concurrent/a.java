package com.google.common.util.concurrent;

import com.google.common.base.d;
import com.google.common.base.i;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: AbstractCatchingFuture */
abstract class a<V, X extends Throwable, F, T> extends h<V> implements Runnable {
    s<? extends V> VO;
    Class<X> VP;
    F VQ;

    /* compiled from: AbstractCatchingFuture */
    private static final class a<V, X extends Throwable> extends a<V, X, d<? super X, ? extends V>, V> {
        a(s<? extends V> sVar, Class<X> cls, d<? super X, ? extends V> dVar) {
            super(sVar, cls, dVar);
        }

        V a(d<? super X, ? extends V> dVar, X x) {
            return dVar.apply(x);
        }

        void setResult(V v) {
            a(v);
        }
    }

    abstract T a(F f, X x);

    abstract void setResult(T t);

    static <V, X extends Throwable> s<V> a(s<? extends V> sVar, Class<X> cls, d<? super X, ? extends V> dVar, Executor executor) {
        s<V> aVar = new a(sVar, cls, dVar);
        sVar.a(aVar, MoreExecutors.a(executor, aVar));
        return aVar;
    }

    a(s<? extends V> sVar, Class<X> cls, F f) {
        this.VO = (s) i.checkNotNull(sVar);
        this.VP = (Class) i.checkNotNull(cls);
        this.VQ = i.checkNotNull(f);
    }

    public final void run() {
        Future future = this.VO;
        Class cls = this.VP;
        Object obj = this.VQ;
        int i = 0;
        int i2 = (future == null ? 1 : 0) | (cls == null ? 1 : 0);
        if (obj == null) {
            i = 1;
        }
        if (((i | i2) | isCancelled()) == 0) {
            Throwable th;
            Object obj2 = null;
            this.VO = null;
            this.VP = null;
            this.VQ = null;
            try {
                obj2 = o.b(future);
                th = null;
            } catch (ExecutionException e) {
                th = (Throwable) i.checkNotNull(e.getCause());
            } catch (Throwable th2) {
                th = th2;
            }
            if (th == null) {
                a(obj2);
            } else if (w.d(th, cls)) {
                try {
                    setResult(a(obj, th));
                } catch (Throwable th3) {
                    a(th3);
                }
            } else {
                a(th3);
            }
        }
    }

    protected String vB() {
        s sVar = this.VO;
        Class cls = this.VP;
        Object obj = this.VQ;
        if (sVar == null || cls == null || obj == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("input=[");
        stringBuilder.append(sVar);
        stringBuilder.append("], exceptionType=[");
        stringBuilder.append(cls);
        stringBuilder.append("], fallback=[");
        stringBuilder.append(obj);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected final void vC() {
        a(this.VO);
        this.VO = null;
        this.VP = null;
        this.VQ = null;
    }
}
