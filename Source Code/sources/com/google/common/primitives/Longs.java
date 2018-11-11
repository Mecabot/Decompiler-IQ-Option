package com.google.common.primitives;

import com.google.common.base.i;
import java.util.Arrays;
import java.util.Comparator;

public final class Longs {

    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Longs.compare(jArr[i], jArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    static final class a {
        private static final byte[] Vf;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i = 0; i <= 9; i++) {
                bArr[i + 48] = (byte) i;
            }
            for (int i2 = 0; i2 <= 26; i2++) {
                byte b = (byte) (i2 + 10);
                bArr[i2 + 65] = b;
                bArr[i2 + 97] = b;
            }
            Vf = bArr;
        }

        static int h(char c) {
            return c < 128 ? Vf[c] : -1;
        }
    }

    public static int compare(long j, long j2) {
        return j < j2 ? -1 : j > j2 ? 1 : 0;
    }

    public static int hashCode(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static Long cN(String str) {
        return r(str, 10);
    }

    public static Long r(String str, int i) {
        String str2 = str;
        int i2 = i;
        if (((String) i.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i2 < 2 || i2 > 36) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("radix must be between MIN_RADIX and MAX_RADIX but was ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i3 = 0;
        if (str2.charAt(0) == '-') {
            i3 = 1;
        }
        if (i3 == str.length()) {
            return null;
        }
        int i4 = i3 + 1;
        int h = a.h(str2.charAt(i3));
        if (h < 0 || h >= i2) {
            return null;
        }
        long j = (long) (-h);
        long j2 = (long) i2;
        long j3 = Long.MIN_VALUE / j2;
        while (i4 < str.length()) {
            int i5 = i4 + 1;
            i4 = a.h(str2.charAt(i4));
            if (i4 < 0 || i4 >= i2 || j < j3) {
                return null;
            }
            j *= j2;
            long j4 = (long) i4;
            if (j < j4 - Long.MIN_VALUE) {
                return null;
            }
            i4 = i5;
            j -= j4;
        }
        if (i3 != 0) {
            return Long.valueOf(j);
        }
        if (j == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j);
    }

    public static Comparator<long[]> vq() {
        return LexicographicalComparator.INSTANCE;
    }
}
