package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zza implements Creator<ProxyRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        byte[] bArr = str;
        Bundle bundle = bArr;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = SupportMenu.USER_MASK & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        str = zzbgm.zzq(parcel, readInt);
                        break;
                    case 2:
                        i2 = zzbgm.zzg(parcel, readInt);
                        break;
                    case 3:
                        j = zzbgm.zzi(parcel, readInt);
                        break;
                    case 4:
                        bArr = zzbgm.zzt(parcel, readInt);
                        break;
                    case 5:
                        bundle = zzbgm.zzs(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            }
            i = zzbgm.zzg(parcel, readInt);
        }
        zzbgm.zzaf(parcel, zzd);
        return new ProxyRequest(i, str, i2, j, bArr, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
