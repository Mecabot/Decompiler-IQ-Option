package io.reactivex.processors;

import io.reactivex.e;
import io.reactivex.h;

/* compiled from: FlowableProcessor */
public abstract class a<T> extends e<T> implements h<T>, org.a.a<T, T> {
    public final a<T> aXp() {
        if (this instanceof b) {
            return this;
        }
        return new b(this);
    }
}
