package com.jumio.mrz.impl.smartEngines.swig;

public class MrzRectVector {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzRectVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzRectVector mrzRectVector) {
        return mrzRectVector == null ? 0 : mrzRectVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzRectVector(this.a);
            }
            this.a = 0;
        }
    }

    public MrzRectVector() {
        this(mrzjniInterfaceJNI.new_MrzRectVector__SWIG_0(), true);
    }

    public MrzRectVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzRectVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzRectVector_size(this.a, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzRectVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzRectVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzRectVector_isEmpty(this.a, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzRectVector_clear(this.a, this);
    }

    public void add(MrzRect mrzRect) {
        mrzjniInterfaceJNI.MrzRectVector_add(this.a, this, MrzRect.getCPtr(mrzRect), mrzRect);
    }

    public MrzRect get(int i) {
        return new MrzRect(mrzjniInterfaceJNI.MrzRectVector_get(this.a, this, i), false);
    }

    public void set(int i, MrzRect mrzRect) {
        mrzjniInterfaceJNI.MrzRectVector_set(this.a, this, i, MrzRect.getCPtr(mrzRect), mrzRect);
    }
}
