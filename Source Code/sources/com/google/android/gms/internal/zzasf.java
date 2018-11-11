package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzasf implements Parcelable {
    @Deprecated
    public static final Creator<zzasf> CREATOR = new zzasg();
    private String mValue;
    private String zzbzd;
    private String zzeav;

    @Deprecated
    zzasf(Parcel parcel) {
        this.zzbzd = parcel.readString();
        this.zzeav = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.zzbzd;
    }

    public final String getValue() {
        return this.mValue;
    }

    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzbzd);
        parcel.writeString(this.zzeav);
        parcel.writeString(this.mValue);
    }
}
