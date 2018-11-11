package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;

public abstract class zzu extends zzew implements zzt {
    public zzu() {
        attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 101:
                zza((GoogleSignInAccount) zzex.zza(parcel, GoogleSignInAccount.CREATOR), (Status) zzex.zza(parcel, Status.CREATOR));
                break;
            case 102:
                zzi((Status) zzex.zza(parcel, Status.CREATOR));
                break;
            case 103:
                zzj((Status) zzex.zza(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
