package com.jumio.nv.data.document;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import java.io.Serializable;
import java.util.Arrays;

public class DocumentType implements Parcelable, Serializable, Comparable<DocumentType> {
    public static final String BARCODE_FORMAT_PDF417 = "PDF417";
    public static final String BARCODE_SIDE_BACK = "BACK";
    public static final String BARCODE_SIDE_FRONT = "FRONT";
    public static final Creator<DocumentType> CREATOR = new Creator<DocumentType>() {
        /* renamed from: a */
        public DocumentType createFromParcel(Parcel parcel) {
            return new DocumentType(parcel);
        }

        /* renamed from: a */
        public DocumentType[] newArray(int i) {
            return new DocumentType[i];
        }
    };
    public static final String MRZ_FORMAT_CNIS = "CNIS";
    public static final String MRZ_FORMAT_MRP = "MRP";
    public static final String MRZ_FORMAT_MRV = "MRV";
    public static final String MRZ_FORMAT_MRV_A = "MRV_A";
    public static final String MRZ_FORMAT_MRV_B = "MRV_B";
    public static final String MRZ_FORMAT_TD1 = "TD1";
    public static final String MRZ_FORMAT_TD2 = "TD2";
    public static final String MRZ_SIDE_BACK = "BACK";
    public static final String MRZ_SIDE_FRONT = "FRONT";
    private String a;
    private NVDocumentType b;
    private int c;
    private boolean d;
    private DocumentScanMode e;
    private ScanSide f;
    private int g;
    private DocumentScanMode h;
    private ScanSide i;
    private boolean j;
    private boolean k;
    private NVDocumentVariant l;
    private byte m;
    private String[] n;
    private NVDocumentMaskingType o;

    public int describeContents() {
        return 0;
    }

    public DocumentType(String str, int i, String str2, String str3, String str4, String str5, String str6, boolean z, int i2, String[] strArr, String str7) {
        this.c = 1;
        this.e = null;
        this.f = null;
        this.g = 1;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = null;
        this.o = NVDocumentMaskingType.NONE;
        this.b = NVDocumentType.fromString(str);
        this.c = i;
        if (this.b == NVDocumentType.PASSPORT) {
            this.e = DocumentScanMode.MRP;
        } else if (this.b == NVDocumentType.VISA) {
            this.e = DocumentScanMode.MRV;
        } else {
            this.e = DocumentScanMode.LINEFINDER;
        }
        this.f = ScanSide.FRONT;
        if (str2.length() != 0) {
            this.n = strArr;
            byte b = (strArr == null || strArr.length == 0) ? (byte) 0 : (byte) 2;
            this.m = b;
            if (MRZ_FORMAT_MRP.equals(str2)) {
                this.e = DocumentScanMode.MRP;
                this.m = (byte) 1;
            } else if (MRZ_FORMAT_MRV.equals(str2) || MRZ_FORMAT_MRV_A.equals(str2) || MRZ_FORMAT_MRV_B.equals(str2)) {
                this.e = DocumentScanMode.MRV;
                this.m = (byte) 0;
            } else if (MRZ_FORMAT_TD1.equals(str2)) {
                this.e = DocumentScanMode.TD1;
            } else if (MRZ_FORMAT_TD2.equals(str2)) {
                this.e = DocumentScanMode.TD2;
            } else if (MRZ_FORMAT_CNIS.equals(str2)) {
                this.e = DocumentScanMode.CNIS;
            }
            if ("FRONT".equals(str3)) {
                this.f = ScanSide.FRONT;
            } else if ("BACK".equals(str3)) {
                this.f = ScanSide.BACK;
            }
            this.d = true;
        } else if (str4.length() != 0) {
            if (BARCODE_FORMAT_PDF417.equals(str4)) {
                this.e = DocumentScanMode.PDF417;
            }
            if ("FRONT".equals(str5)) {
                this.f = ScanSide.FRONT;
            } else if ("BACK".equals(str5)) {
                this.f = ScanSide.BACK;
            }
            this.d = true;
        }
        if (str6.length() != 0) {
            if (this.e == DocumentScanMode.LINEFINDER && this.f == ScanSide.FRONT) {
                this.e = DocumentScanMode.CSSN;
                this.f = ScanSide.FRONT;
                this.j = false;
            } else {
                this.j = true;
            }
            this.a = str6;
            this.d = true;
        } else {
            this.a = null;
        }
        this.k = z;
        this.i = ScanSide.FRONT;
        this.h = DocumentScanMode.MANUAL;
        this.g = i2;
        if (str7.length() != 0) {
            try {
                this.o = NVDocumentMaskingType.valueOf(str7);
            } catch (Exception unused) {
                this.o = NVDocumentMaskingType.NONE;
            }
        }
    }

    public DocumentType(Parcel parcel) {
        boolean z = true;
        this.c = 1;
        NVDocumentVariant nVDocumentVariant = null;
        this.e = null;
        this.f = null;
        this.g = 1;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = null;
        this.o = NVDocumentMaskingType.NONE;
        this.b = NVDocumentType.valueOf(parcel.readString());
        this.c = parcel.readInt();
        this.e = DocumentScanMode.valueOf(parcel.readString());
        this.f = ScanSide.valueOf(parcel.readString());
        this.g = parcel.readInt();
        this.h = DocumentScanMode.valueOf(parcel.readString());
        this.i = ScanSide.valueOf(parcel.readString());
        this.j = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.k = z;
        this.a = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() != 0) {
            nVDocumentVariant = NVDocumentVariant.valueOf(readString);
        }
        this.l = nVDocumentVariant;
    }

    public DocumentType(DocumentType documentType) {
        this.c = 1;
        this.e = null;
        this.f = null;
        this.g = 1;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = null;
        this.o = NVDocumentMaskingType.NONE;
        this.b = documentType.b;
        this.c = documentType.c;
        this.e = documentType.e;
        this.f = documentType.f;
        this.g = documentType.g;
        this.h = documentType.h;
        this.i = documentType.i;
        this.j = documentType.j;
        this.k = documentType.k;
        this.a = documentType.a;
        this.l = documentType.l;
    }

    public NVDocumentType getId() {
        return this.b;
    }

    public void setId(NVDocumentType nVDocumentType) {
        this.b = nVDocumentType;
    }

    public int getParts() {
        return NVDocumentVariant.PAPER.equals(this.l) ? this.g : this.c;
    }

    public void setParts(int i) {
        this.c = i;
    }

    public DocumentScanMode getDocumentScanMode() {
        return NVDocumentVariant.PAPER.equals(this.l) ? this.h : this.e;
    }

    public void setDocumentScanMode(DocumentScanMode documentScanMode) {
        this.e = documentScanMode;
        if (documentScanMode == DocumentScanMode.TEMPLATEMATCHER) {
            this.j = true;
        }
    }

    public ScanSide getDocumentScanSide() {
        return NVDocumentVariant.PAPER.equals(this.l) ? this.i : this.f;
    }

    public void setDocumentScanSide(ScanSide scanSide) {
        this.f = scanSide;
    }

    public boolean hasFallbackScan() {
        return this.j || this.e.equals(DocumentScanMode.TEMPLATEMATCHER);
    }

    public void setFallbackScan(boolean z) {
        this.j = z;
    }

    public String getThirdPartyOcr() {
        return this.a;
    }

    public boolean isDocumentVariantAccepted(NVDocumentVariant nVDocumentVariant) {
        return (this.k && nVDocumentVariant == NVDocumentVariant.PAPER) || nVDocumentVariant == NVDocumentVariant.PLASTIC || nVDocumentVariant == null;
    }

    public void setPaperParts(int i) {
        this.g = i;
    }

    public void setPaperScanMode(DocumentScanMode documentScanMode) {
        this.h = documentScanMode;
    }

    public void setPaperScanSide(ScanSide scanSide) {
        this.i = scanSide;
    }

    public String toString() {
        return this.b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b.name());
        parcel.writeInt(this.c);
        parcel.writeString(this.e.name());
        parcel.writeString(this.f.name());
        parcel.writeInt(this.g);
        parcel.writeString(this.h.name());
        parcel.writeString(this.i.name());
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.a);
        parcel.writeString(this.l == null ? "" : this.l.name());
    }

    public int compareTo(DocumentType documentType) {
        if (this.b != NVDocumentType.PASSPORT || documentType.getId() == NVDocumentType.PASSPORT) {
            if (this.b == NVDocumentType.DRIVER_LICENSE && documentType.getId() == NVDocumentType.PASSPORT) {
                return 1;
            }
            if (this.b != NVDocumentType.DRIVER_LICENSE || documentType.getId() == NVDocumentType.DRIVER_LICENSE) {
                if (this.b == NVDocumentType.IDENTITY_CARD && documentType.getId() == NVDocumentType.PASSPORT) {
                    return 1;
                }
                if (this.b == NVDocumentType.IDENTITY_CARD && documentType.getId() == NVDocumentType.DRIVER_LICENSE) {
                    return 1;
                }
                if (!((this.b == NVDocumentType.IDENTITY_CARD && documentType.getId() == NVDocumentType.VISA) || this.b != NVDocumentType.VISA || documentType.getId() == NVDocumentType.VISA)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DocumentType ? compareTo((DocumentType) obj) : -1) == 0;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public boolean hasExtractionMethod() {
        return this.d;
    }

    public boolean hasPaperVariant() {
        return this.k;
    }

    public boolean hasEMRTD(String str) {
        if (this.m != (byte) 1) {
            return this.m == (byte) 2 && Arrays.asList(this.n).contains(str);
        } else {
            return true;
        }
    }

    public void setPaperVariant(boolean z) {
        this.k = z;
    }

    public NVDocumentVariant getDocumentVariant() {
        return this.l;
    }

    public void setDocumentVariant(NVDocumentVariant nVDocumentVariant) {
        if (isDocumentVariantAccepted(nVDocumentVariant)) {
            this.l = nVDocumentVariant;
        }
    }

    public NVDocumentMaskingType getMaskingType() {
        return this.o;
    }

    public void setMaskingType(NVDocumentMaskingType nVDocumentMaskingType) {
        this.o = nVDocumentMaskingType;
    }
}
