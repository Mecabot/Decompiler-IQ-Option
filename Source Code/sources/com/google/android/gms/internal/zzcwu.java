package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzcwn.zzd;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzcwu implements Creator<zzd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
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
                    str6 = zzbgm.zzq(parcel, readInt);
                    readInt = 7;
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    continue;
            }
            hashSet.add(Integer.valueOf(readInt));
        }
        if (parcel.dataPosition() == zzd) {
            return new zzd(hashSet, i, str, str2, str3, str4, str5, str6);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(zzd);
        throw new zzbgn(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzd[i];
    }
}
