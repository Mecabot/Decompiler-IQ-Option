package com.google.zxing.oned;

import com.google.zxing.FormatException;

/* compiled from: UPCEANReader */
public abstract class p extends m {
    static final int[] acA = new int[]{1, 1, 1, 1, 1, 1};
    static final int[] acC = new int[]{1, 1, 1};
    static final int[] acD = new int[]{1, 1, 1, 1, 1};
    static final int[][] acE = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    static final int[][] acF = new int[20][];

    static {
        int i = 10;
        System.arraycopy(acE, 0, acF, 0, 10);
        while (i < 20) {
            int[] iArr = acE[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            acF[i] = iArr2;
            i++;
        }
    }

    static boolean g(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        length--;
        return h(charSequence.subSequence(0, length)) == Character.digit(charSequence.charAt(length), 10);
    }

    static int h(CharSequence charSequence) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        for (i = length - 1; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw FormatException.yt();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (length -= 2; length >= 0; length -= 2) {
            i = charSequence.charAt(length) - 48;
            if (i < 0 || i > 9) {
                throw FormatException.yt();
            }
            i2 += i;
        }
        return (1000 - i2) % 10;
    }
}
