package com.jumio.ocr.impl.smartEngines.swig;

public class DetectionSettings {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected DetectionSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DetectionSettings detectionSettings) {
        return detectionSettings == null ? 0 : detectionSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_DetectionSettings(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public DetectionSettings() {
        this(jniInterfaceJNI.new_DetectionSettings(), true);
    }

    public double getRoiLeftMargin() {
        return jniInterfaceJNI.DetectionSettings_getRoiLeftMargin(this.swigCPtr, this);
    }

    public double getRoiTopMargin() {
        return jniInterfaceJNI.DetectionSettings_getRoiTopMargin(this.swigCPtr, this);
    }

    public double getRoiRightMargin() {
        return jniInterfaceJNI.DetectionSettings_getRoiRightMargin(this.swigCPtr, this);
    }

    public double getRoiBottomMargin() {
        return jniInterfaceJNI.DetectionSettings_getRoiBottomMargin(this.swigCPtr, this);
    }

    public double getRoiVerticalDeviation() {
        return jniInterfaceJNI.DetectionSettings_getRoiVerticalDeviation(this.swigCPtr, this);
    }

    public double getRoiHorizontalDeviation() {
        return jniInterfaceJNI.DetectionSettings_getRoiHorizontalDeviation(this.swigCPtr, this);
    }

    public void setRoiLeftMargin(double d) {
        jniInterfaceJNI.DetectionSettings_setRoiLeftMargin(this.swigCPtr, this, d);
    }

    public void setRoiTopMargin(double d) {
        jniInterfaceJNI.DetectionSettings_setRoiTopMargin(this.swigCPtr, this, d);
    }

    public void setRoiRightMargin(double d) {
        jniInterfaceJNI.DetectionSettings_setRoiRightMargin(this.swigCPtr, this, d);
    }

    public void setRoiBottomMargin(double d) {
        jniInterfaceJNI.DetectionSettings_setRoiBottomMargin(this.swigCPtr, this, d);
    }

    public void setRoiVerticalDeviation(double d) {
        jniInterfaceJNI.DetectionSettings_setRoiVerticalDeviation(this.swigCPtr, this, d);
    }

    public void setRoiHorizontalDeviation(double d) {
        jniInterfaceJNI.DetectionSettings_setRoiHorizontalDeviation(this.swigCPtr, this, d);
    }
}
