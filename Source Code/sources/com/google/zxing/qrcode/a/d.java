package com.google.zxing.qrcode.a;

/* compiled from: MaskUtil */
final class d {
    static int c(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    static int d(b bVar) {
        byte[][] zr = bVar.zr();
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height - 1) {
            byte[] bArr = zr[i];
            int i3 = i2;
            i2 = 0;
            while (i2 < width - 1) {
                byte b = bArr[i2];
                int i4 = i2 + 1;
                if (b == bArr[i4]) {
                    int i5 = i + 1;
                    if (b == zr[i5][i2] && b == zr[i5][i4]) {
                        i3++;
                    }
                }
                i2 = i4;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    static int e(b bVar) {
        byte[][] zr = bVar.zr();
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            i2 = 0;
            while (i2 < width) {
                byte[] bArr = zr[i];
                int i4 = i2 + 6;
                if (i4 < width && bArr[i2] == (byte) 1 && bArr[i2 + 1] == (byte) 0 && bArr[i2 + 2] == (byte) 1 && bArr[i2 + 3] == (byte) 1 && bArr[i2 + 4] == (byte) 1 && bArr[i2 + 5] == (byte) 0 && bArr[i4] == (byte) 1 && (f(bArr, i2 - 4, i2) || f(bArr, i2 + 7, i2 + 11))) {
                    i3++;
                }
                int i5 = i + 6;
                if (i5 < height && zr[i][i2] == (byte) 1 && zr[i + 1][i2] == (byte) 0 && zr[i + 2][i2] == (byte) 1 && zr[i + 3][i2] == (byte) 1 && zr[i + 4][i2] == (byte) 1 && zr[i + 5][i2] == (byte) 0 && zr[i5][i2] == (byte) 1 && (a(zr, i2, i - 4, i) || a(zr, i2, i + 7, i + 11))) {
                    i3++;
                }
                i2++;
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    private static boolean f(byte[] bArr, int i, int i2) {
        i2 = Math.min(i2, bArr.length);
        for (i = Math.max(i, 0); i < i2; i++) {
            if (bArr[i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        i3 = Math.min(i3, bArr.length);
        for (i2 = Math.max(i2, 0); i2 < i3; i2++) {
            if (bArr[i2][i] == (byte) 1) {
                return false;
            }
        }
        return true;
    }

    static int f(b bVar) {
        byte[][] zr = bVar.zr();
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            byte[] bArr = zr[i];
            int i3 = i2;
            for (i2 = 0; i2 < width; i2++) {
                if (bArr[i2] == (byte) 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int height2 = bVar.getHeight() * bVar.getWidth();
        return ((Math.abs((i2 << 1) - height2) * 10) / height2) * 10;
    }

    static boolean l(int i, int i2, int i3) {
        switch (i) {
            case 0:
                i = (i3 + i2) & 1;
                break;
            case 1:
                i = i3 & 1;
                break;
            case 2:
                i = i2 % 3;
                break;
            case 3:
                i = (i3 + i2) % 3;
                break;
            case 4:
                i = ((i3 / 2) + (i2 / 3)) & 1;
                break;
            case 5:
                i3 *= i2;
                i = (i3 & 1) + (i3 % 3);
                break;
            case 6:
                i3 *= i2;
                i = ((i3 & 1) + (i3 % 3)) & 1;
                break;
            case 7:
                i = (((i3 * i2) % 3) + ((i3 + i2) & 1)) & 1;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder("Invalid mask pattern: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    private static int a(b bVar, boolean z) {
        int height = z ? bVar.getHeight() : bVar.getWidth();
        int width = z ? bVar.getWidth() : bVar.getHeight();
        byte[][] zr = bVar.zr();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            i2 = 0;
            int i4 = 0;
            byte b = (byte) -1;
            while (i2 < width) {
                byte b2 = z ? zr[i][i2] : zr[i2][i];
                if (b2 == b) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b = b2;
                }
                i2++;
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i2 = i3;
            i++;
        }
        return i2;
    }
}
