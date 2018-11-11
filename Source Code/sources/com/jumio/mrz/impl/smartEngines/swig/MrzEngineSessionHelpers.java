package com.jumio.mrz.impl.smartEngines.swig;

public class MrzEngineSessionHelpers {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzEngineSessionHelpers(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzEngineSessionHelpers mrzEngineSessionHelpers) {
        return mrzEngineSessionHelpers == null ? 0 : mrzEngineSessionHelpers.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzEngineSessionHelpers(this.a);
            }
            this.a = 0;
        }
    }

    public double get_optimal_aspect_ratio() {
        return mrzjniInterfaceJNI.MrzEngineSessionHelpers_get_optimal_aspect_ratio(this.a, this);
    }

    public void set_optimal_aspect_ratio(double d) {
        mrzjniInterfaceJNI.MrzEngineSessionHelpers_set_optimal_aspect_ratio(this.a, this, d);
    }

    public MrzEngineSessionHelpers() {
        this(mrzjniInterfaceJNI.new_MrzEngineSessionHelpers(), true);
    }
}
