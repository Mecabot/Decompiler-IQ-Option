package com.google.common.a;

import com.google.common.base.i;

/* compiled from: UnicodeEscaper */
public abstract class c extends a {
    protected abstract char[] bv(int i);

    protected c() {
    }

    protected int a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            int b = b(charSequence, i, i2);
            if (b < 0 || bv(b) != null) {
                break;
            }
            i += Character.isSupplementaryCodePoint(b) ? 2 : 1;
        }
        return i;
    }

    public String escape(String str) {
        i.checkNotNull(str);
        int length = str.length();
        int a = a((CharSequence) str, 0, length);
        return a == length ? str : o(str, a);
    }

    protected final String o(String str, int i) {
        int length = str.length();
        char[] uT = b.uT();
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int b = b(str, i, length);
            if (b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            Object bv = bv(b);
            b = (Character.isSupplementaryCodePoint(b) ? 2 : 1) + i;
            if (bv != null) {
                int i4 = i - i2;
                int i5 = i3 + i4;
                int length2 = bv.length + i5;
                if (uT.length < length2) {
                    uT = a(uT, i3, (length2 + (length - i)) + 32);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, uT, i3);
                    i3 = i5;
                }
                if (bv.length > 0) {
                    System.arraycopy(bv, 0, uT, i3, bv.length);
                    i3 += bv.length;
                }
                i2 = b;
            }
            i = a((CharSequence) str, b, length);
        }
        i = length - i2;
        if (i > 0) {
            i += i3;
            if (uT.length < i) {
                uT = a(uT, i3, i);
            }
            str.getChars(i2, length, uT, i3);
        } else {
            i = i3;
        }
        return new String(uT, 0, i);
    }

    protected static int b(CharSequence charSequence, int i, int i2) {
        i.checkNotNull(charSequence);
        if (i < i2) {
            int i3 = i + 1;
            char charAt = charSequence.charAt(i);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            StringBuilder stringBuilder;
            if (charAt > 56319) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected low surrogate character '");
                stringBuilder.append(charAt);
                stringBuilder.append("' with value ");
                stringBuilder.append(charAt);
                stringBuilder.append(" at index ");
                stringBuilder.append(i3 - 1);
                stringBuilder.append(" in '");
                stringBuilder.append(charSequence);
                stringBuilder.append("'");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i3 == i2) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i3);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Expected low surrogate but got char '");
                stringBuilder.append(charAt2);
                stringBuilder.append("' with value ");
                stringBuilder.append(charAt2);
                stringBuilder.append(" at index ");
                stringBuilder.append(i3);
                stringBuilder.append(" in '");
                stringBuilder.append(charSequence);
                stringBuilder.append("'");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
    }

    private static char[] a(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        Object obj = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, obj, 0, i);
        }
        return obj;
    }
}
