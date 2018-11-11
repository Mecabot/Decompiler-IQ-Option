package com.jumio.nv.liveness.extraction;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.jumio.commons.PersistWith;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.enums.NVLivenessResult;
import com.jumio.nv.models.DocumentDataModel;

@PersistWith("LivenessDataModel")
public class LivenessDataModel extends DocumentDataModel implements StaticModel {
    public static final Creator<LivenessDataModel> CREATOR = new Creator<LivenessDataModel>() {
        /* renamed from: a */
        public LivenessDataModel createFromParcel(Parcel parcel) {
            return new LivenessDataModel(parcel);
        }

        /* renamed from: a */
        public LivenessDataModel[] newArray(int i) {
            return new LivenessDataModel[i];
        }
    };
    private String eyetrackingData;
    private String[] frames;
    private NVLivenessResult livenessResult = null;
    private float livenessValue = 0.0f;

    public LivenessDataModel(Parcel parcel) {
        super(parcel);
        NVLivenessResult nVLivenessResult = null;
        String readString = parcel.readString();
        if (readString.length() != 0) {
            nVLivenessResult = NVLivenessResult.valueOf(readString);
        }
        this.livenessResult = nVLivenessResult;
        this.livenessValue = parcel.readFloat();
        this.frames = parcel.createStringArray();
        this.eyetrackingData = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.livenessResult == null ? "" : this.livenessResult.name());
        parcel.writeFloat(this.livenessValue);
        parcel.writeStringArray(this.frames);
        parcel.writeString(this.eyetrackingData);
    }

    public NVLivenessResult getLivenessResult() {
        return this.livenessResult;
    }

    public void setLivenessResult(NVLivenessResult nVLivenessResult) {
        this.livenessResult = nVLivenessResult;
    }

    public float getLivenessValue() {
        return this.livenessValue;
    }

    public void setLivenessValue(float f) {
        this.livenessValue = f;
    }

    public String[] getFrames() {
        return this.frames;
    }

    public void setFrames(String[] strArr) {
        this.frames = strArr;
    }

    public String getEyetrackingData() {
        return this.eyetrackingData;
    }

    public void setEyetrackingData(String str) {
        this.eyetrackingData = str;
    }
}
