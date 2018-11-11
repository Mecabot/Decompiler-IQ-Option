package io.reactivex;

import io.reactivex.c.f;
import io.reactivex.d.a;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.b;
import io.reactivex.internal.operators.maybe.c;
import io.reactivex.internal.operators.maybe.e;
import java.util.concurrent.Callable;

/* compiled from: Maybe */
public abstract class i<T> implements k<T> {
    protected abstract void b(j<? super T> jVar);

    public static <T> i<T> aWe() {
        return a.a(b.ers);
    }

    public static <T> i<T> f(Callable<? extends T> callable) {
        io.reactivex.internal.a.b.requireNonNull(callable, "callable is null");
        return a.a(new c(callable));
    }

    public static <T> i<T> bZ(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "item is null");
        return a.a(new e(t));
    }

    public final T aWf() {
        Object cVar = new io.reactivex.internal.observers.c();
        a(cVar);
        return cVar.aWf();
    }

    public final <R> i<R> h(f<? super T, ? extends k<? extends R>> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        return a.a(new MaybeFlatten(this, fVar));
    }

    public final a i(f<? super T, ? extends c> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        return a.a(new MaybeFlatMapCompletable(this, fVar));
    }

    public final <R> i<R> j(f<? super T, ? extends R> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        return a.a(new io.reactivex.internal.operators.maybe.f(this, fVar));
    }

    public final i<T> e(n nVar) {
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.a(new MaybeObserveOn(this, nVar));
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, io.reactivex.internal.a.a.aBl);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar) {
        io.reactivex.internal.a.b.requireNonNull(eVar, "onSuccess is null");
        io.reactivex.internal.a.b.requireNonNull(eVar2, "onError is null");
        io.reactivex.internal.a.b.requireNonNull(aVar, "onComplete is null");
        return (io.reactivex.disposables.b) c(new MaybeCallbackObserver(eVar, eVar2, aVar));
    }

    public final void a(j<? super T> jVar) {
        io.reactivex.internal.a.b.requireNonNull(jVar, "observer is null");
        j a = a.a(this, (j) jVar);
        io.reactivex.internal.a.b.requireNonNull(a, "observer returned by the RxJavaPlugins hook is null");
        try {
            b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            new NullPointerException("subscribeActual failed").initCause(th);
        }
    }

    public final i<T> f(n nVar) {
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.a(new MaybeSubscribeOn(this, nVar));
    }

    public final <E extends j<? super T>> E c(E e) {
        a(e);
        return e;
    }

    public final o<T> b(s<? extends T> sVar) {
        io.reactivex.internal.a.b.requireNonNull(sVar, "other is null");
        return a.b(new MaybeSwitchIfEmptySingle(this, sVar));
    }
}
