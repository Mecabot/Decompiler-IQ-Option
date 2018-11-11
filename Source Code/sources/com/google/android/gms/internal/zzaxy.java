package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzaxy extends zzev implements zzaxx {
    zzaxy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void zza(zzaxz zzaxz) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzaxz);
        zzb(1, zzbc);
    }
}
