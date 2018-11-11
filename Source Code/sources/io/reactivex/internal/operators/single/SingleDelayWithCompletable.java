package io.reactivex.internal.operators.single;

import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.d;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithCompletable<T> extends o<T> {
    final c erz;
    final s<T> source;

    static final class OtherObserver<T> extends AtomicReference<b> implements io.reactivex.b, b {
        private static final long serialVersionUID = -8565274649390031272L;
        final q<? super T> actual;
        final s<T> source;

        OtherObserver(q<? super T> qVar, s<T> sVar) {
            this.actual = qVar;
            this.source = sVar;
        }

        public void d(b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.actual.d(this);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.source.a(new d(this, this.actual));
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }
    }

    public SingleDelayWithCompletable(s<T> sVar, c cVar) {
        this.source = sVar;
        this.erz = cVar;
    }

    protected void b(q<? super T> qVar) {
        this.erz.a(new OtherObserver(qVar, this.source));
    }
}
