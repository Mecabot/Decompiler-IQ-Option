package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.List;

@Hide
public final class zza implements Creator<Credential> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        String str2 = str;
        Uri uri = str2;
        List list = uri;
        String str3 = list;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                case 2:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) zzbgm.zza(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    list = zzbgm.zzc(parcel, readInt, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = zzbgm.zzq(parcel, readInt);
                    break;
                case 6:
                    str4 = zzbgm.zzq(parcel, readInt);
                    break;
                case 7:
                    str5 = zzbgm.zzq(parcel, readInt);
                    break;
                case 8:
                    str6 = zzbgm.zzq(parcel, readInt);
                    break;
                case 9:
                    str7 = zzbgm.zzq(parcel, readInt);
                    break;
                case 10:
                    str8 = zzbgm.zzq(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new Credential(str, str2, uri, list, str3, str4, str5, str6, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }
}
