package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqu extends zzi<zzaqu> {
    private String zzaux;
    private String zzdxj;
    private String zzdxk;
    private String zzdxl;
    private boolean zzdxm;
    private String zzdxn;
    private boolean zzdxo;
    private double zzdxp;

    public final String getUserId() {
        return this.zzaux;
    }

    public final void setClientId(String str) {
        this.zzdxk = str;
    }

    public final void setUserId(String str) {
        this.zzaux = str;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.zzdxj);
        hashMap.put("clientId", this.zzdxk);
        hashMap.put("userId", this.zzaux);
        hashMap.put("androidAdId", this.zzdxl);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzdxm));
        hashMap.put("sessionControl", this.zzdxn);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzdxo));
        hashMap.put("sampleRate", Double.valueOf(this.zzdxp));
        return zzi.zzl(hashMap);
    }

    public final void zzam(boolean z) {
        this.zzdxm = z;
    }

    public final void zzan(boolean z) {
        this.zzdxo = true;
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqu zzaqu = (zzaqu) zzi;
        if (!TextUtils.isEmpty(this.zzdxj)) {
            zzaqu.zzdxj = this.zzdxj;
        }
        if (!TextUtils.isEmpty(this.zzdxk)) {
            zzaqu.zzdxk = this.zzdxk;
        }
        if (!TextUtils.isEmpty(this.zzaux)) {
            zzaqu.zzaux = this.zzaux;
        }
        if (!TextUtils.isEmpty(this.zzdxl)) {
            zzaqu.zzdxl = this.zzdxl;
        }
        boolean z = true;
        if (this.zzdxm) {
            zzaqu.zzdxm = true;
        }
        if (!TextUtils.isEmpty(this.zzdxn)) {
            zzaqu.zzdxn = this.zzdxn;
        }
        if (this.zzdxo) {
            zzaqu.zzdxo = this.zzdxo;
        }
        if (this.zzdxp != 0.0d) {
            double d = this.zzdxp;
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            zzbq.checkArgument(z, "Sample rate must be between 0% and 100%");
            zzaqu.zzdxp = d;
        }
    }

    public final void zzdv(String str) {
        this.zzdxj = str;
    }

    public final void zzdw(String str) {
        this.zzdxl = str;
    }

    public final String zzxd() {
        return this.zzdxj;
    }

    public final String zzxe() {
        return this.zzdxk;
    }

    public final String zzxf() {
        return this.zzdxl;
    }

    public final boolean zzxg() {
        return this.zzdxm;
    }

    public final String zzxh() {
        return this.zzdxn;
    }

    public final boolean zzxi() {
        return this.zzdxo;
    }

    public final double zzxj() {
        return this.zzdxp;
    }
}
