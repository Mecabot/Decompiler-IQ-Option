package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

public final class SignInConfiguration extends zzbgl implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzy();
    private final String zzeob;
    private GoogleSignInOptions zzeoc;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.zzeob = zzbq.zzgv(str);
        this.zzeoc = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (this.zzeob.equals(signInConfiguration.zzeob)) {
                if (this.zzeoc != null ? !this.zzeoc.equals(signInConfiguration.zzeoc) : signInConfiguration.zzeoc != null) {
                    return true;
                }
                return false;
            }
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return new zzq().zzs(this.zzeob).zzs(this.zzeoc).zzacr();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 2, this.zzeob, false);
        zzbgo.zza(parcel, 5, this.zzeoc, i, false);
        zzbgo.zzai(parcel, zze);
    }

    public final GoogleSignInOptions zzacv() {
        return this.zzeoc;
    }
}
