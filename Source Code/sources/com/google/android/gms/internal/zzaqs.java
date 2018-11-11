package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.plus.PlusShare;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqs extends zzi<zzaqs> {
    private String mCategory;
    private String zzdxe;
    private String zzdxf;
    private long zzdxg;

    public final String getAction() {
        return this.zzdxe;
    }

    public final String getCategory() {
        return this.mCategory;
    }

    public final String getLabel() {
        return this.zzdxf;
    }

    public final long getValue() {
        return this.zzdxg;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.mCategory);
        hashMap.put("action", this.zzdxe);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzdxf);
        hashMap.put(b.VALUE, Long.valueOf(this.zzdxg));
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqs zzaqs = (zzaqs) zzi;
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzaqs.mCategory = this.mCategory;
        }
        if (!TextUtils.isEmpty(this.zzdxe)) {
            zzaqs.zzdxe = this.zzdxe;
        }
        if (!TextUtils.isEmpty(this.zzdxf)) {
            zzaqs.zzdxf = this.zzdxf;
        }
        if (this.zzdxg != 0) {
            zzaqs.zzdxg = this.zzdxg;
        }
    }
}
