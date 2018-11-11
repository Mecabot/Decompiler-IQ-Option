package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.b;
import com.google.zxing.qrcode.a.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* compiled from: QRCodeWriter */
public final class a implements c {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            StringBuilder stringBuilder = new StringBuilder("Can only encode QR_CODE, but got ");
            stringBuilder.append(barcodeFormat);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder2 = new StringBuilder("Requested dimensions are too small: ");
            stringBuilder2.append(i);
            stringBuilder2.append('x');
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(EncodeHintType.MARGIN)) {
                    i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
                }
            }
            return a(com.google.zxing.qrcode.a.c.a(str, errorCorrectionLevel, (Map) map), i, i2, i3);
        }
    }

    private static b a(f fVar, int i, int i2, int i3) {
        com.google.zxing.qrcode.a.b zs = fVar.zs();
        if (zs == null) {
            throw new IllegalStateException();
        }
        int width = zs.getWidth();
        int height = zs.getHeight();
        i3 <<= 1;
        int i4 = width + i3;
        i3 += height;
        i = Math.max(i, i4);
        i2 = Math.max(i2, i3);
        i3 = Math.min(i / i4, i2 / i3);
        i4 = (i - (width * i3)) / 2;
        int i5 = (i2 - (height * i3)) / 2;
        b bVar = new b(i, i2);
        i2 = 0;
        while (i2 < height) {
            int i6 = i4;
            int i7 = 0;
            while (i7 < width) {
                if (zs.U(i7, i2) == (byte) 1) {
                    bVar.c(i6, i5, i3, i3);
                }
                i7++;
                i6 += i3;
            }
            i2++;
            i5 += i3;
        }
        return bVar;
    }
}
