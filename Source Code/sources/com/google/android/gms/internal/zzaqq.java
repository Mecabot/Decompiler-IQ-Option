package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqq extends zzi<zzaqq> {
    public int zzcly;
    public int zzclz;
    private String zzdxa;
    public int zzdxb;
    public int zzdxc;
    public int zzdxd;

    public final String getLanguage() {
        return this.zzdxa;
    }

    public final void setLanguage(String str) {
        this.zzdxa = str;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.zzdxa);
        hashMap.put("screenColors", Integer.valueOf(this.zzdxb));
        hashMap.put("screenWidth", Integer.valueOf(this.zzcly));
        hashMap.put("screenHeight", Integer.valueOf(this.zzclz));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzdxc));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzdxd));
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqq zzaqq = (zzaqq) zzi;
        if (this.zzdxb != 0) {
            zzaqq.zzdxb = this.zzdxb;
        }
        if (this.zzcly != 0) {
            zzaqq.zzcly = this.zzcly;
        }
        if (this.zzclz != 0) {
            zzaqq.zzclz = this.zzclz;
        }
        if (this.zzdxc != 0) {
            zzaqq.zzdxc = this.zzdxc;
        }
        if (this.zzdxd != 0) {
            zzaqq.zzdxd = this.zzdxd;
        }
        if (!TextUtils.isEmpty(this.zzdxa)) {
            zzaqq.zzdxa = this.zzdxa;
        }
    }
}
