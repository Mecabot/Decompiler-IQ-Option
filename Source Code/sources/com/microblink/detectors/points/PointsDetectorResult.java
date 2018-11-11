package com.microblink.detectors.points;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.support.annotation.Size;
import com.microblink.detectors.DetectorResult;
import com.microblink.geometry.b;

/* compiled from: line */
public class PointsDetectorResult extends DetectorResult {
    public static final Creator<PointsDetectorResult> CREATOR = new Creator<PointsDetectorResult>() {
        /* renamed from: ae */
        public final PointsDetectorResult createFromParcel(Parcel parcel) {
            return new PointsDetectorResult(parcel);
        }

        /* renamed from: hK */
        public final PointsDetectorResult[] newArray(int i) {
            return new PointsDetectorResult[i];
        }
    };
    private b dTW;

    public int describeContents() {
        return 0;
    }

    @Keep
    public PointsDetectorResult(int i, int i2, @Size(9) float[] fArr, @Size(multiple = 2) float[] fArr2) {
        super(i, i2, fArr);
        this.dTW = new b(fArr2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.dTW, 0);
    }

    public PointsDetectorResult(Parcel parcel) {
        super(parcel);
        this.dTW = (b) parcel.readParcelable(b.class.getClassLoader());
    }
}
