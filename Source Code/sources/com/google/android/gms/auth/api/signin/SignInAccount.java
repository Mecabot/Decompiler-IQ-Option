package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

@Hide
public class SignInAccount extends zzbgl implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new zzf();
    @Deprecated
    private String zzaux;
    @Deprecated
    private String zzemh;
    private GoogleSignInAccount zzenk;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.zzenk = googleSignInAccount;
        this.zzemh = zzbq.zzh(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzaux = zzbq.zzh(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Hide
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzenk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 4, this.zzemh, false);
        zzbgo.zza(parcel, 7, this.zzenk, i, false);
        zzbgo.zza(parcel, 8, this.zzaux, false);
        zzbgo.zzai(parcel, zze);
    }
}
