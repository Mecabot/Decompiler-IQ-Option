package com.jumio.mrz.impl.smartEngines.swig;

public class MrzOcrCharVector {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzOcrCharVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzOcrCharVector mrzOcrCharVector) {
        return mrzOcrCharVector == null ? 0 : mrzOcrCharVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVector(this.a);
            }
            this.a = 0;
        }
    }

    public MrzOcrCharVector() {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVector__SWIG_0(), true);
    }

    public MrzOcrCharVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzOcrCharVector_size(this.a, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzOcrCharVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzOcrCharVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzOcrCharVector_isEmpty(this.a, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzOcrCharVector_clear(this.a, this);
    }

    public void add(MrzOcrChar mrzOcrChar) {
        mrzjniInterfaceJNI.MrzOcrCharVector_add(this.a, this, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar);
    }

    public MrzOcrChar get(int i) {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzOcrCharVector_get(this.a, this, i), false);
    }

    public void set(int i, MrzOcrChar mrzOcrChar) {
        mrzjniInterfaceJNI.MrzOcrCharVector_set(this.a, this, i, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar);
    }
}
