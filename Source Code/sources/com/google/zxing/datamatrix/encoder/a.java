package com.google.zxing.datamatrix.encoder;

/* compiled from: ASCIIEncoder */
final class a implements g {
    public int yG() {
        return 0;
    }

    a() {
    }

    public void a(h hVar) {
        if (j.d(hVar.getMessage(), hVar.pos) >= 2) {
            hVar.m(a(hVar.getMessage().charAt(hVar.pos), hVar.getMessage().charAt(hVar.pos + 1)));
            hVar.pos += 2;
            return;
        }
        char currentChar = hVar.getCurrentChar();
        int c = j.c(hVar.getMessage(), hVar.pos, yG());
        if (c != yG()) {
            switch (c) {
                case 1:
                    hVar.m(230);
                    hVar.cd(1);
                    return;
                case 2:
                    hVar.m(239);
                    hVar.cd(2);
                    return;
                case 3:
                    hVar.m(238);
                    hVar.cd(3);
                    return;
                case 4:
                    hVar.m(240);
                    hVar.cd(4);
                    return;
                case 5:
                    hVar.m(231);
                    hVar.cd(5);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Illegal mode: ");
                    stringBuilder.append(c);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        } else if (j.n(currentChar)) {
            hVar.m(235);
            hVar.m((char) ((currentChar - 128) + 1));
            hVar.pos++;
        } else {
            hVar.m((char) (currentChar + 1));
            hVar.pos++;
        }
    }

    private static char a(char c, char c2) {
        if (j.isDigit(c) && j.isDigit(c2)) {
            return (char) ((((c - 48) * 10) + (c2 - 48)) + 130);
        }
        StringBuilder stringBuilder = new StringBuilder("not digits: ");
        stringBuilder.append(c);
        stringBuilder.append(c2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
