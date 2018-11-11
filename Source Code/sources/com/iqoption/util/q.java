package com.iqoption.util;

import android.util.SparseArray;
import com.google.common.base.Suppliers;
import com.google.common.base.n;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: DecimalUtils */
public final class q {
    private static final char[] bgI = new char[]{'k', 'm', 'b', 't'};
    public static DecimalFormatSymbols duZ = new DecimalFormatSymbols(Locale.US);
    private static n<DecimalFormat> dva = Suppliers.a(new n<DecimalFormat>() {
        /* renamed from: aGf */
        public DecimalFormat get() {
            DecimalFormat I = q.I("0", 2);
            I.setRoundingMode(RoundingMode.DOWN);
            return I;
        }
    });
    private static n<SparseArray<DecimalFormat>> dvb = Suppliers.a(r.ajD);
    private static n<SparseArray<DecimalFormat>> dvc = Suppliers.a(s.ajD);

    public static String I(double d) {
        return ((DecimalFormat) dva.get()).format(d);
    }

    public static DecimalFormat I(String str, int i) {
        return i == 0 ? new DecimalFormat("#", duZ) : new DecimalFormat(J(str, i), duZ);
    }

    public static DecimalFormat P(String str, int i) {
        return i == 0 ? new DecimalFormat("#,###", duZ) : new DecimalFormat(Q(str, i), duZ);
    }

    private static String J(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("0.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private static String Q(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("#,##0.");
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static double j(double d, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Precision must not be negative");
        }
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 *= 10;
        }
        double d2 = (double) i2;
        return Math.ceil(d * d2) / d2;
    }

    public static DecimalFormat dX(int i) {
        SparseArray sparseArray = (SparseArray) dvb.get();
        DecimalFormat decimalFormat = (DecimalFormat) sparseArray.get(i);
        if (decimalFormat != null) {
            return decimalFormat;
        }
        decimalFormat = I("#", i);
        sparseArray.put(i, decimalFormat);
        return decimalFormat;
    }

    public static DecimalFormat dY(int i) {
        SparseArray sparseArray = (SparseArray) dvc.get();
        DecimalFormat decimalFormat = (DecimalFormat) sparseArray.get(i);
        if (decimalFormat != null) {
            return decimalFormat;
        }
        decimalFormat = I("0", i);
        sparseArray.put(i, decimalFormat);
        return decimalFormat;
    }
}
