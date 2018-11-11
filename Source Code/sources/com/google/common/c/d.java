package com.google.common.c;

/* compiled from: MathPreconditions */
final class d {
    static int p(String str, int i) {
        if (i > 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append(i);
        stringBuilder.append(") must be > 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static double a(String str, double d) {
        if (d >= 0.0d) {
            return d;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append(d);
        stringBuilder.append(") must be >= 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static void ae(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    static void af(boolean z) {
        if (!z) {
            throw new ArithmeticException("overflow");
        }
    }
}
