package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzd implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        float f = -1.0f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbgm.zzg(parcel, readInt);
                    break;
                case 5:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                case 6:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 7:
                    f = zzbgm.zzl(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzc(i, i2, i3, z, z2, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
