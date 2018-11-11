package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.b;
import java.util.Map;

/* compiled from: Code39Writer */
public final class e extends n {
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        StringBuilder stringBuilder = new StringBuilder("Can only encode CODE_39, but got ");
        stringBuilder.append(barcodeFormat);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0094 A:{LOOP_END, LOOP:3: B:20:0x0092->B:21:0x0094} */
    public boolean[] dJ(java.lang.String r12) {
        /*
        r11 = this;
        r0 = r12.length();
        r1 = 80;
        if (r0 <= r1) goto L_0x001c;
    L_0x0008:
        r12 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Requested contents should be less than 80 digits long, but got ";
        r1.<init>(r2);
        r1.append(r0);
        r0 = r1.toString();
        r12.<init>(r0);
        throw r12;
    L_0x001c:
        r2 = 0;
        r3 = 0;
    L_0x001e:
        if (r3 >= r0) goto L_0x0052;
    L_0x0020:
        r4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
        r5 = r12.charAt(r3);
        r4 = r4.indexOf(r5);
        if (r4 >= 0) goto L_0x004f;
    L_0x002c:
        r12 = dK(r12);
        r0 = r12.length();
        if (r0 <= r1) goto L_0x0052;
    L_0x0036:
        r12 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Requested contents should be less than 80 digits long, but got ";
        r1.<init>(r2);
        r1.append(r0);
        r0 = " (extended full ASCII mode)";
        r1.append(r0);
        r0 = r1.toString();
        r12.<init>(r0);
        throw r12;
    L_0x004f:
        r3 = r3 + 1;
        goto L_0x001e;
    L_0x0052:
        r1 = 9;
        r3 = new int[r1];
        r4 = r0 + 25;
        r5 = r4;
        r4 = 0;
    L_0x005a:
        if (r4 >= r0) goto L_0x007b;
    L_0x005c:
        r6 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
        r7 = r12.charAt(r4);
        r6 = r6.indexOf(r7);
        r7 = com.google.zxing.oned.d.acn;
        r6 = r7[r6];
        a(r6, r3);
        r6 = r5;
        r5 = 0;
    L_0x006f:
        if (r5 >= r1) goto L_0x0077;
    L_0x0071:
        r7 = r3[r5];
        r6 = r6 + r7;
        r5 = r5 + 1;
        goto L_0x006f;
    L_0x0077:
        r4 = r4 + 1;
        r5 = r6;
        goto L_0x005a;
    L_0x007b:
        r1 = new boolean[r5];
        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        a(r4, r3);
        r5 = 1;
        r6 = com.google.zxing.oned.n.a(r1, r2, r3, r5);
        r7 = new int[r5];
        r7[r2] = r5;
        r8 = com.google.zxing.oned.n.a(r1, r6, r7, r2);
        r6 = r6 + r8;
        r8 = r6;
        r6 = 0;
    L_0x0092:
        if (r6 >= r0) goto L_0x00b2;
    L_0x0094:
        r9 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
        r10 = r12.charAt(r6);
        r9 = r9.indexOf(r10);
        r10 = com.google.zxing.oned.d.acn;
        r9 = r10[r9];
        a(r9, r3);
        r9 = com.google.zxing.oned.n.a(r1, r8, r3, r5);
        r8 = r8 + r9;
        r9 = com.google.zxing.oned.n.a(r1, r8, r7, r2);
        r8 = r8 + r9;
        r6 = r6 + 1;
        goto L_0x0092;
    L_0x00b2:
        a(r4, r3);
        com.google.zxing.oned.n.a(r1, r8, r3, r5);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.e.dJ(java.lang.String):boolean[]");
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    private static String dK(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        stringBuilder.append("%V");
                    } else if (charAt != '`') {
                        switch (charAt) {
                            case '-':
                            case '.':
                                break;
                            default:
                                if (charAt <= 0 || charAt >= 27) {
                                    if (charAt <= 26 || charAt >= ' ') {
                                        if ((charAt <= ' ' || charAt >= '-') && charAt != '/' && charAt != ':') {
                                            if (charAt <= '/' || charAt >= ':') {
                                                if (charAt <= ':' || charAt >= '@') {
                                                    if (charAt <= '@' || charAt >= '[') {
                                                        if (charAt <= 'Z' || charAt >= '`') {
                                                            if (charAt <= '`' || charAt >= '{') {
                                                                if (charAt > 'z' && charAt < 128) {
                                                                    stringBuilder.append('%');
                                                                    stringBuilder.append((char) ((charAt - 123) + 80));
                                                                    break;
                                                                }
                                                                stringBuilder = new StringBuilder("Requested content contains a non-encodable character: '");
                                                                stringBuilder.append(str.charAt(i));
                                                                stringBuilder.append("'");
                                                                throw new IllegalArgumentException(stringBuilder.toString());
                                                            }
                                                            stringBuilder.append('+');
                                                            stringBuilder.append((char) ((charAt - 97) + 65));
                                                            break;
                                                        }
                                                        stringBuilder.append('%');
                                                        stringBuilder.append((char) ((charAt - 91) + 75));
                                                        break;
                                                    }
                                                    stringBuilder.append((char) ((charAt - 65) + 65));
                                                    break;
                                                }
                                                stringBuilder.append('%');
                                                stringBuilder.append((char) ((charAt - 59) + 70));
                                                break;
                                            }
                                            stringBuilder.append((char) ((charAt - 48) + 48));
                                            break;
                                        }
                                        stringBuilder.append('/');
                                        stringBuilder.append((char) ((charAt - 33) + 65));
                                        break;
                                    }
                                    stringBuilder.append('%');
                                    stringBuilder.append((char) ((charAt - 27) + 65));
                                    break;
                                }
                                stringBuilder.append('$');
                                stringBuilder.append((char) ((charAt - 1) + 65));
                                continue;
                        }
                    } else {
                        stringBuilder.append("%W");
                    }
                }
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append("%U");
            }
        }
        return stringBuilder.toString();
    }
}
