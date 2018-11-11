package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Hide
public final class zzaqn extends zzi<zzaqn> {
    private Map<Integer, String> zzdwy = new HashMap(4);

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzdwy.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 9);
            stringBuilder.append("dimension");
            stringBuilder.append(valueOf);
            hashMap.put(stringBuilder.toString(), entry.getValue());
        }
        return zzi.zzl(hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        ((zzaqn) zzi).zzdwy.putAll(this.zzdwy);
    }

    public final Map<Integer, String> zzww() {
        return Collections.unmodifiableMap(this.zzdwy);
    }
}
