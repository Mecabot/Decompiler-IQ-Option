package com.google.android.gms.common.util;

public final class zzm {
    private static final char[] zzgky = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzgkz = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String zzm(byte[] bArr) {
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length << 1);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(zzgky[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(zzgky[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static String zzn(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            cArr[i] = zzgkz[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = zzgkz[i2 & 15];
        }
        return new String(cArr);
    }
}
