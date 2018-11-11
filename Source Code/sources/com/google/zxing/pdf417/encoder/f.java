package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.iqoption.dto.ChartTimeInterval;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* compiled from: PDF417HighLevelEncoder */
final class f {
    private static final byte[] acU = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 38, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 35, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 43, (byte) 37, (byte) 42, (byte) 61, (byte) 94, (byte) 0, (byte) 32, (byte) 0, (byte) 0, (byte) 0};
    private static final byte[] acV = new byte[]{(byte) 59, (byte) 60, (byte) 62, (byte) 64, (byte) 91, (byte) 92, (byte) 93, (byte) 95, (byte) 96, (byte) 126, (byte) 33, (byte) 13, (byte) 9, (byte) 44, (byte) 58, (byte) 10, (byte) 45, (byte) 46, (byte) 36, (byte) 47, (byte) 34, (byte) 124, (byte) 42, (byte) 40, (byte) 41, (byte) 63, (byte) 123, (byte) 125, (byte) 39, (byte) 0};
    private static final byte[] acW = new byte[128];
    private static final byte[] acX = new byte[128];
    private static final Charset acY = StandardCharsets.ISO_8859_1;

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean v(char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }

    private static boolean w(char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }

    private static boolean z(char c) {
        return c == 9 || c == 10 || c == 13 || (c >= ' ' && c <= '~');
    }

    static {
        Arrays.fill(acW, (byte) -1);
        for (int i = 0; i < acU.length; i++) {
            byte b = acU[i];
            if (b > (byte) 0) {
                acW[b] = (byte) i;
            }
        }
        Arrays.fill(acX, (byte) -1);
        for (int i2 = 0; i2 < acV.length; i2++) {
            byte b2 = acV[i2];
            if (b2 > (byte) 0) {
                acX[b2] = (byte) i2;
            }
        }
    }

    static String a(String str, Compaction compaction, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        if (charset == null) {
            charset = acY;
        } else if (!acY.equals(charset)) {
            CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name());
            if (characterSetECIByName != null) {
                a(characterSetECIByName.getValue(), stringBuilder);
            }
        }
        int length = str.length();
        switch (compaction) {
            case TEXT:
                a((CharSequence) str, 0, length, stringBuilder, 0);
                break;
            case BYTE:
                byte[] bytes = str.getBytes(charset);
                a(bytes, 0, bytes.length, 1, stringBuilder);
                break;
            case NUMERIC:
                stringBuilder.append(902);
                a(str, 0, length, stringBuilder);
                break;
            default:
                int i = 0;
                int i2 = 0;
                while (true) {
                    int i3 = 0;
                    while (i < length) {
                        int d = d(str, i);
                        if (d >= 13) {
                            stringBuilder.append(902);
                            i2 = 2;
                            a(str, i, d, stringBuilder);
                            i += d;
                        } else {
                            int g = g(str, i);
                            if (g >= 5 || d == length) {
                                if (i2 != 0) {
                                    stringBuilder.append(900);
                                    i2 = 0;
                                    i3 = 0;
                                }
                                i3 = a((CharSequence) str, i, g, stringBuilder, i3);
                                i += g;
                            } else {
                                d = a(str, i, charset);
                                if (d == 0) {
                                    d = 1;
                                }
                                d += i;
                                byte[] bytes2 = str.substring(i, d).getBytes(charset);
                                if (bytes2.length == 1 && i2 == 0) {
                                    a(bytes2, 0, 1, 0, stringBuilder);
                                } else {
                                    a(bytes2, 0, bytes2.length, i2, stringBuilder);
                                    i2 = 1;
                                    i3 = 0;
                                }
                                i = d;
                            }
                        }
                    }
                    break;
                }
                break;
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing block: B:41:0x00d0, code:
            r9 = 1;
     */
    /* JADX WARNING: Missing block: B:45:0x00dc, code:
            r9 = 2;
     */
    /* JADX WARNING: Missing block: B:47:0x00ea, code:
            r8 = r8 + 1;
     */
    /* JADX WARNING: Missing block: B:48:0x00ec, code:
            if (r8 < r1) goto L_0x0010;
     */
    /* JADX WARNING: Missing block: B:49:0x00ee, code:
            r0 = r3.length();
            r1 = 0;
            r7 = 0;
     */
    /* JADX WARNING: Missing block: B:50:0x00f4, code:
            if (r1 >= r0) goto L_0x0112;
     */
    /* JADX WARNING: Missing block: B:52:0x00f8, code:
            if ((r1 % 2) == 0) goto L_0x00fc;
     */
    /* JADX WARNING: Missing block: B:53:0x00fa, code:
            r8 = 1;
     */
    /* JADX WARNING: Missing block: B:54:0x00fc, code:
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:55:0x00fd, code:
            if (r8 == null) goto L_0x010b;
     */
    /* JADX WARNING: Missing block: B:56:0x00ff, code:
            r7 = (char) ((r7 * 30) + r3.charAt(r1));
            r2.append(r7);
     */
    /* JADX WARNING: Missing block: B:57:0x010b, code:
            r7 = r3.charAt(r1);
     */
    /* JADX WARNING: Missing block: B:58:0x010f, code:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:60:0x0113, code:
            if ((r0 % 2) == 0) goto L_0x011c;
     */
    /* JADX WARNING: Missing block: B:61:0x0115, code:
            r2.append((char) ((r7 * 30) + 29));
     */
    /* JADX WARNING: Missing block: B:62:0x011c, code:
            return r9;
     */
    /* JADX WARNING: Missing block: B:64:0x0120, code:
            r9 = 0;
     */
    private static int a(java.lang.CharSequence r17, int r18, int r19, java.lang.StringBuilder r20, int r21) {
        /*
        r0 = r17;
        r1 = r19;
        r2 = r20;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r1);
        r4 = 2;
        r6 = 0;
        r9 = r21;
        r8 = 0;
    L_0x0010:
        r10 = r18 + r8;
        r11 = r0.charAt(r10);
        r12 = 26;
        r13 = 32;
        r14 = 27;
        r15 = 28;
        r5 = 29;
        switch(r9) {
            case 0: goto L_0x00b4;
            case 1: goto L_0x007b;
            case 2: goto L_0x0033;
            default: goto L_0x0023;
        };
    L_0x0023:
        r10 = y(r11);
        if (r10 == 0) goto L_0x011d;
    L_0x0029:
        r10 = acX;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x0033:
        r12 = x(r11);
        if (r12 == 0) goto L_0x0043;
    L_0x0039:
        r10 = acW;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x0043:
        r12 = v(r11);
        if (r12 == 0) goto L_0x004e;
    L_0x0049:
        r3.append(r15);
        goto L_0x0120;
    L_0x004e:
        r12 = w(r11);
        if (r12 == 0) goto L_0x0059;
    L_0x0054:
        r3.append(r14);
        goto L_0x00d0;
    L_0x0059:
        r10 = r10 + 1;
        if (r10 >= r1) goto L_0x006e;
    L_0x005d:
        r10 = r0.charAt(r10);
        r10 = y(r10);
        if (r10 == 0) goto L_0x006e;
    L_0x0067:
        r9 = 3;
        r5 = 25;
        r3.append(r5);
        goto L_0x0010;
    L_0x006e:
        r3.append(r5);
        r10 = acX;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x007b:
        r10 = w(r11);
        if (r10 == 0) goto L_0x008e;
    L_0x0081:
        if (r11 != r13) goto L_0x0087;
    L_0x0083:
        r3.append(r12);
        goto L_0x00ea;
    L_0x0087:
        r11 = r11 + -97;
        r10 = (char) r11;
        r3.append(r10);
        goto L_0x00ea;
    L_0x008e:
        r10 = v(r11);
        if (r10 == 0) goto L_0x009e;
    L_0x0094:
        r3.append(r14);
        r11 = r11 + -65;
        r10 = (char) r11;
        r3.append(r10);
        goto L_0x00ea;
    L_0x009e:
        r10 = x(r11);
        if (r10 == 0) goto L_0x00a8;
    L_0x00a4:
        r3.append(r15);
        goto L_0x00dc;
    L_0x00a8:
        r3.append(r5);
        r10 = acX;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
        goto L_0x00ea;
    L_0x00b4:
        r10 = v(r11);
        if (r10 == 0) goto L_0x00c7;
    L_0x00ba:
        if (r11 != r13) goto L_0x00c0;
    L_0x00bc:
        r3.append(r12);
        goto L_0x00ea;
    L_0x00c0:
        r11 = r11 + -65;
        r10 = (char) r11;
        r3.append(r10);
        goto L_0x00ea;
    L_0x00c7:
        r10 = w(r11);
        if (r10 == 0) goto L_0x00d3;
    L_0x00cd:
        r3.append(r14);
    L_0x00d0:
        r9 = 1;
        goto L_0x0010;
    L_0x00d3:
        r10 = x(r11);
        if (r10 == 0) goto L_0x00df;
    L_0x00d9:
        r3.append(r15);
    L_0x00dc:
        r9 = 2;
        goto L_0x0010;
    L_0x00df:
        r3.append(r5);
        r10 = acX;
        r10 = r10[r11];
        r10 = (char) r10;
        r3.append(r10);
    L_0x00ea:
        r8 = r8 + 1;
        if (r8 < r1) goto L_0x0010;
    L_0x00ee:
        r0 = r3.length();
        r1 = 0;
        r7 = 0;
    L_0x00f4:
        if (r1 >= r0) goto L_0x0112;
    L_0x00f6:
        r8 = r1 % 2;
        if (r8 == 0) goto L_0x00fc;
    L_0x00fa:
        r8 = 1;
        goto L_0x00fd;
    L_0x00fc:
        r8 = 0;
    L_0x00fd:
        if (r8 == 0) goto L_0x010b;
    L_0x00ff:
        r7 = r7 * 30;
        r8 = r3.charAt(r1);
        r7 = r7 + r8;
        r7 = (char) r7;
        r2.append(r7);
        goto L_0x010f;
    L_0x010b:
        r7 = r3.charAt(r1);
    L_0x010f:
        r1 = r1 + 1;
        goto L_0x00f4;
    L_0x0112:
        r0 = r0 % r4;
        if (r0 == 0) goto L_0x011c;
    L_0x0115:
        r7 = r7 * 30;
        r7 = r7 + r5;
        r0 = (char) r7;
        r2.append(r0);
    L_0x011c:
        return r9;
    L_0x011d:
        r3.append(r5);
    L_0x0120:
        r9 = 0;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.f.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder stringBuilder) {
        int i4;
        int i5 = i2;
        StringBuilder stringBuilder2 = stringBuilder;
        if (i5 == 1 && i3 == 0) {
            stringBuilder2.append(913);
        } else if (i5 % 6 == 0) {
            stringBuilder2.append(924);
        } else {
            stringBuilder2.append(901);
        }
        if (i5 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i5) - i4 >= 6) {
                long j = 0;
                int i6 = 0;
                while (i6 < 6) {
                    i6++;
                    j = (j << 8) + ((long) (bArr[i4 + i6] & 255));
                }
                for (int i7 = 0; i7 < 5; i7++) {
                    cArr[i7] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (i6 = 4; i6 >= 0; i6--) {
                    stringBuilder2.append(cArr[i6]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i5) {
            stringBuilder2.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    private static void a(String str, int i, int i2, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            stringBuilder2.setLength(0);
            int min = Math.min(44, i2 - i3);
            StringBuilder stringBuilder3 = new StringBuilder("1");
            int i4 = i + i3;
            stringBuilder3.append(str.substring(i4, i4 + min));
            BigInteger bigInteger = new BigInteger(stringBuilder3.toString());
            do {
                stringBuilder2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = stringBuilder2.length() - 1; length >= 0; length--) {
                stringBuilder.append(stringBuilder2.charAt(length));
            }
            i3 += min;
        }
    }

    private static boolean x(char c) {
        return acW[c] != (byte) -1;
    }

    private static boolean y(char c) {
        return acX[c] != (byte) -1;
    }

    private static int d(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (isDigit(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    private static int g(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && isDigit(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
            if (i3 < 13) {
                if (i3 <= 0) {
                    if (!z(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            } else {
                return (i2 - i) - i3;
            }
        }
        return i2 - i;
    }

    private static int a(String str, int i, Charset charset) {
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && isDigit(charAt)) {
                i3++;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = str.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            charAt = str.charAt(i2);
            if (newEncoder.canEncode(charAt)) {
                i2++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Non-encodable character detected: ");
                stringBuilder.append(charAt);
                stringBuilder.append(" (Unicode: ");
                stringBuilder.append(charAt);
                stringBuilder.append(')');
                throw new WriterException(stringBuilder.toString());
            }
        }
        return i2 - i;
    }

    private static void a(int i, StringBuilder stringBuilder) {
        if (i >= 0 && i < ChartTimeInterval.CANDLE_15m) {
            stringBuilder.append(927);
            stringBuilder.append((char) i);
        } else if (i < 810900) {
            stringBuilder.append(926);
            stringBuilder.append((char) ((i / ChartTimeInterval.CANDLE_15m) - 1));
            stringBuilder.append((char) (i % ChartTimeInterval.CANDLE_15m));
        } else if (i < 811800) {
            stringBuilder.append(925);
            stringBuilder.append((char) (810900 - i));
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("ECI number not in valid range from 0..811799, but was ");
            stringBuilder2.append(i);
            throw new WriterException(stringBuilder2.toString());
        }
    }
}
