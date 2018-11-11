package com.jumio.mrz.impl.smartEngines.swig;

public class MrzField {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzField(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzField mrzField) {
        return mrzField == null ? 0 : mrzField.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzField(this.a);
            }
            this.a = 0;
        }
    }

    public MrzField() {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_0(), true);
    }

    public MrzField(String str, boolean z, double d) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_1(str, z, d), true);
    }

    public MrzField(String str, boolean z) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_2(str, z), true);
    }

    public MrzField(String str) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_3(str), true);
    }

    public MrzField(String str, boolean z, double d, MrzOcrString mrzOcrString, MrzOcrChar mrzOcrChar) {
        this(mrzjniInterfaceJNI.new_MrzField__SWIG_4(str, z, d, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar), true);
    }

    public String getAsString() {
        return mrzjniInterfaceJNI.MrzField_getAsString(this.a, this);
    }

    public boolean isAccepted() {
        return mrzjniInterfaceJNI.MrzField_isAccepted(this.a, this);
    }

    public double getConfidence() {
        return mrzjniInterfaceJNI.MrzField_getConfidence(this.a, this);
    }

    public MrzOcrString getOcrString() {
        return new MrzOcrString(mrzjniInterfaceJNI.MrzField_getOcrString(this.a, this), false);
    }

    public int calculateChecksum() {
        return mrzjniInterfaceJNI.MrzField_calculateChecksum(this.a, this);
    }

    public boolean hasChecksumOcrChar() {
        return mrzjniInterfaceJNI.MrzField_hasChecksumOcrChar(this.a, this);
    }

    public MrzOcrChar getChecksumOcrChar() {
        return new MrzOcrChar(mrzjniInterfaceJNI.MrzField_getChecksumOcrChar(this.a, this), false);
    }

    public boolean hasCorrectChecksum() {
        return mrzjniInterfaceJNI.MrzField_hasCorrectChecksum(this.a, this);
    }
}
