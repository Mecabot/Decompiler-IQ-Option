package com.airbnb.lottie.c;

import android.graphics.Rect;
import com.airbnb.lottie.g;
import com.airbnb.lottie.model.a.l;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.airbnb.lottie.model.layer.Layer.MatteType;
import java.util.Collections;

/* compiled from: LayerParser */
public class t {
    public static Layer g(g gVar) {
        Rect bounds = gVar.getBounds();
        return new Layer(Collections.emptyList(), gVar, "__container", -1, LayerType.PreComp, -1, null, Collections.emptyList(), new l(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), MatteType.None, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0242  */
    public static com.airbnb.lottie.model.layer.Layer q(android.util.JsonReader r37, com.airbnb.lottie.g r38) {
        /*
        r7 = r38;
        r0 = com.airbnb.lottie.model.layer.Layer.MatteType.None;
        r10 = new java.util.ArrayList;
        r10.<init>();
        r8 = new java.util.ArrayList;
        r8.<init>();
        r37.beginObject();
        r1 = 0;
        r11 = 0;
        r2 = 0;
        r3 = 0;
        r5 = -1;
        r30 = r0;
        r12 = r1;
        r13 = r12;
        r14 = r13;
        r20 = r14;
        r21 = r20;
        r28 = r21;
        r29 = r28;
        r31 = r29;
        r16 = r3;
        r18 = r5;
        r0 = 0;
        r1 = 0;
        r15 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r25 = 0;
        r26 = 0;
        r27 = 0;
    L_0x003b:
        r3 = r37.hasNext();
        if (r3 == 0) goto L_0x031a;
    L_0x0041:
        r3 = r37.nextName();
        r4 = r3.hashCode();
        r5 = 1;
        switch(r4) {
            case -995424086: goto L_0x013c;
            case -903568142: goto L_0x0131;
            case 104: goto L_0x0126;
            case 116: goto L_0x011b;
            case 119: goto L_0x0110;
            case 3177: goto L_0x0105;
            case 3233: goto L_0x00fa;
            case 3367: goto L_0x00ef;
            case 3432: goto L_0x00e4;
            case 3519: goto L_0x00d9;
            case 3553: goto L_0x00cd;
            case 3664: goto L_0x00c2;
            case 3669: goto L_0x00b7;
            case 3679: goto L_0x00ab;
            case 3681: goto L_0x009f;
            case 3684: goto L_0x0094;
            case 3705: goto L_0x0088;
            case 3712: goto L_0x007c;
            case 3717: goto L_0x0071;
            case 104415: goto L_0x0066;
            case 108390670: goto L_0x005b;
            case 1441620890: goto L_0x004f;
            default: goto L_0x004d;
        };
    L_0x004d:
        goto L_0x0146;
    L_0x004f:
        r4 = "masksProperties";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0057:
        r3 = 10;
        goto L_0x0147;
    L_0x005b:
        r4 = "refId";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0063:
        r3 = 2;
        goto L_0x0147;
    L_0x0066:
        r4 = "ind";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x006e:
        r3 = 1;
        goto L_0x0147;
    L_0x0071:
        r4 = "ty";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0079:
        r3 = 3;
        goto L_0x0147;
    L_0x007c:
        r4 = "tt";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0084:
        r3 = 9;
        goto L_0x0147;
    L_0x0088:
        r4 = "tm";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0090:
        r3 = 20;
        goto L_0x0147;
    L_0x0094:
        r4 = "sw";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x009c:
        r3 = 5;
        goto L_0x0147;
    L_0x009f:
        r4 = "st";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00a7:
        r3 = 15;
        goto L_0x0147;
    L_0x00ab:
        r4 = "sr";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00b3:
        r3 = 14;
        goto L_0x0147;
    L_0x00b7:
        r4 = "sh";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00bf:
        r3 = 6;
        goto L_0x0147;
    L_0x00c2:
        r4 = "sc";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00ca:
        r3 = 7;
        goto L_0x0147;
    L_0x00cd:
        r4 = "op";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00d5:
        r3 = 19;
        goto L_0x0147;
    L_0x00d9:
        r4 = "nm";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00e1:
        r3 = 0;
        goto L_0x0147;
    L_0x00e4:
        r4 = "ks";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00ec:
        r3 = 8;
        goto L_0x0147;
    L_0x00ef:
        r4 = "ip";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x00f7:
        r3 = 18;
        goto L_0x0147;
    L_0x00fa:
        r4 = "ef";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0102:
        r3 = 13;
        goto L_0x0147;
    L_0x0105:
        r4 = "cl";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x010d:
        r3 = 21;
        goto L_0x0147;
    L_0x0110:
        r4 = "w";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0118:
        r3 = 16;
        goto L_0x0147;
    L_0x011b:
        r4 = "t";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0123:
        r3 = 12;
        goto L_0x0147;
    L_0x0126:
        r4 = "h";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x012e:
        r3 = 17;
        goto L_0x0147;
    L_0x0131:
        r4 = "shapes";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0139:
        r3 = 11;
        goto L_0x0147;
    L_0x013c:
        r4 = "parent";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0146;
    L_0x0144:
        r3 = 4;
        goto L_0x0147;
    L_0x0146:
        r3 = -1;
    L_0x0147:
        switch(r3) {
            case 0: goto L_0x0311;
            case 1: goto L_0x0307;
            case 2: goto L_0x0300;
            case 3: goto L_0x02e8;
            case 4: goto L_0x02de;
            case 5: goto L_0x02cd;
            case 6: goto L_0x02bc;
            case 7: goto L_0x02b1;
            case 8: goto L_0x02a9;
            case 9: goto L_0x029b;
            case 10: goto L_0x0283;
            case 11: goto L_0x0269;
            case 12: goto L_0x020a;
            case 13: goto L_0x01ac;
            case 14: goto L_0x01a3;
            case 15: goto L_0x0198;
            case 16: goto L_0x0186;
            case 17: goto L_0x0174;
            case 18: goto L_0x016b;
            case 19: goto L_0x0162;
            case 20: goto L_0x015a;
            case 21: goto L_0x0151;
            default: goto L_0x014a;
        };
    L_0x014a:
        r3 = r37;
        r37.skipValue();
        goto L_0x0317;
    L_0x0151:
        r3 = r37.nextString();
        r13 = r3;
        r3 = r37;
        goto L_0x0317;
    L_0x015a:
        r3 = r37;
        r31 = com.airbnb.lottie.c.d.a(r3, r7, r2);
        goto L_0x0317;
    L_0x0162:
        r3 = r37;
        r4 = r37.nextDouble();
        r1 = (float) r4;
        goto L_0x0317;
    L_0x016b:
        r3 = r37;
        r4 = r37.nextDouble();
        r0 = (float) r4;
        goto L_0x0317;
    L_0x0174:
        r3 = r37;
        r4 = r37.nextInt();
        r4 = (float) r4;
        r5 = com.airbnb.lottie.d.f.fo();
        r4 = r4 * r5;
        r4 = (int) r4;
        r27 = r4;
        goto L_0x0317;
    L_0x0186:
        r3 = r37;
        r4 = r37.nextInt();
        r4 = (float) r4;
        r5 = com.airbnb.lottie.d.f.fo();
        r4 = r4 * r5;
        r4 = (int) r4;
        r26 = r4;
        goto L_0x0317;
    L_0x0198:
        r3 = r37;
        r4 = r37.nextDouble();
        r4 = (float) r4;
        r25 = r4;
        goto L_0x0317;
    L_0x01a3:
        r3 = r37;
        r4 = r37.nextDouble();
        r15 = (float) r4;
        goto L_0x0317;
    L_0x01ac:
        r3 = r37;
        r37.beginArray();
        r4 = new java.util.ArrayList;
        r4.<init>();
    L_0x01b6:
        r5 = r37.hasNext();
        if (r5 == 0) goto L_0x01f1;
    L_0x01bc:
        r37.beginObject();
    L_0x01bf:
        r5 = r37.hasNext();
        if (r5 == 0) goto L_0x01ec;
    L_0x01c5:
        r5 = r37.nextName();
        r2 = r5.hashCode();
        r6 = 3519; // 0xdbf float:4.931E-42 double:1.7386E-320;
        if (r2 == r6) goto L_0x01d2;
    L_0x01d1:
        goto L_0x01dc;
    L_0x01d2:
        r2 = "nm";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x01dc;
    L_0x01da:
        r2 = 0;
        goto L_0x01dd;
    L_0x01dc:
        r2 = -1;
    L_0x01dd:
        if (r2 == 0) goto L_0x01e3;
    L_0x01df:
        r37.skipValue();
        goto L_0x01ea;
    L_0x01e3:
        r2 = r37.nextString();
        r4.add(r2);
    L_0x01ea:
        r2 = 0;
        goto L_0x01bf;
    L_0x01ec:
        r37.endObject();
        r2 = 0;
        goto L_0x01b6;
    L_0x01f1:
        r37.endArray();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ";
        r2.append(r5);
        r2.append(r4);
        r2 = r2.toString();
        r7.Y(r2);
        goto L_0x0317;
    L_0x020a:
        r3 = r37;
        r37.beginObject();
    L_0x020f:
        r2 = r37.hasNext();
        if (r2 == 0) goto L_0x0264;
    L_0x0215:
        r2 = r37.nextName();
        r4 = r2.hashCode();
        r6 = 97;
        if (r4 == r6) goto L_0x0230;
    L_0x0221:
        r6 = 100;
        if (r4 == r6) goto L_0x0226;
    L_0x0225:
        goto L_0x023a;
    L_0x0226:
        r4 = "d";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x023a;
    L_0x022e:
        r2 = 0;
        goto L_0x023b;
    L_0x0230:
        r4 = "a";
        r2 = r2.equals(r4);
        if (r2 == 0) goto L_0x023a;
    L_0x0238:
        r2 = 1;
        goto L_0x023b;
    L_0x023a:
        r2 = -1;
    L_0x023b:
        switch(r2) {
            case 0: goto L_0x025f;
            case 1: goto L_0x0242;
            default: goto L_0x023e;
        };
    L_0x023e:
        r37.skipValue();
        goto L_0x020f;
    L_0x0242:
        r37.beginArray();
        r2 = r37.hasNext();
        if (r2 == 0) goto L_0x0251;
    L_0x024b:
        r2 = com.airbnb.lottie.c.b.c(r37, r38);
        r29 = r2;
    L_0x0251:
        r2 = r37.hasNext();
        if (r2 == 0) goto L_0x025b;
    L_0x0257:
        r37.skipValue();
        goto L_0x0251;
    L_0x025b:
        r37.endArray();
        goto L_0x020f;
    L_0x025f:
        r28 = com.airbnb.lottie.c.d.k(r37, r38);
        goto L_0x020f;
    L_0x0264:
        r37.endObject();
        goto L_0x0317;
    L_0x0269:
        r3 = r37;
        r37.beginArray();
    L_0x026e:
        r2 = r37.hasNext();
        if (r2 == 0) goto L_0x027e;
    L_0x0274:
        r2 = com.airbnb.lottie.c.h.m(r37, r38);
        if (r2 == 0) goto L_0x026e;
    L_0x027a:
        r8.add(r2);
        goto L_0x026e;
    L_0x027e:
        r37.endArray();
        goto L_0x0317;
    L_0x0283:
        r3 = r37;
        r37.beginArray();
    L_0x0288:
        r2 = r37.hasNext();
        if (r2 == 0) goto L_0x0296;
    L_0x028e:
        r2 = com.airbnb.lottie.c.v.r(r37, r38);
        r10.add(r2);
        goto L_0x0288;
    L_0x0296:
        r37.endArray();
        goto L_0x0317;
    L_0x029b:
        r3 = r37;
        r2 = com.airbnb.lottie.model.layer.Layer.MatteType.values();
        r4 = r37.nextInt();
        r30 = r2[r4];
        goto L_0x0317;
    L_0x02a9:
        r3 = r37;
        r21 = com.airbnb.lottie.c.c.e(r37, r38);
        goto L_0x0317;
    L_0x02b1:
        r3 = r37;
        r2 = r37.nextString();
        r24 = android.graphics.Color.parseColor(r2);
        goto L_0x0317;
    L_0x02bc:
        r3 = r37;
        r2 = r37.nextInt();
        r2 = (float) r2;
        r4 = com.airbnb.lottie.d.f.fo();
        r2 = r2 * r4;
        r2 = (int) r2;
        r23 = r2;
        goto L_0x0317;
    L_0x02cd:
        r3 = r37;
        r2 = r37.nextInt();
        r2 = (float) r2;
        r4 = com.airbnb.lottie.d.f.fo();
        r2 = r2 * r4;
        r2 = (int) r2;
        r22 = r2;
        goto L_0x0317;
    L_0x02de:
        r3 = r37;
        r2 = r37.nextInt();
        r4 = (long) r2;
        r18 = r4;
        goto L_0x0317;
    L_0x02e8:
        r3 = r37;
        r2 = r37.nextInt();
        r4 = com.airbnb.lottie.model.layer.Layer.LayerType.Unknown;
        r4 = r4.ordinal();
        if (r2 >= r4) goto L_0x02fd;
    L_0x02f6:
        r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values();
        r14 = r4[r2];
        goto L_0x0317;
    L_0x02fd:
        r14 = com.airbnb.lottie.model.layer.Layer.LayerType.Unknown;
        goto L_0x0317;
    L_0x0300:
        r3 = r37;
        r20 = r37.nextString();
        goto L_0x0317;
    L_0x0307:
        r3 = r37;
        r2 = r37.nextInt();
        r4 = (long) r2;
        r16 = r4;
        goto L_0x0317;
    L_0x0311:
        r3 = r37;
        r12 = r37.nextString();
    L_0x0317:
        r2 = 0;
        goto L_0x003b;
    L_0x031a:
        r3 = r37;
        r37.endObject();
        r6 = r0 / r15;
        r32 = r1 / r15;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        if (r0 <= 0) goto L_0x0351;
    L_0x032c:
        r4 = new com.airbnb.lottie.e.a;
        r2 = java.lang.Float.valueOf(r11);
        r3 = java.lang.Float.valueOf(r11);
        r33 = 0;
        r34 = 0;
        r35 = java.lang.Float.valueOf(r6);
        r0 = r4;
        r1 = r7;
        r9 = r4;
        r4 = r33;
        r11 = r5;
        r5 = r34;
        r33 = r6;
        r6 = r35;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r11.add(r9);
        goto L_0x0354;
    L_0x0351:
        r11 = r5;
        r33 = r6;
    L_0x0354:
        r0 = 0;
        r1 = (r32 > r0 ? 1 : (r32 == r0 ? 0 : -1));
        if (r1 <= 0) goto L_0x035c;
    L_0x0359:
        r9 = r32;
        goto L_0x0361;
    L_0x035c:
        r0 = r38.db();
        r9 = r0;
    L_0x0361:
        r6 = new com.airbnb.lottie.e.a;
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = java.lang.Float.valueOf(r0);
        r3 = java.lang.Float.valueOf(r0);
        r4 = 0;
        r32 = java.lang.Float.valueOf(r9);
        r0 = r6;
        r1 = r7;
        r5 = r33;
        r36 = r15;
        r15 = r6;
        r6 = r32;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r11.add(r15);
        r15 = new com.airbnb.lottie.e.a;
        r0 = 0;
        r2 = java.lang.Float.valueOf(r0);
        r3 = java.lang.Float.valueOf(r0);
        r0 = 2139095039; // 0x7f7fffff float:3.4028235E38 double:1.056853372E-314;
        r6 = java.lang.Float.valueOf(r0);
        r0 = r15;
        r5 = r9;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r11.add(r15);
        r0 = ".ai";
        r0 = r12.endsWith(r0);
        if (r0 != 0) goto L_0x03ab;
    L_0x03a3:
        r0 = "ai";
        r0 = r0.equals(r13);
        if (r0 == 0) goto L_0x03b0;
    L_0x03ab:
        r0 = "Convert your Illustrator layers to shape layers.";
        r7.Y(r0);
    L_0x03b0:
        r32 = new com.airbnb.lottie.model.layer.Layer;
        r0 = r32;
        r1 = r8;
        r2 = r7;
        r3 = r12;
        r4 = r16;
        r6 = r14;
        r7 = r18;
        r9 = r20;
        r33 = r11;
        r11 = r21;
        r12 = r22;
        r13 = r23;
        r14 = r24;
        r15 = r36;
        r16 = r25;
        r17 = r26;
        r18 = r27;
        r19 = r28;
        r20 = r29;
        r21 = r33;
        r22 = r30;
        r23 = r31;
        r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        return r32;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.t.q(android.util.JsonReader, com.airbnb.lottie.g):com.airbnb.lottie.model.layer.Layer");
    }
}
