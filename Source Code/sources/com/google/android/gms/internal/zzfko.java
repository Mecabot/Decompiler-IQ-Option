package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhu.zzg;
import java.util.Arrays;

public final class zzfko {
    private static final zzfko zzpta = new zzfko(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzpnq;
    private int zzppi;
    private int[] zzptb;
    private Object[] zzptc;

    private zzfko() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfko(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzppi = -1;
        this.count = i;
        this.zzptb = iArr;
        this.zzptc = objArr;
        this.zzpnq = z;
    }

    static zzfko zzb(zzfko zzfko, zzfko zzfko2) {
        int i = zzfko.count + zzfko2.count;
        Object copyOf = Arrays.copyOf(zzfko.zzptb, i);
        System.arraycopy(zzfko2.zzptb, 0, copyOf, zzfko.count, zzfko2.count);
        Object copyOf2 = Arrays.copyOf(zzfko.zzptc, i);
        System.arraycopy(zzfko2.zzptc, 0, copyOf2, zzfko.count, zzfko2.count);
        return new zzfko(i, copyOf, copyOf2, true);
    }

    private void zzc(int i, Object obj) {
        zzdbr();
        if (this.count == this.zzptb.length) {
            int i2 = this.count + (this.count < 4 ? 8 : this.count >> 1);
            this.zzptb = Arrays.copyOf(this.zzptb, i2);
            this.zzptc = Arrays.copyOf(this.zzptc, i2);
        }
        this.zzptb[this.count] = i;
        this.zzptc[this.count] = obj;
        this.count++;
    }

    private final void zzdbr() {
        if (!this.zzpnq) {
            throw new UnsupportedOperationException();
        }
    }

    public static zzfko zzdca() {
        return zzpta;
    }

    static zzfko zzdcb() {
        return new zzfko();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfko)) {
            return false;
        }
        zzfko zzfko = (zzfko) obj;
        if (this.count == zzfko.count) {
            Object obj2;
            int[] iArr = this.zzptb;
            int[] iArr2 = zzfko.zzptb;
            int i = this.count;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] != iArr2[i2]) {
                    obj2 = null;
                    break;
                }
            }
            obj2 = 1;
            if (obj2 != null) {
                Object[] objArr = this.zzptc;
                Object[] objArr2 = zzfko.zzptc;
                int i3 = this.count;
                for (i = 0; i < i3; i++) {
                    if (!objArr[i].equals(objArr2[i])) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
                return obj != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.count + 527) * 31) + Arrays.hashCode(this.zzptb)) * 31) + Arrays.deepHashCode(this.zzptc);
    }

    public final void zza(zzfhg zzfhg) {
        for (int i = 0; i < this.count; i++) {
            int i2 = this.zzptb[i];
            int i3 = i2 >>> 3;
            i2 &= 7;
            if (i2 != 5) {
                switch (i2) {
                    case 0:
                        zzfhg.zza(i3, ((Long) this.zzptc[i]).longValue());
                        break;
                    case 1:
                        zzfhg.zzb(i3, ((Long) this.zzptc[i]).longValue());
                        break;
                    case 2:
                        zzfhg.zza(i3, (zzfgs) this.zzptc[i]);
                        break;
                    case 3:
                        zzfhg.zzac(i3, 3);
                        ((zzfko) this.zzptc[i]).zza(zzfhg);
                        zzfhg.zzac(i3, 4);
                        break;
                    default:
                        throw zzfie.zzdaj();
                }
            }
            zzfhg.zzaf(i3, ((Integer) this.zzptc[i]).intValue());
        }
    }

    final void zza(zzfli zzfli) {
        int i;
        if (zzfli.zzcyz() == zzg.zzpqg) {
            for (i = this.count - 1; i >= 0; i--) {
                zzfli.zzb(this.zzptb[i] >>> 3, this.zzptc[i]);
            }
            return;
        }
        for (i = 0; i < this.count; i++) {
            zzfli.zzb(this.zzptb[i] >>> 3, this.zzptc[i]);
        }
    }

    final boolean zzb(int i, zzfhb zzfhb) {
        zzdbr();
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzc(i, Long.valueOf(zzfhb.zzcxz()));
                return true;
            case 1:
                zzc(i, Long.valueOf(zzfhb.zzcyb()));
                return true;
            case 2:
                zzc(i, zzfhb.zzcyf());
                return true;
            case 3:
                zzfko zzfko = new zzfko();
                int zzcxx;
                do {
                    zzcxx = zzfhb.zzcxx();
                    if (zzcxx != 0) {
                    }
                    zzfhb.zzlf((i2 << 3) | 4);
                    zzc(i, zzfko);
                    return true;
                } while (zzfko.zzb(zzcxx, zzfhb));
                zzfhb.zzlf((i2 << 3) | 4);
                zzc(i, zzfko);
                return true;
            case 4:
                return false;
            case 5:
                zzc(i, Integer.valueOf(zzfhb.zzcyc()));
                return true;
            default:
                throw zzfie.zzdaj();
        }
    }

    public final void zzbkr() {
        this.zzpnq = false;
    }

    final void zzd(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzfjf.zzb(stringBuilder, i, String.valueOf(this.zzptb[i2] >>> 3), this.zzptc[i2]);
        }
    }

    public final int zzdcc() {
        int i = this.zzppi;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (i = 0; i < this.count; i++) {
            i2 += zzfhg.zzd(this.zzptb[i] >>> 3, (zzfgs) this.zzptc[i]);
        }
        this.zzppi = i2;
        return i2;
    }

    public final int zzhs() {
        int i = this.zzppi;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (i = 0; i < this.count; i++) {
            int i3 = this.zzptb[i];
            int i4 = i3 >>> 3;
            i3 &= 7;
            if (i3 != 5) {
                switch (i3) {
                    case 0:
                        i3 = zzfhg.zzd(i4, ((Long) this.zzptc[i]).longValue());
                        break;
                    case 1:
                        i3 = zzfhg.zze(i4, ((Long) this.zzptc[i]).longValue());
                        break;
                    case 2:
                        i3 = zzfhg.zzc(i4, (zzfgs) this.zzptc[i]);
                        break;
                    case 3:
                        i3 = (zzfhg.zzlw(i4) << 1) + ((zzfko) this.zzptc[i]).zzhs();
                        break;
                    default:
                        throw new IllegalStateException(zzfie.zzdaj());
                }
            }
            i3 = zzfhg.zzai(i4, ((Integer) this.zzptc[i]).intValue());
            i2 += i3;
        }
        this.zzppi = i2;
        return i2;
    }
}
