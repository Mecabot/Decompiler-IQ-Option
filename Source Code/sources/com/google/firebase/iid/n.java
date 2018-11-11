package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n implements Creator<m> {
    n() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        return readStrongBinder != null ? new m(readStrongBinder) : null;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new m[i];
    }
}
