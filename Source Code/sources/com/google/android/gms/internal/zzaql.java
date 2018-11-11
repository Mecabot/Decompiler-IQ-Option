package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaql extends zzi<zzaql> {
    private String mAppId;
    private String zzdwo;
    private String zzdwp;
    private String zzdwq;

    public final String getAppId() {
        return this.mAppId;
    }

    public final void setAppId(String str) {
        this.mAppId = str;
    }

    public final void setAppInstallerId(String str) {
        this.zzdwq = str;
    }

    public final void setAppName(String str) {
        this.zzdwo = str;
    }

    public final void setAppVersion(String str) {
        this.zzdwp = str;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.zzdwo);
        hashMap.put("appVersion", this.zzdwp);
        hashMap.put("appId", this.mAppId);
        hashMap.put("appInstallerId", this.zzdwq);
        return zzi.zzl(hashMap);
    }

    /* renamed from: zza */
    public final void zzb(zzaql zzaql) {
        if (!TextUtils.isEmpty(this.zzdwo)) {
            zzaql.zzdwo = this.zzdwo;
        }
        if (!TextUtils.isEmpty(this.zzdwp)) {
            zzaql.zzdwp = this.zzdwp;
        }
        if (!TextUtils.isEmpty(this.mAppId)) {
            zzaql.mAppId = this.mAppId;
        }
        if (!TextUtils.isEmpty(this.zzdwq)) {
            zzaql.zzdwq = this.zzdwq;
        }
    }

    public final String zzwn() {
        return this.zzdwo;
    }

    public final String zzwo() {
        return this.zzdwp;
    }

    public final String zzwp() {
        return this.zzdwq;
    }
}
