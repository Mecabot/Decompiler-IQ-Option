package com.jumio.alejwt.swig;

public class JWSAlgorithm {
    public static final long HS256 = aleEngineJNI.JWSAlgorithm_HS256_get();
    public static final long NONE = aleEngineJNI.JWSAlgorithm_NONE_get();
    public static final long PS256 = aleEngineJNI.JWSAlgorithm_PS256_get();
    public static final long RS256 = aleEngineJNI.JWSAlgorithm_RS256_get();
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected JWSAlgorithm(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(JWSAlgorithm jWSAlgorithm) {
        return jWSAlgorithm == null ? 0 : jWSAlgorithm.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_JWSAlgorithm(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public JWSAlgorithm() {
        this(aleEngineJNI.new_JWSAlgorithm(), true);
    }
}
