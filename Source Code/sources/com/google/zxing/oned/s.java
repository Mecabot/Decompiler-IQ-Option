package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: UPCEWriter */
public final class s extends q {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode UPC_E, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public boolean[] dJ(String str) {
        int length = str.length();
        StringBuilder stringBuilder;
        switch (length) {
            case 7:
                try {
                    length = p.h(r.dL(str));
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
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            digit = r.acH[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int a = n.a(zArr, 0, p.acC, true) + 0;
            for (int i = 1; i <= 6; i++) {
                int digit2 = Character.digit(str.charAt(i), 10);
                if (((digit >> (6 - i)) & 1) == 1) {
                    digit2 += 10;
                }
                a += n.a(zArr, a, p.acF[digit2], false);
            }
            n.a(zArr, a, p.acA, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
