package com.microblink.hardware.camera.memory;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.secured.m;

/* compiled from: line */
public class BitmapCameraFrame implements m {
    private long IlIllIlIIl;
    private RectF dUF;
    private Orientation dUG;
    private long dUH;
    private Bitmap mBitmap;

    private static native long initializeNativeBitmapFrame(long j, Bitmap bitmap, int i, float f, float f2, float f3, float f4);

    private static native void terminateNativeBitmapFrame(long j);

    public final void aOJ() {
    }

    public final boolean aOK() {
        return true;
    }

    public final void recycle() {
        terminateNativeBitmapFrame(this.IlIllIlIIl);
        this.IlIllIlIIl = 0;
        this.mBitmap = null;
    }

    public final boolean cC(long j) {
        if (this.IlIllIlIIl != 0) {
            throw new IllegalStateException("Native part is already initialized!");
        }
        this.IlIllIlIIl = initializeNativeBitmapFrame(j, this.mBitmap, this.dUG.intValue(), this.dUF.left, this.dUF.top, this.dUF.width(), this.dUF.height());
        return this.IlIllIlIIl != 0;
    }

    public final long aOL() {
        return this.IlIllIlIIl;
    }

    public final long aOM() {
        return this.dUH;
    }
}
