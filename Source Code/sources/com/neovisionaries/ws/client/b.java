package com.neovisionaries.ws.client;

/* compiled from: Base64 */
class b {
    private static final byte[] dZu = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

    public static String encode(String str) {
        return str == null ? null : encode(p.kK(str));
    }

    public static String encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = (((((bArr.length * 8) + 5) / 6) + 3) / 4) * 4;
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (true) {
            int j = j(bArr, i);
            if (j < 0) {
                break;
            }
            stringBuilder.append((char) dZu[j]);
            i += 6;
        }
        for (int length2 = stringBuilder.length(); length2 < length; length2++) {
            stringBuilder.append('=');
        }
        return stringBuilder.toString();
    }

    private static int j(byte[] bArr, int i) {
        int i2 = i / 8;
        if (bArr.length <= i2) {
            return -1;
        }
        int i3;
        if (bArr.length - 1 == i2) {
            i3 = 0;
        } else {
            i3 = bArr[i2 + 1];
        }
        switch ((i % 24) / 6) {
            case 0:
                return (bArr[i2] >> 2) & 63;
            case 1:
                return ((bArr[i2] << 4) & 48) | ((i3 >> 4) & 15);
            case 2:
                return ((bArr[i2] << 2) & 60) | ((i3 >> 6) & 3);
            case 3:
                return bArr[i2] & 63;
            default:
                return 0;
        }
    }
}
