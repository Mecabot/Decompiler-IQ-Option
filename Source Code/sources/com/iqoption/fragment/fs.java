package com.iqoption.fragment;

import com.iqoption.core.microservices.f.a.a.a;
import com.iqoption.util.y;
import java.util.Comparator;

final /* synthetic */ class fs implements Comparator {
    static final Comparator $instance = new fs();

    private fs() {
    }

    public int compare(Object obj, Object obj2) {
        return y.g(a.d(((b) obj2).ctC), a.aYn.d(((b) obj).ctC));
    }
}
