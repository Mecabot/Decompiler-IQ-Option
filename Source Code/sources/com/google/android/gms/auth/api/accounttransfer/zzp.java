package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.List;

@Hide
public final class zzp implements Creator<zzo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        List list = null;
        List list2 = list;
        List list3 = list2;
        List list4 = list3;
        List list5 = list4;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 2:
                    list = zzbgm.zzac(parcel, readInt);
                    break;
                case 3:
                    list2 = zzbgm.zzac(parcel, readInt);
                    break;
                case 4:
                    list3 = zzbgm.zzac(parcel, readInt);
                    break;
                case 5:
                    list4 = zzbgm.zzac(parcel, readInt);
                    break;
                case 6:
                    list5 = zzbgm.zzac(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzo(i, list, list2, list3, list4, list5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
