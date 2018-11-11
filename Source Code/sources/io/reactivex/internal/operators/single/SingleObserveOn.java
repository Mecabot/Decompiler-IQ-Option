package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends o<T> {
    final n scheduler;
    final s<T> source;

    static final class ObserveOnSingleObserver<T> extends AtomicReference<b> implements b, q<T>, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final q<? super T> actual;
        Throwable error;
        final n scheduler;
        T value;

        ObserveOnSingleObserver(q<? super T> qVar, n nVar) {
            this.actual = qVar;
            this.scheduler = nVar;
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

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
            } else {
                this.actual.onSuccess(this.value);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }
    }

    public SingleObserveOn(s<T> sVar, n nVar) {
        this.source = sVar;
        this.scheduler = nVar;
    }

    protected void b(q<? super T> qVar) {
        this.source.a(new ObserveOnSingleObserver(qVar, this.scheduler));
    }
}
