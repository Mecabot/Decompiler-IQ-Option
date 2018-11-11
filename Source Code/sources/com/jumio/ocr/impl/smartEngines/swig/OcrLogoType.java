package com.jumio.ocr.impl.smartEngines.swig;

public final class OcrLogoType {
    public static final OcrLogoType OcrLogoTypeAmericanExpress = new OcrLogoType("OcrLogoTypeAmericanExpress");
    public static final OcrLogoType OcrLogoTypeDinersClub = new OcrLogoType("OcrLogoTypeDinersClub");
    public static final OcrLogoType OcrLogoTypeDiscover = new OcrLogoType("OcrLogoTypeDiscover");
    public static final OcrLogoType OcrLogoTypeMasterCard = new OcrLogoType("OcrLogoTypeMasterCard");
    public static final OcrLogoType OcrLogoTypeUnknown = new OcrLogoType("OcrLogoTypeUnknown", jniInterfaceJNI.OcrLogoTypeUnknown_get());
    public static final OcrLogoType OcrLogoTypeVisa = new OcrLogoType("OcrLogoTypeVisa");
    private static int swigNext;
    private static OcrLogoType[] swigValues = new OcrLogoType[]{OcrLogoTypeUnknown, OcrLogoTypeVisa, OcrLogoTypeMasterCard, OcrLogoTypeAmericanExpress, OcrLogoTypeDiscover, OcrLogoTypeDinersClub};
    private final String swigName;
    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static OcrLogoType swigToEnum(int i) {
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
        stringBuilder.append(OcrLogoType.class);
        stringBuilder.append(" with value ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private OcrLogoType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private OcrLogoType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private OcrLogoType(String str, OcrLogoType ocrLogoType) {
        this.swigName = str;
        this.swigValue = ocrLogoType.swigValue;
        swigNext = this.swigValue + 1;
    }
}
