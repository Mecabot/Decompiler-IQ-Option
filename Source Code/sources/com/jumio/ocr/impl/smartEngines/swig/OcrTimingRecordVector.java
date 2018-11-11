package com.jumio.ocr.impl.smartEngines.swig;

public class OcrTimingRecordVector {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrTimingRecordVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrTimingRecordVector ocrTimingRecordVector) {
        return ocrTimingRecordVector == null ? 0 : ocrTimingRecordVector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrTimingRecordVector(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrTimingRecordVector() {
        this(jniInterfaceJNI.new_OcrTimingRecordVector__SWIG_0(), true);
    }

    public OcrTimingRecordVector(long j) {
        this(jniInterfaceJNI.new_OcrTimingRecordVector__SWIG_1(j), true);
    }

    public long size() {
        return jniInterfaceJNI.OcrTimingRecordVector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return jniInterfaceJNI.OcrTimingRecordVector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        jniInterfaceJNI.OcrTimingRecordVector_reserve(this.swigCPtr, this, j);
    }

    public boolean isEmpty() {
        return jniInterfaceJNI.OcrTimingRecordVector_isEmpty(this.swigCPtr, this);
    }

    public void clear() {
        jniInterfaceJNI.OcrTimingRecordVector_clear(this.swigCPtr, this);
    }

    public void add(OcrTimingRecord ocrTimingRecord) {
        jniInterfaceJNI.OcrTimingRecordVector_add(this.swigCPtr, this, OcrTimingRecord.getCPtr(ocrTimingRecord), ocrTimingRecord);
    }

    public OcrTimingRecord get(int i) {
        return new OcrTimingRecord(jniInterfaceJNI.OcrTimingRecordVector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, OcrTimingRecord ocrTimingRecord) {
        jniInterfaceJNI.OcrTimingRecordVector_set(this.swigCPtr, this, i, OcrTimingRecord.getCPtr(ocrTimingRecord), ocrTimingRecord);
    }
}
