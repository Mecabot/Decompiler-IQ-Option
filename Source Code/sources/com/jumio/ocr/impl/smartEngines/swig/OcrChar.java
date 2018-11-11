package com.jumio.ocr.impl.smartEngines.swig;

public class OcrChar {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrChar(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrChar ocrChar) {
        return ocrChar == null ? 0 : ocrChar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrChar(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrChar() {
        this(jniInterfaceJNI.new_OcrChar__SWIG_0(), true);
    }

    public OcrChar(char c, double d) {
        this(jniInterfaceJNI.new_OcrChar__SWIG_1(c, d), true);
    }

    public char getCharacter() {
        return jniInterfaceJNI.OcrChar_getCharacter(this.swigCPtr, this);
    }

    public double getProbability() {
        return jniInterfaceJNI.OcrChar_getProbability(this.swigCPtr, this);
    }
}
