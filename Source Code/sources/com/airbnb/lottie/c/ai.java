package com.airbnb.lottie.c;

/* compiled from: ShapeStrokeParser */
class ai {
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    static com.airbnb.lottie.model.content.ShapeStroke z(android.util.JsonReader r17, com.airbnb.lottie.g r18) {
        /*
        r3 = new java.util.ArrayList;
        r3.<init>();
        r1 = 0;
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
    L_0x000c:
        r9 = r17.hasNext();
        if (r9 == 0) goto L_0x014e;
    L_0x0012:
        r9 = r17.nextName();
        r10 = r9.hashCode();
        r12 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r14 = 0;
        r15 = 1;
        if (r10 == r12) goto L_0x0070;
    L_0x0020:
        r0 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        if (r10 == r0) goto L_0x0066;
    L_0x0024:
        r0 = 3447; // 0xd77 float:4.83E-42 double:1.703E-320;
        if (r10 == r0) goto L_0x005c;
    L_0x0028:
        r0 = 3454; // 0xd7e float:4.84E-42 double:1.7065E-320;
        if (r10 == r0) goto L_0x0052;
    L_0x002c:
        r0 = 3519; // 0xdbf float:4.931E-42 double:1.7386E-320;
        if (r10 == r0) goto L_0x0048;
    L_0x0030:
        switch(r10) {
            case 99: goto L_0x003e;
            case 100: goto L_0x0034;
            default: goto L_0x0033;
        };
    L_0x0033:
        goto L_0x007a;
    L_0x0034:
        r0 = "d";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x003c:
        r0 = 6;
        goto L_0x007b;
    L_0x003e:
        r0 = "c";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x0046:
        r0 = 1;
        goto L_0x007b;
    L_0x0048:
        r0 = "nm";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x0050:
        r0 = 0;
        goto L_0x007b;
    L_0x0052:
        r0 = "lj";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x005a:
        r0 = 5;
        goto L_0x007b;
    L_0x005c:
        r0 = "lc";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x0064:
        r0 = 4;
        goto L_0x007b;
    L_0x0066:
        r0 = "w";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x006e:
        r0 = 2;
        goto L_0x007b;
    L_0x0070:
        r0 = "o";
        r0 = r9.equals(r0);
        if (r0 == 0) goto L_0x007a;
    L_0x0078:
        r0 = 3;
        goto L_0x007b;
    L_0x007a:
        r0 = -1;
    L_0x007b:
        switch(r0) {
            case 0: goto L_0x0148;
            case 1: goto L_0x0142;
            case 2: goto L_0x013c;
            case 3: goto L_0x0136;
            case 4: goto L_0x0129;
            case 5: goto L_0x011c;
            case 6: goto L_0x0082;
            default: goto L_0x007e;
        };
    L_0x007e:
        r17.skipValue();
        goto L_0x000c;
    L_0x0082:
        r17.beginArray();
    L_0x0085:
        r0 = r17.hasNext();
        if (r0 == 0) goto L_0x010a;
    L_0x008b:
        r17.beginObject();
        r0 = 0;
        r9 = 0;
    L_0x0090:
        r10 = r17.hasNext();
        if (r10 == 0) goto L_0x00cd;
    L_0x0096:
        r10 = r17.nextName();
        r11 = r10.hashCode();
        r13 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r11 == r13) goto L_0x00b1;
    L_0x00a2:
        r13 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        if (r11 == r13) goto L_0x00a7;
    L_0x00a6:
        goto L_0x00bb;
    L_0x00a7:
        r11 = "v";
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x00bb;
    L_0x00af:
        r10 = 1;
        goto L_0x00bc;
    L_0x00b1:
        r11 = "n";
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x00bb;
    L_0x00b9:
        r10 = 0;
        goto L_0x00bc;
    L_0x00bb:
        r10 = -1;
    L_0x00bc:
        switch(r10) {
            case 0: goto L_0x00c8;
            case 1: goto L_0x00c3;
            default: goto L_0x00bf;
        };
    L_0x00bf:
        r17.skipValue();
        goto L_0x0090;
    L_0x00c3:
        r9 = com.airbnb.lottie.c.d.f(r17, r18);
        goto L_0x0090;
    L_0x00c8:
        r0 = r17.nextString();
        goto L_0x0090;
    L_0x00cd:
        r17.endObject();
        r10 = r0.hashCode();
        r11 = 100;
        if (r10 == r11) goto L_0x00f3;
    L_0x00d8:
        r11 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r10 == r11) goto L_0x00e9;
    L_0x00dc:
        if (r10 == r12) goto L_0x00df;
    L_0x00de:
        goto L_0x00fd;
    L_0x00df:
        r10 = "o";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x00fd;
    L_0x00e7:
        r0 = 0;
        goto L_0x00fe;
    L_0x00e9:
        r10 = "g";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x00fd;
    L_0x00f1:
        r0 = 2;
        goto L_0x00fe;
    L_0x00f3:
        r10 = "d";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x00fd;
    L_0x00fb:
        r0 = 1;
        goto L_0x00fe;
    L_0x00fd:
        r0 = -1;
    L_0x00fe:
        switch(r0) {
            case 0: goto L_0x0107;
            case 1: goto L_0x0102;
            case 2: goto L_0x0102;
            default: goto L_0x0101;
        };
    L_0x0101:
        goto L_0x0085;
    L_0x0102:
        r3.add(r9);
        goto L_0x0085;
    L_0x0107:
        r2 = r9;
        goto L_0x0085;
    L_0x010a:
        r17.endArray();
        r0 = r3.size();
        if (r0 != r15) goto L_0x000c;
    L_0x0113:
        r0 = r3.get(r14);
        r3.add(r0);
        goto L_0x000c;
    L_0x011c:
        r0 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values();
        r8 = r17.nextInt();
        r8 = r8 - r15;
        r8 = r0[r8];
        goto L_0x000c;
    L_0x0129:
        r0 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values();
        r7 = r17.nextInt();
        r7 = r7 - r15;
        r7 = r0[r7];
        goto L_0x000c;
    L_0x0136:
        r5 = com.airbnb.lottie.c.d.g(r17, r18);
        goto L_0x000c;
    L_0x013c:
        r6 = com.airbnb.lottie.c.d.f(r17, r18);
        goto L_0x000c;
    L_0x0142:
        r4 = com.airbnb.lottie.c.d.l(r17, r18);
        goto L_0x000c;
    L_0x0148:
        r1 = r17.nextString();
        goto L_0x000c;
    L_0x014e:
        r9 = new com.airbnb.lottie.model.content.ShapeStroke;
        r0 = r9;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.ai.z(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.model.content.ShapeStroke");
    }
}
