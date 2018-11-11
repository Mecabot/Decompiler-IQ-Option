package com.pro100svitlo.creditCardNfcReader.iso7816emv;

/* compiled from: TLV */
public class d {
    private ITag egx;
    private byte[] egy;
    private byte[] egz;
    private int length;

    public d(ITag iTag, int i, byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || i != bArr2.length) {
            throw new IllegalArgumentException("length != bytes.length");
        }
        this.egx = iTag;
        this.egy = bArr;
        this.egz = bArr2;
        this.length = i;
    }

    public ITag aRJ() {
        return this.egx;
    }

    public byte[] aRK() {
        return this.egz;
    }
}
