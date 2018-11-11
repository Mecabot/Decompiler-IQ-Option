package com.jumio.ocr.impl.smartEngines.swig;

public class OcrQuadrangle {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrQuadrangle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrQuadrangle ocrQuadrangle) {
        return ocrQuadrangle == null ? 0 : ocrQuadrangle.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrQuadrangle(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrQuadrangle() {
        this(jniInterfaceJNI.new_OcrQuadrangle__SWIG_0(), true);
    }

    public OcrQuadrangle(OcrPoint ocrPoint, OcrPoint ocrPoint2, OcrPoint ocrPoint3, OcrPoint ocrPoint4) {
        this(jniInterfaceJNI.new_OcrQuadrangle__SWIG_1(OcrPoint.getCPtr(ocrPoint), ocrPoint, OcrPoint.getCPtr(ocrPoint2), ocrPoint2, OcrPoint.getCPtr(ocrPoint3), ocrPoint3, OcrPoint.getCPtr(ocrPoint4), ocrPoint4), true);
    }

    public OcrPoint getTopLeft() {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getTopLeft(this.swigCPtr, this), false);
    }

    public OcrPoint getTopRight() {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getTopRight(this.swigCPtr, this), false);
    }

    public OcrPoint getBottomRight() {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getBottomRight(this.swigCPtr, this), false);
    }

    public OcrPoint getBottomLeft() {
        return new OcrPoint(jniInterfaceJNI.OcrQuadrangle_getBottomLeft(this.swigCPtr, this), false);
    }
}
