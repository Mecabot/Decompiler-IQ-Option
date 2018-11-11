package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: EAN8Writer */
public final class j extends q {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode EAN_8, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] dJ(String str) {
        int i;
        int length = str.length();
        StringBuilder stringBuilder;
        switch (length) {
            case 7:
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
            case 8:
                try {
                    if (!p.g(str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (FormatException unused) {
                    throw new IllegalArgumentException("Illegal contents");
                }
                break;
            default:
                stringBuilder = new StringBuilder("Requested contents should be 8 digits long, but got ");
                stringBuilder.append(length);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        boolean[] zArr = new boolean[67];
        int a = n.a(zArr, 0, p.acC, true) + 0;
        for (i = 0; i <= 3; i++) {
            a += n.a(zArr, a, p.acE[Character.digit(str.charAt(i), 10)], false);
        }
        a += n.a(zArr, a, p.acD, false);
        for (i = 4; i <= 7; i++) {
            a += n.a(zArr, a, p.acE[Character.digit(str.charAt(i), 10)], true);
        }
        n.a(zArr, a, p.acC, true);
        return zArr;
    }
}
