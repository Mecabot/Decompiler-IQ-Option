package com.microblink.recognizers.blinkbarcode.zxing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.microblink.recognizers.settings.RecognizerSettings;

/* compiled from: line */
public class ZXingRecognizerSettings extends RecognizerSettings {
    public static final Creator<ZXingRecognizerSettings> CREATOR = new Creator<ZXingRecognizerSettings>() {
        /* renamed from: ar */
        public final ZXingRecognizerSettings createFromParcel(Parcel parcel) {
            return new ZXingRecognizerSettings(parcel, (byte) 0);
        }

        /* renamed from: hW */
        public final ZXingRecognizerSettings[] newArray(int i) {
            return new ZXingRecognizerSettings[i];
        }
    };

    private static native long nativeConstruct();

    private static native boolean nativeIsInverseScanMode(long j);

    private static native boolean nativeIsSlowThoroughScan(long j);

    private static native void nativeSetInverseScanning(long j, boolean z);

    private static native void nativeSetScanAztecCode(long j, boolean z);

    private static native void nativeSetScanCode128(long j, boolean z);

    private static native void nativeSetScanCode39(long j, boolean z);

    private static native void nativeSetScanDataMatrixCode(long j, boolean z);

    private static native void nativeSetScanEAN13Code(long j, boolean z);

    private static native void nativeSetScanEAN8Code(long j, boolean z);

    private static native void nativeSetScanITFCode(long j, boolean z);

    private static native void nativeSetScanQRCode(long j, boolean z);

    private static native void nativeSetScanUPCACode(long j, boolean z);

    private static native void nativeSetScanUPCECode(long j, boolean z);

    private static native void nativeSetSlowThoroughScan(long j, boolean z);

    private static native boolean nativeShouldScanAztecCode(long j);

    private static native boolean nativeShouldScanCode128(long j);

    private static native boolean nativeShouldScanCode39(long j);

    private static native boolean nativeShouldScanDataMatrixCode(long j);

    private static native boolean nativeShouldScanEAN13Code(long j);

    private static native boolean nativeShouldScanEAN8Code(long j);

    private static native boolean nativeShouldScanITFCode(long j);

    private static native boolean nativeShouldScanQRCode(long j);

    private static native boolean nativeShouldScanUPCACode(long j);

    private static native boolean nativeShouldScanUPCECode(long j);

    /* synthetic */ ZXingRecognizerSettings(Parcel parcel, byte b) {
        this(parcel);
    }

    public ZXingRecognizerSettings() {
        this.IlIllIlIIl = nativeConstruct();
    }

    private ZXingRecognizerSettings(Parcel parcel) {
        this.IlIllIlIIl = nativeConstruct();
        boolean z = false;
        nativeSetInverseScanning(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetSlowThoroughScan(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanAztecCode(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanCode128(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanCode39(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanDataMatrixCode(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanEAN13Code(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanEAN8Code(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanITFCode(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanQRCode(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        nativeSetScanUPCACode(this.IlIllIlIIl, parcel.readByte() == (byte) 1);
        long j = this.IlIllIlIIl;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        nativeSetScanUPCECode(j, z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(nativeIsInverseScanMode(this.IlIllIlIIl));
        parcel.writeByte(nativeIsSlowThoroughScan(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanAztecCode(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanCode128(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanCode39(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanDataMatrixCode(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanEAN13Code(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanEAN8Code(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanITFCode(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanQRCode(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanUPCACode(this.IlIllIlIIl));
        parcel.writeByte(nativeShouldScanUPCECode(this.IlIllIlIIl));
    }
}
