package com.microblink.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;

/* compiled from: line */
public class Image {
    long IlIllIlIIl = 0;
    private Integer dUI;
    private Integer dUJ;
    private Rect dUK;
    private final int dUL = 1;
    Object dUM = null;

    private static native long nativeClone(long j);

    private static native boolean nativeCopyPixelsToBitmap(long j, Bitmap bitmap);

    private static native void nativeDestruct(long j);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetImageFormat(long j);

    private static native String nativeGetImageName(long j);

    private static native int nativeGetImageOrientation(long j);

    private static native int nativeGetImageType(long j);

    private static native ByteBuffer nativeGetPixelBuffer(long j);

    private static native void nativeGetRoi(long j, int[] iArr);

    private static native int nativeGetRowStride(long j);

    private static native int nativeGetWidth(long j);

    private static native void nativeSetImageOrientation(long j, int i);

    private static native void nativeSetRoi(long j, int i, int i2, int i3, int i4);

    Image(long j) {
        this.IlIllIlIIl = j;
    }

    public void dispose() {
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
            this.IlIllIlIIl = 0;
            this.dUM = null;
        }
    }

    protected void finalize() {
        super.finalize();
        dispose();
    }

    /* renamed from: aON */
    public Image clone() {
        if (this.IlIllIlIIl != 0) {
            return new Image(nativeClone(this.IlIllIlIIl));
        }
        throw new IllegalStateException("Cannot clone disposed image!");
    }

    public int getWidth() {
        if (this.IlIllIlIIl == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.dUI == null) {
            this.dUI = Integer.valueOf(nativeGetWidth(this.IlIllIlIIl));
        }
        return this.dUI.intValue();
    }

    public int getHeight() {
        if (this.IlIllIlIIl == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.dUJ == null) {
            this.dUJ = Integer.valueOf(nativeGetHeight(this.IlIllIlIIl));
        }
        return this.dUJ.intValue();
    }

    public Rect aOO() {
        if (this.IlIllIlIIl == 0) {
            throw new IllegalStateException("Cannot use disposed image!");
        }
        if (this.dUK == null) {
            int[] iArr = new int[4];
            nativeGetRoi(this.IlIllIlIIl, iArr);
            this.dUK = new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        return this.dUK;
    }

    public boolean isDisposed() {
        return this.IlIllIlIIl == 0;
    }
}
