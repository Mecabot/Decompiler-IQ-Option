package com.microblink.recognizers.blinkbarcode.pdf417;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.microblink.recognizers.settings.RecognizerSettings;

/* compiled from: line */
public class Pdf417RecognizerSettings extends RecognizerSettings {
    public static final Creator<Pdf417RecognizerSettings> CREATOR = new Creator<Pdf417RecognizerSettings>() {
        /* renamed from: al */
        public final Pdf417RecognizerSettings createFromParcel(Parcel parcel) {
            return new Pdf417RecognizerSettings(parcel, (byte) 0);
        }

        /* renamed from: hQ */
        public final Pdf417RecognizerSettings[] newArray(int i) {
            return new Pdf417RecognizerSettings[i];
        }
    };

    private static native long nativeConstruct();

    private static native boolean nativeIsInverseScanMode(long j);

    private static native boolean nativeIsNullQuietZoneAllowed(long j);

    private static native boolean nativeIsUncertainScanMode(long j);

    private static native void nativeSetInverseScanning(long j, boolean z);

    private static native void nativeSetNullQuietZoneAllowed(long j, boolean z);

    private static native void nativeSetUncertainScanning(long j, boolean z);

    /* synthetic */ Pdf417RecognizerSettings(Parcel parcel, byte b) {
        this(parcel);
    }

    public Pdf417RecognizerSettings() {
        this.IlIllIlIIl = nativeConstruct();
    }

    public void fL(boolean z) {
        nativeSetUncertainScanning(this.IlIllIlIIl, z);
    }

    public void fM(boolean z) {
        nativeSetNullQuietZoneAllowed(this.IlIllIlIIl, z);
    }

    private Pdf417RecognizerSettings(Parcel parcel) {
        this.IlIllIlIIl = nativeConstruct();
        boolean z = false;
        nativeSetInverseScanning(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetNullQuietZoneAllowed(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        long j = this.IlIllIlIIl;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        nativeSetUncertainScanning(j, z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(nativeIsInverseScanMode(this.IlIllIlIIl));
        parcel.writeByte(nativeIsNullQuietZoneAllowed(this.IlIllIlIIl));
        parcel.writeByte(nativeIsUncertainScanMode(this.IlIllIlIIl));
    }
}
