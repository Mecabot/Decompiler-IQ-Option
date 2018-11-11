package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzayl;
import com.google.android.gms.internal.zzez;
import java.io.IOException;

final class zze implements zzj<TokenData> {
    private /* synthetic */ Bundle val$options;
    private /* synthetic */ Account zzehs;
    private /* synthetic */ String zzeht;

    zze(Account account, String str, Bundle bundle) {
        this.zzehs = account;
        this.zzeht = str;
        this.val$options = bundle;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) {
        Bundle bundle = (Bundle) zzd.zzp(zzez.zza(iBinder).zza(this.zzehs, this.zzeht, this.val$options));
        TokenData zzc = TokenData.zzc(bundle, "tokenDetails");
        if (zzc != null) {
            return zzc;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzayl zzfi = zzayl.zzfi(string);
        int i = 0;
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
        if (zzayl.NETWORK_ERROR.equals(zzfi) || zzayl.SERVICE_UNAVAILABLE.equals(zzfi)) {
            i = 1;
        }
        if (i != 0) {
            throw new IOException(string);
        }
        throw new GoogleAuthException(string);
    }
}
