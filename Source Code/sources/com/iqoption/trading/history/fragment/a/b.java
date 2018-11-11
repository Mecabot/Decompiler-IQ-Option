package com.iqoption.trading.history.fragment.a;

import com.iqoption.dto.Balance;
import java.util.Comparator;

final /* synthetic */ class b implements Comparator {
    static final Comparator $instance = new b();

    private b() {
    }

    public int compare(Object obj, Object obj2) {
        return a.b((Balance) obj, (Balance) obj2);
    }
}
