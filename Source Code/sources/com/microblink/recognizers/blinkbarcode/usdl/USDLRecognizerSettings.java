package com.microblink.recognizers.blinkbarcode.usdl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.microblink.recognizers.settings.RecognizerSettings;

/* compiled from: line */
public class USDLRecognizerSettings extends RecognizerSettings {
    public static final Creator<USDLRecognizerSettings> CREATOR = new Creator<USDLRecognizerSettings>() {
        /* renamed from: ap */
        public final USDLRecognizerSettings createFromParcel(Parcel parcel) {
            return new USDLRecognizerSettings(parcel, (byte) 0);
        }

        /* renamed from: hU */
        public final USDLRecognizerSettings[] newArray(int i) {
            return new USDLRecognizerSettings[i];
        }
    };

    private static native long nativeConstruct();

    private static native boolean nativeIsNullQuietZoneAllowed(long j);

    private static native boolean nativeIsScanning1DBarcodes(long j);

    private static native boolean nativeIsUncertainScanMode(long j);

    private static native void nativeSetNullQuietZoneAllowed(long j, boolean z);

    private static native void nativeSetScan1DBarcodes(long j, boolean z);

    private static native void nativeSetUncertainScanning(long j, boolean z);

    /* synthetic */ USDLRecognizerSettings(Parcel parcel, byte b) {
        this(parcel);
    }

    public USDLRecognizerSettings() {
        this.IlIllIlIIl = nativeConstruct();
    }

    private USDLRecognizerSettings(Parcel parcel) {
        this.IlIllIlIIl = nativeConstruct();
        boolean z = false;
        nativeSetUncertainScanning(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetNullQuietZoneAllowed(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        long j = this.IlIllIlIIl;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        nativeSetScan1DBarcodes(j, z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(nativeIsUncertainScanMode(this.IlIllIlIIl));
        parcel.writeByte(nativeIsNullQuietZoneAllowed(this.IlIllIlIIl));
        parcel.writeByte(nativeIsScanning1DBarcodes(this.IlIllIlIIl));
    }
}
