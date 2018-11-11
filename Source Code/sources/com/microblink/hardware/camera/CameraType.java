package com.microblink.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public enum CameraType implements Parcelable {
    CAMERA_DEFAULT,
    CAMERA_BACKFACE,
    CAMERA_FRONTFACE;
    
    public static final Creator<CameraType> CREATOR = null;

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Creator<CameraType>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CameraType[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return CameraType.values()[parcel.readInt()];
            }
        };
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
