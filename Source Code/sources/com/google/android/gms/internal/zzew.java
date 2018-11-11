package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.view.ViewCompat;

public class zzew extends Binder implements IInterface {
    public IBinder asBinder() {
        return this;
    }

    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i > ViewCompat.MEASURED_SIZE_MASK) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }
}
