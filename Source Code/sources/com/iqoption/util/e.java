package com.iqoption.util;

import android.graphics.Bitmap;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.lang.reflect.Array;

/* compiled from: BitmapBlurer */
public class e {
    private final int[] b = new int[this.duP];
    private final int duP = (this.w * this.h);
    private final int[] duQ = new int[Math.max(this.w, this.h)];
    private final int[] duR = new int[(this.w * this.h)];
    private int duS;
    private int[] dv;
    private final int[] g = new int[this.duP];
    private final int h;
    private final int[] r = new int[this.duP];
    private final int w;

    public e(Bitmap bitmap) {
        this.w = bitmap.getWidth();
        this.h = bitmap.getHeight();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, int i) {
        bitmap.getPixels(this.duR, 0, this.w, 0, 0, this.w, this.h);
        if (this.dv == null) {
            this.duS = (((i + i) + 1) + 1) >> 1;
            this.duS *= this.duS;
            this.dv = new int[(this.duS * 256)];
        }
        a(bitmap2, this.w, this.h, this.r, this.g, this.b, this.duQ, this.dv, this.duS, this.duR, i);
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int i3 = (((i + i) + 1) + 1) >> 1;
        int i4 = i3 * i3;
        int[] iArr4 = new int[i2];
        int i5 = width;
        int[] iArr5 = iArr4;
        int[] iArr6 = new int[(i4 * 256)];
        int[] iArr7 = new int[Math.max(width, height)];
        bitmap.getPixels(iArr4, 0, i5, 0, 0, width, height);
        a(createBitmap, i5, height, iArr, iArr2, iArr3, iArr7, iArr6, i4, iArr5, i);
        return createBitmap;
    }

    private static void a(Bitmap bitmap, int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i3, int[] iArr6, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i;
        int i16 = i2;
        int i17 = i3;
        int i18 = i4;
        int i19 = i15 - 1;
        int i20 = i16 - 1;
        int i21 = (i18 + i18) + 1;
        for (i5 = 0; i5 < i17 * 256; i5++) {
            iArr5[i5] = i5 / i17;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(int.class, new int[]{i21, 3});
        int i22 = i18 + 1;
        i5 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i5 < i16) {
            i6 = -i18;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            while (i6 <= i18) {
                i13 = i20;
                i20 = iArr6[i23 + Math.min(i19, Math.max(i6, 0))];
                int[] iArr8 = iArr7[i6 + i18];
                iArr8[0] = (i20 & 16711680) >> 16;
                iArr8[1] = (i20 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i20 & 255;
                i20 = i22 - Math.abs(i6);
                i7 += iArr8[0] * i20;
                i8 += iArr8[1] * i20;
                i9 += iArr8[2] * i20;
                if (i6 > 0) {
                    i10 += iArr8[0];
                    i11 += iArr8[1];
                    i12 += iArr8[2];
                } else {
                    i25 += iArr8[0];
                    i26 += iArr8[1];
                    i27 += iArr8[2];
                }
                i6++;
                i20 = i13;
                i16 = i2;
            }
            i13 = i20;
            i20 = i18;
            for (i16 = 0; i16 < i15; i16++) {
                iArr[i23] = iArr5[i7];
                iArr2[i23] = iArr5[i8];
                iArr3[i23] = iArr5[i9];
                i7 -= i25;
                i8 -= i26;
                i9 -= i27;
                int[] iArr9 = iArr7[((i20 - i18) + i21) % i21];
                i25 -= iArr9[0];
                i26 -= iArr9[1];
                i27 -= iArr9[2];
                if (i5 == 0) {
                    iArr4[i16] = Math.min((i16 + i18) + 1, i19);
                }
                i14 = iArr6[i24 + iArr4[i16]];
                iArr9[0] = (i14 & 16711680) >> 16;
                iArr9[1] = (i14 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i14 & 255;
                i10 += iArr9[0];
                i11 += iArr9[1];
                i12 += iArr9[2];
                i7 += i10;
                i8 += i11;
                i9 += i12;
                i20 = (i20 + 1) % i21;
                int[] iArr10 = iArr7[i20 % i21];
                i25 += iArr10[0];
                i26 += iArr10[1];
                i27 += iArr10[2];
                i10 -= iArr10[0];
                i11 -= iArr10[1];
                i12 -= iArr10[2];
                i23++;
            }
            i24 += i15;
            i5++;
            i20 = i13;
            i16 = i2;
        }
        i13 = i20;
        i14 = 0;
        while (i14 < i15) {
            int abs;
            i16 = -i18;
            i19 = i16 * i15;
            i20 = 0;
            i6 = 0;
            i5 = 0;
            i23 = 0;
            i24 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            while (i16 <= i18) {
                i11 = Math.max(0, i19) + i14;
                int[] iArr11 = iArr7[i16 + i18];
                iArr11[0] = iArr[i11];
                iArr11[1] = iArr2[i11];
                iArr11[2] = iArr3[i11];
                abs = i22 - Math.abs(i16);
                i20 += iArr[i11] * abs;
                i6 += iArr2[i11] * abs;
                i5 += iArr3[i11] * abs;
                if (i16 > 0) {
                    i23 += iArr11[0];
                    i24 += iArr11[1];
                    i7 += iArr11[2];
                } else {
                    i8 += iArr11[0];
                    i9 += iArr11[1];
                    i10 += iArr11[2];
                }
                abs = i13;
                if (i16 < abs) {
                    i19 += i15;
                }
                i16++;
                i13 = abs;
            }
            abs = i13;
            i11 = i24;
            i12 = i7;
            i16 = i2;
            i19 = 0;
            i24 = i18;
            i7 = i23;
            i23 = i5;
            i5 = i6;
            i6 = i20;
            i20 = i14;
            while (i19 < i16) {
                iArr6[i20] = (((iArr6[i20] & ViewCompat.MEASURED_STATE_MASK) | (iArr5[i6] << 16)) | (iArr5[i5] << 8)) | iArr5[i23];
                i6 -= i8;
                i5 -= i9;
                i23 -= i10;
                int[] iArr12 = iArr7[((i24 - i18) + i21) % i21];
                i8 -= iArr12[0];
                i9 -= iArr12[1];
                i10 -= iArr12[2];
                if (i14 == 0) {
                    iArr4[i19] = Math.min(i19 + i22, abs) * i15;
                }
                i18 = iArr4[i19] + i14;
                iArr12[0] = iArr[i18];
                iArr12[1] = iArr2[i18];
                iArr12[2] = iArr3[i18];
                i7 += iArr12[0];
                i11 += iArr12[1];
                i12 += iArr12[2];
                i6 += i7;
                i5 += i11;
                i23 += i12;
                i24 = (i24 + 1) % i21;
                int[] iArr13 = iArr7[i24];
                i8 += iArr13[0];
                i9 += iArr13[1];
                i10 += iArr13[2];
                i7 -= iArr13[0];
                i11 -= iArr13[1];
                i12 -= iArr13[2];
                i20 += i15;
                i19++;
                i18 = i4;
            }
            i14++;
            i13 = abs;
            i18 = i4;
        }
        bitmap.setPixels(iArr6, 0, i15, 0, 0, i15, i2);
    }
}
