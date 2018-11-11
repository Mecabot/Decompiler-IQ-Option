package com.jumio.ocr.impl.smartEngines.swig;

public class DetectionInternalSettingsFactory {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DetectionInternalSettingsFactory(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DetectionInternalSettingsFactory detectionInternalSettingsFactory) {
        return detectionInternalSettingsFactory == null ? 0 : detectionInternalSettingsFactory.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_DetectionInternalSettingsFactory(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public static DetectionInternalSettings createFromFileSystem(String str) {
        long DetectionInternalSettingsFactory_createFromFileSystem = jniInterfaceJNI.DetectionInternalSettingsFactory_createFromFileSystem(str);
        if (DetectionInternalSettingsFactory_createFromFileSystem == 0) {
            return null;
        }
        return new DetectionInternalSettings(DetectionInternalSettingsFactory_createFromFileSystem, false);
    }

    public DetectionInternalSettingsFactory() {
        this(jniInterfaceJNI.new_DetectionInternalSettingsFactory(), true);
    }
}
