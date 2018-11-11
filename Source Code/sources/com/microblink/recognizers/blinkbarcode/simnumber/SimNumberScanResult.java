package com.microblink.recognizers.blinkbarcode.simnumber;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.microblink.recognizers.BaseRecognitionResult;

/* compiled from: line */
public class SimNumberScanResult extends BaseRecognitionResult {
    public static final Creator<SimNumberScanResult> CREATOR = new Creator<SimNumberScanResult>() {
        /* renamed from: ao */
        public final SimNumberScanResult createFromParcel(Parcel parcel) {
            return new SimNumberScanResult(parcel, (byte) 0);
        }

        /* renamed from: hT */
        public final SimNumberScanResult[] newArray(int i) {
            return new SimNumberScanResult[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SimNumberScanResult(Parcel parcel, byte b) {
        this(parcel);
    }

    @Keep
    public SimNumberScanResult(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private SimNumberScanResult(Parcel parcel) {
        super(parcel);
    }
}
