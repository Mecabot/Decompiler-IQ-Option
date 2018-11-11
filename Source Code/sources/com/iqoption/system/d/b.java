package com.iqoption.system.d;

/* compiled from: SntpClient */
public class b {
    private static final String TAG = "com.iqoption.system.d.b";
    private long dsj;
    private long dsk;
    private boolean dsl = false;

    private int c(byte b) {
        return b & 255;
    }

    private double cb(long j) {
        return ((double) j) / 65.536d;
    }

    public static long e(long[] jArr) {
        return ((jArr[1] - jArr[0]) + (jArr[2] - jArr[3])) / 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a9  */
    long[] N(java.lang.String r25, int r26) {
        /*
        r24 = this;
        r1 = r24;
        r2 = r25;
        r3 = 48;
        r4 = 0;
        r3 = new byte[r3];	 Catch:{ Exception -> 0x018e }
        r5 = java.net.InetAddress.getByName(r25);	 Catch:{ Exception -> 0x018e }
        r6 = new java.net.DatagramPacket;	 Catch:{ Exception -> 0x018e }
        r7 = r3.length;	 Catch:{ Exception -> 0x018e }
        r8 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r6.<init>(r3, r7, r5, r8);	 Catch:{ Exception -> 0x018e }
        r1.r(r3);	 Catch:{ Exception -> 0x018e }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x018e }
        r9 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x018e }
        r5 = 40;
        r1.a(r3, r5, r7);	 Catch:{ Exception -> 0x018e }
        r11 = new java.net.DatagramSocket;	 Catch:{ Exception -> 0x018e }
        r11.<init>();	 Catch:{ Exception -> 0x018e }
        r12 = r26;
        r11.setSoTimeout(r12);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r11.send(r6);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = 8;
        r6 = new long[r4];	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r12 = new java.net.DatagramPacket;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r13 = r3.length;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r12.<init>(r3, r13);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r11.receive(r12);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r14 = 7;
        r6[r14] = r12;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r15 = 24;
        r15 = r1.h(r3, r15);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r14 = 32;
        r17 = r1.h(r3, r14);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r19 = r1.h(r3, r5);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = 0;
        r21 = r12 - r9;
        r9 = r7 + r21;
        r5 = 0;
        r6[r5] = r15;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r7 = 1;
        r6[r7] = r17;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r8 = 2;
        r6[r8] = r19;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r8 = 3;
        r6[r8] = r9;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r12 = 4;
        r13 = r1.i(r3, r12);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6[r12] = r13;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r13 = r6[r12];	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r13 = r1.cb(r13);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r21 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r23 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1));
        if (r23 <= 0) goto L_0x0091;
    L_0x007a:
        r3 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = "Invalid response from NTP server. Root delay violation ";
        r4.append(r5);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.append(r13);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r3;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x0091:
        r13 = r1.i(r3, r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = 5;
        r6[r4] = r13;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r13 = r6[r4];	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r13 = r1.cb(r13);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r23 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1));
        if (r23 <= 0) goto L_0x00b9;
    L_0x00a2:
        r3 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = "Invalid response from NTP server. Root dispersion violation ";
        r4.append(r5);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.append(r13);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r3;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x00b9:
        r13 = r3[r5];	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r14 = 7;
        r13 = r13 & r14;
        r13 = (byte) r13;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        if (r13 == r12) goto L_0x00da;
    L_0x00c0:
        if (r13 == r4) goto L_0x00da;
    L_0x00c2:
        r3 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = "untrusted mode value for NtpTime: ";
        r4.append(r5);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.append(r13);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r3;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x00da:
        r4 = r3[r7];	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = r4 & 255;
        r12 = (long) r4;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r14 = 6;
        r6[r14] = r12;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        if (r4 < r7) goto L_0x016b;
    L_0x00e4:
        r12 = 15;
        if (r4 <= r12) goto L_0x00ea;
    L_0x00e8:
        goto L_0x016b;
    L_0x00ea:
        r3 = r3[r5];	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3 = r3 >> r14;
        r3 = r3 & r8;
        r3 = (byte) r3;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        if (r3 != r8) goto L_0x00fa;
    L_0x00f1:
        r3 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = "unsynchronized server responded for NtpTime";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r3;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x00fa:
        r3 = 0;
        r3 = r9 - r15;
        r8 = r19 - r17;
        r12 = r3 - r8;
        r3 = java.lang.Math.abs(r12);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r8 = 100;
        r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x0122;
    L_0x010b:
        r5 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r7 = "Server response delay too large for comfort ";
        r6.append(r7);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6.append(r3);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3 = r6.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5.<init>(r3);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r5;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x0122:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = 0;
        r8 = r15 - r3;
        r3 = java.lang.Math.abs(r8);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r8 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r5 < 0) goto L_0x014a;
    L_0x0133:
        r5 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r7 = "Request was sent more than 10 seconds back ";
        r6.append(r7);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6.append(r3);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3 = r6.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5.<init>(r3);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r5;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x014a:
        r1.dsl = r7;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3 = TAG;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = "---- SNTP successful response from ";
        r4.append(r5);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4.append(r2);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        com.iqoption.core.i.i(r3, r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r1.f(r6);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        if (r11 == 0) goto L_0x016a;
    L_0x0167:
        r11.close();
    L_0x016a:
        return r6;
    L_0x016b:
        r3 = new java.io.IOException;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5.<init>();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r6 = "untrusted stratum value for NtpTime: ";
        r5.append(r6);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r5.append(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r4 = r5.toString();	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
        throw r3;	 Catch:{ Exception -> 0x0186, all -> 0x0183 }
    L_0x0183:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01a7;
    L_0x0186:
        r0 = move-exception;
        r3 = r0;
        r4 = r11;
        goto L_0x0190;
    L_0x018a:
        r0 = move-exception;
        r2 = r0;
        r11 = r4;
        goto L_0x01a7;
    L_0x018e:
        r0 = move-exception;
        r3 = r0;
    L_0x0190:
        r5 = TAG;	 Catch:{ all -> 0x018a }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x018a }
        r6.<init>();	 Catch:{ all -> 0x018a }
        r7 = "---- SNTP request failed for ";
        r6.append(r7);	 Catch:{ all -> 0x018a }
        r6.append(r2);	 Catch:{ all -> 0x018a }
        r2 = r6.toString();	 Catch:{ all -> 0x018a }
        com.iqoption.core.i.d(r5, r2);	 Catch:{ all -> 0x018a }
        throw r3;	 Catch:{ all -> 0x018a }
    L_0x01a7:
        if (r11 == 0) goto L_0x01ac;
    L_0x01a9:
        r11.close();
    L_0x01ac:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.system.d.b.N(java.lang.String, int):long[]");
    }

    void f(long[] jArr) {
        this.dsk = g(jArr);
        this.dsj = jArr[7];
    }

    long g(long[] jArr) {
        return jArr[3] + e(jArr);
    }

    boolean aEz() {
        return this.dsl;
    }

    long aEA() {
        return this.dsk;
    }

    long aEB() {
        return this.dsj;
    }

    private void r(byte[] bArr) {
        bArr[0] = (byte) 27;
    }

    private void a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 24));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> 16));
        i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 8));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> null));
        j3 = (j3 * 4294967296L) / 1000;
        i2 = i + 1;
        bArr[i] = (byte) ((int) (j3 >> 24));
        i = i2 + 1;
        bArr[i2] = (byte) ((int) (j3 >> 16));
        i2 = i + 1;
        bArr[i] = (byte) ((int) (j3 >> 8));
        bArr[i2] = (byte) ((int) (Math.random() * 255.0d));
    }

    private long h(byte[] bArr, int i) {
        return ((i(bArr, i) - 2208988800L) * 1000) + ((i(bArr, i + 4) * 1000) / 4294967296L);
    }

    private long i(byte[] bArr, int i) {
        return (((((long) c(bArr[i])) << 24) + (((long) c(bArr[i + 1])) << 16)) + (((long) c(bArr[i + 2])) << 8)) + ((long) c(bArr[i + 3]));
    }
}
