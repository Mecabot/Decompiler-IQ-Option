package com.jumio.nv;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.jumio.nv.data.document.NVMRZFormat;
import java.io.Serializable;

public class NetverifyMrzData implements Parcelable, Serializable {
    public static final Creator<NetverifyMrzData> CREATOR = new Creator<NetverifyMrzData>() {
        /* renamed from: a */
        public NetverifyMrzData[] newArray(int i) {
            return new NetverifyMrzData[i];
        }

        /* renamed from: a */
        public NetverifyMrzData createFromParcel(Parcel parcel) {
            return new NetverifyMrzData(parcel);
        }
    };
    protected boolean mCompositeValid;
    protected boolean mDobValid;
    protected boolean mExpiryValid;
    protected NVMRZFormat mFormat;
    protected boolean mIdValid;
    protected boolean mPersNumValid;
    protected String mrzLine1;
    protected String mrzLine2;
    protected String mrzLine3;

    public int describeContents() {
        return 0;
    }

    public NetverifyMrzData() {
        this.mFormat = NVMRZFormat.MRP;
        this.mPersNumValid = true;
        this.mCompositeValid = false;
    }

    public NetverifyMrzData(Parcel parcel) {
        this.mFormat = NVMRZFormat.MRP;
        boolean z = true;
        this.mPersNumValid = true;
        this.mCompositeValid = false;
        this.mrzLine1 = parcel.readString();
        this.mrzLine2 = parcel.readString();
        this.mrzLine3 = parcel.readString();
        try {
            this.mFormat = NVMRZFormat.values()[parcel.readInt()];
        } catch (Exception e) {
            e.printStackTrace();
            this.mFormat = NVMRZFormat.MRP;
        }
        this.mDobValid = parcel.readInt() == 1;
        this.mExpiryValid = parcel.readInt() == 1;
        this.mCompositeValid = parcel.readInt() == 1;
        this.mIdValid = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mPersNumValid = z;
    }

    public String getMrzLine1() {
        return this.mrzLine1;
    }

    public void setMrzLine1(String str) {
        this.mrzLine1 = str;
    }

    public String getMrzLine2() {
        return this.mrzLine2;
    }

    public void setMrzLine2(String str) {
        this.mrzLine2 = str;
    }

    public String getMrzLine3() {
        return this.mrzLine3;
    }

    public void setMrzLine3(String str) {
        this.mrzLine3 = str;
    }

    public boolean idNumberValid() {
        return this.mIdValid;
    }

    public void setIdNumberValid(boolean z) {
        this.mIdValid = z;
    }

    public boolean dobValid() {
        return this.mDobValid;
    }

    public void setDobValid(boolean z) {
        this.mDobValid = z;
    }

    public boolean expiryDateValid() {
        return this.mExpiryValid;
    }

    public void setExpiryDateValid(boolean z) {
        this.mExpiryValid = z;
    }

    public boolean personalNumberValid() {
        return this.mPersNumValid;
    }

    public void setPersonalNumberValid(boolean z) {
        this.mPersNumValid = z;
    }

    public boolean compositeValid() {
        return this.mCompositeValid;
    }

    public void setCompositeValid(boolean z) {
        this.mCompositeValid = z;
    }

    public NVMRZFormat getFormat() {
        return this.mFormat;
    }

    public void setFormat(NVMRZFormat nVMRZFormat) {
        this.mFormat = nVMRZFormat;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mrzLine1);
        parcel.writeString(this.mrzLine2);
        parcel.writeString(this.mrzLine3);
        parcel.writeInt(this.mFormat.ordinal());
        parcel.writeInt(this.mDobValid);
        parcel.writeInt(this.mExpiryValid);
        parcel.writeInt(this.mCompositeValid);
        parcel.writeInt(this.mIdValid);
        parcel.writeInt(this.mPersNumValid);
    }
}
