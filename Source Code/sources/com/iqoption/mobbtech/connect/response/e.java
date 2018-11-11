package com.iqoption.mobbtech.connect.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.managers.feature.a;

/* compiled from: CryptoPayoutAvailable */
public class e implements Parcelable {
    public static final Creator<e> CREATOR = new Creator<e>() {
        /* renamed from: R */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: fu */
        public e[] newArray(int i) {
            return new e[i];
        }
    };
    @SerializedName("available_crypto")
    public Double cVI;
    @SerializedName("fee")
    public Double cVJ;
    @SerializedName("necessary3ds")
    public Double cVK;
    @SerializedName("minimum")
    private Double cVL;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CryptoPayoutAvailable{availableCrypto=");
        stringBuilder.append(this.cVI);
        stringBuilder.append(", fee=");
        stringBuilder.append(this.cVJ);
        stringBuilder.append(", necessary3ds=");
        stringBuilder.append(this.cVK);
        stringBuilder.append(", minimum=");
        stringBuilder.append(this.cVL);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean A(double d) {
        return d > 0.0d && d >= ((Double) com.google.common.base.e.h(this.cVL, Double.valueOf(0.0d))).doubleValue() && d <= ((Double) com.google.common.base.e.h(this.cVI, Double.valueOf(0.0d))).doubleValue();
    }

    public double auQ() {
        return this.cVJ != null ? this.cVJ.doubleValue() : 0.0d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.cVI == null ? this.cVI.equals(eVar.cVI) : eVar.cVI == null) {
            return false;
        }
        if (!this.cVJ == null ? this.cVJ.equals(eVar.cVJ) : eVar.cVJ == null) {
            return false;
        }
        if (!this.cVK == null ? this.cVK.equals(eVar.cVK) : eVar.cVK == null) {
            return false;
        }
        if (this.cVL != null) {
            z = this.cVL.equals(eVar.cVL);
        } else if (eVar.cVL != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((this.cVI != null ? this.cVI.hashCode() : 0) * 31) + (this.cVJ != null ? this.cVJ.hashCode() : 0)) * 31) + (this.cVK != null ? this.cVK.hashCode() : 0)) * 31;
        if (this.cVL != null) {
            i = this.cVL.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.cVI);
        parcel.writeValue(this.cVJ);
        parcel.writeValue(this.cVK);
        parcel.writeValue(this.cVL);
    }

    protected e(Parcel parcel) {
        this.cVI = (Double) parcel.readValue(Double.class.getClassLoader());
        this.cVJ = (Double) parcel.readValue(Double.class.getClassLoader());
        this.cVK = (Double) parcel.readValue(Double.class.getClassLoader());
        this.cVL = (Double) parcel.readValue(Double.class.getClassLoader());
    }

    public double getMinimum() {
        if (a.eW("crypto-check-min-amount")) {
            return ((Double) com.google.common.base.e.h(this.cVL, Double.valueOf(0.0d))).doubleValue();
        }
        return 0.0d;
    }
}
