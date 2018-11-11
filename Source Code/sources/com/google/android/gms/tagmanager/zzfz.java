package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzfz extends zzga {
    private static final String ID = zzbh.STARTS_WITH.toString();

    public zzfz() {
        super(ID);
    }

    protected final boolean zza(String str, String str2, Map<String, zzbt> map) {
        return str.startsWith(str2);
    }
}
