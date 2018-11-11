package org.threeten.bp.format;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: DecimalStyle */
public final class f {
    public static final f fgu = new f('0', '+', '-', '.');
    private static final ConcurrentMap<Locale, f> fgv = new ConcurrentHashMap(16, 0.75f, 2);
    private final char fgw;
    private final char fgx;
    private final char fgy;
    private final char fgz;

    private f(char c, char c2, char c3, char c4) {
        this.fgw = c;
        this.fgx = c2;
        this.fgy = c3;
        this.fgz = c4;
    }

    public char getZeroDigit() {
        return this.fgw;
    }

    public char getPositiveSign() {
        return this.fgx;
    }

    public char getNegativeSign() {
        return this.fgy;
    }

    public char getDecimalSeparator() {
        return this.fgz;
    }

    String nR(String str) {
        if (this.fgw == '0') {
            return str;
        }
        int i = this.fgw - 48;
        char[] toCharArray = str.toCharArray();
        for (int i2 = 0; i2 < toCharArray.length; i2++) {
            toCharArray[i2] = (char) (toCharArray[i2] + i);
        }
        return new String(toCharArray);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!(this.fgw == fVar.fgw && this.fgx == fVar.fgx && this.fgy == fVar.fgy && this.fgz == fVar.fgz)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.fgw + this.fgx) + this.fgy) + this.fgz;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecimalStyle[");
        stringBuilder.append(this.fgw);
        stringBuilder.append(this.fgx);
        stringBuilder.append(this.fgy);
        stringBuilder.append(this.fgz);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
