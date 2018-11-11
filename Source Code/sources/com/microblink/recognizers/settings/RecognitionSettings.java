package com.microblink.recognizers.settings;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.dto.ToastEntity;

/* compiled from: line */
public class RecognitionSettings implements Parcelable {
    public static final Creator<RecognitionSettings> CREATOR = new Creator<RecognitionSettings>() {
        /* renamed from: at */
        public final RecognitionSettings createFromParcel(Parcel parcel) {
            return new RecognitionSettings(parcel, (byte) 0);
        }

        /* renamed from: hY */
        public final RecognitionSettings[] newArray(int i) {
            return new RecognitionSettings[i];
        }
    };
    private boolean dVA;
    private int dVB;
    private FrameQualityEstimationMode dVC;
    private RecognizerSettings[] dVD;
    private int dVz;

    /* compiled from: line */
    public enum FrameQualityEstimationMode {
        AUTOMATIC,
        ALWAYS_ON,
        ALWAYS_OFF
    }

    public int describeContents() {
        return 0;
    }

    /* synthetic */ RecognitionSettings(Parcel parcel, byte b) {
        this(parcel);
    }

    public RecognitionSettings() {
        this.dVz = 0;
        this.dVA = true;
        this.dVB = ToastEntity.ALERT_TOAST_DURATION;
        this.dVC = FrameQualityEstimationMode.AUTOMATIC;
        this.dVD = null;
    }

    public boolean aPi() {
        return this.dVA;
    }

    public void fN(boolean z) {
        this.dVA = z;
    }

    public void a(RecognizerSettings[] recognizerSettingsArr) {
        this.dVD = recognizerSettingsArr;
    }

    public RecognizerSettings[] aPj() {
        return this.dVD;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dVz);
        parcel.writeByte(this.dVA);
        parcel.writeInt(this.dVB);
        parcel.writeInt(this.dVC.ordinal());
        parcel.writeParcelableArray(this.dVD, 0);
    }

    private RecognitionSettings(Parcel parcel) {
        int i = 0;
        this.dVz = 0;
        boolean z = true;
        this.dVA = true;
        this.dVB = ToastEntity.ALERT_TOAST_DURATION;
        this.dVC = FrameQualityEstimationMode.AUTOMATIC;
        this.dVD = null;
        this.dVz = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.dVA = z;
        this.dVB = parcel.readInt();
        this.dVC = FrameQualityEstimationMode.values()[parcel.readInt()];
        Parcelable[] readParcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        if (readParcelableArray != null && readParcelableArray.length > 0) {
            this.dVD = new RecognizerSettings[readParcelableArray.length];
            while (i < readParcelableArray.length) {
                this.dVD[i] = (RecognizerSettings) readParcelableArray[i];
                i++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RecognitionSettings)) {
            return false;
        }
        RecognitionSettings recognitionSettings = (RecognitionSettings) obj;
        if (this == recognitionSettings && this.dVD == recognitionSettings.dVD) {
            return true;
        }
        return false;
    }
}
