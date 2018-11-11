package com.google.android.gms.internal;

public class zzfik {
    private static final zzfhm zzpns = zzfhm.zzczf();
    private zzfgs zzpqq;
    private volatile zzfjc zzpqr;
    private volatile zzfgs zzpqs;

    private zzfjc zzj(zzfjc zzfjc) {
        if (this.zzpqr == null) {
            synchronized (this) {
                if (this.zzpqr == null) {
                    this.zzpqr = zzfjc;
                    this.zzpqs = zzfgs.zzpnw;
                    try {
                    } catch (zzfie unused) {
                        this.zzpqr = zzfjc;
                        this.zzpqs = zzfgs.zzpnw;
                    }
                }
            }
        }
        return this.zzpqr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfik)) {
            return false;
        }
        zzfik zzfik = (zzfik) obj;
        zzfjc zzfjc = this.zzpqr;
        zzfjc zzfjc2 = zzfik.zzpqr;
        return (zzfjc == null && zzfjc2 == null) ? toByteString().equals(zzfik.toByteString()) : (zzfjc == null || zzfjc2 == null) ? zzfjc != null ? zzfjc.equals(zzfik.zzj(zzfjc.zzczu())) : zzj(zzfjc2.zzczu()).equals(zzfjc2) : zzfjc.equals(zzfjc2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfgs toByteString() {
        if (this.zzpqs != null) {
            return this.zzpqs;
        }
        synchronized (this) {
            zzfgs zzfgs;
            if (this.zzpqs != null) {
                zzfgs = this.zzpqs;
                return zzfgs;
            }
            this.zzpqs = this.zzpqr == null ? zzfgs.zzpnw : this.zzpqr.toByteString();
            zzfgs = this.zzpqs;
            return zzfgs;
        }
    }

    public final int zzhs() {
        return this.zzpqs != null ? this.zzpqs.size() : this.zzpqr != null ? this.zzpqr.zzhs() : 0;
    }

    public final zzfjc zzk(zzfjc zzfjc) {
        zzfjc zzfjc2 = this.zzpqr;
        this.zzpqq = null;
        this.zzpqs = null;
        this.zzpqr = zzfjc;
        return zzfjc2;
    }
}
