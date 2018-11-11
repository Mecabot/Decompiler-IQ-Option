package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzaxu extends zzew implements zzaxt {
    public zzaxu() {
        attachInterface(this, "com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza((ProxyResponse) zzex.zza(parcel, ProxyResponse.CREATOR));
                break;
            case 2:
                zzez(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
