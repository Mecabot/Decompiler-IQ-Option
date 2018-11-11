package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzdko {
    private final List<zzdkj> zzlcg;
    private final List<zzdkj> zzlch;
    private final List<zzdkj> zzlci;
    private final List<zzdkj> zzlcj;
    private final List<zzdkj> zzldo;
    private final List<zzdkj> zzldp;
    private final List<String> zzldq;
    private final List<String> zzldr;
    private final List<String> zzlds;
    private final List<String> zzldt;

    private zzdko() {
        this.zzlcg = new ArrayList();
        this.zzlch = new ArrayList();
        this.zzlci = new ArrayList();
        this.zzlcj = new ArrayList();
        this.zzldo = new ArrayList();
        this.zzldp = new ArrayList();
        this.zzldq = new ArrayList();
        this.zzldr = new ArrayList();
        this.zzlds = new ArrayList();
        this.zzldt = new ArrayList();
    }

    public final zzdkn zzblb() {
        return new zzdkn(this.zzlcg, this.zzlch, this.zzlci, this.zzlcj, this.zzldo, this.zzldp, this.zzldq, this.zzldr, this.zzlds, this.zzldt);
    }

    public final zzdko zzd(zzdkj zzdkj) {
        this.zzlcg.add(zzdkj);
        return this;
    }

    public final zzdko zze(zzdkj zzdkj) {
        this.zzlch.add(zzdkj);
        return this;
    }

    public final zzdko zzf(zzdkj zzdkj) {
        this.zzlci.add(zzdkj);
        return this;
    }

    public final zzdko zzg(zzdkj zzdkj) {
        this.zzlcj.add(zzdkj);
        return this;
    }

    public final zzdko zzh(zzdkj zzdkj) {
        this.zzldo.add(zzdkj);
        return this;
    }

    public final zzdko zzi(zzdkj zzdkj) {
        this.zzldp.add(zzdkj);
        return this;
    }

    public final zzdko zzno(String str) {
        this.zzlds.add(str);
        return this;
    }

    public final zzdko zznp(String str) {
        this.zzldt.add(str);
        return this;
    }

    public final zzdko zznq(String str) {
        this.zzldq.add(str);
        return this;
    }

    public final zzdko zznr(String str) {
        this.zzldr.add(str);
        return this;
    }
}
