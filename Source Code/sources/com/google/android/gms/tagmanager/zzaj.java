package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzaj extends zzbr {
    private static final String ID = zzbh.CONTAINER_VERSION.toString();
    private final String zzfli;

    public zzaj(String str) {
        super(ID, new String[0]);
        this.zzfli = str;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return this.zzfli == null ? zzgk.zzbil() : zzgk.zzam(this.zzfli);
    }
}
