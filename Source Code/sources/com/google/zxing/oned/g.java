package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: Code93Writer */
public class g extends n {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode CODE_93, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] dJ(String str) {
        int length = str.length();
        if (length > 80) {
            StringBuilder stringBuilder = new StringBuilder("Requested contents should be less than 80 digits long, but got ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int[] iArr = new int[9];
        int length2 = (((str.length() + 2) + 2) * 9) + 1;
        a(f.acn[47], iArr);
        boolean[] zArr = new boolean[length2];
        int i = 0;
        int a = a(zArr, 0, iArr);
        while (i < length) {
            a(f.acn["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            a += a(zArr, a, iArr);
            i++;
        }
        length = s(str, 20);
        a(f.acn[length], iArr);
        a += a(zArr, a, iArr);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(length));
        a(f.acn[s(stringBuilder2.toString(), 15)], iArr);
        a += a(zArr, a, iArr);
        a(f.acn[47], iArr);
        zArr[a + a(zArr, a, iArr)] = true;
        return zArr;
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    private static int a(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = i;
        i = 0;
        while (i < length) {
            int i3 = i2 + 1;
            zArr[i2] = iArr[i] != 0;
            i++;
            i2 = i3;
        }
        return 9;
    }

    private static int s(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
