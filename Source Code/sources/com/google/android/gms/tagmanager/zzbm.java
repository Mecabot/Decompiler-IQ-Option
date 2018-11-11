package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

@Hide
public final class zzbm extends zzga {
    private static final String ID = zzbh.EQUALS.toString();

    public zzbm() {
        super(ID);
    }

    protected final boolean zza(String str, String str2, Map<String, zzbt> map) {
        return str.equals(str2);
    }
}
