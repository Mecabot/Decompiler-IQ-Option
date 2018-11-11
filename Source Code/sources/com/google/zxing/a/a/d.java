package com.google.zxing.a.a;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: HighLevelEncoder */
public final class d {
    static final String[] abh = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] abi = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] abj;
    static final int[][] abk;
    private final byte[] text;

    static {
        int i;
        int i2;
        int i3;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{5, 256});
        abj = iArr;
        iArr[0][32] = 1;
        for (i = 65; i <= 90; i++) {
            abj[0][i] = (i - 65) + 2;
        }
        abj[1][32] = 1;
        for (i = 97; i <= 122; i++) {
            abj[1][i] = (i - 97) + 2;
        }
        abj[2][32] = 1;
        for (i = 48; i <= 57; i++) {
            abj[2][i] = (i - 48) + 2;
        }
        abj[2][44] = 12;
        abj[2][46] = 13;
        int[] iArr2 = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (i2 = 0; i2 < 28; i2++) {
            abj[3][iArr2[i2]] = i2;
        }
        int[] iArr3 = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (i3 = 0; i3 < 31; i3++) {
            if (iArr3[i3] > 0) {
                abj[4][iArr3[i3]] = i3;
            }
        }
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, new int[]{6, 6});
        abk = iArr4;
        for (int[] fill : iArr4) {
            Arrays.fill(fill, -1);
        }
        abk[0][4] = 0;
        abk[1][4] = 0;
        abk[1][0] = 28;
        abk[3][4] = 0;
        abk[2][4] = 0;
        abk[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.text = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    public com.google.zxing.common.a yv() {
        /*
        r8 = this;
        r0 = com.google.zxing.a.a.f.abn;
        r0 = java.util.Collections.singletonList(r0);
        r1 = 0;
        r2 = r0;
        r0 = 0;
    L_0x0009:
        r3 = r8.text;
        r3 = r3.length;
        if (r0 >= r3) goto L_0x0054;
    L_0x000e:
        r3 = r0 + 1;
        r4 = r8.text;
        r4 = r4.length;
        if (r3 >= r4) goto L_0x001a;
    L_0x0015:
        r4 = r8.text;
        r4 = r4[r3];
        goto L_0x001b;
    L_0x001a:
        r4 = 0;
    L_0x001b:
        r5 = r8.text;
        r5 = r5[r0];
        r6 = 13;
        if (r5 == r6) goto L_0x003f;
    L_0x0023:
        r6 = 44;
        r7 = 32;
        if (r5 == r6) goto L_0x003b;
    L_0x0029:
        r6 = 46;
        if (r5 == r6) goto L_0x0037;
    L_0x002d:
        r6 = 58;
        if (r5 == r6) goto L_0x0033;
    L_0x0031:
        r4 = 0;
        goto L_0x0044;
    L_0x0033:
        if (r4 != r7) goto L_0x0031;
    L_0x0035:
        r4 = 5;
        goto L_0x0044;
    L_0x0037:
        if (r4 != r7) goto L_0x0031;
    L_0x0039:
        r4 = 3;
        goto L_0x0044;
    L_0x003b:
        if (r4 != r7) goto L_0x0031;
    L_0x003d:
        r4 = 4;
        goto L_0x0044;
    L_0x003f:
        r5 = 10;
        if (r4 != r5) goto L_0x0031;
    L_0x0043:
        r4 = 2;
    L_0x0044:
        if (r4 <= 0) goto L_0x004d;
    L_0x0046:
        r0 = a(r2, r0, r4);
        r2 = r0;
        r0 = r3;
        goto L_0x0051;
    L_0x004d:
        r2 = r8.d(r2, r0);
    L_0x0051:
        r0 = r0 + 1;
        goto L_0x0009;
    L_0x0054:
        r0 = new com.google.zxing.a.a.d$1;
        r0.<init>();
        r0 = java.util.Collections.min(r2, r0);
        r0 = (com.google.zxing.a.a.f) r0;
        r1 = r8.text;
        r0 = r0.o(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.a.a.d.yv():com.google.zxing.common.a");
    }

    private Collection<f> d(Iterable<f> iterable, int i) {
        Collection linkedList = new LinkedList();
        for (f a : iterable) {
            a(a, i, linkedList);
        }
        return F(linkedList);
    }

    private void a(f fVar, int i, Collection<f> collection) {
        char c = (char) (this.text[i] & 255);
        int i2 = 0;
        Object obj = abj[fVar.getMode()][c] > 0 ? 1 : null;
        f fVar2 = null;
        while (i2 <= 4) {
            int i3 = abj[i2][c];
            if (i3 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.bQ(i);
                }
                if (obj == null || i2 == fVar.getMode() || i2 == 2) {
                    collection.add(fVar2.G(i2, i3));
                }
                if (obj == null && abk[fVar.getMode()][i2] >= 0) {
                    collection.add(fVar2.H(i2, i3));
                }
            }
            i2++;
        }
        if (fVar.yw() > 0 || abj[fVar.getMode()][c] == 0) {
            collection.add(fVar.bP(i));
        }
    }

    private static Collection<f> a(Iterable<f> iterable, int i, int i2) {
        Iterable linkedList = new LinkedList();
        for (f a : iterable) {
            a(a, i, i2, linkedList);
        }
        return F(linkedList);
    }

    private static void a(f fVar, int i, int i2, Collection<f> collection) {
        f bQ = fVar.bQ(i);
        collection.add(bQ.G(4, i2));
        if (fVar.getMode() != 4) {
            collection.add(bQ.H(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(bQ.G(2, 16 - i2).G(2, 1));
        }
        if (fVar.yw() > 0) {
            collection.add(fVar.bP(i).bP(i + 1));
        }
    }

    private static Collection<f> F(Iterable<f> iterable) {
        Collection linkedList = new LinkedList();
        for (f fVar : iterable) {
            Object obj = 1;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) it.next();
                if (fVar2.a(fVar)) {
                    obj = null;
                    break;
                } else if (fVar.a(fVar2)) {
                    it.remove();
                }
            }
            if (obj != null) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }
}
