package com.google.zxing.pdf417.encoder;

/* compiled from: BarcodeRow */
final class b {
    private final byte[] acK;
    private int acL = 0;

    b(int i) {
        this.acK = new byte[i];
    }

    private void set(int i, boolean z) {
        this.acK[i] = (byte) z;
    }

    void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.acL;
            this.acL = i3 + 1;
            set(i3, z);
        }
    }

    byte[] cg(int i) {
        byte[] bArr = new byte[(this.acK.length * i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.acK[i2 / i];
        }
        return bArr;
    }
}
