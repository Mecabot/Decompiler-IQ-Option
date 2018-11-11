package com.google.common.util.concurrent;

import com.google.common.base.i;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: AbstractTransformFuture */
abstract class d<I, O, F, T> extends h<O> implements Runnable {
    s<? extends I> VO;
    F Wt;

    /* compiled from: AbstractTransformFuture */
    private static final class a<I, O> extends d<I, O, g<? super I, ? extends O>, s<? extends O>> {
        a(s<? extends I> sVar, g<? super I, ? extends O> gVar) {
            super(sVar, gVar);
        }

        /* renamed from: a */
        s<? extends O> y(g<? super I, ? extends O> gVar, I i) {
            s<? extends O> aP = gVar.aP(i);
            i.checkNotNull(aP, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            return aP;
        }

        /* renamed from: d */
        void setResult(s<? extends O> sVar) {
            a((s) sVar);
        }
    }

    /* compiled from: AbstractTransformFuture */
    private static final class b<I, O> extends d<I, O, com.google.common.base.d<? super I, ? extends O>, O> {
        b(s<? extends I> sVar, com.google.common.base.d<? super I, ? extends O> dVar) {
            super(sVar, dVar);
        }

        /* renamed from: a */
        O y(com.google.common.base.d<? super I, ? extends O> dVar, I i) {
            return dVar.apply(i);
        }

        void setResult(O o) {
            a(o);
        }
    }

    abstract void setResult(T t);

    abstract T y(F f, I i);

    static <I, O> s<O> a(s<I> sVar, g<? super I, ? extends O> gVar, Executor executor) {
        i.checkNotNull(executor);
        s<O> aVar = new a(sVar, gVar);
        sVar.a(aVar, MoreExecutors.a(executor, aVar));
        return aVar;
    }

    static <I, O> s<O> a(s<I> sVar, com.google.common.base.d<? super I, ? extends O> dVar, Executor executor) {
        i.checkNotNull(dVar);
        s<O> bVar = new b(sVar, dVar);
        sVar.a(bVar, MoreExecutors.a(executor, bVar));
        return bVar;
    }

    d(s<? extends I> sVar, F f) {
        this.VO = (s) i.checkNotNull(sVar);
        this.Wt = i.checkNotNull(f);
    }

    public final void run() {
        Future future = this.VO;
        Object obj = this.Wt;
        int i = 1;
        int isCancelled = isCancelled() | (future == null ? 1 : 0);
        if (obj != null) {
            i = 0;
        }
        if ((isCancelled | i) == 0) {
            this.VO = null;
            this.Wt = null;
            try {
                try {
                    setResult(y(obj, o.b(future)));
                } catch (UndeclaredThrowableException e) {
                    a(e.getCause());
                } catch (Throwable th) {
                    a(th);
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e2) {
                a(e2.getCause());
            } catch (Throwable th2) {
                a(th2);
            } catch (Throwable th22) {
                a(th22);
            }
        }
    }

    protected final void vC() {
        a(this.VO);
        this.VO = null;
        this.Wt = null;
    }

    protected String vB() {
        s sVar = this.VO;
        Object obj = this.Wt;
        if (sVar == null || obj == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inputFuture=[");
        stringBuilder.append(sVar);
        stringBuilder.append("], function=[");
        stringBuilder.append(obj);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
