package com.pro100svitlo.creditCardNfcReader.model.enums;

public enum ServiceCode1Enum implements a {
    INTERNATIONNAL(1, "International interchange", "None"),
    INTERNATIONNAL_ICC(2, "International interchange", "Integrated circuit card"),
    NATIONAL(5, "National interchange", "None"),
    NATIONAL_ICC(6, "National interchange", "Integrated circuit card"),
    PRIVATE(7, "Private", "None");
    
    private final String interchange;
    private final String technology;
    private final int value;

    private ServiceCode1Enum(int i, String str, String str2) {
        this.value = i;
        this.interchange = str;
        this.technology = str2;
    }

    public String getInterchange() {
        return this.interchange;
    }

    public String getTechnology() {
        return this.technology;
    }

    public int getKey() {
        return this.value;
    }
}
