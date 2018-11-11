package com.jumio.ocr.impl.smartEngines.swig;

public class DetectionInternalSettings {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DetectionInternalSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DetectionInternalSettings detectionInternalSettings) {
        return detectionInternalSettings == null ? 0 : detectionInternalSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_DetectionInternalSettings(this.swigCPtr);
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
        jniInterfaceJNI.DetectionInternalSettings_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniInterfaceJNI.DetectionInternalSettings_change_ownership(this, this.swigCPtr, true);
    }

    public DetectionInternalSettings() {
        this(jniInterfaceJNI.new_DetectionInternalSettings(), true);
        jniInterfaceJNI.DetectionInternalSettings_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
