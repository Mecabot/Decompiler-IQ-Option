package com.iqoption.kyc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ArrayListMultimap;
import java.util.Date;

/* compiled from: KycProfile */
public class e implements Parcelable {
    public static final Creator<e> CREATOR = new Creator<e>() {
        /* renamed from: K */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: fa */
        public e[] newArray(int i) {
            return new e[i];
        }
    };
    public String address;
    public Date cJq;
    public Boolean cJr;
    public Long cJs;
    public Long cJt;
    public String cJu;
    public ArrayListMultimap<Integer, Integer> cJv = ArrayListMultimap.sq();
    public String city;
    public String firstName;
    public String lastName;
    public String nationality;

    public int describeContents() {
        return 0;
    }

    public boolean aoO() {
        return (this.firstName == null || this.lastName == null || this.cJq == null || this.cJr == null || this.cJs == null || this.nationality == null || this.city == null || this.cJu == null || this.address == null) ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeLong(this.cJq != null ? this.cJq.getTime() : -1);
        parcel.writeValue(this.cJr);
        parcel.writeValue(this.cJs);
        parcel.writeValue(this.cJt);
        parcel.writeString(this.nationality);
        parcel.writeString(this.city);
        parcel.writeString(this.cJu);
        parcel.writeString(this.address);
        parcel.writeSerializable(this.cJv);
    }

    protected e(Parcel parcel) {
        Date date;
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        long readLong = parcel.readLong();
        if (readLong == -1) {
            date = null;
        } else {
            date = new Date(readLong);
        }
        this.cJq = date;
        this.cJr = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.cJs = (Long) parcel.readValue(Long.class.getClassLoader());
        this.cJt = (Long) parcel.readValue(Long.class.getClassLoader());
        this.nationality = parcel.readString();
        this.city = parcel.readString();
        this.cJu = parcel.readString();
        this.address = parcel.readString();
        this.cJv = (ArrayListMultimap) parcel.readSerializable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.firstName == null ? this.firstName.equals(eVar.firstName) : eVar.firstName == null) {
            return false;
        }
        if (!this.lastName == null ? this.lastName.equals(eVar.lastName) : eVar.lastName == null) {
            return false;
        }
        if (!this.cJq == null ? this.cJq.equals(eVar.cJq) : eVar.cJq == null) {
            return false;
        }
        if (!this.cJr == null ? this.cJr.equals(eVar.cJr) : eVar.cJr == null) {
            return false;
        }
        if (!this.cJs == null ? this.cJs.equals(eVar.cJs) : eVar.cJs == null) {
            return false;
        }
        if (!this.cJt == null ? this.cJt.equals(eVar.cJt) : eVar.cJt == null) {
            return false;
        }
        if (!this.nationality == null ? this.nationality.equals(eVar.nationality) : eVar.nationality == null) {
            return false;
        }
        if (!this.city == null ? this.city.equals(eVar.city) : eVar.city == null) {
            return false;
        }
        if (!this.cJu == null ? this.cJu.equals(eVar.cJu) : eVar.cJu == null) {
            return false;
        }
        if (this.address == null ? eVar.address == null : this.address.equals(eVar.address)) {
            return this.cJv.equals(eVar.cJv);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((this.firstName != null ? this.firstName.hashCode() : 0) * 31) + (this.lastName != null ? this.lastName.hashCode() : 0)) * 31) + (this.cJq != null ? this.cJq.hashCode() : 0)) * 31) + (this.cJr != null ? this.cJr.hashCode() : 0)) * 31) + (this.cJs != null ? this.cJs.hashCode() : 0)) * 31) + (this.cJt != null ? this.cJt.hashCode() : 0)) * 31) + (this.nationality != null ? this.nationality.hashCode() : 0)) * 31) + (this.city != null ? this.city.hashCode() : 0)) * 31) + (this.cJu != null ? this.cJu.hashCode() : 0)) * 31;
        if (this.address != null) {
            i = this.address.hashCode();
        }
        return ((hashCode + i) * 31) + this.cJv.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KycProfile{firstName='");
        stringBuilder.append(this.firstName);
        stringBuilder.append('\'');
        stringBuilder.append(", lastName='");
        stringBuilder.append(this.lastName);
        stringBuilder.append('\'');
        stringBuilder.append(", birthDate=");
        stringBuilder.append(this.cJq);
        stringBuilder.append(", isMale=");
        stringBuilder.append(this.cJr);
        stringBuilder.append(", countryId=");
        stringBuilder.append(this.cJs);
        stringBuilder.append(", citizenCountryId=");
        stringBuilder.append(this.cJt);
        stringBuilder.append(", nationality='");
        stringBuilder.append(this.nationality);
        stringBuilder.append('\'');
        stringBuilder.append(", city='");
        stringBuilder.append(this.city);
        stringBuilder.append('\'');
        stringBuilder.append(", postalIndex='");
        stringBuilder.append(this.cJu);
        stringBuilder.append('\'');
        stringBuilder.append(", address='");
        stringBuilder.append(this.address);
        stringBuilder.append('\'');
        stringBuilder.append(", answers=");
        stringBuilder.append(this.cJv);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
