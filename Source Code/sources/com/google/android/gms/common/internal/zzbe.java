package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zzbe extends zzev implements zzbd {
    zzbe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, zzbv zzbv) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) iObjectWrapper);
        zzex.zza(zzbc, (Parcelable) zzbv);
        Parcel zza = zza(2, zzbc);
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }
}
