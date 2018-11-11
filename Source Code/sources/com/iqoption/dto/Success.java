package com.iqoption.dto;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public final class Success implements Parcelable {
    public static final Creator<Success> CREATOR = new Creator<Success>() {
        public Success createFromParcel(Parcel parcel) {
            return new Success(parcel);
        }

        public Success[] newArray(int i) {
            return new Success[i];
        }
    };
    @SerializedName("success")
    private boolean success;

    public int describeContents() {
        return 0;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.success);
    }

    protected Success(Parcel parcel) {
        this.success = parcel.readByte() != (byte) 0;
    }

    public static Success of(boolean z) {
        Success success = new Success();
        success.success = z;
        return success;
    }
}
