package kotlin.reflect.jvm.internal.impl.protobuf;

/* compiled from: Utf8 */
final class u {
    private static int E(int i, int i2, int i3) {
        return (i > -12 || i2 > -65 || i3 > -65) ? -1 : (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    private static int bi(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : i ^ (i2 << 8);
    }

    private static int lO(int i) {
        return i > -12 ? -1 : i;
    }

    public static boolean ah(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static boolean n(byte[] bArr, int i, int i2) {
        return o(bArr, i, i2) == 0;
    }

    /* JADX WARNING: Missing block: B:8:0x0015, code:
            if (r7[r8] > (byte) -65) goto L_0x0017;
     */
    /* JADX WARNING: Missing block: B:27:0x0042, code:
            if (r7[r8] > (byte) -65) goto L_0x0044;
     */
    /* JADX WARNING: Missing block: B:47:0x007a, code:
            if (r7[r6] > (byte) -65) goto L_0x007c;
     */
    public static int f(int r6, byte[] r7, int r8, int r9) {
        /*
        if (r6 == 0) goto L_0x007d;
    L_0x0002:
        if (r8 < r9) goto L_0x0005;
    L_0x0004:
        return r6;
    L_0x0005:
        r0 = (byte) r6;
        r1 = -32;
        r2 = -1;
        r3 = -65;
        if (r0 >= r1) goto L_0x0018;
    L_0x000d:
        r6 = -62;
        if (r0 < r6) goto L_0x0017;
    L_0x0011:
        r6 = r8 + 1;
        r8 = r7[r8];
        if (r8 <= r3) goto L_0x007e;
    L_0x0017:
        return r2;
    L_0x0018:
        r4 = -16;
        if (r0 >= r4) goto L_0x0045;
    L_0x001c:
        r6 = r6 >> 8;
        r6 = r6 ^ r2;
        r6 = (byte) r6;
        if (r6 != 0) goto L_0x0030;
    L_0x0022:
        r6 = r8 + 1;
        r8 = r7[r8];
        if (r6 < r9) goto L_0x002d;
    L_0x0028:
        r6 = bi(r0, r8);
        return r6;
    L_0x002d:
        r5 = r8;
        r8 = r6;
        r6 = r5;
    L_0x0030:
        if (r6 > r3) goto L_0x0044;
    L_0x0032:
        r4 = -96;
        if (r0 != r1) goto L_0x0038;
    L_0x0036:
        if (r6 < r4) goto L_0x0044;
    L_0x0038:
        r1 = -19;
        if (r0 != r1) goto L_0x003e;
    L_0x003c:
        if (r6 >= r4) goto L_0x0044;
    L_0x003e:
        r6 = r8 + 1;
        r8 = r7[r8];
        if (r8 <= r3) goto L_0x007e;
    L_0x0044:
        return r2;
    L_0x0045:
        r1 = r6 >> 8;
        r1 = r1 ^ r2;
        r1 = (byte) r1;
        r4 = 0;
        if (r1 != 0) goto L_0x0057;
    L_0x004c:
        r6 = r8 + 1;
        r1 = r7[r8];
        if (r6 < r9) goto L_0x005b;
    L_0x0052:
        r6 = bi(r0, r1);
        return r6;
    L_0x0057:
        r6 = r6 >> 16;
        r4 = (byte) r6;
        r6 = r8;
    L_0x005b:
        if (r4 != 0) goto L_0x0069;
    L_0x005d:
        r8 = r6 + 1;
        r4 = r7[r6];
        if (r8 < r9) goto L_0x0068;
    L_0x0063:
        r6 = E(r0, r1, r4);
        return r6;
    L_0x0068:
        r6 = r8;
    L_0x0069:
        if (r1 > r3) goto L_0x007c;
    L_0x006b:
        r8 = r0 << 28;
        r1 = r1 + 112;
        r8 = r8 + r1;
        r8 = r8 >> 30;
        if (r8 != 0) goto L_0x007c;
    L_0x0074:
        if (r4 > r3) goto L_0x007c;
    L_0x0076:
        r8 = r6 + 1;
        r6 = r7[r6];
        if (r6 <= r3) goto L_0x007d;
    L_0x007c:
        return r2;
    L_0x007d:
        r6 = r8;
    L_0x007e:
        r6 = o(r7, r6, r9);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.u.f(int, byte[], int, int):int");
    }

    public static int o(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] >= (byte) 0) {
            i++;
        }
        if (i >= i2) {
            return 0;
        }
        return p(bArr, i, i2);
    }

    private static int p(byte[] bArr, int i, int i2) {
        while (i < i2) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b < (byte) 0) {
                byte b2;
                if (b < (byte) -32) {
                    if (i3 >= i2) {
                        return b;
                    }
                    if (b >= (byte) -62) {
                        i = i3 + 1;
                        if (bArr[i3] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (b < (byte) -16) {
                    if (i3 >= i2 - 1) {
                        return q(bArr, i3, i2);
                    }
                    int i4 = i3 + 1;
                    b2 = bArr[i3];
                    if (b2 <= (byte) -65 && ((b != (byte) -32 || b2 >= (byte) -96) && (b != (byte) -19 || b2 < (byte) -96))) {
                        i = i4 + 1;
                        if (bArr[i4] > (byte) -65) {
                        }
                    }
                    return -1;
                } else if (i3 >= i2 - 2) {
                    return q(bArr, i3, i2);
                } else {
                    int i5 = i3 + 1;
                    b2 = bArr[i3];
                    if (b2 <= (byte) -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                        i = i5 + 1;
                        if (bArr[i5] <= (byte) -65) {
                            i3 = i + 1;
                            if (bArr[i] > (byte) -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            i = i3;
        }
        return 0;
    }

    private static int q(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return lO(b);
            case 1:
                return bi(b, bArr[i]);
            case 2:
                return E(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }
}
