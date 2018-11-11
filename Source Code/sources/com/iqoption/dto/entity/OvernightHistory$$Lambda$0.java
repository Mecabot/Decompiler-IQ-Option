package com.iqoption.dto.entity;

import java.util.Comparator;

final /* synthetic */ class OvernightHistory$$Lambda$0 implements Comparator {
    static final Comparator $instance = new OvernightHistory$$Lambda$0();

    private OvernightHistory$$Lambda$0() {
    }

    public int compare(Object obj, Object obj2) {
        return Long.compare(((OvernightHistory) obj2).filledAt, ((OvernightHistory) obj).filledAt);
    }
}
