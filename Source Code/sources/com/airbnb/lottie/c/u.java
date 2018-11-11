package com.airbnb.lottie.c;

import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.JsonReader;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.c;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionParser */
public class u {
    /* JADX WARNING: Missing block: B:42:0x00cd, code:
            r27 = r11;
            r20 = r12;
     */
    /* JADX WARNING: Missing block: B:47:0x010b, code:
            r27 = r11;
     */
    /* JADX WARNING: Missing block: B:52:0x0139, code:
            r12 = r20;
            r11 = r27;
     */
    public static com.airbnb.lottie.g e(android.util.JsonReader r28) {
        /*
        r0 = r28;
        r1 = com.airbnb.lottie.d.f.fo();
        r8 = new android.support.v4.util.LongSparseArray;
        r8.<init>();
        r7 = new java.util.ArrayList;
        r7.<init>();
        r9 = new java.util.HashMap;
        r9.<init>();
        r10 = new java.util.HashMap;
        r10.<init>();
        r12 = new java.util.HashMap;
        r12.<init>();
        r11 = new android.support.v4.util.SparseArrayCompat;
        r11.<init>();
        r13 = new com.airbnb.lottie.g;
        r13.<init>();
        r28.beginObject();
        r2 = 0;
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r14 = 0;
    L_0x0032:
        r15 = r28.hasNext();
        if (r15 == 0) goto L_0x013f;
    L_0x0038:
        r15 = r28.nextName();
        r16 = -1;
        r17 = r15.hashCode();
        r18 = 1;
        r19 = 2;
        switch(r17) {
            case -1408207997: goto L_0x00a7;
            case -1109732030: goto L_0x009d;
            case 104: goto L_0x0093;
            case 118: goto L_0x0089;
            case 119: goto L_0x007f;
            case 3276: goto L_0x0075;
            case 3367: goto L_0x006b;
            case 3553: goto L_0x0061;
            case 94623709: goto L_0x0056;
            case 97615364: goto L_0x004b;
            default: goto L_0x0049;
        };
    L_0x0049:
        goto L_0x00b1;
    L_0x004b:
        r3 = "fonts";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0053:
        r3 = 8;
        goto L_0x00b2;
    L_0x0056:
        r3 = "chars";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x005e:
        r3 = 9;
        goto L_0x00b2;
    L_0x0061:
        r3 = "op";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0069:
        r3 = 3;
        goto L_0x00b2;
    L_0x006b:
        r3 = "ip";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0073:
        r3 = 2;
        goto L_0x00b2;
    L_0x0075:
        r3 = "fr";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x007d:
        r3 = 4;
        goto L_0x00b2;
    L_0x007f:
        r3 = "w";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0087:
        r3 = 0;
        goto L_0x00b2;
    L_0x0089:
        r3 = "v";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0091:
        r3 = 5;
        goto L_0x00b2;
    L_0x0093:
        r3 = "h";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x009b:
        r3 = 1;
        goto L_0x00b2;
    L_0x009d:
        r3 = "layers";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x00a5:
        r3 = 6;
        goto L_0x00b2;
    L_0x00a7:
        r3 = "assets";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x00af:
        r3 = 7;
        goto L_0x00b2;
    L_0x00b1:
        r3 = -1;
    L_0x00b2:
        switch(r3) {
            case 0: goto L_0x0131;
            case 1: goto L_0x0127;
            case 2: goto L_0x011d;
            case 3: goto L_0x010e;
            case 4: goto L_0x0104;
            case 5: goto L_0x00d3;
            case 6: goto L_0x00ca;
            case 7: goto L_0x00c6;
            case 8: goto L_0x00c2;
            case 9: goto L_0x00be;
            default: goto L_0x00b5;
        };
    L_0x00b5:
        r27 = r11;
        r20 = r12;
        r28.skipValue();
        goto L_0x0139;
    L_0x00be:
        a(r0, r13, r11);
        goto L_0x00cd;
    L_0x00c2:
        a(r0, r12);
        goto L_0x00cd;
    L_0x00c6:
        a(r0, r13, r9, r10);
        goto L_0x00cd;
    L_0x00ca:
        a(r0, r13, r7, r8);
    L_0x00cd:
        r27 = r11;
        r20 = r12;
        goto L_0x0139;
    L_0x00d3:
        r3 = r28.nextString();
        r15 = "\\.";
        r3 = r3.split(r15);
        r20 = r12;
        r15 = 0;
        r12 = r3[r15];
        r21 = java.lang.Integer.parseInt(r12);
        r12 = r3[r18];
        r22 = java.lang.Integer.parseInt(r12);
        r3 = r3[r19];
        r23 = java.lang.Integer.parseInt(r3);
        r24 = 4;
        r25 = 4;
        r26 = 0;
        r3 = com.airbnb.lottie.d.f.a(r21, r22, r23, r24, r25, r26);
        if (r3 != 0) goto L_0x010b;
    L_0x00fe:
        r3 = "Lottie only supports bodymovin >= 4.4.0";
        r13.Y(r3);
        goto L_0x010b;
    L_0x0104:
        r20 = r12;
        r14 = r28.nextDouble();
        r14 = (float) r14;
    L_0x010b:
        r27 = r11;
        goto L_0x0139;
    L_0x010e:
        r27 = r11;
        r20 = r12;
        r11 = r28.nextDouble();
        r3 = (float) r11;
        r6 = 1008981770; // 0x3c23d70a float:0.01 double:4.9850323E-315;
        r6 = r3 - r6;
        goto L_0x0139;
    L_0x011d:
        r27 = r11;
        r20 = r12;
        r11 = r28.nextDouble();
        r5 = (float) r11;
        goto L_0x0139;
    L_0x0127:
        r27 = r11;
        r20 = r12;
        r3 = r28.nextInt();
        r4 = r3;
        goto L_0x0139;
    L_0x0131:
        r27 = r11;
        r20 = r12;
        r2 = r28.nextInt();
    L_0x0139:
        r12 = r20;
        r11 = r27;
        goto L_0x0032;
    L_0x013f:
        r27 = r11;
        r20 = r12;
        r28.endObject();
        r0 = (float) r2;
        r0 = r0 * r1;
        r0 = (int) r0;
        r2 = (float) r4;
        r2 = r2 * r1;
        r1 = (int) r2;
        r3 = new android.graphics.Rect;
        r2 = 0;
        r3.<init>(r2, r2, r0, r1);
        r2 = r13;
        r4 = r5;
        r5 = r6;
        r6 = r14;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.u.e(android.util.JsonReader):com.airbnb.lottie.g");
    }

    private static void a(JsonReader jsonReader, g gVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer q = t.q(jsonReader, gVar);
            if (q.eV() == LayerType.Image) {
                i++;
            }
            list.add(q);
            longSparseArray.put(q.getId(), q);
            if (i > 4) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("You have ");
                stringBuilder.append(i);
                stringBuilder.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                d.warn(stringBuilder.toString());
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    private static void a(android.util.JsonReader r12, com.airbnb.lottie.g r13, java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.model.layer.Layer>> r14, java.util.Map<java.lang.String, com.airbnb.lottie.p> r15) {
        /*
        r12.beginArray();
    L_0x0003:
        r0 = r12.hasNext();
        if (r0 == 0) goto L_0x00e0;
    L_0x0009:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new android.support.v4.util.LongSparseArray;
        r1.<init>();
        r12.beginObject();
        r2 = 0;
        r3 = 0;
        r7 = r3;
        r8 = r7;
        r9 = r8;
        r5 = 0;
        r6 = 0;
    L_0x001d:
        r3 = r12.hasNext();
        if (r3 == 0) goto L_0x00c7;
    L_0x0023:
        r3 = r12.nextName();
        r4 = -1;
        r10 = r3.hashCode();
        r11 = -1109732030; // 0xffffffffbddad542 float:-0.10685207 double:NaN;
        if (r10 == r11) goto L_0x0078;
    L_0x0031:
        r11 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        if (r10 == r11) goto L_0x006e;
    L_0x0035:
        r11 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        if (r10 == r11) goto L_0x0064;
    L_0x0039:
        r11 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        if (r10 == r11) goto L_0x005a;
    L_0x003d:
        r11 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        if (r10 == r11) goto L_0x0050;
    L_0x0041:
        r11 = 3355; // 0xd1b float:4.701E-42 double:1.6576E-320;
        if (r10 == r11) goto L_0x0046;
    L_0x0045:
        goto L_0x0082;
    L_0x0046:
        r10 = "id";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x0082;
    L_0x004e:
        r3 = 0;
        goto L_0x0083;
    L_0x0050:
        r10 = "w";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x0082;
    L_0x0058:
        r3 = 2;
        goto L_0x0083;
    L_0x005a:
        r10 = "u";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x0082;
    L_0x0062:
        r3 = 5;
        goto L_0x0083;
    L_0x0064:
        r10 = "p";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x0082;
    L_0x006c:
        r3 = 4;
        goto L_0x0083;
    L_0x006e:
        r10 = "h";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x0082;
    L_0x0076:
        r3 = 3;
        goto L_0x0083;
    L_0x0078:
        r10 = "layers";
        r3 = r3.equals(r10);
        if (r3 == 0) goto L_0x0082;
    L_0x0080:
        r3 = 1;
        goto L_0x0083;
    L_0x0082:
        r3 = -1;
    L_0x0083:
        switch(r3) {
            case 0: goto L_0x00c0;
            case 1: goto L_0x00a3;
            case 2: goto L_0x009c;
            case 3: goto L_0x0096;
            case 4: goto L_0x0090;
            case 5: goto L_0x008a;
            default: goto L_0x0086;
        };
    L_0x0086:
        r12.skipValue();
        goto L_0x001d;
    L_0x008a:
        r3 = r12.nextString();
        r9 = r3;
        goto L_0x001d;
    L_0x0090:
        r3 = r12.nextString();
        r8 = r3;
        goto L_0x001d;
    L_0x0096:
        r3 = r12.nextInt();
        r6 = r3;
        goto L_0x001d;
    L_0x009c:
        r3 = r12.nextInt();
        r5 = r3;
        goto L_0x001d;
    L_0x00a3:
        r12.beginArray();
    L_0x00a6:
        r3 = r12.hasNext();
        if (r3 == 0) goto L_0x00bb;
    L_0x00ac:
        r3 = com.airbnb.lottie.c.t.q(r12, r13);
        r10 = r3.getId();
        r1.put(r10, r3);
        r0.add(r3);
        goto L_0x00a6;
    L_0x00bb:
        r12.endArray();
        goto L_0x001d;
    L_0x00c0:
        r3 = r12.nextString();
        r7 = r3;
        goto L_0x001d;
    L_0x00c7:
        r12.endObject();
        if (r8 == 0) goto L_0x00db;
    L_0x00cc:
        r0 = new com.airbnb.lottie.p;
        r4 = r0;
        r4.<init>(r5, r6, r7, r8, r9);
        r1 = r0.getId();
        r15.put(r1, r0);
        goto L_0x0003;
    L_0x00db:
        r14.put(r7, r0);
        goto L_0x0003;
    L_0x00e0:
        r12.endArray();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.u.a(android.util.JsonReader, com.airbnb.lottie.g, java.util.Map, java.util.Map):void");
    }

    private static void a(JsonReader jsonReader, Map<String, c> map) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            if (nextName.hashCode() == 3322014 && nextName.equals("list")) {
                obj = null;
            }
            if (obj != null) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    c b = l.b(jsonReader);
                    map.put(b.getName(), b);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void a(JsonReader jsonReader, g gVar, SparseArrayCompat<com.airbnb.lottie.model.d> sparseArrayCompat) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.model.d n = k.n(jsonReader, gVar);
            sparseArrayCompat.put(n.hashCode(), n);
        }
        jsonReader.endArray();
    }
}
