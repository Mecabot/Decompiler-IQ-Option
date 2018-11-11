package io.reactivex;

import io.reactivex.c.f;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.c.i;
import io.reactivex.c.j;
import io.reactivex.d.a;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.k;
import io.reactivex.internal.operators.flowable.l;
import io.reactivex.internal.operators.flowable.m;
import io.reactivex.internal.operators.flowable.n;
import io.reactivex.internal.operators.flowable.o;
import io.reactivex.internal.operators.flowable.p;
import io.reactivex.internal.operators.flowable.q;
import io.reactivex.internal.operators.flowable.s;
import io.reactivex.internal.operators.flowable.t;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.subscribers.d;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.a.b;
import org.a.c;

/* compiled from: Flowable */
public abstract class e<T> implements b<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    protected abstract void a(c<? super T> cVar);

    public static int aVT() {
        return BUFFER_SIZE;
    }

    public static <T, R> e<R> a(f<? super Object[], ? extends R> fVar, b<? extends T>... bVarArr) {
        return a((b[]) bVarArr, (f) fVar, aVT());
    }

    public static <T, R> e<R> a(b<? extends T>[] bVarArr, f<? super Object[], ? extends R> fVar, int i) {
        io.reactivex.internal.a.b.requireNonNull(bVarArr, "sources is null");
        if (bVarArr.length == 0) {
            return aVU();
        }
        io.reactivex.internal.a.b.requireNonNull(fVar, "combiner is null");
        io.reactivex.internal.a.b.n(i, "bufferSize");
        return a.g(new FlowableCombineLatest((b[]) bVarArr, (f) fVar, i, false));
    }

    public static <T, R> e<R> a(Iterable<? extends b<? extends T>> iterable, f<? super Object[], ? extends R> fVar) {
        return a((Iterable) iterable, (f) fVar, aVT());
    }

    public static <T, R> e<R> a(Iterable<? extends b<? extends T>> iterable, f<? super Object[], ? extends R> fVar, int i) {
        io.reactivex.internal.a.b.requireNonNull(iterable, "sources is null");
        io.reactivex.internal.a.b.requireNonNull(fVar, "combiner is null");
        io.reactivex.internal.a.b.n(i, "bufferSize");
        return a.g(new FlowableCombineLatest((Iterable) iterable, (f) fVar, i, false));
    }

    public static <T1, T2, R> e<R> a(b<? extends T1> bVar, b<? extends T2> bVar2, io.reactivex.c.b<? super T1, ? super T2, ? extends R> bVar3) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        return a(io.reactivex.internal.a.a.b(bVar3), bVar, bVar2);
    }

    public static <T1, T2, T3, R> e<R> a(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, g<? super T1, ? super T2, ? super T3, ? extends R> gVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar3, "source3 is null");
        return a(io.reactivex.internal.a.a.a((g) gVar), bVar, bVar2, bVar3);
    }

    public static <T1, T2, T3, T4, R> e<R> a(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, b<? extends T4> bVar4, h<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> hVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar3, "source3 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar4, "source4 is null");
        return a(io.reactivex.internal.a.a.a((h) hVar), bVar, bVar2, bVar3, bVar4);
    }

    public static <T1, T2, T3, T4, T5, R> e<R> a(b<? extends T1> bVar, b<? extends T2> bVar2, b<? extends T3> bVar3, b<? extends T4> bVar4, b<? extends T5> bVar5, i<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> iVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar3, "source3 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar4, "source4 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar5, "source5 is null");
        return a(io.reactivex.internal.a.a.a((i) iVar), bVar, bVar2, bVar3, bVar4, bVar5);
    }

    public static <T> e<T> a(b<? extends T> bVar, b<? extends T> bVar2) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        return a(bVar, bVar2);
    }

    public static <T> e<T> a(b<? extends T>... bVarArr) {
        if (bVarArr.length == 0) {
            return aVU();
        }
        if (bVarArr.length == 1) {
            return b(bVarArr[0]);
        }
        return a.g(new FlowableConcatArray(bVarArr, false));
    }

    public static <T> e<T> a(g<T> gVar, BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.a.b.requireNonNull(gVar, "source is null");
        io.reactivex.internal.a.b.requireNonNull(backpressureStrategy, "mode is null");
        return a.g(new FlowableCreate(gVar, backpressureStrategy));
    }

    public static <T> e<T> aVU() {
        return a.g(io.reactivex.internal.operators.flowable.f.eqU);
    }

    public static <T> e<T> e(Callable<? extends Throwable> callable) {
        io.reactivex.internal.a.b.requireNonNull(callable, "errorSupplier is null");
        return a.g(new io.reactivex.internal.operators.flowable.g(callable));
    }

    public static <T> e<T> R(Throwable th) {
        io.reactivex.internal.a.b.requireNonNull(th, "throwable is null");
        return e(io.reactivex.internal.a.a.cd(th));
    }

    public static <T> e<T> t(T... tArr) {
        io.reactivex.internal.a.b.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return aVU();
        }
        if (tArr.length == 1) {
            return bW(tArr[0]);
        }
        return a.g(new FlowableFromArray(tArr));
    }

    public static <T> e<T> e(Future<? extends T> future) {
        io.reactivex.internal.a.b.requireNonNull(future, "future is null");
        return a.g(new io.reactivex.internal.operators.flowable.i(future, 0, null));
    }

    public static <T> e<T> J(Iterable<? extends T> iterable) {
        io.reactivex.internal.a.b.requireNonNull(iterable, "source is null");
        return a.g(new FlowableFromIterable(iterable));
    }

    public static <T> e<T> b(b<? extends T> bVar) {
        if (bVar instanceof e) {
            return a.g((e) bVar);
        }
        io.reactivex.internal.a.b.requireNonNull(bVar, "publisher is null");
        return a.g(new k(bVar));
    }

    public static e<Long> a(long j, long j2, TimeUnit timeUnit) {
        return a(j, j2, timeUnit, io.reactivex.e.a.aXs());
    }

    public static e<Long> a(long j, long j2, TimeUnit timeUnit, n nVar) {
        io.reactivex.internal.a.b.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.g(new FlowableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, nVar));
    }

    public static <T> e<T> bW(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "item is null");
        return a.g(new l(t));
    }

    public static <T> e<T> K(Iterable<? extends b<? extends T>> iterable) {
        return J(iterable).a(io.reactivex.internal.a.a.aWs());
    }

    public static <T> e<T> b(b<? extends T> bVar, b<? extends T> bVar2) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        return t(bVar, bVar2).a(io.reactivex.internal.a.a.aWs(), false, 2);
    }

    public static <T> e<T> a(b<? extends T> bVar, b<? extends T> bVar2, b<? extends T> bVar3) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "source1 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar2, "source2 is null");
        io.reactivex.internal.a.b.requireNonNull(bVar3, "source3 is null");
        return t(bVar, bVar2, bVar3).a(io.reactivex.internal.a.a.aWs(), false, 3);
    }

    public static <T> e<T> aVV() {
        return a.g(n.eqU);
    }

    public static e<Long> e(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, io.reactivex.e.a.aXs());
    }

    public static e<Long> a(long j, TimeUnit timeUnit, n nVar) {
        io.reactivex.internal.a.b.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.g(new FlowableTimer(Math.max(0, j), timeUnit, nVar));
    }

    public final T aVW() {
        h dVar = new d();
        a(dVar);
        T aWf = dVar.aWf();
        if (aWf != null) {
            return aWf;
        }
        throw new NoSuchElementException();
    }

    public final e<T> c(b<? extends T> bVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "other is null");
        return a((b) this, (b) bVar);
    }

    public final e<T> f(long j, TimeUnit timeUnit) {
        return b(j, timeUnit, io.reactivex.e.a.aXs());
    }

    public final e<T> b(long j, TimeUnit timeUnit, n nVar) {
        io.reactivex.internal.a.b.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.g(new FlowableDebounceTimed(this, j, timeUnit, nVar));
    }

    public final e<T> bX(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "item is null");
        return e(bW(t));
    }

    public final e<T> d(io.reactivex.c.a aVar) {
        io.reactivex.internal.a.b.requireNonNull(aVar, "onFinally is null");
        return a.g(new FlowableDoFinally(this, aVar));
    }

    public final e<T> e(io.reactivex.c.a aVar) {
        return a(io.reactivex.internal.a.a.aWt(), io.reactivex.internal.a.a.eqs, aVar);
    }

    private e<T> a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        io.reactivex.internal.a.b.requireNonNull(eVar, "onNext is null");
        io.reactivex.internal.a.b.requireNonNull(eVar2, "onError is null");
        io.reactivex.internal.a.b.requireNonNull(aVar, "onComplete is null");
        io.reactivex.internal.a.b.requireNonNull(aVar2, "onAfterTerminate is null");
        return a.g(new io.reactivex.internal.operators.flowable.b(this, eVar, eVar2, aVar, aVar2));
    }

    public final e<T> a(io.reactivex.c.e<? super org.a.d> eVar, j jVar, io.reactivex.c.a aVar) {
        io.reactivex.internal.a.b.requireNonNull(eVar, "onSubscribe is null");
        io.reactivex.internal.a.b.requireNonNull(jVar, "onRequest is null");
        io.reactivex.internal.a.b.requireNonNull(aVar, "onCancel is null");
        return a.g(new io.reactivex.internal.operators.flowable.c(this, eVar, jVar, aVar));
    }

    public final e<T> a(io.reactivex.c.e<? super T> eVar) {
        return a((io.reactivex.c.e) eVar, io.reactivex.internal.a.a.aWt(), io.reactivex.internal.a.a.aBl, io.reactivex.internal.a.a.aBl);
    }

    public final e<T> b(io.reactivex.c.e<? super org.a.d> eVar) {
        return a((io.reactivex.c.e) eVar, io.reactivex.internal.a.a.eqs, io.reactivex.internal.a.a.aBl);
    }

    public final i<T> cN(long j) {
        if (j >= 0) {
            return a.a(new io.reactivex.internal.operators.flowable.d(this, j));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final o<T> cO(long j) {
        if (j >= 0) {
            return a.b(new io.reactivex.internal.operators.flowable.e(this, j, null));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final e<T> a(io.reactivex.c.k<? super T> kVar) {
        io.reactivex.internal.a.b.requireNonNull(kVar, "predicate is null");
        return a.g(new io.reactivex.internal.operators.flowable.h(this, kVar));
    }

    public final i<T> aVX() {
        return cN(0);
    }

    public final o<T> aVY() {
        return cO(0);
    }

    public final <R> e<R> a(f<? super T, ? extends b<? extends R>> fVar) {
        return a((f) fVar, false, aVT(), aVT());
    }

    public final <R> e<R> a(f<? super T, ? extends b<? extends R>> fVar, boolean z, int i) {
        return a((f) fVar, z, i, aVT());
    }

    public final <R> e<R> a(f<? super T, ? extends b<? extends R>> fVar, boolean z, int i, int i2) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        io.reactivex.internal.a.b.n(i, "maxConcurrency");
        io.reactivex.internal.a.b.n(i2, "bufferSize");
        if (!(this instanceof io.reactivex.internal.b.g)) {
            return a.g(new FlowableFlatMap(this, fVar, z, i, i2));
        }
        Object call = ((io.reactivex.internal.b.g) this).call();
        if (call == null) {
            return aVU();
        }
        return p.a(call, fVar);
    }

    public final <R> e<R> b(f<? super T, ? extends k<? extends R>> fVar) {
        return b((f) fVar, false, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public final <R> e<R> b(f<? super T, ? extends k<? extends R>> fVar, boolean z, int i) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        io.reactivex.internal.a.b.n(i, "maxConcurrency");
        return a.g(new FlowableFlatMapMaybe(this, fVar, z, i));
    }

    public final <R> e<R> c(f<? super T, ? extends s<? extends R>> fVar) {
        return c((f) fVar, false, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public final <R> e<R> c(f<? super T, ? extends s<? extends R>> fVar, boolean z, int i) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        io.reactivex.internal.a.b.n(i, "maxConcurrency");
        return a.g(new FlowableFlatMapSingle(this, fVar, z, i));
    }

    public final <R> e<R> d(f<? super T, ? extends R> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "mapper is null");
        return a.g(new m(this, fVar));
    }

    public final e<T> d(b<? extends T> bVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "other is null");
        return b(this, bVar);
    }

    public final e<T> c(n nVar) {
        return a(nVar, false, aVT());
    }

    public final e<T> a(n nVar, boolean z, int i) {
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        io.reactivex.internal.a.b.n(i, "bufferSize");
        return a.g(new FlowableObserveOn(this, nVar, z, i));
    }

    public final e<T> aVZ() {
        return c(aVT(), false, true);
    }

    public final e<T> c(int i, boolean z, boolean z2) {
        io.reactivex.internal.a.b.n(i, "bufferSize");
        return a.g(new FlowableOnBackpressureBuffer(this, i, z2, z, io.reactivex.internal.a.a.aBl));
    }

    public final e<T> aWa() {
        return a.g(new FlowableOnBackpressureDrop(this));
    }

    public final e<T> aWb() {
        return a.g(new FlowableOnBackpressureLatest(this));
    }

    public final e<T> e(f<? super Throwable, ? extends b<? extends T>> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "resumeFunction is null");
        return a.g(new o(this, fVar, false));
    }

    public final e<T> f(f<? super Throwable, ? extends T> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "valueSupplier is null");
        return a.g(new FlowableOnErrorReturn(this, fVar));
    }

    public final e<T> bY(T t) {
        io.reactivex.internal.a.b.requireNonNull(t, "item is null");
        return f(io.reactivex.internal.a.a.ce(t));
    }

    public final io.reactivex.b.a<T> aWc() {
        return jc(aVT());
    }

    public final io.reactivex.b.a<T> jc(int i) {
        io.reactivex.internal.a.b.n(i, "bufferSize");
        return FlowablePublish.a(this, i);
    }

    public final e<T> g(f<? super e<Object>, ? extends b<?>> fVar) {
        io.reactivex.internal.a.b.requireNonNull(fVar, "handler is null");
        return a.g(new FlowableRepeatWhen(this, fVar));
    }

    public final e<T> a(long j, TimeUnit timeUnit, boolean z) {
        return a(j, timeUnit, io.reactivex.e.a.aXs(), z);
    }

    public final e<T> a(long j, TimeUnit timeUnit, n nVar, boolean z) {
        io.reactivex.internal.a.b.requireNonNull(timeUnit, "unit is null");
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.g(new FlowableSampleTimed(this, j, timeUnit, nVar, z));
    }

    public final e<T> a(io.reactivex.c.b<T, T, T> bVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "accumulator is null");
        return a.g(new q(this, bVar));
    }

    public final e<T> aWd() {
        return aWc().aWr();
    }

    public final e<T> cP(long j) {
        if (j <= 0) {
            return a.g(this);
        }
        return a.g(new s(this, j));
    }

    public final io.reactivex.disposables.b c(io.reactivex.c.e<? super T> eVar) {
        return a((io.reactivex.c.e) eVar, io.reactivex.internal.a.a.eqr, io.reactivex.internal.a.a.aBl, RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2) {
        return a((io.reactivex.c.e) eVar, (io.reactivex.c.e) eVar2, io.reactivex.internal.a.a.aBl, RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar) {
        return a((io.reactivex.c.e) eVar, (io.reactivex.c.e) eVar2, aVar, RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.e<? super T> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.e<? super org.a.d> eVar3) {
        io.reactivex.internal.a.b.requireNonNull(eVar, "onNext is null");
        io.reactivex.internal.a.b.requireNonNull(eVar2, "onError is null");
        io.reactivex.internal.a.b.requireNonNull(aVar, "onComplete is null");
        io.reactivex.internal.a.b.requireNonNull(eVar3, "onSubscribe is null");
        h lambdaSubscriber = new LambdaSubscriber(eVar, eVar2, aVar, eVar3);
        a(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void b(c<? super T> cVar) {
        if (cVar instanceof h) {
            a((h) cVar);
            return;
        }
        io.reactivex.internal.a.b.requireNonNull(cVar, "s is null");
        a(new StrictSubscriber(cVar));
    }

    public final void a(h<? super T> hVar) {
        io.reactivex.internal.a.b.requireNonNull(hVar, "s is null");
        try {
            c a = a.a(this, (c) hVar);
            io.reactivex.internal.a.b.requireNonNull(a, "Plugin returned null Subscriber");
            a(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            a.onError(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }

    public final e<T> d(n nVar) {
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a(nVar, !(this instanceof FlowableCreate));
    }

    public final e<T> a(n nVar, boolean z) {
        io.reactivex.internal.a.b.requireNonNull(nVar, "scheduler is null");
        return a.g(new FlowableSubscribeOn(this, nVar, z));
    }

    public final e<T> e(b<? extends T> bVar) {
        io.reactivex.internal.a.b.requireNonNull(bVar, "other is null");
        return a.g(new t(this, bVar));
    }

    public final e<T> cQ(long j) {
        if (j >= 0) {
            return a.g(new FlowableTake(this, j));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
