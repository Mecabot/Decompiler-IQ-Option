package com.pro100svitlo.creditCardNfcReader.model.enums;

public enum ServiceCode2Enum implements a {
    NORMAL(0, "Normal"),
    BY_ISSUER(2, "By issuer"),
    BY_ISSUER_WIHOUT_BI_AGREEMENT(4, "By issuer unless explicit bilateral agreement applies");
    
    private final String authorizationProcessing;
    private final int value;

    private ServiceCode2Enum(int i, String str) {
        this.value = i;
        this.authorizationProcessing = str;
    }

    public String getAuthorizationProcessing() {
        return this.authorizationProcessing;
    }

    public int getKey() {
        return this.value;
    }
}
