package com.jumio.ocr.impl.smartEngines.swig;

public class OcrConfidence {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrConfidence(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrConfidence ocrConfidence) {
        return ocrConfidence == null ? 0 : ocrConfidence.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrConfidence(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrConfidence(double d, double d2) {
        this(jniInterfaceJNI.new_OcrConfidence(d, d2), true);
    }

    public double getMinimum() {
        return jniInterfaceJNI.OcrConfidence_getMinimum(this.swigCPtr, this);
    }

    public double getAverage() {
        return jniInterfaceJNI.OcrConfidence_getAverage(this.swigCPtr, this);
    }
}
