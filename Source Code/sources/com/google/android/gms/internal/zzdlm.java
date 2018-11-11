package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzdlm implements Creator<zzdll> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbgm.zzd(parcel);
        zzdlu[] zzdluArr = null;
        zzdlf zzdlf = zzdluArr;
        zzdlf zzdlf2 = zzdlf;
        zzdlf zzdlf3 = zzdlf2;
        String str = zzdlf3;
        String str2 = str;
        float f = 0.0f;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    zzdluArr = (zzdlu[]) zzbgm.zzb(parcel2, readInt, zzdlu.CREATOR);
                    break;
                case 3:
                    zzdlf = (zzdlf) zzbgm.zza(parcel2, readInt, zzdlf.CREATOR);
                    break;
                case 4:
                    zzdlf2 = (zzdlf) zzbgm.zza(parcel2, readInt, zzdlf.CREATOR);
                    break;
                case 5:
                    zzdlf3 = (zzdlf) zzbgm.zza(parcel2, readInt, zzdlf.CREATOR);
                    break;
                case 6:
                    str = zzbgm.zzq(parcel2, readInt);
                    break;
                case 7:
                    f = zzbgm.zzl(parcel2, readInt);
                    break;
                case 8:
                    str2 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 9:
                    i = zzbgm.zzg(parcel2, readInt);
                    break;
                case 10:
                    z = zzbgm.zzc(parcel2, readInt);
                    break;
                case 11:
                    i2 = zzbgm.zzg(parcel2, readInt);
                    break;
                case 12:
                    i3 = zzbgm.zzg(parcel2, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel2, zzd);
        return new zzdll(zzdluArr, zzdlf, zzdlf2, zzdlf3, str, f, str2, i, z, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdll[i];
    }
}
