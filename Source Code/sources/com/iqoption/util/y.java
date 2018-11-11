package com.iqoption.util;

import android.support.annotation.Nullable;

/* compiled from: DoubleUtils */
public final class y {
    @Nullable
    public static Double f(Double d, Double d2) {
        if (d == null) {
            return d2;
        }
        return d2 == null ? null : Double.valueOf(d.doubleValue() + d2.doubleValue());
    }

    public static int g(@Nullable Double d, @Nullable Double d2) {
        double d3 = 0.0d;
        double doubleValue = d == null ? 0.0d : d.doubleValue();
        if (d2 != null) {
            d3 = d2.doubleValue();
        }
        return Double.compare(doubleValue, d3);
    }
}
