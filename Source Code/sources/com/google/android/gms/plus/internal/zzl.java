package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzl implements Creator<PlusCommonExtras> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 != 1000) {
                switch (i2) {
                    case 1:
                        str = zzbgm.zzq(parcel, readInt);
                        break;
                    case 2:
                        str2 = zzbgm.zzq(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            }
            i = zzbgm.zzg(parcel, readInt);
        }
        zzbgm.zzaf(parcel, zzd);
        return new PlusCommonExtras(i, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PlusCommonExtras[i];
    }
}
