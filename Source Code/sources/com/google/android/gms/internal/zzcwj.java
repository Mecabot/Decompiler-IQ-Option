package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zzh;
import java.util.Collection;

final class zzcwj extends zzcwl {
    private /* synthetic */ Collection zzkij;

    zzcwj(zzcwf zzcwf, GoogleApiClient googleApiClient, Collection collection) {
        this.zzkij = collection;
        super(googleApiClient, null);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzh) zzb).zza(this, this.zzkij);
    }
}
