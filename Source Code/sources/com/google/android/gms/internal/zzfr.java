package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

public final class zzfr extends zzev implements zzfp {
    zzfr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String getId() {
        Parcel zza = zza(1, zzbc());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean zzb(boolean z) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, true);
        zzbc = zza(2, zzbc);
        boolean zza = zzex.zza(zzbc);
        zzbc.recycle();
        return zza;
    }

    public final boolean zzbn() {
        Parcel zza = zza(6, zzbc());
        boolean zza2 = zzex.zza(zza);
        zza.recycle();
        return zza2;
    }
}
