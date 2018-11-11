package io.reactivex.internal.operators.flowable;

import io.reactivex.c.f;
import io.reactivex.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import org.a.b;
import org.a.c;

/* compiled from: FlowableScalarXMap */
public final class p {

    /* compiled from: FlowableScalarXMap */
    static final class a<T, R> extends e<R> {
        final f<? super T, ? extends b<? extends R>> mapper;
        final T value;

        a(T t, f<? super T, ? extends b<? extends R>> fVar) {
            this.value = t;
            this.mapper = fVar;
        }

        public void a(c<? super R> cVar) {
            try {
                b bVar = (b) io.reactivex.internal.a.b.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call == null) {
                            EmptySubscription.complete(cVar);
                            return;
                        }
                        cVar.a(new ScalarSubscription(cVar, call));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        EmptySubscription.error(th, cVar);
                        return;
                    }
                }
                bVar.b(cVar);
            } catch (Throwable th2) {
                EmptySubscription.error(th2, cVar);
            }
        }
    }

    public static <T, R> boolean a(b<T> bVar, c<? super R> cVar, f<? super T, ? extends b<? extends R>> fVar) {
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) bVar).call();
            if (call == null) {
                EmptySubscription.complete(cVar);
                return true;
            }
            try {
                b bVar2 = (b) io.reactivex.internal.a.b.requireNonNull(fVar.apply(call), "The mapper returned a null Publisher");
                if (bVar2 instanceof Callable) {
                    try {
                        call = ((Callable) bVar2).call();
                        if (call == null) {
                            EmptySubscription.complete(cVar);
                            return true;
                        }
                        cVar.a(new ScalarSubscription(cVar, call));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.V(th);
                        EmptySubscription.error(th, cVar);
                        return true;
                    }
                }
                bVar2.b(cVar);
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.V(th2);
                EmptySubscription.error(th2, cVar);
                return true;
            }
        } catch (Throwable th22) {
            io.reactivex.exceptions.a.V(th22);
            EmptySubscription.error(th22, cVar);
            return true;
        }
    }

    public static <T, U> e<U> a(T t, f<? super T, ? extends b<? extends U>> fVar) {
        return io.reactivex.d.a.g(new a(t, fVar));
    }
}
