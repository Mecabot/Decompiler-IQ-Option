package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: EAN13Writer */
public final class i extends q {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode EAN_13, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] dJ(String str) {
        int length = str.length();
        StringBuilder stringBuilder;
        switch (length) {
            case 12:
                try {
                    length = p.h(str);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(length);
                    str = stringBuilder.toString();
                    break;
                } catch (Throwable e) {
                    throw new IllegalArgumentException(e);
                }
            case 13:
                try {
                    if (!p.g(str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (FormatException unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
                break;
            default:
                stringBuilder = new StringBuilder("Requested contents should be 12 or 13 digits long, but got ");
                stringBuilder.append(length);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = h.acv[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int a = n.a(zArr, 0, p.acC, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int digit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                digit += 10;
            }
            a += n.a(zArr, a, p.acF[digit], false);
        }
        a += n.a(zArr, a, p.acD, false);
        for (length = 7; length <= 12; length++) {
            a += n.a(zArr, a, p.acE[Character.digit(str.charAt(length), 10)], true);
        }
        n.a(zArr, a, p.acC, true);
        return zArr;
    }
}
