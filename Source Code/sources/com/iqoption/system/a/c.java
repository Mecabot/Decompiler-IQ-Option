package com.iqoption.system.a;

/* compiled from: EventBusValueEvent */
public class c<T> implements a {
    private T value;

    public c<T> setValue(T t) {
        this.value = t;
        return this;
    }

    public T getValue() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }
}
