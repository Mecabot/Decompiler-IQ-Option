package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.vision.barcode.Barcode.DriverLicense;

@Hide
public final class zzg implements Creator<DriverLicense> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
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
                    str5 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 7:
                    str6 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 8:
                    str7 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 9:
                    str8 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 10:
                    str9 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 11:
                    str10 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 12:
                    str11 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 13:
                    str12 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 14:
                    str13 = zzbgm.zzq(parcel2, readInt);
                    break;
                case 15:
                    str14 = zzbgm.zzq(parcel2, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel2, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel2, zzd);
        return new DriverLicense(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DriverLicense[i];
    }
}
