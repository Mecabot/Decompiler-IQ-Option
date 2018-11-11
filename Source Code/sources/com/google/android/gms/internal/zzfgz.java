package com.google.android.gms.internal;

class zzfgz extends zzfgy {
    protected final byte[] zzjwl;

    zzfgz(byte[] bArr) {
        this.zzjwl = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfgs) || size() != ((zzfgs) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfgz)) {
            return obj.equals(this);
        }
        zzfgz zzfgz = (zzfgz) obj;
        int zzcxt = zzcxt();
        int zzcxt2 = zzfgz.zzcxt();
        return (zzcxt == 0 || zzcxt2 == 0 || zzcxt == zzcxt2) ? zza(zzfgz, 0, size()) : false;
    }

    public int size() {
        return this.zzjwl.length;
    }

    final void zza(zzfgr zzfgr) {
        zzfgr.zze(this.zzjwl, zzcxu(), size());
    }

    final boolean zza(zzfgs zzfgs, int i, int i2) {
        if (i2 > zzfgs.size()) {
            i = size();
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i3 = i + i2;
        int size;
        if (i3 > zzfgs.size()) {
            size = zzfgs.size();
            StringBuilder stringBuilder2 = new StringBuilder(59);
            stringBuilder2.append("Ran off end of other: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(i2);
            stringBuilder2.append(", ");
            stringBuilder2.append(size);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else if (!(zzfgs instanceof zzfgz)) {
            return zzfgs.zzaa(i, i3).equals(zzaa(0, i2));
        } else {
            zzfgz zzfgz = (zzfgz) zzfgs;
            byte[] bArr = this.zzjwl;
            byte[] bArr2 = zzfgz.zzjwl;
            int zzcxu = zzcxu() + i2;
            i2 = zzcxu();
            size = zzfgz.zzcxu() + i;
            while (i2 < zzcxu) {
                if (bArr[i2] != bArr2[size]) {
                    return false;
                }
                i2++;
                size++;
            }
            return true;
        }
    }

    public final zzfgs zzaa(int i, int i2) {
        i2 = zzfgs.zzh(i, i2, size());
        return i2 == 0 ? zzfgs.zzpnw : new zzfgv(this.zzjwl, zzcxu() + i, i2);
    }

    protected void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzjwl, i, bArr, i2, i3);
    }

    public final zzfhb zzcxq() {
        return zzfhb.zzb(this.zzjwl, zzcxu(), size(), true);
    }

    protected int zzcxu() {
        return 0;
    }

    protected final int zzg(int i, int i2, int i3) {
        return zzfhz.zza(i, this.zzjwl, zzcxu() + i2, i3);
    }

    public byte zzld(int i) {
        return this.zzjwl[i];
    }
}
