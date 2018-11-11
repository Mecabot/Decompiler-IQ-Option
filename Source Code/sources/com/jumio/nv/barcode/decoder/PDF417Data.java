package com.jumio.nv.barcode.decoder;

import com.jumio.nv.barcode.enums.EyeColor;
import com.jumio.nv.enums.NVGender;
import java.util.Date;

public class PDF417Data {
    private String addressCity = "";
    private String addressState = "";
    private String addressStreet1 = "";
    private String addressStreet2 = "";
    private String addressZip = "";
    private Date dateOfBirth = null;
    private String endorsementCodes = "";
    private Date expiryDate = null;
    private EyeColor eyeColor = null;
    private String firstName = "";
    private NVGender gender = null;
    private String height = "";
    private String idNumber = "";
    private Date issueDate = null;
    private String issuingCountry = "";
    private String lastName = "";
    private String middleName = "";
    private String nameSuffix = "";
    private String restrictionCodes = "";
    private StringBuilder unparsedData = new StringBuilder();
    private String vehicleClass = "";

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String str) {
        if (str != null && !str.trim().equals("")) {
            this.idNumber = str;
        }
    }

    public Date getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(Date date) {
        this.issueDate = date;
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
        if (str != null && !str.trim().equals("")) {
            this.issuingCountry = str;
        }
    }

    public String getVehicleClass() {
        return this.vehicleClass;
    }

    public void setVehicleClass(String str) {
        if (str != null && !str.trim().equals("")) {
            this.vehicleClass = str;
        }
    }

    public String getRestrictionCodes() {
        return this.restrictionCodes;
    }

    public void setRestrictionCodes(String str) {
        if (str != null && !str.trim().equals("")) {
            this.restrictionCodes = str;
        }
    }

    public String getEndorsementCodes() {
        return this.endorsementCodes;
    }

    public void setEndorsementCodes(String str) {
        if (str != null && !str.trim().equals("")) {
            this.endorsementCodes = str;
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        if (str != null && !str.trim().equals("") && !str.equalsIgnoreCase("NONE")) {
            this.firstName = str;
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        if (str != null && !str.trim().equals("") && !str.equalsIgnoreCase("NONE")) {
            this.lastName = str;
        }
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String str) {
        if (str != null && !str.trim().equals("") && !str.equalsIgnoreCase("NONE")) {
            this.middleName = str;
        }
    }

    public String getNameSuffix() {
        return this.nameSuffix;
    }

    public void setNameSuffix(String str) {
        this.nameSuffix = str;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
    }

    public NVGender getGender() {
        return this.gender;
    }

    public void setGender(NVGender nVGender) {
        if (nVGender != null) {
            this.gender = nVGender;
        }
    }

    public EyeColor getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        if (eyeColor != null) {
            this.eyeColor = eyeColor;
        }
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String str) {
        if (str != null && !str.trim().equals("")) {
            this.height = str;
        }
    }

    public String getAddressStreet1() {
        return this.addressStreet1;
    }

    public void setAddressStreet1(String str) {
        if (str != null && !str.trim().equals("")) {
            this.addressStreet1 = str;
        }
    }

    public String getAddressStreet2() {
        return this.addressStreet2;
    }

    public void setAddressStreet2(String str) {
        if (str != null && !str.trim().equals("")) {
            this.addressStreet2 = str;
        }
    }

    public String getAddressCity() {
        return this.addressCity;
    }

    public void setAddressCity(String str) {
        if (str != null && !str.trim().equals("")) {
            this.addressCity = str;
        }
    }

    public String getAddressState() {
        return this.addressState;
    }

    public void setAddressState(String str) {
        if (str != null && !str.trim().equals("")) {
            this.addressState = str;
        }
    }

    public String getAddressZip() {
        return this.addressZip;
    }

    public void setAddressZip(String str) {
        if (str != null && !str.trim().equals("")) {
            this.addressZip = str;
        }
    }

    public StringBuilder getUnparsedData() {
        return this.unparsedData;
    }

    public void addUnparsedData(String str, String str2) {
        StringBuilder stringBuilder = this.unparsedData;
        stringBuilder.append(str);
        stringBuilder.append(str2);
    }

    public String toString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.issueDate != null) {
            stringBuilder.append("issueDate: ");
            stringBuilder.append(this.issueDate.toString());
            stringBuilder.append(str);
        }
        if (this.expiryDate != null) {
            stringBuilder.append("expiryDate: ");
            stringBuilder.append(this.expiryDate.toString());
            stringBuilder.append(str);
        }
        if (!(this.issuingCountry == null || this.issuingCountry.equals(""))) {
            stringBuilder.append("issuingCountry: ");
            stringBuilder.append(this.issuingCountry);
            stringBuilder.append(str);
        }
        if (!(this.vehicleClass == null || this.vehicleClass.equals(""))) {
            stringBuilder.append("vehicleClass: ");
            stringBuilder.append(this.vehicleClass);
            stringBuilder.append(str);
        }
        if (!(this.restrictionCodes == null || this.restrictionCodes.equals(""))) {
            stringBuilder.append("restrictionCodes: ");
            stringBuilder.append(this.restrictionCodes);
            stringBuilder.append(str);
        }
        if (!(this.endorsementCodes == null || this.endorsementCodes.equals(""))) {
            stringBuilder.append("endorsementCodes: ");
            stringBuilder.append(this.endorsementCodes);
            stringBuilder.append(str);
        }
        if (!(this.firstName == null || this.firstName.equals(""))) {
            stringBuilder.append("firstName: ");
            stringBuilder.append(this.firstName);
            stringBuilder.append(str);
        }
        if (!(this.lastName == null || this.lastName.equals(""))) {
            stringBuilder.append("lastName: ");
            stringBuilder.append(this.lastName);
            stringBuilder.append(str);
        }
        if (!(this.middleName == null || this.middleName.equals(""))) {
            stringBuilder.append("middleName: ");
            stringBuilder.append(this.middleName);
            stringBuilder.append(str);
        }
        if (this.dateOfBirth != null) {
            stringBuilder.append("dateOfBirth: ");
            stringBuilder.append(this.dateOfBirth);
            stringBuilder.append(str);
        }
        if (this.gender != null) {
            stringBuilder.append("sex: ");
            stringBuilder.append(this.gender.name());
            stringBuilder.append(str);
        }
        if (this.eyeColor != null) {
            stringBuilder.append("eyeColor: ");
            stringBuilder.append(this.eyeColor);
            stringBuilder.append(str);
        }
        if (!(this.height == null || this.height.equals(""))) {
            stringBuilder.append("height: ");
            stringBuilder.append(this.height);
            stringBuilder.append(str);
        }
        if (!(this.addressStreet1 == null || this.addressStreet1.equals(""))) {
            stringBuilder.append("addressStreet1: ");
            stringBuilder.append(this.addressStreet1);
            stringBuilder.append(str);
        }
        if (!(this.addressStreet2 == null || this.addressStreet2.equals(""))) {
            stringBuilder.append("addressStreet2: ");
            stringBuilder.append(this.addressStreet2);
            stringBuilder.append(str);
        }
        if (!(this.addressCity == null || this.addressCity.equals(""))) {
            stringBuilder.append("addressCity: ");
            stringBuilder.append(this.addressCity);
            stringBuilder.append(str);
        }
        if (!(this.addressState == null || this.addressState.equals(""))) {
            stringBuilder.append("addressState: ");
            stringBuilder.append(this.addressState);
            stringBuilder.append(str);
        }
        if (!(this.addressZip == null || this.addressZip.equals(""))) {
            stringBuilder.append("addressZip: ");
            stringBuilder.append(this.addressZip);
            stringBuilder.append(str);
        }
        if (!(this.idNumber == null || this.idNumber.equals(""))) {
            stringBuilder.append("idNumber: ");
            stringBuilder.append(this.idNumber);
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return toString(", ");
    }
}
