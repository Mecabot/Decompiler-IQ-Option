package com.google.zxing.qrcode.a;

/* compiled from: BlockPair */
final class a {
    private final byte[] adk;
    private final byte[] adl;

    a(byte[] bArr, byte[] bArr2) {
        this.adk = bArr;
        this.adl = bArr2;
    }

    public byte[] getDataBytes() {
        return this.adk;
    }

    public byte[] zq() {
        return this.adl;
    }
}
