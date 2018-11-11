package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public final class zzaxo extends zzev implements zzaxn {
    zzaxo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zza(zzaxl zzaxl) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzaxl);
        zzb(4, zzbc);
    }

    public final void zza(zzaxl zzaxl, CredentialRequest credentialRequest) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzaxl);
        zzex.zza(zzbc, (Parcelable) credentialRequest);
        zzb(1, zzbc);
    }

    public final void zza(zzaxl zzaxl, zzaxj zzaxj) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzaxl);
        zzex.zza(zzbc, (Parcelable) zzaxj);
        zzb(3, zzbc);
    }

    public final void zza(zzaxl zzaxl, zzaxp zzaxp) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzaxl);
        zzex.zza(zzbc, (Parcelable) zzaxp);
        zzb(2, zzbc);
    }
}
