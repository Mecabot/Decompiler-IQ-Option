package com.jumio.ocr.impl.smartEngines.swig;

public class DetectionEngine {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DetectionEngine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DetectionEngine detectionEngine) {
        return detectionEngine == null ? 0 : detectionEngine.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_DetectionEngine(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DetectionEngine(DetectionSettings detectionSettings, DetectionInternalSettings detectionInternalSettings) {
        this(jniInterfaceJNI.new_DetectionEngine(DetectionSettings.getCPtr(detectionSettings), detectionSettings, DetectionInternalSettings.getCPtr(detectionInternalSettings), detectionInternalSettings), true);
    }

    public void resetSession() {
        jniInterfaceJNI.DetectionEngine_resetSession(this.swigCPtr, this);
    }

    public DetectionResult processRawImage(byte[] bArr, int i, int i2, int i3, int i4) {
        return new DetectionResult(jniInterfaceJNI.DetectionEngine_processRawImage(this.swigCPtr, this, bArr, i, i2, i3, i4), true);
    }

    public DetectionResult processRawYUVImage(byte[] bArr, int i, int i2, int i3, int i4) {
        return new DetectionResult(jniInterfaceJNI.DetectionEngine_processRawYUVImage(this.swigCPtr, this, bArr, i, i2, i3, i4), true);
    }
}
