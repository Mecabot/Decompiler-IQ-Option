package com.jumio.ocr.impl.smartEngines.swig;

public class OcrEngineSettings {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrEngineSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrEngineSettings ocrEngineSettings) {
        return ocrEngineSettings == null ? 0 : ocrEngineSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrEngineSettings(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public OcrEngineSettings() {
        this(jniInterfaceJNI.new_OcrEngineSettings__SWIG_0(), true);
    }

    public OcrEngineSettings(OcrEngineSettings ocrEngineSettings) {
        this(jniInterfaceJNI.new_OcrEngineSettings__SWIG_1(getCPtr(ocrEngineSettings), ocrEngineSettings), true);
    }

    public int getNumberOfQuadranglesToProcess() {
        return jniInterfaceJNI.OcrEngineSettings_getNumberOfQuadranglesToProcess(this.swigCPtr, this);
    }

    public OcrQuadrangleVector getPreDetectedQuadrangles() {
        return new OcrQuadrangleVector(jniInterfaceJNI.OcrEngineSettings_getPreDetectedQuadrangles(this.swigCPtr, this), false);
    }

    public boolean getNumberRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getNumberRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getExpiryRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getExpiryRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getNameRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getNameRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getUkSortCodeAccountNumberRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getUkSortCodeAccountNumberRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getAmexCVVRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getAmexCVVRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getSbcodeRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getSbcodeRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getNumberContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getNumberContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean getExpiryContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getExpiryContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean getNameContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getNameContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean getUkSortCodeAccountNumberContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getUkSortCodeAccountNumberContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean getRawSecondLineRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getRawSecondLineRecognitionFlag(this.swigCPtr, this);
    }

    public boolean getUseAdvAcceptDictFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getUseAdvAcceptDictFlag(this.swigCPtr, this);
    }

    public boolean getCheckChinaUnionPayLuhnCodeFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getCheckChinaUnionPayLuhnCodeFlag(this.swigCPtr, this);
    }

    public boolean getCheckStarbucksFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getCheckStarbucksFlag(this.swigCPtr, this);
    }

    public boolean getCheckUmpFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getCheckUmpFlag(this.swigCPtr, this);
    }

    public boolean getUpturnedCardDetectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getUpturnedCardDetectionFlag(this.swigCPtr, this);
    }

    public int getFocusThreshold() {
        return jniInterfaceJNI.OcrEngineSettings_getFocusThreshold(this.swigCPtr, this);
    }

    public int getIntensityThreshold() {
        return jniInterfaceJNI.OcrEngineSettings_getIntensityThreshold(this.swigCPtr, this);
    }

    public boolean getLogoAnalysisFlag() {
        return jniInterfaceJNI.OcrEngineSettings_getLogoAnalysisFlag(this.swigCPtr, this);
    }

    public void setNumberOfQuadranglesToProcess(int i) {
        jniInterfaceJNI.OcrEngineSettings_setNumberOfQuadranglesToProcess(this.swigCPtr, this, i);
    }

    public void setPreDetectedQuadrangles(OcrQuadrangleVector ocrQuadrangleVector) {
        jniInterfaceJNI.OcrEngineSettings_setPreDetectedQuadrangles(this.swigCPtr, this, OcrQuadrangleVector.getCPtr(ocrQuadrangleVector), ocrQuadrangleVector);
    }

    public void setNumberRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setNumberRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setExpiryRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setExpiryRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setNameRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setNameRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setNumberContextCorrectionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setNumberContextCorrectionFlag(this.swigCPtr, this, z);
    }

    public void setExpiryContextCorrectionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setExpiryContextCorrectionFlag(this.swigCPtr, this, z);
    }

    public void setNameContextCorrectionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setNameContextCorrectionFlag(this.swigCPtr, this, z);
    }

    public void setUkSortCodeAccountNumberRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setUkSortCodeAccountNumberRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setUkSortCodeAccountNumberContextCorrectionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setUkSortCodeAccountNumberContextCorrectionFlag(this.swigCPtr, this, z);
    }

    public void setAmexCVVRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setAmexCVVRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setSbcodeRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setSbcodeRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setRawSecondLineRecognitionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setRawSecondLineRecognitionFlag(this.swigCPtr, this, z);
    }

    public void setUseAdvAcceptDictFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setUseAdvAcceptDictFlag(this.swigCPtr, this, z);
    }

    public void setCheckChinaUnionPayLuhnCodeFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setCheckChinaUnionPayLuhnCodeFlag(this.swigCPtr, this, z);
    }

    public void setCheckStarbucksFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setCheckStarbucksFlag(this.swigCPtr, this, z);
    }

    public void setCheckUmpFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setCheckUmpFlag(this.swigCPtr, this, z);
    }

    public void setUpturnedCardDetectionFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setUpturnedCardDetectionFlag(this.swigCPtr, this, z);
    }

    public void setFocusThreshold(int i) {
        jniInterfaceJNI.OcrEngineSettings_setFocusThreshold(this.swigCPtr, this, i);
    }

    public void setIntensityThreshold(int i) {
        jniInterfaceJNI.OcrEngineSettings_setIntensityThreshold(this.swigCPtr, this, i);
    }

    public void setLogoAnalysisFlag(boolean z) {
        jniInterfaceJNI.OcrEngineSettings_setLogoAnalysisFlag(this.swigCPtr, this, z);
    }

    public boolean isOverridenNumberOfQuadranglesToProcess() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNumberOfQuadranglesToProcess(this.swigCPtr, this);
    }

    public boolean isOverridenPreDetectedQuadrangles() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenPreDetectedQuadrangles(this.swigCPtr, this);
    }

    public boolean isOverridenNumberRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNumberRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenExpiryRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenExpiryRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenNameRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNameRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenAmexCVVRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenAmexCVVRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenSbcodeRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenSbcodeRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenNumberContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNumberContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenExpiryContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenExpiryContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenNameContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenNameContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenUkSortCodeAccountNumberRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUkSortCodeAccountNumberRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenUkSortCodeAccountNumberContextCorrectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUkSortCodeAccountNumberContextCorrectionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenRawSecondLineRecognitionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenRawSecondLineRecognitionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenUseAdvAcceptDictFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUseAdvAcceptDictFlag(this.swigCPtr, this);
    }

    public boolean isOverridenCheckChinaUnionPayLuhnCodeFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenCheckChinaUnionPayLuhnCodeFlag(this.swigCPtr, this);
    }

    public boolean isOverridenCheckStarbucksFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenCheckStarbucksFlag(this.swigCPtr, this);
    }

    public boolean isOverridenCheckUmpFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenCheckUmpFlag(this.swigCPtr, this);
    }

    public boolean isOverridenUpturnedCardDetectionFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenUpturnedCardDetectionFlag(this.swigCPtr, this);
    }

    public boolean isOverridenFocusThreshold() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenFocusThreshold(this.swigCPtr, this);
    }

    public boolean isOverridenIntensityThreshold() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenIntensityThreshold(this.swigCPtr, this);
    }

    public boolean isOverridenLogoAnalysisFlag() {
        return jniInterfaceJNI.OcrEngineSettings_isOverridenLogoAnalysisFlag(this.swigCPtr, this);
    }
}
