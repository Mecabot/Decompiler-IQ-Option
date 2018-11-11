package com.microblink.recognizers;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;

/* compiled from: line */
public class LibraryInfoResult extends BaseRecognitionResult {
    public static final Creator<LibraryInfoResult> CREATOR = new Creator<LibraryInfoResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LibraryInfoResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LibraryInfoResult(parcel);
        }
    };

    public String getTitle() {
        return "Library information";
    }

    @Keep
    public LibraryInfoResult(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    protected LibraryInfoResult(Parcel parcel) {
        super(parcel);
    }

    public String aPe() {
        return aPd().getString("LibInfo");
    }

    public String toString() {
        return aPe();
    }
}
