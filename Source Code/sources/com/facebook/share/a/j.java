package com.facebook.share.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

/* compiled from: SharePhoto */
public final class j extends d {
    public static final Creator<j> CREATOR = new Creator<j>() {
        /* renamed from: B */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* renamed from: al */
        public j[] newArray(int i) {
            return new j[i];
        }
    };
    private final Uri Jg;
    private final boolean Jm;
    private final String Jn;
    private final Bitmap bitmap;

    public int describeContents() {
        return 0;
    }

    j(Parcel parcel) {
        super(parcel);
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.Jg = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.Jm = parcel.readByte() != (byte) 0;
        this.Jn = parcel.readString();
    }

    @Nullable
    public Uri ot() {
        return this.Jg;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.Jg, 0);
        parcel.writeByte((byte) this.Jm);
        parcel.writeString(this.Jn);
    }
}
