package com.google.android.gms.common;

import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzm;

final class zzr extends zzp {
    private final String packageName;
    private final zzh zzfro;
    private final boolean zzfrp;
    private final boolean zzfrq;

    private zzr(String str, zzh zzh, boolean z, boolean z2) {
        super(false, null, null);
        this.packageName = str;
        this.zzfro = zzh;
        this.zzfrp = z;
        this.zzfrq = z2;
    }

    final String getErrorMessage() {
        String str = this.zzfrq ? "debug cert rejected" : "not whitelisted";
        String str2 = this.packageName;
        String zzn = zzm.zzn(zza.zzeq("SHA-1").digest(this.zzfro.getBytes()));
        boolean z = this.zzfrp;
        StringBuilder stringBuilder = new StringBuilder(((String.valueOf(str).length() + 44) + String.valueOf(str2).length()) + String.valueOf(zzn).length());
        stringBuilder.append(str);
        stringBuilder.append(": pkg=");
        stringBuilder.append(str2);
        stringBuilder.append(", sha1=");
        stringBuilder.append(zzn);
        stringBuilder.append(", atk=");
        stringBuilder.append(z);
        stringBuilder.append(", ver=12211278.false");
        return stringBuilder.toString();
    }
}
