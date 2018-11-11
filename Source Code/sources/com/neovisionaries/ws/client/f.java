package com.neovisionaries.ws.client;

/* compiled from: DeflateDecompressor */
class f {
    f() {
    }

    public static void a(c cVar, c cVar2) {
        a(cVar, 0, cVar2);
    }

    private static void a(c cVar, int i, c cVar2) {
        while (a(cVar, new int[]{i * 8}, cVar2)) {
        }
    }

    private static boolean a(c cVar, int[] iArr, c cVar2) {
        boolean o = cVar.o(iArr);
        switch (cVar.c(iArr, 2)) {
            case 0:
                b(cVar, iArr, cVar2);
                break;
            case 1:
                c(cVar, iArr, cVar2);
                break;
            case 2:
                d(cVar, iArr, cVar2);
                break;
            default:
                throw new FormatException(String.format("[%s] Bad compression type '11' at the bit index '%d'.", new Object[]{f.class.getSimpleName(), Integer.valueOf(iArr[0])}));
        }
        if (cVar.length() <= iArr[0] / 8) {
            o = true;
        }
        if (o) {
            return false;
        }
        return true;
    }

    private static void b(c cVar, int[] iArr, c cVar2) {
        int i = ((iArr[0] + 7) & -8) / 8;
        int i2 = (cVar.get(i) & 255) + ((cVar.get(i + 1) & 255) * 256);
        i += 4;
        cVar2.a(cVar, i, i2);
        iArr[0] = (i + i2) * 8;
    }

    private static void c(c cVar, int[] iArr, c cVar2) {
        a(cVar, iArr, cVar2, k.aQk(), j.aQj());
    }

    private static void d(c cVar, int[] iArr, c cVar2) {
        n[] nVarArr = new n[2];
        g.a(cVar, iArr, nVarArr);
        a(cVar, iArr, cVar2, nVarArr[0], nVarArr[1]);
    }

    private static void a(c cVar, int[] iArr, c cVar2, n nVar, n nVar2) {
        while (true) {
            int a = nVar.a(cVar, iArr);
            if (a != 256) {
                if (a < 0 || a > 255) {
                    a(g.a(cVar, iArr, a), g.a(cVar, iArr, nVar2), cVar2);
                } else {
                    cVar2.ic(a);
                }
            } else {
                return;
            }
        }
    }

    private static void a(int i, int i2, c cVar) {
        int length = cVar.length();
        byte[] bArr = new byte[i];
        i2 = length - i2;
        int i3 = 0;
        int i4 = i2;
        while (i3 < i) {
            if (length <= i4) {
                i4 = i2;
            }
            bArr[i3] = cVar.get(i4);
            i3++;
            i4++;
        }
        cVar.s(bArr);
    }
}
