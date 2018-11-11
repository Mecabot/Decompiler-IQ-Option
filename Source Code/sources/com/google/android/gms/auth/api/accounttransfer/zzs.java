package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzbgn;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzs implements Creator<zzr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        zzt zzt = null;
        String str = zzt;
        String str2 = str;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    readInt = 1;
                    break;
                case 2:
                    zzt = (zzt) zzbgm.zza(parcel, readInt, zzt.CREATOR);
                    readInt = 2;
                    break;
                case 3:
                    str = zzbgm.zzq(parcel, readInt);
                    readInt = 3;
                    break;
                case 4:
                    str2 = zzbgm.zzq(parcel, readInt);
                    readInt = 4;
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    continue;
            }
            hashSet.add(Integer.valueOf(readInt));
        }
        if (parcel.dataPosition() == zzd) {
            return new zzr(hashSet, i, zzt, str, str2);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(zzd);
        throw new zzbgn(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
