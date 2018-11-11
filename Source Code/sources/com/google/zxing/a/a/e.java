package com.google.zxing.a.a;

import com.google.zxing.common.a;

/* compiled from: SimpleToken */
final class e extends g {
    private final short abm;
    private final short value;

    e(g gVar, int i, int i2) {
        super(gVar);
        this.value = (short) i;
        this.abm = (short) i2;
    }

    void a(a aVar, byte[] bArr) {
        aVar.K(this.value, this.abm);
    }

    public String toString() {
        int i = (this.value & ((1 << this.abm) - 1)) | (1 << this.abm);
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(Integer.toBinaryString(i | (1 << this.abm)).substring(1));
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
