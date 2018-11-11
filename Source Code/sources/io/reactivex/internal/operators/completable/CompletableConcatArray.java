package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.b;
import io.reactivex.c;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends a {
    final c[] sources;

    static final class ConcatInnerObserver extends AtomicInteger implements b {
        private static final long serialVersionUID = -7965400327305809232L;
        final b actual;
        int index;
        final SequentialDisposable sd = new SequentialDisposable();
        final c[] sources;

        ConcatInnerObserver(b bVar, c[] cVarArr) {
            this.actual = bVar;
            this.sources = cVarArr;
        }

        public void d(io.reactivex.disposables.b bVar) {
            this.sd.h(bVar);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            next();
        }

        void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                c[] cVarArr = this.sources;
                while (!this.sd.isDisposed()) {
                    int i = this.index;
                    this.index = i + 1;
                    if (i == cVarArr.length) {
                        this.actual.onComplete();
                        return;
                    }
                    cVarArr[i].a(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public CompletableConcatArray(c[] cVarArr) {
        this.sources = cVarArr;
    }

    public void b(b bVar) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(bVar, this.sources);
        bVar.d(concatInnerObserver.sd);
        concatInnerObserver.next();
    }
}
