package com.microblink.recognizers.blinkbarcode.simnumber;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.microblink.recognizers.settings.RecognizerSettings;

/* compiled from: line */
public class SimNumberRecognizerSettings extends RecognizerSettings {
    public static final Creator<SimNumberRecognizerSettings> CREATOR = new Creator<SimNumberRecognizerSettings>() {
        /* renamed from: an */
        public final SimNumberRecognizerSettings createFromParcel(Parcel parcel) {
            return new SimNumberRecognizerSettings();
        }

        /* renamed from: hS */
        public final SimNumberRecognizerSettings[] newArray(int i) {
            return new SimNumberRecognizerSettings[i];
        }
    };

    private static native long nativeConstruct();

    public void writeToParcel(Parcel parcel, int i) {
    }

    public SimNumberRecognizerSettings() {
        this.IlIllIlIIl = nativeConstruct();
    }
}
