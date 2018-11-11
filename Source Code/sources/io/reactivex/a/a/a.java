package io.reactivex.a.a;

import io.reactivex.c.f;
import io.reactivex.n;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins */
public final class a {
    private static volatile f<Callable<n>, n> eqg;
    private static volatile f<n, n> eqh;

    public static n i(Callable<n> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        f fVar = eqg;
        if (fVar == null) {
            return j(callable);
        }
        return a(fVar, (Callable) callable);
    }

    public static n i(n nVar) {
        if (nVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        f fVar = eqh;
        if (fVar == null) {
            return nVar;
        }
        return (n) a(fVar, (Object) nVar);
    }

    static n j(Callable<n> callable) {
        try {
            n nVar = (n) callable.call();
            if (nVar != null) {
                return nVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            RuntimeException g = io.reactivex.exceptions.a.g(th);
        }
    }

    static n a(f<Callable<n>, n> fVar, Callable<n> callable) {
        n nVar = (n) a((f) fVar, (Object) callable);
        if (nVar != null) {
            return nVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R a(f<T, R> fVar, T t) {
        try {
            return fVar.apply(t);
        } catch (Throwable th) {
            RuntimeException g = io.reactivex.exceptions.a.g(th);
        }
    }
}
