package com.microblink.settings;

import com.microblink.secured.IllllIIlII;
import com.microblink.secured.e;
import com.microblink.secured.i;

/* compiled from: line */
public class NativeLibraryInfo {
    private long IlIllIlIIl;

    public static native String getNativeBuildVersion();

    public static native boolean isProtectionEnabled();

    public static native boolean isWeakProtectionEnabled();

    private static native long nativeConstruct();

    private static native void nativeDestruct(long j);

    private static native String nativeGetErrorList(long j);

    private static native int nativeGetMaxImageSize(long j);

    private static native boolean nativeIsLibrarySuccessfullyInitialized(long j);

    private static native int nativeObtainProductId();

    protected void finalize() {
        super.finalize();
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
        }
    }

    static {
        i.aPu();
        i.aPu();
    }

    public NativeLibraryInfo(long j) {
        this.IlIllIlIIl = 0;
        this.IlIllIlIIl = j;
    }

    public NativeLibraryInfo() {
        this.IlIllIlIIl = 0;
        this.IlIllIlIIl = nativeConstruct();
    }

    public final boolean aPY() {
        return nativeIsLibrarySuccessfullyInitialized(this.IlIllIlIIl);
    }

    public String aPZ() {
        String nativeGetErrorList = nativeGetErrorList(this.IlIllIlIIl);
        return nativeGetErrorList == null ? "" : nativeGetErrorList;
    }

    public static e aQa() {
        return new e(IllllIIlII.values()[nativeObtainProductId()], getNativeBuildVersion());
    }
}
