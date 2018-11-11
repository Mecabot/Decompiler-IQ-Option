package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhu.zzb;
import com.google.android.gms.internal.zzfhu.zzg;
import com.google.android.gms.internal.zzfhu.zzh;
import java.io.IOException;

public final class zzfgp extends zzfhu<zzfgp, zza> implements zzfje {
    private static volatile zzfjl<zzfgp> zzbbm;
    private static final zzfgp zzpnv;
    private String zzmid = "";
    private zzfgs zzmie = zzfgs.zzpnw;

    public static final class zza extends com.google.android.gms.internal.zzfhu.zza<zzfgp, zza> implements zzfje {
        private zza() {
            super(zzfgp.zzpnv);
        }

        /* synthetic */ zza(zzfgq zzfgq) {
            this();
        }
    }

    static {
        zzfhu zzfgp = new zzfgp();
        zzpnv = zzfgp;
        zzfgp.zza(zzg.zzppw, null, null);
        zzfgp.zzpph.zzbkr();
    }

    private zzfgp() {
    }

    public static zzfgp zzcxo() {
        return zzpnv;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = true;
        switch (zzfgq.zzbbk[i - 1]) {
            case 1:
                return new zzfgp();
            case 2:
                return zzpnv;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh zzh = (zzh) obj;
                zzfgp zzfgp = (zzfgp) obj2;
                this.zzmid = zzh.zza(this.zzmid.isEmpty() ^ true, this.zzmid, zzfgp.zzmid.isEmpty() ^ true, zzfgp.zzmid);
                boolean z2 = this.zzmie != zzfgs.zzpnw;
                zzfgs zzfgs = this.zzmie;
                if (zzfgp.zzmie == zzfgs.zzpnw) {
                    z = false;
                }
                this.zzmie = zzh.zza(z2, zzfgs, z, zzfgp.zzmie);
                return this;
            case 6:
                zzfhb zzfhb = (zzfhb) obj;
                if (((zzfhm) obj2) != null) {
                    Object obj3 = null;
                    while (obj3 == null) {
                        try {
                            int zzcxx = zzfhb.zzcxx();
                            if (zzcxx != 0) {
                                if (zzcxx == 10) {
                                    this.zzmid = zzfhb.zzcye();
                                } else if (zzcxx != 18) {
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
                                    this.zzmie = zzfhb.zzcyf();
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
                    synchronized (zzfgp.class) {
                        if (zzbbm == null) {
                            zzbbm = new zzb(zzpnv);
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
        return zzpnv;
    }

    public final void zza(zzfhg zzfhg) {
        if (!this.zzmid.isEmpty()) {
            zzfhg.zzp(1, this.zzmid);
        }
        if (!this.zzmie.isEmpty()) {
            zzfhg.zza(2, this.zzmie);
        }
        this.zzpph.zza(zzfhg);
    }

    public final int zzhs() {
        int i = this.zzppi;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.zzmid.isEmpty()) {
            i2 = 0 + zzfhg.zzq(1, this.zzmid);
        }
        if (!this.zzmie.isEmpty()) {
            i2 += zzfhg.zzc(2, this.zzmie);
        }
        i2 += this.zzpph.zzhs();
        this.zzppi = i2;
        return i2;
    }
}
