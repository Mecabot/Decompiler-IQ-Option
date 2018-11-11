package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzdn extends zzbr {
    private static final String ID = zzbh.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context mContext;

    public zzdn(Context context) {
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
