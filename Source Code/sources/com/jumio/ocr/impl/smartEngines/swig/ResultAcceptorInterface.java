package com.jumio.ocr.impl.smartEngines.swig;

import com.jumio.ocr.impl.smartEngines.swig.ResultAcceptorInterfaceSettings.FieldName;

public class ResultAcceptorInterface {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ResultAcceptorInterface(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ResultAcceptorInterface resultAcceptorInterface) {
        return resultAcceptorInterface == null ? 0 : resultAcceptorInterface.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_ResultAcceptorInterface(this.swigCPtr);
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
        jniInterfaceJNI.ResultAcceptorInterface_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        jniInterfaceJNI.ResultAcceptorInterface_change_ownership(this, this.swigCPtr, true);
    }

    public void accept(FieldName fieldName, OcrCharStringVector ocrCharStringVector, int i, int i2, ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings, boolean z) {
        if (getClass() == ResultAcceptorInterface.class) {
            jniInterfaceJNI.ResultAcceptorInterface_accept(this.swigCPtr, this, fieldName.swigValue(), OcrCharStringVector.getCPtr(ocrCharStringVector), ocrCharStringVector, i, i2, ResultAcceptorInterfaceSettings.getCPtr(resultAcceptorInterfaceSettings), resultAcceptorInterfaceSettings, z);
            return;
        }
        jniInterfaceJNI.ResultAcceptorInterface_acceptSwigExplicitResultAcceptorInterface(this.swigCPtr, this, fieldName.swigValue(), OcrCharStringVector.getCPtr(ocrCharStringVector), ocrCharStringVector, i, i2, ResultAcceptorInterfaceSettings.getCPtr(resultAcceptorInterfaceSettings), resultAcceptorInterfaceSettings, z);
    }

    public ResultAcceptorInterface() {
        this(jniInterfaceJNI.new_ResultAcceptorInterface(), true);
        jniInterfaceJNI.ResultAcceptorInterface_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }
}
