package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhu.zzb;
import com.google.android.gms.internal.zzfhu.zzg;
import com.google.android.gms.internal.zzfhu.zzh;
import java.io.IOException;

public final class zzfhw extends zzfhu<zzfhw, zza> implements zzfje {
    private static volatile zzfjl<zzfhw> zzbbm;
    private static final zzfhw zzpqj;
    private int zzpqi;

    public static final class zza extends com.google.android.gms.internal.zzfhu.zza<zzfhw, zza> implements zzfje {
        private zza() {
            super(zzfhw.zzpqj);
        }

        /* synthetic */ zza(zzfhx zzfhx) {
            this();
        }

        public final zza zzmj(int i) {
            zzczv();
            ((zzfhw) this.zzppl).setValue(i);
            return this;
        }
    }

    static {
        zzfhu zzfhw = new zzfhw();
        zzpqj = zzfhw;
        zzfhw.zza(zzg.zzppw, null, null);
        zzfhw.zzpph.zzbkr();
    }

    private zzfhw() {
    }

    private final void setValue(int i) {
        this.zzpqi = i;
    }

    public static zza zzdaa() {
        return (zza) ((com.google.android.gms.internal.zzfhu.zza) zzpqj.zza(zzg.zzppy, null, null));
    }

    public static zzfhw zzdab() {
        return zzpqj;
    }

    public final int getValue() {
        return this.zzpqi;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = true;
        switch (zzfhx.zzbbk[i - 1]) {
            case 1:
                return new zzfhw();
            case 2:
                return zzpqj;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh zzh = (zzh) obj;
                zzfhw zzfhw = (zzfhw) obj2;
                boolean z2 = this.zzpqi != 0;
                int i2 = this.zzpqi;
                if (zzfhw.zzpqi == 0) {
                    z = false;
                }
                this.zzpqi = zzh.zza(z2, i2, z, zzfhw.zzpqi);
                return this;
            case 6:
                zzfhb zzfhb = (zzfhb) obj;
                if (((zzfhm) obj2) != null) {
                    Object obj3 = null;
                    while (obj3 == null) {
                        try {
                            int zzcxx = zzfhb.zzcxx();
                            if (zzcxx != 0) {
                                if (zzcxx != 8) {
                                    boolean z3;
                                    if ((zzcxx & 7) == 4) {
                                        z3 = false;
                                    } else {
                                        if (this.zzpph == zzfko.zzdca()) {
                                            this.zzpph = zzfko.zzdcb();
                                        }
                                        z3 = this.zzpph.zzb(zzcxx, zzfhb);
                                    }
                                    if (z3) {
                                    }
                                } else {
                                    this.zzpqi = zzfhb.zzcya();
                                }
                            }
                            obj3 = 1;
                        } catch (zzfie e) {
                            throw new RuntimeException(e.zzi(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new zzfie(e2.getMessage()).zzi(this));
                        }
                    }
                    break;
                }
                throw new NullPointerException();
            case 7:
                break;
            case 8:
                if (zzbbm == null) {
                    synchronized (zzfhw.class) {
                        if (zzbbm == null) {
                            zzbbm = new zzb(zzpqj);
                        }
                    }
                }
                return zzbbm;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return zzpqj;
    }

    public final void zza(zzfhg zzfhg) {
        if (this.zzpqi != 0) {
            zzfhg.zzad(1, this.zzpqi);
        }
        this.zzpph.zza(zzfhg);
    }

    public final int zzhs() {
        int i = this.zzppi;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzpqi != 0) {
            i2 = 0 + zzfhg.zzag(1, this.zzpqi);
        }
        i2 += this.zzpph.zzhs();
        this.zzppi = i2;
        return i2;
    }
}
