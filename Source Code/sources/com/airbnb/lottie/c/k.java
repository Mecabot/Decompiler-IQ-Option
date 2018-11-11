package com.airbnb.lottie.c;

/* compiled from: FontCharacterParser */
class k {
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081  */
    static com.airbnb.lottie.model.d n(android.util.JsonReader r13, com.airbnb.lottie.g r14) {
        /*
        r1 = new java.util.ArrayList;
        r1.<init>();
        r13.beginObject();
        r0 = 0;
        r2 = 0;
        r4 = 0;
        r9 = r0;
        r10 = r9;
        r5 = r2;
        r7 = r5;
        r2 = 0;
    L_0x0011:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x00d8;
    L_0x0017:
        r0 = r13.nextName();
        r3 = -1;
        r11 = r0.hashCode();
        r12 = -1866931350; // 0xffffffff90b8e36a float:-7.292559E-29 double:NaN;
        if (r11 == r12) goto L_0x006f;
    L_0x0025:
        r12 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        if (r11 == r12) goto L_0x0065;
    L_0x0029:
        r12 = 3173; // 0xc65 float:4.446E-42 double:1.5677E-320;
        if (r11 == r12) goto L_0x005b;
    L_0x002d:
        r12 = 3076010; // 0x2eefaa float:4.310408E-39 double:1.519751E-317;
        if (r11 == r12) goto L_0x0051;
    L_0x0032:
        r12 = 3530753; // 0x35e001 float:4.947639E-39 double:1.744424E-317;
        if (r11 == r12) goto L_0x0047;
    L_0x0037:
        r12 = 109780401; // 0x68b1db1 float:5.2329616E-35 double:5.42387247E-316;
        if (r11 == r12) goto L_0x003d;
    L_0x003c:
        goto L_0x0079;
    L_0x003d:
        r11 = "style";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x0079;
    L_0x0045:
        r0 = 3;
        goto L_0x007a;
    L_0x0047:
        r11 = "size";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x0079;
    L_0x004f:
        r0 = 1;
        goto L_0x007a;
    L_0x0051:
        r11 = "data";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x0079;
    L_0x0059:
        r0 = 5;
        goto L_0x007a;
    L_0x005b:
        r11 = "ch";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x0079;
    L_0x0063:
        r0 = 0;
        goto L_0x007a;
    L_0x0065:
        r11 = "w";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x0079;
    L_0x006d:
        r0 = 2;
        goto L_0x007a;
    L_0x006f:
        r11 = "fFamily";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x0079;
    L_0x0077:
        r0 = 4;
        goto L_0x007a;
    L_0x0079:
        r0 = -1;
    L_0x007a:
        switch(r0) {
            case 0: goto L_0x00ce;
            case 1: goto L_0x00c8;
            case 2: goto L_0x00c2;
            case 3: goto L_0x00bc;
            case 4: goto L_0x00b6;
            case 5: goto L_0x0081;
            default: goto L_0x007d;
        };
    L_0x007d:
        r13.skipValue();
        goto L_0x0011;
    L_0x0081:
        r13.beginObject();
    L_0x0084:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x00b1;
    L_0x008a:
        r0 = "shapes";
        r3 = r13.nextName();
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00ad;
    L_0x0096:
        r13.beginArray();
    L_0x0099:
        r0 = r13.hasNext();
        if (r0 == 0) goto L_0x00a9;
    L_0x009f:
        r0 = com.airbnb.lottie.c.h.m(r13, r14);
        r0 = (com.airbnb.lottie.model.content.j) r0;
        r1.add(r0);
        goto L_0x0099;
    L_0x00a9:
        r13.endArray();
        goto L_0x0084;
    L_0x00ad:
        r13.skipValue();
        goto L_0x0084;
    L_0x00b1:
        r13.endObject();
        goto L_0x0011;
    L_0x00b6:
        r10 = r13.nextString();
        goto L_0x0011;
    L_0x00bc:
        r9 = r13.nextString();
        goto L_0x0011;
    L_0x00c2:
        r7 = r13.nextDouble();
        goto L_0x0011;
    L_0x00c8:
        r5 = r13.nextDouble();
        goto L_0x0011;
    L_0x00ce:
        r0 = r13.nextString();
        r2 = r0.charAt(r4);
        goto L_0x0011;
    L_0x00d8:
        r13.endObject();
        r13 = new com.airbnb.lottie.model.d;
        r0 = r13;
        r3 = r5;
        r5 = r7;
        r7 = r9;
        r8 = r10;
        r0.<init>(r1, r2, r3, r5, r7, r8);
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.k.n(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.model.d");
    }
}
