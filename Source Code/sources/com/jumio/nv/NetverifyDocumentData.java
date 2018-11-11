package com.jumio.nv;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.jumio.commons.utils.StringUtil;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.enums.EMRTDStatus;
import com.jumio.nv.enums.NVExtractionMethod;
import com.jumio.nv.enums.NVGender;
import java.io.Serializable;
import java.util.Date;

public class NetverifyDocumentData implements Parcelable, Serializable {
    public static final Creator<NetverifyDocumentData> CREATOR = new Creator<NetverifyDocumentData>() {
        /* renamed from: a */
        public NetverifyDocumentData createFromParcel(Parcel parcel) {
            return new NetverifyDocumentData(parcel);
        }

        /* renamed from: a */
        public NetverifyDocumentData[] newArray(int i) {
            return new NetverifyDocumentData[i];
        }
    };
    private String addressLine = null;
    private String backImage = null;
    private String city = null;
    private Date dob = null;
    private EMRTDStatus emrtdStatus = EMRTDStatus.NOT_AVAILABLE;
    private Date expiryDate = null;
    private NVExtractionMethod extractionMethod = NVExtractionMethod.NONE;
    private String faceImage = null;
    private String firstName = null;
    private String frontImage = null;
    private NVGender gender = null;
    private String idNumber = null;
    private String issuingCountry = null;
    private Date issuingDate = null;
    private String lastName = null;
    private String middleName = null;
    protected NetverifyMrzData mrzData = null;
    private String nameSuffix = null;
    private String optData1 = null;
    private String optData2 = null;
    private String originatingCountry = null;
    private String personalNumber = null;
    private String placeOfBirth = null;
    private String postCode = null;
    private String selectedCountry = null;
    private NVDocumentType selectedDocumentType = null;
    private String subdivision = null;

    public int describeContents() {
        return 0;
    }

    protected NetverifyDocumentData(Parcel parcel) {
        Date date;
        Date date2;
        NVGender nVGender = null;
        this.selectedCountry = readString(parcel.readString());
        String readString = parcel.readString();
        this.selectedDocumentType = readString.length() == 0 ? null : NVDocumentType.valueOf(readString);
        this.idNumber = readString(parcel.readString());
        this.personalNumber = readString(parcel.readString());
        long readLong = parcel.readLong();
        if (readLong == 0) {
            date = null;
        } else {
            date = new Date(readLong);
        }
        this.issuingDate = date;
        readLong = parcel.readLong();
        if (readLong == 0) {
            date = null;
        } else {
            date = new Date(readLong);
        }
        this.expiryDate = date;
        this.issuingCountry = readString(parcel.readString());
        this.lastName = readString(parcel.readString());
        this.firstName = readString(parcel.readString());
        this.middleName = readString(parcel.readString());
        this.nameSuffix = readString(parcel.readString());
        readLong = parcel.readLong();
        if (readLong == 0) {
            date2 = null;
        } else {
            date2 = new Date(readLong);
        }
        this.dob = date2;
        readString = parcel.readString();
        if (readString.length() != 0) {
            nVGender = NVGender.valueOf(readString);
        }
        this.gender = nVGender;
        this.originatingCountry = readString(parcel.readString());
        this.addressLine = readString(parcel.readString());
        this.city = readString(parcel.readString());
        this.subdivision = readString(parcel.readString());
        this.postCode = readString(parcel.readString());
        this.optData1 = readString(parcel.readString());
        this.optData2 = readString(parcel.readString());
        this.mrzData = (NetverifyMrzData) parcel.readParcelable(getClass().getClassLoader());
        this.placeOfBirth = parcel.readString();
        this.frontImage = parcel.readString();
        this.backImage = parcel.readString();
        this.faceImage = parcel.readString();
        try {
            this.emrtdStatus = EMRTDStatus.valueOf(parcel.readString());
        } catch (Exception unused) {
            this.emrtdStatus = EMRTDStatus.NOT_AVAILABLE;
        }
        try {
            this.extractionMethod = NVExtractionMethod.valueOf(parcel.readString());
        } catch (Exception unused2) {
            this.extractionMethod = NVExtractionMethod.NONE;
        }
    }

    public String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public void setPlaceOfBirth(String str) {
        this.placeOfBirth = str;
    }

    public NetverifyDocumentData copy() {
        NetverifyDocumentData netverifyDocumentData = new NetverifyDocumentData();
        netverifyDocumentData.selectedCountry = this.selectedCountry;
        netverifyDocumentData.selectedDocumentType = this.selectedDocumentType;
        netverifyDocumentData.idNumber = this.idNumber;
        netverifyDocumentData.personalNumber = this.personalNumber;
        netverifyDocumentData.issuingDate = this.issuingDate;
        netverifyDocumentData.expiryDate = this.expiryDate;
        netverifyDocumentData.issuingCountry = this.issuingCountry;
        netverifyDocumentData.lastName = this.lastName;
        netverifyDocumentData.firstName = this.firstName;
        netverifyDocumentData.middleName = this.middleName;
        netverifyDocumentData.nameSuffix = this.nameSuffix;
        netverifyDocumentData.dob = this.dob;
        netverifyDocumentData.gender = this.gender;
        netverifyDocumentData.originatingCountry = this.originatingCountry;
        netverifyDocumentData.addressLine = this.addressLine;
        netverifyDocumentData.city = this.city;
        netverifyDocumentData.subdivision = this.subdivision;
        netverifyDocumentData.postCode = this.postCode;
        netverifyDocumentData.optData1 = this.optData1;
        netverifyDocumentData.optData2 = this.optData2;
        netverifyDocumentData.mrzData = this.mrzData;
        netverifyDocumentData.placeOfBirth = this.placeOfBirth;
        netverifyDocumentData.frontImage = this.frontImage;
        netverifyDocumentData.backImage = this.backImage;
        netverifyDocumentData.faceImage = this.faceImage;
        netverifyDocumentData.emrtdStatus = this.emrtdStatus;
        netverifyDocumentData.extractionMethod = this.extractionMethod;
        return netverifyDocumentData;
    }

    private String readString(String str) {
        return str.length() == 0 ? null : str;
    }

    public String getSelectedCountry() {
        return this.selectedCountry;
    }

    public void setSelectedCountry(String str) {
        this.selectedCountry = StringUtil.trim(str, 3);
    }

    public NVDocumentType getSelectedDocumentType() {
        return this.selectedDocumentType;
    }

    public void setSelectedDocumentType(NVDocumentType nVDocumentType) {
        this.selectedDocumentType = nVDocumentType;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String str) {
        this.idNumber = StringUtil.trim(str, 100);
    }

    public String getPersonalNumber() {
        return this.personalNumber;
    }

    public void setPersonalNumber(String str) {
        this.personalNumber = StringUtil.trim(str, 14, "^[A-Z0-9]*$");
    }

    public Date getIssuingDate() {
        return this.issuingDate;
    }

    public void setIssuingDate(Date date) {
        this.issuingDate = date;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date date) {
        this.expiryDate = date;
    }

    public String getIssuingCountry() {
        return this.issuingCountry;
    }

    public void setIssuingCountry(String str) {
        this.issuingCountry = StringUtil.trim(str, 3, "[A-Z]{3}");
        if (!checkCountryCode(str)) {
            this.issuingCountry = null;
        }
    }

    public String getLastName() {
        String str = this.lastName;
        if (getNameSuffix() == null || getNameSuffix().length() == 0 || str == null || str.endsWith(getNameSuffix())) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.lastName);
        stringBuilder.append(" ");
        stringBuilder.append(getNameSuffix());
        return stringBuilder.toString();
    }

    public void setLastName(String str) {
        this.lastName = StringUtil.trim(str, 100);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = StringUtil.trim(str, 100);
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String str) {
        this.middleName = StringUtil.trim(str, 100);
    }

    public String getNameSuffix() {
        return this.nameSuffix;
    }

    public void setNameSuffix(String str) {
        this.nameSuffix = StringUtil.trim(str, 100);
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date date) {
        this.dob = date;
    }

    public NVGender getGender() {
        return this.gender;
    }

    public void setGender(NVGender nVGender) {
        this.gender = nVGender;
    }

    public String getOriginatingCountry() {
        return this.originatingCountry;
    }

    public void setOriginatingCountry(String str) {
        this.originatingCountry = StringUtil.trim(str, 3, "[A-Z]{3}");
        if (!checkCountryCode(str)) {
            this.originatingCountry = null;
        }
    }

    public String getAddressLine() {
        return this.addressLine;
    }

    public void setAddressLine(String str) {
        this.addressLine = StringUtil.trim(str, 255);
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = StringUtil.trim(str, 64);
    }

    public String getSubdivision() {
        return this.subdivision;
    }

    public void setSubdivision(String str) {
        this.subdivision = StringUtil.trim(str, 3, "[A-Z]{2,3}");
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String str) {
        this.postCode = StringUtil.trim(str, 15);
    }

    public String getOptionalData1() {
        return this.optData1;
    }

    public void setOptionalData1(String str) {
        this.optData1 = StringUtil.trim(str, 50, "^[A-Z0-9]*$");
    }

    public String getOptionalData2() {
        return this.optData2;
    }

    public void setOptionalData2(String str) {
        this.optData2 = StringUtil.trim(str, 50, "^[A-Z0-9]*$");
    }

    private boolean checkCountryCode(String str) {
        return (str == null || str.length() == 0) ? false : new Country(str).getName().equalsIgnoreCase(str) ^ 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.selectedCountry == null ? "" : this.selectedCountry);
        parcel.writeString(this.selectedDocumentType == null ? "" : this.selectedDocumentType.name());
        parcel.writeString(this.idNumber == null ? "" : this.idNumber);
        parcel.writeString(this.personalNumber == null ? "" : this.personalNumber);
        long j = 0;
        parcel.writeLong(this.issuingDate == null ? 0 : this.issuingDate.getTime());
        parcel.writeLong(this.expiryDate == null ? 0 : this.expiryDate.getTime());
        parcel.writeString(this.issuingCountry == null ? "" : this.issuingCountry);
        parcel.writeString(this.lastName == null ? "" : this.lastName);
        parcel.writeString(this.firstName == null ? "" : this.firstName);
        parcel.writeString(this.middleName == null ? "" : this.middleName);
        parcel.writeString(this.nameSuffix == null ? "" : this.nameSuffix);
        if (this.dob != null) {
            j = this.dob.getTime();
        }
        parcel.writeLong(j);
        parcel.writeString(this.gender == null ? "" : this.gender.name());
        parcel.writeString(this.originatingCountry == null ? "" : this.originatingCountry);
        parcel.writeString(this.addressLine == null ? "" : this.addressLine);
        parcel.writeString(this.city == null ? "" : this.city);
        parcel.writeString(this.subdivision == null ? "" : this.subdivision);
        parcel.writeString(this.postCode == null ? "" : this.postCode);
        parcel.writeString(this.optData1 == null ? "" : this.optData1);
        parcel.writeString(this.optData2 == null ? "" : this.optData2);
        parcel.writeParcelable(this.mrzData, 0);
        parcel.writeString(this.placeOfBirth);
        parcel.writeString(this.frontImage);
        parcel.writeString(this.backImage);
        parcel.writeString(this.faceImage);
        parcel.writeString(this.emrtdStatus.toString());
        parcel.writeString(this.extractionMethod.name());
    }

    public NetverifyMrzData getMrzData() {
        return this.mrzData;
    }

    public void setMrzData(NetverifyMrzData netverifyMrzData) {
        this.mrzData = netverifyMrzData;
    }

    public EMRTDStatus getEMRTDStatus() {
        return this.emrtdStatus;
    }

    public void setEMRTDStatus(EMRTDStatus eMRTDStatus) {
        this.emrtdStatus = eMRTDStatus;
    }

    public NVExtractionMethod getExtractionMethod() {
        return this.extractionMethod;
    }

    public void setExtractionMethod(NVExtractionMethod nVExtractionMethod) {
        this.extractionMethod = nVExtractionMethod;
    }

    public String getFrontImage() {
        return this.frontImage;
    }

    public void setFrontImage(String str) {
        this.frontImage = str;
    }

    public String getBackImage() {
        return this.backImage;
    }

    public void setBackImage(String str) {
        this.backImage = str;
    }

    public String getFaceImage() {
        return this.faceImage;
    }

    public void setFaceImage(String str) {
        this.faceImage = str;
    }
}
