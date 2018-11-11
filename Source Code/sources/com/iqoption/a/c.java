package com.iqoption.a;

import com.iqoption.dto.Balance;
import java.util.Comparator;

final /* synthetic */ class c implements Comparator {
    private final b agy;

    c(b bVar) {
        this.agy = bVar;
    }

    public int compare(Object obj, Object obj2) {
        return this.agy.a((Balance) obj, (Balance) obj2);
    }
}
