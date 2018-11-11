package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzbu implements Creator<zzbt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = iBinder;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 2:
                    iBinder = zzbgm.zzr(parcel, readInt);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) zzbgm.zza(parcel, readInt, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzbt(i, iBinder, connectionResult, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbt[i];
    }
}
