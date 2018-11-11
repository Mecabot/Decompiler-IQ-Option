package com.jumio.mrz.impl.smartEngines.swig;

public class MrzOcrStringVector {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzOcrStringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzOcrStringVector mrzOcrStringVector) {
        return mrzOcrStringVector == null ? 0 : mrzOcrStringVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrStringVector(this.a);
            }
            this.a = 0;
        }
    }

    public MrzOcrStringVector() {
        this(mrzjniInterfaceJNI.new_MrzOcrStringVector__SWIG_0(), true);
    }

    public MrzOcrStringVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzOcrStringVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzOcrStringVector_size(this.a, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzOcrStringVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzOcrStringVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzOcrStringVector_isEmpty(this.a, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzOcrStringVector_clear(this.a, this);
    }

    public void add(MrzOcrString mrzOcrString) {
        mrzjniInterfaceJNI.MrzOcrStringVector_add(this.a, this, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString);
    }

    public MrzOcrString get(int i) {
        return new MrzOcrString(mrzjniInterfaceJNI.MrzOcrStringVector_get(this.a, this, i), false);
    }

    public void set(int i, MrzOcrString mrzOcrString) {
        mrzjniInterfaceJNI.MrzOcrStringVector_set(this.a, this, i, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString);
    }
}
