package com.iqoption.dialog.a;

import com.google.common.primitives.Longs;
import com.iqoption.dto.Point;
import java.util.Comparator;

final /* synthetic */ class n implements Comparator {
    static final Comparator $instance = new n();

    private n() {
    }

    public int compare(Object obj, Object obj2) {
        return Longs.compare(((Point) obj).timestamp, ((Point) obj2).timestamp);
    }
}
