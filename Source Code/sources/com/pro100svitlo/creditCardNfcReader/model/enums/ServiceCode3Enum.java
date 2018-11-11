package com.pro100svitlo.creditCardNfcReader.model.enums;

public enum ServiceCode3Enum implements a {
    NO_RESTRICTION_PIN_REQUIRED(0, "No restrictions", "PIN required"),
    NO_RESTRICTION(1, "No restrictions", "None"),
    GOODS_SERVICES(2, "Goods and services only", "None"),
    ATM_ONLY(3, "ATM only", "PIN required"),
    CASH_ONLY(4, "Cash only", "None"),
    GOODS_SERVICES_PIN_REQUIRED(5, "Goods and services only", "PIN required"),
    NO_RESTRICTION_PIN_IF_PED(6, "No restrictions", "Prompt for PIN if PED present"),
    GOODS_SERVICES_PIN_IF_PED(7, "Goods and services only", "Prompt for PIN if PED present");
    
    private final String allowedServices;
    private final String pinRequirements;
    private final int value;

    private ServiceCode3Enum(int i, String str, String str2) {
        this.value = i;
        this.allowedServices = str;
        this.pinRequirements = str2;
    }

    public String getAllowedServices() {
        return this.allowedServices;
    }

    public String getPinRequirements() {
        return this.pinRequirements;
    }

    public int getKey() {
        return this.value;
    }
}
