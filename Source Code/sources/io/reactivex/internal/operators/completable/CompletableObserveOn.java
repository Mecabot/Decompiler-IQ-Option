package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.n;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends a {
    final n scheduler;
    final c source;

    static final class ObserveOnCompletableObserver extends AtomicReference<b> implements io.reactivex.b, b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final io.reactivex.b actual;
        Throwable error;
        final n scheduler;

        ObserveOnCompletableObserver(io.reactivex.b bVar, n nVar) {
            this.actual = bVar;
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
            this.actual.onComplete();
        }
    }

    public CompletableObserveOn(c cVar, n nVar) {
        this.source = cVar;
        this.scheduler = nVar;
    }

    protected void b(io.reactivex.b bVar) {
        this.source.a(new ObserveOnCompletableObserver(bVar, this.scheduler));
    }
}
