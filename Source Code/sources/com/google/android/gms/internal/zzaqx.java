package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqx extends zzi<zzaqx> {
    public String mCategory;
    public String zzdxf;
    public String zzdxy;
    public long zzdxz;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.zzdxy);
        hashMap.put("timeInMillis", Long.valueOf(this.zzdxz));
        hashMap.put("category", this.mCategory);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzdxf);
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqx zzaqx = (zzaqx) zzi;
        if (!TextUtils.isEmpty(this.zzdxy)) {
            zzaqx.zzdxy = this.zzdxy;
        }
        if (this.zzdxz != 0) {
            zzaqx.zzdxz = this.zzdxz;
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzaqx.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzdxf)) {
            zzaqx.zzdxf = this.zzdxf;
        }
    }
}
