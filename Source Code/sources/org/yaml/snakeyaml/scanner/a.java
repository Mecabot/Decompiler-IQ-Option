package org.yaml.snakeyaml.scanner;

import java.util.Arrays;

/* compiled from: Constant */
public final class a {
    public static final a fjQ = new a("\n  ");
    public static final a fjR = new a("\r\n  ");
    public static final a fjS = new a("\u0000\r\n  ");
    public static final a fjT = new a(" \u0000\r\n  ");
    public static final a fjU = new a("\t \u0000\r\n  ");
    public static final a fjV = new a("\u0000 \t");
    public static final a fjW = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");
    public static final a fjX = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
    private String fjY;
    boolean[] fjZ = new boolean[128];
    boolean fka;

    private a(String str) {
        int i = 0;
        this.fka = false;
        Arrays.fill(this.fjZ, false);
        StringBuilder stringBuilder = new StringBuilder();
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 128) {
                this.fjZ[codePointAt] = true;
            } else {
                stringBuilder.appendCodePoint(codePointAt);
            }
            i++;
        }
        if (stringBuilder.length() > 0) {
            this.fka = true;
            this.fjY = stringBuilder.toString();
        }
    }

    public boolean nu(int i) {
        if (i < 128) {
            return this.fjZ[i];
        }
        return this.fka && this.fjY.indexOf(i, 0) != -1;
    }

    public boolean nv(int i) {
        return nu(i) ^ 1;
    }

    public boolean p(int i, String str) {
        return nu(i) || str.indexOf(i, 0) != -1;
    }

    public boolean q(int i, String str) {
        return p(i, str) ^ 1;
    }
}
