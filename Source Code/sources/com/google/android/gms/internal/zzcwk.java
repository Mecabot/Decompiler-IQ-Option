package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zzh;

final class zzcwk extends zzcwl {
    private /* synthetic */ String[] zzkik;

    zzcwk(zzcwf zzcwf, GoogleApiClient googleApiClient, String[] strArr) {
        this.zzkik = strArr;
        super(googleApiClient, null);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        ((zzh) zzb).zzc(this, this.zzkik);
    }
}
