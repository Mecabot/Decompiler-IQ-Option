package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzi;
import java.util.HashMap;
import java.util.Map;

@Hide
public final class zzdkg {
    private final Context mContext;
    private final zze zzata;
    private String zzkog;
    private Map<String, Object> zzlbb;
    private final Map<String, Object> zzlbc;
    private final zzdkq zzldn;

    public zzdkg(Context context) {
        this(context, new HashMap(), new zzdkq(context), zzi.zzanq());
    }

    private zzdkg(Context context, Map<String, Object> map, zzdkq zzdkq, zze zze) {
        this.zzkog = null;
        this.zzlbb = new HashMap();
        this.mContext = context;
        this.zzata = zze;
        this.zzldn = zzdkq;
        this.zzlbc = map;
    }

    public final void zznm(String str) {
        this.zzkog = str;
    }
}
