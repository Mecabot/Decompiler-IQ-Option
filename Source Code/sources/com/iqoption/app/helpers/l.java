package com.iqoption.app.helpers;

import com.iqoption.core.microservices.tradingengine.response.active.a;
import java.util.Comparator;

final /* synthetic */ class l implements Comparator {
    private final long alZ;

    l(long j) {
        this.alZ = j;
    }

    public int compare(Object obj, Object obj2) {
        return a.a(this.alZ, (a) obj, (a) obj2);
    }
}
