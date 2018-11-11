package com.iqoption.dto.entity.iqbus;

import android.support.annotation.Nullable;
import com.google.common.base.d;
import com.google.common.base.f;
import com.google.common.collect.Ordering;
import com.google.gson.annotations.SerializedName;
import com.iqoption.core.i;
import com.iqoption.util.ah;

public class Country {
    public static Ordering<Country> ORDERING = new Ordering<Country>() {
        public int compare(Country country, Country country2) {
            return Ordering.from(String.CASE_INSENSITIVE_ORDER).nullsFirst().compare(country.name, country2.name);
        }
    };
    private static final String TAG = "com.iqoption.dto.entity.iqbus.Country";
    public static final d<Country, Long> getId = new d<Country, Long>() {
        public Long apply(Country country) {
            return country.id;
        }
    };
    public static final d<Country, String> getName = new d<Country, String>() {
        public String apply(Country country) {
            return country.name;
        }
    };
    @SerializedName("code_id")
    public Integer codeId;
    @SerializedName("domain")
    public String domain;
    @SerializedName("id")
    public Long id;
    @SerializedName("is_regulated")
    public Boolean isRegulated;
    @SerializedName("is_visible")
    public Boolean isVisible;
    @SerializedName("name")
    public String name;
    @SerializedName("name_full")
    public String nameFull;
    @SerializedName("name_iso")
    public String nameIso;
    @SerializedName("name_short")
    public String nameShort;
    @SerializedName("phone_code")
    public Integer phoneCode;
    @SerializedName("priority")
    public Integer priority;

    @Nullable
    public static Country fromJson(String str) {
        try {
            return (Country) ah.aGg().fromJson(str, Country.class);
        } catch (Throwable e) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unable to create country from json string ");
            stringBuilder.append(str);
            i.e(str2, stringBuilder.toString(), e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }
        return f.equal(this.id, ((Country) obj).id);
    }

    public int hashCode() {
        return f.hashCode(this.id);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Country{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", phoneCode=");
        stringBuilder.append(this.phoneCode);
        stringBuilder.append(", priority=");
        stringBuilder.append(this.priority);
        stringBuilder.append(", codeId=");
        stringBuilder.append(this.codeId);
        stringBuilder.append(", nameFull='");
        stringBuilder.append(this.nameFull);
        stringBuilder.append('\'');
        stringBuilder.append(", nameShort='");
        stringBuilder.append(this.nameShort);
        stringBuilder.append('\'');
        stringBuilder.append(", nameIso='");
        stringBuilder.append(this.nameIso);
        stringBuilder.append('\'');
        stringBuilder.append(", domain='");
        stringBuilder.append(this.domain);
        stringBuilder.append('\'');
        stringBuilder.append(", isVisible=");
        stringBuilder.append(this.isVisible);
        stringBuilder.append(", isRegulated=");
        stringBuilder.append(this.isRegulated);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
