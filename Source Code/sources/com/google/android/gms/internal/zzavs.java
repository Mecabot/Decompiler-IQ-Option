package com.google.android.gms.internal;

import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

final class zzavs extends zzm<AddAccountResult, zzawa> {
    private /* synthetic */ String zzehu;

    zzavs(zzavq zzavq, Api api, GoogleApiClient googleApiClient, String str) {
        this.zzehu = str;
        super(api, googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzc) ((zzawa) zzb).zzalw()).zza(new zzavt(this), this.zzehu);
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return new zzavx(status, null);
    }
}
