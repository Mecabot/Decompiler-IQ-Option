package org.yaml.snakeyaml.a.b.a.a.a.a.a;

import android.support.v4.internal.view.SupportMenu;

/* compiled from: PercentEscaper */
public class b extends c {
    private static final char[] UW = "0123456789ABCDEF".toCharArray();
    private static final char[] fiu = new char[]{'+'};
    private final boolean UX;
    private final boolean[] Va;

    public b(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        } else {
            this.UX = z;
            this.Va = cK(str);
        }
    }

    private static boolean[] cK(String str) {
        char[] toCharArray = str.toCharArray();
        int i = 122;
        for (char max : toCharArray) {
            i = Math.max(max, i);
        }
        boolean[] zArr = new boolean[(i + 1)];
        for (i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (i = 65; i <= 90; i++) {
            zArr[i] = true;
        }
        for (i = 97; i <= 122; i++) {
            zArr[i] = true;
        }
        for (char c : toCharArray) {
            zArr[c] = true;
        }
        return zArr;
    }

    protected int a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt >= this.Va.length || !this.Va[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    public String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= this.Va.length || !this.Va[charAt]) {
                return o(str, i);
            }
        }
        return str;
    }

    protected char[] bv(int i) {
        if (i < this.Va.length && this.Va[i]) {
            return null;
        }
        if (i == 32 && this.UX) {
            return fiu;
        }
        char[] cArr;
        if (i <= 127) {
            return new char[]{'%', UW[i & 15], UW[i >>> 4]};
        } else if (i <= 2047) {
            cArr = new char[6];
            cArr[0] = '%';
            cArr[3] = '%';
            cArr[5] = UW[i & 15];
            i >>>= 4;
            cArr[4] = UW[(i & 3) | 8];
            i >>>= 2;
            cArr[2] = UW[i & 15];
            cArr[1] = UW[(i >>> 4) | 12];
            return cArr;
        } else if (i <= SupportMenu.USER_MASK) {
            cArr = new char[9];
            i >>>= 4;
            cArr[7] = UW[(i & 3) | 8];
            i >>>= 2;
            cArr[5] = UW[i & 15];
            i >>>= 4;
            cArr[4] = UW[(i & 3) | 8];
            cArr[2] = UW[i >>> 2];
            return cArr;
        } else if (i <= 1114111) {
            cArr = new char[12];
            i >>>= 4;
            cArr[10] = UW[(i & 3) | 8];
            i >>>= 2;
            cArr[8] = UW[i & 15];
            i >>>= 4;
            cArr[7] = UW[(i & 3) | 8];
            i >>>= 2;
            cArr[5] = UW[i & 15];
            i >>>= 4;
            cArr[4] = UW[(i & 3) | 8];
            cArr[2] = UW[(i >>> 2) & 7];
            return cArr;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid unicode character value ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
