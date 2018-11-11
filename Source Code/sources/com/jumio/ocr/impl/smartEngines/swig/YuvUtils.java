package com.jumio.ocr.impl.smartEngines.swig;

public class YuvUtils {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected YuvUtils(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(YuvUtils yuvUtils) {
        return yuvUtils == null ? 0 : yuvUtils.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_YuvUtils(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public static int yuv2rgb(byte[] bArr, byte[] bArr2, int i, int i2) {
        return jniInterfaceJNI.YuvUtils_yuv2rgb(bArr, bArr2, i, i2);
    }

    public static int yuvCutRotateScale2rgb(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int i7, int i8, int i9) {
        return jniInterfaceJNI.YuvUtils_yuvCutRotateScale2rgb(bArr, i, i2, i3, i4, i5, i6, bArr2, i7, i8, i9);
    }

    public YuvUtils() {
        this(jniInterfaceJNI.new_YuvUtils(), true);
    }
}
