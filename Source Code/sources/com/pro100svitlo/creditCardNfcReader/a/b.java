package com.pro100svitlo.creditCardNfcReader.a;

import com.pro100svitlo.creditCardNfcReader.enums.CommandEnum;

/* compiled from: CommandApdu */
public class b {
    protected int egV;
    protected int egW;
    protected int egX;
    protected int egY;
    protected int egZ;
    protected byte[] eha;
    protected int ehb;
    protected boolean ehc;

    public b(CommandEnum commandEnum, byte[] bArr, int i) {
        int i2 = 0;
        this.egV = 0;
        this.egW = 0;
        this.egX = 0;
        this.egY = 0;
        this.egZ = 0;
        this.eha = new byte[0];
        this.ehb = 0;
        this.ehc = false;
        this.egV = commandEnum.getCla();
        this.egW = commandEnum.getIns();
        this.egX = commandEnum.getP1();
        this.egY = commandEnum.getP2();
        if (bArr != null) {
            i2 = bArr.length;
        }
        this.egZ = i2;
        this.eha = bArr;
        this.ehb = i;
        this.ehc = true;
    }

    public b(CommandEnum commandEnum, int i, int i2, int i3) {
        this.egV = 0;
        this.egW = 0;
        this.egX = 0;
        this.egY = 0;
        this.egZ = 0;
        this.eha = new byte[0];
        this.ehb = 0;
        this.ehc = false;
        this.egV = commandEnum.getCla();
        this.egW = commandEnum.getIns();
        this.egX = i;
        this.egY = i2;
        this.ehb = i3;
        this.ehc = true;
    }

    public byte[] aSl() {
        int i = 4;
        int length = (this.eha == null || this.eha.length == 0) ? 4 : this.eha.length + 5;
        if (this.ehc) {
            length++;
        }
        Object obj = new byte[length];
        obj[0] = (byte) this.egV;
        obj[1] = (byte) this.egW;
        obj[2] = (byte) this.egX;
        obj[3] = (byte) this.egY;
        if (!(this.eha == null || this.eha.length == 0)) {
            obj[4] = (byte) this.egZ;
            System.arraycopy(this.eha, 0, obj, 5, this.eha.length);
            i = this.eha.length + 5;
        }
        if (this.ehc) {
            obj[i] = (byte) (obj[i] + ((byte) this.ehb));
        }
        return obj;
    }
}
