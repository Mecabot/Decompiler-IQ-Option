package com.jumio.ocr.impl.smartEngines.swig;

public class OcrQuadrangleVector {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrQuadrangleVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrQuadrangleVector ocrQuadrangleVector) {
        return ocrQuadrangleVector == null ? 0 : ocrQuadrangleVector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrQuadrangleVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrQuadrangleVector() {
        this(jniInterfaceJNI.new_OcrQuadrangleVector__SWIG_0(), true);
    }

    public OcrQuadrangleVector(long j) {
        this(jniInterfaceJNI.new_OcrQuadrangleVector__SWIG_1(j), true);
    }

    public long size() {
        return jniInterfaceJNI.OcrQuadrangleVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return jniInterfaceJNI.OcrQuadrangleVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        jniInterfaceJNI.OcrQuadrangleVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return jniInterfaceJNI.OcrQuadrangleVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        jniInterfaceJNI.OcrQuadrangleVector_clear(this.swigCPtr, this);
    }

    public void add(OcrQuadrangle ocrQuadrangle) {
        jniInterfaceJNI.OcrQuadrangleVector_add(this.swigCPtr, this, OcrQuadrangle.getCPtr(ocrQuadrangle), ocrQuadrangle);
    }

    public OcrQuadrangle get(int i) {
        return new OcrQuadrangle(jniInterfaceJNI.OcrQuadrangleVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, OcrQuadrangle ocrQuadrangle) {
        jniInterfaceJNI.OcrQuadrangleVector_set(this.swigCPtr, this, i, OcrQuadrangle.getCPtr(ocrQuadrangle), ocrQuadrangle);
    }
}
