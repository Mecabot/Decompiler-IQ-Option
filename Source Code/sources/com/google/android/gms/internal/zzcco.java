package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzcco extends zzev implements zzccm {
    zzcco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final boolean getBooleanFlagValue(String str, boolean z, int i) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzex.zza(zzbc, z);
        zzbc.writeInt(i);
        Parcel zza = zza(2, zzbc);
        z = zzex.zza(zza);
        zza.recycle();
        return z;
    }

    public final int getIntFlagValue(String str, int i, int i2) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeInt(i);
        zzbc.writeInt(i2);
        Parcel zza = zza(3, zzbc);
        i = zza.readInt();
        zza.recycle();
        return i;
    }

    public final long getLongFlagValue(String str, long j, int i) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeLong(j);
        zzbc.writeInt(i);
        Parcel zza = zza(4, zzbc);
        j = zza.readLong();
        zza.recycle();
        return j;
    }

    public final String getStringFlagValue(String str, String str2, int i) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzbc.writeInt(i);
        Parcel zza = zza(5, zzbc);
        str2 = zza.readString();
        zza.recycle();
        return str2;
    }

    public final void init(IObjectWrapper iObjectWrapper) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) iObjectWrapper);
        zzb(1, zzbc);
    }
}
