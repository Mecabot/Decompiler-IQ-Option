package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzcwn.zze;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzcwv implements Creator<zze> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Set hashSet = new HashSet();
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    readInt = 1;
                    break;
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    readInt = 2;
                    break;
                case 3:
                    str2 = zzbgm.zzq(parcel, readInt);
                    readInt = 3;
                    break;
                case 4:
                    str3 = zzbgm.zzq(parcel, readInt);
                    readInt = 4;
                    break;
                case 5:
                    str4 = zzbgm.zzq(parcel, readInt);
                    readInt = 5;
                    break;
                case 6:
                    str5 = zzbgm.zzq(parcel, readInt);
                    readInt = 6;
                    break;
                case 7:
                    z = zzbgm.zzc(parcel, readInt);
                    readInt = 7;
                    break;
                case 8:
                    str6 = zzbgm.zzq(parcel, readInt);
                    readInt = 8;
                    break;
                case 9:
                    str7 = zzbgm.zzq(parcel, readInt);
                    readInt = 9;
                    break;
                case 10:
                    i2 = zzbgm.zzg(parcel, readInt);
                    readInt = 10;
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    continue;
            }
            hashSet.add(Integer.valueOf(readInt));
        }
        if (parcel.dataPosition() == zzd) {
            return new zze(hashSet, i, str, str2, str3, str4, str5, z, str6, str7, i2);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(zzd);
        throw new zzbgn(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
