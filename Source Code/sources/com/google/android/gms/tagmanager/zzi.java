package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzi extends zzbr {
    private static final String ID = zzbh.APP_ID.toString();
    private final Context mContext;

    public zzi(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        return zzgk.zzam(this.mContext.getPackageName());
    }
}
