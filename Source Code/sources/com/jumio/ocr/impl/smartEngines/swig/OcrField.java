package com.jumio.ocr.impl.smartEngines.swig;

public class OcrField {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrField(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrField ocrField) {
        return ocrField == null ? 0 : ocrField.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrField(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrField(OcrCharStringVector ocrCharStringVector, boolean z) {
        this(jniInterfaceJNI.new_OcrField__SWIG_0(OcrCharStringVector.getCPtr(ocrCharStringVector), ocrCharStringVector, z), true);
    }

    public OcrField(OcrField ocrField) {
        this(jniInterfaceJNI.new_OcrField__SWIG_1(getCPtr(ocrField), ocrField), true);
    }

    public OcrCharStringVector getOcrCharVariants() {
        return new OcrCharStringVector(jniInterfaceJNI.OcrField_getOcrCharVariants(this.swigCPtr, this), false);
    }

    public boolean getToAcceptFlag() {
        return jniInterfaceJNI.OcrField_getToAcceptFlag(this.swigCPtr, this);
    }

    public OcrConfidence getConfidence() {
        return new OcrConfidence(jniInterfaceJNI.OcrField_getConfidence(this.swigCPtr, this), true);
    }

    public String getAsString() {
        return jniInterfaceJNI.OcrField_getAsString(this.swigCPtr, this);
    }

    public long getLength() {
        return jniInterfaceJNI.OcrField_getLength(this.swigCPtr, this);
    }
}
