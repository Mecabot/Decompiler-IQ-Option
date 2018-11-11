package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzbhe extends zzev implements zzbhd {
    zzbhe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zza(zzbhb zzbhb) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzbhb);
        zzc(1, zzbc);
    }
}
