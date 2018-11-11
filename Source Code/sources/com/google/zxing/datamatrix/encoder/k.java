package com.google.zxing.datamatrix.encoder;

import com.google.zxing.a;

/* compiled from: SymbolInfo */
public class k {
    static final k[] acc;
    private static k[] acd;
    private final boolean ace;
    private final int acf;
    private final int acg;
    public final int ach;
    public final int aci;
    private final int acj;
    private final int ack;
    private final int acl;

    static {
        k[] kVarArr = new k[]{new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        acc = kVarArr;
        acd = kVarArr;
    }

    public k(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    k(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.ace = z;
        this.acf = i;
        this.acg = i2;
        this.ach = i3;
        this.aci = i4;
        this.acj = i5;
        this.ack = i6;
        this.acl = i7;
    }

    public static k a(int i, SymbolShapeHint symbolShapeHint, a aVar, a aVar2, boolean z) {
        for (k kVar : acd) {
            if ((symbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !kVar.ace) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.ace) && ((aVar == null || (kVar.yX() >= aVar.getWidth() && kVar.yY() >= aVar.getHeight())) && ((aVar2 == null || (kVar.yX() <= aVar2.getWidth() && kVar.yY() <= aVar2.getHeight())) && i <= kVar.acf)))) {
                return kVar;
            }
        }
        if (!z) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("Can't find a symbol arrangement that matches the message. Data codewords: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private int yT() {
        int i = this.acj;
        if (i != 4) {
            if (i == 16) {
                return 4;
            }
            if (i == 36) {
                return 6;
            }
            switch (i) {
                case 1:
                    return 1;
                case 2:
                    break;
                default:
                    throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return 2;
    }

    private int yU() {
        int i = this.acj;
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        switch (i) {
            case 1:
            case 2:
                return 1;
            default:
                throw new IllegalStateException("Cannot handle this number of data regions");
        }
    }

    public final int yV() {
        return yT() * this.ach;
    }

    public final int yW() {
        return yU() * this.aci;
    }

    public final int yX() {
        return yV() + (yT() << 1);
    }

    public final int yY() {
        return yW() + (yU() << 1);
    }

    public int yH() {
        return this.acf / this.ack;
    }

    public final int yZ() {
        return this.acf;
    }

    public final int za() {
        return this.acg;
    }

    public int bX(int i) {
        return this.ack;
    }

    public final int cf(int i) {
        return this.acl;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.ace ? "Rectangular Symbol:" : "Square Symbol:");
        stringBuilder.append(" data region ");
        stringBuilder.append(this.ach);
        stringBuilder.append('x');
        stringBuilder.append(this.aci);
        stringBuilder.append(", symbol size ");
        stringBuilder.append(yX());
        stringBuilder.append('x');
        stringBuilder.append(yY());
        stringBuilder.append(", symbol data size ");
        stringBuilder.append(yV());
        stringBuilder.append('x');
        stringBuilder.append(yW());
        stringBuilder.append(", codewords ");
        stringBuilder.append(this.acf);
        stringBuilder.append('+');
        stringBuilder.append(this.acg);
        return stringBuilder.toString();
    }
}
