package io.reactivex.d;

import io.reactivex.c.b;
import io.reactivex.c.d;
import io.reactivex.c.e;
import io.reactivex.c.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.i;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import io.reactivex.l;
import io.reactivex.m;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import java.util.concurrent.Callable;
import org.a.c;

/* compiled from: RxJavaPlugins */
public final class a {
    static volatile e<? super Throwable> esX;
    static volatile f<? super Runnable, ? extends Runnable> esY;
    static volatile f<? super Callable<n>, ? extends n> esZ;
    static volatile f<? super Callable<n>, ? extends n> eta;
    static volatile f<? super Callable<n>, ? extends n> etb;
    static volatile f<? super Callable<n>, ? extends n> etc;
    static volatile f<? super n, ? extends n> etd;
    static volatile f<? super n, ? extends n> ete;
    static volatile f<? super n, ? extends n> etf;
    static volatile f<? super io.reactivex.e, ? extends io.reactivex.e> etg;
    static volatile f<? super io.reactivex.b.a, ? extends io.reactivex.b.a> eti;
    static volatile f<? super i, ? extends i> etj;
    static volatile f<? super o, ? extends o> etk;
    static volatile f<? super io.reactivex.a, ? extends io.reactivex.a> etl;
    static volatile b<? super io.reactivex.e, ? super c, ? extends c> etm;
    static volatile b<? super i, ? super j, ? extends j> etn;
    static volatile b<? super l, ? super m, ? extends m> eto;
    static volatile b<? super o, ? super q, ? extends q> etp;
    static volatile b<? super io.reactivex.a, ? super io.reactivex.b, ? extends io.reactivex.b> etq;
    static volatile d etr;
    static volatile boolean ets;
    static volatile boolean ett;

    public static boolean aXk() {
        return ett;
    }

    public static n k(Callable<n> callable) {
        io.reactivex.internal.a.b.requireNonNull(callable, "Scheduler Callable can't be null");
        f fVar = esZ;
        if (fVar == null) {
            return j((Callable) callable);
        }
        return a(fVar, (Callable) callable);
    }

    public static n l(Callable<n> callable) {
        io.reactivex.internal.a.b.requireNonNull(callable, "Scheduler Callable can't be null");
        f fVar = etb;
        if (fVar == null) {
            return j((Callable) callable);
        }
        return a(fVar, (Callable) callable);
    }

    public static n m(Callable<n> callable) {
        io.reactivex.internal.a.b.requireNonNull(callable, "Scheduler Callable can't be null");
        f fVar = etc;
        if (fVar == null) {
            return j((Callable) callable);
        }
        return a(fVar, (Callable) callable);
    }

    public static n n(Callable<n> callable) {
        io.reactivex.internal.a.b.requireNonNull(callable, "Scheduler Callable can't be null");
        f fVar = eta;
        if (fVar == null) {
            return j((Callable) callable);
        }
        return a(fVar, (Callable) callable);
    }

    public static n j(n nVar) {
        f fVar = etd;
        if (fVar == null) {
            return nVar;
        }
        return (n) a(fVar, (Object) nVar);
    }

    public static void onError(Throwable th) {
        e eVar = esX;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!ab(th)) {
            th = new UndeliverableException(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                ac(th2);
            }
        }
        th.printStackTrace();
        ac(th);
    }

    static boolean ab(Throwable th) {
        if ((th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException)) {
            return true;
        }
        return false;
    }

    static void ac(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static n k(n nVar) {
        f fVar = etf;
        if (fVar == null) {
            return nVar;
        }
        return (n) a(fVar, (Object) nVar);
    }

    public static Runnable u(Runnable runnable) {
        io.reactivex.internal.a.b.requireNonNull(runnable, "run is null");
        f fVar = esY;
        if (fVar == null) {
            return runnable;
        }
        return (Runnable) a(fVar, (Object) runnable);
    }

    public static n l(n nVar) {
        f fVar = ete;
        if (fVar == null) {
            return nVar;
        }
        return (n) a(fVar, (Object) nVar);
    }

    public static void f(e<? super Throwable> eVar) {
        if (ets) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        esX = eVar;
    }

    public static <T> c<? super T> a(io.reactivex.e<T> eVar, c<? super T> cVar) {
        b bVar = etm;
        return bVar != null ? (c) a(bVar, eVar, cVar) : cVar;
    }

    public static <T> m<? super T> a(l<T> lVar, m<? super T> mVar) {
        b bVar = eto;
        return bVar != null ? (m) a(bVar, lVar, mVar) : mVar;
    }

    public static <T> q<? super T> a(o<T> oVar, q<? super T> qVar) {
        b bVar = etp;
        return bVar != null ? (q) a(bVar, oVar, qVar) : qVar;
    }

    public static io.reactivex.b a(io.reactivex.a aVar, io.reactivex.b bVar) {
        b bVar2 = etq;
        return bVar2 != null ? (io.reactivex.b) a(bVar2, aVar, bVar) : bVar;
    }

    public static <T> j<? super T> a(i<T> iVar, j<? super T> jVar) {
        b bVar = etn;
        return bVar != null ? (j) a(bVar, iVar, jVar) : jVar;
    }

    public static <T> i<T> a(i<T> iVar) {
        f fVar = etj;
        return fVar != null ? (i) a(fVar, (Object) iVar) : iVar;
    }

    public static <T> io.reactivex.e<T> g(io.reactivex.e<T> eVar) {
        f fVar = etg;
        return fVar != null ? (io.reactivex.e) a(fVar, (Object) eVar) : eVar;
    }

    public static <T> io.reactivex.b.a<T> a(io.reactivex.b.a<T> aVar) {
        f fVar = eti;
        return fVar != null ? (io.reactivex.b.a) a(fVar, (Object) aVar) : aVar;
    }

    public static <T> o<T> b(o<T> oVar) {
        f fVar = etk;
        return fVar != null ? (o) a(fVar, (Object) oVar) : oVar;
    }

    public static io.reactivex.a a(io.reactivex.a aVar) {
        f fVar = etl;
        return fVar != null ? (io.reactivex.a) a(fVar, (Object) aVar) : aVar;
    }

    public static boolean aXl() {
        d dVar = etr;
        if (dVar == null) {
            return false;
        }
        try {
            return dVar.getAsBoolean();
        } catch (Throwable th) {
            RuntimeException Z = ExceptionHelper.Z(th);
        }
    }

    static <T, R> R a(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            RuntimeException Z = ExceptionHelper.Z(th);
        }
    }

    static <T, U, R> R a(b<T, U, R> bVar, T t, U u) {
        try {
            return bVar.apply(t, u);
        } catch (Throwable th) {
            RuntimeException Z = ExceptionHelper.Z(th);
        }
    }

    static n j(Callable<n> callable) {
        try {
            return (n) io.reactivex.internal.a.b.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            RuntimeException Z = ExceptionHelper.Z(th);
        }
    }

    static n a(f<? super Callable<n>, ? extends n> fVar, Callable<n> callable) {
        return (n) io.reactivex.internal.a.b.requireNonNull(a((f) fVar, (Object) callable), "Scheduler Callable result can't be null");
    }
}
