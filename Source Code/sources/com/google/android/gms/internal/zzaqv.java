package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Hide
public final class zzaqv extends zzi<zzaqv> {
    private String zzaqh;
    private int zzdxq;
    private int zzdxr;
    private String zzdxs;
    private String zzdxt;
    private boolean zzdxu;
    private boolean zzdxv;

    public zzaqv() {
        this(false);
    }

    private zzaqv(boolean z) {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                Log.e("GAv4", "UUID.randomUUID() returned 0.");
                leastSignificantBits = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
        this(false, leastSignificantBits);
    }

    private zzaqv(boolean z, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.zzdxq = i;
        this.zzdxv = false;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.zzaqh);
        hashMap.put("interstitial", Boolean.valueOf(this.zzdxu));
        hashMap.put("automatic", Boolean.valueOf(this.zzdxv));
        hashMap.put("screenId", Integer.valueOf(this.zzdxq));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzdxr));
        hashMap.put("referrerScreenName", this.zzdxs);
        hashMap.put("referrerUri", this.zzdxt);
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqv zzaqv = (zzaqv) zzi;
        if (!TextUtils.isEmpty(this.zzaqh)) {
            zzaqv.zzaqh = this.zzaqh;
        }
        if (this.zzdxq != 0) {
            zzaqv.zzdxq = this.zzdxq;
        }
        if (this.zzdxr != 0) {
            zzaqv.zzdxr = this.zzdxr;
        }
        if (!TextUtils.isEmpty(this.zzdxs)) {
            zzaqv.zzdxs = this.zzdxs;
        }
        if (!TextUtils.isEmpty(this.zzdxt)) {
            String str = this.zzdxt;
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            zzaqv.zzdxt = str;
        }
        if (this.zzdxu) {
            zzaqv.zzdxu = this.zzdxu;
        }
        if (this.zzdxv) {
            zzaqv.zzdxv = this.zzdxv;
        }
    }

    public final String zzxk() {
        return this.zzaqh;
    }

    public final int zzxl() {
        return this.zzdxq;
    }

    public final String zzxm() {
        return this.zzdxt;
    }
}
