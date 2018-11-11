package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbt;
import java.util.Map;

final class zzl extends zzbr {
    private static final String ID = zzbh.APP_VERSION_NAME.toString();
    private final Context mContext;

    public zzl(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public final boolean zzbfh() {
        return true;
    }

    public final zzbt zzx(Map<String, zzbt> map) {
        try {
            return zzgk.zzam(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            String packageName = this.mContext.getPackageName();
            String message = e.getMessage();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(packageName).length() + 25) + String.valueOf(message).length());
            stringBuilder.append("Package name ");
            stringBuilder.append(packageName);
            stringBuilder.append(" not found. ");
            stringBuilder.append(message);
            zzdj.e(stringBuilder.toString());
            return zzgk.zzbil();
        }
    }
}
