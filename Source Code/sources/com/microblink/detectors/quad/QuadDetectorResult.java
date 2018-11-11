package com.microblink.detectors.quad;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.support.annotation.Size;
import com.microblink.detectors.DetectorResult;
import com.microblink.geometry.Quadrilateral;

/* compiled from: line */
public class QuadDetectorResult extends DetectorResult {
    public static final Creator<QuadDetectorResult> CREATOR = new Creator<QuadDetectorResult>() {
        /* renamed from: af */
        public final QuadDetectorResult createFromParcel(Parcel parcel) {
            return new QuadDetectorResult(parcel);
        }

        /* renamed from: hL */
        public final QuadDetectorResult[] newArray(int i) {
            return new QuadDetectorResult[i];
        }
    };
    protected Quadrilateral dTX;
    protected Quadrilateral dTY;

    @Keep
    public QuadDetectorResult(int i, int i2, @Size(9) float[] fArr, @Size(8) float[] fArr2, @Size(8) float[] fArr3) {
        super(i, i2, fArr);
        this.dTX = new Quadrilateral(fArr2);
        this.dTY = new Quadrilateral(fArr3);
    }

    public QuadDetectorResult(Parcel parcel) {
        super(parcel);
        this.dTX = (Quadrilateral) parcel.readParcelable(Quadrilateral.class.getClassLoader());
        this.dTY = (Quadrilateral) parcel.readParcelable(Quadrilateral.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.dTX, 0);
        parcel.writeParcelable(this.dTY, 0);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("; Detection Location: ");
        stringBuilder.append(this.dTX);
        stringBuilder.append("; Display Location: ");
        stringBuilder.append(this.dTY);
        return stringBuilder.toString();
    }
}
