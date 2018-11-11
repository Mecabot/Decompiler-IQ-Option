package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.n;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends o<T> {
    final n scheduler;
    final s<? extends T> source;

    static final class SubscribeOnObserver<T> extends AtomicReference<b> implements b, q<T>, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final q<? super T> actual;
        final s<? extends T> source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(q<? super T> qVar, s<? extends T> sVar) {
            this.actual = qVar;
            this.source = sVar;
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

        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) get());
        }

        public void run() {
            this.source.a(this);
        }
    }

    public SingleSubscribeOn(s<? extends T> sVar, n nVar) {
        this.source = sVar;
        this.scheduler = nVar;
    }

    protected void b(q<? super T> qVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(qVar, this.source);
        qVar.d(subscribeOnObserver);
        subscribeOnObserver.task.h(this.scheduler.q(subscribeOnObserver));
    }
}
