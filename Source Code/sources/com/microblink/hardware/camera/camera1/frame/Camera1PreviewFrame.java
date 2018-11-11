package com.microblink.hardware.camera.camera1.frame;

import com.microblink.secured.i;
import com.microblink.secured.o;
import com.microblink.secured.q;
import com.microblink.util.Log;

/* compiled from: line */
public class Camera1PreviewFrame extends q {
    private o dUz;

    private static native long initializeNativeCamera1Frame(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    private static native double nativeGetCamera1FrameQuality(long j);

    private static native void terminateNativeCamera1Frame(long j);

    public final boolean aOK() {
        return false;
    }

    public final void aOJ() {
        Log.e(this, "Finalizing frame ID: {}", Long.valueOf(this.dUH));
        terminateNativeCamera1Frame(this.IlIllIlIIl);
        this.IlIllIlIIl = 0;
        super.aOJ();
    }

    public final void recycle() {
        if (this.dUz != null) {
            this.dUz.dWR.a(this);
        }
    }

    public final void dispose() {
        super.dispose();
        this.dUz = null;
    }

    public final boolean cC(long j) {
        if (this.IlIllIlIIl != 0) {
            throw new IllegalStateException("Native part is already initialized!");
        }
        this.IlIllIlIIl = initializeNativeCamera1Frame(j, this.dWV, this.dWW, this.dWU, this.dUD, this.dUE, this.dUG.intValue(), this.dUF.left, this.dUF.top, this.dUF.width(), this.dUF.height());
        return this.IlIllIlIIl != 0;
    }

    static {
        i.aPu();
    }
}
