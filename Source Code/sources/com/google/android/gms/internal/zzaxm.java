package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzaxm extends zzew implements zzaxl {
    public zzaxm() {
        attachInterface(this, "com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza((Status) zzex.zza(parcel, Status.CREATOR), (Credential) zzex.zza(parcel, Credential.CREATOR));
                break;
            case 2:
                zze((Status) zzex.zza(parcel, Status.CREATOR));
                break;
            case 3:
                zza((Status) zzex.zza(parcel, Status.CREATOR), parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
