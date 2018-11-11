package com.google.common.base;

import java.io.Serializable;

public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract <V> Optional<V> a(d<? super T, V> dVar);

    public abstract T get();

    public abstract boolean isPresent();

    public abstract T pq();

    public abstract T w(T t);

    public static <T> Optional<T> pN() {
        return Absent.pp();
    }

    public static <T> Optional<T> E(T t) {
        return new Present(i.checkNotNull(t));
    }

    public static <T> Optional<T> F(T t) {
        return t == null ? pN() : new Present(t);
    }

    Optional() {
    }
}
