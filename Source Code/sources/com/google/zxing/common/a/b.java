package com.google.zxing.common.a;

/* compiled from: GenericGFPoly */
final class b {
    private final a abJ;
    private final int[] abK;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.abJ = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.abK = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.abK = new int[]{0};
            return;
        }
        this.abK = new int[(length - i)];
        System.arraycopy(iArr, i, this.abK, 0, this.abK.length);
    }

    int[] yE() {
        return this.abK;
    }

    int yF() {
        return this.abK.length - 1;
    }

    boolean isZero() {
        return this.abK[0] == 0;
    }

    int bV(int i) {
        return this.abK[(this.abK.length - 1) - i];
    }

    b a(b bVar) {
        if (!this.abJ.equals(bVar.abJ)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (isZero()) {
            return bVar;
        } else {
            if (bVar.isZero()) {
                return this;
            }
            int[] iArr = this.abK;
            Object obj = bVar.abK;
            if (iArr.length > obj.length) {
                Object obj2 = iArr;
                iArr = obj;
                obj = obj2;
            }
            Object obj3 = new int[obj.length];
            int length = obj.length - iArr.length;
            System.arraycopy(obj, 0, obj3, 0, length);
            for (int i = length; i < obj.length; i++) {
                obj3[i] = a.N(iArr[i - length], obj[i]);
            }
            return new b(this.abJ, obj3);
        }
    }

    b b(b bVar) {
        if (!this.abJ.equals(bVar.abJ)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (isZero() || bVar.isZero()) {
            return this.abJ.yC();
        } else {
            int[] iArr = this.abK;
            int length = iArr.length;
            int[] iArr2 = bVar.abK;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = a.N(iArr3[i4], this.abJ.O(i2, iArr2[i3]));
                }
            }
            return new b(this.abJ, iArr3);
        }
    }

    b P(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.abJ.yC();
        } else {
            int length = this.abK.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.abJ.O(this.abK[i3], i2);
            }
            return new b(this.abJ, iArr);
        }
    }

    b[] c(b bVar) {
        if (!this.abJ.equals(bVar.abJ)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (bVar.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            b yC = this.abJ.yC();
            int bU = this.abJ.bU(bVar.bV(bVar.yF()));
            b bVar2 = yC;
            yC = this;
            while (yC.yF() >= bVar.yF() && !yC.isZero()) {
                int yF = yC.yF() - bVar.yF();
                int O = this.abJ.O(yC.bV(yC.yF()), bU);
                b P = bVar.P(yF, O);
                bVar2 = bVar2.a(this.abJ.M(yF, O));
                yC = yC.a(P);
            }
            return new b[]{bVar2, yC};
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(yF() * 8);
        for (int yF = yF(); yF >= 0; yF--) {
            int bV = bV(yF);
            if (bV != 0) {
                if (bV < 0) {
                    stringBuilder.append(" - ");
                    bV = -bV;
                } else if (stringBuilder.length() > 0) {
                    stringBuilder.append(" + ");
                }
                if (yF == 0 || bV != 1) {
                    bV = this.abJ.bT(bV);
                    if (bV == 0) {
                        stringBuilder.append('1');
                    } else if (bV == 1) {
                        stringBuilder.append('a');
                    } else {
                        stringBuilder.append("a^");
                        stringBuilder.append(bV);
                    }
                }
                if (yF != 0) {
                    if (yF == 1) {
                        stringBuilder.append('x');
                    } else {
                        stringBuilder.append("x^");
                        stringBuilder.append(yF);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
