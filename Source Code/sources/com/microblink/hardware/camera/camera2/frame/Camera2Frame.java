package com.microblink.hardware.camera.camera2.frame;

import android.annotation.TargetApi;
import android.graphics.RectF;
import android.media.Image;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.secured.i;
import com.microblink.secured.m;
import com.microblink.secured.n;
import com.microblink.secured.p;
import com.microblink.util.Log;
import java.nio.ByteBuffer;

@TargetApi(21)
/* compiled from: line */
public class Camera2Frame implements m {
    private long IlIllIlIIl;
    public Image dUA;
    private p dUB;
    public n dUC;
    public boolean dUD;
    public boolean dUE;
    private RectF dUF;
    private Orientation dUG;
    public long dUH;

    private static native long initializeNativeCamera2Frame(long j, int i, int i2, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    private static native double nativeGetCamera2FrameQuality(long j);

    private static native void terminateNativeCamera2Frame(long j);

    public final boolean aOK() {
        return false;
    }

    public final void aOJ() {
        Log.e(this, "Finalizing frame ID: {}", Long.valueOf(this.dUH));
        terminateNativeCamera2Frame(this.IlIllIlIIl);
        this.IlIllIlIIl = 0;
        if (this.dUA != null) {
            this.dUC.a(this.dUA);
            this.dUC = null;
        }
    }

    public final void recycle() {
        this.dUB.dWT.a(this);
    }

    public final boolean cC(long j) {
        if (this.IlIllIlIIl != 0) {
            throw new IllegalStateException("Native part is already initialized!");
        }
        this.IlIllIlIIl = initializeNativeCamera2Frame(j, this.dUA.getWidth(), this.dUA.getHeight(), this.dUD, this.dUE, this.dUG.intValue(), this.dUF.left, this.dUF.top, this.dUF.width(), this.dUF.height(), this.dUA.getPlanes()[0].getBuffer(), this.dUA.getPlanes()[0].getRowStride(), this.dUA.getPlanes()[0].getPixelStride(), this.dUA.getPlanes()[1].getBuffer(), this.dUA.getPlanes()[1].getRowStride(), this.dUA.getPlanes()[1].getPixelStride(), this.dUA.getPlanes()[2].getBuffer(), this.dUA.getPlanes()[2].getRowStride(), this.dUA.getPlanes()[2].getPixelStride());
        return this.IlIllIlIIl != 0;
    }

    public final long aOL() {
        return this.IlIllIlIIl;
    }

    public final long aOM() {
        return this.dUH;
    }

    static {
        i.aPu();
    }
}
