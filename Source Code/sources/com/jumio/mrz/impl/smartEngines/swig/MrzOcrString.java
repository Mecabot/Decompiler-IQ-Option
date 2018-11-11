package com.jumio.mrz.impl.smartEngines.swig;

public class MrzOcrString {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzOcrString(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzOcrString mrzOcrString) {
        return mrzOcrString == null ? 0 : mrzOcrString.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrString(this.a);
            }
            this.a = 0;
        }
    }

    public MrzOcrString() {
        this(mrzjniInterfaceJNI.new_MrzOcrString__SWIG_0(), true);
    }

    public MrzOcrString(MrzOcrCharVector mrzOcrCharVector) {
        this(mrzjniInterfaceJNI.new_MrzOcrString__SWIG_1(MrzOcrCharVector.getCPtr(mrzOcrCharVector), mrzOcrCharVector), true);
    }

    public MrzOcrCharVector getOcrChars() {
        return new MrzOcrCharVector(mrzjniInterfaceJNI.MrzOcrString_getOcrChars(this.a, this), false);
    }
}
