package com.airbnb.lottie.c;

/* compiled from: ContentModelParser */
class h {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0041 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0041 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Missing block: B:48:0x00b1, code:
            if (r2.equals("gs") != false) goto L_0x00dd;
     */
    @android.support.annotation.Nullable
    static com.airbnb.lottie.model.content.b m(android.util.JsonReader r9, com.airbnb.lottie.g r10) {
        /*
        r9.beginObject();
        r0 = 2;
        r1 = 2;
    L_0x0005:
        r2 = r9.hasNext();
        r3 = 1;
        r4 = 0;
        r5 = -1;
        r6 = 0;
        if (r2 == 0) goto L_0x0046;
    L_0x000f:
        r2 = r9.nextName();
        r7 = r2.hashCode();
        r8 = 100;
        if (r7 == r8) goto L_0x002a;
    L_0x001b:
        r8 = 3717; // 0xe85 float:5.209E-42 double:1.8364E-320;
        if (r7 == r8) goto L_0x0020;
    L_0x001f:
        goto L_0x0034;
    L_0x0020:
        r7 = "ty";
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x0034;
    L_0x0028:
        r2 = 0;
        goto L_0x0035;
    L_0x002a:
        r7 = "d";
        r2 = r2.equals(r7);
        if (r2 == 0) goto L_0x0034;
    L_0x0032:
        r2 = 1;
        goto L_0x0035;
    L_0x0034:
        r2 = -1;
    L_0x0035:
        switch(r2) {
            case 0: goto L_0x0041;
            case 1: goto L_0x003c;
            default: goto L_0x0038;
        };
    L_0x0038:
        r9.skipValue();
        goto L_0x0005;
    L_0x003c:
        r1 = r9.nextInt();
        goto L_0x0005;
    L_0x0041:
        r2 = r9.nextString();
        goto L_0x0047;
    L_0x0046:
        r2 = r6;
    L_0x0047:
        if (r2 != 0) goto L_0x004a;
    L_0x0049:
        return r6;
    L_0x004a:
        r7 = r2.hashCode();
        switch(r7) {
            case 3239: goto L_0x00d2;
            case 3270: goto L_0x00c8;
            case 3295: goto L_0x00be;
            case 3307: goto L_0x00b4;
            case 3308: goto L_0x00ab;
            case 3488: goto L_0x00a0;
            case 3633: goto L_0x0095;
            case 3646: goto L_0x008a;
            case 3669: goto L_0x0080;
            case 3679: goto L_0x0075;
            case 3681: goto L_0x006a;
            case 3705: goto L_0x005e;
            case 3710: goto L_0x0053;
            default: goto L_0x0051;
        };
    L_0x0051:
        goto L_0x00dc;
    L_0x0053:
        r0 = "tr";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x005b:
        r0 = 5;
        goto L_0x00dd;
    L_0x005e:
        r0 = "tm";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x0066:
        r0 = 9;
        goto L_0x00dd;
    L_0x006a:
        r0 = "st";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x0072:
        r0 = 1;
        goto L_0x00dd;
    L_0x0075:
        r0 = "sr";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x007d:
        r0 = 10;
        goto L_0x00dd;
    L_0x0080:
        r0 = "sh";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x0088:
        r0 = 6;
        goto L_0x00dd;
    L_0x008a:
        r0 = "rp";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x0092:
        r0 = 12;
        goto L_0x00dd;
    L_0x0095:
        r0 = "rc";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x009d:
        r0 = 8;
        goto L_0x00dd;
    L_0x00a0:
        r0 = "mm";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00a8:
        r0 = 11;
        goto L_0x00dd;
    L_0x00ab:
        r3 = "gs";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x00dc;
    L_0x00b3:
        goto L_0x00dd;
    L_0x00b4:
        r0 = "gr";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00bc:
        r0 = 0;
        goto L_0x00dd;
    L_0x00be:
        r0 = "gf";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00c6:
        r0 = 4;
        goto L_0x00dd;
    L_0x00c8:
        r0 = "fl";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00d0:
        r0 = 3;
        goto L_0x00dd;
    L_0x00d2:
        r0 = "el";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x00dc;
    L_0x00da:
        r0 = 7;
        goto L_0x00dd;
    L_0x00dc:
        r0 = -1;
    L_0x00dd:
        switch(r0) {
            case 0: goto L_0x0138;
            case 1: goto L_0x0133;
            case 2: goto L_0x012e;
            case 3: goto L_0x0129;
            case 4: goto L_0x0124;
            case 5: goto L_0x011f;
            case 6: goto L_0x011a;
            case 7: goto L_0x0115;
            case 8: goto L_0x0110;
            case 9: goto L_0x010b;
            case 10: goto L_0x0106;
            case 11: goto L_0x00fc;
            case 12: goto L_0x00f7;
            default: goto L_0x00e0;
        };
    L_0x00e0:
        r10 = "LOTTIE";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Unknown shape type ";
        r0.append(r1);
        r0.append(r2);
        r0 = r0.toString();
        android.util.Log.w(r10, r0);
        goto L_0x013c;
    L_0x00f7:
        r6 = com.airbnb.lottie.c.ac.v(r9, r10);
        goto L_0x013c;
    L_0x00fc:
        r6 = com.airbnb.lottie.c.w.f(r9);
        r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().";
        r10.Y(r0);
        goto L_0x013c;
    L_0x0106:
        r6 = com.airbnb.lottie.c.aa.t(r9, r10);
        goto L_0x013c;
    L_0x010b:
        r6 = com.airbnb.lottie.c.aj.A(r9, r10);
        goto L_0x013c;
    L_0x0110:
        r6 = com.airbnb.lottie.c.ab.u(r9, r10);
        goto L_0x013c;
    L_0x0115:
        r6 = com.airbnb.lottie.c.f.b(r9, r10, r1);
        goto L_0x013c;
    L_0x011a:
        r6 = com.airbnb.lottie.c.ah.y(r9, r10);
        goto L_0x013c;
    L_0x011f:
        r6 = com.airbnb.lottie.c.c.e(r9, r10);
        goto L_0x013c;
    L_0x0124:
        r6 = com.airbnb.lottie.c.n.o(r9, r10);
        goto L_0x013c;
    L_0x0129:
        r6 = com.airbnb.lottie.c.af.w(r9, r10);
        goto L_0x013c;
    L_0x012e:
        r6 = com.airbnb.lottie.c.o.p(r9, r10);
        goto L_0x013c;
    L_0x0133:
        r6 = com.airbnb.lottie.c.ai.z(r9, r10);
        goto L_0x013c;
    L_0x0138:
        r6 = com.airbnb.lottie.c.ag.x(r9, r10);
    L_0x013c:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x0146;
    L_0x0142:
        r9.skipValue();
        goto L_0x013c;
    L_0x0146:
        r9.endObject();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.h.m(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.model.content.b");
    }
}
