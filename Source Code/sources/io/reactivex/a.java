package io.reactivex;

import io.reactivex.internal.a.b;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.c;
import io.reactivex.internal.operators.completable.e;
import io.reactivex.internal.operators.completable.f;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import java.util.concurrent.Future;

/* compiled from: Completable */
public abstract class a implements c {
    protected abstract void b(b bVar);

    public static a aVR() {
        return io.reactivex.d.a.a(io.reactivex.internal.operators.completable.a.eqE);
    }

    public static a a(c... cVarArr) {
        b.requireNonNull(cVarArr, "sources is null");
        if (cVarArr.length == 0) {
            return aVR();
        }
        if (cVarArr.length == 1) {
            return a(cVarArr[0]);
        }
        return io.reactivex.d.a.a(new CompletableConcatArray(cVarArr));
    }

    public static a b(io.reactivex.c.a aVar) {
        b.requireNonNull(aVar, "run is null");
        return io.reactivex.d.a.a(new io.reactivex.internal.operators.completable.b(aVar));
    }

    public static a d(Future<?> future) {
        b.requireNonNull(future, "future is null");
        return b(io.reactivex.internal.a.a.g(future));
    }

    public static a p(Runnable runnable) {
        b.requireNonNull(runnable, "run is null");
        return io.reactivex.d.a.a(new c(runnable));
    }

    public static a b(c... cVarArr) {
        b.requireNonNull(cVarArr, "sources is null");
        if (cVarArr.length == 0) {
            return aVR();
        }
        if (cVarArr.length == 1) {
            return a(cVarArr[0]);
        }
        return io.reactivex.d.a.a(new CompletableMergeArray(cVarArr));
    }

    private static NullPointerException Q(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static a a(c cVar) {
        b.requireNonNull(cVar, "source is null");
        if (cVar instanceof a) {
            return io.reactivex.d.a.a((a) cVar);
        }
        return io.reactivex.d.a.a(new e(cVar));
    }

    public final <T> o<T> a(s<T> sVar) {
        b.requireNonNull(sVar, "next is null");
        return io.reactivex.d.a.b(new SingleDelayWithCompletable(sVar, this));
    }

    public final a b(c cVar) {
        return c(cVar);
    }

    public final a c(c cVar) {
        b.requireNonNull(cVar, "other is null");
        return a(this, cVar);
    }

    public final a c(io.reactivex.c.a aVar) {
        return a(io.reactivex.internal.a.a.aWt(), io.reactivex.internal.a.a.aWt(), aVar, io.reactivex.internal.a.a.aBl, io.reactivex.internal.a.a.aBl, io.reactivex.internal.a.a.aBl);
    }

    private a a(io.reactivex.c.e<? super io.reactivex.disposables.b> eVar, io.reactivex.c.e<? super Throwable> eVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2, io.reactivex.c.a aVar3, io.reactivex.c.a aVar4) {
        b.requireNonNull(eVar, "onSubscribe is null");
        b.requireNonNull(eVar2, "onError is null");
        b.requireNonNull(aVar, "onComplete is null");
        b.requireNonNull(aVar2, "onTerminate is null");
        b.requireNonNull(aVar3, "onAfterTerminate is null");
        b.requireNonNull(aVar4, "onDispose is null");
        return io.reactivex.d.a.a(new f(this, eVar, eVar2, aVar, aVar2, aVar3, aVar4));
    }

    public final a d(c cVar) {
        b.requireNonNull(cVar, "other is null");
        return b(this, cVar);
    }

    public final a a(n nVar) {
        b.requireNonNull(nVar, "scheduler is null");
        return io.reactivex.d.a.a(new CompletableObserveOn(this, nVar));
    }

    public final io.reactivex.disposables.b aVS() {
        b emptyCompletableObserver = new EmptyCompletableObserver();
        a(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final void a(b bVar) {
        NullPointerException e;
        b.requireNonNull(bVar, "s is null");
        try {
            b(io.reactivex.d.a.a(this, bVar));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            io.reactivex.d.a.onError(th);
            e2 = Q(th);
        }
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.a aVar, io.reactivex.c.e<? super Throwable> eVar) {
        b.requireNonNull(eVar, "onError is null");
        b.requireNonNull(aVar, "onComplete is null");
        b callbackCompletableObserver = new CallbackCompletableObserver(eVar, aVar);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final a b(n nVar) {
        b.requireNonNull(nVar, "scheduler is null");
        return io.reactivex.d.a.a(new CompletableSubscribeOn(this, nVar));
    }
}
