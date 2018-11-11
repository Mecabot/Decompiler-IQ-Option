package com.jumio.clientlib.impl.templatematcher;

public class ImgWarp {
    private transient long a;
    protected transient boolean swigCMemOwn;

    protected ImgWarp(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(ImgWarp imgWarp) {
        return imgWarp == null ? 0 : imgWarp.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniTemplateMatcherJNI.delete_ImgWarp(this.a);
            }
            this.a = 0;
        }
    }

    public static void warp(byte[] bArr, long j, int i, int i2, PixelFormatType pixelFormatType, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, byte[] bArr2, int i3, int i4) {
        jniTemplateMatcherJNI.ImgWarp_warp(bArr, j, i, i2, pixelFormatType.swigValue(), f, f2, f3, f4, f5, f6, f7, f8, bArr2, i3, i4);
    }

    public ImgWarp() {
        this(jniTemplateMatcherJNI.new_ImgWarp(), true);
    }
}
