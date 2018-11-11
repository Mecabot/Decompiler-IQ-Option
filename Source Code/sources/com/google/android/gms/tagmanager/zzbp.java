package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbp extends zzbr {
    private static final String ID = zzbh.EVENT.toString();
    private final zzfc zzkne;

    public zzbp(zzfc zzfc) {
        super(ID, new String[0]);
        this.zzkne = zzfc;
    }

    public final boolean zzbfh() {
        return false;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        String zzbho = this.zzkne.zzbho();
        return zzbho == null ? zzgk.zzbil() : zzgk.zzam(zzbho);
    }
}
