package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzaqp extends zzi<zzaqp> {
    private final Map<String, Object> zzbwu = new HashMap();

    public final void set(String str, String str2) {
        zzbq.zzgv(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        zzbq.zzh(str, "Name can not be empty or \"&\"");
        this.zzbwu.put(str, str2);
    }

    public final String toString() {
        return zzi.zzl(this.zzbwu);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaqp zzaqp = (zzaqp) zzi;
        zzbq.checkNotNull(zzaqp);
        zzaqp.zzbwu.putAll(this.zzbwu);
    }

    public final Map<String, Object> zzwy() {
        return Collections.unmodifiableMap(this.zzbwu);
    }
}
