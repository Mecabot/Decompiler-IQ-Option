package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzeb extends zzbr {
    private static final String ID = zzbh.OS_VERSION.toString();

    public zzeb() {
        super(ID, new String[0]);
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return zzgk.zzam(VERSION.RELEASE);
    }
}
