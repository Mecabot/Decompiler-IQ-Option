package com.google.zxing.datamatrix.encoder;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.iqoption.dto.ChartTimeInterval;
import com.jumio.analytics.MobileEvents;

/* compiled from: ErrorCorrection */
public final class i {
    private static final int[] abY = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] abZ;
    private static final int[] aca = new int[256];
    private static final int[] acb = new int[255];

    static {
        r0 = new int[16][];
        int i = 0;
        r0[0] = new int[]{228, 48, 15, 111, 62};
        r0[1] = new int[]{23, 68, 144, 134, 240, 92, 254};
        r0[2] = new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61};
        r0[3] = new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, ChartTimeInterval.CANDLE_2m};
        r0[4] = new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242};
        r0[5] = new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185};
        r0[6] = new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188};
        r0[7] = new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172};
        r0[8] = new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193};
        r0[9] = new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, ChartTimeInterval.CANDLE_2m, 151, 233, 168, 93, 255};
        r0[10] = new int[]{245, 127, 242, 218, 130, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, 102, ChartTimeInterval.CANDLE_2m, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112};
        r0[11] = new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5};
        r0[12] = new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, ChartTimeInterval.CANDLE_2m, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19};
        r0[13] = new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46};
        r0[14] = new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, 221, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204};
        r0[15] = new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186};
        abZ = r0;
        int i2 = 1;
        while (i < 255) {
            acb[i] = i2;
            aca[i2] = i;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= MobileEvents.EVENTTYPE_USERACTION;
            }
            i++;
        }
    }

    public static String a(String str, k kVar) {
        if (str.length() != kVar.yZ()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder stringBuilder = new StringBuilder(kVar.yZ() + kVar.za());
        stringBuilder.append(str);
        int yH = kVar.yH();
        if (yH == 1) {
            stringBuilder.append(c(str, kVar.za()));
        } else {
            int i;
            stringBuilder.setLength(stringBuilder.capacity());
            int[] iArr = new int[yH];
            int[] iArr2 = new int[yH];
            int[] iArr3 = new int[yH];
            int i2 = 0;
            while (i2 < yH) {
                i = i2 + 1;
                iArr[i2] = kVar.bX(i);
                iArr2[i2] = kVar.cf(i);
                iArr3[i2] = 0;
                if (i2 > 0) {
                    iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                }
                i2 = i;
            }
            for (int i3 = 0; i3 < yH; i3++) {
                StringBuilder stringBuilder2 = new StringBuilder(iArr[i3]);
                for (i = i3; i < kVar.yZ(); i += yH) {
                    stringBuilder2.append(str.charAt(i));
                }
                String c = c(stringBuilder2.toString(), iArr2[i3]);
                i = i3;
                int i4 = 0;
                while (i < iArr2[i3] * yH) {
                    int i5 = i4 + 1;
                    stringBuilder.setCharAt(kVar.yZ() + i, c.charAt(i4));
                    i += yH;
                    i4 = i5;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String c(CharSequence charSequence, int i) {
        return a(charSequence, 0, charSequence.length(), i);
    }

    private static String a(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i5 < abY.length) {
            if (abY[i5] == i3) {
                break;
            }
            i5++;
        }
        i5 = -1;
        if (i5 < 0) {
            StringBuilder stringBuilder = new StringBuilder("Illegal number of error correction codewords specified: ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i6;
        int[] iArr = abZ[i5];
        char[] cArr = new char[i3];
        for (i6 = 0; i6 < i3; i6++) {
            cArr[i6] = 0;
        }
        for (i6 = i; i6 < i + i2; i6++) {
            int i7 = i3 - 1;
            int charAt = cArr[i7] ^ charSequence.charAt(i6);
            while (i7 > 0) {
                if (charAt == 0 || iArr[i7] == 0) {
                    cArr[i7] = cArr[i7 - 1];
                } else {
                    cArr[i7] = (char) (cArr[i7 - 1] ^ acb[(aca[charAt] + aca[iArr[i7]]) % 255]);
                }
                i7--;
            }
            if (charAt == 0 || iArr[0] == 0) {
                cArr[0] = 0;
            } else {
                cArr[0] = (char) acb[(aca[charAt] + aca[iArr[0]]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        while (i4 < i3) {
            cArr2[i4] = cArr[(i3 - i4) - 1];
            i4++;
        }
        return String.valueOf(cArr2);
    }
}
