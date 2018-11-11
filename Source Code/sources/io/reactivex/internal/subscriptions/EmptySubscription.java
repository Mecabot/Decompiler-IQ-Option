package io.reactivex.internal.subscriptions;

import io.reactivex.internal.b.f;
import org.a.c;

public enum EmptySubscription implements f<Object> {
    INSTANCE;

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public Object poll() {
        return null;
    }

    public int requestFusion(int i) {
        return i & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }

    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    public static void error(Throwable th, c<?> cVar) {
        cVar.a(INSTANCE);
        cVar.onError(th);
    }

    public static void complete(c<?> cVar) {
        cVar.a(INSTANCE);
        cVar.onComplete();
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
