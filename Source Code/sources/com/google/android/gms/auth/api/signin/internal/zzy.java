package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzy implements Creator<SignInConfiguration> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i = SupportMenu.USER_MASK & readInt;
            if (i == 2) {
                str = zzbgm.zzq(parcel, readInt);
            } else if (i != 5) {
                zzbgm.zzb(parcel, readInt);
            } else {
                googleSignInOptions = (GoogleSignInOptions) zzbgm.zza(parcel, readInt, GoogleSignInOptions.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
