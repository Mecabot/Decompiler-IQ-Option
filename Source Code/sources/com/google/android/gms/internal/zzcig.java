package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzcig implements Creator<zzcif> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbgm.zzd(parcel);
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        long j5 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel2, readInt);
                    break;
                case 3:
                    str2 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 4:
                    str3 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 5:
                    str4 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 6:
                    j = zzbgm.zzi(parcel2, readInt);
                    break;
                case 7:
                    j2 = zzbgm.zzi(parcel2, readInt);
                    break;
                case 8:
                    str5 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 9:
                    z = zzbgm.zzc(parcel2, readInt);
                    break;
                case 10:
                    z2 = zzbgm.zzc(parcel2, readInt);
                    break;
                case 11:
                    j5 = zzbgm.zzi(parcel2, readInt);
                    break;
                case 12:
                    str6 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 13:
                    j3 = zzbgm.zzi(parcel2, readInt);
                    break;
                case 14:
                    j4 = zzbgm.zzi(parcel2, readInt);
                    break;
                case 15:
                    i = zzbgm.zzg(parcel2, readInt);
                    break;
                case 16:
                    z3 = zzbgm.zzc(parcel2, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel2, zzd);
        return new zzcif(str, str2, str3, str4, j, j2, str5, z, z2, j5, str6, j3, j4, i, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcif[i];
    }
}
