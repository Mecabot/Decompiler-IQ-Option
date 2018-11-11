package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.b;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.i;
import com.google.zxing.datamatrix.encoder.j;
import com.google.zxing.datamatrix.encoder.k;
import java.util.Map;

/* compiled from: DataMatrixWriter */
public final class a implements c {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            StringBuilder stringBuilder = new StringBuilder("Can only encode DATA_MATRIX, but got ");
            stringBuilder.append(barcodeFormat);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0 || i2 < 0) {
            StringBuilder stringBuilder2 = new StringBuilder("Requested dimensions are too small: ");
            stringBuilder2.append(i);
            stringBuilder2.append('x');
            stringBuilder2.append(i2);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            com.google.zxing.a aVar;
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            com.google.zxing.a aVar2 = null;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                aVar = (com.google.zxing.a) map.get(EncodeHintType.MIN_SIZE);
                if (aVar == null) {
                    aVar = null;
                }
                com.google.zxing.a aVar3 = (com.google.zxing.a) map.get(EncodeHintType.MAX_SIZE);
                if (aVar3 != null) {
                    aVar2 = aVar3;
                }
            } else {
                aVar = null;
            }
            str = j.a(str, symbolShapeHint, aVar, aVar2);
            k a = k.a(str.length(), symbolShapeHint, aVar, aVar2, true);
            e eVar = new e(i.a(str, a), a.yV(), a.yW());
            eVar.yI();
            return a(eVar, a);
        }
    }

    private static b a(e eVar, k kVar) {
        int yV = kVar.yV();
        int yW = kVar.yW();
        com.google.zxing.qrcode.a.b bVar = new com.google.zxing.qrcode.a.b(kVar.yX(), kVar.yY());
        int i = 0;
        for (int i2 = 0; i2 < yW; i2++) {
            int i3;
            int i4;
            if (i2 % kVar.aci == 0) {
                i3 = 0;
                for (i4 = 0; i4 < kVar.yX(); i4++) {
                    bVar.set(i3, i, i4 % 2 == 0);
                    i3++;
                }
                i++;
            }
            i3 = 0;
            for (i4 = 0; i4 < yV; i4++) {
                if (i4 % kVar.ach == 0) {
                    bVar.set(i3, i, true);
                    i3++;
                }
                bVar.set(i3, i, eVar.Q(i4, i2));
                i3++;
                if (i4 % kVar.ach == kVar.ach - 1) {
                    bVar.set(i3, i, i2 % 2 == 0);
                    i3++;
                }
            }
            i++;
            if (i2 % kVar.aci == kVar.aci - 1) {
                i3 = 0;
                for (i4 = 0; i4 < kVar.yX(); i4++) {
                    bVar.set(i3, i, true);
                    i3++;
                }
                i++;
            }
        }
        return a(bVar);
    }

    private static b a(com.google.zxing.qrcode.a.b bVar) {
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        b bVar2 = new b(width, height);
        bVar2.clear();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                if (bVar.U(i, i2) == (byte) 1) {
                    bVar2.set(i, i2);
                }
            }
        }
        return bVar2;
    }
}
