package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzbfw implements Creator<zzbfv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        int i = 0;
        int i2 = 0;
        boolean z = true;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 5:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    str3 = zzbgm.zzq(parcel, readInt);
                    break;
                case 7:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 8:
                    str4 = zzbgm.zzq(parcel, readInt);
                    break;
                case 9:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 10:
                    i3 = zzbgm.zzg(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzbfv(str, i, i2, str2, str3, z, str4, z2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbfv[i];
    }
}
