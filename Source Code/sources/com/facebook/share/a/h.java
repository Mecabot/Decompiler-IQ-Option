package com.facebook.share.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ShareOpenGraphObject */
public final class h extends i<h, Object> {
    public static final Creator<h> CREATOR = new Creator<h>() {
        /* renamed from: A */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        /* renamed from: ak */
        public h[] newArray(int i) {
            return new h[i];
        }
    };

    h(Parcel parcel) {
        super(parcel);
    }
}
