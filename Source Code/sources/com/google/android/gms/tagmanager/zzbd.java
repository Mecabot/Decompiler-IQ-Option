package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzbd extends zzbr {
    private static final String ID = zzbh.DEVICE_NAME.toString();

    public zzbd() {
        super(ID, new String[0]);
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals("unknown"))) {
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(obj).length());
            stringBuilder.append(str);
            stringBuilder.append(" ");
            stringBuilder.append(obj);
            obj = stringBuilder.toString();
        }
        return zzgk.zzam(obj);
    }
}
