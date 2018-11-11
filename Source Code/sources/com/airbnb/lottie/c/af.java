package com.airbnb.lottie.c;

/* compiled from: ShapeFillParser */
class af {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    static com.airbnb.lottie.model.content.i w(android.util.JsonReader r11, com.airbnb.lottie.g r12) {
        /*
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r4 = r2;
        r7 = r4;
        r8 = r7;
        r2 = 1;
        r5 = 0;
    L_0x0008:
        r3 = r11.hasNext();
        if (r3 == 0) goto L_0x0084;
    L_0x000e:
        r3 = r11.nextName();
        r6 = -1;
        r9 = r3.hashCode();
        r10 = -396065730; // 0xffffffffe864843e float:-4.316556E24 double:NaN;
        if (r9 == r10) goto L_0x0055;
    L_0x001c:
        r10 = 99;
        if (r9 == r10) goto L_0x004b;
    L_0x0020:
        r10 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        if (r9 == r10) goto L_0x0041;
    L_0x0024:
        r10 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r9 == r10) goto L_0x0037;
    L_0x0028:
        r10 = 3519; // 0xdbf float:4.931E-42 double:1.7386E-320;
        if (r9 == r10) goto L_0x002d;
    L_0x002c:
        goto L_0x005f;
    L_0x002d:
        r9 = "nm";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x005f;
    L_0x0035:
        r3 = 0;
        goto L_0x0060;
    L_0x0037:
        r9 = "r";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x005f;
    L_0x003f:
        r3 = 4;
        goto L_0x0060;
    L_0x0041:
        r9 = "o";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x005f;
    L_0x0049:
        r3 = 2;
        goto L_0x0060;
    L_0x004b:
        r9 = "c";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x005f;
    L_0x0053:
        r3 = 1;
        goto L_0x0060;
    L_0x0055:
        r9 = "fillEnabled";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x005f;
    L_0x005d:
        r3 = 3;
        goto L_0x0060;
    L_0x005f:
        r3 = -1;
    L_0x0060:
        switch(r3) {
            case 0: goto L_0x007e;
            case 1: goto L_0x0078;
            case 2: goto L_0x0072;
            case 3: goto L_0x006c;
            case 4: goto L_0x0067;
            default: goto L_0x0063;
        };
    L_0x0063:
        r11.skipValue();
        goto L_0x0008;
    L_0x0067:
        r2 = r11.nextInt();
        goto L_0x0008;
    L_0x006c:
        r3 = r11.nextBoolean();
        r5 = r3;
        goto L_0x0008;
    L_0x0072:
        r3 = com.airbnb.lottie.c.d.g(r11, r12);
        r8 = r3;
        goto L_0x0008;
    L_0x0078:
        r3 = com.airbnb.lottie.c.d.l(r11, r12);
        r7 = r3;
        goto L_0x0008;
    L_0x007e:
        r3 = r11.nextString();
        r4 = r3;
        goto L_0x0008;
    L_0x0084:
        if (r2 != r1) goto L_0x008a;
    L_0x0086:
        r11 = android.graphics.Path.FillType.WINDING;
    L_0x0088:
        r6 = r11;
        goto L_0x008d;
    L_0x008a:
        r11 = android.graphics.Path.FillType.EVEN_ODD;
        goto L_0x0088;
    L_0x008d:
        r11 = new com.airbnb.lottie.model.content.i;
        r3 = r11;
        r3.<init>(r4, r5, r6, r7, r8);
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.af.w(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.model.content.i");
    }
}
