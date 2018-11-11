package com.facebook.share.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ShareHashtag */
public class b implements e {
    public static final Creator<b> CREATOR = new Creator<b>() {
        /* renamed from: u */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: ag */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private final String Jd;

    /* compiled from: ShareHashtag */
    public static class a {
        private String Jd;

        public a cm(String str) {
            this.Jd = str;
            return this;
        }

        public a a(b bVar) {
            return bVar == null ? this : cm(bVar.on());
        }

        a v(Parcel parcel) {
            return a((b) parcel.readParcelable(b.class.getClassLoader()));
        }

        public b oo() {
            return new b(this, null);
        }
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    private b(a aVar) {
        this.Jd = aVar.Jd;
    }

    b(Parcel parcel) {
        this.Jd = parcel.readString();
    }

    public String on() {
        return this.Jd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Jd);
    }
}
