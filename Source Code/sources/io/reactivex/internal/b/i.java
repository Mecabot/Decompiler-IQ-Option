package io.reactivex.internal.b;

/* compiled from: SimpleQueue */
public interface i<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    T poll();
}
