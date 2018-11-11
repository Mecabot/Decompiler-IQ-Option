package com.google.common.util.concurrent;

import com.google.common.base.d;
import com.google.common.base.e;
import com.google.common.base.i;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Futures */
public final class o extends q {
    private static final g<s<Object>, Object> WK = new g<s<Object>, Object>() {
        /* renamed from: e */
        public s<Object> aP(s<Object> sVar) {
            return sVar;
        }
    };

    /* compiled from: Futures */
    private static final class a<V> implements Runnable {
        final n<? super V> WL;
        final Future<V> future;

        a(Future<V> future, n<? super V> nVar) {
            this.future = future;
            this.WL = nVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x000c A:{Splitter: B:0:0x0000, ExcHandler: java.lang.RuntimeException (r0_2 'e' java.lang.Throwable)} */
        /* JADX WARNING: Missing block: B:4:0x000c, code:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:5:0x000d, code:
            r2.WL.l(r0);
     */
        /* JADX WARNING: Missing block: B:6:0x0012, code:
            return;
     */
        public void run() {
            /*
            r2 = this;
            r0 = r2.future;	 Catch:{ ExecutionException -> 0x0013, RuntimeException -> 0x000c, RuntimeException -> 0x000c }
            r0 = com.google.common.util.concurrent.o.b(r0);	 Catch:{ ExecutionException -> 0x0013, RuntimeException -> 0x000c, RuntimeException -> 0x000c }
            r1 = r2.WL;
            r1.onSuccess(r0);
            return;
        L_0x000c:
            r0 = move-exception;
            r1 = r2.WL;
            r1.l(r0);
            return;
        L_0x0013:
            r0 = move-exception;
            r1 = r2.WL;
            r0 = r0.getCause();
            r1.l(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.o.a.run():void");
        }

        public String toString() {
            return e.B(this).C(this.WL).toString();
        }
    }

    public static <V> s<V> aR(V v) {
        if (v == null) {
            return d.WN;
        }
        return new d(v);
    }

    public static <V> s<V> m(Throwable th) {
        i.checkNotNull(th);
        return new c(th);
    }

    public static <V> s<V> vT() {
        return new a();
    }

    @Deprecated
    public static <V, X extends Exception> i<V, X> b(X x) {
        i.checkNotNull(x);
        return new b(x);
    }

    public static <V, X extends Throwable> s<V> b(s<? extends V> sVar, Class<X> cls, d<? super X, ? extends V> dVar, Executor executor) {
        return a.a(sVar, cls, dVar, executor);
    }

    public static <V> s<V> a(s<V> sVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return aa.b(sVar, j, timeUnit, scheduledExecutorService);
    }

    @Deprecated
    public static <I, O> s<O> a(s<I> sVar, g<? super I, ? extends O> gVar) {
        return d.a((s) sVar, (g) gVar, MoreExecutors.vV());
    }

    public static <I, O> s<O> b(s<I> sVar, g<? super I, ? extends O> gVar, Executor executor) {
        return d.a((s) sVar, (g) gVar, executor);
    }

    @Deprecated
    public static <I, O> s<O> a(s<I> sVar, d<? super I, ? extends O> dVar) {
        return d.a((s) sVar, (d) dVar, MoreExecutors.vV());
    }

    public static <I, O> s<O> b(s<I> sVar, d<? super I, ? extends O> dVar, Executor executor) {
        return d.a((s) sVar, (d) dVar, executor);
    }

    @SafeVarargs
    public static <V> s<List<V>> a(s<? extends V>... sVarArr) {
        return new b(ImmutableList.f(sVarArr), true);
    }

    public static <V> s<List<V>> E(Iterable<? extends s<? extends V>> iterable) {
        return new b(ImmutableList.g((Iterable) iterable), true);
    }

    @Deprecated
    public static <V> void a(s<V> sVar, n<? super V> nVar) {
        a(sVar, nVar, MoreExecutors.vV());
    }

    public static <V> void a(s<V> sVar, n<? super V> nVar, Executor executor) {
        i.checkNotNull(nVar);
        sVar.a(new a(sVar, nVar), executor);
    }

    public static <V> V b(Future<V> future) {
        i.b(future.isDone(), "Future was expected to be done: %s", (Object) future);
        return ab.c(future);
    }
}
