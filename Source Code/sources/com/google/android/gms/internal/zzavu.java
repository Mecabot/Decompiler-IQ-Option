package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

final class zzavu extends zzm<Result, zzawa> {
    private /* synthetic */ Account zzehs;

    zzavu(zzavq zzavq, Api api, GoogleApiClient googleApiClient, Account account) {
        this.zzehs = account;
        super(api, googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzc) ((zzawa) zzb).zzalw()).zza(new zzavv(this), this.zzehs);
    }

    protected final Result zzb(Status status) {
        return new zzavz(status);
    }
}
