package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends a {
    final n scheduler;
    final c source;

    static final class SubscribeOnObserver extends AtomicReference<b> implements io.reactivex.b, b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final io.reactivex.b actual;
        final c source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(io.reactivex.b bVar, c cVar) {
            this.actual = bVar;
            this.source = cVar;
        }

        public void run() {
            this.source.a(this);
        }

        public void d(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }
    }

    public CompletableSubscribeOn(c cVar, n nVar) {
        this.source = cVar;
        this.scheduler = nVar;
    }

    protected void b(io.reactivex.b bVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(bVar, this.source);
        bVar.d(subscribeOnObserver);
        subscribeOnObserver.task.h(this.scheduler.q(subscribeOnObserver));
    }
}
