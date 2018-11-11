package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: UPCAWriter */
public final class o implements c {
    private final i acB = new i();

    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            StringBuilder stringBuilder = new StringBuilder("Can only encode UPC-A, but got ");
            stringBuilder.append(barcodeFormat);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        i iVar = this.acB;
        StringBuilder stringBuilder2 = new StringBuilder("0");
        stringBuilder2.append(str);
        return iVar.a(stringBuilder2.toString(), BarcodeFormat.EAN_13, i, i2, map);
    }
}
