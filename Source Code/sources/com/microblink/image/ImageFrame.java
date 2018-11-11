package com.microblink.image;

import com.microblink.secured.m;

/* compiled from: line */
public class ImageFrame implements m {
    private long IlIllIlIIl = 0;
    protected Image dUN;
    private long dUe;

    private static native long nativeConstruct(long j, long j2);

    private static native void nativeDestruct(long j);

    public final boolean aOK() {
        return true;
    }

    public ImageFrame(Image image, long j) {
        if (image == null) {
            throw new NullPointerException("Image object cannot be null!");
        }
        this.dUN = image;
        this.dUe = j;
    }

    public final boolean cC(long j) {
        this.IlIllIlIIl = nativeConstruct(j, this.dUN.IlIllIlIIl);
        return this.IlIllIlIIl != 0;
    }

    public final void recycle() {
        nativeDestruct(this.IlIllIlIIl);
    }

    public final long aOL() {
        return this.IlIllIlIIl;
    }

    public final long aOM() {
        return this.dUe;
    }

    public final void aOJ() {
        throw new UnsupportedOperationException("Image frame should not be used in object pool.");
    }
}
