package com.jumio.mrz.impl.smartEngines.swig;

public class StringVector {
    private long a;
    protected boolean swigCMemOwn;

    protected StringVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(StringVector stringVector) {
        return stringVector == null ? 0 : stringVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_StringVector(this.a);
            }
            this.a = 0;
        }
    }

    public StringVector() {
        this(mrzjniInterfaceJNI.new_StringVector__SWIG_0(), true);
    }

    public StringVector(long j) {
        this(mrzjniInterfaceJNI.new_StringVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.StringVector_size(this.a, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.StringVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.StringVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.StringVector_isEmpty(this.a, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.StringVector_clear(this.a, this);
    }

    public void add(String str) {
        mrzjniInterfaceJNI.StringVector_add(this.a, this, str);
    }

    public String get(int i) {
        return mrzjniInterfaceJNI.StringVector_get(this.a, this, i);
    }

    public void set(int i, String str) {
        mrzjniInterfaceJNI.StringVector_set(this.a, this, i, str);
    }
}
