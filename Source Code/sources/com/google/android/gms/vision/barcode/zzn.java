package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.vision.barcode.Barcode.WiFi;

@Hide
public final class zzn implements Creator<WiFi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 4:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new WiFi(str, str2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WiFi[i];
    }
}
