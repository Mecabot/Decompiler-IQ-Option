package com.facebook.share.a;

import android.net.Uri;
import android.os.Parcel;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShareContent */
public abstract class a<P extends a, E> implements e {
    private final Uri IY;
    private final List<String> IZ;
    private final String Iz;
    private final String Ja;
    private final String Jb;
    private final b Jc;

    public int describeContents() {
        return 0;
    }

    protected a(Parcel parcel) {
        this.IY = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.IZ = t(parcel);
        this.Ja = parcel.readString();
        this.Iz = parcel.readString();
        this.Jb = parcel.readString();
        this.Jc = new com.facebook.share.a.b.a().v(parcel).oo();
    }

    @Nullable
    public Uri ol() {
        return this.IY;
    }

    @Nullable
    public b om() {
        return this.Jc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.IY, 0);
        parcel.writeStringList(this.IZ);
        parcel.writeString(this.Ja);
        parcel.writeString(this.Iz);
        parcel.writeString(this.Jb);
        parcel.writeParcelable(this.Jc, 0);
    }

    private List<String> t(Parcel parcel) {
        List arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        return arrayList.size() == 0 ? null : Collections.unmodifiableList(arrayList);
    }
}
