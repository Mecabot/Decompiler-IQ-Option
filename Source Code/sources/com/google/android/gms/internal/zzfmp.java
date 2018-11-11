package com.google.android.gms.internal;

public final class zzfmp extends zzflm<zzfmp> implements Cloneable {
    private String version;
    private int zzjgl;
    private String zzpyp;

    public zzfmp() {
        this.zzjgl = 0;
        this.zzpyp = "";
        this.version = "";
        this.zzpvl = null;
        this.zzpnr = -1;
    }

    private zzfmp zzddc() {
        try {
            return (zzfmp) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfmp)) {
            return false;
        }
        zzfmp zzfmp = (zzfmp) obj;
        if (this.zzjgl != zzfmp.zzjgl) {
            return false;
        }
        if (this.zzpyp == null) {
            if (zzfmp.zzpyp != null) {
                return false;
            }
        } else if (!this.zzpyp.equals(zzfmp.zzpyp)) {
            return false;
        }
        if (this.version == null) {
            if (zzfmp.version != null) {
                return false;
            }
        } else if (!this.version.equals(zzfmp.version)) {
            return false;
        }
        return (this.zzpvl == null || this.zzpvl.isEmpty()) ? zzfmp.zzpvl == null || zzfmp.zzpvl.isEmpty() : this.zzpvl.equals(zzfmp.zzpvl);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.zzjgl) * 31) + (this.zzpyp == null ? 0 : this.zzpyp.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31;
        if (!(this.zzpvl == null || this.zzpvl.isEmpty())) {
            i = this.zzpvl.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzflk zzflk) {
        if (this.zzjgl != 0) {
            zzflk.zzad(1, this.zzjgl);
        }
        if (!(this.zzpyp == null || this.zzpyp.equals(""))) {
            zzflk.zzp(2, this.zzpyp);
        }
        if (!(this.version == null || this.version.equals(""))) {
            zzflk.zzp(3, this.version);
        }
        super.zza(zzflk);
    }

    public final /* synthetic */ zzflm zzdck() {
        return (zzfmp) clone();
    }

    public final /* synthetic */ zzfls zzdcl() {
        return (zzfmp) clone();
    }

    protected final int zzq() {
        int zzq = super.zzq();
        if (this.zzjgl != 0) {
            zzq += zzflk.zzag(1, this.zzjgl);
        }
        if (!(this.zzpyp == null || this.zzpyp.equals(""))) {
            zzq += zzflk.zzq(2, this.zzpyp);
        }
        return (this.version == null || this.version.equals("")) ? zzq : zzq + zzflk.zzq(3, this.version);
    }
}
