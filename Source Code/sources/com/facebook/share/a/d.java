package com.facebook.share.a;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: ShareMedia */
public abstract class d implements e {
    private final Bundle Ji;

    public int describeContents() {
        return 0;
    }

    d(Parcel parcel) {
        this.Ji = parcel.readBundle();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.Ji);
    }
}
