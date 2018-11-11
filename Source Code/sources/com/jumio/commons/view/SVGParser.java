package com.jumio.commons.view;

import android.graphics.Path;

public class SVGParser {
    private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x018e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x018e A:{SYNTHETIC} */
    public static android.graphics.Path createPathFromSvgString(java.lang.String r24) {
        /*
        r0 = r24;
        r1 = r24.length();
        r2 = new com.jumio.commons.view.SVGParserHelper;
        r3 = 0;
        r2.<init>(r0, r3);
        r2.skipWhitespace();
        r14 = new android.graphics.Path;
        r14.<init>();
        r15 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r12 = 0;
        r13 = 0;
        r16 = 0;
        r17 = 0;
    L_0x001e:
        r7 = r2.pos;
        if (r7 >= r1) goto L_0x0195;
    L_0x0022:
        r7 = r2.pos;
        r7 = r0.charAt(r7);
        r8 = 43;
        r9 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r10 = 99;
        r11 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        if (r7 == r8) goto L_0x003a;
    L_0x0032:
        r8 = 45;
        if (r7 == r8) goto L_0x003a;
    L_0x0036:
        switch(r7) {
            case 48: goto L_0x003a;
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
        goto L_0x004f;
    L_0x003a:
        if (r4 == r11) goto L_0x0057;
    L_0x003c:
        r8 = 77;
        if (r4 != r8) goto L_0x0041;
    L_0x0040:
        goto L_0x0057;
    L_0x0041:
        if (r4 == r10) goto L_0x0055;
    L_0x0043:
        r8 = 67;
        if (r4 != r8) goto L_0x0048;
    L_0x0047:
        goto L_0x0055;
    L_0x0048:
        if (r4 == r9) goto L_0x0055;
    L_0x004a:
        r8 = 76;
        if (r4 != r8) goto L_0x004f;
    L_0x004e:
        goto L_0x0055;
    L_0x004f:
        r2.advance();
    L_0x0052:
        r18 = r7;
        goto L_0x005c;
    L_0x0055:
        r7 = r4;
        goto L_0x0052;
    L_0x0057:
        r7 = r4 + -1;
        r7 = (char) r7;
        r18 = r4;
    L_0x005c:
        r19 = 1;
        switch(r7) {
            case 65: goto L_0x014c;
            case 67: goto L_0x010d;
            case 72: goto L_0x00f9;
            case 76: goto L_0x00e1;
            case 77: goto L_0x00c7;
            case 83: goto L_0x0089;
            case 86: goto L_0x0077;
            case 90: goto L_0x0069;
            case 97: goto L_0x014c;
            case 99: goto L_0x010d;
            case 104: goto L_0x00f9;
            case 108: goto L_0x00e1;
            case 109: goto L_0x00c7;
            case 115: goto L_0x0089;
            case 118: goto L_0x0077;
            case 122: goto L_0x0069;
            default: goto L_0x0061;
        };
    L_0x0061:
        r23 = r12;
        r22 = r13;
    L_0x0065:
        r19 = 0;
        goto L_0x0188;
    L_0x0069:
        r14.close();
        r14.moveTo(r13, r12);
        r6 = r12;
        r17 = r6;
        r5 = r13;
        r16 = r5;
        goto L_0x0188;
    L_0x0077:
        r4 = r2.nextFloat();
        r8 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        if (r7 != r8) goto L_0x0084;
    L_0x007f:
        r14.rLineTo(r15, r4);
        r6 = r6 + r4;
        goto L_0x0065;
    L_0x0084:
        r14.lineTo(r5, r4);
        r6 = r4;
        goto L_0x0065;
    L_0x0089:
        r4 = r2.nextFloat();
        r8 = r2.nextFloat();
        r9 = r2.nextFloat();
        r10 = r2.nextFloat();
        r11 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r7 != r11) goto L_0x00a1;
    L_0x009d:
        r4 = r4 + r5;
        r9 = r9 + r5;
        r8 = r8 + r6;
        r10 = r10 + r6;
    L_0x00a1:
        r11 = r4;
        r20 = r8;
        r21 = r9;
        r22 = r10;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 * r4;
        r5 = r5 - r16;
        r6 = r6 * r4;
        r6 = r6 - r17;
        r4 = r14;
        r7 = r11;
        r8 = r20;
        r9 = r21;
        r10 = r22;
        r4.cubicTo(r5, r6, r7, r8, r9, r10);
        r16 = r11;
        r17 = r20;
        r5 = r21;
        r6 = r22;
        goto L_0x0188;
    L_0x00c7:
        r4 = r2.nextFloat();
        r8 = r2.nextFloat();
        if (r7 != r11) goto L_0x00d9;
    L_0x00d1:
        r13 = r13 + r4;
        r12 = r12 + r8;
        r14.rMoveTo(r4, r8);
        r5 = r5 + r4;
        r6 = r6 + r8;
        goto L_0x0065;
    L_0x00d9:
        r14.moveTo(r4, r8);
        r5 = r4;
        r13 = r5;
        r6 = r8;
        r12 = r6;
        goto L_0x0065;
    L_0x00e1:
        r4 = r2.nextFloat();
        r8 = r2.nextFloat();
        if (r7 != r9) goto L_0x00f2;
    L_0x00eb:
        r14.rLineTo(r4, r8);
        r5 = r5 + r4;
        r6 = r6 + r8;
        goto L_0x0065;
    L_0x00f2:
        r14.lineTo(r4, r8);
        r5 = r4;
        r6 = r8;
        goto L_0x0065;
    L_0x00f9:
        r4 = r2.nextFloat();
        r8 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r7 != r8) goto L_0x0107;
    L_0x0101:
        r14.rLineTo(r4, r15);
        r5 = r5 + r4;
        goto L_0x0065;
    L_0x0107:
        r14.lineTo(r4, r6);
        r5 = r4;
        goto L_0x0065;
    L_0x010d:
        r4 = r2.nextFloat();
        r8 = r2.nextFloat();
        r9 = r2.nextFloat();
        r11 = r2.nextFloat();
        r16 = r2.nextFloat();
        r17 = r2.nextFloat();
        if (r7 != r10) goto L_0x012f;
    L_0x0127:
        r4 = r4 + r5;
        r9 = r9 + r5;
        r16 = r16 + r5;
        r8 = r8 + r6;
        r11 = r11 + r6;
        r17 = r17 + r6;
    L_0x012f:
        r5 = r4;
        r6 = r8;
        r20 = r17;
        r17 = r16;
        r16 = r11;
        r11 = r9;
        r4 = r14;
        r7 = r11;
        r8 = r16;
        r9 = r17;
        r10 = r20;
        r4.cubicTo(r5, r6, r7, r8, r9, r10);
        r5 = r17;
        r6 = r20;
        r17 = r16;
        r16 = r11;
        goto L_0x0188;
    L_0x014c:
        r9 = r2.nextFloat();
        r10 = r2.nextFloat();
        r11 = r2.nextFloat();
        r4 = r2.nextFloat();
        r8 = (int) r4;
        r4 = r2.nextFloat();
        r7 = (int) r4;
        r19 = r2.nextFloat();
        r20 = r2.nextFloat();
        r4 = r14;
        r21 = r7;
        r7 = r19;
        r22 = r8;
        r8 = r20;
        r23 = r12;
        r12 = r22;
        r22 = r13;
        r13 = r21;
        drawArc(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        r5 = r19;
        r6 = r20;
        r13 = r22;
        r12 = r23;
        goto L_0x0065;
    L_0x0188:
        if (r19 != 0) goto L_0x018e;
    L_0x018a:
        r16 = r5;
        r17 = r6;
    L_0x018e:
        r2.skipWhitespace();
        r4 = r18;
        goto L_0x001e;
    L_0x0195:
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.view.SVGParser.createPathFromSvgString(java.lang.String):android.graphics.Path");
    }
}
