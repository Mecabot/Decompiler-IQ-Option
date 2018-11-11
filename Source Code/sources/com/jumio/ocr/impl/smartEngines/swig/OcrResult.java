package com.jumio.ocr.impl.smartEngines.swig;

public class OcrResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrResult ocrResult) {
        return ocrResult == null ? 0 : ocrResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrResult(OcrField ocrField, OcrField ocrField2, OcrField ocrField3, OcrField ocrField4, OcrField ocrField5, OcrField ocrField6, OcrField ocrField7, OcrField ocrField8, OcrQuadrangle ocrQuadrangle, boolean z, boolean z2, OcrLogoType ocrLogoType, OcrCardType ocrCardType, boolean z3, boolean z4) {
        this(jniInterfaceJNI.new_OcrResult(OcrField.getCPtr(ocrField), ocrField, OcrField.getCPtr(ocrField2), ocrField2, OcrField.getCPtr(ocrField3), ocrField3, OcrField.getCPtr(ocrField4), ocrField4, OcrField.getCPtr(ocrField5), ocrField5, OcrField.getCPtr(ocrField6), ocrField6, OcrField.getCPtr(ocrField7), ocrField7, OcrField.getCPtr(ocrField8), ocrField8, OcrQuadrangle.getCPtr(ocrQuadrangle), ocrQuadrangle, z, z2, ocrLogoType.swigValue(), ocrCardType.swigValue(), z3, z4), true);
    }

    public OcrField getCardNumber() {
        return new OcrField(jniInterfaceJNI.OcrResult_getCardNumber(this.swigCPtr, this), false);
    }

    public OcrField getCardExpiry() {
        return new OcrField(jniInterfaceJNI.OcrResult_getCardExpiry(this.swigCPtr, this), false);
    }

    public OcrField getCardName() {
        return new OcrField(jniInterfaceJNI.OcrResult_getCardName(this.swigCPtr, this), false);
    }

    public OcrField getUkSortCode() {
        return new OcrField(jniInterfaceJNI.OcrResult_getUkSortCode(this.swigCPtr, this), false);
    }

    public OcrField getUkAccountNumber() {
        return new OcrField(jniInterfaceJNI.OcrResult_getUkAccountNumber(this.swigCPtr, this), false);
    }

    public OcrField getRawSecondLine() {
        return new OcrField(jniInterfaceJNI.OcrResult_getRawSecondLine(this.swigCPtr, this), false);
    }

    public OcrField getAmexCVV() {
        return new OcrField(jniInterfaceJNI.OcrResult_getAmexCVV(this.swigCPtr, this), false);
    }

    public OcrField getSbCode() {
        return new OcrField(jniInterfaceJNI.OcrResult_getSbCode(this.swigCPtr, this), false);
    }

    public OcrQuadrangle getCardQuadrangle() {
        return new OcrQuadrangle(jniInterfaceJNI.OcrResult_getCardQuadrangle(this.swigCPtr, this), false);
    }

    public int getOrientation() {
        return jniInterfaceJNI.OcrResult_getOrientation(this.swigCPtr, this);
    }

    public boolean getShouldBeDiscardedFlag() {
        return jniInterfaceJNI.OcrResult_getShouldBeDiscardedFlag(this.swigCPtr, this);
    }

    public boolean getUpturnedCardFlag() {
        return jniInterfaceJNI.OcrResult_getUpturnedCardFlag(this.swigCPtr, this);
    }

    public OcrLogoType getLogoType() {
        return OcrLogoType.swigToEnum(jniInterfaceJNI.OcrResult_getLogoType(this.swigCPtr, this));
    }

    public OcrCardType getCardType() {
        return OcrCardType.swigToEnum(jniInterfaceJNI.OcrResult_getCardType(this.swigCPtr, this));
    }

    public boolean getUmpCardFlag() {
        return jniInterfaceJNI.OcrResult_getUmpCardFlag(this.swigCPtr, this);
    }

    public boolean getStbCardFlag() {
        return jniInterfaceJNI.OcrResult_getStbCardFlag(this.swigCPtr, this);
    }
}
