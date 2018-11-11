package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzk implements Creator<zzi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = str;
        byte[] bArr = str2;
        long j = 0;
        double d = 0.0d;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel2, readInt);
                    break;
                case 3:
                    j = zzbgm.zzi(parcel2, readInt);
                    break;
                case 4:
                    z = zzbgm.zzc(parcel2, readInt);
                    break;
                case 5:
                    d = zzbgm.zzn(parcel2, readInt);
                    break;
                case 6:
                    str2 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 7:
                    bArr = zzbgm.zzt(parcel2, readInt);
                    break;
                case 8:
                    i = zzbgm.zzg(parcel2, readInt);
                    break;
                case 9:
                    i2 = zzbgm.zzg(parcel2, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel2, zzd);
        return new zzi(str, j, z, d, str2, bArr, i, i2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzi[i];
    }
}
