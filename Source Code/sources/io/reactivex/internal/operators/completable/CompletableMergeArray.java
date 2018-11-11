package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.b;
import io.reactivex.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends a {
    final c[] sources;

    static final class InnerCompletableObserver extends AtomicInteger implements b {
        private static final long serialVersionUID = -8360547806504310570L;
        final b actual;
        final AtomicBoolean once;
        final io.reactivex.disposables.a set;

        InnerCompletableObserver(b bVar, AtomicBoolean atomicBoolean, io.reactivex.disposables.a aVar, int i) {
            this.actual = bVar;
            this.once = atomicBoolean;
            this.set = aVar;
            lazySet(i);
        }

        public void d(io.reactivex.disposables.b bVar) {
            this.set.e(bVar);
        }

        public void onError(Throwable th) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th);
            } else {
                io.reactivex.d.a.onError(th);
            }
        }

        public void onComplete() {
            if (decrementAndGet() == 0 && this.once.compareAndSet(false, true)) {
                this.actual.onComplete();
            }
        }
    }

    public CompletableMergeArray(c[] cVarArr) {
        this.sources = cVarArr;
    }

    public void b(b bVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(bVar, new AtomicBoolean(), aVar, this.sources.length + 1);
        bVar.d(aVar);
        c[] cVarArr = this.sources;
        int length = cVarArr.length;
        int i = 0;
        while (i < length) {
            c cVar = cVarArr[i];
            if (!aVar.isDisposed()) {
                if (cVar == null) {
                    aVar.dispose();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                cVar.a(innerCompletableObserver);
                i++;
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }
}
