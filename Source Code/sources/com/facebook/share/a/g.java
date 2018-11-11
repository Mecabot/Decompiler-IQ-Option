package com.facebook.share.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.share.a.f.a;

/* compiled from: ShareOpenGraphContent */
public final class g extends a<g, Object> {
    public static final Creator<g> CREATOR = new Creator<g>() {
        /* renamed from: z */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* renamed from: aj */
        public g[] newArray(int i) {
            return new g[i];
        }
    };
    private final f Jj;
    private final String Jk;

    public int describeContents() {
        return 0;
    }

    g(Parcel parcel) {
        super(parcel);
        this.Jj = new a().y(parcel).or();
        this.Jk = parcel.readString();
    }

    @Nullable
    public f os() {
        return this.Jj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.Jj, 0);
        parcel.writeString(this.Jk);
    }
}
