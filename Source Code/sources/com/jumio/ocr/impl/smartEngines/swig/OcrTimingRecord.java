package com.jumio.ocr.impl.smartEngines.swig;

public class OcrTimingRecord {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrTimingRecord(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrTimingRecord ocrTimingRecord) {
        return ocrTimingRecord == null ? 0 : ocrTimingRecord.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrTimingRecord(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrTimingRecord() {
        this(jniInterfaceJNI.new_OcrTimingRecord__SWIG_0(), true);
    }

    public OcrTimingRecord(double d, long j, String str, String str2) {
        this(jniInterfaceJNI.new_OcrTimingRecord__SWIG_1(d, j, str, str2), true);
    }

    public double getTotalTime() {
        return jniInterfaceJNI.OcrTimingRecord_getTotalTime(this.swigCPtr, this);
    }

    public long getCallCount() {
        return jniInterfaceJNI.OcrTimingRecord_getCallCount(this.swigCPtr, this);
    }

    public String getName() {
        return jniInterfaceJNI.OcrTimingRecord_getName(this.swigCPtr, this);
    }

    public String getComment() {
        return jniInterfaceJNI.OcrTimingRecord_getComment(this.swigCPtr, this);
    }
}
