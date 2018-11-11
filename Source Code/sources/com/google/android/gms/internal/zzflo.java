package com.google.android.gms.internal;

public final class zzflo implements Cloneable {
    private static final zzflp zzpvn = new zzflp();
    private int mSize;
    private boolean zzpvo;
    private int[] zzpvp;
    private zzflp[] zzpvq;

    zzflo() {
        this(10);
    }

    private zzflo(int i) {
        this.zzpvo = false;
        i = idealIntArraySize(i);
        this.zzpvp = new int[i];
        this.zzpvq = new zzflp[i];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        i <<= 2;
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                i = i3;
                break;
            }
        }
        return i / 4;
    }

    private final int zznb(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzpvp[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() {
        int i = this.mSize;
        zzflo zzflo = new zzflo(i);
        int i2 = 0;
        System.arraycopy(this.zzpvp, 0, zzflo.zzpvp, 0, i);
        while (i2 < i) {
            if (this.zzpvq[i2] != null) {
                zzflo.zzpvq[i2] = (zzflp) this.zzpvq[i2].clone();
            }
            i2++;
        }
        zzflo.mSize = i;
        return zzflo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzflo)) {
            return false;
        }
        zzflo zzflo = (zzflo) obj;
        if (this.mSize != zzflo.mSize) {
            return false;
        }
        Object obj2;
        int[] iArr = this.zzpvp;
        int[] iArr2 = zzflo.zzpvp;
        int i = this.mSize;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                obj2 = null;
                break;
            }
        }
        obj2 = 1;
        if (obj2 != null) {
            zzflp[] zzflpArr = this.zzpvq;
            zzflp[] zzflpArr2 = zzflo.zzpvq;
            int i3 = this.mSize;
            for (i = 0; i < i3; i++) {
                if (!zzflpArr[i].equals(zzflpArr2[i])) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzpvp[i2]) * 31) + this.zzpvq[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final int size() {
        return this.mSize;
    }

    final void zza(int i, zzflp zzflp) {
        int zznb = zznb(i);
        if (zznb >= 0) {
            this.zzpvq[zznb] = zzflp;
            return;
        }
        zznb ^= -1;
        if (zznb >= this.mSize || this.zzpvq[zznb] != zzpvn) {
            if (this.mSize >= this.zzpvp.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzflp[idealIntArraySize];
                System.arraycopy(this.zzpvp, 0, obj, 0, this.zzpvp.length);
                System.arraycopy(this.zzpvq, 0, obj2, 0, this.zzpvq.length);
                this.zzpvp = obj;
                this.zzpvq = obj2;
            }
            if (this.mSize - zznb != 0) {
                int i2 = zznb + 1;
                System.arraycopy(this.zzpvp, zznb, this.zzpvp, i2, this.mSize - zznb);
                System.arraycopy(this.zzpvq, zznb, this.zzpvq, i2, this.mSize - zznb);
            }
            this.zzpvp[zznb] = i;
            this.zzpvq[zznb] = zzflp;
            this.mSize++;
            return;
        }
        this.zzpvp[zznb] = i;
        this.zzpvq[zznb] = zzflp;
    }

    final zzflp zzmz(int i) {
        i = zznb(i);
        return (i < 0 || this.zzpvq[i] == zzpvn) ? null : this.zzpvq[i];
    }

    final zzflp zzna(int i) {
        return this.zzpvq[i];
    }
}
