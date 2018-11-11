package com.jumio.mrz.impl.smartEngines.swig;

public class MrzOcrChar {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzOcrChar(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzOcrChar mrzOcrChar) {
        return mrzOcrChar == null ? 0 : mrzOcrChar.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrChar(this.a);
            }
            this.a = 0;
        }
    }

    public MrzOcrChar() {
        this(mrzjniInterfaceJNI.new_MrzOcrChar__SWIG_0(), true);
    }

    public MrzOcrChar(MrzOcrCharVariantVector mrzOcrCharVariantVector, boolean z, boolean z2, boolean z3) {
        this(mrzjniInterfaceJNI.new_MrzOcrChar__SWIG_1(MrzOcrCharVariantVector.getCPtr(mrzOcrCharVariantVector), mrzOcrCharVariantVector, z, z2, z3), true);
    }

    public MrzOcrCharVariantVector getOcrCharVariants() {
        return new MrzOcrCharVariantVector(mrzjniInterfaceJNI.MrzOcrChar_getOcrCharVariants(this.a, this), false);
    }

    public boolean isHighlighted() {
        return mrzjniInterfaceJNI.MrzOcrChar_isHighlighted(this.a, this);
    }

    public boolean isCorrected() {
        return mrzjniInterfaceJNI.MrzOcrChar_isCorrected(this.a, this);
    }

    public boolean isFoundInDictionary() {
        return mrzjniInterfaceJNI.MrzOcrChar_isFoundInDictionary(this.a, this);
    }

    public char GetChar() {
        return mrzjniInterfaceJNI.MrzOcrChar_GetChar(this.a, this);
    }
}
