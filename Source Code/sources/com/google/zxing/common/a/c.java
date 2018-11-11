package com.google.zxing.common.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReedSolomonEncoder */
public final class c {
    private final a abJ;
    private final List<b> abL = new ArrayList();

    public c(a aVar) {
        this.abJ = aVar;
        this.abL.add(new b(aVar, new int[]{1}));
    }

    private b bW(int i) {
        if (i >= this.abL.size()) {
            b bVar = (b) this.abL.get(this.abL.size() - 1);
            for (int size = this.abL.size(); size <= i; size++) {
                bVar = bVar.b(new b(this.abJ, new int[]{1, this.abJ.bS((size - 1) + this.abJ.yD())}));
                this.abL.add(bVar);
            }
        }
        return (b) this.abL.get(i);
    }

    public void b(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bW = bW(i);
        Object obj = new int[length];
        System.arraycopy(iArr, 0, obj, 0, length);
        Object yE = new b(this.abJ, obj).P(i, 1).c(bW)[1].yE();
        i -= yE.length;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(yE, 0, iArr, length + i, yE.length);
    }
}
