package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle<T> extends o<T> {
    final k<T> err;
    final s<? extends T> other;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<b> implements b, j<T> {
        private static final long serialVersionUID = 4603919676453758899L;
        final q<? super T> actual;
        final s<? extends T> other;

        static final class a<T> implements q<T> {
            final q<? super T> actual;
            final AtomicReference<b> eqD;

            a(q<? super T> qVar, AtomicReference<b> atomicReference) {
                this.actual = qVar;
                this.eqD = atomicReference;
            }

            public void d(b bVar) {
                DisposableHelper.setOnce(this.eqD, bVar);
            }

            public void onSuccess(T t) {
                this.actual.onSuccess(t);
            }

            public void onError(Throwable th) {
                this.actual.onError(th);
            }
        }

        SwitchIfEmptyMaybeObserver(q<? super T> qVar, s<? extends T> sVar) {
            this.actual = qVar;
            this.other = sVar;
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
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            b bVar = (b) get();
            if (bVar != DisposableHelper.DISPOSED && compareAndSet(bVar, null)) {
                this.other.a(new a(this.actual, this));
            }
        }
    }

    public MaybeSwitchIfEmptySingle(k<T> kVar, s<? extends T> sVar) {
        this.err = kVar;
        this.other = sVar;
    }

    protected void b(q<? super T> qVar) {
        this.err.a(new SwitchIfEmptyMaybeObserver(qVar, this.other));
    }
}
