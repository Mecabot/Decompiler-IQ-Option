package com.jumio.ocr.impl.smartEngines.swig;

public class OcrEngineSession extends OcrEngineBaseSession {
    private long swigCPtr;

    protected OcrEngineSession(long j, boolean z) {
        super(jniInterfaceJNI.OcrEngineSession_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrEngineSession ocrEngineSession) {
        return ocrEngineSession == null ? 0 : ocrEngineSession.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrEngineSession(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
        super.delete();
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        jniInterfaceJNI.OcrEngineSession_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniInterfaceJNI.OcrEngineSession_change_ownership(this, this.swigCPtr, true);
    }

    public OcrResult processImageFile(String str, OcrEngineSettings ocrEngineSettings) {
        long OcrEngineSession_processImageFile__SWIG_0 = jniInterfaceJNI.OcrEngineSession_processImageFile__SWIG_0(this.swigCPtr, this, str, OcrEngineSettings.getCPtr(ocrEngineSettings), ocrEngineSettings);
        if (OcrEngineSession_processImageFile__SWIG_0 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineSession_processImageFile__SWIG_0, true);
    }

    public OcrResult processImageFile(String str) {
        long OcrEngineSession_processImageFile__SWIG_1 = jniInterfaceJNI.OcrEngineSession_processImageFile__SWIG_1(this.swigCPtr, this, str);
        if (OcrEngineSession_processImageFile__SWIG_1 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineSession_processImageFile__SWIG_1, true);
    }

    public OcrResult processImageData(byte[] bArr, OcrEngineSettings ocrEngineSettings) {
        long OcrEngineSession_processImageData__SWIG_0 = jniInterfaceJNI.OcrEngineSession_processImageData__SWIG_0(this.swigCPtr, this, bArr, OcrEngineSettings.getCPtr(ocrEngineSettings), ocrEngineSettings);
        if (OcrEngineSession_processImageData__SWIG_0 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineSession_processImageData__SWIG_0, true);
    }

    public OcrResult processImageData(byte[] bArr) {
        long OcrEngineSession_processImageData__SWIG_1 = jniInterfaceJNI.OcrEngineSession_processImageData__SWIG_1(this.swigCPtr, this, bArr);
        if (OcrEngineSession_processImageData__SWIG_1 == 0) {
            return null;
        }
        return new OcrResult(OcrEngineSession_processImageData__SWIG_1, true);
    }
}
