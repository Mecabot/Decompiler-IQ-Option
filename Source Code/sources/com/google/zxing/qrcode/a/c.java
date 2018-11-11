package com.google.zxing.qrcode.a;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.a;
import com.google.zxing.qrcode.decoder.a.b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: Encoder */
public final class c {
    private static final int[] adn = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int b(b bVar) {
        return ((d.c(bVar) + d.d(bVar)) + d.e(bVar)) + d.f(bVar);
    }

    public static f a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) {
        a a;
        String str2 = "ISO-8859-1";
        Object obj = (map == null || !map.containsKey(EncodeHintType.CHARACTER_SET)) ? null : 1;
        if (obj != null) {
            str2 = map.get(EncodeHintType.CHARACTER_SET).toString();
        }
        Mode U = U(str, str2);
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (U == Mode.BYTE && !(obj == null && "ISO-8859-1".equals(str2))) {
            CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2);
            if (characterSetECIByName != null) {
                a(characterSetECIByName, aVar);
            }
        }
        a(U, aVar);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        a(str, U, aVar2, str2);
        if (map == null || !map.containsKey(EncodeHintType.QR_VERSION)) {
            a = a(errorCorrectionLevel, U, aVar, aVar2);
        } else {
            a = a.ci(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!a(a(U, aVar, aVar2, a), a, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        }
        com.google.zxing.common.a aVar3 = new com.google.zxing.common.a();
        aVar3.a(aVar);
        a(U == Mode.BYTE ? aVar2.yz() : str.length(), a, U, aVar3);
        aVar3.a(aVar2);
        b a2 = a.a(errorCorrectionLevel);
        int zi = a.zi() - a2.zo();
        a(zi, aVar3);
        com.google.zxing.common.a a3 = a(aVar3, a.zi(), zi, a2.zn());
        f fVar = new f();
        fVar.b(errorCorrectionLevel);
        fVar.a(U);
        fVar.a(a);
        zi = a.zj();
        b bVar = new b(zi, zi);
        zi = a(a3, errorCorrectionLevel, a, bVar);
        fVar.cm(zi);
        e.a(a3, errorCorrectionLevel, a, zi, bVar);
        fVar.k(bVar);
        return fVar;
    }

    private static a a(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2) {
        return a(a(mode, aVar, aVar2, a(a(mode, aVar, aVar2, a.ci(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int a(Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2, a aVar3) {
        return (aVar.getSize() + mode.getCharacterCountBits(aVar3)) + aVar2.getSize();
    }

    static int cj(int i) {
        return i < adn.length ? adn[i] : -1;
    }

    private static Mode U(String str, String str2) {
        if ("Shift_JIS".equals(str2) && dM(str)) {
            return Mode.KANJI;
        }
        Object obj = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && cj(charAt) == -1) {
                return Mode.BYTE;
            }
            obj = 1;
        }
        if (obj != null) {
            return Mode.ALPHANUMERIC;
        }
        if (null != null) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean dM(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, a aVar2, b bVar) {
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            e.a(aVar, errorCorrectionLevel, aVar2, i3, bVar);
            int b = b(bVar);
            if (b < i) {
                i2 = i3;
                i = b;
            }
        }
        return i2;
    }

    private static a a(int i, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i2 = 1; i2 <= 40; i2++) {
            a ci = a.ci(i2);
            if (a(i, ci, errorCorrectionLevel)) {
                return ci;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, a aVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return aVar.zi() - aVar.a(errorCorrectionLevel).zo() >= (i + 7) / 8;
    }

    static void a(int i, com.google.zxing.common.a aVar) {
        int i2 = i << 3;
        if (aVar.getSize() > i2) {
            StringBuilder stringBuilder = new StringBuilder("data bits cannot fit in the QR Code");
            stringBuilder.append(aVar.getSize());
            stringBuilder.append(" > ");
            stringBuilder.append(i2);
            throw new WriterException(stringBuilder.toString());
        }
        int i3;
        int i4 = 0;
        for (i3 = 0; i3 < 4 && aVar.getSize() < i2; i3++) {
            aVar.ao(false);
        }
        i3 = aVar.getSize() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                aVar.ao(false);
                i3++;
            }
        }
        i -= aVar.yz();
        while (i4 < i) {
            aVar.K((i4 & 1) == 0 ? 236 : 17, 8);
            i4++;
        }
        if (aVar.getSize() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        i2 /= i3;
        int i9 = i2 + 1;
        i7 -= i2;
        i8 -= i9;
        if (i7 != i8) {
            throw new WriterException("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        } else if (i != ((i2 + i7) * i6) + ((i9 + i8) * i5)) {
            throw new WriterException("Total bytes mismatch");
        } else if (i4 < i6) {
            iArr[0] = i2;
            iArr2[0] = i7;
        } else {
            iArr[0] = i9;
            iArr2[0] = i8;
        }
    }

    static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (aVar.yz() != i5) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        Collection<a> arrayList = new ArrayList(i6);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = iArr2;
            a(i4, i5, i6, i11, iArr, iArr2);
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            aVar.b(i8 << 3, bArr, 0, i12);
            byte[] g = g(bArr, iArr3[0]);
            arrayList.add(new a(bArr, g));
            i9 = Math.max(i9, i12);
            i10 = Math.max(i10, g.length);
            i8 += iArr[0];
        }
        if (i5 != i8) {
            throw new WriterException("Data bytes does not match offset");
        }
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        for (int i13 = 0; i13 < i9; i13++) {
            for (a dataBytes : arrayList) {
                byte[] dataBytes2 = dataBytes.getDataBytes();
                if (i13 < dataBytes2.length) {
                    aVar2.K(dataBytes2[i13], 8);
                }
            }
        }
        while (i7 < i10) {
            for (a zq : arrayList) {
                byte[] zq2 = zq.zq();
                if (i7 < zq2.length) {
                    aVar2.K(zq2[i7], 8);
                }
            }
            i7++;
        }
        if (i4 == aVar2.yz()) {
            return aVar2;
        }
        StringBuilder stringBuilder = new StringBuilder("Interleaving error: ");
        stringBuilder.append(i4);
        stringBuilder.append(" and ");
        stringBuilder.append(aVar2.yz());
        stringBuilder.append(" differ.");
        throw new WriterException(stringBuilder.toString());
    }

    static byte[] g(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.google.zxing.common.a.c(com.google.zxing.common.a.a.abz).b(iArr, i);
        bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) iArr[length + i3];
        }
        return bArr;
    }

    static void a(Mode mode, com.google.zxing.common.a aVar) {
        aVar.K(mode.getBits(), 4);
    }

    static void a(int i, a aVar, Mode mode, com.google.zxing.common.a aVar2) {
        int characterCountBits = mode.getCharacterCountBits(aVar);
        int i2 = 1 << characterCountBits;
        if (i >= i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" is bigger than ");
            stringBuilder.append(i2 - 1);
            throw new WriterException(stringBuilder.toString());
        }
        aVar2.K(i, characterCountBits);
    }

    static void a(String str, Mode mode, com.google.zxing.common.a aVar, String str2) {
        switch (mode) {
            case NUMERIC:
                a((CharSequence) str, aVar);
                return;
            case ALPHANUMERIC:
                b(str, aVar);
                return;
            case BYTE:
                a(str, aVar, str2);
                return;
            case KANJI:
                a(str, aVar);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Invalid mode: ");
                stringBuilder.append(mode);
                throw new WriterException(stringBuilder.toString());
        }
    }

    static void a(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            int i2 = i + 2;
            if (i2 < length) {
                aVar.K(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i2) - 48), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    aVar.K((charAt * 10) + (charSequence.charAt(i) - 48), 7);
                    i = i2;
                } else {
                    aVar.K(charAt, 4);
                }
            }
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int cj = cj(charSequence.charAt(i));
            if (cj == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                i2 = cj(charSequence.charAt(i2));
                if (i2 == -1) {
                    throw new WriterException();
                }
                aVar.K((cj * 45) + i2, 11);
                i += 2;
            } else {
                aVar.K(cj, 6);
                i = i2;
            }
        }
    }

    static void a(String str, com.google.zxing.common.a aVar, String str2) {
        try {
            for (byte K : str.getBytes(str2)) {
                aVar.K(K, 8);
            }
        } catch (Throwable e) {
            throw new WriterException(e);
        }
    }

    static void a(String str, com.google.zxing.common.a aVar) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                aVar.K(((i2 >> 8) * 192) + (i2 & 255), 13);
            }
        } catch (Throwable e) {
            throw new WriterException(e);
        }
    }

    private static void a(CharacterSetECI characterSetECI, com.google.zxing.common.a aVar) {
        aVar.K(Mode.ECI.getBits(), 4);
        aVar.K(characterSetECI.getValue(), 8);
    }
}
