package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T> extends a<T, T> {
    final n scheduler;

    static final class ObserveOnMaybeObserver<T> extends AtomicReference<b> implements b, j<T>, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final j<? super T> actual;
        Throwable error;
        final n scheduler;
        T value;

        ObserveOnMaybeObserver(j<? super T> jVar, n nVar) {
            this.actual = jVar;
            this.scheduler = nVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void d(b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.d(this);
            }
        }

        public void onSuccess(T t) {
            this.value = t;
            DisposableHelper.replace(this, this.scheduler.q(this));
        }

        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.q(this));
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.q(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.actual.onError(th);
                return;
            }
            Object obj = this.value;
            if (obj != null) {
                this.value = null;
                this.actual.onSuccess(obj);
                return;
            }
            this.actual.onComplete();
        }
    }

    public MaybeObserveOn(k<T> kVar, n nVar) {
        super(kVar);
        this.scheduler = nVar;
    }

    protected void b(j<? super T> jVar) {
        this.err.a(new ObserveOnMaybeObserver(jVar, this.scheduler));
    }
}
