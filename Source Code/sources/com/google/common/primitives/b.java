package com.google.common.primitives;

import java.util.regex.Pattern;

/* compiled from: Doubles */
public final class b {
    static final Pattern Ve = vp();

    private static Pattern vp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(?:\\d++(?:\\.\\d*+)?|\\.\\d++)");
        stringBuilder.append("(?:[eE][+-]?\\d++)?[fFdD]?");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("0[xX]");
        stringBuilder3.append("(?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)");
        stringBuilder3.append("[pP][+-]?\\d++[fFdD]?");
        String stringBuilder4 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append("[+-]?(?:NaN|Infinity|");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("|");
        stringBuilder3.append(stringBuilder4);
        stringBuilder3.append(")");
        return Pattern.compile(stringBuilder3.toString());
    }

    public static Double cL(String str) {
        if (Ve.matcher(str).matches()) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }
}
