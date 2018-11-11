package com.jumio.mrz.impl.smartEngines.swig;

public class MrzOcrCharVariantVector {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzOcrCharVariantVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzOcrCharVariantVector mrzOcrCharVariantVector) {
        return mrzOcrCharVariantVector == null ? 0 : mrzOcrCharVariantVector.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVariantVector(this.a);
            }
            this.a = 0;
        }
    }

    public MrzOcrCharVariantVector() {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariantVector__SWIG_0(), true);
    }

    public MrzOcrCharVariantVector(long j) {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariantVector__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_size(this.a, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_capacity(this.a, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzOcrCharVariantVector_isEmpty(this.a, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_clear(this.a, this);
    }

    public void add(MrzOcrCharVariant mrzOcrCharVariant) {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_add(this.a, this, MrzOcrCharVariant.getCPtr(mrzOcrCharVariant), mrzOcrCharVariant);
    }

    public MrzOcrCharVariant get(int i) {
        return new MrzOcrCharVariant(mrzjniInterfaceJNI.MrzOcrCharVariantVector_get(this.a, this, i), false);
    }

    public void set(int i, MrzOcrCharVariant mrzOcrCharVariant) {
        mrzjniInterfaceJNI.MrzOcrCharVariantVector_set(this.a, this, i, MrzOcrCharVariant.getCPtr(mrzOcrCharVariant), mrzOcrCharVariant);
    }
}
