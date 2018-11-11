package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzbgn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzm implements Creator<zzl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzo zzo = arrayList;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    readInt = 1;
                    break;
                case 2:
                    arrayList = zzbgm.zzc(parcel, readInt, zzr.CREATOR);
                    readInt = 2;
                    break;
                case 3:
                    i2 = zzbgm.zzg(parcel, readInt);
                    readInt = 3;
                    break;
                case 4:
                    zzo = (zzo) zzbgm.zza(parcel, readInt, zzo.CREATOR);
                    readInt = 4;
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    continue;
            }
            hashSet.add(Integer.valueOf(readInt));
        }
        if (parcel.dataPosition() == zzd) {
            return new zzl(hashSet, i, arrayList, i2, zzo);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(zzd);
        throw new zzbgn(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }
}
