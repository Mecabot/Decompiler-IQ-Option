package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zzh;

final class zzcwg extends zzcwl {
    private /* synthetic */ int zzkih;
    private /* synthetic */ String zzkii;

    zzcwg(zzcwf zzcwf, GoogleApiClient googleApiClient, int i, String str) {
        this.zzkih = i;
        this.zzkii = str;
        super(googleApiClient, null);
    }

    protected final /* synthetic */ void zza(zzb zzb) {
        zza(((zzh) zzb).zza(this, this.zzkih, this.zzkii));
    }
}
