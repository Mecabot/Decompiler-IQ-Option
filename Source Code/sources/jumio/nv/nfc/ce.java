package jumio.nv.nfc;

/* compiled from: TagTreeDecoder */
public class ce {
    protected int a;
    protected int b;
    protected int c;
    protected int[][] d;
    protected int[][] e;

    public ce(int i, int i2) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException();
        }
        this.a = i2;
        this.b = i;
        int i3 = 0;
        if (i2 != 0 && i != 0) {
            this.c = 1;
            while (true) {
                if (i == 1 && i2 == 1) {
                    break;
                }
                i2 = (i2 + 1) >> 1;
                i = (i + 1) >> 1;
                this.c++;
            }
        } else {
            this.c = 0;
        }
        this.d = new int[this.c][];
        this.e = new int[this.c][];
        i = this.a;
        i2 = this.b;
        while (i3 < this.c) {
            int i4 = i2 * i;
            this.d[i3] = new int[i4];
            dq.a(this.d[i3], ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.e[i3] = new int[i4];
            i = (i + 1) >> 1;
            i2 = (i2 + 1) >> 1;
            i3++;
        }
    }

    /* JADX WARNING: Missing block: B:7:0x0030, code:
            if (r4 < r2) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:8:0x0033, code:
            r2 = r4;
     */
    /* JADX WARNING: Missing block: B:9:0x0034, code:
            if (r9 <= r2) goto L_0x0046;
     */
    /* JADX WARNING: Missing block: B:10:0x0036, code:
            if (r5 < r2) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:12:0x003c, code:
            if (r10.a() != 0) goto L_0x0041;
     */
    /* JADX WARNING: Missing block: B:13:0x003e, code:
            r2 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:14:0x0041, code:
            r4 = r2 + 1;
            r5 = r2;
     */
    /* JADX WARNING: Missing block: B:15:0x0045, code:
            r2 = r9;
     */
    /* JADX WARNING: Missing block: B:16:0x0046, code:
            r6.e[r0][r3] = r2;
            r6.d[r0][r3] = r5;
     */
    /* JADX WARNING: Missing block: B:17:0x0052, code:
            if (r0 <= 0) goto L_0x0069;
     */
    /* JADX WARNING: Missing block: B:18:0x0054, code:
            if (r2 >= r5) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:19:0x0057, code:
            r2 = r5;
     */
    /* JADX WARNING: Missing block: B:21:0x0069, code:
            return r5;
     */
    public int a(int r7, int r8, int r9, jumio.nv.nfc.cd r10) {
        /*
        r6 = this;
        r0 = r6.b;
        if (r7 >= r0) goto L_0x006a;
    L_0x0004:
        r0 = r6.a;
        if (r8 >= r0) goto L_0x006a;
    L_0x0008:
        if (r9 >= 0) goto L_0x000b;
    L_0x000a:
        goto L_0x006a;
    L_0x000b:
        r0 = r6.c;
        r1 = 1;
        r0 = r0 - r1;
        r2 = r6.e;
        r2 = r2[r0];
        r3 = 0;
        r2 = r2[r3];
        r3 = r7 >> r0;
        r4 = r6.a;
        r5 = r1 << r0;
        r4 = r4 + r5;
        r4 = r4 - r1;
        r4 = r4 >> r0;
        r3 = r3 * r4;
        r4 = r8 >> r0;
        r3 = r3 + r4;
    L_0x0024:
        r4 = r6.e;
        r4 = r4[r0];
        r4 = r4[r3];
        r5 = r6.d;
        r5 = r5[r0];
        r5 = r5[r3];
        if (r4 >= r2) goto L_0x0033;
    L_0x0032:
        goto L_0x0034;
    L_0x0033:
        r2 = r4;
    L_0x0034:
        if (r9 <= r2) goto L_0x0046;
    L_0x0036:
        if (r5 < r2) goto L_0x0045;
    L_0x0038:
        r4 = r10.a();
        if (r4 != 0) goto L_0x0041;
    L_0x003e:
        r2 = r2 + 1;
        goto L_0x0034;
    L_0x0041:
        r4 = r2 + 1;
        r5 = r2;
        goto L_0x0033;
    L_0x0045:
        r2 = r9;
    L_0x0046:
        r4 = r6.e;
        r4 = r4[r0];
        r4[r3] = r2;
        r4 = r6.d;
        r4 = r4[r0];
        r4[r3] = r5;
        if (r0 <= 0) goto L_0x0069;
    L_0x0054:
        if (r2 >= r5) goto L_0x0057;
    L_0x0056:
        goto L_0x0058;
    L_0x0057:
        r2 = r5;
    L_0x0058:
        r0 = r0 + -1;
        r3 = r7 >> r0;
        r4 = r6.a;
        r5 = r1 << r0;
        r4 = r4 + r5;
        r4 = r4 - r1;
        r4 = r4 >> r0;
        r3 = r3 * r4;
        r4 = r8 >> r0;
        r3 = r3 + r4;
        goto L_0x0024;
    L_0x0069:
        return r5;
    L_0x006a:
        r7 = new java.lang.IllegalArgumentException;
        r7.<init>();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.nfc.ce.a(int, int, int, jumio.nv.nfc.cd):int");
    }
}
