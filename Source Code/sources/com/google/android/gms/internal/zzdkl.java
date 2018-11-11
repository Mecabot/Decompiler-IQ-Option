package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzdkl {
    private final String zzfli;
    private final List<zzdkn> zzlcb;
    private final Map<String, List<zzdkj>> zzlcc;
    private final int zzlcd;

    private zzdkl(List<zzdkn> list, Map<String, List<zzdkj>> map, String str, int i) {
        this.zzlcb = Collections.unmodifiableList(list);
        this.zzlcc = Collections.unmodifiableMap(map);
        this.zzfli = str;
        this.zzlcd = i;
    }

    public static zzdkm zzbkw() {
        return new zzdkm();
    }

    public final String getVersion() {
        return this.zzfli;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzlcb);
        String valueOf2 = String.valueOf(this.zzlcc);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 17) + String.valueOf(valueOf2).length());
        stringBuilder.append("Rules: ");
        stringBuilder.append(valueOf);
        stringBuilder.append("  Macros: ");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }

    public final List<zzdkn> zzbkb() {
        return this.zzlcb;
    }

    public final Map<String, List<zzdkj>> zzbkx() {
        return this.zzlcc;
    }
}
