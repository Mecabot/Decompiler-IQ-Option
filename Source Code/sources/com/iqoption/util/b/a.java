package com.iqoption.util.b;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: ConcurrentMapSet */
public class a<T> {
    private final ConcurrentMap<T, T> Ov = new ConcurrentHashMap();

    public T add(T t) {
        return this.Ov.put(t, t);
    }

    public T remove(T t) {
        return this.Ov.remove(t);
    }

    public T get(T t) {
        return this.Ov.get(t);
    }

    public void clear() {
        this.Ov.clear();
    }

    public void addAll(Collection<? extends T> collection) {
        for (Object add : collection) {
            add(add);
        }
    }

    public Collection<T> aGI() {
        return this.Ov.values();
    }
}
