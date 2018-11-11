package com.neovisionaries.ws.client;

import android.support.v4.view.InputDeviceCompat;

/* compiled from: DeflateUtil */
class g {
    private static int[] dZx = new int[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    g() {
    }

    public static void a(c cVar, int[] iArr, n[] nVarArr) {
        int c = cVar.c(iArr, 5) + InputDeviceCompat.SOURCE_KEYBOARD;
        int c2 = cVar.c(iArr, 5) + 1;
        int c3 = cVar.c(iArr, 4) + 4;
        int[] iArr2 = new int[19];
        for (int i = 0; i < c3; i++) {
            iArr2[ig(i)] = (byte) cVar.c(iArr, 3);
        }
        n nVar = new n(iArr2);
        int[] iArr3 = new int[c];
        a(cVar, iArr, iArr3, nVar);
        n nVar2 = new n(iArr3);
        int[] iArr4 = new int[c2];
        a(cVar, iArr, iArr4, nVar);
        n nVar3 = new n(iArr4);
        nVarArr[0] = nVar2;
        nVarArr[1] = nVar3;
    }

    private static void a(c cVar, int[] iArr, int[] iArr2, n nVar) {
        int i = 0;
        while (i < iArr2.length) {
            int a = nVar.a(cVar, iArr);
            if (a < 0 || a > 15) {
                int c;
                switch (a) {
                    case 16:
                        a = iArr2[i - 1];
                        c = cVar.c(iArr, 2) + 3;
                        break;
                    case 17:
                        a = cVar.c(iArr, 3) + 3;
                        break;
                    case 18:
                        a = cVar.c(iArr, 7) + 11;
                        break;
                    default:
                        throw new FormatException(String.format("[%s] Bad code length '%d' at the bit index '%d'.", new Object[]{g.class.getSimpleName(), Integer.valueOf(a), iArr}));
                }
                c = a;
                a = 0;
                for (int i2 = 0; i2 < c; i2++) {
                    iArr2[i + i2] = a;
                }
                i += c - 1;
            } else {
                iArr2[i] = a;
            }
            i++;
        }
    }

    private static int ig(int i) {
        return dZx[i];
    }

    /* JADX WARNING: Missing block: B:10:0x003b, code:
            r0 = 5;
     */
    /* JADX WARNING: Missing block: B:19:0x0054, code:
            r0 = 3;
     */
    /* JADX WARNING: Missing block: B:24:0x0061, code:
            r0 = 2;
     */
    /* JADX WARNING: Missing block: B:29:0x006e, code:
            r0 = 1;
     */
    /* JADX WARNING: Missing block: B:31:0x0074, code:
            return r7 + r5.c(r6, r0);
     */
    public static int a(com.neovisionaries.ws.client.c r5, int[] r6, int r7) {
        /*
        r0 = 4;
        r1 = 5;
        r2 = 2;
        r3 = 1;
        r4 = 3;
        switch(r7) {
            case 257: goto L_0x0075;
            case 258: goto L_0x0075;
            case 259: goto L_0x0075;
            case 260: goto L_0x0075;
            case 261: goto L_0x0075;
            case 262: goto L_0x0075;
            case 263: goto L_0x0075;
            case 264: goto L_0x0075;
            case 265: goto L_0x006c;
            case 266: goto L_0x0069;
            case 267: goto L_0x0066;
            case 268: goto L_0x0063;
            case 269: goto L_0x005f;
            case 270: goto L_0x005c;
            case 271: goto L_0x0059;
            case 272: goto L_0x0056;
            case 273: goto L_0x0052;
            case 274: goto L_0x004f;
            case 275: goto L_0x004c;
            case 276: goto L_0x0049;
            case 277: goto L_0x0046;
            case 278: goto L_0x0043;
            case 279: goto L_0x0040;
            case 280: goto L_0x003d;
            case 281: goto L_0x0039;
            case 282: goto L_0x0036;
            case 283: goto L_0x0033;
            case 284: goto L_0x0030;
            case 285: goto L_0x002d;
            default: goto L_0x0008;
        };
    L_0x0008:
        r5 = "[%s] Bad literal/length code '%d' at the bit index '%d'.";
        r0 = new java.lang.Object[r4];
        r1 = com.neovisionaries.ws.client.g.class;
        r1 = r1.getSimpleName();
        r4 = 0;
        r0[r4] = r1;
        r7 = java.lang.Integer.valueOf(r7);
        r0[r3] = r7;
        r6 = r6[r4];
        r6 = java.lang.Integer.valueOf(r6);
        r0[r2] = r6;
        r5 = java.lang.String.format(r5, r0);
        r6 = new com.neovisionaries.ws.client.FormatException;
        r6.<init>(r5);
        throw r6;
    L_0x002d:
        r5 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
        return r5;
    L_0x0030:
        r7 = 227; // 0xe3 float:3.18E-43 double:1.12E-321;
        goto L_0x003b;
    L_0x0033:
        r7 = 195; // 0xc3 float:2.73E-43 double:9.63E-322;
        goto L_0x003b;
    L_0x0036:
        r7 = 163; // 0xa3 float:2.28E-43 double:8.05E-322;
        goto L_0x003b;
    L_0x0039:
        r7 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
    L_0x003b:
        r0 = 5;
        goto L_0x006f;
    L_0x003d:
        r7 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x006f;
    L_0x0040:
        r7 = 99;
        goto L_0x006f;
    L_0x0043:
        r7 = 83;
        goto L_0x006f;
    L_0x0046:
        r7 = 67;
        goto L_0x006f;
    L_0x0049:
        r7 = 59;
        goto L_0x0054;
    L_0x004c:
        r7 = 51;
        goto L_0x0054;
    L_0x004f:
        r7 = 43;
        goto L_0x0054;
    L_0x0052:
        r7 = 35;
    L_0x0054:
        r0 = 3;
        goto L_0x006f;
    L_0x0056:
        r7 = 31;
        goto L_0x0061;
    L_0x0059:
        r7 = 27;
        goto L_0x0061;
    L_0x005c:
        r7 = 23;
        goto L_0x0061;
    L_0x005f:
        r7 = 19;
    L_0x0061:
        r0 = 2;
        goto L_0x006f;
    L_0x0063:
        r7 = 17;
        goto L_0x006e;
    L_0x0066:
        r7 = 15;
        goto L_0x006e;
    L_0x0069:
        r7 = 13;
        goto L_0x006e;
    L_0x006c:
        r7 = 11;
    L_0x006e:
        r0 = 1;
    L_0x006f:
        r5 = r5.c(r6, r0);
        r7 = r7 + r5;
        return r7;
    L_0x0075:
        r7 = r7 + -254;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.g.a(com.neovisionaries.ws.client.c, int[], int):int");
    }

    /* JADX WARNING: Missing block: B:6:0x0044, code:
            r0 = 13;
     */
    /* JADX WARNING: Missing block: B:9:0x004d, code:
            r0 = 12;
     */
    /* JADX WARNING: Missing block: B:12:0x0056, code:
            r0 = 11;
     */
    /* JADX WARNING: Missing block: B:15:0x005e, code:
            r0 = 10;
     */
    /* JADX WARNING: Missing block: B:18:0x0066, code:
            r0 = 9;
     */
    /* JADX WARNING: Missing block: B:21:0x006e, code:
            r0 = 8;
     */
    /* JADX WARNING: Missing block: B:24:0x0076, code:
            r0 = 7;
     */
    /* JADX WARNING: Missing block: B:27:0x007d, code:
            r0 = 6;
     */
    /* JADX WARNING: Missing block: B:34:0x0096, code:
            r0 = 3;
     */
    /* JADX WARNING: Missing block: B:40:0x00a9, code:
            return r6 + r13.c(r14, r0);
     */
    public static int a(com.neovisionaries.ws.client.c r13, int[] r14, com.neovisionaries.ws.client.n r15) {
        /*
        r15 = r15.a(r13, r14);
        r0 = 4;
        r1 = 6;
        r2 = 8;
        r3 = 10;
        r4 = 11;
        r5 = 12;
        r6 = 5;
        r7 = 7;
        r8 = 9;
        r9 = 13;
        r10 = 2;
        r11 = 3;
        r12 = 1;
        switch(r15) {
            case 0: goto L_0x00aa;
            case 1: goto L_0x00aa;
            case 2: goto L_0x00aa;
            case 3: goto L_0x00aa;
            case 4: goto L_0x00a3;
            case 5: goto L_0x00a0;
            case 6: goto L_0x009c;
            case 7: goto L_0x0098;
            case 8: goto L_0x0094;
            case 9: goto L_0x0091;
            case 10: goto L_0x008e;
            case 11: goto L_0x008b;
            case 12: goto L_0x0085;
            case 13: goto L_0x007f;
            case 14: goto L_0x007b;
            case 15: goto L_0x0078;
            case 16: goto L_0x0074;
            case 17: goto L_0x0071;
            case 18: goto L_0x006c;
            case 19: goto L_0x0069;
            case 20: goto L_0x0064;
            case 21: goto L_0x0061;
            case 22: goto L_0x005c;
            case 23: goto L_0x0059;
            case 24: goto L_0x0054;
            case 25: goto L_0x0051;
            case 26: goto L_0x004b;
            case 27: goto L_0x0048;
            case 28: goto L_0x0042;
            case 29: goto L_0x003f;
            default: goto L_0x001a;
        };
    L_0x001a:
        r13 = "[%s] Bad distance code '%d' at the bit index '%d'.";
        r0 = new java.lang.Object[r11];
        r1 = com.neovisionaries.ws.client.g.class;
        r1 = r1.getSimpleName();
        r2 = 0;
        r0[r2] = r1;
        r15 = java.lang.Integer.valueOf(r15);
        r0[r12] = r15;
        r14 = r14[r2];
        r14 = java.lang.Integer.valueOf(r14);
        r0[r10] = r14;
        r13 = java.lang.String.format(r13, r0);
        r14 = new com.neovisionaries.ws.client.FormatException;
        r14.<init>(r13);
        throw r14;
    L_0x003f:
        r6 = 24577; // 0x6001 float:3.444E-41 double:1.21427E-319;
        goto L_0x0044;
    L_0x0042:
        r6 = 16385; // 0x4001 float:2.296E-41 double:8.0953E-320;
    L_0x0044:
        r0 = 13;
        goto L_0x00a4;
    L_0x0048:
        r6 = 12289; // 0x3001 float:1.722E-41 double:6.0716E-320;
        goto L_0x004d;
    L_0x004b:
        r6 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
    L_0x004d:
        r0 = 12;
        goto L_0x00a4;
    L_0x0051:
        r6 = 6145; // 0x1801 float:8.611E-42 double:3.036E-320;
        goto L_0x0056;
    L_0x0054:
        r6 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
    L_0x0056:
        r0 = 11;
        goto L_0x00a4;
    L_0x0059:
        r6 = 3073; // 0xc01 float:4.306E-42 double:1.5183E-320;
        goto L_0x005e;
    L_0x005c:
        r6 = 2049; // 0x801 float:2.871E-42 double:1.0123E-320;
    L_0x005e:
        r0 = 10;
        goto L_0x00a4;
    L_0x0061:
        r6 = 1537; // 0x601 float:2.154E-42 double:7.594E-321;
        goto L_0x0066;
    L_0x0064:
        r6 = 1025; // 0x401 float:1.436E-42 double:5.064E-321;
    L_0x0066:
        r0 = 9;
        goto L_0x00a4;
    L_0x0069:
        r6 = 769; // 0x301 float:1.078E-42 double:3.8E-321;
        goto L_0x006e;
    L_0x006c:
        r6 = 513; // 0x201 float:7.19E-43 double:2.535E-321;
    L_0x006e:
        r0 = 8;
        goto L_0x00a4;
    L_0x0071:
        r6 = 385; // 0x181 float:5.4E-43 double:1.9E-321;
        goto L_0x0076;
    L_0x0074:
        r6 = 257; // 0x101 float:3.6E-43 double:1.27E-321;
    L_0x0076:
        r0 = 7;
        goto L_0x00a4;
    L_0x0078:
        r6 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
        goto L_0x007d;
    L_0x007b:
        r6 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
    L_0x007d:
        r0 = 6;
        goto L_0x00a4;
    L_0x007f:
        r15 = 97;
        r0 = 5;
        r6 = 97;
        goto L_0x00a4;
    L_0x0085:
        r15 = 65;
        r0 = 5;
        r6 = 65;
        goto L_0x00a4;
    L_0x008b:
        r6 = 49;
        goto L_0x00a4;
    L_0x008e:
        r6 = 33;
        goto L_0x00a4;
    L_0x0091:
        r6 = 25;
        goto L_0x0096;
    L_0x0094:
        r6 = 17;
    L_0x0096:
        r0 = 3;
        goto L_0x00a4;
    L_0x0098:
        r0 = 2;
        r6 = 13;
        goto L_0x00a4;
    L_0x009c:
        r0 = 2;
        r6 = 9;
        goto L_0x00a4;
    L_0x00a0:
        r0 = 1;
        r6 = 7;
        goto L_0x00a4;
    L_0x00a3:
        r0 = 1;
    L_0x00a4:
        r13 = r13.c(r14, r0);
        r6 = r6 + r13;
        return r6;
    L_0x00aa:
        r15 = r15 + r12;
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.g.a(com.neovisionaries.ws.client.c, int[], com.neovisionaries.ws.client.n):int");
    }
}
