package com.jumio.ocr.impl.smartEngines.swig;

public class DetectionResult {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DetectionResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DetectionResult detectionResult) {
        return detectionResult == null ? 0 : detectionResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_DetectionResult(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DetectionResult() {
        this(jniInterfaceJNI.new_DetectionResult__SWIG_0(), true);
    }

    public DetectionResult(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, OcrPoint ocrPoint, OcrPoint ocrPoint2, boolean z7, OcrQuadrangle ocrQuadrangle) {
        long new_DetectionResult__SWIG_1 = jniInterfaceJNI.new_DetectionResult__SWIG_1(z, z2, i, z3, z4, z5, z6, OcrPoint.getCPtr(ocrPoint), ocrPoint, OcrPoint.getCPtr(ocrPoint2), ocrPoint2, z7, OcrQuadrangle.getCPtr(ocrQuadrangle), ocrQuadrangle);
        this(new_DetectionResult__SWIG_1, true);
    }

    public boolean isCardInRoi() {
        return jniInterfaceJNI.DetectionResult_isCardInRoi(this.swigCPtr, this);
    }

    public boolean isCardImageOfGoodQuality() {
        return jniInterfaceJNI.DetectionResult_isCardImageOfGoodQuality(this.swigCPtr, this);
    }

    public int getCardImageQualityScore() {
        return jniInterfaceJNI.DetectionResult_getCardImageQualityScore(this.swigCPtr, this);
    }

    public boolean hasTopOfCard() {
        return jniInterfaceJNI.DetectionResult_hasTopOfCard(this.swigCPtr, this);
    }

    public boolean hasBottomOfCard() {
        return jniInterfaceJNI.DetectionResult_hasBottomOfCard(this.swigCPtr, this);
    }

    public boolean hasLeftOfCard() {
        return jniInterfaceJNI.DetectionResult_hasLeftOfCard(this.swigCPtr, this);
    }

    public boolean hasRightOfCard() {
        return jniInterfaceJNI.DetectionResult_hasRightOfCard(this.swigCPtr, this);
    }

    public OcrPoint getFocusPointOfInterest() {
        return new OcrPoint(jniInterfaceJNI.DetectionResult_getFocusPointOfInterest(this.swigCPtr, this), true);
    }

    public OcrPoint getExposurePointOfInterest() {
        return new OcrPoint(jniInterfaceJNI.DetectionResult_getExposurePointOfInterest(this.swigCPtr, this), true);
    }

    public boolean getFlashTurnOn() {
        return jniInterfaceJNI.DetectionResult_getFlashTurnOn(this.swigCPtr, this);
    }

    public OcrQuadrangle getCardQuadrangle() {
        return new OcrQuadrangle(jniInterfaceJNI.DetectionResult_getCardQuadrangle(this.swigCPtr, this), true);
    }
}
