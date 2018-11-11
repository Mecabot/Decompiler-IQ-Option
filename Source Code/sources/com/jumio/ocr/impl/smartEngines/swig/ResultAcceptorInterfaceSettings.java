package com.jumio.ocr.impl.smartEngines.swig;

public class ResultAcceptorInterfaceSettings {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    public static final class FieldName {
        public static final FieldName AMEX_CVV = new FieldName("AMEX_CVV");
        public static final FieldName EXPIRY = new FieldName("EXPIRY");
        public static final FieldName NAME = new FieldName("NAME");
        public static final FieldName NAME_2NDLINE = new FieldName("NAME_2NDLINE");
        public static final FieldName NUMBER = new FieldName("NUMBER");
        public static final FieldName SB_CODE = new FieldName("SB_CODE");
        public static final FieldName UK_ACCOUNTNUM = new FieldName("UK_ACCOUNTNUM");
        public static final FieldName UK_SORTCODE = new FieldName("UK_SORTCODE");
        private static int swigNext;
        private static FieldName[] swigValues = new FieldName[]{NUMBER, EXPIRY, NAME, UK_SORTCODE, UK_ACCOUNTNUM, NAME_2NDLINE, AMEX_CVV, SB_CODE};
        private final String swigName;
        private final int swigValue;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static FieldName swigToEnum(int i) {
            if (i < swigValues.length && i >= 0 && swigValues[i].swigValue == i) {
                return swigValues[i];
            }
            for (int i2 = 0; i2 < swigValues.length; i2++) {
                if (swigValues[i2].swigValue == i) {
                    return swigValues[i2];
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No enum ");
            stringBuilder.append(FieldName.class);
            stringBuilder.append(" with value ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        private FieldName(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private FieldName(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private FieldName(String str, FieldName fieldName) {
            this.swigName = str;
            this.swigValue = fieldName.swigValue;
            swigNext = this.swigValue + 1;
        }
    }

    protected ResultAcceptorInterfaceSettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings) {
        return resultAcceptorInterfaceSettings == null ? 0 : resultAcceptorInterfaceSettings.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                jniInterfaceJNI.delete_ResultAcceptorInterfaceSettings(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public ResultAcceptorInterfaceSettings() {
        this(jniInterfaceJNI.new_ResultAcceptorInterfaceSettings__SWIG_0(), true);
    }

    public ResultAcceptorInterfaceSettings(ResultAcceptorInterfaceSettings resultAcceptorInterfaceSettings) {
        this(jniInterfaceJNI.new_ResultAcceptorInterfaceSettings__SWIG_1(getCPtr(resultAcceptorInterfaceSettings), resultAcceptorInterfaceSettings), true);
    }

    public boolean getOcrEnabledFlag(FieldName fieldName) {
        return jniInterfaceJNI.ResultAcceptorInterfaceSettings_getOcrEnabledFlag(this.swigCPtr, this, fieldName.swigValue());
    }

    public void setOcrEnabledFlag(FieldName fieldName, boolean z) {
        jniInterfaceJNI.ResultAcceptorInterfaceSettings_setOcrEnabledFlag(this.swigCPtr, this, fieldName.swigValue(), z);
    }

    public void setAllOcrEnabledFlag(boolean z) {
        jniInterfaceJNI.ResultAcceptorInterfaceSettings_setAllOcrEnabledFlag(this.swigCPtr, this, z);
    }
}
