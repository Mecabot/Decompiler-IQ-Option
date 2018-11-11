package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;

/* compiled from: FlowableNever */
public final class n extends e<Object> {
    public static final e<Object> eqU = new n();

    private n() {
    }

    public void a(c<? super Object> cVar) {
        cVar.a(EmptySubscription.INSTANCE);
    }
}
