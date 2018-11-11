package com.microblink.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public enum VideoResolutionPreset implements Parcelable {
    VIDEO_RESOLUTION_DEFAULT(1080),
    VIDEO_RESOLUTION_480p(480),
    VIDEO_RESOLUTION_720p(720),
    VIDEO_RESOLUTION_1080p(1080),
    VIDEO_RESOLUTION_2160p(2160),
    VIDEO_RESOLUTION_MAX_AVAILABLE(4320);
    
    public static final Creator<VideoResolutionPreset> CREATOR = null;
    private int lIIIIIlIlI;

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new Creator<VideoResolutionPreset>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new VideoResolutionPreset[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return VideoResolutionPreset.values()[parcel.readInt()];
            }
        };
    }

    private VideoResolutionPreset(int i) {
        this.lIIIIIlIlI = i;
    }

    public final int getIdealHeight() {
        return this.lIIIIIlIlI;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
