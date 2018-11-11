package com.jumio.mrz.impl.smartEngines.swig;

public class MrzDate {
    private long a;
    protected boolean swigCMemOwn;

    protected MrzDate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.a = j;
    }

    protected static long getCPtr(MrzDate mrzDate) {
        return mrzDate == null ? 0 : mrzDate.a;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.a != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                mrzjniInterfaceJNI.delete_MrzDate(this.a);
            }
            this.a = 0;
        }
    }

    public MrzDate(int i, int i2, int i3) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_0(i, i2, i3), true);
    }

    public MrzDate(int i, int i2) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_1(i, i2), true);
    }

    public MrzDate(int i) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_2(i), true);
    }

    public MrzDate() {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_3(), true);
    }

    public int getDay() {
        return mrzjniInterfaceJNI.MrzDate_getDay(this.a, this);
    }

    public int getMonth() {
        return mrzjniInterfaceJNI.MrzDate_getMonth(this.a, this);
    }

    public int getYear() {
        return mrzjniInterfaceJNI.MrzDate_getYear(this.a, this);
    }

    public void setDay(int i) {
        mrzjniInterfaceJNI.MrzDate_setDay(this.a, this, i);
    }

    public void setMonth(int i) {
        mrzjniInterfaceJNI.MrzDate_setMonth(this.a, this, i);
    }

    public void setYear(int i) {
        mrzjniInterfaceJNI.MrzDate_setYear(this.a, this, i);
    }

    public boolean isDayPresent() {
        return mrzjniInterfaceJNI.MrzDate_isDayPresent(this.a, this);
    }

    public boolean isMonthPresent() {
        return mrzjniInterfaceJNI.MrzDate_isMonthPresent(this.a, this);
    }

    public boolean isYearPresent() {
        return mrzjniInterfaceJNI.MrzDate_isYearPresent(this.a, this);
    }

    public MrzDate(MrzDate mrzDate) {
        this(mrzjniInterfaceJNI.new_MrzDate__SWIG_4(getCPtr(mrzDate), mrzDate), true);
    }
}
