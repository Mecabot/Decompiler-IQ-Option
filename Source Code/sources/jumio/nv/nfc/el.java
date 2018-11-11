package jumio.nv.nfc;

/* compiled from: SynWTFilterIntLift5x3 */
public class el extends ek {
    public boolean b() {
        return true;
    }

    public void a(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8) {
        int i9;
        int i10 = i2 + i5;
        int i11 = i8 * 2;
        if (i10 > 1) {
            iArr3[i7] = iArr[i] - ((iArr2[i4] + 1) >> 1);
        } else {
            iArr3[i7] = iArr[i];
        }
        int i12 = i7 + i11;
        int i13 = i4 + i6;
        int i14 = i + i3;
        int i15 = 2;
        while (true) {
            i9 = i10 - 1;
            if (i15 >= i9) {
                break;
            }
            iArr3[i12] = iArr[i14] - (((iArr2[i13 - i6] + iArr2[i13]) + 2) >> 2);
            i14 += i3;
            i13 += i6;
            i12 += i11;
            i15 += 2;
        }
        i15 = i10 % 2;
        if (i15 == 1 && i10 > 2) {
            iArr3[i12] = iArr[i14] - (((iArr2[i13 - i6] * 2) + 2) >> 2);
        }
        int i16 = i4;
        int i17 = i7 + i8;
        for (int i18 = 1; i18 < i9; i18 += 2) {
            iArr3[i17] = iArr2[i16] + ((iArr3[i17 - i8] + iArr3[i17 + i8]) >> 1);
            i16 += i6;
            i17 += i11;
        }
        if (i15 == 0 && i10 > 1) {
            iArr3[i17] = iArr2[i16] + iArr3[i17 - i8];
        }
    }

    public void b(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8) {
        int i9;
        int i10 = i2 + i5;
        int i11 = i8 * 2;
        int i12 = i7 + i8;
        int i13 = i;
        int i14 = i4;
        int i15 = i12;
        int i16 = 1;
        while (true) {
            i9 = i10 - 1;
            if (i16 >= i9) {
                break;
            }
            i9 = iArr[i13];
            int i17 = iArr2[i14];
            i14 += i6;
            iArr3[i15] = i9 - (((i17 + iArr2[i14]) + 2) >> 2);
            i13 += i3;
            i15 += i11;
            i16 += 2;
        }
        if (i10 > 1 && i10 % 2 == 0) {
            iArr3[i15] = iArr[i13] - (((iArr2[i14] * 2) + 2) >> 2);
        }
        if (i10 > 1) {
            iArr3[i7] = iArr2[i4] + iArr3[i12];
        } else {
            iArr3[i7] = iArr2[i4] >> 1;
        }
        int i18 = i7 + i11;
        int i19 = i4 + i6;
        for (int i20 = 2; i20 < i9; i20 += 2) {
            iArr3[i18] = iArr2[i19] + ((iArr3[i18 - i8] + iArr3[i18 + i8]) >> 1);
            i19 += i6;
            i18 += i11;
        }
        if (i10 % 2 == 1 && i10 > 1) {
            iArr3[i18] = iArr2[i19] + iArr3[i18 - i8];
        }
    }
}
