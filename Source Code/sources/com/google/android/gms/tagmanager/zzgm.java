package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzgm extends zzbr {
    private static final String ID = zzbh.UPPERCASE_STRING.toString();
    private static final String zzkpn = zzbi.ARG0.toString();

    public zzgm() {
        super(ID, zzkpn);
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return zzgk.zzam(zzgk.zzd((zzbt) map.get(zzkpn)).toUpperCase());
    }
}
