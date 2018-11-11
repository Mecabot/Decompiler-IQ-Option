package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.a.e;

@Deprecated
/* compiled from: LikeContent */
public class d implements e {
    @Deprecated
    public static final Creator<d> CREATOR = new Creator<d>() {
        /* renamed from: s */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: af */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    private final String HL;
    private final String IV;

    @Deprecated
    /* compiled from: LikeContent */
    public static class a {
        private String HL;
        private String IV;

        @Deprecated
        public a cj(String str) {
            this.HL = str;
            return this;
        }

        @Deprecated
        public a ck(String str) {
            this.IV = str;
            return this;
        }

        @Deprecated
        public d oi() {
            return new d(this, null);
        }
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    /* synthetic */ d(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private d(a aVar) {
        this.HL = aVar.HL;
        this.IV = aVar.IV;
    }

    @Deprecated
    d(Parcel parcel) {
        this.HL = parcel.readString();
        this.IV = parcel.readString();
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.HL);
        parcel.writeString(this.IV);
    }
}
