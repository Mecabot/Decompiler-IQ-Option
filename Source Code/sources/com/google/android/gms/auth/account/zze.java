package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zze extends zzev implements zzc {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    public final void zza(zza zza, Account account) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zza);
        zzex.zza(zzbc, (Parcelable) account);
        zzb(3, zzbc);
    }

    public final void zza(zza zza, String str) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) zza);
        zzbc.writeString(str);
        zzb(2, zzbc);
    }

    public final void zzau(boolean z) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, z);
        zzb(1, zzbc);
    }
}
