package com.google.zxing.datamatrix.encoder;

import com.google.zxing.a;
import java.nio.charset.StandardCharsets;

/* compiled from: EncoderContext */
final class h {
    private final String abQ;
    private SymbolShapeHint abR;
    private a abS;
    private a abT;
    private final StringBuilder abU;
    private int abV;
    private k abW;
    private int abX;
    int pos;

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder stringBuilder = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            char c = (char) (bytes[i] & 255);
            if (c != '?' || str.charAt(i) == '?') {
                stringBuilder.append(c);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.abQ = stringBuilder.toString();
        this.abR = SymbolShapeHint.FORCE_NONE;
        this.abU = new StringBuilder(str.length());
        this.abV = -1;
    }

    public void a(SymbolShapeHint symbolShapeHint) {
        this.abR = symbolShapeHint;
    }

    public void a(a aVar, a aVar2) {
        this.abS = aVar;
        this.abT = aVar2;
    }

    public String getMessage() {
        return this.abQ;
    }

    public void cc(int i) {
        this.abX = i;
    }

    public char getCurrentChar() {
        return this.abQ.charAt(this.pos);
    }

    public StringBuilder yJ() {
        return this.abU;
    }

    public void dI(String str) {
        this.abU.append(str);
    }

    public void m(char c) {
        this.abU.append(c);
    }

    public int yK() {
        return this.abU.length();
    }

    public int yL() {
        return this.abV;
    }

    public void cd(int i) {
        this.abV = i;
    }

    public void yM() {
        this.abV = -1;
    }

    public boolean yN() {
        return this.pos < yO();
    }

    private int yO() {
        return this.abQ.length() - this.abX;
    }

    public int yP() {
        return yO() - this.pos;
    }

    public k yQ() {
        return this.abW;
    }

    public void yR() {
        ce(yK());
    }

    public void ce(int i) {
        if (this.abW == null || i > this.abW.yZ()) {
            this.abW = k.a(i, this.abR, this.abS, this.abT, true);
        }
    }

    public void yS() {
        this.abW = null;
    }
}
