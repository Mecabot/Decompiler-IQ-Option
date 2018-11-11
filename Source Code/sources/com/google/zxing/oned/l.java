package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: ITFWriter */
public final class l extends n {
    private static final int[] acA = new int[]{3, 1, 1};
    private static final int[] acx = new int[]{1, 1, 1, 1};

    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode ITF, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] dJ(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length > 80) {
            StringBuilder stringBuilder = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = n.a(zArr, 0, acx, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[10];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    iArr[i3] = k.acz[digit][i2];
                    iArr[i3 + 1] = k.acz[digit2][i2];
                }
                a += n.a(zArr, a, iArr, true);
            }
            n.a(zArr, a, acA, true);
            return zArr;
        }
    }
}
