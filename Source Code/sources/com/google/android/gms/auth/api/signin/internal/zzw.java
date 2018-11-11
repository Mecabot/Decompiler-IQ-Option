package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zzw extends zzev implements zzv {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zza(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzt);
        zzex.zza(zzbc, (Parcelable) googleSignInOptions);
        zzb(101, zzbc);
    }

    public final void zzb(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzt);
        zzex.zza(zzbc, (Parcelable) googleSignInOptions);
        zzb(102, zzbc);
    }

    public final void zzc(zzt zzt, GoogleSignInOptions googleSignInOptions) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zzt);
        zzex.zza(zzbc, (Parcelable) googleSignInOptions);
        zzb(103, zzbc);
    }
}
