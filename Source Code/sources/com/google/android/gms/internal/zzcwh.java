package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zzh;

final class zzcwh extends zzcwl {
    private /* synthetic */ String zzkii;

    zzcwh(zzcwf zzcwf, GoogleApiClient googleApiClient, String str) {
        this.zzkii = str;
        super(googleApiClient, null);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        zza(((zzh) zzb).zza(this, 0, this.zzkii));
    }
}
