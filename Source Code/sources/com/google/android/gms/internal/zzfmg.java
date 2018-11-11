package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfhu.zzb;
import com.google.android.gms.internal.zzfhu.zzf;
import com.google.android.gms.internal.zzfhu.zzg;
import com.google.android.gms.internal.zzfhu.zzh;
import java.io.IOException;

public final class zzfmg extends zzfhu<zzfmg, zza> implements zzfje {
    private static volatile zzfjl<zzfmg> zzbbm;
    private static final zzfmg zzpxv;
    private int zzmjb;
    private int zzpxs;
    private String zzpxt = "";
    private zzfid<zzfgp> zzpxu = zzfhu.zzczs();

    public static final class zza extends com.google.android.gms.internal.zzfhu.zza<zzfmg, zza> implements zzfje {
        private zza() {
            super(zzfmg.zzpxv);
        }

        /* synthetic */ zza(zzfmh zzfmh) {
            this();
        }
    }

    static {
        zzfhu zzfmg = new zzfmg();
        zzpxv = zzfmg;
        zzfmg.zza(zzg.zzppw, null, null);
        zzfmg.zzpph.zzbkr();
    }

    private zzfmg() {
    }

    public static zzfmg zzdcu() {
        return zzpxv;
    }

    public final int getCode() {
        return this.zzpxs;
    }

    public final String getMessage() {
        return this.zzpxt;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        boolean z = false;
        int i2;
        switch (zzfmh.zzbbk[i - 1]) {
            case 1:
                return new zzfmg();
            case 2:
                return zzpxv;
            case 3:
                this.zzpxu.zzbkr();
                return null;
            case 4:
                return new zza();
            case 5:
                zzh zzh = (zzh) obj;
                zzfmg zzfmg = (zzfmg) obj2;
                boolean z2 = this.zzpxs != 0;
                i2 = this.zzpxs;
                if (zzfmg.zzpxs != 0) {
                    z = true;
                }
                this.zzpxs = zzh.zza(z2, i2, z, zzfmg.zzpxs);
                this.zzpxt = zzh.zza(this.zzpxt.isEmpty() ^ true, this.zzpxt, true ^ zzfmg.zzpxt.isEmpty(), zzfmg.zzpxt);
                this.zzpxu = zzh.zza(this.zzpxu, zzfmg.zzpxu);
                if (zzh == zzf.zzppq) {
                    this.zzmjb |= zzfmg.zzmjb;
                }
                return this;
            case 6:
                zzfhb zzfhb = (zzfhb) obj;
                zzfhm zzfhm = (zzfhm) obj2;
                if (zzfhm != null) {
                    while (!z) {
                        try {
                            i = zzfhb.zzcxx();
                            if (i != 0) {
                                if (i == 8) {
                                    this.zzpxs = zzfhb.zzcya();
                                } else if (i == 18) {
                                    this.zzpxt = zzfhb.zzcye();
                                } else if (i == 26) {
                                    if (!this.zzpxu.zzcxk()) {
                                        zzfid zzfid = this.zzpxu;
                                        i2 = zzfid.size();
                                        this.zzpxu = zzfid.zzmo(i2 == 0 ? 10 : i2 << 1);
                                    }
                                    this.zzpxu.add((zzfgp) zzfhb.zza(zzfgp.zzcxo(), zzfhm));
                                } else if (zza(i, zzfhb)) {
                                }
                            }
                            z = true;
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
                    synchronized (zzfmg.class) {
                        if (zzbbm == null) {
                            zzbbm = new zzb(zzpxv);
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
        return zzpxv;
    }

    public final void zza(zzfhg zzfhg) {
        if (this.zzpxs != 0) {
            zzfhg.zzad(1, this.zzpxs);
        }
        if (!this.zzpxt.isEmpty()) {
            zzfhg.zzp(2, this.zzpxt);
        }
        for (int i = 0; i < this.zzpxu.size(); i++) {
            zzfhg.zza(3, (zzfjc) this.zzpxu.get(i));
        }
        this.zzpph.zza(zzfhg);
    }

    public final int zzhs() {
        int i = this.zzppi;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        i = this.zzpxs != 0 ? zzfhg.zzag(1, this.zzpxs) + 0 : 0;
        if (!this.zzpxt.isEmpty()) {
            i += zzfhg.zzq(2, this.zzpxt);
        }
        while (i2 < this.zzpxu.size()) {
            i += zzfhg.zzc(3, (zzfjc) this.zzpxu.get(i2));
            i2++;
        }
        i += this.zzpph.zzhs();
        this.zzppi = i;
        return i;
    }
}
