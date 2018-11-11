package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* compiled from: BarcodeMatrix */
public final class a {
    private final b[] acI;
    private int acJ;
    private final int height;
    private final int width;

    a(int i, int i2) {
        this.acI = new b[i];
        int length = this.acI.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.acI[i3] = new b(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i;
        this.acJ = -1;
    }

    void zc() {
        this.acJ++;
    }

    b zd() {
        return this.acI[this.acJ];
    }

    public byte[][] S(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.height * i2, this.width * i});
        int i3 = this.height * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.acI[i4 / i2].cg(i);
        }
        return bArr;
    }
}
