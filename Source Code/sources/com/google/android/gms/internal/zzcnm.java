package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzcnm implements Creator<zzcnl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        Long l = str;
        Float f = l;
        String str2 = f;
        String str3 = str2;
        Double d = str3;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel2, readInt);
                    break;
                case 2:
                    str = zzbgm.zzq(parcel2, readInt);
                    break;
                case 3:
                    j = zzbgm.zzi(parcel2, readInt);
                    break;
                case 4:
                    l = zzbgm.zzj(parcel2, readInt);
                    break;
                case 5:
                    f = zzbgm.zzm(parcel2, readInt);
                    break;
                case 6:
                    str2 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 7:
                    str3 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 8:
                    d = zzbgm.zzo(parcel2, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel2, zzd);
        return new zzcnl(i, str, j, l, f, str2, str3, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcnl[i];
    }
}
