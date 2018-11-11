package com.iqoption.util;

import android.support.annotation.Nullable;
import java.math.BigDecimal;

/* compiled from: MathUtils */
public class au {
    public static double J(double d) {
        return d < 0.0d ? d : -d;
    }

    public static float e(float f, float f2, float f3) {
        return f < f2 ? 0.0f : f < f3 ? (f - f2) / (f3 - f2) : 1.0f;
    }

    public static double i(double d, double d2) {
        return d * (d2 / 100.0d);
    }

    public static double j(double d, double d2) {
        return (d2 * 100.0d) / d;
    }

    public static double c(double d, int i) {
        return a(d, i, 4);
    }

    public static double a(double d, int i, int i2) {
        try {
            return new BigDecimal(Double.toString(d)).setScale(i, i2).doubleValue();
        } catch (NumberFormatException unused) {
            return Double.isInfinite(d) ? d : Double.NaN;
        }
    }

    @Nullable
    public static Double h(Double d, Double d2) {
        return (d == null || d2 == null) ? null : Double.valueOf((d2.doubleValue() * 100.0d) / d.doubleValue());
    }

    @Nullable
    public static Double i(Double d, Double d2) {
        return (d == null || d2 == null) ? null : Double.valueOf(d.doubleValue() * (d2.doubleValue() / 100.0d));
    }
}
