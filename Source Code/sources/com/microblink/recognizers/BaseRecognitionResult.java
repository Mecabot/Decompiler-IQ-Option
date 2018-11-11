package com.microblink.recognizers;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.microblink.secured.ac;

/* compiled from: line */
public abstract class BaseRecognitionResult implements Parcelable {
    private a dVs;

    public int describeContents() {
        return 0;
    }

    @Keep
    public BaseRecognitionResult(long j, boolean z, boolean z2) {
        this.dVs = new NativeResultHolder(j, z, z2);
    }

    public final a aPd() {
        return this.dVs;
    }

    public String getTitle() {
        if (this.dVs != null) {
            String string = this.dVs.getString("PaymentDataType");
            if (string != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" result");
                return stringBuilder.toString();
            }
        }
        return "Base recognition result";
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Title: ");
        stringBuilder.append(getTitle());
        stringBuilder.append(",\n");
        stringBuilder.append("Valid: ");
        stringBuilder.append(this.dVs.isValid());
        stringBuilder.append(",\n");
        stringBuilder.append("Empty: ");
        stringBuilder.append(this.dVs.isEmpty());
        stringBuilder.append(",\n");
        for (String str : this.dVs.keySet()) {
            Object object = this.dVs.getObject(str);
            if (object != null) {
                stringBuilder.append(str);
                stringBuilder.append(": ");
                stringBuilder.append(object.toString());
                stringBuilder.append(",\n");
            }
        }
        return stringBuilder.toString();
    }

    public boolean isValid() {
        return this.dVs.isValid();
    }

    public boolean isEmpty() {
        return this.dVs.isEmpty();
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.dVs.ai(parcel);
    }

    protected BaseRecognitionResult(Parcel parcel) {
        this.dVs = new ac(parcel);
    }
}
