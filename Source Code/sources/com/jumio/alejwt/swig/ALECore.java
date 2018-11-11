package com.jumio.alejwt.swig;

public class ALECore {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected ALECore(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ALECore aLECore) {
        return aLECore == null ? 0 : aLECore.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALECore(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ALECore(ALESettings aLESettings) {
        this(aleEngineJNI.new_ALECore(ALESettings.getCPtr(aLESettings), aLESettings), true);
    }

    public ALERequest createRequest() {
        long ALECore_createRequest = aleEngineJNI.ALECore_createRequest(this.swigCPtr, this);
        if (ALECore_createRequest == 0) {
            return null;
        }
        return new ALERequest(ALECore_createRequest, false);
    }

    public void destroyRequest(ALERequest aLERequest) {
        aleEngineJNI.ALECore_destroyRequest(this.swigCPtr, this, ALERequest.getCPtr(aLERequest), aLERequest);
    }
}
