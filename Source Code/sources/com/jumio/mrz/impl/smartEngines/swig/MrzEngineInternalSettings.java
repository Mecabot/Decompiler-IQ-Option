package com.jumio.mrz.impl.smartEngines.swig;

public class MrzEngineInternalSettings {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzEngineInternalSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzEngineInternalSettings mrzEngineInternalSettings) {
        return mrzEngineInternalSettings == null ? 0 : mrzEngineInternalSettings.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngineInternalSettings(this.a);
            }
            this.a = 0;
        }
    }

    public static MrzEngineInternalSettings createFromFilesystem(String str) {
        long MrzEngineInternalSettings_createFromFilesystem = mrzjniInterfaceJNI.MrzEngineInternalSettings_createFromFilesystem(str);
        if (MrzEngineInternalSettings_createFromFilesystem == 0) {
            return null;
        }
        return new MrzEngineInternalSettings(MrzEngineInternalSettings_createFromFilesystem, false);
    }
}
