package com.jumio.ocr.impl.smartEngines.swig;

public class OcrCharVector {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrCharVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrCharVector ocrCharVector) {
        return ocrCharVector == null ? 0 : ocrCharVector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrCharVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrCharVector() {
        this(jniInterfaceJNI.new_OcrCharVector__SWIG_0(), true);
    }

    public OcrCharVector(long j) {
        this(jniInterfaceJNI.new_OcrCharVector__SWIG_1(j), true);
    }

    public long size() {
        return jniInterfaceJNI.OcrCharVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return jniInterfaceJNI.OcrCharVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        jniInterfaceJNI.OcrCharVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return jniInterfaceJNI.OcrCharVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        jniInterfaceJNI.OcrCharVector_clear(this.swigCPtr, this);
    }

    public void add(OcrChar ocrChar) {
        jniInterfaceJNI.OcrCharVector_add(this.swigCPtr, this, OcrChar.getCPtr(ocrChar), ocrChar);
    }

    public OcrChar get(int i) {
        return new OcrChar(jniInterfaceJNI.OcrCharVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, OcrChar ocrChar) {
        jniInterfaceJNI.OcrCharVector_set(this.swigCPtr, this, i, OcrChar.getCPtr(ocrChar), ocrChar);
    }
}
