package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzas extends zzbr {
    private static final String ID = zzbh.CUSTOM_VAR.toString();
    private static final String NAME = zzbi.NAME.toString();
    private static final String zzkos = zzbi.DEFAULT_VALUE.toString();
    private final DataLayer zzknd;

    public zzas(DataLayer dataLayer) {
        super(ID, NAME);
        this.zzknd = dataLayer;
    }

    public final boolean zzbfh() {
        return false;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        Object obj = this.zzknd.get(zzgk.zzd((zzbt) map.get(NAME)));
        if (obj != null) {
            return zzgk.zzam(obj);
        }
        zzbt zzbt = (zzbt) map.get(zzkos);
        return zzbt != null ? zzbt : zzgk.zzbil();
    }
}
