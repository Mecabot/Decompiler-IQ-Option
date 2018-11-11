package com.jumio.ocr.impl.smartEngines.swig;

public class ImageCheck {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ImageCheck(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ImageCheck imageCheck) {
        return imageCheck == null ? 0 : imageCheck.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_ImageCheck(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public static boolean isRefocusNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return jniInterfaceJNI.ImageCheck_isRefocusNeeded(bArr, i, i2, i3, i4, i5);
    }

    public static int computeFocusConfidence(byte[] bArr, int i, int i2, int i3, int i4) {
        return jniInterfaceJNI.ImageCheck_computeFocusConfidence(bArr, i, i2, i3, i4);
    }

    public static boolean isFlashNeeded(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return jniInterfaceJNI.ImageCheck_isFlashNeeded(bArr, i, i2, i3, i4, i5);
    }

    public static float computeFlashConfidence(byte[] bArr, int i, int i2, int i3, int i4) {
        return jniInterfaceJNI.ImageCheck_computeFlashConfidence(bArr, i, i2, i3, i4);
    }

    public ImageCheck() {
        this(jniInterfaceJNI.new_ImageCheck(), true);
    }
}
