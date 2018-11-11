package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.b.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.a.c;

/* compiled from: FlowableEmpty */
public final class f extends e<Object> implements g<Object> {
    public static final e<Object> eqU = new f();

    public Object call() {
        return null;
    }

    private f() {
    }

    public void a(c<? super Object> cVar) {
        EmptySubscription.complete(cVar);
    }
}
