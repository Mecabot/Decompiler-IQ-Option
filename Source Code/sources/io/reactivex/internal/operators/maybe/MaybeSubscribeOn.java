package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T> extends a<T, T> {
    final n scheduler;

    static final class a<T> implements Runnable {
        final k<T> err;
        final j<? super T> eru;

        a(j<? super T> jVar, k<T> kVar) {
            this.eru = jVar;
            this.err = kVar;
        }

        public void run() {
            this.err.a(this.eru);
        }
    }

    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<b> implements b, j<T> {
        private static final long serialVersionUID = 8571289934935992137L;
        final j<? super T> actual;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnMaybeObserver(j<? super T> jVar) {
            this.actual = jVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void d(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }

    public MaybeSubscribeOn(k<T> kVar, n nVar) {
        super(kVar);
        this.scheduler = nVar;
    }

    protected void b(j<? super T> jVar) {
        j subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(jVar);
        jVar.d(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.h(this.scheduler.q(new a(subscribeOnMaybeObserver, this.err)));
    }
}
