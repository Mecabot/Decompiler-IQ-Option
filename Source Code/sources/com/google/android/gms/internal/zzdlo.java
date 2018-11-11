package com.google.android.gms.internal;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzdlo implements Creator<zzdln> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        Rect rect = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((SupportMenu.USER_MASK & readInt) != 2) {
                zzbgm.zzb(parcel, readInt);
            } else {
                rect = (Rect) zzbgm.zza(parcel, readInt, Rect.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzdln(rect);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdln[i];
    }
}
