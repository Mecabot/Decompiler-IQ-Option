package com.google.common.io;

/* compiled from: LineBuffer */
abstract class h {
    private StringBuilder Uw = new StringBuilder();
    private boolean Ux;

    protected abstract void O(String str, String str2);

    h() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    protected void b(char[] r7, int r8, int r9) {
        /*
        r6 = this;
        r0 = r6.Ux;
        r1 = 0;
        r2 = 10;
        r3 = 1;
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        if (r9 <= 0) goto L_0x001a;
    L_0x000a:
        r0 = r7[r8];
        if (r0 != r2) goto L_0x0010;
    L_0x000e:
        r0 = 1;
        goto L_0x0011;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        r0 = r6.ad(r0);
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0 = r8 + 1;
        goto L_0x001b;
    L_0x001a:
        r0 = r8;
    L_0x001b:
        r8 = r8 + r9;
        r9 = r0;
    L_0x001d:
        if (r0 >= r8) goto L_0x0054;
    L_0x001f:
        r4 = r7[r0];
        if (r4 == r2) goto L_0x0046;
    L_0x0023:
        r5 = 13;
        if (r4 == r5) goto L_0x0028;
    L_0x0027:
        goto L_0x0052;
    L_0x0028:
        r4 = r6.Uw;
        r5 = r0 - r9;
        r4.append(r7, r9, r5);
        r6.Ux = r3;
        r9 = r0 + 1;
        if (r9 >= r8) goto L_0x0043;
    L_0x0035:
        r4 = r7[r9];
        if (r4 != r2) goto L_0x003b;
    L_0x0039:
        r4 = 1;
        goto L_0x003c;
    L_0x003b:
        r4 = 0;
    L_0x003c:
        r4 = r6.ad(r4);
        if (r4 == 0) goto L_0x0043;
    L_0x0042:
        r0 = r9;
    L_0x0043:
        r9 = r0 + 1;
        goto L_0x0052;
    L_0x0046:
        r4 = r6.Uw;
        r5 = r0 - r9;
        r4.append(r7, r9, r5);
        r6.ad(r3);
        r9 = r0 + 1;
    L_0x0052:
        r0 = r0 + r3;
        goto L_0x001d;
    L_0x0054:
        r0 = r6.Uw;
        r8 = r8 - r9;
        r0.append(r7, r9, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.h.b(char[], int, int):void");
    }

    private boolean ad(boolean z) {
        String str = this.Ux ? z ? "\r\n" : "\r" : z ? "\n" : "";
        O(this.Uw.toString(), str);
        this.Uw = new StringBuilder();
        this.Ux = false;
        return z;
    }

    protected void finish() {
        if (this.Ux || this.Uw.length() > 0) {
            ad(false);
        }
    }
}
