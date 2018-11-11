package com.google.zxing.qrcode.decoder;

import com.iqoption.dto.ChartTimeInterval;

/* compiled from: Version */
public final class a {
    private static final int[] ada = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final a[] adb = zk();
    private final int adc;
    private final int[] ade;
    private final b[] adf;
    private final int adg;

    /* compiled from: Version */
    public static final class a {
        private final int adh;
        private final int count;

        a(int i, int i2) {
            this.count = i;
            this.adh = i2;
        }

        public int getCount() {
            return this.count;
        }

        public int zl() {
            return this.adh;
        }
    }

    /* compiled from: Version */
    public static final class b {
        private final int adi;
        private final a[] adj;

        b(int i, a... aVarArr) {
            this.adi = i;
            this.adj = aVarArr;
        }

        public int zm() {
            return this.adi;
        }

        public int zn() {
            int i = 0;
            for (a count : this.adj) {
                i += count.getCount();
            }
            return i;
        }

        public int zo() {
            return this.adi * zn();
        }

        public a[] zp() {
            return this.adj;
        }
    }

    private a(int i, int[] iArr, b... bVarArr) {
        this.adc = i;
        this.ade = iArr;
        this.adf = bVarArr;
        i = 0;
        int zm = bVarArr[0].zm();
        a[] zp = bVarArr[0].zp();
        int length = zp.length;
        int i2 = 0;
        while (i < length) {
            a aVar = zp[i];
            i2 += aVar.getCount() * (aVar.zl() + zm);
            i++;
        }
        this.adg = i2;
    }

    public int getVersionNumber() {
        return this.adc;
    }

    public int zi() {
        return this.adg;
    }

    public int zj() {
        return (this.adc * 4) + 17;
    }

    public b a(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.adf[errorCorrectionLevel.ordinal()];
    }

    public static a ci(int i) {
        if (i > 0 && i <= 40) {
            return adb[i - 1];
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        return String.valueOf(this.adc);
    }

    private static a[] zk() {
        r0 = new a[40];
        int[] iArr = new int[0];
        b[] bVarArr = new b[4];
        bVarArr[0] = new b(7, new a(1, 19));
        bVarArr[1] = new b(10, new a(1, 16));
        bVarArr[2] = new b(13, new a(1, 13));
        bVarArr[3] = new b(17, new a(1, 9));
        r0[0] = new a(1, iArr, bVarArr);
        iArr = new int[]{6, 18};
        bVarArr = new b[4];
        bVarArr[0] = new b(10, new a(1, 34));
        bVarArr[1] = new b(16, new a(1, 28));
        bVarArr[2] = new b(22, new a(1, 22));
        bVarArr[3] = new b(28, new a(1, 16));
        r0[1] = new a(2, iArr, bVarArr);
        iArr = new int[]{6, 22};
        bVarArr = new b[4];
        bVarArr[0] = new b(15, new a(1, 55));
        bVarArr[1] = new b(26, new a(1, 44));
        bVarArr[2] = new b(18, new a(2, 17));
        bVarArr[3] = new b(22, new a(2, 13));
        r0[2] = new a(3, iArr, bVarArr);
        iArr = new int[]{6, 26};
        bVarArr = new b[4];
        bVarArr[0] = new b(20, new a(1, 80));
        bVarArr[1] = new b(18, new a(2, 32));
        bVarArr[2] = new b(26, new a(2, 24));
        bVarArr[3] = new b(16, new a(4, 9));
        r0[3] = new a(4, iArr, bVarArr);
        iArr = new int[]{6, 30};
        bVarArr = new b[4];
        bVarArr[0] = new b(26, new a(1, 108));
        bVarArr[1] = new b(24, new a(2, 43));
        bVarArr[2] = new b(18, new a(2, 15), new a(2, 16));
        bVarArr[3] = new b(22, new a(2, 11), new a(2, 12));
        r0[4] = new a(5, iArr, bVarArr);
        iArr = new int[]{6, 34};
        bVarArr = new b[4];
        bVarArr[0] = new b(18, new a(2, 68));
        bVarArr[1] = new b(16, new a(4, 27));
        bVarArr[2] = new b(24, new a(4, 19));
        bVarArr[3] = new b(28, new a(4, 15));
        r0[5] = new a(6, iArr, bVarArr);
        iArr = new int[]{6, 22, 38};
        bVarArr = new b[4];
        bVarArr[0] = new b(20, new a(2, 78));
        bVarArr[1] = new b(18, new a(4, 31));
        bVarArr[2] = new b(18, new a(2, 14), new a(4, 15));
        bVarArr[3] = new b(26, new a(4, 13), new a(1, 14));
        r0[6] = new a(7, iArr, bVarArr);
        iArr = new int[]{6, 24, 42};
        bVarArr = new b[4];
        bVarArr[0] = new b(24, new a(2, 97));
        bVarArr[1] = new b(22, new a(2, 38), new a(2, 39));
        bVarArr[2] = new b(22, new a(4, 18), new a(2, 19));
        bVarArr[3] = new b(26, new a(4, 14), new a(2, 15));
        r0[7] = new a(8, iArr, bVarArr);
        iArr = new int[]{6, 26, 46};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(2, 116));
        bVarArr[1] = new b(22, new a(3, 36), new a(2, 37));
        bVarArr[2] = new b(20, new a(4, 16), new a(4, 17));
        bVarArr[3] = new b(24, new a(4, 12), new a(4, 13));
        r0[8] = new a(9, iArr, bVarArr);
        iArr = new int[]{6, 28, 50};
        bVarArr = new b[4];
        bVarArr[0] = new b(18, new a(2, 68), new a(2, 69));
        bVarArr[1] = new b(26, new a(4, 43), new a(1, 44));
        bVarArr[2] = new b(24, new a(6, 19), new a(2, 20));
        bVarArr[3] = new b(28, new a(6, 15), new a(2, 16));
        r0[9] = new a(10, iArr, bVarArr);
        iArr = new int[]{6, 30, 54};
        bVarArr = new b[4];
        bVarArr[0] = new b(20, new a(4, 81));
        bVarArr[1] = new b(30, new a(1, 50), new a(4, 51));
        bVarArr[2] = new b(28, new a(4, 22), new a(4, 23));
        bVarArr[3] = new b(24, new a(3, 12), new a(8, 13));
        r0[10] = new a(11, iArr, bVarArr);
        iArr = new int[]{6, 32, 58};
        bVarArr = new b[4];
        bVarArr[0] = new b(24, new a(2, 92), new a(2, 93));
        bVarArr[1] = new b(22, new a(6, 36), new a(2, 37));
        bVarArr[2] = new b(26, new a(4, 20), new a(6, 21));
        bVarArr[3] = new b(28, new a(7, 14), new a(4, 15));
        r0[11] = new a(12, iArr, bVarArr);
        iArr = new int[]{6, 34, 62};
        bVarArr = new b[4];
        bVarArr[0] = new b(26, new a(4, 107));
        bVarArr[1] = new b(22, new a(8, 37), new a(1, 38));
        bVarArr[2] = new b(24, new a(8, 20), new a(4, 21));
        bVarArr[3] = new b(22, new a(12, 11), new a(4, 12));
        r0[12] = new a(13, iArr, bVarArr);
        iArr = new int[]{6, 26, 46, 66};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(3, 115), new a(1, 116));
        bVarArr[1] = new b(24, new a(4, 40), new a(5, 41));
        bVarArr[2] = new b(20, new a(11, 16), new a(5, 17));
        bVarArr[3] = new b(24, new a(11, 12), new a(5, 13));
        r0[13] = new a(14, iArr, bVarArr);
        iArr = new int[]{6, 26, 48, 70};
        bVarArr = new b[4];
        bVarArr[0] = new b(22, new a(5, 87), new a(1, 88));
        bVarArr[1] = new b(24, new a(5, 41), new a(5, 42));
        bVarArr[2] = new b(30, new a(5, 24), new a(7, 25));
        bVarArr[3] = new b(24, new a(11, 12), new a(7, 13));
        r0[14] = new a(15, iArr, bVarArr);
        iArr = new int[]{6, 26, 50, 74};
        bVarArr = new b[4];
        bVarArr[0] = new b(24, new a(5, 98), new a(1, 99));
        bVarArr[1] = new b(28, new a(7, 45), new a(3, 46));
        bVarArr[2] = new b(24, new a(15, 19), new a(2, 20));
        bVarArr[3] = new b(30, new a(3, 15), new a(13, 16));
        r0[15] = new a(16, iArr, bVarArr);
        iArr = new int[]{6, 30, 54, 78};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(1, 107), new a(5, 108));
        bVarArr[1] = new b(28, new a(10, 46), new a(1, 47));
        bVarArr[2] = new b(28, new a(1, 22), new a(15, 23));
        bVarArr[3] = new b(28, new a(2, 14), new a(17, 15));
        r0[16] = new a(17, iArr, bVarArr);
        iArr = new int[]{6, 30, 56, 82};
        bVarArr = new b[4];
        bVarArr[0] = new b(30, new a(5, ChartTimeInterval.CANDLE_2m), new a(1, 121));
        bVarArr[1] = new b(26, new a(9, 43), new a(4, 44));
        bVarArr[2] = new b(28, new a(17, 22), new a(1, 23));
        bVarArr[3] = new b(28, new a(2, 14), new a(19, 15));
        r0[17] = new a(18, iArr, bVarArr);
        iArr = new int[]{6, 30, 58, 86};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(3, 113), new a(4, 114));
        bVarArr[1] = new b(26, new a(3, 44), new a(11, 45));
        bVarArr[2] = new b(26, new a(17, 21), new a(4, 22));
        bVarArr[3] = new b(26, new a(9, 13), new a(16, 14));
        r0[18] = new a(19, iArr, bVarArr);
        iArr = new int[]{6, 34, 62, 90};
        bVarArr = new b[4];
        bVarArr[0] = new b(28, new a(3, 107), new a(5, 108));
        bVarArr[1] = new b(26, new a(3, 41), new a(13, 42));
        bVarArr[2] = new b(30, new a(15, 24), new a(5, 25));
        bVarArr[3] = new b(28, new a(15, 15), new a(10, 16));
        r0[19] = new a(20, iArr, bVarArr);
        int[] iArr2 = new int[]{6, 28, 50, 72, 94};
        r3 = new b[4];
        r3[0] = new b(28, new a(4, 116), new a(4, 117));
        r3[1] = new b(26, new a(17, 42));
        r3[2] = new b(28, new a(17, 22), new a(6, 23));
        r3[3] = new b(30, new a(19, 16), new a(6, 17));
        r0[20] = new a(21, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98};
        r3 = new b[4];
        r3[0] = new b(28, new a(2, 111), new a(7, 112));
        r3[1] = new b(28, new a(17, 46));
        r3[2] = new b(30, new a(7, 24), new a(16, 25));
        r3[3] = new b(24, new a(34, 13));
        r0[21] = new a(22, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102};
        r6 = new b[4];
        r6[0] = new b(30, new a(4, 121), new a(5, 122));
        r6[1] = new b(28, new a(4, 47), new a(14, 48));
        r6[2] = new b(30, new a(11, 24), new a(14, 25));
        r6[3] = new b(30, new a(16, 15), new a(14, 16));
        r0[22] = new a(23, iArr2, r6);
        iArr2 = new int[]{6, 28, 54, 80, 106};
        r3 = new b[4];
        r3[0] = new b(30, new a(6, 117), new a(4, 118));
        r3[1] = new b(28, new a(6, 45), new a(14, 46));
        r3[2] = new b(30, new a(11, 24), new a(16, 25));
        r3[3] = new b(30, new a(30, 16), new a(2, 17));
        r0[23] = new a(24, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110};
        r3 = new b[4];
        r3[0] = new b(26, new a(8, 106), new a(4, 107));
        r3[1] = new b(28, new a(8, 47), new a(13, 48));
        r3[2] = new b(30, new a(7, 24), new a(22, 25));
        r3[3] = new b(30, new a(22, 15), new a(13, 16));
        r0[24] = new a(25, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114};
        r3 = new b[4];
        r3[0] = new b(28, new a(10, 114), new a(2, 115));
        r3[1] = new b(28, new a(19, 46), new a(4, 47));
        r3[2] = new b(28, new a(28, 22), new a(6, 23));
        r3[3] = new b(30, new a(33, 16), new a(4, 17));
        r0[25] = new a(26, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, 118};
        r3 = new b[4];
        r3[0] = new b(30, new a(8, 122), new a(4, 123));
        r3[1] = new b(28, new a(22, 45), new a(3, 46));
        r3[2] = new b(30, new a(8, 23), new a(26, 24));
        r3[3] = new b(30, new a(12, 15), new a(28, 16));
        r0[26] = new a(27, iArr2, r3);
        iArr2 = new int[]{6, 26, 50, 74, 98, 122};
        r3 = new b[4];
        r3[0] = new b(30, new a(3, 117), new a(10, 118));
        r3[1] = new b(28, new a(3, 45), new a(23, 46));
        r3[2] = new b(30, new a(4, 24), new a(31, 25));
        r3[3] = new b(30, new a(11, 15), new a(31, 16));
        r0[27] = new a(28, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, 126};
        r3 = new b[4];
        r3[0] = new b(30, new a(7, 116), new a(7, 117));
        r3[1] = new b(28, new a(21, 45), new a(7, 46));
        r3[2] = new b(30, new a(1, 23), new a(37, 24));
        r3[3] = new b(30, new a(19, 15), new a(26, 16));
        r0[28] = new a(29, iArr2, r3);
        iArr2 = new int[]{6, 26, 52, 78, 104, 130};
        r3 = new b[4];
        r3[0] = new b(30, new a(5, 115), new a(10, 116));
        r3[1] = new b(28, new a(19, 47), new a(10, 48));
        r3[2] = new b(30, new a(15, 24), new a(25, 25));
        r3[3] = new b(30, new a(23, 15), new a(25, 16));
        r0[29] = new a(30, iArr2, r3);
        iArr2 = new int[]{6, 30, 56, 82, 108, 134};
        r3 = new b[4];
        r3[0] = new b(30, new a(13, 115), new a(3, 116));
        r3[1] = new b(28, new a(2, 46), new a(29, 47));
        r3[2] = new b(30, new a(42, 24), new a(1, 25));
        r3[3] = new b(30, new a(23, 15), new a(28, 16));
        r0[30] = new a(31, iArr2, r3);
        iArr2 = new int[]{6, 34, 60, 86, 112, 138};
        r3 = new b[4];
        r3[0] = new b(30, new a(17, 115));
        r3[1] = new b(28, new a(10, 46), new a(23, 47));
        r3[2] = new b(30, new a(10, 24), new a(35, 25));
        r3[3] = new b(30, new a(19, 15), new a(35, 16));
        r0[31] = new a(32, iArr2, r3);
        iArr2 = new int[]{6, 30, 58, 86, 114, 142};
        r3 = new b[4];
        r3[0] = new b(30, new a(17, 115), new a(1, 116));
        r3[1] = new b(28, new a(14, 46), new a(21, 47));
        r3[2] = new b(30, new a(29, 24), new a(19, 25));
        r3[3] = new b(30, new a(11, 15), new a(46, 16));
        r0[32] = new a(33, iArr2, r3);
        iArr2 = new int[]{6, 34, 62, 90, 118, 146};
        r3 = new b[4];
        r3[0] = new b(30, new a(13, 115), new a(6, 116));
        r3[1] = new b(28, new a(14, 46), new a(23, 47));
        r3[2] = new b(30, new a(44, 24), new a(7, 25));
        r3[3] = new b(30, new a(59, 16), new a(1, 17));
        r0[33] = new a(34, iArr2, r3);
        iArr2 = new int[]{6, 30, 54, 78, 102, 126, 150};
        r3 = new b[4];
        r3[0] = new b(30, new a(12, 121), new a(7, 122));
        r3[1] = new b(28, new a(12, 47), new a(26, 48));
        r3[2] = new b(30, new a(39, 24), new a(14, 25));
        r3[3] = new b(30, new a(22, 15), new a(41, 16));
        r0[34] = new a(35, iArr2, r3);
        iArr2 = new int[]{6, 24, 50, 76, 102, 128, 154};
        r3 = new b[4];
        r3[0] = new b(30, new a(6, 121), new a(14, 122));
        r3[1] = new b(28, new a(6, 47), new a(34, 48));
        r3[2] = new b(30, new a(46, 24), new a(10, 25));
        r3[3] = new b(30, new a(2, 15), new a(64, 16));
        r0[35] = new a(36, iArr2, r3);
        iArr2 = new int[]{6, 28, 54, 80, 106, 132, 158};
        r3 = new b[4];
        r3[0] = new b(30, new a(17, 122), new a(4, 123));
        r3[1] = new b(28, new a(29, 46), new a(14, 47));
        r3[2] = new b(30, new a(49, 24), new a(10, 25));
        r3[3] = new b(30, new a(24, 15), new a(46, 16));
        r0[36] = new a(37, iArr2, r3);
        iArr2 = new int[]{6, 32, 58, 84, 110, 136, 162};
        r3 = new b[4];
        r3[0] = new b(30, new a(4, 122), new a(18, 123));
        r3[1] = new b(28, new a(13, 46), new a(32, 47));
        r3[2] = new b(30, new a(48, 24), new a(14, 25));
        r3[3] = new b(30, new a(42, 15), new a(32, 16));
        r0[37] = new a(38, iArr2, r3);
        iArr2 = new int[]{6, 26, 54, 82, 110, 138, 166};
        r3 = new b[4];
        r3[0] = new b(30, new a(20, 117), new a(4, 118));
        r3[1] = new b(28, new a(40, 47), new a(7, 48));
        r3[2] = new b(30, new a(43, 24), new a(22, 25));
        r3[3] = new b(30, new a(10, 15), new a(67, 16));
        r0[38] = new a(39, iArr2, r3);
        iArr = new int[]{6, 30, 58, 86, 114, 142, 170};
        r4 = new b[4];
        r4[0] = new b(30, new a(19, 118), new a(6, 119));
        r4[1] = new b(28, new a(18, 47), new a(31, 48));
        r4[2] = new b(30, new a(34, 24), new a(34, 25));
        r4[3] = new b(30, new a(20, 15), new a(61, 16));
        r0[39] = new a(40, iArr, r4);
        return r0;
    }
}
