package com.google.zxing.datamatrix.encoder;

/* compiled from: X12Encoder */
final class m extends c {
    public int yG() {
        return 3;
    }

    m() {
    }

    public void a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        while (hVar.yN()) {
            char currentChar = hVar.getCurrentChar();
            hVar.pos++;
            a(currentChar, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                c.a(hVar, stringBuilder);
                if (j.c(hVar.getMessage(), hVar.pos, yG()) != yG()) {
                    hVar.cd(0);
                    break;
                }
            }
        }
        b(hVar, stringBuilder);
    }

    int a(char c, StringBuilder stringBuilder) {
        if (c == 13) {
            stringBuilder.append(0);
        } else if (c == ' ') {
            stringBuilder.append(3);
        } else if (c == '*') {
            stringBuilder.append(1);
        } else if (c == '>') {
            stringBuilder.append(2);
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
        } else if (c < 'A' || c > 'Z') {
            j.u(c);
        } else {
            stringBuilder.append((char) ((c - 65) + 14));
        }
        return 1;
    }

    void b(h hVar, StringBuilder stringBuilder) {
        hVar.yR();
        int yZ = hVar.yQ().yZ() - hVar.yK();
        hVar.pos -= stringBuilder.length();
        if (hVar.yP() > 1 || yZ > 1 || hVar.yP() != yZ) {
            hVar.m(254);
        }
        if (hVar.yL() < 0) {
            hVar.cd(0);
        }
    }
}
