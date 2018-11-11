package com.iqoption.microservice.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

/* compiled from: KycDocumentsStatus */
public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        /* renamed from: Q */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: fp */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    @SerializedName("isVerified")
    public boolean cRL;
    @SerializedName("documentsState")
    public String cRM;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycDocumentsStatus{isVerified=");
        stringBuilder.append(this.cRL);
        stringBuilder.append(", documentsState='");
        stringBuilder.append(this.cRM);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.cRL);
        parcel.writeString(this.cRM);
    }

    protected a(Parcel parcel) {
        this.cRL = parcel.readByte() != (byte) 0;
        this.cRM = parcel.readString();
    }
}
