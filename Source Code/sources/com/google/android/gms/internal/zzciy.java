package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzciy implements Creator<zzcix> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        zzciu zzciu = str;
        String str2 = zzciu;
        long j = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    zzciu = (zzciu) zzbgm.zza(parcel, readInt, zzciu.CREATOR);
                    break;
                case 4:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 5:
                    j = zzbgm.zzi(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzcix(str, zzciu, str2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcix[i];
    }
}
