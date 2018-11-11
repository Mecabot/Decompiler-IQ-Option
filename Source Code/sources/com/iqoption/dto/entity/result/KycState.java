package com.iqoption.dto.entity.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.app.a;

public class KycState implements Parcelable {
    public static final Creator<KycState> CREATOR = new Creator<KycState>() {
        public KycState createFromParcel(Parcel parcel) {
            return new KycState(parcel);
        }

        public KycState[] newArray(int i) {
            return new KycState[i];
        }
    };
    public static final int DAYS_LEFT_BLOCKED = 0;
    public static final int DAYS_LEFT_IGNORE = -1;
    public static final int STATUS_KYC_IS_REQUIRED = 1;
    public static final int STATUS_KYC_PARTIAL_DOCS = 2;
    public static final int STATUS_KYC_WAS_VERIFIED = 3;
    public static final int STATUS_NO_KYC = 0;
    @SerializedName("daysLeftToVerify")
    public Integer daysLeftToVerify;
    @SerializedName("isDocumentPoaUploaded")
    public Boolean isDocumentPoaUploaded;
    @SerializedName("isDocumentPoiUploaded")
    public Boolean isDocumentPoiUploaded;
    @SerializedName("isDocumentsApproved")
    public Boolean isDocumentsApproved;
    @SerializedName("isDocumentsDeclined")
    public Boolean isDocumentsDeclined;
    @SerializedName("isDocumentsNeeded")
    public Boolean isDocumentsNeeded;
    @SerializedName("isDocumentsUploadSkipped")
    public Boolean isDocumentsUploadSkipped;
    @SerializedName("isDocumentsUploaded")
    public Boolean isDocumentsUploaded;
    @SerializedName("isPhoneConfirmationSkipped")
    public Boolean isPhoneConfirmationSkipped;
    @SerializedName("isPhoneConfirmed")
    public Boolean isPhoneConfirmed;
    @SerializedName("isPhoneFilled")
    public Boolean isPhoneFilled;
    @SerializedName("isPhoneNeeded")
    public Boolean isPhoneNeeded;
    @SerializedName("isProfileFilled")
    public Boolean isProfileFilled;
    @SerializedName("isProfileNeeded")
    public Boolean isProfileNeeded;
    @SerializedName("isRegulatedUser")
    public Boolean isRegulatedUser;
    @SerializedName("status")
    public Integer status;

    public int describeContents() {
        return 0;
    }

    public static boolean isBlocked() {
        return ((Integer) a.Cw().akx.getValue()).intValue() == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycState{status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", isRegulatedUser=");
        stringBuilder.append(this.isRegulatedUser);
        stringBuilder.append(", isProfileNeeded=");
        stringBuilder.append(this.isProfileNeeded);
        stringBuilder.append(", isPhoneNeeded=");
        stringBuilder.append(this.isPhoneNeeded);
        stringBuilder.append(", isDocumentsNeeded=");
        stringBuilder.append(this.isDocumentsNeeded);
        stringBuilder.append(", isDocumentsDeclined=");
        stringBuilder.append(this.isDocumentsDeclined);
        stringBuilder.append(", isProfileFilled=");
        stringBuilder.append(this.isProfileFilled);
        stringBuilder.append(", isPhoneFilled=");
        stringBuilder.append(this.isPhoneFilled);
        stringBuilder.append(", isDocumentsUploaded=");
        stringBuilder.append(this.isDocumentsUploaded);
        stringBuilder.append(", isPhoneConfirmationSkipped=");
        stringBuilder.append(this.isPhoneConfirmationSkipped);
        stringBuilder.append(", isPhoneConfirmed=");
        stringBuilder.append(this.isPhoneConfirmed);
        stringBuilder.append(", isDocumentsUploadSkipped=");
        stringBuilder.append(this.isDocumentsUploadSkipped);
        stringBuilder.append(", isDocumentsApproved=");
        stringBuilder.append(this.isDocumentsApproved);
        stringBuilder.append(", isDocumentPoiUploaded=");
        stringBuilder.append(this.isDocumentPoiUploaded);
        stringBuilder.append(", isDocumentPoaUploaded=");
        stringBuilder.append(this.isDocumentPoaUploaded);
        stringBuilder.append(", daysLeftToVerify=");
        stringBuilder.append(this.daysLeftToVerify);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.status);
        parcel.writeValue(this.isRegulatedUser);
        parcel.writeValue(this.isProfileNeeded);
        parcel.writeValue(this.isPhoneNeeded);
        parcel.writeValue(this.isDocumentsNeeded);
        parcel.writeValue(this.isDocumentsDeclined);
        parcel.writeValue(this.isProfileFilled);
        parcel.writeValue(this.isPhoneFilled);
        parcel.writeValue(this.isDocumentsUploaded);
        parcel.writeValue(this.isPhoneConfirmationSkipped);
        parcel.writeValue(this.isPhoneConfirmed);
        parcel.writeValue(this.isDocumentsUploadSkipped);
        parcel.writeValue(this.isDocumentsApproved);
        parcel.writeValue(this.isDocumentPoiUploaded);
        parcel.writeValue(this.isDocumentPoaUploaded);
        parcel.writeValue(this.daysLeftToVerify);
    }

    protected KycState(Parcel parcel) {
        this.status = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.isRegulatedUser = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isProfileNeeded = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isPhoneNeeded = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentsNeeded = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentsDeclined = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isProfileFilled = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isPhoneFilled = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentsUploaded = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isPhoneConfirmationSkipped = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isPhoneConfirmed = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentsUploadSkipped = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentsApproved = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentPoiUploaded = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.isDocumentPoaUploaded = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.daysLeftToVerify = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KycState)) {
            return false;
        }
        KycState kycState = (KycState) obj;
        if (!this.status == null ? this.status.equals(kycState.status) : kycState.status == null) {
            return false;
        }
        if (!this.isRegulatedUser == null ? this.isRegulatedUser.equals(kycState.isRegulatedUser) : kycState.isRegulatedUser == null) {
            return false;
        }
        if (!this.isProfileNeeded == null ? this.isProfileNeeded.equals(kycState.isProfileNeeded) : kycState.isProfileNeeded == null) {
            return false;
        }
        if (!this.isPhoneNeeded == null ? this.isPhoneNeeded.equals(kycState.isPhoneNeeded) : kycState.isPhoneNeeded == null) {
            return false;
        }
        if (!this.isDocumentsNeeded == null ? this.isDocumentsNeeded.equals(kycState.isDocumentsNeeded) : kycState.isDocumentsNeeded == null) {
            return false;
        }
        if (!this.isDocumentsDeclined == null ? this.isDocumentsDeclined.equals(kycState.isDocumentsDeclined) : kycState.isDocumentsDeclined == null) {
            return false;
        }
        if (!this.isProfileFilled == null ? this.isProfileFilled.equals(kycState.isProfileFilled) : kycState.isProfileFilled == null) {
            return false;
        }
        if (!this.isPhoneFilled == null ? this.isPhoneFilled.equals(kycState.isPhoneFilled) : kycState.isPhoneFilled == null) {
            return false;
        }
        if (!this.isDocumentsUploaded == null ? this.isDocumentsUploaded.equals(kycState.isDocumentsUploaded) : kycState.isDocumentsUploaded == null) {
            return false;
        }
        if (!this.isPhoneConfirmationSkipped == null ? this.isPhoneConfirmationSkipped.equals(kycState.isPhoneConfirmationSkipped) : kycState.isPhoneConfirmationSkipped == null) {
            return false;
        }
        if (!this.isPhoneConfirmed == null ? this.isPhoneConfirmed.equals(kycState.isPhoneConfirmed) : kycState.isPhoneConfirmed == null) {
            return false;
        }
        if (!this.isDocumentsUploadSkipped == null ? this.isDocumentsUploadSkipped.equals(kycState.isDocumentsUploadSkipped) : kycState.isDocumentsUploadSkipped == null) {
            return false;
        }
        if (!this.isDocumentsApproved == null ? this.isDocumentsApproved.equals(kycState.isDocumentsApproved) : kycState.isDocumentsApproved == null) {
            return false;
        }
        if (!this.isDocumentPoiUploaded == null ? this.isDocumentPoiUploaded.equals(kycState.isDocumentPoiUploaded) : kycState.isDocumentPoiUploaded == null) {
            return false;
        }
        if (!this.isDocumentPoaUploaded == null ? this.isDocumentPoaUploaded.equals(kycState.isDocumentPoaUploaded) : kycState.isDocumentPoaUploaded == null) {
            return false;
        }
        if (this.daysLeftToVerify != null) {
            z = this.daysLeftToVerify.equals(kycState.daysLeftToVerify);
        } else if (kycState.daysLeftToVerify != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((((((this.status != null ? this.status.hashCode() : 0) * 31) + (this.isRegulatedUser != null ? this.isRegulatedUser.hashCode() : 0)) * 31) + (this.isProfileNeeded != null ? this.isProfileNeeded.hashCode() : 0)) * 31) + (this.isPhoneNeeded != null ? this.isPhoneNeeded.hashCode() : 0)) * 31) + (this.isDocumentsNeeded != null ? this.isDocumentsNeeded.hashCode() : 0)) * 31) + (this.isDocumentsDeclined != null ? this.isDocumentsDeclined.hashCode() : 0)) * 31) + (this.isProfileFilled != null ? this.isProfileFilled.hashCode() : 0)) * 31) + (this.isPhoneFilled != null ? this.isPhoneFilled.hashCode() : 0)) * 31) + (this.isDocumentsUploaded != null ? this.isDocumentsUploaded.hashCode() : 0)) * 31) + (this.isPhoneConfirmationSkipped != null ? this.isPhoneConfirmationSkipped.hashCode() : 0)) * 31) + (this.isPhoneConfirmed != null ? this.isPhoneConfirmed.hashCode() : 0)) * 31) + (this.isDocumentsUploadSkipped != null ? this.isDocumentsUploadSkipped.hashCode() : 0)) * 31) + (this.isDocumentsApproved != null ? this.isDocumentsApproved.hashCode() : 0)) * 31) + (this.isDocumentPoiUploaded != null ? this.isDocumentPoiUploaded.hashCode() : 0)) * 31) + (this.isDocumentPoaUploaded != null ? this.isDocumentPoaUploaded.hashCode() : 0)) * 31;
        if (this.daysLeftToVerify != null) {
            i = this.daysLeftToVerify.hashCode();
        }
        return hashCode + i;
    }
}
