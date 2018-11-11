package com.jumio.ocr.impl.smartEngines.swig;

public class OcrCharStringVector {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrCharStringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrCharStringVector ocrCharStringVector) {
        return ocrCharStringVector == null ? 0 : ocrCharStringVector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrCharStringVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrCharStringVector() {
        this(jniInterfaceJNI.new_OcrCharStringVector__SWIG_0(), true);
    }

    public OcrCharStringVector(long j) {
        this(jniInterfaceJNI.new_OcrCharStringVector__SWIG_1(j), true);
    }

    public long size() {
        return jniInterfaceJNI.OcrCharStringVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return jniInterfaceJNI.OcrCharStringVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        jniInterfaceJNI.OcrCharStringVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return jniInterfaceJNI.OcrCharStringVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        jniInterfaceJNI.OcrCharStringVector_clear(this.swigCPtr, this);
    }

    public void add(OcrCharVariants ocrCharVariants) {
        jniInterfaceJNI.OcrCharStringVector_add(this.swigCPtr, this, OcrCharVariants.getCPtr(ocrCharVariants), ocrCharVariants);
    }

    public OcrCharVariants get(int i) {
        return new OcrCharVariants(jniInterfaceJNI.OcrCharStringVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, OcrCharVariants ocrCharVariants) {
        jniInterfaceJNI.OcrCharStringVector_set(this.swigCPtr, this, i, OcrCharVariants.getCPtr(ocrCharVariants), ocrCharVariants);
    }
}
