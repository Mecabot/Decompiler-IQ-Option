package io.reactivex;

import io.reactivex.c.e;
import io.reactivex.c.f;
import io.reactivex.d.a;
import io.reactivex.internal.a.b;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.flowable.r;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.c;
import io.reactivex.internal.operators.single.d;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* compiled from: Single */
public abstract class o<T> implements s<T> {
    protected abstract void b(q<? super T> qVar);

    public static <T> o<T> a(r<T> rVar) {
        b.requireNonNull(rVar, "source is null");
        return a.b(new SingleCreate(rVar));
    }

    public static <T> o<T> g(Callable<? extends Throwable> callable) {
        b.requireNonNull(callable, "errorSupplier is null");
        return a.b(new io.reactivex.internal.operators.single.b(callable));
    }

    public static <T> o<T> S(Throwable th) {
        b.requireNonNull(th, "error is null");
        return g(io.reactivex.internal.a.a.cd(th));
    }

    public static <T> o<T> h(Callable<? extends T> callable) {
        b.requireNonNull(callable, "callable is null");
        return a.b(new c(callable));
    }

    public static <T> o<T> f(Future<? extends T> future) {
        return f(e.e((Future) future));
    }

    public static <T> o<T> ca(T t) {
        b.requireNonNull(t, "value is null");
        return a.b(new d(t));
    }

    public static <T1, T2, R> o<R> a(s<? extends T1> sVar, s<? extends T2> sVar2, io.reactivex.c.b<? super T1, ? super T2, ? extends R> bVar) {
        b.requireNonNull(sVar, "source1 is null");
        b.requireNonNull(sVar2, "source2 is null");
        return a(io.reactivex.internal.a.a.b(bVar), sVar, sVar2);
    }

    public static <T, R> o<R> a(f<? super Object[], ? extends R> fVar, s<? extends T>... sVarArr) {
        b.requireNonNull(fVar, "zipper is null");
        b.requireNonNull(sVarArr, "sources is null");
        if (sVarArr.length == 0) {
            return S(new NoSuchElementException());
        }
        return a.b(new SingleZipArray(sVarArr, fVar));
    }

    public final o<T> aWh() {
        return a.b(new SingleCache(this));
    }

    public final o<T> d(e<? super T> eVar) {
        b.requireNonNull(eVar, "onSuccess is null");
        return a.b(new io.reactivex.internal.operators.single.a(this, eVar));
    }

    public final <R> o<R> k(f<? super T, ? extends s<? extends R>> fVar) {
        b.requireNonNull(fVar, "mapper is null");
        return a.b(new SingleFlatMap(this, fVar));
    }

    public final <R> i<R> l(f<? super T, ? extends k<? extends R>> fVar) {
        b.requireNonNull(fVar, "mapper is null");
        return a.a(new SingleFlatMapMaybe(this, fVar));
    }

    public final <R> e<R> m(f<? super T, ? extends org.a.b<? extends R>> fVar) {
        return aWk().a((f) fVar);
    }

    public final a i(f<? super T, ? extends c> fVar) {
        b.requireNonNull(fVar, "mapper is null");
        return a.a(new SingleFlatMapCompletable(this, fVar));
    }

    public final T aWf() {
        q cVar = new io.reactivex.internal.observers.c();
        a(cVar);
        return cVar.aWf();
    }

    public final <R> o<R> n(f<? super T, ? extends R> fVar) {
        b.requireNonNull(fVar, "mapper is null");
        return a.b(new io.reactivex.internal.operators.single.e(this, fVar));
    }

    public final o<T> g(n nVar) {
        b.requireNonNull(nVar, "scheduler is null");
        return a.b(new SingleObserveOn(this, nVar));
    }

    public final o<T> o(f<Throwable, ? extends T> fVar) {
        b.requireNonNull(fVar, "resumeFunction is null");
        return a.b(new io.reactivex.internal.operators.single.f(this, fVar, null));
    }

    public final o<T> cb(T t) {
        b.requireNonNull(t, "value is null");
        return a.b(new io.reactivex.internal.operators.single.f(this, null, t));
    }

    public final e<T> g(f<? super e<Object>, ? extends org.a.b<?>> fVar) {
        return aWk().g(fVar);
    }

    public final io.reactivex.disposables.b aVS() {
        return a(io.reactivex.internal.a.a.aWt(), io.reactivex.internal.a.a.eqr);
    }

    public final io.reactivex.disposables.b a(e<? super T> eVar, e<? super Throwable> eVar2) {
        b.requireNonNull(eVar, "onSuccess is null");
        b.requireNonNull(eVar2, "onError is null");
        q consumerSingleObserver = new ConsumerSingleObserver(eVar, eVar2);
        a(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final void a(q<? super T> qVar) {
        b.requireNonNull(qVar, "subscriber is null");
        q a = a.a(this, (q) qVar);
        b.requireNonNull(a, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            new NullPointerException("subscribeActual failed").initCause(th);
        }
    }

    public final o<T> h(n nVar) {
        b.requireNonNull(nVar, "scheduler is null");
        return a.b(new SingleSubscribeOn(this, nVar));
    }

    @Deprecated
    public final a aWi() {
        return a.a(new io.reactivex.internal.operators.completable.d(this));
    }

    public final a aWj() {
        return a.a(new io.reactivex.internal.operators.completable.d(this));
    }

    public final e<T> aWk() {
        if (this instanceof io.reactivex.internal.b.b) {
            return ((io.reactivex.internal.b.b) this).aWu();
        }
        return a.g(new SingleToFlowable(this));
    }

    public final i<T> aWl() {
        if (this instanceof io.reactivex.internal.b.c) {
            return ((io.reactivex.internal.b.c) this).aWv();
        }
        return a.a(new io.reactivex.internal.operators.maybe.d(this));
    }

    private static <T> o<T> f(e<T> eVar) {
        return a.b(new r(eVar, null));
    }
}
