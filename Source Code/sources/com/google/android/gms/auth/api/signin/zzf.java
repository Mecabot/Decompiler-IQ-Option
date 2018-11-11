package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzf implements Creator<SignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = "";
        String str2 = "";
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i != 4) {
                switch (i) {
                    case 7:
                        googleSignInAccount = (GoogleSignInAccount) zzbgm.zza(parcel, readInt, GoogleSignInAccount.CREATOR);
                        break;
                    case 8:
                        str2 = zzbgm.zzq(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            }
            str = zzbgm.zzq(parcel, readInt);
        }
        zzbgm.zzaf(parcel, zzd);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
