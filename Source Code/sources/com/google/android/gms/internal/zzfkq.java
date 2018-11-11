package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzfkq {
    private static final Logger logger = Logger.getLogger(zzfkq.class.getName());
    private static final Unsafe zzmdw = zzdcf();
    private static final Class<?> zzpnt = zzfgo.zzcxn();
    private static final boolean zzpop = zzdcg();
    private static final boolean zzptd = zzp(Long.TYPE);
    private static final boolean zzpte = zzp(Integer.TYPE);
    private static final zzd zzptf;
    private static final boolean zzptg = zzdch();
    private static final long zzpth = ((long) zzn(byte[].class));
    private static final long zzpti = ((long) zzn(boolean[].class));
    private static final long zzptj = ((long) zzo(boolean[].class));
    private static final long zzptk = ((long) zzn(int[].class));
    private static final long zzptl = ((long) zzo(int[].class));
    private static final long zzptm = ((long) zzn(long[].class));
    private static final long zzptn = ((long) zzo(long[].class));
    private static final long zzpto = ((long) zzn(float[].class));
    private static final long zzptp = ((long) zzo(float[].class));
    private static final long zzptq = ((long) zzn(double[].class));
    private static final long zzptr = ((long) zzo(double[].class));
    private static final long zzpts = ((long) zzn(Object[].class));
    private static final long zzptt = ((long) zzo(Object[].class));
    private static final long zzptu;
    private static final boolean zzptv = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static abstract class zzd {
        Unsafe zzptw;

        zzd(Unsafe unsafe) {
            this.zzptw = unsafe;
        }

        public final int zza(Object obj, long j) {
            return this.zzptw.getInt(obj, j);
        }

        public abstract void zze(Object obj, long j, byte b);

        public abstract byte zzf(Object obj, long j);
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfkq.zzptv) {
                zzfkq.zza(obj, j, b);
            } else {
                zzfkq.zzb(obj, j, b);
            }
        }

        public final byte zzf(Object obj, long j) {
            return zzfkq.zzptv ? zzfkq.zzb(obj, j) : zzfkq.zzc(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfkq.zzptv) {
                zzfkq.zza(obj, j, b);
            } else {
                zzfkq.zzb(obj, j, b);
            }
        }

        public final byte zzf(Object obj, long j) {
            return zzfkq.zzptv ? zzfkq.zzb(obj, j) : zzfkq.zzc(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzptw.putByte(obj, j, b);
        }

        public final byte zzf(Object obj, long j) {
            return this.zzptw.getByte(obj, j);
        }
    }

    /* JADX WARNING: Missing block: B:14:0x00e4, code:
            if (r0 != null) goto L_0x00ef;
     */
    static {
        /*
        r0 = com.google.android.gms.internal.zzfkq.class;
        r0 = r0.getName();
        r0 = java.util.logging.Logger.getLogger(r0);
        logger = r0;
        r0 = zzdcf();
        zzmdw = r0;
        r0 = com.google.android.gms.internal.zzfgo.zzcxn();
        zzpnt = r0;
        r0 = java.lang.Long.TYPE;
        r0 = zzp(r0);
        zzptd = r0;
        r0 = java.lang.Integer.TYPE;
        r0 = zzp(r0);
        zzpte = r0;
        r0 = zzmdw;
        r1 = 0;
        if (r0 != 0) goto L_0x002e;
    L_0x002d:
        goto L_0x0053;
    L_0x002e:
        r0 = com.google.android.gms.internal.zzfgo.zzcxm();
        if (r0 == 0) goto L_0x004c;
    L_0x0034:
        r0 = zzptd;
        if (r0 == 0) goto L_0x0040;
    L_0x0038:
        r1 = new com.google.android.gms.internal.zzfkq$zzb;
        r0 = zzmdw;
        r1.<init>(r0);
        goto L_0x0053;
    L_0x0040:
        r0 = zzpte;
        if (r0 == 0) goto L_0x0053;
    L_0x0044:
        r1 = new com.google.android.gms.internal.zzfkq$zza;
        r0 = zzmdw;
        r1.<init>(r0);
        goto L_0x0053;
    L_0x004c:
        r1 = new com.google.android.gms.internal.zzfkq$zzc;
        r0 = zzmdw;
        r1.<init>(r0);
    L_0x0053:
        zzptf = r1;
        r0 = zzdch();
        zzptg = r0;
        r0 = zzdcg();
        zzpop = r0;
        r0 = byte[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzpth = r0;
        r0 = boolean[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzpti = r0;
        r0 = boolean[].class;
        r0 = zzo(r0);
        r0 = (long) r0;
        zzptj = r0;
        r0 = int[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzptk = r0;
        r0 = int[].class;
        r0 = zzo(r0);
        r0 = (long) r0;
        zzptl = r0;
        r0 = long[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzptm = r0;
        r0 = long[].class;
        r0 = zzo(r0);
        r0 = (long) r0;
        zzptn = r0;
        r0 = float[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzpto = r0;
        r0 = float[].class;
        r0 = zzo(r0);
        r0 = (long) r0;
        zzptp = r0;
        r0 = double[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzptq = r0;
        r0 = double[].class;
        r0 = zzo(r0);
        r0 = (long) r0;
        zzptr = r0;
        r0 = java.lang.Object[].class;
        r0 = zzn(r0);
        r0 = (long) r0;
        zzpts = r0;
        r0 = java.lang.Object[].class;
        r0 = zzo(r0);
        r0 = (long) r0;
        zzptt = r0;
        r0 = com.google.android.gms.internal.zzfgo.zzcxm();
        if (r0 == 0) goto L_0x00e7;
    L_0x00dc:
        r0 = java.nio.Buffer.class;
        r1 = "effectiveDirectAddress";
        r0 = zza(r0, r1);
        if (r0 == 0) goto L_0x00e7;
    L_0x00e6:
        goto L_0x00ef;
    L_0x00e7:
        r0 = java.nio.Buffer.class;
        r1 = "address";
        r0 = zza(r0, r1);
    L_0x00ef:
        if (r0 == 0) goto L_0x00ff;
    L_0x00f1:
        r1 = zzptf;
        if (r1 != 0) goto L_0x00f6;
    L_0x00f5:
        goto L_0x00ff;
    L_0x00f6:
        r1 = zzptf;
        r1 = r1.zzptw;
        r0 = r1.objectFieldOffset(r0);
        goto L_0x0101;
    L_0x00ff:
        r0 = -1;
    L_0x0101:
        zzptu = r0;
        r0 = java.nio.ByteOrder.nativeOrder();
        r1 = java.nio.ByteOrder.BIG_ENDIAN;
        if (r0 != r1) goto L_0x010d;
    L_0x010b:
        r0 = 1;
        goto L_0x010e;
    L_0x010d:
        r0 = 0;
    L_0x010e:
        zzptv = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.<clinit>():void");
    }

    private zzfkq() {
    }

    static int zza(Object obj, long j) {
        return zzptf.zza(obj, j);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void zza(Object obj, long j, byte b) {
        long j2 = j & -4;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ -1)));
    }

    private static void zza(Object obj, long j, int i) {
        zzptf.zzptw.putInt(obj, j, i);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzptf.zze(bArr, zzpth + j, b);
    }

    private static byte zzb(Object obj, long j) {
        return (byte) (zza(obj, j & -4) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    static byte zzb(byte[] bArr, long j) {
        return zzptf.zzf(bArr, zzpth + j);
    }

    private static void zzb(Object obj, long j, byte b) {
        long j2 = j & -4;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & ((255 << i) ^ -1)));
    }

    private static byte zzc(Object obj, long j) {
        return (byte) (zza(obj, j & -4) >>> ((int) ((j & 3) << 3)));
    }

    static boolean zzdcd() {
        return zzpop;
    }

    static boolean zzdce() {
        return zzptg;
    }

    private static Unsafe zzdcf() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfkr());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzdcg() {
        if (zzmdw == null) {
            return false;
        }
        try {
            Class cls = zzmdw.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzfgo.zzcxm()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 71);
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(valueOf);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", stringBuilder.toString());
            return false;
        }
    }

    private static boolean zzdch() {
        if (zzmdw == null) {
            return false;
        }
        try {
            Class cls = zzmdw.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzfgo.zzcxm()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 71);
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(valueOf);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", stringBuilder.toString());
            return false;
        }
    }

    private static int zzn(Class<?> cls) {
        return zzpop ? zzptf.zzptw.arrayBaseOffset(cls) : -1;
    }

    private static int zzo(Class<?> cls) {
        return zzpop ? zzptf.zzptw.arrayIndexScale(cls) : -1;
    }

    private static boolean zzp(Class<?> cls) {
        if (!zzfgo.zzcxm()) {
            return false;
        }
        try {
            Class cls2 = zzpnt;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
