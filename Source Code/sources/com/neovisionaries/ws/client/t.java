package com.neovisionaries.ws.client;

import java.util.Map.Entry;

/* compiled from: PerMessageDeflateExtension */
class t extends s {
    private static final byte[] dZT = new byte[]{(byte) 0, (byte) 0, (byte) -1, (byte) -1};
    private boolean dZU;
    private boolean dZV;
    private int dZW = 32768;
    private int dZX = 32768;
    private int dZY;
    private c dZZ;

    public t() {
        super("permessage-deflate");
    }

    public t(String str) {
        super(str);
    }

    void validate() {
        for (Entry entry : getParameters().entrySet()) {
            aL((String) entry.getKey(), (String) entry.getValue());
        }
        this.dZY = this.dZW + 1024;
    }

    private void aL(String str, String str2) {
        if ("server_no_context_takeover".equals(str)) {
            this.dZU = true;
        } else if ("client_no_context_takeover".equals(str)) {
            this.dZV = true;
        } else if ("server_max_window_bits".equals(str)) {
            this.dZW = aM(str, str2);
        } else if ("client_max_window_bits".equals(str)) {
            this.dZX = aM(str, str2);
        } else {
            WebSocketError webSocketError = WebSocketError.PERMESSAGE_DEFLATE_UNSUPPORTED_PARAMETER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("permessage-deflate extension contains an unsupported parameter: ");
            stringBuilder.append(str);
            throw new WebSocketException(webSocketError, stringBuilder.toString());
        }
    }

    private int aM(String str, String str2) {
        int aN = aN(str, str2);
        int i = 256;
        for (int i2 = 8; i2 < aN; i2++) {
            i *= 2;
        }
        return i;
    }

    private int aN(String str, String str2) {
        int kN = kN(str2);
        if (kN >= 0) {
            return kN;
        }
        throw new WebSocketException(WebSocketError.PERMESSAGE_DEFLATE_INVALID_MAX_WINDOW_BITS, String.format("The value of %s parameter of permessage-deflate extension is invalid: %s", new Object[]{str, str2}));
    }

    private int kN(String str) {
        if (str == null) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(str);
            return (parseInt < 8 || 15 < parseInt) ? -1 : parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    protected byte[] x(byte[] bArr) {
        c cVar = new c(bArr.length + dZT.length);
        cVar.s(bArr);
        cVar.s(dZT);
        if (this.dZZ == null) {
            this.dZZ = new c(this.dZY);
        }
        int length = this.dZZ.length();
        try {
            f.a(cVar, this.dZZ);
            bArr = this.dZZ.id(length);
            this.dZZ.ie(this.dZY);
            if (this.dZU) {
                this.dZZ.clear();
            }
            return bArr;
        } catch (Throwable e) {
            throw new WebSocketException(WebSocketError.DECOMPRESSION_ERROR, String.format("Failed to decompress the message: %s", new Object[]{e.getMessage()}), e);
        }
    }

    protected byte[] t(byte[] bArr) {
        if (!y(bArr)) {
            return bArr;
        }
        try {
            return z(e.t(bArr));
        } catch (Throwable e) {
            throw new WebSocketException(WebSocketError.COMPRESSION_ERROR, String.format("Failed to compress the message: %s", new Object[]{e.getMessage()}), e);
        }
    }

    private boolean y(byte[] bArr) {
        return this.dZX == 32768 || bArr.length < this.dZX;
    }

    private static byte[] z(byte[] bArr) {
        c cVar = new c(bArr.length + 1);
        cVar.s(bArr);
        int[] iArr = new int[1];
        boolean[] zArr = new boolean[1];
        while (a(cVar, iArr, zArr)) {
        }
        if (zArr[0]) {
            return cVar.aH(0, (((iArr[0] - 1) / 8) + 1) - 4);
        }
        b(cVar, iArr);
        return cVar.aH(0, ((iArr[0] - 1) / 8) + 1);
    }

    private static void b(c cVar, int[] iArr) {
        int i = iArr[0] % 8;
        if (i != 0) {
            switch (i) {
                case 6:
                case 7:
                    break;
            }
        }
        cVar.ic(0);
        iArr[0] = iArr[0] + 3;
    }

    private static boolean a(com.neovisionaries.ws.client.c r5, int[] r6, boolean[] r7) {
        /*
        r0 = r5.o(r6);
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x0008:
        r3 = r6[r2];
        r3 = r3 - r1;
        r5.if(r3);
    L_0x000e:
        r3 = 2;
        r4 = r5.c(r6, r3);
        switch(r4) {
            case 0: goto L_0x003d;
            case 1: goto L_0x0038;
            case 2: goto L_0x0034;
            default: goto L_0x0016;
        };
    L_0x0016:
        r5 = "[%s] Bad compression type '11' at the bit index '%d'.";
        r7 = new java.lang.Object[r3];
        r0 = com.neovisionaries.ws.client.t.class;
        r0 = r0.getSimpleName();
        r7[r2] = r0;
        r6 = r6[r2];
        r6 = java.lang.Integer.valueOf(r6);
        r7[r1] = r6;
        r5 = java.lang.String.format(r5, r7);
        r6 = new com.neovisionaries.ws.client.FormatException;
        r6.<init>(r5);
        throw r6;
    L_0x0034:
        e(r5, r6);
        goto L_0x003b;
    L_0x0038:
        d(r5, r6);
    L_0x003b:
        r3 = 0;
        goto L_0x0044;
    L_0x003d:
        r3 = c(r5, r6);
        if (r3 != 0) goto L_0x003b;
    L_0x0043:
        r3 = 1;
    L_0x0044:
        r5 = r5.length();
        r6 = r6[r2];
        r6 = r6 / 8;
        if (r5 > r6) goto L_0x004f;
    L_0x004e:
        r0 = 1;
    L_0x004f:
        if (r0 == 0) goto L_0x0055;
    L_0x0051:
        if (r3 == 0) goto L_0x0055;
    L_0x0053:
        r7[r2] = r1;
    L_0x0055:
        if (r0 != 0) goto L_0x0058;
    L_0x0057:
        goto L_0x0059;
    L_0x0058:
        r1 = 0;
    L_0x0059:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.ws.client.t.a(com.neovisionaries.ws.client.c, int[], boolean[]):boolean");
    }

    private static int c(c cVar, int[] iArr) {
        int i = ((iArr[0] + 7) & -8) / 8;
        int i2 = (cVar.get(i) & 255) + ((cVar.get(i + 1) & 255) * 256);
        iArr[0] = ((i + 4) + i2) * 8;
        return i2;
    }

    private static void d(c cVar, int[] iArr) {
        a(cVar, iArr, k.aQk(), j.aQj());
    }

    private static void e(c cVar, int[] iArr) {
        n[] nVarArr = new n[2];
        g.a(cVar, iArr, nVarArr);
        a(cVar, iArr, nVarArr[0], nVarArr[1]);
    }

    private static void a(c cVar, int[] iArr, n nVar, n nVar2) {
        while (true) {
            int a = nVar.a(cVar, iArr);
            if (a != 256) {
                if (a < 0 || a > 255) {
                    g.a(cVar, iArr, a);
                    g.a(cVar, iArr, nVar2);
                }
            } else {
                return;
            }
        }
    }
}
