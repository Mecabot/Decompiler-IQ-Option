package com.neovisionaries.ws.client;

/* compiled from: Huffman */
class n {
    private final int dZL;
    private final int dZM;
    private final int[] dZN;
    private final int[] dZO;

    public n(int[] iArr) {
        this.dZL = Math.max(p.p(iArr), 1);
        this.dZM = p.max(iArr);
        Object[] objArr = new Object[2];
        this.dZN = a(d(iArr, this.dZM), this.dZM, objArr);
        this.dZO = a(iArr, (int[]) objArr[0], ((Integer) objArr[1]).intValue());
    }

    private static int[] aK(int i, int i2) {
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = i2;
        }
        return iArr;
    }

    private static int[] d(int[] iArr, int i) {
        int[] iArr2 = new int[(i + 1)];
        for (int i2 : iArr) {
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int[] a(int[] iArr, int i, Object[] objArr) {
        i++;
        int[] aK = aK(i, -1);
        iArr[0] = 0;
        int[] iArr2 = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 1; i4 < iArr.length; i4++) {
            i2 = (i2 + iArr[i4 - 1]) << 1;
            iArr2[i4] = i2;
            i3 = (iArr[i4] + i2) - 1;
            aK[i4] = i3;
        }
        objArr[0] = iArr2;
        objArr[1] = Integer.valueOf(i3);
        return aK;
    }

    private static int[] a(int[] iArr, int[] iArr2, int i) {
        int[] iArr3 = new int[(i + 1)];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                int i4 = iArr2[i3];
                iArr2[i3] = i4 + 1;
                iArr3[i4] = i2;
            }
        }
        return iArr3;
    }

    public int a(c cVar, int[] iArr) {
        for (int i = this.dZL; i <= this.dZM; i++) {
            int i2 = this.dZN[i];
            if (i2 >= 0) {
                int aJ = cVar.aJ(iArr[0], i);
                if (i2 >= aJ) {
                    int i3 = this.dZO[aJ];
                    iArr[0] = iArr[0] + i;
                    return i3;
                }
            }
        }
        throw new FormatException(String.format("[%s] Bad code at the bit index '%d'.", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr[0])}));
    }
}
