package com.google.android.gms.internal;

import java.io.InputStream;

public abstract class zzfhb {
    private static volatile boolean zzpog = true;
    int zzpoc;
    int zzpod;
    int zzpoe;
    private boolean zzpof;

    private zzfhb() {
        this.zzpod = 100;
        this.zzpoe = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzpof = false;
    }

    /* synthetic */ zzfhb(zzfhc zzfhc) {
        this();
    }

    static zzfhb zzb(byte[] bArr, int i, int i2, boolean z) {
        zzfhb zzfhd = new zzfhd(bArr, i, i2, z, null);
        try {
            zzfhd.zzli(i2);
            return zzfhd;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static zzfhb zzbb(byte[] bArr) {
        return zzb(bArr, 0, bArr.length, false);
    }

    public static long zzct(long j) {
        return (j >>> 1) ^ (-(j & 1));
    }

    public static zzfhb zzh(InputStream inputStream) {
        if (inputStream != null) {
            return new zzfhe(inputStream, 4096, null);
        }
        byte[] bArr = zzfhz.EMPTY_BYTE_ARRAY;
        return zzb(bArr, 0, bArr.length, false);
    }

    public static zzfhb zzh(byte[] bArr, int i, int i2) {
        return zzb(bArr, i, i2, false);
    }

    public static int zzll(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract <T extends zzfhu<T, ?>> T zza(T t, zzfhm zzfhm);

    public abstract void zza(zzfjd zzfjd, zzfhm zzfhm);

    public abstract int zzcxx();

    public abstract long zzcxy();

    public abstract long zzcxz();

    public abstract int zzcya();

    public abstract long zzcyb();

    public abstract int zzcyc();

    public abstract boolean zzcyd();

    public abstract String zzcye();

    public abstract zzfgs zzcyf();

    public abstract int zzcyg();

    public abstract int zzcyh();

    public abstract int zzcyi();

    public abstract long zzcyj();

    public abstract int zzcyk();

    public abstract long zzcyl();

    public abstract int zzcym();

    abstract long zzcyn();

    public abstract int zzcyo();

    public abstract boolean zzcyp();

    public abstract int zzcyq();

    public abstract void zzlf(int i);

    public abstract boolean zzlg(int i);

    public final int zzlh(int i) {
        i = this.zzpoe;
        this.zzpoe = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        return i;
    }

    public abstract int zzli(int i);

    public abstract void zzlj(int i);

    public abstract void zzlk(int i);
}
