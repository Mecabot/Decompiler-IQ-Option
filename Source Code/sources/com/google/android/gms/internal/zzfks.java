package com.google.android.gms.internal;

final class zzfks {
    private static final zzfkt zzptx;

    static {
        Object obj = (zzfkq.zzdcd() && zzfkq.zzdce()) ? 1 : null;
        zzptx = obj != null ? new zzfkw() : new zzfku();
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzptx.zzb(charSequence, bArr, i, i2);
    }

    private static int zzam(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : i ^ (i2 << 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    static int zzd(java.lang.CharSequence r8) {
        /*
        r0 = r8.length();
        r1 = 0;
        r2 = 0;
    L_0x0006:
        if (r2 >= r0) goto L_0x0013;
    L_0x0008:
        r3 = r8.charAt(r2);
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r3 >= r4) goto L_0x0013;
    L_0x0010:
        r2 = r2 + 1;
        goto L_0x0006;
    L_0x0013:
        r3 = r0;
    L_0x0014:
        if (r2 >= r0) goto L_0x0058;
    L_0x0016:
        r4 = r8.charAt(r2);
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        if (r4 >= r5) goto L_0x0026;
    L_0x001e:
        r4 = 127 - r4;
        r4 = r4 >>> 31;
        r3 = r3 + r4;
        r2 = r2 + 1;
        goto L_0x0014;
    L_0x0026:
        r4 = r8.length();
    L_0x002a:
        if (r2 >= r4) goto L_0x0057;
    L_0x002c:
        r6 = r8.charAt(r2);
        if (r6 >= r5) goto L_0x0038;
    L_0x0032:
        r6 = 127 - r6;
        r6 = r6 >>> 31;
        r1 = r1 + r6;
        goto L_0x0054;
    L_0x0038:
        r1 = r1 + 2;
        r7 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r7 > r6) goto L_0x0054;
    L_0x003f:
        r7 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r6 > r7) goto L_0x0054;
    L_0x0044:
        r6 = java.lang.Character.codePointAt(r8, r2);
        r7 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r6 >= r7) goto L_0x0052;
    L_0x004c:
        r8 = new com.google.android.gms.internal.zzfkv;
        r8.<init>(r2, r4);
        throw r8;
    L_0x0052:
        r2 = r2 + 1;
    L_0x0054:
        r2 = r2 + 1;
        goto L_0x002a;
    L_0x0057:
        r3 = r3 + r1;
    L_0x0058:
        if (r3 >= r0) goto L_0x007b;
    L_0x005a:
        r8 = new java.lang.IllegalArgumentException;
        r0 = (long) r3;
        r2 = 4294967296; // 0x100000000 float:0.0 double:2.121995791E-314;
        r4 = r0 + r2;
        r0 = 54;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "UTF-8 length does not fit in int: ";
        r1.append(r0);
        r1.append(r4);
        r0 = r1.toString();
        r8.<init>(r0);
        throw r8;
    L_0x007b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfks.zzd(java.lang.CharSequence):int");
    }

    private static int zzi(int i, int i2, int i3) {
        return (i > -12 || i2 > -65 || i3 > -65) ? -1 : (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean zzl(byte[] bArr, int i, int i2) {
        return zzptx.zzb(0, bArr, i, i2) == 0;
    }

    private static int zzm(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzmu(b);
            case 1:
                return zzam(b, bArr[i]);
            case 2:
                return zzi(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    private static int zzmu(int i) {
        return i > -12 ? -1 : i;
    }
}
