package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus.zza;

abstract class zzcwl extends zza<LoadPeopleResult> {
    private zzcwl(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* synthetic */ zzcwl(GoogleApiClient googleApiClient, zzcwg zzcwg) {
        this(googleApiClient);
    }

    public final /* synthetic */ Result zzb(Status status) {
        return new zzcwm(this, status);
    }
}
