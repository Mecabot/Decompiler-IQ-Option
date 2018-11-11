package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzb implements Creator<ProxyResponse> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundle = pendingIntent;
        byte[] bArr = bundle;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i4 = SupportMenu.USER_MASK & readInt;
            if (i4 != 1000) {
                switch (i4) {
                    case 1:
                        i2 = zzbgm.zzg(parcel, readInt);
                        break;
                    case 2:
                        pendingIntent = (PendingIntent) zzbgm.zza(parcel, readInt, PendingIntent.CREATOR);
                        break;
                    case 3:
                        i3 = zzbgm.zzg(parcel, readInt);
                        break;
                    case 4:
                        bundle = zzbgm.zzs(parcel, readInt);
                        break;
                    case 5:
                        bArr = zzbgm.zzt(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            }
            i = zzbgm.zzg(parcel, readInt);
        }
        zzbgm.zzaf(parcel, zzd);
        return new ProxyResponse(i, i2, pendingIntent, i3, bundle, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
