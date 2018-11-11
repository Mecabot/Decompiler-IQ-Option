package com.jumio.alejwt.swig;

public class ALESettings {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ALESettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ALESettings aLESettings) {
        return aLESettings == null ? 0 : aLESettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALESettings(this.swigCPtr);
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
        aleEngineJNI.ALESettings_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        aleEngineJNI.ALESettings_change_ownership(this, this.swigCPtr, true);
    }

    public ALESettings() {
        this(aleEngineJNI.new_ALESettings(), true);
        aleEngineJNI.ALESettings_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void setDirectory(String str) {
        aleEngineJNI.ALESettings_setDirectory(this.swigCPtr, this, str);
    }

    public String getDirectory() {
        return aleEngineJNI.ALESettings_getDirectory(this.swigCPtr, this);
    }

    public void setKeyID(String str) {
        aleEngineJNI.ALESettings_setKeyID(this.swigCPtr, this, str);
    }

    public String getKeyID() {
        return aleEngineJNI.ALESettings_getKeyID(this.swigCPtr, this);
    }

    public void setPublicKey(String str) {
        aleEngineJNI.ALESettings_setPublicKey(this.swigCPtr, this, str);
    }

    public String getPublicKey() {
        return aleEngineJNI.ALESettings_getPublicKey(this.swigCPtr, this);
    }
}
