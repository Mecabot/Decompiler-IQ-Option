package com.airbnb.lottie.c;

/* compiled from: MaskParser */
class v {
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Missing block: B:33:0x007b, code:
            if (r0.equals(com.facebook.i.TAG) != false) goto L_0x0089;
     */
    static com.airbnb.lottie.model.content.Mask r(android.util.JsonReader r10, com.airbnb.lottie.g r11) {
        /*
        r10.beginObject();
        r0 = 0;
        r1 = r0;
        r2 = r1;
    L_0x0006:
        r3 = r10.hasNext();
        if (r3 == 0) goto L_0x00b7;
    L_0x000c:
        r3 = r10.nextName();
        r4 = r3.hashCode();
        r5 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r6 = 2;
        r7 = 1;
        r8 = 0;
        r9 = -1;
        if (r4 == r5) goto L_0x003a;
    L_0x001c:
        r5 = 3588; // 0xe04 float:5.028E-42 double:1.7727E-320;
        if (r4 == r5) goto L_0x0030;
    L_0x0020:
        r5 = 3357091; // 0x3339a3 float:4.704286E-39 double:1.6586233E-317;
        if (r4 == r5) goto L_0x0026;
    L_0x0025:
        goto L_0x0044;
    L_0x0026:
        r4 = "mode";
        r4 = r3.equals(r4);
        if (r4 == 0) goto L_0x0044;
    L_0x002e:
        r4 = 0;
        goto L_0x0045;
    L_0x0030:
        r4 = "pt";
        r4 = r3.equals(r4);
        if (r4 == 0) goto L_0x0044;
    L_0x0038:
        r4 = 1;
        goto L_0x0045;
    L_0x003a:
        r4 = "o";
        r4 = r3.equals(r4);
        if (r4 == 0) goto L_0x0044;
    L_0x0042:
        r4 = 2;
        goto L_0x0045;
    L_0x0044:
        r4 = -1;
    L_0x0045:
        switch(r4) {
            case 0: goto L_0x0056;
            case 1: goto L_0x0051;
            case 2: goto L_0x004c;
            default: goto L_0x0048;
        };
    L_0x0048:
        r10.skipValue();
        goto L_0x0006;
    L_0x004c:
        r2 = com.airbnb.lottie.c.d.g(r10, r11);
        goto L_0x0006;
    L_0x0051:
        r1 = com.airbnb.lottie.c.d.j(r10, r11);
        goto L_0x0006;
    L_0x0056:
        r0 = r10.nextString();
        r4 = r0.hashCode();
        r5 = 97;
        if (r4 == r5) goto L_0x007e;
    L_0x0062:
        r5 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        if (r4 == r5) goto L_0x0075;
    L_0x0066:
        r5 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        if (r4 == r5) goto L_0x006b;
    L_0x006a:
        goto L_0x0088;
    L_0x006b:
        r4 = "s";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0088;
    L_0x0073:
        r6 = 1;
        goto L_0x0089;
    L_0x0075:
        r4 = "i";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0088;
    L_0x007d:
        goto L_0x0089;
    L_0x007e:
        r4 = "a";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0088;
    L_0x0086:
        r6 = 0;
        goto L_0x0089;
    L_0x0088:
        r6 = -1;
    L_0x0089:
        switch(r6) {
            case 0: goto L_0x00b3;
            case 1: goto L_0x00af;
            case 2: goto L_0x00ab;
            default: goto L_0x008c;
        };
    L_0x008c:
        r0 = "LOTTIE";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Unknown mask mode ";
        r4.append(r5);
        r4.append(r3);
        r3 = ". Defaulting to Add.";
        r4.append(r3);
        r3 = r4.toString();
        android.util.Log.w(r0, r3);
        r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd;
        goto L_0x0006;
    L_0x00ab:
        r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeIntersect;
        goto L_0x0006;
    L_0x00af:
        r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeSubtract;
        goto L_0x0006;
    L_0x00b3:
        r0 = com.airbnb.lottie.model.content.Mask.MaskMode.MaskModeAdd;
        goto L_0x0006;
    L_0x00b7:
        r10.endObject();
        r10 = new com.airbnb.lottie.model.content.Mask;
        r10.<init>(r0, r1, r2);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.v.r(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.model.content.Mask");
    }
}
