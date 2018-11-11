package com.google.zxing.qrcode.a;

import com.google.zxing.WriterException;
import com.google.zxing.common.a;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* compiled from: MatrixUtil */
final class e {
    private static final int[][] adp = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] adq = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] adr = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] ads = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static boolean cl(int i) {
        return i == -1;
    }

    static void g(b bVar) {
        bVar.b((byte) -1);
    }

    static void a(a aVar, ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.a aVar2, int i, b bVar) {
        g(bVar);
        a(aVar2, bVar);
        a(errorCorrectionLevel, i, bVar);
        b(aVar2, bVar);
        a(aVar, i, bVar);
    }

    static void a(com.google.zxing.qrcode.decoder.a aVar, b bVar) {
        j(bVar);
        i(bVar);
        c(aVar, bVar);
        h(bVar);
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i, b bVar) {
        a aVar = new a();
        a(errorCorrectionLevel, i, aVar);
        for (i = 0; i < aVar.getSize(); i++) {
            boolean z = aVar.get((aVar.getSize() - 1) - i);
            int[] iArr = ads[i];
            bVar.set(iArr[0], iArr[1], z);
            if (i < 8) {
                bVar.set((bVar.getWidth() - i) - 1, 8, z);
            } else {
                bVar.set(8, (bVar.getHeight() - 7) + (i - 8), z);
            }
        }
    }

    static void b(com.google.zxing.qrcode.decoder.a aVar, b bVar) {
        if (aVar.getVersionNumber() >= 7) {
            a aVar2 = new a();
            a(aVar, aVar2);
            int i = 0;
            int i2 = 17;
            while (i < 6) {
                int i3 = i2;
                for (i2 = 0; i2 < 3; i2++) {
                    boolean z = aVar2.get(i3);
                    i3--;
                    bVar.set(i, (bVar.getHeight() - 11) + i2, z);
                    bVar.set((bVar.getHeight() - 11) + i2, i, z);
                }
                i++;
                i2 = i3;
            }
        }
    }

    static void a(a aVar, int i, b bVar) {
        int width = bVar.getWidth() - 1;
        int height = bVar.getHeight() - 1;
        int i2 = 0;
        int i3 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < bVar.getHeight()) {
                int i4 = i2;
                for (i2 = 0; i2 < 2; i2++) {
                    int i5 = width - i2;
                    if (cl(bVar.U(i5, height))) {
                        boolean z;
                        if (i4 < aVar.getSize()) {
                            z = aVar.get(i4);
                            i4++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && d.l(i, i5, height)) {
                            z = !z;
                        }
                        bVar.set(i5, height, z);
                    }
                }
                height += i3;
                i2 = i4;
            }
            i3 = -i3;
            height += i3;
            width -= 2;
        }
        if (i2 != aVar.getSize()) {
            StringBuilder stringBuilder = new StringBuilder("Not all bits consumed: ");
            stringBuilder.append(i2);
            stringBuilder.append('/');
            stringBuilder.append(aVar.getSize());
            throw new WriterException(stringBuilder.toString());
        }
    }

    static int ck(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    static int V(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int ck = ck(i2);
        i <<= ck - 1;
        while (ck(i) >= ck) {
            i ^= i2 << (ck(i) - ck);
        }
        return i;
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i, a aVar) {
        if (f.cn(i)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i;
            aVar.K(bits, 5);
            aVar.K(V(bits, 1335), 10);
            a aVar2 = new a();
            aVar2.K(21522, 15);
            aVar.b(aVar2);
            if (aVar.getSize() != 15) {
                StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
                stringBuilder.append(aVar.getSize());
                throw new WriterException(stringBuilder.toString());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(com.google.zxing.qrcode.decoder.a aVar, a aVar2) {
        aVar2.K(aVar.getVersionNumber(), 6);
        aVar2.K(V(aVar.getVersionNumber(), 7973), 12);
        if (aVar2.getSize() != 18) {
            StringBuilder stringBuilder = new StringBuilder("should not happen but we got: ");
            stringBuilder.append(aVar2.getSize());
            throw new WriterException(stringBuilder.toString());
        }
    }

    private static void h(b bVar) {
        int i = 8;
        while (i < bVar.getWidth() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (cl(bVar.U(i, 6))) {
                bVar.set(i, 6, i3);
            }
            if (cl(bVar.U(6, i))) {
                bVar.set(6, i, i3);
            }
            i = i2;
        }
    }

    private static void i(b bVar) {
        if (bVar.U(8, bVar.getHeight() - 8) == (byte) 0) {
            throw new WriterException();
        }
        bVar.set(8, bVar.getHeight() - 8, 1);
    }

    private static void a(int i, int i2, b bVar) {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (cl(bVar.U(i4, i2))) {
                bVar.set(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void b(int i, int i2, b bVar) {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (cl(bVar.U(i, i4))) {
                bVar.set(i, i4, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void c(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = adq[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.set(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void d(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = adp[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.set(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void j(b bVar) {
        int length = adp[0].length;
        d(0, 0, bVar);
        d(bVar.getWidth() - length, 0, bVar);
        d(0, bVar.getWidth() - length, bVar);
        a(0, 7, bVar);
        a(bVar.getWidth() - 8, 7, bVar);
        a(0, bVar.getWidth() - 8, bVar);
        b(7, 0, bVar);
        b((bVar.getHeight() - 7) - 1, 0, bVar);
        b(7, bVar.getHeight() - 7, bVar);
    }

    private static void c(com.google.zxing.qrcode.decoder.a aVar, b bVar) {
        if (aVar.getVersionNumber() >= 2) {
            int[] iArr = adr[aVar.getVersionNumber() - 1];
            for (int i : iArr) {
                if (i >= 0) {
                    for (int i2 : iArr) {
                        if (i2 >= 0 && cl(bVar.U(i2, i))) {
                            c(i2 - 2, i - 2, bVar);
                        }
                    }
                }
            }
        }
    }
}
