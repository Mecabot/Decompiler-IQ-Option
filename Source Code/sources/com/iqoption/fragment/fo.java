package com.iqoption.fragment;

import com.iqoption.core.microservices.f.a.a.a;
import com.iqoption.util.au;
import com.iqoption.util.y;
import java.util.Comparator;

final /* synthetic */ class fo implements Comparator {
    static final Comparator $instance = new fo();

    private fo() {
    }

    public int compare(Object obj, Object obj2) {
        return y.g(au.h(a.c(((b) obj).ctC), a.a(((b) obj).ctC)), au.h(a.c(((b) obj2).ctC), a.a(((b) obj2).ctC)));
    }
}
