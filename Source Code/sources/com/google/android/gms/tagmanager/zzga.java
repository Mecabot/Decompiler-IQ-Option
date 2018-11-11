package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbt;
import java.util.Map;

abstract class zzga extends zzeg {
    public zzga(String str) {
        super(str);
    }

    protected final boolean zza(zzbt zzbt, zzbt zzbt2, Map<String, zzbt> map) {
        String zzd = zzgk.zzd(zzbt);
        String zzd2 = zzgk.zzd(zzbt2);
        return (zzd == zzgk.zzbik() || zzd2 == zzgk.zzbik()) ? false : zza(zzd, zzd2, (Map) map);
    }

    protected abstract boolean zza(String str, String str2, Map<String, zzbt> map);
}
