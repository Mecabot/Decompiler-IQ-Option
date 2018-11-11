package com.pro100svitlo.creditCardNfcReader.a;

import java.util.Locale;

/* compiled from: BytesUtils */
public final class a {
    public static String T(byte[] bArr) {
        return a(bArr, "%02x ", false);
    }

    private static String a(byte[] bArr, String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            stringBuffer.append("");
        } else {
            Object obj = null;
            for (byte b : bArr) {
                if (b != (byte) 0 || !z || obj != null) {
                    stringBuffer.append(String.format(str, new Object[]{Integer.valueOf(b & 255)}));
                    obj = 1;
                }
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.getDefault()).trim();
    }

    public static byte[] lj(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
        String replace = str.replace(" ", "");
        if (replace.length() % 2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hex binary needs to be even-length :");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[Math.round(((float) replace.length()) / 2.0f)];
        int i = 0;
        int i2 = 0;
        while (i < replace.length()) {
            int i3 = i + 2;
            int i4 = i2 + 1;
            bArr[i2] = Integer.valueOf(Integer.parseInt(replace.substring(i, i3), 16)).byteValue();
            i = i3;
            i2 = i4;
        }
        return bArr;
    }

    public static boolean aL(int i, int i2) {
        if (i2 >= 0 && i2 <= 31) {
            return (i & (1 << i2)) != 0;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("parameter 'pBitIndex' must be between 0 and 31. pBitIndex=");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static byte a(byte b, int i, boolean z) {
        if (i >= 0 && i <= 7) {
            return z ? (byte) (b | (1 << i)) : (byte) (b & ((1 << i) ^ -1));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("parameter 'pBitIndex' must be between 0 and 7. pBitIndex=");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
