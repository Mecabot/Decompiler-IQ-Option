package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbl extends zzga {
    private static final String ID = zzbh.ENDS_WITH.toString();

    public zzbl() {
        super(ID);
    }

    protected final boolean zza(String str, String str2, Map<String, zzbt> map) {
        return str.endsWith(str2);
    }
}
