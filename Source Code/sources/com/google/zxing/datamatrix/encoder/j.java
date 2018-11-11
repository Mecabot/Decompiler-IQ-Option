package com.google.zxing.datamatrix.encoder;

import com.google.zxing.a;
import java.util.Arrays;

/* compiled from: HighLevelEncoder */
public final class j {
    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean n(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean o(char c) {
        return c == ' ' || ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'));
    }

    private static boolean p(char c) {
        return c == ' ' || ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'));
    }

    private static boolean r(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    private static boolean s(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean t(char c) {
        return false;
    }

    private static char b(char c, int i) {
        int i2 = c + (((i * 149) % 253) + 1);
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    public static String a(String str, SymbolShapeHint symbolShapeHint, a aVar, a aVar2) {
        r0 = new g[6];
        int i = 0;
        r0[0] = new a();
        r0[1] = new c();
        r0[2] = new l();
        r0[3] = new m();
        r0[4] = new f();
        r0[5] = new b();
        h hVar = new h(str);
        hVar.a(symbolShapeHint);
        hVar.a(aVar, aVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.m(236);
            hVar.cc(2);
            hVar.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.m(237);
            hVar.cc(2);
            hVar.pos += 7;
        }
        while (hVar.yN()) {
            r0[i].a(hVar);
            if (hVar.yL() >= 0) {
                i = hVar.yL();
                hVar.yM();
            }
        }
        int yK = hVar.yK();
        hVar.yR();
        int yZ = hVar.yQ().yZ();
        if (!(yK >= yZ || i == 0 || i == 5)) {
            hVar.m(254);
        }
        StringBuilder yJ = hVar.yJ();
        if (yJ.length() < yZ) {
            yJ.append(129);
        }
        while (yJ.length() < yZ) {
            yJ.append(b(129, yJ.length() + 1));
        }
        return hVar.yJ().toString();
    }

    static int c(CharSequence charSequence, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        int i3 = i;
        if (i3 >= charSequence.length()) {
            return i2;
        }
        float[] fArr;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            float[] fArr2 = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr2[i2] = 0.0f;
            fArr = fArr2;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int a = a(fArr, iArr, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr);
                int p = p(bArr);
                if (iArr[0] == a) {
                    return 0;
                }
                if (p == 1 && bArr[5] > (byte) 0) {
                    return 5;
                }
                if (p == 1 && bArr[4] > (byte) 0) {
                    return 4;
                }
                if (p != 1 || bArr[2] <= (byte) 0) {
                    return (p != 1 || bArr[3] <= (byte) 0) ? 1 : 3;
                } else {
                    return 2;
                }
            }
            char charAt = charSequence2.charAt(i5);
            i4++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (n(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (o(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (n(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (p(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (n(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (q(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (n(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (s(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (n(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (t(charAt)) {
                i5 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                i5 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                a(fArr, iArr2, (int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr2);
                int p2 = p(bArr2);
                if (iArr2[0] < iArr2[i5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] >= iArr2[0] && ((bArr2[1] + bArr2[2]) + bArr2[3]) + bArr2[4] != 0) {
                    if (p2 == 1 && bArr2[4] > (byte) 0) {
                        return 4;
                    }
                    if (p2 == 1 && bArr2[2] > (byte) 0) {
                        return 2;
                    }
                    if (p2 == 1 && bArr2[3] > (byte) 0) {
                        return 3;
                    }
                    if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                        if (iArr2[1] < iArr2[3]) {
                            return 1;
                        }
                        if (iArr2[1] == iArr2[3]) {
                            i3 = (i3 + i4) + 1;
                            while (i3 < charSequence.length()) {
                                char charAt2 = charSequence2.charAt(i3);
                                if (!r(charAt2)) {
                                    if (!q(charAt2)) {
                                        break;
                                    }
                                    i3++;
                                } else {
                                    return 3;
                                }
                            }
                            return 1;
                        }
                    }
                }
            }
        }
        return 5;
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (i = 0; i < 6; i++) {
            iArr[i] = (int) Math.ceil((double) fArr[i]);
            int i3 = iArr[i];
            if (i2 > i3) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i3;
            }
            if (i2 == i3) {
                bArr[i] = (byte) (bArr[i] + 1);
            }
        }
        return i2;
    }

    private static int p(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    private static boolean q(char c) {
        return r(c) || c == ' ' || ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'));
    }

    public static int d(CharSequence charSequence, int i) {
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

    static void u(char c) {
        String toHexString = Integer.toHexString(c);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0000".substring(0, 4 - toHexString.length()));
        stringBuilder.append(toHexString);
        toHexString = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder("Illegal character: ");
        stringBuilder2.append(c);
        stringBuilder2.append(" (0x");
        stringBuilder2.append(toHexString);
        stringBuilder2.append(')');
        throw new IllegalArgumentException(stringBuilder2.toString());
    }
}
