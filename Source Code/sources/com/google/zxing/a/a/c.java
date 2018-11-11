package com.google.zxing.a.a;

import com.google.zxing.common.a;
import com.google.zxing.common.b;

/* compiled from: Encoder */
public final class c {
    private static final int[] abg = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int e(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public static a e(byte[] bArr, int i, int i2) {
        boolean z;
        int abs;
        int e;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        a yv = new d(bArr).yv();
        int i8 = 11;
        int size = ((yv.getSize() * i) / 100) + 11;
        int size2 = yv.getSize() + size;
        int i9 = 32;
        int i10 = 0;
        if (i2 != 0) {
            z = i2 < 0;
            abs = Math.abs(i2);
            if (z) {
                i9 = 4;
            }
            if (abs > i9) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
            e = e(abs, z);
            i9 = abg[abs];
            i3 = e - (e % i9);
            yv = a(yv, i9);
            if (yv.getSize() + size > i3) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            } else if (!z || yv.getSize() <= (i9 << 6)) {
                i4 = e;
                i5 = abs;
            } else {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        }
        a aVar = null;
        e = 0;
        abs = 0;
        while (e <= 32) {
            boolean z2 = e <= 3;
            i5 = z2 ? e + 1 : e;
            i4 = e(i5, z2);
            if (size2 <= i4) {
                if (abs != abg[i5]) {
                    abs = abg[i5];
                    aVar = a(yv, abs);
                }
                i6 = i4 - (i4 % abs);
                if ((!z2 || aVar.getSize() <= (abs << 6)) && aVar.getSize() + size <= i6) {
                    i9 = abs;
                    yv = aVar;
                    z = z2;
                }
            }
            e++;
            i10 = 0;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
        a a = a(yv, i4, i9);
        int size3 = yv.getSize() / i9;
        a a2 = a(z, i5, size3);
        if (!z) {
            i8 = 14;
        }
        i8 += i5 << 2;
        int[] iArr = new int[i8];
        abs = 2;
        if (z) {
            for (i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
            i3 = i8;
        } else {
            int i11 = i8 / 2;
            i3 = (i8 + 1) + (((i11 - 1) / 15) * 2);
            i4 = i3 / 2;
            for (i6 = 0; i6 < i11; i6++) {
                i7 = (i6 / 15) + i6;
                iArr[(i11 - i6) - 1] = (i4 - i7) - 1;
                iArr[i11 + i6] = (i7 + i4) + 1;
            }
        }
        b bVar = new b(i3);
        i4 = 0;
        i6 = 0;
        while (i4 < i5) {
            i7 = ((i5 - i4) << abs) + (z ? 9 : 12);
            int i12 = 0;
            while (i12 < i7) {
                int i13 = i12 << 1;
                for (abs = 
/*
Method generation error in method: com.google.zxing.a.a.c.e(byte[], int, int):com.google.zxing.a.a.a, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r8_9 'abs' int) = (r8_8 'abs' int), (r8_21 'abs' int) binds: {(r8_8 'abs' int)=B:63:0x011c, (r8_21 'abs' int)=B:80:0x0191} in method: com.google.zxing.a.a.c.e(byte[], int, int):com.google.zxing.a.a.a, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:183)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:218)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:218)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:173)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:323)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:260)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:222)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 25 more

*/

    private static void a(b bVar, int i, int i2) {
        int i3;
        int i4;
        for (i3 = 0; i3 < i2; i3 += 2) {
            i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bVar.set(i5, i4);
                bVar.set(i5, i6);
                bVar.set(i4, i5);
                bVar.set(i6, i5);
                i5++;
            }
        }
        i3 = i - i2;
        bVar.set(i3, i3);
        i4 = i3 + 1;
        bVar.set(i4, i3);
        bVar.set(i3, i4);
        i += i2;
        bVar.set(i, i3);
        bVar.set(i, i4);
        bVar.set(i, i - 1);
    }

    static a a(boolean z, int i, int i2) {
        a aVar = new a();
        if (z) {
            aVar.K(i - 1, 2);
            aVar.K(i2 - 1, 6);
            return a(aVar, 28, 4);
        }
        aVar.K(i - 1, 5);
        aVar.K(i2 - 1, 11);
        return a(aVar, 40, 4);
    }

    private static void a(b bVar, boolean z, int i, a aVar) {
        i /= 2;
        int i2 = 0;
        int i3;
        if (z) {
            while (i2 < 7) {
                i3 = (i - 3) + i2;
                if (aVar.get(i2)) {
                    bVar.set(i3, i - 5);
                }
                if (aVar.get(i2 + 7)) {
                    bVar.set(i + 5, i3);
                }
                if (aVar.get(20 - i2)) {
                    bVar.set(i3, i + 5);
                }
                if (aVar.get(27 - i2)) {
                    bVar.set(i - 5, i3);
                }
                i2++;
            }
            return;
        }
        while (i2 < 10) {
            i3 = ((i - 5) + i2) + (i2 / 5);
            if (aVar.get(i2)) {
                bVar.set(i3, i - 7);
            }
            if (aVar.get(i2 + 10)) {
                bVar.set(i + 7, i3);
            }
            if (aVar.get(29 - i2)) {
                bVar.set(i3, i + 7);
            }
            if (aVar.get(39 - i2)) {
                bVar.set(i - 7, i3);
            }
            i2++;
        }
    }

    private static a a(a aVar, int i, int i2) {
        int size = aVar.getSize() / i2;
        com.google.zxing.common.a.c cVar = new com.google.zxing.common.a.c(bO(i2));
        int i3 = i / i2;
        int[] b = b(aVar, i2, i3);
        cVar.b(b, i3 - size);
        i %= i2;
        a aVar2 = new a();
        int i4 = 0;
        aVar2.K(0, i);
        i = b.length;
        while (i4 < i) {
            aVar2.K(b[i4], i2);
            i4++;
        }
        return aVar2;
    }

    private static int[] b(a aVar, int i, int i2) {
        int[] iArr = new int[i2];
        int size = aVar.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= aVar.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static com.google.zxing.common.a.a bO(int i) {
        if (i == 4) {
            return com.google.zxing.common.a.a.aby;
        }
        if (i == 6) {
            return com.google.zxing.common.a.a.abx;
        }
        if (i == 8) {
            return com.google.zxing.common.a.a.abB;
        }
        if (i == 10) {
            return com.google.zxing.common.a.a.abw;
        }
        if (i == 12) {
            return com.google.zxing.common.a.a.abv;
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported word size ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static a a(a aVar, int i) {
        a aVar2 = new a();
        int size = aVar.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4;
            int i5 = 0;
            for (i4 = 0; i4 < i; i4++) {
                int i6 = i3 + i4;
                if (i6 >= size || aVar.get(i6)) {
                    i5 |= 1 << ((i - 1) - i4);
                }
            }
            i4 = i5 & i2;
            if (i4 == i2) {
                aVar2.K(i4, i);
                i3--;
            } else if (i4 == 0) {
                aVar2.K(i5 | 1, i);
                i3--;
            } else {
                aVar2.K(i5, i);
            }
            i3 += i;
        }
        return aVar2;
    }
}
