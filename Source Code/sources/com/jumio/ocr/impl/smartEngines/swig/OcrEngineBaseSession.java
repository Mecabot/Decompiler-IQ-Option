package com.jumio.ocr.impl.smartEngines.swig;

public class OcrEngineBaseSession {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrEngineBaseSession(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrEngineBaseSession ocrEngineBaseSession) {
        return ocrEngineBaseSession == null ? 0 : ocrEngineBaseSession.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrEngineBaseSession(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        jniInterfaceJNI.OcrEngineBaseSession_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniInterfaceJNI.OcrEngineBaseSession_change_ownership(this, this.swigCPtr, true);
    }

    public OcrResult processUncompressedImageData(byte[] bArr, int i, int i2, int i3, OcrEngineSettings ocrEngineSettings) {
        long OcrEngineBaseSession_processUncompressedImageData__SWIG_0 = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedImageData__SWIG_0(this.swigCPtr, this, bArr, i, i2, i3, OcrEngineSettings.getCPtr(ocrEngineSettings), ocrEngineSettings);
        if (OcrEngineBaseSession_processUncompressedImageData__SWIG_0 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineBaseSession_processUncompressedImageData__SWIG_0, true);
    }

    public OcrResult processUncompressedImageData(byte[] bArr, int i, int i2, int i3) {
        long OcrEngineBaseSession_processUncompressedImageData__SWIG_1 = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedImageData__SWIG_1(this.swigCPtr, this, bArr, i, i2, i3);
        if (OcrEngineBaseSession_processUncompressedImageData__SWIG_1 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineBaseSession_processUncompressedImageData__SWIG_1, true);
    }

    public OcrResult processUncompressedYUVImageData(byte[] bArr, int i, int i2, int i3, OcrEngineSettings ocrEngineSettings) {
        long OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0 = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0(this.swigCPtr, this, bArr, i, i2, i3, OcrEngineSettings.getCPtr(ocrEngineSettings), ocrEngineSettings);
        if (OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_0, true);
    }

    public OcrResult processUncompressedYUVImageData(byte[] bArr, int i, int i2, int i3) {
        long OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1 = jniInterfaceJNI.OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1(this.swigCPtr, this, bArr, i, i2, i3);
        if (OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineBaseSession_processUncompressedYUVImageData__SWIG_1, true);
    }

    public boolean isRefocusRequired(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return jniInterfaceJNI.OcrEngineBaseSession_isRefocusRequired(this.swigCPtr, this, bArr, i, i2, i3, i4, i5);
    }

    public int computeFocusConfidence(byte[] bArr, int i, int i2, int i3, int i4) {
        return jniInterfaceJNI.OcrEngineBaseSession_computeFocusConfidence(this.swigCPtr, this, bArr, i, i2, i3, i4);
    }

    public float computeFlashConfidence(byte[] bArr, int i, int i2, int i3, int i4) {
        return jniInterfaceJNI.OcrEngineBaseSession_computeFlashConfidence(this.swigCPtr, this, bArr, i, i2, i3, i4);
    }

    public boolean isFlashRequired(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return jniInterfaceJNI.OcrEngineBaseSession_isFlashRequired(this.swigCPtr, this, bArr, i, i2, i3, i4, i5);
    }

    public void resetSession() {
        jniInterfaceJNI.OcrEngineBaseSession_resetSession(this.swigCPtr, this);
    }
}
