package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzbgn;
import java.util.HashSet;
import java.util.Set;

@Hide
public final class zzu implements Creator<zzt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Set hashSet = new HashSet();
        String str = null;
        byte[] bArr = str;
        PendingIntent pendingIntent = bArr;
        DeviceMetaData deviceMetaData = pendingIntent;
        int i = 0;
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
                    i2 = zzbgm.zzg(parcel, readInt);
                    readInt = 3;
                    break;
                case 4:
                    bArr = zzbgm.zzt(parcel, readInt);
                    readInt = 4;
                    break;
                case 5:
                    pendingIntent = (PendingIntent) zzbgm.zza(parcel, readInt, PendingIntent.CREATOR);
                    readInt = 5;
                    break;
                case 6:
                    deviceMetaData = (DeviceMetaData) zzbgm.zza(parcel, readInt, DeviceMetaData.CREATOR);
                    readInt = 6;
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    continue;
            }
            hashSet.add(Integer.valueOf(readInt));
        }
        if (parcel.dataPosition() == zzd) {
            return new zzt(hashSet, i, str, i2, bArr, pendingIntent, deviceMetaData);
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(zzd);
        throw new zzbgn(stringBuilder.toString(), parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
