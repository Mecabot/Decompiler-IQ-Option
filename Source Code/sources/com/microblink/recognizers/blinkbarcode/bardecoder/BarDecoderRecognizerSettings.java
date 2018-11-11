package com.microblink.recognizers.blinkbarcode.bardecoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.microblink.recognizers.settings.RecognizerSettings;

/* compiled from: line */
public class BarDecoderRecognizerSettings extends RecognizerSettings {
    public static final Creator<BarDecoderRecognizerSettings> CREATOR = new Creator<BarDecoderRecognizerSettings>() {
        /* renamed from: aj */
        public final BarDecoderRecognizerSettings createFromParcel(Parcel parcel) {
            return new BarDecoderRecognizerSettings(parcel, (byte) 0);
        }

        /* renamed from: hO */
        public final BarDecoderRecognizerSettings[] newArray(int i) {
            return new BarDecoderRecognizerSettings[i];
        }
    };

    private static native long nativeConstruct();

    private static native boolean nativeIsAutoScaleDetectionEnabled(long j);

    private static native boolean nativeIsInverseScanMode(long j);

    private static native boolean nativeIsTryingHarder(long j);

    private static native void nativeSetAutoScaleDetection(long j, boolean z);

    private static native void nativeSetInverseScanning(long j, boolean z);

    private static native void nativeSetScanCode128(long j, boolean z);

    private static native void nativeSetScanCode39(long j, boolean z);

    private static native void nativeSetTryHarder(long j, boolean z);

    private static native boolean nativeShouldScanCode128(long j);

    private static native boolean nativeShouldScanCode39(long j);

    /* synthetic */ BarDecoderRecognizerSettings(Parcel parcel, byte b) {
        this(parcel);
    }

    public BarDecoderRecognizerSettings() {
        this.IlIllIlIIl = nativeConstruct();
    }

    private BarDecoderRecognizerSettings(Parcel parcel) {
        this.IlIllIlIIl = nativeConstruct();
        boolean z = false;
        nativeSetAutoScaleDetection(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetInverseScanning(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetTryHarder(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanCode128(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        long j = this.IlIllIlIIl;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        nativeSetScanCode39(j, z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(nativeIsAutoScaleDetectionEnabled(this.IlIllIlIIl));
        parcel.writeByte(nativeIsInverseScanMode(this.IlIllIlIIl));
        parcel.writeByte(nativeIsTryingHarder(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanCode128(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanCode39(this.IlIllIlIIl));
    }
}
