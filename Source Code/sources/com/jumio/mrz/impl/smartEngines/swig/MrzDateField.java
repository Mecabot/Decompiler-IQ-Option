package com.jumio.mrz.impl.smartEngines.swig;

public class MrzDateField extends MrzField {
    private long a;

    protected MrzDateField(long j, boolean z) {
        super(mrzjniInterfaceJNI.MrzDateField_SWIGUpcast(j), z);
        this.a = j;
    }

    protected static long getCPtr(MrzDateField mrzDateField) {
        return mrzDateField == null ? 0 : mrzDateField.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzDateField(this.a);
            }
            this.a = 0;
        }
        super.delete();
    }

    public MrzDateField() {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_0(), true);
    }

    public MrzDateField(MrzDate mrzDate, boolean z, double d) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_1(MrzDate.getCPtr(mrzDate), mrzDate, z, d), true);
    }

    public MrzDateField(MrzDate mrzDate, boolean z) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_2(MrzDate.getCPtr(mrzDate), mrzDate, z), true);
    }

    public MrzDateField(MrzDate mrzDate) {
        this(mrzjniInterfaceJNI.new_MrzDateField__SWIG_3(MrzDate.getCPtr(mrzDate), mrzDate), true);
    }

    public MrzDateField(MrzDate mrzDate, boolean z, double d, MrzOcrString mrzOcrString, MrzOcrChar mrzOcrChar) {
        long new_MrzDateField__SWIG_4 = mrzjniInterfaceJNI.new_MrzDateField__SWIG_4(MrzDate.getCPtr(mrzDate), mrzDate, z, d, MrzOcrString.getCPtr(mrzOcrString), mrzOcrString, MrzOcrChar.getCPtr(mrzOcrChar), mrzOcrChar);
        this(new_MrzDateField__SWIG_4, true);
    }

    public MrzDate getAsMrzDate() {
        return new MrzDate(mrzjniInterfaceJNI.MrzDateField_getAsMrzDate(this.a, this), false);
    }
}
