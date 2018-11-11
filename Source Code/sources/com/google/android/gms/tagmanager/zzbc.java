package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbc extends zzbr {
    private static final String ID = zzbh.DEVICE_ID.toString();
    private final Context mContext;

    public zzbc(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        String string = Secure.getString(this.mContext.getContentResolver(), "android_id");
        return string == null ? zzgk.zzbil() : zzgk.zzam(string);
    }
}
