package com.google.zxing.a;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: AztecWriter */
public final class a implements c {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i3;
        int parseInt;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        int i4 = 33;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                charset = charset2;
                i3 = i4;
                parseInt = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                return a(str, barcodeFormat, i, i2, charset, i3, parseInt);
            }
            charset = charset2;
            i3 = i4;
        } else {
            charset = charset2;
            i3 = 33;
        }
        parseInt = 0;
        return a(str, barcodeFormat, i, i2, charset, i3, parseInt);
    }

    private static b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(com.google.zxing.a.a.c.e(str.getBytes(charset), i3, i4), i, i2);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode AZTEC, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static b a(com.google.zxing.a.a.a aVar, int i, int i2) {
        b yu = aVar.yu();
        if (yu == null) {
            throw new IllegalStateException();
        }
        int width = yu.getWidth();
        int height = yu.getHeight();
        i = Math.max(i, width);
        i2 = Math.max(i2, height);
        int min = Math.min(i / width, i2 / height);
        int i3 = (i - (width * min)) / 2;
        int i4 = (i2 - (height * min)) / 2;
        b bVar = new b(i, i2);
        i2 = 0;
        while (i2 < height) {
            int i5 = i3;
            int i6 = 0;
            while (i6 < width) {
                if (yu.L(i6, i2)) {
                    bVar.c(i5, i4, min, min);
                }
                i6++;
                i5 += min;
            }
            i2++;
            i4 += min;
        }
        return bVar;
    }
}
