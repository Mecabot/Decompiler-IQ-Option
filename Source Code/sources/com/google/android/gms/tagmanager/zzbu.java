package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbu extends zzdz {
    private static final String ID = zzbh.GREATER_THAN.toString();

    public zzbu() {
        super(ID);
    }

    protected final boolean zza(zzgj zzgj, zzgj zzgj2, Map<String, zzbt> map) {
        return zzgj.compareTo(zzgj2) > 0;
    }
}
