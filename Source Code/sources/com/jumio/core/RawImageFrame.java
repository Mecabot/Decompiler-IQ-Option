package com.jumio.core;

public class RawImageFrame {
    public static final int RGB = 0;
    public static final int YUV = 1;
    byte[] data;
    int format = 0;
    int height;
    int width;

    public RawImageFrame(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.width = i;
        this.height = i2;
    }
}
