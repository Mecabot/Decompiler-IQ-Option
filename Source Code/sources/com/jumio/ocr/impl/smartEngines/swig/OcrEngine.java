package com.jumio.ocr.impl.smartEngines.swig;

public class OcrEngine extends OcrEngineBase {
    private long swigCPtr;

    protected OcrEngine(long j, boolean z) {
        super(jniInterfaceJNI.OcrEngine_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrEngine ocrEngine) {
        return ocrEngine == null ? 0 : ocrEngine.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrEngine(this.swigCPtr);
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
        jniInterfaceJNI.OcrEngine_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniInterfaceJNI.OcrEngine_change_ownership(this, this.swigCPtr, true);
    }

    public OcrEngine(OcrEngineInternalSettings ocrEngineInternalSettings) {
        this(jniInterfaceJNI.new_OcrEngine(OcrEngineInternalSettings.getCPtr(ocrEngineInternalSettings), ocrEngineInternalSettings), true);
        jniInterfaceJNI.OcrEngine_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public OcrEngineSession createSession(ResultAcceptorInterface resultAcceptorInterface) {
        long OcrEngine_createSession__SWIG_0 = jniInterfaceJNI.OcrEngine_createSession__SWIG_0(this.swigCPtr, this, ResultAcceptorInterface.getCPtr(resultAcceptorInterface), resultAcceptorInterface);
        if (OcrEngine_createSession__SWIG_0 == 0) {
            return null;
        }
        return new OcrEngineSession(OcrEngine_createSession__SWIG_0, true);
    }

    public OcrEngineSession createSession() {
        long OcrEngine_createSession__SWIG_1 = jniInterfaceJNI.OcrEngine_createSession__SWIG_1(this.swigCPtr, this);
        if (OcrEngine_createSession__SWIG_1 == 0) {
            return null;
        }
        return new OcrEngineSession(OcrEngine_createSession__SWIG_1, true);
    }
}
