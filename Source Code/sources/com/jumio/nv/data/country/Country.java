package com.jumio.nv.data.country;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.jumio.nv.IsoCountryConverter;
import com.jumio.nv.data.document.DocumentType;
import java.io.Serializable;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

public class Country implements Parcelable, Serializable, Comparable<Country> {
    public static final Creator<Country> CREATOR = new Creator<Country>() {
        /* renamed from: a */
        public Country createFromParcel(Parcel parcel) {
            return new Country(parcel);
        }

        /* renamed from: a */
        public Country[] newArray(int i) {
            return new Country[i];
        }
    };
    private String a = "";
    private String b = "";

    public boolean canUseTemplateMatcher(Context context, DocumentType documentType) {
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean prepareTemplateMatcher(Context context, DocumentType documentType) {
        return false;
    }

    public Country(String str) {
        String convertToAlpha2 = str.length() == 3 ? IsoCountryConverter.convertToAlpha2(str) : str;
        if (convertToAlpha2 == null) {
            convertToAlpha2 = "";
        }
        a(str, new Locale("", convertToAlpha2).getDisplayCountry());
    }

    public Country(String str, String str2) {
        a(str, str2);
    }

    public Country(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    private void a(String str, String str2) {
        this.a = str;
        if (str2.equals("")) {
            this.b = str;
        } else {
            this.b = str2;
        }
    }

    public CollationKey getCollationKey() {
        return Collator.getInstance().getCollationKey(this.b);
    }

    public String getIsoCode() {
        return this.a;
    }

    public void setIsoCode(String str) {
        this.a = str;
    }

    public String getName() {
        return this.b;
    }

    public void setName(String str) {
        this.b = str;
    }

    public int compareTo(@NonNull Country country) {
        return Collator.getInstance().getCollationKey(this.b).compareTo(country.getCollationKey());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + 31) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country = (Country) obj;
        if (country.b.equals(this.b) && country.getIsoCode().equals(this.a)) {
            z = true;
        }
        return z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public String toString() {
        return String.format("%s (%s)", new Object[]{this.b, this.a});
    }
}
