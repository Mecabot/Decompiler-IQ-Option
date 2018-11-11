package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Hide
public final class zzaqo extends zzi<zzaqo> {
    private Map<Integer, Double> zzdwz = new HashMap(4);

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzdwz.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 6);
            stringBuilder.append("metric");
            stringBuilder.append(valueOf);
            hashMap.put(stringBuilder.toString(), entry.getValue());
        }
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        ((zzaqo) zzi).zzdwz.putAll(this.zzdwz);
    }

    public final Map<Integer, Double> zzwx() {
        return Collections.unmodifiableMap(this.zzdwz);
    }
}
