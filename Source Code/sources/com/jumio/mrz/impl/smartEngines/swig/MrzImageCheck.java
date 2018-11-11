package com.jumio.mrz.impl.smartEngines.swig;

public class MrzImageCheck {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzImageCheck(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzImageCheck mrzImageCheck) {
        return mrzImageCheck == null ? 0 : mrzImageCheck.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzImageCheck(this.a);
            }
            this.a = 0;
        }
    }

    public static boolean isRefocusNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return mrzjniInterfaceJNI.MrzImageCheck_isRefocusNeeded(bArr, i, i2, i3, i4, i5);
    }

    public static int computeFocusConfidence(byte[] bArr, int i, int i2, int i3, int i4) {
        return mrzjniInterfaceJNI.MrzImageCheck_computeFocusConfidence(bArr, i, i2, i3, i4);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return mrzjniInterfaceJNI.MrzImageCheck_isFlashNeeded(bArr, i, i2, i3, i4, i5);
    }

    public static float computeFlashConfidence(byte[] bArr, int i, int i2, int i3, int i4) {
        return mrzjniInterfaceJNI.MrzImageCheck_computeFlashConfidence(bArr, i, i2, i3, i4);
    }

    public MrzImageCheck() {
        this(mrzjniInterfaceJNI.new_MrzImageCheck(), true);
    }
}
