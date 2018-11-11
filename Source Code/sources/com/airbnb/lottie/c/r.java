package com.airbnb.lottie.c;

import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.e.a;
import com.airbnb.lottie.g;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser */
class r {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static SparseArrayCompat<WeakReference<Interpolator>> oy;

    r() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> fd() {
        if (oy == null) {
            oy = new SparseArrayCompat();
        }
        return oy;
    }

    @Nullable
    private static WeakReference<Interpolator> q(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (r.class) {
            weakReference = (WeakReference) fd().get(i);
        }
        return weakReference;
    }

    private static void a(int i, WeakReference<Interpolator> weakReference) {
        synchronized (r.class) {
            oy.put(i, weakReference);
        }
    }

    static <T> a<T> a(JsonReader jsonReader, g gVar, float f, ak<T> akVar, boolean z) {
        if (z) {
            return a(gVar, jsonReader, f, akVar);
        }
        return a(jsonReader, f, akVar);
    }

    private static <T> com.airbnb.lottie.e.a<T> a(com.airbnb.lottie.g r17, android.util.JsonReader r18, float r19, com.airbnb.lottie.c.ak<T> r20) {
        /*
        r0 = r18;
        r1 = r19;
        r2 = r20;
        r18.beginObject();
        r4 = 0;
        r5 = 0;
        r6 = r4;
        r7 = r6;
        r8 = r7;
        r9 = r8;
        r13 = r9;
        r14 = r13;
        r5 = 0;
        r11 = 0;
    L_0x0013:
        r10 = r18.hasNext();
        if (r10 == 0) goto L_0x00ba;
    L_0x0019:
        r10 = r18.nextName();
        r12 = -1;
        r15 = r10.hashCode();
        r3 = 1;
        switch(r15) {
            case 101: goto L_0x006d;
            case 104: goto L_0x0063;
            case 105: goto L_0x0059;
            case 111: goto L_0x004f;
            case 115: goto L_0x0045;
            case 116: goto L_0x003b;
            case 3701: goto L_0x0031;
            case 3707: goto L_0x0027;
            default: goto L_0x0026;
        };
    L_0x0026:
        goto L_0x0077;
    L_0x0027:
        r15 = "to";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x002f:
        r10 = 6;
        goto L_0x0078;
    L_0x0031:
        r15 = "ti";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0039:
        r10 = 7;
        goto L_0x0078;
    L_0x003b:
        r15 = "t";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0043:
        r10 = 0;
        goto L_0x0078;
    L_0x0045:
        r15 = "s";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x004d:
        r10 = 1;
        goto L_0x0078;
    L_0x004f:
        r15 = "o";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0057:
        r10 = 3;
        goto L_0x0078;
    L_0x0059:
        r15 = "i";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0061:
        r10 = 4;
        goto L_0x0078;
    L_0x0063:
        r15 = "h";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x006b:
        r10 = 5;
        goto L_0x0078;
    L_0x006d:
        r15 = "e";
        r10 = r10.equals(r15);
        if (r10 == 0) goto L_0x0077;
    L_0x0075:
        r10 = 2;
        goto L_0x0078;
    L_0x0077:
        r10 = -1;
    L_0x0078:
        switch(r10) {
            case 0: goto L_0x00b2;
            case 1: goto L_0x00ab;
            case 2: goto L_0x00a4;
            case 3: goto L_0x009d;
            case 4: goto L_0x0096;
            case 5: goto L_0x008b;
            case 6: goto L_0x0085;
            case 7: goto L_0x007f;
            default: goto L_0x007b;
        };
    L_0x007b:
        r18.skipValue();
        goto L_0x0013;
    L_0x007f:
        r3 = com.airbnb.lottie.c.q.g(r18, r19);
        r14 = r3;
        goto L_0x0013;
    L_0x0085:
        r3 = com.airbnb.lottie.c.q.g(r18, r19);
        r13 = r3;
        goto L_0x0013;
    L_0x008b:
        r5 = r18.nextInt();
        if (r5 != r3) goto L_0x0092;
    L_0x0091:
        goto L_0x0093;
    L_0x0092:
        r3 = 0;
    L_0x0093:
        r5 = r3;
        goto L_0x0013;
    L_0x0096:
        r3 = com.airbnb.lottie.c.q.g(r18, r19);
        r7 = r3;
        goto L_0x0013;
    L_0x009d:
        r3 = com.airbnb.lottie.c.q.g(r18, r19);
        r6 = r3;
        goto L_0x0013;
    L_0x00a4:
        r3 = r2.b(r0, r1);
        r9 = r3;
        goto L_0x0013;
    L_0x00ab:
        r3 = r2.b(r0, r1);
        r8 = r3;
        goto L_0x0013;
    L_0x00b2:
        r10 = r18.nextDouble();
        r3 = (float) r10;
        r11 = r3;
        goto L_0x0013;
    L_0x00ba:
        r18.endObject();
        if (r5 == 0) goto L_0x00c4;
    L_0x00bf:
        r0 = LINEAR_INTERPOLATOR;
        r10 = r0;
        r9 = r8;
        goto L_0x0127;
    L_0x00c4:
        if (r6 == 0) goto L_0x0124;
    L_0x00c6:
        if (r7 == 0) goto L_0x0124;
    L_0x00c8:
        r0 = r6.x;
        r2 = -r1;
        r0 = com.airbnb.lottie.d.e.clamp(r0, r2, r1);
        r6.x = r0;
        r0 = r6.y;
        r3 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r5 = -1027080192; // 0xffffffffc2c80000 float:-100.0 double:NaN;
        r0 = com.airbnb.lottie.d.e.clamp(r0, r5, r3);
        r6.y = r0;
        r0 = r7.x;
        r0 = com.airbnb.lottie.d.e.clamp(r0, r2, r1);
        r7.x = r0;
        r0 = r7.y;
        r0 = com.airbnb.lottie.d.e.clamp(r0, r5, r3);
        r7.y = r0;
        r0 = r6.x;
        r2 = r6.y;
        r3 = r7.x;
        r5 = r7.y;
        r0 = com.airbnb.lottie.d.f.a(r0, r2, r3, r5);
        r2 = q(r0);
        if (r2 == 0) goto L_0x0106;
    L_0x00ff:
        r3 = r2.get();
        r4 = r3;
        r4 = (android.view.animation.Interpolator) r4;
    L_0x0106:
        if (r2 == 0) goto L_0x010a;
    L_0x0108:
        if (r4 != 0) goto L_0x0122;
    L_0x010a:
        r2 = r6.x;
        r2 = r2 / r1;
        r3 = r6.y;
        r3 = r3 / r1;
        r4 = r7.x;
        r4 = r4 / r1;
        r5 = r7.y;
        r5 = r5 / r1;
        r4 = android.support.v4.view.animation.PathInterpolatorCompat.create(r2, r3, r4, r5);
        r1 = new java.lang.ref.WeakReference;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0122 }
        r1.<init>(r4);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0122 }
        a(r0, r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0122 }
    L_0x0122:
        r10 = r4;
        goto L_0x0127;
    L_0x0124:
        r0 = LINEAR_INTERPOLATOR;
        r10 = r0;
    L_0x0127:
        r0 = new com.airbnb.lottie.e.a;
        r12 = 0;
        r6 = r0;
        r7 = r17;
        r6.<init>(r7, r8, r9, r10, r11, r12);
        r0.oV = r13;
        r0.oW = r14;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.r.a(com.airbnb.lottie.g, android.util.JsonReader, float, com.airbnb.lottie.c.ak):com.airbnb.lottie.e.a<T>");
    }

    private static <T> a<T> a(JsonReader jsonReader, float f, ak<T> akVar) {
        return new a(akVar.b(jsonReader, f));
    }
}
