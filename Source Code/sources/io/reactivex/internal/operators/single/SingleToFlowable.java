package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.q;
import io.reactivex.s;
import org.a.c;

public final class SingleToFlowable<T> extends e<T> {
    final s<? extends T> source;

    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements q<T> {
        private static final long serialVersionUID = 187782011903685568L;
        b d;

        SingleToFlowableObserver(c<? super T> cVar) {
            super(cVar);
        }

        public void d(b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.a(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void cancel() {
            super.cancel();
            this.d.dispose();
        }
    }

    public SingleToFlowable(s<? extends T> sVar) {
        this.source = sVar;
    }

    public void a(c<? super T> cVar) {
        this.source.a(new SingleToFlowableObserver(cVar));
    }
}
