package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzez;

final class zzf implements zzj<Void> {
    private /* synthetic */ Bundle val$extras;
    private /* synthetic */ String zzehu;

    zzf(String str, Bundle bundle) {
        this.zzehu = str;
        this.val$extras = bundle;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) {
        Bundle bundle = (Bundle) zzd.zzp(zzez.zza(iBinder).zza(this.zzehu, this.val$extras));
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
