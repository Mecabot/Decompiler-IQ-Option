package com.microblink.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new a[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    };
    private float dUo;
    private float dUp;
    private float dUq;

    public int describeContents() {
        return 0;
    }

    public a() {
        this.dUq = -1.0f;
        this.dUo = 0.0f;
        this.dUp = 0.0f;
    }

    public a(float f, float f2) {
        this.dUq = -1.0f;
        this.dUo = f;
        this.dUp = f2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Point{mX=");
        stringBuilder.append(this.dUo);
        stringBuilder.append(", mY=");
        stringBuilder.append(this.dUp);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.dUo == aVar.dUo && this.dUp == aVar.dUp) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.dUo);
        parcel.writeFloat(this.dUp);
        parcel.writeFloat(this.dUq);
    }

    protected a(Parcel parcel) {
        this.dUq = -1.0f;
        this.dUo = parcel.readFloat();
        this.dUp = parcel.readFloat();
        this.dUq = parcel.readFloat();
    }
}
