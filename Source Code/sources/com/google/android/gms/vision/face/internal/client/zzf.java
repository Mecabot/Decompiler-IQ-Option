package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzex;

public final class zzf extends zzev implements zze {
    zzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final void zzblm() {
        zzb(3, zzbc());
    }

    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzdld zzdld) {
        Parcel zzbc = zzbc();
        zzex.zza(zzbc, (IInterface) iObjectWrapper);
        zzex.zza(zzbc, (Parcelable) zzdld);
        Parcel zza = zza(1, zzbc);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza.createTypedArray(FaceParcel.CREATOR);
        zza.recycle();
        return faceParcelArr;
    }

    public final boolean zzfo(int i) {
        Parcel zzbc = zzbc();
        zzbc.writeInt(i);
        Parcel zza = zza(2, zzbc);
        boolean zza2 = zzex.zza(zza);
        zza.recycle();
        return zza2;
    }
}
