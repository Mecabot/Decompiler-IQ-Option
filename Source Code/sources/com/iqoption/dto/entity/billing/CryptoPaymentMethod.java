package com.iqoption.dto.entity.billing;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, aXE = {"Lcom/iqoption/dto/entity/billing/CryptoPaymentMethod;", "", "id", "", "name", "", "address", "currency", "iconUrl", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCurrency", "getIconUrl", "getId", "()J", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "IqOption-5.5.1_optionXRelease"})
/* compiled from: CryptoPaymentMethod.kt */
public final class CryptoPaymentMethod {
    @SerializedName("address")
    private final String address;
    @SerializedName("currency")
    private final String currency;
    @SerializedName("icon_url")
    private final String iconUrl;
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;

    public static /* synthetic */ CryptoPaymentMethod copy$default(CryptoPaymentMethod cryptoPaymentMethod, long j, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cryptoPaymentMethod.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = cryptoPaymentMethod.name;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = cryptoPaymentMethod.address;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = cryptoPaymentMethod.currency;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = cryptoPaymentMethod.iconUrl;
        }
        return cryptoPaymentMethod.copy(j2, str5, str6, str7, str4);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.address;
    }

    public final String component4() {
        return this.currency;
    }

    public final String component5() {
        return this.iconUrl;
    }

    public final CryptoPaymentMethod copy(long j, String str, String str2, String str3, String str4) {
        h.e(str, "name");
        h.e(str2, "address");
        h.e(str3, b.CURRENCY);
        h.e(str4, "iconUrl");
        return new CryptoPaymentMethod(j, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CryptoPaymentMethod) {
            CryptoPaymentMethod cryptoPaymentMethod = (CryptoPaymentMethod) obj;
            return ((this.id > cryptoPaymentMethod.id ? 1 : (this.id == cryptoPaymentMethod.id ? 0 : -1)) == 0 ? 1 : null) != null && h.E(this.name, cryptoPaymentMethod.name) && h.E(this.address, cryptoPaymentMethod.address) && h.E(this.currency, cryptoPaymentMethod.currency) && h.E(this.iconUrl, cryptoPaymentMethod.iconUrl);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.address;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.currency;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.iconUrl;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CryptoPaymentMethod(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", address=");
        stringBuilder.append(this.address);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public CryptoPaymentMethod(long j, String str, String str2, String str3, String str4) {
        h.e(str, "name");
        h.e(str2, "address");
        h.e(str3, b.CURRENCY);
        h.e(str4, "iconUrl");
        this.id = j;
        this.name = str;
        this.address = str2;
        this.currency = str3;
        this.iconUrl = str4;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }
}
