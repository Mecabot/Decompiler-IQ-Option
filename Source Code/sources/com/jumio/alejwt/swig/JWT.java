package com.jumio.alejwt.swig;

public class JWT {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected JWT(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(JWT jwt) {
        return jwt == null ? 0 : jwt.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_JWT(this.swigCPtr);
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
        aleEngineJNI.JWT_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        aleEngineJNI.JWT_change_ownership(this, this.swigCPtr, true);
    }

    public JWT() {
        this(aleEngineJNI.new_JWT(), true);
        aleEngineJNI.JWT_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void parse(byte[] bArr) {
        aleEngineJNI.JWT_parse(this.swigCPtr, this, bArr);
    }

    public void useGzip(boolean z) {
        aleEngineJNI.JWT_useGzip(this.swigCPtr, this, z);
    }

    public boolean isGzip() {
        return aleEngineJNI.JWT_isGzip(this.swigCPtr, this);
    }

    public void setAlgorithm(long j) {
        aleEngineJNI.JWT_setAlgorithm(this.swigCPtr, this, j);
    }

    public long getAlgorithm() {
        return aleEngineJNI.JWT_getAlgorithm(this.swigCPtr, this);
    }

    public int getPayloadLength() {
        return aleEngineJNI.JWT_getPayloadLength(this.swigCPtr, this);
    }

    public int getPayload(byte[] bArr) {
        return aleEngineJNI.JWT_getPayload(this.swigCPtr, this, bArr);
    }

    public void setPublicKey(byte[] bArr) {
        aleEngineJNI.JWT_setPublicKey(this.swigCPtr, this, bArr);
    }
}
