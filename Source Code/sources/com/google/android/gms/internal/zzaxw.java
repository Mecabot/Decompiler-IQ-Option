package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public final class zzaxw extends zzev implements zzaxv {
    zzaxw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void zza(zzaxt zzaxt, ProxyRequest proxyRequest) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzaxt);
        zzex.zza(zzbc, (Parcelable) proxyRequest);
        zzb(1, zzbc);
    }
}
