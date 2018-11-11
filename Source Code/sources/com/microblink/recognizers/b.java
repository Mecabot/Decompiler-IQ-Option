package com.microblink.recognizers;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.microblink.view.recognition.RecognitionType;

/* compiled from: line */
public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    };
    private BaseRecognitionResult[] dVx;
    private RecognitionType dVy;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dVy.ordinal());
        parcel.writeParcelableArray(this.dVx, 0);
    }

    public b(BaseRecognitionResult[] baseRecognitionResultArr, RecognitionType recognitionType) {
        this.dVx = baseRecognitionResultArr;
        this.dVy = recognitionType;
    }

    @Nullable
    public BaseRecognitionResult[] aPf() {
        return this.dVx;
    }

    protected b(Parcel parcel) {
        this.dVy = RecognitionType.values()[parcel.readInt()];
        Parcelable[] readParcelableArray = parcel.readParcelableArray(getClass().getClassLoader());
        if (readParcelableArray != null) {
            this.dVx = new BaseRecognitionResult[readParcelableArray.length];
            for (int i = 0; i < readParcelableArray.length; i++) {
                this.dVx[i] = (BaseRecognitionResult) readParcelableArray[i];
            }
        }
    }
}
