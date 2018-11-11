package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzo implements Creator<zzn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String[] strArr = str;
        String[] strArr2 = strArr;
        String[] strArr3 = strArr2;
        String str2 = strArr3;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        PlusCommonExtras plusCommonExtras = str5;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 != 1000) {
                switch (i2) {
                    case 1:
                        str = zzbgm.zzq(parcel, readInt);
                        break;
                    case 2:
                        strArr = zzbgm.zzaa(parcel, readInt);
                        break;
                    case 3:
                        strArr2 = zzbgm.zzaa(parcel, readInt);
                        break;
                    case 4:
                        strArr3 = zzbgm.zzaa(parcel, readInt);
                        break;
                    case 5:
                        str2 = zzbgm.zzq(parcel, readInt);
                        break;
                    case 6:
                        str3 = zzbgm.zzq(parcel, readInt);
                        break;
                    case 7:
                        str4 = zzbgm.zzq(parcel, readInt);
                        break;
                    case 8:
                        str5 = zzbgm.zzq(parcel, readInt);
                        break;
                    case 9:
                        plusCommonExtras = (PlusCommonExtras) zzbgm.zza(parcel, readInt, PlusCommonExtras.CREATOR);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            }
            i = zzbgm.zzg(parcel, readInt);
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzn(i, str, strArr, strArr2, strArr3, str2, str3, str4, str5, plusCommonExtras);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzn[i];
    }
}
