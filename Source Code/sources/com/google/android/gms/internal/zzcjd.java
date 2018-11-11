package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class zzcjd extends zzev implements zzcjb {
    zzcjd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzcnl> zza(zzcif zzcif, boolean z) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzex.zza(zzbc, z);
        Parcel zza = zza(7, zzbc);
        List createTypedArrayList = zza.createTypedArrayList(zzcnl.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzcii> zza(String str, String str2, zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzex.zza(zzbc, (Parcelable) zzcif);
        Parcel zza = zza(16, zzbc);
        List createTypedArrayList = zza.createTypedArrayList(zzcii.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzcnl> zza(String str, String str2, String str3, boolean z) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzbc.writeString(str3);
        zzex.zza(zzbc, z);
        Parcel zza = zza(15, zzbc);
        List createTypedArrayList = zza.createTypedArrayList(zzcnl.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzcnl> zza(String str, String str2, boolean z, zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzex.zza(zzbc, z);
        zzex.zza(zzbc, (Parcelable) zzcif);
        Parcel zza = zza(14, zzbc);
        List createTypedArrayList = zza.createTypedArrayList(zzcnl.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zza(long j, String str, String str2, String str3) {
        Parcel zzbc = zzbc();
        zzbc.writeLong(j);
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzbc.writeString(str3);
        zzb(10, zzbc);
    }

    public final void zza(zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzb(4, zzbc);
    }

    public final void zza(zzcii zzcii, zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcii);
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzb(12, zzbc);
    }

    public final void zza(zzcix zzcix, zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcix);
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzb(1, zzbc);
    }

    public final void zza(zzcix zzcix, String str, String str2) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcix);
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzb(5, zzbc);
    }

    public final void zza(zzcnl zzcnl, zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcnl);
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzb(2, zzbc);
    }

    public final byte[] zza(zzcix zzcix, String str) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcix);
        zzbc.writeString(str);
        Parcel zza = zza(9, zzbc);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zzb(zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzb(6, zzbc);
    }

    public final void zzb(zzcii zzcii) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcii);
        zzb(13, zzbc);
    }

    public final String zzc(zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcif);
        Parcel zza = zza(11, zzbc);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzd(zzcif zzcif) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (Parcelable) zzcif);
        zzb(18, zzbc);
    }

    public final List<zzcii> zzk(String str, String str2, String str3) {
        Parcel zzbc = zzbc();
        zzbc.writeString(str);
        zzbc.writeString(str2);
        zzbc.writeString(str3);
        Parcel zza = zza(17, zzbc);
        List createTypedArrayList = zza.createTypedArrayList(zzcii.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }
}
