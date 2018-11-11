package com.microblink.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public enum CameraSurface implements Parcelable {
    SURFACE_DEFAULT,
    SURFACE_TEXTURE_VIEW,
    SURFACE_SURFACE_VIEW;
    
    public static final Creator<CameraSurface> CREATOR = null;

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Creator<CameraSurface>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CameraSurface[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return CameraSurface.values()[parcel.readInt()];
            }
        };
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
