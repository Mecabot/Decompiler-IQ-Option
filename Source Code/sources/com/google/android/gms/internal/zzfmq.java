package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzfmq extends zzflm<zzfmq> implements Cloneable {
    private byte[] zzpyq;
    private String zzpyr;
    private byte[][] zzpys;
    private boolean zzpyt;

    public zzfmq() {
        this.zzpyq = zzflv.zzpwe;
        this.zzpyr = "";
        this.zzpys = zzflv.zzpwd;
        this.zzpyt = false;
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private zzfmq zzddd() {
        try {
            zzfmq zzfmq = (zzfmq) super.clone();
            if (this.zzpys != null && this.zzpys.length > 0) {
                zzfmq.zzpys = (byte[][]) this.zzpys.clone();
            }
            return zzfmq;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmq)) {
            return false;
        }
        zzfmq zzfmq = (zzfmq) obj;
        if (!Arrays.equals(this.zzpyq, zzfmq.zzpyq)) {
            return false;
        }
        if (this.zzpyr == null) {
            if (zzfmq.zzpyr != null) {
                return false;
            }
        } else if (!this.zzpyr.equals(zzfmq.zzpyr)) {
            return false;
        }
        return (zzflq.zza(this.zzpys, zzfmq.zzpys) && this.zzpyt == zzfmq.zzpyt) ? (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzfmq.zzpvl == null || zzfmq.zzpvl.isEmpty() : this.zzpvl.equals(zzfmq.zzpvl) : false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzpyq)) * 31) + (this.zzpyr == null ? 0 : this.zzpyr.hashCode())) * 31) + zzflq.zzd(this.zzpys)) * 31) + (this.zzpyt ? 1231 : 1237)) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (!Arrays.equals(this.zzpyq, zzflv.zzpwe)) {
            zzflk.zzc(1, this.zzpyq);
        }
        if (this.zzpys != null && this.zzpys.length > 0) {
            for (byte[] bArr : this.zzpys) {
                if (bArr != null) {
                    zzflk.zzc(2, bArr);
                }
            }
        }
        if (this.zzpyt) {
            zzflk.zzl(3, this.zzpyt);
        }
        if (!(this.zzpyr == null || this.zzpyr.equals(""))) {
            zzflk.zzp(4, this.zzpyr);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmq) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmq) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (!Arrays.equals(this.zzpyq, zzflv.zzpwe)) {
            zzq += zzflk.zzd(1, this.zzpyq);
        }
        if (this.zzpys != null && this.zzpys.length > 0) {
            int i = 0;
            int i2 = 0;
            for (byte[] bArr : this.zzpys) {
                if (bArr != null) {
                    i2++;
                    i += zzflk.zzbg(bArr);
                }
            }
            zzq = (zzq + i) + (i2 * 1);
        }
        if (this.zzpyt) {
            zzq += zzflk.zzlw(3) + 1;
        }
        return (this.zzpyr == null || this.zzpyr.equals("")) ? zzq : zzq + zzflk.zzq(4, this.zzpyr);
    }
}
