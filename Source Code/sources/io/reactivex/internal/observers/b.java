package io.reactivex.internal.observers;

/* compiled from: BlockingFirstObserver */
public final class b<T> extends a<T> {
    public void e(T t) {
        if (this.value == null) {
            this.value = t;
            this.d.dispose();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }
}
