package com.google.zxing.a.a;

import com.google.zxing.common.a;

/* compiled from: BinaryShiftToken */
final class b extends g {
    private final short abe;
    private final short abf;

    b(g gVar, int i, int i2) {
        super(gVar);
        this.abe = (short) i;
        this.abf = (short) i2;
    }

    public void a(a aVar, byte[] bArr) {
        short s = (short) 0;
        while (s < this.abf) {
            if (s == (short) 0 || (s == (short) 31 && this.abf <= (short) 62)) {
                aVar.K(31, 5);
                if (this.abf > (short) 62) {
                    aVar.K(this.abf - 31, 16);
                } else if (s == (short) 0) {
                    aVar.K(Math.min(this.abf, 31), 5);
                } else {
                    aVar.K(this.abf - 31, 5);
                }
            }
            aVar.K(bArr[this.abe + s], 8);
            s++;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(this.abe);
        stringBuilder.append("::");
        stringBuilder.append((this.abe + this.abf) - 1);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}
