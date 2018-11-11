package com.facebook.share.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

/* compiled from: ShareLinkContent */
public final class c extends a<c, Object> {
    public static final Creator<c> CREATOR = new Creator<c>() {
        /* renamed from: w */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: ah */
        public c[] newArray(int i) {
            return new c[i];
        }
    };
    @Deprecated
    private final String Je;
    @Deprecated
    private final String Jf;
    @Deprecated
    private final Uri Jg;
    private final String Jh;

    public int describeContents() {
        return 0;
    }

    c(Parcel parcel) {
        super(parcel);
        this.Je = parcel.readString();
        this.Jf = parcel.readString();
        this.Jg = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.Jh = parcel.readString();
    }

    @Nullable
    public String op() {
        return this.Jh;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.Je);
        parcel.writeString(this.Jf);
        parcel.writeParcelable(this.Jg, 0);
        parcel.writeString(this.Jh);
    }
}
