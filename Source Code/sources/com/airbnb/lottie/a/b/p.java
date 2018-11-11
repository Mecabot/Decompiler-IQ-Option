package com.airbnb.lottie.a.b;

import com.airbnb.lottie.e.a;
import com.airbnb.lottie.e.b;
import com.airbnb.lottie.e.c;
import java.util.Collections;

/* compiled from: ValueCallbackKeyframeAnimation */
public class p<K, A> extends a<K, A> {
    private final b<A> lP = new b();

    float dH() {
        return 1.0f;
    }

    public p(c<A> cVar) {
        super(Collections.emptyList());
        a(cVar);
    }

    public void notifyListeners() {
        if (this.lu != null) {
            super.notifyListeners();
        }
    }

    public A getValue() {
        return this.lu.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    A a(a<K> aVar, float f) {
        return getValue();
    }
}
