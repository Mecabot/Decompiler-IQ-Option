package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqw extends zzi<zzaqw> {
    public String zzdxe;
    public String zzdxw;
    public String zzdxx;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.zzdxw);
        hashMap.put("action", this.zzdxe);
        hashMap.put("target", this.zzdxx);
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqw zzaqw = (zzaqw) zzi;
        if (!TextUtils.isEmpty(this.zzdxw)) {
            zzaqw.zzdxw = this.zzdxw;
        }
        if (!TextUtils.isEmpty(this.zzdxe)) {
            zzaqw.zzdxe = this.zzdxe;
        }
        if (!TextUtils.isEmpty(this.zzdxx)) {
            zzaqw.zzdxx = this.zzdxx;
        }
    }
}
