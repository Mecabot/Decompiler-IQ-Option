package com.microblink.detectors;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.support.annotation.Size;
import com.microblink.view.recognition.DetectionStatus;

@Keep
/* compiled from: line */
public abstract class DetectorResult implements Parcelable {
    protected DetectionCode mDetectionCode;
    protected DetectionStatus mDetectionStatus;
    protected Matrix mTransformMatrix = new Matrix();

    /* compiled from: line */
    public enum DetectionCode {
        FAIL,
        FALLBACK,
        SUCCESS
    }

    public int describeContents() {
        return 0;
    }

    protected DetectorResult(int i, int i2, @Size(9) float[] fArr) {
        setDetectionCode(i);
        this.mDetectionStatus = DetectionStatus.fromNativeDetectionStatus(i2);
        this.mTransformMatrix.setValues(fArr);
    }

    public DetectionCode getDetectionCode() {
        return this.mDetectionCode;
    }

    protected void setDetectionCode(int i) {
        DetectionCode[] values = DetectionCode.values();
        if (i >= values.length) {
            this.mDetectionCode = DetectionCode.SUCCESS;
        } else {
            this.mDetectionCode = values[i];
        }
    }

    protected int getDetectionCodeOrdinal() {
        return this.mDetectionCode.ordinal();
    }

    protected String getDetectionCodeName() {
        return this.mDetectionCode.name();
    }

    public DetectionStatus getDetectionStatus() {
        return this.mDetectionStatus;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getDetectionCodeOrdinal());
        parcel.writeInt(this.mDetectionStatus.ordinal());
        float[] fArr = new float[9];
        this.mTransformMatrix.getValues(fArr);
        parcel.writeFloatArray(fArr);
    }

    protected DetectorResult(Parcel parcel) {
        setDetectionCode(parcel.readInt());
        this.mDetectionStatus = DetectionStatus.values()[parcel.readInt()];
        float[] fArr = new float[9];
        parcel.readFloatArray(fArr);
        this.mTransformMatrix.setValues(fArr);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DetectorResult{mDetectionCode=");
        stringBuilder.append(getDetectionCodeName());
        stringBuilder.append(", mDetectionStatus=");
        stringBuilder.append(this.mDetectionStatus);
        stringBuilder.append(", mTransformMatrix=");
        stringBuilder.append(this.mTransformMatrix);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
