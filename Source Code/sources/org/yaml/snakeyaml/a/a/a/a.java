package org.yaml.snakeyaml.a.a.a;

/* compiled from: Base64Coder */
public class a {
    private static final String fiq = System.getProperty("line.separator");
    private static char[] fir = new char[64];
    private static byte[] fis = new byte[128];

    static {
        int i;
        char c = 'A';
        int i2 = 0;
        while (c <= 'Z') {
            i = i2 + 1;
            fir[i2] = c;
            c = (char) (c + 1);
            i2 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i2 + 1;
            fir[i2] = c;
            c = (char) (c + 1);
            i2 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i2 + 1;
            fir[i2] = c;
            c = (char) (c + 1);
            i2 = i;
        }
        int i3 = i2 + 1;
        fir[i2] = '+';
        fir[i3] = '/';
        for (int i4 = 0; i4 < fis.length; i4++) {
            fis[i4] = (byte) -1;
        }
        for (int i5 = 0; i5 < 64; i5++) {
            fis[fir[i5]] = (byte) i5;
        }
    }

    public static byte[] d(char[] cArr) {
        return c(cArr, 0, cArr.length);
    }

    public static byte[] c(char[] cArr, int i, int i2) {
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        i2 += i;
        int i4 = 0;
        while (i < i2) {
            int i5;
            int i6 = i + 1;
            char c = cArr[i];
            int i7 = i6 + 1;
            char c2 = cArr[i6];
            int i8 = 65;
            if (i7 < i2) {
                i5 = i7 + 1;
                i7 = cArr[i7];
            } else {
                i5 = i7;
                i7 = 65;
            }
            if (i5 < i2) {
                i8 = i5 + 1;
                char c3 = cArr[i5];
                i5 = i8;
                i8 = c3;
            }
            if (c > 127 || c2 > 127 || i7 > 127 || i8 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = fis[c];
            byte b2 = fis[c2];
            byte b3 = fis[i7];
            byte b4 = fis[i8];
            if (b < (byte) 0 || b2 < (byte) 0 || b3 < (byte) 0 || b4 < (byte) 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i = (b << 2) | (b2 >>> 4);
            i6 = ((b2 & 15) << 4) | (b3 >>> 2);
            i7 = ((b3 & 3) << 6) | b4;
            i8 = i4 + 1;
            bArr[i4] = (byte) i;
            if (i8 < i3) {
                i = i8 + 1;
                bArr[i8] = (byte) i6;
            } else {
                i = i8;
            }
            if (i < i3) {
                i4 = i + 1;
                bArr[i] = (byte) i7;
            } else {
                i4 = i;
            }
            i = i5;
        }
        return bArr;
    }
}
