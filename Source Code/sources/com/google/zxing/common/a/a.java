package com.google.zxing.common.a;

import com.jumio.analytics.MobileEvents;

/* compiled from: GenericGF */
public final class a {
    public static final a abA;
    public static final a abB;
    public static final a abC = abx;
    public static final a abv = new a(4201, 4096, 1);
    public static final a abw = new a(1033, 1024, 1);
    public static final a abx = new a(67, 64, 1);
    public static final a aby = new a(19, 16, 1);
    public static final a abz = new a(285, 256, 0);
    private final int[] abD;
    private final int[] abE;
    private final b abF;
    private final b abG;
    private final int abH;
    private final int abI;
    private final int size;

    static int N(int i, int i2) {
        return i ^ i2;
    }

    static {
        a aVar = new a(MobileEvents.EVENTTYPE_USERACTION, 256, 1);
        abA = aVar;
        abB = aVar;
    }

    public a(int i, int i2, int i3) {
        this.abH = i;
        this.size = i2;
        this.abI = i3;
        this.abD = new int[i2];
        this.abE = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.abD[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i = 0; i < i2 - 1; i++) {
            this.abE[this.abD[i]] = i;
        }
        this.abF = new b(this, new int[]{0});
        this.abG = new b(this, new int[]{1});
    }

    b yC() {
        return this.abF;
    }

    b M(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.abF;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new b(this, iArr);
        }
    }

    int bS(int i) {
        return this.abD[i];
    }

    int bT(int i) {
        if (i != 0) {
            return this.abE[i];
        }
        throw new IllegalArgumentException();
    }

    int bU(int i) {
        if (i != 0) {
            return this.abD[(this.size - this.abE[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int O(int i, int i2) {
        return (i == 0 || i2 == 0) ? 0 : this.abD[(this.abE[i] + this.abE[i2]) % (this.size - 1)];
    }

    public int yD() {
        return this.abI;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GF(0x");
        stringBuilder.append(Integer.toHexString(this.abH));
        stringBuilder.append(',');
        stringBuilder.append(this.size);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
