package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzgf extends zzbr {
    private static final String ID = zzbh.TIME.toString();

    public zzgf() {
        super(ID, new String[0]);
    }

    public final boolean zzbfh() {
        return false;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return zzgk.zzam(Long.valueOf(System.currentTimeMillis()));
    }
}
