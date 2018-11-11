package com.pro100svitlo.creditCardNfcReader.model.enums;

public enum TransactionTypeEnum implements a {
    PURCHASE(0),
    CASH_ADVANCE(1),
    CASHBACK(9),
    REFUND(32);
    
    private final int value;

    private TransactionTypeEnum(int i) {
        this.value = i;
    }

    public int getKey() {
        return this.value;
    }
}
