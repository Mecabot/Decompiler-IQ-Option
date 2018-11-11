package com.google.android.gms.plus.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zze extends zzev implements zzd {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.plus.internal.IPlusOneButtonCreator");
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, int i, int i2, String str, int i3) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) iObjectWrapper);
        zzbc.writeInt(i);
        zzbc.writeInt(i2);
        zzbc.writeString(str);
        zzbc.writeInt(i3);
        Parcel zza = zza(1, zzbc);
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }
}
