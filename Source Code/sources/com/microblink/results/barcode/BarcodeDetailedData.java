package com.microblink.results.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* compiled from: line */
public class BarcodeDetailedData implements Parcelable {
    public static final Creator<BarcodeDetailedData> CREATOR = new Creator<BarcodeDetailedData>() {
        /* renamed from: hZ */
        public final BarcodeDetailedData[] newArray(int i) {
            return new BarcodeDetailedData[i];
        }

        /* renamed from: au */
        public final BarcodeDetailedData createFromParcel(Parcel parcel) {
            return new BarcodeDetailedData(parcel);
        }
    };
    long IlIllIlIIl;
    private BarcodeElement[] dVE;
    private byte[] dVF;

    private static native void nativeDestruct(long j);

    private static native byte[] nativeGetAllData(long j);

    private static native void nativeGetElements(long j, long[] jArr);

    private static native int nativeGetNumElements(long j);

    public int describeContents() {
        return 0;
    }

    @Keep
    public BarcodeDetailedData(long j) {
        this.dVE = null;
        this.dVF = null;
        this.IlIllIlIIl = j;
    }

    protected void finalize() {
        super.finalize();
        if (this.IlIllIlIIl != 0) {
            nativeDestruct(this.IlIllIlIIl);
        }
    }

    @Nullable
    public BarcodeElement[] aPk() {
        if (this.dVE == null && this.IlIllIlIIl != 0) {
            int nativeGetNumElements = nativeGetNumElements(this.IlIllIlIIl);
            long[] jArr = new long[nativeGetNumElements];
            this.dVE = new BarcodeElement[nativeGetNumElements];
            nativeGetElements(this.IlIllIlIIl, jArr);
            for (int i = 0; i < nativeGetNumElements; i++) {
                this.dVE[i] = new BarcodeElement(jArr[i], this);
            }
        }
        return this.dVE;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable[] aPk = aPk();
        if (aPk == null || aPk.length <= 0) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(aPk.length);
        parcel.writeTypedArray(aPk, 0);
    }

    public BarcodeDetailedData(Parcel parcel) {
        this.dVE = null;
        this.dVF = null;
        this.IlIllIlIIl = 0;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.dVE = new BarcodeElement[readInt];
            parcel.readTypedArray(this.dVE, BarcodeElement.CREATOR);
        }
    }

    @Nullable
    public byte[] aPl() {
        if (this.dVF == null) {
            if (this.IlIllIlIIl != 0) {
                this.dVF = nativeGetAllData(this.IlIllIlIIl);
            } else if (this.dVE != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                BarcodeElement[] barcodeElementArr = this.dVE;
                int length = barcodeElementArr.length;
                int i = 0;
                while (i < length) {
                    try {
                        byteArrayOutputStream.write(barcodeElementArr[i].aPn());
                        i++;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                this.dVF = byteArrayOutputStream.toByteArray();
            } else {
                this.dVF = null;
            }
        }
        return this.dVF;
    }

    public String toString() {
        BarcodeElement[] aPk = aPk();
        StringBuilder stringBuilder = new StringBuilder("Total elements: ");
        if (aPk != null) {
            stringBuilder.append(aPk.length);
            stringBuilder.append("\n");
            int i = 0;
            while (i < aPk.length) {
                stringBuilder.append("Element #");
                int i2 = i + 1;
                stringBuilder.append(i2);
                stringBuilder.append(" is of type ");
                BarcodeElement barcodeElement = this.dVE[i];
                stringBuilder.append(barcodeElement.aPm() == ElementType.TEXT_DATA ? "text" : "byte");
                stringBuilder.append("\n");
                byte[] aPn = barcodeElement.aPn();
                stringBuilder.append("Length = ");
                stringBuilder.append(aPn.length);
                stringBuilder.append(" {");
                for (int i3 = 0; i3 < aPn.length; i3++) {
                    stringBuilder.append(aPn[i3] & 255);
                    if (i3 != aPn.length - 1) {
                        stringBuilder.append(", ");
                    }
                }
                stringBuilder.append("}\n");
                if (barcodeElement.aPm() == ElementType.TEXT_DATA) {
                    try {
                        String str = new String(aPn, "UTF-8");
                        stringBuilder.append("Text representation (UTF-8 decoded): ");
                        stringBuilder.append(str);
                        stringBuilder.append("\n");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                i = i2;
            }
        } else {
            stringBuilder.append("0\n");
        }
        return stringBuilder.toString();
    }
}
