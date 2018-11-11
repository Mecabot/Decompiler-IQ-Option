package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Iterator;
import java.util.Map;

@Hide
public abstract class zzeg extends zzbr {
    private static final String zzkpn = zzbi.ARG0.toString();
    private static final String zzkrk = zzbi.ARG1.toString();

    public zzeg(String str) {
        super(str, zzkpn, zzkrk);
    }

    protected abstract boolean zza(zzbt zzbt, zzbt zzbt2, Map<String, zzbt> map);

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        boolean z;
        Iterator it = map.values().iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                zzbt zzbt = (zzbt) map.get(zzkpn);
                zzbt zzbt2 = (zzbt) map.get(zzkrk);
                if (!(zzbt == null || zzbt2 == null)) {
                    z = zza(zzbt, zzbt2, map);
                }
            }
            return zzgk.zzam(Boolean.valueOf(z));
        } while (((zzbt) it.next()) != zzgk.zzbil());
        return zzgk.zzam(Boolean.valueOf(z));
    }
}
