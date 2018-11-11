package com.jumio.alejwt.swig;

public class ALEHeader {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ALEHeader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ALEHeader aLEHeader) {
        return aLEHeader == null ? 0 : aLEHeader.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALEHeader(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ALEHeader() {
        this(aleEngineJNI.new_ALEHeader(), true);
    }

    public void add(String str, String str2) {
        aleEngineJNI.ALEHeader_add__SWIG_0(this.swigCPtr, this, str, str2);
    }

    public void clear() {
        aleEngineJNI.ALEHeader_clear(this.swigCPtr, this);
    }
}
