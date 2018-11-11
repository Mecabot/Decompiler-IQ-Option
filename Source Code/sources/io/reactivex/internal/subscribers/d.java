package io.reactivex.internal.subscribers;

import io.reactivex.d.a;

/* compiled from: BlockingFirstSubscriber */
public final class d<T> extends c<T> {
    public void e(T t) {
        if (this.value == null) {
            this.value = t;
            this.s.cancel();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        } else {
            a.onError(th);
        }
        countDown();
    }
}
