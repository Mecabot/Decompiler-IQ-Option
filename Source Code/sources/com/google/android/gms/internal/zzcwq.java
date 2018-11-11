package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzcwn.zzb;
import com.google.android.gms.internal.zzcwn.zzb.zza;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzcwq implements Creator<zzb> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        zza zza = null;
        zzb.zzb zzb = zza;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    readInt = 1;
                    break;
                case 2:
                    zza = (zza) zzbgm.zza(parcel, readInt, zza.CREATOR);
                    readInt = 2;
                    break;
                case 3:
                    zzb = (zzb.zzb) zzbgm.zza(parcel, readInt, zzb.zzb.CREATOR);
                    readInt = 3;
                    break;
                case 4:
                    i2 = zzbgm.zzg(parcel, readInt);
                    readInt = 4;
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    continue;
            }
            hashSet.add(Integer.valueOf(readInt));
        }
        if (parcel.dataPosition() == zzd) {
            return new zzb(hashSet, i, zza, zzb, i2);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(zzd);
        throw new zzbgn(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzb[i];
    }
}
