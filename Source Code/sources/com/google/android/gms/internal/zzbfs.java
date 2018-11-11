package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zze;

public final class zzbfs extends zzev implements zzbfr {
    zzbfs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    public final void zza(zzbfp zzbfp, zze zze) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzbfp);
        zzex.zza(zzbc, (Parcelable) zze);
        zzc(1, zzbc);
    }
}
