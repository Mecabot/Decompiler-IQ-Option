package com.pro100svitlo.creditCardNfcReader.enums;

public enum CommandEnum {
    SELECT(0, 164, 4, 0),
    READ_RECORD(0, 178, 0, 0),
    GPO(128, 168, 0, 0),
    GET_DATA(128, 202, 0, 0);
    
    private final int cla;
    private final int ins;
    private final int p1;
    private final int p2;

    private CommandEnum(int i, int i2, int i3, int i4) {
        this.cla = i;
        this.ins = i2;
        this.p1 = i3;
        this.p2 = i4;
    }

    public int getCla() {
        return this.cla;
    }

    public int getIns() {
        return this.ins;
    }

    public int getP1() {
        return this.p1;
    }

    public int getP2() {
        return this.p2;
    }
}
