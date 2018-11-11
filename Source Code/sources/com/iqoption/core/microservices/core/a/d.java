package com.iqoption.core.microservices.core.a;

import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.Currencies;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\rHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006%"}, aXE = {"Lcom/iqoption/core/microservices/core/response/RegistrationCurrency;", "", "()V", "id", "", "name", "", "symbol", "mask", "isDefault", "", "isRegistration", "minInvestment", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZD)V", "getId", "()J", "()Z", "getMask", "()Ljava/lang/String;", "getMinInvestment", "()D", "getName", "getSymbol", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "core_release"})
/* compiled from: RegistrationCurrency.kt */
public final class d {
    @SerializedName("registration")
    private final boolean aVE;
    @SerializedName("min_investment")
    private final double aVF;
    @SerializedName("id")
    private final long id;
    @SerializedName("is_default")
    private final boolean isDefault;
    @SerializedName("mask")
    private final String mask;
    @SerializedName("name")
    private final String name;
    @SerializedName("symbol")
    private final String symbol;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if ((this.id == dVar.id ? 1 : null) != null && h.E(this.name, dVar.name) && h.E(this.symbol, dVar.symbol) && h.E(this.mask, dVar.mask)) {
                if ((this.isDefault == dVar.isDefault ? 1 : null) != null) {
                    return (this.aVE == dVar.aVE ? 1 : null) != null && Double.compare(this.aVF, dVar.aVF) == 0;
                }
            }
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.symbol;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.mask;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        int i3 = this.isDefault;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.aVE;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.aVF);
        return i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RegistrationCurrency(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", symbol=");
        stringBuilder.append(this.symbol);
        stringBuilder.append(", mask=");
        stringBuilder.append(this.mask);
        stringBuilder.append(", isDefault=");
        stringBuilder.append(this.isDefault);
        stringBuilder.append(", isRegistration=");
        stringBuilder.append(this.aVE);
        stringBuilder.append(", minInvestment=");
        stringBuilder.append(this.aVF);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public d(long j, String str, String str2, String str3, boolean z, boolean z2, double d) {
        h.e(str, "name");
        h.e(str2, "symbol");
        h.e(str3, "mask");
        this.id = j;
        this.name = str;
        this.symbol = str2;
        this.mask = str3;
        this.isDefault = z;
        this.aVE = z2;
        this.aVF = d;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final boolean VK() {
        return this.aVE;
    }

    public /* synthetic */ d(long j, String str, String str2, String str3, boolean z, boolean z2, double d, int i, f fVar) {
        this((i & 1) != 0 ? -1 : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? Currencies.REPLACE_CURRENCY_MASK : str3, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? 0.0d : d);
    }

    public d() {
        this(-1, null, null, null, false, false, 0.0d, 126, null);
    }
}
