package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzt extends zzbr {
    private static final String ID = zzbh.CONSTANT.toString();
    private static final String VALUE = zzbi.VALUE.toString();

    public zzt() {
        super(ID, VALUE);
    }

    public static String zzbfj() {
        return ID;
    }

    public static String zzbfk() {
        return VALUE;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return (zzbt) map.get(VALUE);
    }
}
