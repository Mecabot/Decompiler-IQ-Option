package com.google.zxing.datamatrix.encoder;

/* compiled from: EdifactEncoder */
final class f implements g {
    public int yG() {
        return 4;
    }

    f() {
    }

    public void a(h hVar) {
        CharSequence stringBuilder = new StringBuilder();
        while (hVar.yN()) {
            b(hVar.getCurrentChar(), (StringBuilder) stringBuilder);
            hVar.pos++;
            if (stringBuilder.length() >= 4) {
                hVar.dI(b(stringBuilder, 0));
                stringBuilder.delete(0, 4);
                if (j.c(hVar.getMessage(), hVar.pos, yG()) != yG()) {
                    hVar.cd(0);
                    break;
                }
            }
        }
        stringBuilder.append(31);
        a(hVar, stringBuilder);
    }

    private static void a(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                int i = 1;
                if (length == 1) {
                    hVar.yR();
                    int yZ = hVar.yQ().yZ() - hVar.yK();
                    if (hVar.yP() == 0 && yZ <= 2) {
                        hVar.cd(0);
                        return;
                    }
                }
                if (length > 4) {
                    throw new IllegalStateException("Count must not exceed 4");
                }
                length--;
                String b = b(charSequence, 0);
                if ((hVar.yN() ^ 1) == 0 || length > 2) {
                    i = 0;
                }
                if (length <= 2) {
                    hVar.ce(hVar.yK() + length);
                    if (hVar.yQ().yZ() - hVar.yK() >= 3) {
                        hVar.ce(hVar.yK() + b.length());
                        i = 0;
                    }
                }
                if (i != 0) {
                    hVar.yS();
                    hVar.pos -= length;
                } else {
                    hVar.dI(b);
                }
                hVar.cd(0);
            }
        } finally {
            hVar.cd(0);
        }
    }

    private static void b(char c, StringBuilder stringBuilder) {
        if (c >= ' ' && c <= '?') {
            stringBuilder.append(c);
        } else if (c < '@' || c > '^') {
            j.u(c);
        } else {
            stringBuilder.append((char) (c - 64));
        }
    }

    private static String b(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        char charAt = charSequence.charAt(i);
        int i2 = 0;
        int charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
        int charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
        if (length >= 4) {
            i2 = charSequence.charAt(i + 3);
        }
        int i3 = (((charAt << 18) + (charAt2 << 12)) + (charAt3 << 6)) + i2;
        char c = (char) ((i3 >> 16) & 255);
        charAt = (char) ((i3 >> 8) & 255);
        char c2 = (char) (i3 & 255);
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append(c);
        if (length >= 2) {
            stringBuilder.append(charAt);
        }
        if (length >= 3) {
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }
}
