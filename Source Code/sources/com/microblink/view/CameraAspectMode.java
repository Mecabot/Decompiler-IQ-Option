package com.microblink.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public enum CameraAspectMode implements Parcelable {
    ASPECT_FIT,
    ASPECT_FILL;
    
    public static final Creator<CameraAspectMode> CREATOR = null;

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Creator<CameraAspectMode>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CameraAspectMode[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return CameraAspectMode.values()[parcel.readInt()];
            }
        };
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
