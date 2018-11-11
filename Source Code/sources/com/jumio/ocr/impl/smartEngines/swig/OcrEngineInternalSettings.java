package com.jumio.ocr.impl.smartEngines.swig;

public class OcrEngineInternalSettings {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected OcrEngineInternalSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OcrEngineInternalSettings ocrEngineInternalSettings) {
        return ocrEngineInternalSettings == null ? 0 : ocrEngineInternalSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_OcrEngineInternalSettings(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public static OcrEngineInternalSettings createFromFilesystem(String str) {
        long OcrEngineInternalSettings_createFromFilesystem = jniInterfaceJNI.OcrEngineInternalSettings_createFromFilesystem(str);
        if (OcrEngineInternalSettings_createFromFilesystem == 0) {
            return null;
        }
        return new OcrEngineInternalSettings(OcrEngineInternalSettings_createFromFilesystem, false);
    }
}
