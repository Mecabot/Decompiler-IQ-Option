package com.jumio.ocr.impl.smartEngines.swig;

public class OcrPoint {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrPoint ocrPoint) {
        return ocrPoint == null ? 0 : ocrPoint.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrPoint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrPoint(int i, int i2) {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_0(i, i2), true);
    }

    public OcrPoint(int i) {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_1(i), true);
    }

    public OcrPoint() {
        this(jniInterfaceJNI.new_OcrPoint__SWIG_2(), true);
    }

    public int getX() {
        return jniInterfaceJNI.OcrPoint_getX(this.swigCPtr, this);
    }

    public int getY() {
        return jniInterfaceJNI.OcrPoint_getY(this.swigCPtr, this);
    }
}
