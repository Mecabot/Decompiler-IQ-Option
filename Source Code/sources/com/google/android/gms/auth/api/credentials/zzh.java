package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzh implements Creator<HintRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = credentialPickerConfig;
        String str = strArr;
        String str2 = str;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i2 = SupportMenu.USER_MASK & readInt;
            if (i2 != 1000) {
                switch (i2) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) zzbgm.zza(parcel, readInt, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        z = zzbgm.zzc(parcel, readInt);
                        break;
                    case 3:
                        z2 = zzbgm.zzc(parcel, readInt);
                        break;
                    case 4:
                        strArr = zzbgm.zzaa(parcel, readInt);
                        break;
                    case 5:
                        z3 = zzbgm.zzc(parcel, readInt);
                        break;
                    case 6:
                        str = zzbgm.zzq(parcel, readInt);
                        break;
                    case 7:
                        str2 = zzbgm.zzq(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            }
            i = zzbgm.zzg(parcel, readInt);
        }
        zzbgm.zzaf(parcel, zzd);
        return new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new HintRequest[i];
    }
}
