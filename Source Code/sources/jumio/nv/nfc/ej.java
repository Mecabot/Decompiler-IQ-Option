package jumio.nv.nfc;

/* compiled from: SynWTFilterFloatLift9x7 */
public class ej extends ei {
    public boolean b() {
        return false;
    }

    public void a(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8) {
        int i9;
        int i10 = i2 + i5;
        int i11 = i8 * 2;
        int i12 = 1;
        if (i10 > 1) {
            fArr3[i7] = (fArr[i] / 0.8128931f) - ((fArr2[i4] * 0.88701373f) / 1.2301741f);
        } else {
            fArr3[i7] = fArr[i];
        }
        int i13 = i7 + i11;
        int i14 = i + i3;
        int i15 = i4 + i6;
        int i16 = i13;
        int i17 = 2;
        while (true) {
            i9 = i10 - 1;
            if (i17 >= i9) {
                break;
            }
            fArr3[i16] = (fArr[i14] / 0.8128931f) - (((fArr2[i15 - i6] + fArr2[i15]) * 0.44350687f) / 1.2301741f);
            i17 += 2;
            i16 += i11;
            i14 += i3;
            i15 += i6;
        }
        i17 = i10 % 2;
        if (i17 == 1 && i10 > 2) {
            fArr3[i16] = (fArr[i14] / 0.8128931f) - ((fArr2[i15 - i6] * 0.88701373f) / 1.2301741f);
        }
        int i18 = i7 + i8;
        int i19 = i4;
        int i20 = i18;
        int i21 = 1;
        while (i21 < i9) {
            fArr3[i20] = (fArr2[i19] / 1.2301741f) - ((fArr3[i20 - i8] + fArr3[i20 + i8]) * 0.8829111f);
            i21 += 2;
            i20 += i11;
            i19 += i6;
        }
        if (i17 == 0) {
            fArr3[i20] = (fArr2[i19] / 1.2301741f) - (fArr3[i20 - i8] * 1.7658222f);
        }
        if (i10 > 1) {
            fArr3[i7] = fArr3[i7] - (fArr3[i18] * -0.105960235f);
        }
        int i22 = 2;
        while (i22 < i9) {
            fArr3[i13] = fArr3[i13] - ((fArr3[i13 - i8] + fArr3[i13 + i8]) * -0.052980117f);
            i22 += 2;
            i13 += i11;
        }
        if (i17 == 1 && i10 > 2) {
            fArr3[i13] = fArr3[i13] - (fArr3[i13 - i8] * -0.105960235f);
        }
        while (i12 < i9) {
            fArr3[i18] = fArr3[i18] - ((fArr3[i18 - i8] + fArr3[i18 + i8]) * -1.5861343f);
            i12 += 2;
            i18 += i11;
        }
        if (i17 == 0) {
            fArr3[i18] = fArr3[i18] - (fArr3[i18 - i8] * -3.1722686f);
        }
    }

    public void b(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6, float[] fArr3, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i2 + i5;
        int i15 = i8 * 2;
        if (i14 != 1) {
            i9 = i14 >> 1;
            i10 = i;
            i11 = i4;
            for (i12 = 0; i12 < i9; i12++) {
                fArr[i10] = fArr[i10] / 0.8128931f;
                fArr2[i11] = fArr2[i11] / 1.2301741f;
                i10 += i3;
                i11 += i6;
            }
            if (i14 % 2 == 1) {
                fArr2[i11] = fArr2[i11] / 1.2301741f;
            }
        } else {
            fArr2[i4] = fArr2[i4] / 2.0f;
        }
        i9 = i7 + i8;
        i11 = i;
        int i16 = i4;
        i10 = i9;
        while (true) {
            i13 = i14 - 1;
            if (1 >= i13) {
                break;
            }
            float f = fArr[i11];
            float f2 = fArr2[i16];
            i16 += i6;
            fArr3[i10] = f - ((f2 + fArr2[i16]) * 0.44350687f);
            i10 += i15;
            i11 += i3;
            i12 = 1 + 2;
        }
        int i17 = i14 % 2;
        if (i17 == 0) {
            i12 = 1;
            if (i14 > 1) {
                fArr3[i10] = fArr[i11] - (fArr2[i16] * 0.88701373f);
            }
        } else {
            i12 = 1;
        }
        if (i14 > i12) {
            fArr3[i7] = fArr2[i4] - (fArr3[i9] * 1.7658222f);
        } else {
            fArr3[i7] = fArr2[i4];
        }
        i12 = i7 + i15;
        i10 = 2;
        i16 = i4 + i6;
        i11 = i12;
        for (int i18 = 2; i18 < i13; i18 += 2) {
            fArr3[i11] = fArr2[i16] - ((fArr3[i11 - i8] + fArr3[i11 + i8]) * 0.8829111f);
            i11 += i15;
            i16 += i6;
        }
        if (i17 == 1 && i14 > 1) {
            fArr3[i11] = fArr2[i16] - (fArr3[i11 - i8] * 1.7658222f);
        }
        int i19 = i9;
        for (int i20 = 1; i20 < i13; i20 += 2) {
            fArr3[i19] = fArr3[i19] - ((fArr3[i19 - i8] + fArr3[i19 + i8]) * -0.052980117f);
            i19 += i15;
        }
        if (i17 == 0 && i14 > 1) {
            fArr3[i19] = fArr3[i19] - (fArr3[i19 - i8] * -0.105960235f);
        }
        if (i14 > 1) {
            fArr3[i7] = fArr3[i7] - (fArr3[i9] * -3.1722686f);
        }
        while (i10 < i13) {
            fArr3[i12] = fArr3[i12] - ((fArr3[i12 - i8] + fArr3[i12 + i8]) * -1.5861343f);
            i12 += i15;
            i10 += 2;
        }
        if (i17 == 1 && i14 > 1) {
            fArr3[i12] = fArr3[i12] - (fArr3[i12 - i8] * -3.1722686f);
        }
    }
}
