package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzaya extends zzew implements zzaxz {
    public zzaya() {
        attachInterface(this, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzg((Status) zzex.zza(parcel, Status.CREATOR));
        return true;
    }
}
