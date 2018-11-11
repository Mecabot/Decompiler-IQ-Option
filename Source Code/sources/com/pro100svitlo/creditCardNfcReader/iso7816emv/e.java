package com.pro100svitlo.creditCardNfcReader.iso7816emv;

/* compiled from: TagAndLength */
public class e {
    private ITag egx;
    private int length;

    public e(ITag iTag, int i) {
        this.egx = iTag;
        this.length = i;
    }

    public ITag aRJ() {
        return this.egx;
    }

    public int getLength() {
        return this.length;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.egx.toString());
        stringBuilder.append(" length: ");
        stringBuilder.append(this.length);
        return stringBuilder.toString();
    }
}
