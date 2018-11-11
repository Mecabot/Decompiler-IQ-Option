package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzawo extends zzev implements zzawn {
    zzawo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
    }

    public final void zza(zzawl zzawl, zzawj zzawj) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzawl);
        zzex.zza(zzbc, (Parcelable) zzawj);
        zzb(7, zzbc);
    }

    public final void zza(zzawl zzawl, zzawp zzawp) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzawl);
        zzex.zza(zzbc, (Parcelable) zzawp);
        zzb(9, zzbc);
    }

    public final void zza(zzawl zzawl, zzawr zzawr) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzawl);
        zzex.zza(zzbc, (Parcelable) zzawr);
        zzb(6, zzbc);
    }

    public final void zza(zzawl zzawl, zzawt zzawt) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzawl);
        zzex.zza(zzbc, (Parcelable) zzawt);
        zzb(5, zzbc);
    }

    public final void zza(zzawl zzawl, zzawv zzawv) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzawl);
        zzex.zza(zzbc, (Parcelable) zzawv);
        zzb(8, zzbc);
    }
}
