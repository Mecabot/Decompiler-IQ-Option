package com.iqoption.fragment;

import com.google.common.primitives.Ints;
import com.iqoption.core.microservices.tradingengine.response.active.a;
import java.util.Comparator;

final /* synthetic */ class fi implements Comparator {
    static final Comparator $instance = new fi();

    private fi() {
    }

    public int compare(Object obj, Object obj2) {
        return Ints.compare(((a) obj).Xi().intValue(), ((a) obj2).Xi().intValue());
    }
}
