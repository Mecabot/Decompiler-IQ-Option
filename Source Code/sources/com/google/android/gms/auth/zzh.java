package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzez;

final class zzh implements zzj<Bundle> {
    private /* synthetic */ Account zzehs;

    zzh(Account account) {
        this.zzehs = account;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) {
        return (Bundle) zzd.zzp(zzez.zza(iBinder).zza(this.zzehs));
    }
}
