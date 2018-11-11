package io.reactivex.subjects;

import io.reactivex.l;
import io.reactivex.m;

/* compiled from: Subject */
public abstract class c<T> extends l<T> implements m<T> {
    public abstract boolean aXx();

    public abstract boolean aXy();

    public final c<T> aXB() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
