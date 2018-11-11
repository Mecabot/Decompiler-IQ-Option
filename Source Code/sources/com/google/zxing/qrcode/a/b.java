package com.google.zxing.qrcode.a;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ByteMatrix */
public final class b {
    private final byte[][] adm;
    private final int height;
    private final int width;

    public b(int i, int i2) {
        this.adm = (byte[][]) Array.newInstance(byte.class, new int[]{i2, i});
        this.width = i;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public byte U(int i, int i2) {
        return this.adm[i2][i];
    }

    public byte[][] zr() {
        return this.adm;
    }

    public void set(int i, int i2, int i3) {
        this.adm[i2][i] = (byte) i3;
    }

    public void set(int i, int i2, boolean z) {
        this.adm[i2][i] = (byte) z;
    }

    public void b(byte b) {
        for (byte[] fill : this.adm) {
            Arrays.fill(fill, b);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((this.width * 2) * this.height) + 2);
        for (int i = 0; i < this.height; i++) {
            byte[] bArr = this.adm[i];
            for (int i2 = 0; i2 < this.width; i2++) {
                switch (bArr[i2]) {
                    case (byte) 0:
                        stringBuilder.append(" 0");
                        break;
                    case (byte) 1:
                        stringBuilder.append(" 1");
                        break;
                    default:
                        stringBuilder.append("  ");
                        break;
                }
            }
            stringBuilder.append(10);
        }
        return stringBuilder.toString();
    }
}
