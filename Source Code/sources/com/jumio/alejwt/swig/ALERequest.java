package com.jumio.alejwt.swig;

public class ALERequest {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ALERequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ALERequest aLERequest) {
        return aLERequest == null ? 0 : aLERequest.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0;
        }
    }

    public int calculateRequestSize(ALEHeader aLEHeader, int i) {
        return aleEngineJNI.ALERequest_calculateRequestSize(this.swigCPtr, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i);
    }

    public int calculateRequestInit(ALEHeader aLEHeader, int i) {
        return aleEngineJNI.ALERequest_calculateRequestInit(this.swigCPtr, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i);
    }

    public int calculateRequestUpdate(int i) {
        return aleEngineJNI.ALERequest_calculateRequestUpdate(this.swigCPtr, this, i);
    }

    public int calculateRequestFinish() {
        return aleEngineJNI.ALERequest_calculateRequestFinish(this.swigCPtr, this);
    }

    public int initRequest(ALEHeader aLEHeader, int i, byte[] bArr, int i2) {
        return aleEngineJNI.ALERequest_initRequest__SWIG_0(this.swigCPtr, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i, bArr, i2);
    }

    public int initRequest(ALEHeader aLEHeader, int i, byte[] bArr) {
        return aleEngineJNI.ALERequest_initRequest__SWIG_1(this.swigCPtr, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i, bArr);
    }

    public int updateRequest(byte[] bArr, byte[] bArr2, int i) {
        return aleEngineJNI.ALERequest_updateRequest__SWIG_0(this.swigCPtr, this, bArr, bArr2, i);
    }

    public int updateRequest(byte[] bArr, byte[] bArr2) {
        return aleEngineJNI.ALERequest_updateRequest__SWIG_1(this.swigCPtr, this, bArr, bArr2);
    }

    public int finishRequest(byte[] bArr, int i) {
        return aleEngineJNI.ALERequest_finishRequest__SWIG_0(this.swigCPtr, this, bArr, i);
    }

    public int finishRequest(byte[] bArr) {
        return aleEngineJNI.ALERequest_finishRequest__SWIG_1(this.swigCPtr, this, bArr);
    }

    public int request(ALEHeader aLEHeader, byte[] bArr, byte[] bArr2, int i) {
        return aleEngineJNI.ALERequest_request__SWIG_0(this.swigCPtr, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, bArr, bArr2, i);
    }

    public int request(ALEHeader aLEHeader, byte[] bArr, byte[] bArr2) {
        return aleEngineJNI.ALERequest_request__SWIG_1(this.swigCPtr, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, bArr, bArr2);
    }

    public int calculateResponseSize(byte[] bArr) {
        return aleEngineJNI.ALERequest_calculateResponseSize(this.swigCPtr, this, bArr);
    }

    public void initResponse() {
        aleEngineJNI.ALERequest_initResponse(this.swigCPtr, this);
    }

    public int updateResponse(byte[] bArr, byte[] bArr2, int i) {
        return aleEngineJNI.ALERequest_updateResponse__SWIG_0(this.swigCPtr, this, bArr, bArr2, i);
    }

    public int updateResponse(byte[] bArr, byte[] bArr2) {
        return aleEngineJNI.ALERequest_updateResponse__SWIG_1(this.swigCPtr, this, bArr, bArr2);
    }

    public boolean finishResponse() {
        return aleEngineJNI.ALERequest_finishResponse(this.swigCPtr, this);
    }

    public int response(byte[] bArr, byte[] bArr2, int i) {
        return aleEngineJNI.ALERequest_response__SWIG_0(this.swigCPtr, this, bArr, bArr2, i);
    }

    public int response(byte[] bArr, byte[] bArr2) {
        return aleEngineJNI.ALERequest_response__SWIG_1(this.swigCPtr, this, bArr, bArr2);
    }

    public boolean isVerified() {
        return aleEngineJNI.ALERequest_isVerified(this.swigCPtr, this);
    }

    public boolean isKeyUpdate() {
        return aleEngineJNI.ALERequest_isKeyUpdate(this.swigCPtr, this);
    }

    public int getErrorCode() {
        return aleEngineJNI.ALERequest_getErrorCode(this.swigCPtr, this);
    }
}
