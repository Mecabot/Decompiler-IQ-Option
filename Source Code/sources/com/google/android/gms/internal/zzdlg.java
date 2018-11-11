package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzdlg implements Creator<zzdlf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbgm.zzg(parcel, readInt);
                    break;
                case 5:
                    i4 = zzbgm.zzg(parcel, readInt);
                    break;
                case 6:
                    f = zzbgm.zzl(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzdlf(i, i2, i3, i4, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdlf[i];
    }
}
