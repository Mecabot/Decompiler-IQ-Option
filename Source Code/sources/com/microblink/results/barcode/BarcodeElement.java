package com.microblink.results.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: line */
public class BarcodeElement implements Parcelable {
    public static final Creator<BarcodeElement> CREATOR = new Creator<BarcodeElement>() {
        /* renamed from: ia */
        public final BarcodeElement[] newArray(int i) {
            return new BarcodeElement[i];
        }

        /* renamed from: av */
        public final BarcodeElement createFromParcel(Parcel parcel) {
            return new BarcodeElement(parcel);
        }
    };
    long IlIllIlIIl;
    private ElementType dVG = null;
    private byte[] dVH = null;
    BarcodeDetailedData dVI;

    private static native byte[] nativeGetElementBytes(long j);

    private static native int nativeGetElementType(long j);

    public int describeContents() {
        return 0;
    }

    public BarcodeElement(long j, BarcodeDetailedData barcodeDetailedData) {
        this.IlIllIlIIl = j;
        this.dVI = barcodeDetailedData;
    }

    public ElementType aPm() {
        if (this.dVG == null && this.IlIllIlIIl != 0) {
            this.dVG = ElementType.values()[nativeGetElementType(this.IlIllIlIIl)];
        }
        return this.dVG;
    }

    public byte[] aPn() {
        if (this.dVH == null && this.IlIllIlIIl != 0) {
            this.dVH = nativeGetElementBytes(this.IlIllIlIIl);
        }
        return this.dVH;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(aPm().ordinal());
        byte[] aPn = aPn();
        parcel.writeInt(aPn.length);
        parcel.writeByteArray(aPn);
    }

    public BarcodeElement(Parcel parcel) {
        this.dVG = ElementType.values()[parcel.readInt()];
        this.dVH = new byte[parcel.readInt()];
        parcel.readByteArray(this.dVH);
    }
}
