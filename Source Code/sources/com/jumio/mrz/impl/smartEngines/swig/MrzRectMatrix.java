package com.jumio.mrz.impl.smartEngines.swig;

public class MrzRectMatrix {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzRectMatrix(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzRectMatrix mrzRectMatrix) {
        return mrzRectMatrix == null ? 0 : mrzRectMatrix.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzRectMatrix(this.a);
            }
            this.a = 0;
        }
    }

    public MrzRectMatrix() {
        this(mrzjniInterfaceJNI.new_MrzRectMatrix__SWIG_0(), true);
    }

    public MrzRectMatrix(long j) {
        this(mrzjniInterfaceJNI.new_MrzRectMatrix__SWIG_1(j), true);
    }

    public long size() {
        return mrzjniInterfaceJNI.MrzRectMatrix_size(this.a, this);
    }

    public long capacity() {
        return mrzjniInterfaceJNI.MrzRectMatrix_capacity(this.a, this);
    }

    public void reserve(long j) {
        mrzjniInterfaceJNI.MrzRectMatrix_reserve(this.a, this, j);
    }

    public boolean isEmpty() {
        return mrzjniInterfaceJNI.MrzRectMatrix_isEmpty(this.a, this);
    }

    public void clear() {
        mrzjniInterfaceJNI.MrzRectMatrix_clear(this.a, this);
    }

    public void add(MrzRectVector mrzRectVector) {
        mrzjniInterfaceJNI.MrzRectMatrix_add(this.a, this, MrzRectVector.getCPtr(mrzRectVector), mrzRectVector);
    }

    public MrzRectVector get(int i) {
        return new MrzRectVector(mrzjniInterfaceJNI.MrzRectMatrix_get(this.a, this, i), false);
    }

    public void set(int i, MrzRectVector mrzRectVector) {
        mrzjniInterfaceJNI.MrzRectMatrix_set(this.a, this, i, MrzRectVector.getCPtr(mrzRectVector), mrzRectVector);
    }
}
