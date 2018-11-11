package com.jumio.mrz.impl.smartEngines.swig;

public class MrzOcrCharVariant {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzOcrCharVariant(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzOcrCharVariant mrzOcrCharVariant) {
        return mrzOcrCharVariant == null ? 0 : mrzOcrCharVariant.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzOcrCharVariant(this.a);
            }
            this.a = 0;
        }
    }

    public MrzOcrCharVariant() {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariant__SWIG_0(), true);
    }

    public MrzOcrCharVariant(char c, double d) {
        this(mrzjniInterfaceJNI.new_MrzOcrCharVariant__SWIG_1(c, d), true);
    }

    public char getCharacter() {
        return mrzjniInterfaceJNI.MrzOcrCharVariant_getCharacter(this.a, this);
    }

    public double getConfidence() {
        return mrzjniInterfaceJNI.MrzOcrCharVariant_getConfidence(this.a, this);
    }
}
