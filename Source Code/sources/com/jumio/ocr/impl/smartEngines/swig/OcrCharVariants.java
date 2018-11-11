package com.jumio.ocr.impl.smartEngines.swig;

public class OcrCharVariants {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrCharVariants(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrCharVariants ocrCharVariants) {
        return ocrCharVariants == null ? 0 : ocrCharVariants.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrCharVariants(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrCharVariants() {
        this(jniInterfaceJNI.new_OcrCharVariants__SWIG_0(), true);
    }

    public OcrCharVariants(OcrQuadrangle ocrQuadrangle, int i) {
        this(jniInterfaceJNI.new_OcrCharVariants__SWIG_1(OcrQuadrangle.getCPtr(ocrQuadrangle), ocrQuadrangle, i), true);
    }

    public void add(OcrChar ocrChar) {
        jniInterfaceJNI.OcrCharVariants_add(this.swigCPtr, this, OcrChar.getCPtr(ocrChar), ocrChar);
    }

    public OcrCharVector get() {
        return new OcrCharVector(jniInterfaceJNI.OcrCharVariants_get(this.swigCPtr, this), false);
    }

    public OcrQuadrangle getQuadrangle() {
        return new OcrQuadrangle(jniInterfaceJNI.OcrCharVariants_getQuadrangle(this.swigCPtr, this), false);
    }

    public int getHighlightingMask() {
        return jniInterfaceJNI.OcrCharVariants_getHighlightingMask(this.swigCPtr, this);
    }
}
