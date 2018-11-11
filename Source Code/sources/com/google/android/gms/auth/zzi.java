package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzayl;
import com.google.android.gms.internal.zzez;

final class zzi implements zzj<Boolean> {
    private /* synthetic */ String zzehx;

    zzi(String str) {
        this.zzehx = str;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) {
        Bundle bundle = (Bundle) zzd.zzp(zzez.zza(iBinder).zzp(this.zzehx));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzayl zzfi = zzayl.zzfi(string);
        if (zzayl.SUCCESS.equals(zzfi)) {
            return Boolean.valueOf(true);
        }
        if (zzayl.zza(zzfi)) {
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(zzfi);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 31);
            stringBuilder.append("isUserRecoverableError status: ");
            stringBuilder.append(valueOf);
            objArr[0] = stringBuilder.toString();
            zzd.zzehr.zzf("GoogleAuthUtil", objArr);
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
