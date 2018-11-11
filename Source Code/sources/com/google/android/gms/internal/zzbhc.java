package com.google.android.gms.internal;

import android.os.Parcel;

public abstract class zzbhc extends zzew implements zzbhb {
    public zzbhc() {
        attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzch(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
