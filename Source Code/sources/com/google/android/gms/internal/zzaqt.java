package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqt extends zzi<zzaqt> {
    public String zzdxh;
    public boolean zzdxi;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzdxh);
        hashMap.put(Param.FATAL, Boolean.valueOf(this.zzdxi));
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqt zzaqt = (zzaqt) zzi;
        if (!TextUtils.isEmpty(this.zzdxh)) {
            zzaqt.zzdxh = this.zzdxh;
        }
        if (this.zzdxi) {
            zzaqt.zzdxi = this.zzdxi;
        }
    }
}
