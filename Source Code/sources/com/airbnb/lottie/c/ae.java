package com.airbnb.lottie.c;

import com.airbnb.lottie.model.content.h;

/* compiled from: ShapeDataParser */
public class ae implements ak<h> {
    public static final ae oC = new ae();

    private ae() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061  */
    /* renamed from: m */
    public com.airbnb.lottie.model.content.h b(android.util.JsonReader r13, float r14) {
        /*
        r12 = this;
        r0 = r13.peek();
        r1 = android.util.JsonToken.BEGIN_ARRAY;
        if (r0 != r1) goto L_0x000b;
    L_0x0008:
        r13.beginArray();
    L_0x000b:
        r13.beginObject();
        r0 = 0;
        r1 = 0;
        r2 = r0;
        r3 = r2;
        r4 = 0;
    L_0x0013:
        r5 = r13.hasNext();
        r6 = 1;
        if (r5 == 0) goto L_0x0075;
    L_0x001a:
        r5 = r13.nextName();
        r7 = -1;
        r8 = r5.hashCode();
        r9 = 99;
        if (r8 == r9) goto L_0x0052;
    L_0x0027:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        if (r8 == r9) goto L_0x0048;
    L_0x002b:
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        if (r8 == r9) goto L_0x003e;
    L_0x002f:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        if (r8 == r9) goto L_0x0034;
    L_0x0033:
        goto L_0x005c;
    L_0x0034:
        r8 = "v";
        r5 = r5.equals(r8);
        if (r5 == 0) goto L_0x005c;
    L_0x003c:
        r5 = 1;
        goto L_0x005d;
    L_0x003e:
        r6 = "o";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x005c;
    L_0x0046:
        r5 = 3;
        goto L_0x005d;
    L_0x0048:
        r6 = "i";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x005c;
    L_0x0050:
        r5 = 2;
        goto L_0x005d;
    L_0x0052:
        r6 = "c";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x005c;
    L_0x005a:
        r5 = 0;
        goto L_0x005d;
    L_0x005c:
        r5 = -1;
    L_0x005d:
        switch(r5) {
            case 0: goto L_0x0070;
            case 1: goto L_0x006b;
            case 2: goto L_0x0066;
            case 3: goto L_0x0061;
            default: goto L_0x0060;
        };
    L_0x0060:
        goto L_0x0013;
    L_0x0061:
        r3 = com.airbnb.lottie.c.q.f(r13, r14);
        goto L_0x0013;
    L_0x0066:
        r2 = com.airbnb.lottie.c.q.f(r13, r14);
        goto L_0x0013;
    L_0x006b:
        r0 = com.airbnb.lottie.c.q.f(r13, r14);
        goto L_0x0013;
    L_0x0070:
        r4 = r13.nextBoolean();
        goto L_0x0013;
    L_0x0075:
        r13.endObject();
        r14 = r13.peek();
        r5 = android.util.JsonToken.END_ARRAY;
        if (r14 != r5) goto L_0x0083;
    L_0x0080:
        r13.endArray();
    L_0x0083:
        if (r0 == 0) goto L_0x0110;
    L_0x0085:
        if (r2 == 0) goto L_0x0110;
    L_0x0087:
        if (r3 != 0) goto L_0x008b;
    L_0x0089:
        goto L_0x0110;
    L_0x008b:
        r13 = r0.isEmpty();
        if (r13 == 0) goto L_0x00a0;
    L_0x0091:
        r13 = new com.airbnb.lottie.model.content.h;
        r14 = new android.graphics.PointF;
        r14.<init>();
        r0 = java.util.Collections.emptyList();
        r13.<init>(r14, r1, r0);
        return r13;
    L_0x00a0:
        r13 = r0.size();
        r14 = r0.get(r1);
        r14 = (android.graphics.PointF) r14;
        r5 = new java.util.ArrayList;
        r5.<init>(r13);
        r7 = 1;
    L_0x00b0:
        if (r7 >= r13) goto L_0x00df;
    L_0x00b2:
        r8 = r0.get(r7);
        r8 = (android.graphics.PointF) r8;
        r9 = r7 + -1;
        r10 = r0.get(r9);
        r10 = (android.graphics.PointF) r10;
        r9 = r3.get(r9);
        r9 = (android.graphics.PointF) r9;
        r11 = r2.get(r7);
        r11 = (android.graphics.PointF) r11;
        r9 = com.airbnb.lottie.d.e.b(r10, r9);
        r10 = com.airbnb.lottie.d.e.b(r8, r11);
        r11 = new com.airbnb.lottie.model.a;
        r11.<init>(r9, r10, r8);
        r5.add(r11);
        r7 = r7 + 1;
        goto L_0x00b0;
    L_0x00df:
        if (r4 == 0) goto L_0x010a;
    L_0x00e1:
        r7 = r0.get(r1);
        r7 = (android.graphics.PointF) r7;
        r13 = r13 - r6;
        r0 = r0.get(r13);
        r0 = (android.graphics.PointF) r0;
        r13 = r3.get(r13);
        r13 = (android.graphics.PointF) r13;
        r1 = r2.get(r1);
        r1 = (android.graphics.PointF) r1;
        r13 = com.airbnb.lottie.d.e.b(r0, r13);
        r0 = com.airbnb.lottie.d.e.b(r7, r1);
        r1 = new com.airbnb.lottie.model.a;
        r1.<init>(r13, r0, r7);
        r5.add(r1);
    L_0x010a:
        r13 = new com.airbnb.lottie.model.content.h;
        r13.<init>(r14, r4, r5);
        return r13;
    L_0x0110:
        r13 = new java.lang.IllegalArgumentException;
        r14 = "Shape data was missing information.";
        r13.<init>(r14);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.ae.m(android.util.JsonReader, float):com.airbnb.lottie.model.content.h");
    }
}
