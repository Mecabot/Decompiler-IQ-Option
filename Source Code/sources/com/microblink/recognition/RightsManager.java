package com.microblink.recognition;

import android.support.annotation.Keep;

/* compiled from: line */
public class RightsManager {
    public long IlIllIlIIl = 0;

    private static native void nativeDestruct(long j);

    public static native int nativeGetPingInterval(long j);

    public static native boolean nativeIsLicenseOk(long j);

    private static native boolean nativeIsRightEnabled(long j, int i);

    @Keep
    protected RightsManager(long j) {
        this.IlIllIlIIl = j;
    }

    public final boolean a(Right right) {
        return nativeIsRightEnabled(this.IlIllIlIIl, right.IIIIlIllIl);
    }

    protected void finalize() {
        super.finalize();
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
        }
    }
}
