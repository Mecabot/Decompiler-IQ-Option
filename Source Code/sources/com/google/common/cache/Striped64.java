package com.google.common.cache;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number {
    static final ThreadLocal<int[]> Pg = new ThreadLocal();
    static final Random Ph = new Random();
    static final int Pi = Runtime.getRuntime().availableProcessors();
    private static final Unsafe Pm;
    private static final long Pn;
    private static final long Po;
    volatile transient a[] Pj;
    volatile transient long Pk;
    volatile transient int Pl;

    static final class a {
        private static final Unsafe Pm;
        private static final long Pp;
        volatile long value;

        a(long j) {
            this.value = j;
        }

        final boolean f(long j, long j2) {
            return Pm.compareAndSwapLong(this, Pp, j, j2);
        }

        static {
            try {
                Pm = Striped64.getUnsafe();
                Pp = Pm.objectFieldOffset(a.class.getDeclaredField(b.VALUE));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
    }

    abstract long d(long j, long j2);

    static {
        try {
            Pm = getUnsafe();
            Class cls = Striped64.class;
            Pn = Pm.objectFieldOffset(cls.getDeclaredField("base"));
            Po = Pm.objectFieldOffset(cls.getDeclaredField("busy"));
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    final boolean e(long j, long j2) {
        return Pm.compareAndSwapLong(this, Pn, j, j2);
    }

    final boolean rt() {
        return Pm.compareAndSwapInt(this, Po, 0, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0027 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0107 A:{SYNTHETIC} */
    /* JADX WARNING: Missing block: B:53:0x0093, code:
            if (r1.Pj != r10) goto L_0x00aa;
     */
    /* JADX WARNING: Missing block: B:56:?, code:
            r5 = new com.google.common.cache.Striped64.a[(r11 << 1)];
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:57:0x009a, code:
            if (r6 >= r11) goto L_0x00a3;
     */
    /* JADX WARNING: Missing block: B:58:0x009c, code:
            r5[r6] = r10[r6];
            r6 = r6 + 1;
     */
    /* JADX WARNING: Missing block: B:59:0x00a3, code:
            r1.Pj = r5;
     */
    /* JADX WARNING: Missing block: B:60:0x00a6, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:61:0x00a7, code:
            r2 = r0;
            r5 = 0;
     */
    /* JADX WARNING: Missing block: B:65:0x00b4, code:
            r1.Pl = r5;
     */
    /* JADX WARNING: Missing block: B:66:0x00b6, code:
            throw r2;
     */
    final void a(long r18, int[] r20, boolean r21) {
        /*
        r17 = this;
        r1 = r17;
        r2 = r18;
        r5 = 1;
        r6 = 0;
        if (r20 != 0) goto L_0x0020;
    L_0x0008:
        r4 = Pg;
        r7 = new int[r5];
        r4.set(r7);
        r4 = Ph;
        r4 = r4.nextInt();
        if (r4 != 0) goto L_0x0018;
    L_0x0017:
        r4 = 1;
    L_0x0018:
        r7[r6] = r4;
        r16 = r7;
        r7 = r4;
        r4 = r16;
        goto L_0x0024;
    L_0x0020:
        r7 = r20[r6];
        r4 = r20;
    L_0x0024:
        r8 = r21;
    L_0x0026:
        r9 = 0;
    L_0x0027:
        r10 = r1.Pj;
        if (r10 == 0) goto L_0x00c6;
    L_0x002b:
        r11 = r10.length;
        if (r11 <= 0) goto L_0x00c6;
    L_0x002e:
        r12 = r11 + -1;
        r12 = r12 & r7;
        r12 = r10[r12];
        if (r12 != 0) goto L_0x0068;
    L_0x0035:
        r10 = r1.Pl;
        if (r10 != 0) goto L_0x0066;
    L_0x0039:
        r10 = new com.google.common.cache.Striped64$a;
        r10.<init>(r2);
        r11 = r1.Pl;
        if (r11 != 0) goto L_0x0066;
    L_0x0042:
        r11 = r17.rt();
        if (r11 == 0) goto L_0x0066;
    L_0x0048:
        r11 = r1.Pj;	 Catch:{ all -> 0x0061 }
        if (r11 == 0) goto L_0x005a;
    L_0x004c:
        r12 = r11.length;	 Catch:{ all -> 0x0061 }
        if (r12 <= 0) goto L_0x005a;
    L_0x004f:
        r12 = r12 + -1;
        r12 = r12 & r7;
        r13 = r11[r12];	 Catch:{ all -> 0x0061 }
        if (r13 != 0) goto L_0x005a;
    L_0x0056:
        r11[r12] = r10;	 Catch:{ all -> 0x0061 }
        r10 = 1;
        goto L_0x005b;
    L_0x005a:
        r10 = 0;
    L_0x005b:
        r1.Pl = r6;
        if (r10 == 0) goto L_0x0027;
    L_0x005f:
        goto L_0x0107;
    L_0x0061:
        r0 = move-exception;
        r2 = r0;
        r1.Pl = r6;
        throw r2;
    L_0x0066:
        r9 = 0;
        goto L_0x00b7;
    L_0x0068:
        if (r8 != 0) goto L_0x006c;
    L_0x006a:
        r8 = 1;
        goto L_0x00b7;
    L_0x006c:
        r13 = r12.value;
        r5 = r1.d(r13, r2);
        r5 = r12.f(r13, r5);
        if (r5 == 0) goto L_0x007a;
    L_0x0078:
        goto L_0x0107;
    L_0x007a:
        r5 = Pi;
        if (r11 >= r5) goto L_0x0066;
    L_0x007e:
        r5 = r1.Pj;
        if (r5 == r10) goto L_0x0083;
    L_0x0082:
        goto L_0x0066;
    L_0x0083:
        if (r9 != 0) goto L_0x0087;
    L_0x0085:
        r9 = 1;
        goto L_0x00b7;
    L_0x0087:
        r5 = r1.Pl;
        if (r5 != 0) goto L_0x00b7;
    L_0x008b:
        r5 = r17.rt();
        if (r5 == 0) goto L_0x00b7;
    L_0x0091:
        r5 = r1.Pj;	 Catch:{ all -> 0x00b1 }
        if (r5 != r10) goto L_0x00aa;
    L_0x0095:
        r5 = r11 << 1;
        r5 = new com.google.common.cache.Striped64.a[r5];	 Catch:{ all -> 0x00a6 }
        r6 = 0;
    L_0x009a:
        if (r6 >= r11) goto L_0x00a3;
    L_0x009c:
        r9 = r10[r6];	 Catch:{ all -> 0x00a6 }
        r5[r6] = r9;	 Catch:{ all -> 0x00a6 }
        r6 = r6 + 1;
        goto L_0x009a;
    L_0x00a3:
        r1.Pj = r5;	 Catch:{ all -> 0x00a6 }
        goto L_0x00aa;
    L_0x00a6:
        r0 = move-exception;
        r2 = r0;
        r5 = 0;
        goto L_0x00b4;
    L_0x00aa:
        r5 = 0;
        r1.Pl = r5;
        r5 = 1;
        r6 = 0;
        goto L_0x0026;
    L_0x00b1:
        r0 = move-exception;
        r5 = 0;
        r2 = r0;
    L_0x00b4:
        r1.Pl = r5;
        throw r2;
    L_0x00b7:
        r5 = r7 << 13;
        r5 = r5 ^ r7;
        r6 = r5 >>> 17;
        r5 = r5 ^ r6;
        r6 = r5 << 5;
        r5 = r5 ^ r6;
        r6 = 0;
        r4[r6] = r5;
        r7 = r5;
        r5 = 0;
        goto L_0x0108;
    L_0x00c6:
        r5 = r1.Pl;
        if (r5 != 0) goto L_0x00fa;
    L_0x00ca:
        r5 = r1.Pj;
        if (r5 != r10) goto L_0x00fa;
    L_0x00ce:
        r5 = r17.rt();
        if (r5 == 0) goto L_0x00fa;
    L_0x00d4:
        r5 = r1.Pj;	 Catch:{ all -> 0x00f4 }
        if (r5 != r10) goto L_0x00ed;
    L_0x00d8:
        r5 = 2;
        r5 = new com.google.common.cache.Striped64.a[r5];	 Catch:{ all -> 0x00e9 }
        r6 = r7 & 1;
        r10 = new com.google.common.cache.Striped64$a;	 Catch:{ all -> 0x00e9 }
        r10.<init>(r2);	 Catch:{ all -> 0x00e9 }
        r5[r6] = r10;	 Catch:{ all -> 0x00e9 }
        r1.Pj = r5;	 Catch:{ all -> 0x00e9 }
        r5 = 0;
        r15 = 1;
        goto L_0x00ef;
    L_0x00e9:
        r0 = move-exception;
        r2 = r0;
        r5 = 0;
        goto L_0x00f7;
    L_0x00ed:
        r5 = 0;
        r15 = 0;
    L_0x00ef:
        r1.Pl = r5;
        if (r15 == 0) goto L_0x0108;
    L_0x00f3:
        goto L_0x0107;
    L_0x00f4:
        r0 = move-exception;
        r5 = 0;
        r2 = r0;
    L_0x00f7:
        r1.Pl = r5;
        throw r2;
    L_0x00fa:
        r5 = 0;
        r10 = r1.Pk;
        r12 = r1.d(r10, r2);
        r6 = r1.e(r10, r12);
        if (r6 == 0) goto L_0x0108;
    L_0x0107:
        return;
    L_0x0108:
        r5 = 1;
        r6 = 0;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.a(long, int[], boolean):void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:5:0x0010, code:
            return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.cache.Striped64.AnonymousClass1());
     */
    /* JADX WARNING: Missing block: B:6:0x0011, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x001d, code:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
     */
    private static sun.misc.Unsafe getUnsafe() {
        /*
        r0 = sun.misc.Unsafe.getUnsafe();	 Catch:{ SecurityException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new com.google.common.cache.Striped64$1;	 Catch:{ PrivilegedActionException -> 0x0011 }
        r0.<init>();	 Catch:{ PrivilegedActionException -> 0x0011 }
        r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ PrivilegedActionException -> 0x0011 }
        r0 = (sun.misc.Unsafe) r0;	 Catch:{ PrivilegedActionException -> 0x0011 }
        return r0;
    L_0x0011:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "Could not initialize intrinsics";
        r0 = r0.getCause();
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.getUnsafe():sun.misc.Unsafe");
    }
}
