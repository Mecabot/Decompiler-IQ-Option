package io.reactivex;

import io.reactivex.d.a;
import io.reactivex.internal.observers.b;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.flowable.j;
import java.util.NoSuchElementException;

/* compiled from: Observable */
public abstract class l<T> {
    protected abstract void b(m<? super T> mVar);

    public final T aVW() {
        m bVar = new b();
        a(bVar);
        T aWf = bVar.aWf();
        if (aWf != null) {
            return aWf;
        }
        throw new NoSuchElementException();
    }

    public final void a(m<? super T> mVar) {
        io.reactivex.internal.a.b.requireNonNull(mVar, "observer is null");
        try {
            m a = a.a(this, (m) mVar);
            io.reactivex.internal.a.b.requireNonNull(a, "Plugin returned null Observer");
            b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.V(th);
            a.onError(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }

    public final e<T> a(BackpressureStrategy backpressureStrategy) {
        e<T> jVar = new j(this);
        switch (backpressureStrategy) {
            case DROP:
                return jVar.aWa();
            case LATEST:
                return jVar.aWb();
            case MISSING:
                return jVar;
            case ERROR:
                return a.g(new FlowableOnBackpressureError(jVar));
            default:
                return jVar.aVZ();
        }
    }
}
