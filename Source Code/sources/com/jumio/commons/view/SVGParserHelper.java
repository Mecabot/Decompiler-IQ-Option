package com.jumio.commons.view;

class SVGParserHelper {
    private static final double[] pow10 = new double[128];
    private char current;
    private int n;
    public int pos;
    private CharSequence s;

    public SVGParserHelper(CharSequence charSequence, int i) {
        this.s = charSequence;
        this.pos = i;
        this.n = charSequence.length();
        this.current = charSequence.charAt(i);
    }

    private char read() {
        if (this.pos < this.n) {
            this.pos++;
        }
        if (this.pos == this.n) {
            return 0;
        }
        return this.s.charAt(this.pos);
    }

    public void skipWhitespace() {
        while (this.pos < this.n && Character.isWhitespace(this.s.charAt(this.pos))) {
            advance();
        }
    }

    public void skipNumberSeparator() {
        while (this.pos < this.n) {
            char charAt = this.s.charAt(this.pos);
            if (!(charAt == ' ' || charAt == ',')) {
                switch (charAt) {
                    case 9:
                    case 10:
                        break;
                    default:
                        return;
                }
            }
            advance();
        }
    }

    public void advance() {
        this.current = read();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079 A:{LOOP_START, PHI: r12 } */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0100  */
    /* JADX WARNING: Missing block: B:11:0x0028, code:
            r15.current = read();
            r5 = r15.current;
     */
    /* JADX WARNING: Missing block: B:12:0x0030, code:
            if (r5 == '.') goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code:
            if (r5 == 'E') goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:14:0x0034, code:
            if (r5 == 'e') goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:15:0x0036, code:
            switch(r5) {
                case 48: goto L_0x0028;
                case 49: goto L_0x003a;
                case 50: goto L_0x003a;
                case 51: goto L_0x003a;
                case 52: goto L_0x003a;
                case 53: goto L_0x003a;
                case 54: goto L_0x003a;
                case 55: goto L_0x003a;
                case 56: goto L_0x003a;
                case 57: goto L_0x003a;
                default: goto L_0x0039;
            };
     */
    /* JADX WARNING: Missing block: B:16:0x0039, code:
            return 0.0f;
     */
    /* JADX WARNING: Missing block: B:17:0x003a, code:
            r5 = 0;
            r11 = 0;
            r12 = 0;
     */
    /* JADX WARNING: Missing block: B:18:0x003d, code:
            if (r5 >= 9) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:19:0x003f, code:
            r5 = r5 + 1;
            r11 = (r11 * 10) + (r15.current - 48);
     */
    /* JADX WARNING: Missing block: B:20:0x0049, code:
            r12 = r12 + 1;
     */
    /* JADX WARNING: Missing block: B:21:0x004b, code:
            r15.current = read();
     */
    /* JADX WARNING: Missing block: B:22:0x0053, code:
            switch(r15.current) {
                case 48: goto L_0x003d;
                case 49: goto L_0x003d;
                case 50: goto L_0x003d;
                case 51: goto L_0x003d;
                case 52: goto L_0x003d;
                case 53: goto L_0x003d;
                case 54: goto L_0x003d;
                case 55: goto L_0x003d;
                case 56: goto L_0x003d;
                case 57: goto L_0x003d;
                default: goto L_0x0056;
            };
     */
    /* JADX WARNING: Missing block: B:23:0x0056, code:
            r13 = r11;
            r11 = r5;
            r5 = 1;
     */
    /* JADX WARNING: Missing block: B:24:0x005a, code:
            r5 = 1;
     */
    /* JADX WARNING: Missing block: B:26:0x005d, code:
            r11 = 0;
            r12 = 0;
            r13 = 0;
     */
    /* JADX WARNING: Missing block: B:41:0x0096, code:
            r15.current = read();
     */
    /* JADX WARNING: Missing block: B:59:0x00d5, code:
            r15.current = read();
     */
    /* JADX WARNING: Missing block: B:60:0x00dd, code:
            switch(r15.current) {
                case 48: goto L_0x00d5;
                case 49: goto L_0x00e1;
                case 50: goto L_0x00e1;
                case 51: goto L_0x00e1;
                case 52: goto L_0x00e1;
                case 53: goto L_0x00e1;
                case 54: goto L_0x00e1;
                case 55: goto L_0x00e1;
                case 56: goto L_0x00e1;
                case 57: goto L_0x00e1;
                default: goto L_0x00e0;
            };
     */
    /* JADX WARNING: Missing block: B:61:0x00e1, code:
            r1 = 0;
     */
    /* JADX WARNING: Missing block: B:63:0x00e3, code:
            if (r4 >= 3) goto L_0x00ee;
     */
    /* JADX WARNING: Missing block: B:64:0x00e5, code:
            r4 = r4 + 1;
            r1 = (r1 * 10) + (r15.current - 48);
     */
    /* JADX WARNING: Missing block: B:65:0x00ee, code:
            r15.current = read();
     */
    /* JADX WARNING: Missing block: B:66:0x00f6, code:
            switch(r15.current) {
                case 48: goto L_0x00e2;
                case 49: goto L_0x00e2;
                case 50: goto L_0x00e2;
                case 51: goto L_0x00e2;
                case 52: goto L_0x00e2;
                case 53: goto L_0x00e2;
                case 54: goto L_0x00e2;
                case 55: goto L_0x00e2;
                case 56: goto L_0x00e2;
                case 57: goto L_0x00e2;
                default: goto L_0x00f9;
            };
     */
    /* JADX WARNING: Missing block: B:67:0x00f9, code:
            r4 = r1;
     */
    public float parseFloat() {
        /*
        r15 = this;
        r0 = r15.current;
        r1 = 45;
        r2 = 43;
        r3 = 1;
        r4 = 0;
        if (r0 == r2) goto L_0x0010;
    L_0x000a:
        if (r0 == r1) goto L_0x000e;
    L_0x000c:
        r0 = 1;
        goto L_0x0017;
    L_0x000e:
        r0 = 0;
        goto L_0x0011;
    L_0x0010:
        r0 = 1;
    L_0x0011:
        r5 = r15.read();
        r15.current = r5;
    L_0x0017:
        r5 = r15.current;
        r6 = 9;
        r7 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r8 = 69;
        r9 = 46;
        r10 = 0;
        switch(r5) {
            case 46: goto L_0x005c;
            case 47: goto L_0x0025;
            case 48: goto L_0x0028;
            case 49: goto L_0x003a;
            case 50: goto L_0x003a;
            case 51: goto L_0x003a;
            case 52: goto L_0x003a;
            case 53: goto L_0x003a;
            case 54: goto L_0x003a;
            case 55: goto L_0x003a;
            case 56: goto L_0x003a;
            case 57: goto L_0x003a;
            default: goto L_0x0025;
        };
    L_0x0025:
        r0 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        return r0;
    L_0x0028:
        r5 = r15.read();
        r15.current = r5;
        r5 = r15.current;
        if (r5 == r9) goto L_0x005a;
    L_0x0032:
        if (r5 == r8) goto L_0x005a;
    L_0x0034:
        if (r5 == r7) goto L_0x005a;
    L_0x0036:
        switch(r5) {
            case 48: goto L_0x0028;
            case 49: goto L_0x003a;
            case 50: goto L_0x003a;
            case 51: goto L_0x003a;
            case 52: goto L_0x003a;
            case 53: goto L_0x003a;
            case 54: goto L_0x003a;
            case 55: goto L_0x003a;
            case 56: goto L_0x003a;
            case 57: goto L_0x003a;
            default: goto L_0x0039;
        };
    L_0x0039:
        return r10;
    L_0x003a:
        r5 = 0;
        r11 = 0;
        r12 = 0;
    L_0x003d:
        if (r5 >= r6) goto L_0x0049;
    L_0x003f:
        r5 = r5 + 1;
        r11 = r11 * 10;
        r13 = r15.current;
        r13 = r13 + -48;
        r11 = r11 + r13;
        goto L_0x004b;
    L_0x0049:
        r12 = r12 + 1;
    L_0x004b:
        r13 = r15.read();
        r15.current = r13;
        r13 = r15.current;
        switch(r13) {
            case 48: goto L_0x003d;
            case 49: goto L_0x003d;
            case 50: goto L_0x003d;
            case 51: goto L_0x003d;
            case 52: goto L_0x003d;
            case 53: goto L_0x003d;
            case 54: goto L_0x003d;
            case 55: goto L_0x003d;
            case 56: goto L_0x003d;
            case 57: goto L_0x003d;
            default: goto L_0x0056;
        };
    L_0x0056:
        r13 = r11;
        r11 = r5;
        r5 = 1;
        goto L_0x0060;
    L_0x005a:
        r5 = 1;
        goto L_0x005d;
    L_0x005c:
        r5 = 0;
    L_0x005d:
        r11 = 0;
        r12 = 0;
        r13 = 0;
    L_0x0060:
        r14 = r15.current;
        if (r14 != r9) goto L_0x00a1;
    L_0x0064:
        r9 = r15.read();
        r15.current = r9;
        r9 = r15.current;
        switch(r9) {
            case 48: goto L_0x0077;
            case 49: goto L_0x0089;
            case 50: goto L_0x0089;
            case 51: goto L_0x0089;
            case 52: goto L_0x0089;
            case 53: goto L_0x0089;
            case 54: goto L_0x0089;
            case 55: goto L_0x0089;
            case 56: goto L_0x0089;
            case 57: goto L_0x0089;
            default: goto L_0x006f;
        };
    L_0x006f:
        if (r5 != 0) goto L_0x00a1;
    L_0x0071:
        r0 = r15.current;
        r15.reportUnexpectedCharacterError(r0);
        return r10;
    L_0x0077:
        if (r11 != 0) goto L_0x0089;
    L_0x0079:
        r9 = r15.read();
        r15.current = r9;
        r12 = r12 + -1;
        r9 = r15.current;
        switch(r9) {
            case 48: goto L_0x0079;
            case 49: goto L_0x0089;
            case 50: goto L_0x0089;
            case 51: goto L_0x0089;
            case 52: goto L_0x0089;
            case 53: goto L_0x0089;
            case 54: goto L_0x0089;
            case 55: goto L_0x0089;
            case 56: goto L_0x0089;
            case 57: goto L_0x0089;
            default: goto L_0x0086;
        };
    L_0x0086:
        if (r5 != 0) goto L_0x00a1;
    L_0x0088:
        return r10;
    L_0x0089:
        if (r11 >= r6) goto L_0x0096;
    L_0x008b:
        r11 = r11 + 1;
        r13 = r13 * 10;
        r5 = r15.current;
        r5 = r5 + -48;
        r13 = r13 + r5;
        r12 = r12 + -1;
    L_0x0096:
        r5 = r15.read();
        r15.current = r5;
        r5 = r15.current;
        switch(r5) {
            case 48: goto L_0x0089;
            case 49: goto L_0x0089;
            case 50: goto L_0x0089;
            case 51: goto L_0x0089;
            case 52: goto L_0x0089;
            case 53: goto L_0x0089;
            case 54: goto L_0x0089;
            case 55: goto L_0x0089;
            case 56: goto L_0x0089;
            case 57: goto L_0x0089;
            default: goto L_0x00a1;
        };
    L_0x00a1:
        r5 = r15.current;
        if (r5 == r8) goto L_0x00a8;
    L_0x00a5:
        if (r5 == r7) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00fa;
    L_0x00a8:
        r5 = r15.read();
        r15.current = r5;
        r5 = r15.current;
        if (r5 == r2) goto L_0x00be;
    L_0x00b2:
        if (r5 == r1) goto L_0x00bd;
    L_0x00b4:
        switch(r5) {
            case 48: goto L_0x00cf;
            case 49: goto L_0x00cf;
            case 50: goto L_0x00cf;
            case 51: goto L_0x00cf;
            case 52: goto L_0x00cf;
            case 53: goto L_0x00cf;
            case 54: goto L_0x00cf;
            case 55: goto L_0x00cf;
            case 56: goto L_0x00cf;
            case 57: goto L_0x00cf;
            default: goto L_0x00b7;
        };
    L_0x00b7:
        r0 = r15.current;
        r15.reportUnexpectedCharacterError(r0);
        return r10;
    L_0x00bd:
        r3 = 0;
    L_0x00be:
        r1 = r15.read();
        r15.current = r1;
        r1 = r15.current;
        switch(r1) {
            case 48: goto L_0x00cf;
            case 49: goto L_0x00cf;
            case 50: goto L_0x00cf;
            case 51: goto L_0x00cf;
            case 52: goto L_0x00cf;
            case 53: goto L_0x00cf;
            case 54: goto L_0x00cf;
            case 55: goto L_0x00cf;
            case 56: goto L_0x00cf;
            case 57: goto L_0x00cf;
            default: goto L_0x00c9;
        };
    L_0x00c9:
        r0 = r15.current;
        r15.reportUnexpectedCharacterError(r0);
        return r10;
    L_0x00cf:
        r1 = r15.current;
        switch(r1) {
            case 48: goto L_0x00d5;
            case 49: goto L_0x00e1;
            case 50: goto L_0x00e1;
            case 51: goto L_0x00e1;
            case 52: goto L_0x00e1;
            case 53: goto L_0x00e1;
            case 54: goto L_0x00e1;
            case 55: goto L_0x00e1;
            case 56: goto L_0x00e1;
            case 57: goto L_0x00e1;
            default: goto L_0x00d4;
        };
    L_0x00d4:
        goto L_0x00fa;
    L_0x00d5:
        r1 = r15.read();
        r15.current = r1;
        r1 = r15.current;
        switch(r1) {
            case 48: goto L_0x00d5;
            case 49: goto L_0x00e1;
            case 50: goto L_0x00e1;
            case 51: goto L_0x00e1;
            case 52: goto L_0x00e1;
            case 53: goto L_0x00e1;
            case 54: goto L_0x00e1;
            case 55: goto L_0x00e1;
            case 56: goto L_0x00e1;
            case 57: goto L_0x00e1;
            default: goto L_0x00e0;
        };
    L_0x00e0:
        goto L_0x00fa;
    L_0x00e1:
        r1 = 0;
    L_0x00e2:
        r2 = 3;
        if (r4 >= r2) goto L_0x00ee;
    L_0x00e5:
        r4 = r4 + 1;
        r1 = r1 * 10;
        r2 = r15.current;
        r2 = r2 + -48;
        r1 = r1 + r2;
    L_0x00ee:
        r2 = r15.read();
        r15.current = r2;
        r2 = r15.current;
        switch(r2) {
            case 48: goto L_0x00e2;
            case 49: goto L_0x00e2;
            case 50: goto L_0x00e2;
            case 51: goto L_0x00e2;
            case 52: goto L_0x00e2;
            case 53: goto L_0x00e2;
            case 54: goto L_0x00e2;
            case 55: goto L_0x00e2;
            case 56: goto L_0x00e2;
            case 57: goto L_0x00e2;
            default: goto L_0x00f9;
        };
    L_0x00f9:
        r4 = r1;
    L_0x00fa:
        if (r3 != 0) goto L_0x00fd;
    L_0x00fc:
        r4 = -r4;
    L_0x00fd:
        r4 = r4 + r12;
        if (r0 != 0) goto L_0x0101;
    L_0x0100:
        r13 = -r13;
    L_0x0101:
        r0 = buildFloat(r13, r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.view.SVGParserHelper.parseFloat():float");
    }

    private void reportUnexpectedCharacterError(char c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected char '");
        stringBuilder.append(c);
        stringBuilder.append("'.");
        throw new RuntimeException(stringBuilder.toString());
    }

    public static float buildFloat(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        } else if (i2 == 0) {
            return (float) i;
        } else {
            if (i >= 67108864) {
                i++;
            }
            return (float) (i2 > 0 ? ((double) i) * pow10[i2] : ((double) i) / pow10[-i2]);
        }
    }

    static {
        for (int i = 0; i < pow10.length; i++) {
            pow10[i] = Math.pow(10.0d, (double) i);
        }
    }

    public float nextFloat() {
        skipWhitespace();
        float parseFloat = parseFloat();
        skipNumberSeparator();
        return parseFloat;
    }
}
