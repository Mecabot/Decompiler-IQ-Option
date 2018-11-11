package com.iqoption.core.microservices.configuration.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import com.google.gson.annotations.SerializedName;
import com.iqoption.dto.Currencies;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001JB\u0007\b\u0016¢\u0006\u0002\u0010\u0004B±\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f¢\u0006\u0002\u0010\u001aJ\t\u0010-\u001a\u00020\u0002HÆ\u0003J\t\u0010.\u001a\u00020\u0012HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0010HÆ\u0003Jµ\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\fHÆ\u0001J\t\u0010?\u001a\u00020\u0010HÖ\u0001J\u0013\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0010HÖ\u0001J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00028\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\u0018\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010!R\u0016\u0010\u0019\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010!R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010!R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010!R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u0014\u001a\u00020\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0016\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0016\u0010\u0013\u001a\u00020\u00128\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$¨\u0006K"}, aXE = {"Lcom/iqoption/core/microservices/configuration/response/Currency;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "Landroid/os/Parcelable;", "()V", "id", "name", "", "description", "symbol", "mask", "isVisible", "", "isTradable", "code", "unit", "", "rate", "", "rateUsd", "minDealAmount", "maxDealAmount", "minorUnits", "image", "isCrypto", "isInOut", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;IDDDIILjava/lang/String;ZZ)V", "getCode", "()Ljava/lang/String;", "getDescription", "getId", "()Ljava/lang/Long;", "getImage", "()Z", "getMask", "getMaxDealAmount", "()I", "getMinDealAmount", "()D", "getMinorUnits", "getName", "getRate", "getRateUsd", "getSymbol", "getUnit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "core_release"})
/* compiled from: Currency.kt */
public final class d implements Parcelable, com.iqoption.core.ui.widget.recyclerview.adapter.a.d<Long> {
    private static final String BTC_CURRENCY = "BTC";
    private static final int BTC_CURRENCY_ID = 44;
    public static final Creator CREATOR = new b();
    private static final String ETH_CURRENCY = "ETH";
    private static final int ETH_CURRENCY_ID = 46;
    private static final String OTM_CURRENCY = "OTM";
    private static final int OTM_CURRENCY_ID = 47;
    private static final String OTN_CURRENCY = "OTN";
    private static final int OTN_CURRENCY_ID = 45;
    private static final int aVr = 2;
    private static final int aVs = 6;
    private static final d aVt = new d();
    public static final a aVu = new a();
    @SerializedName("is_tradable")
    private final boolean aVj;
    @SerializedName("unit")
    private final int aVk;
    @SerializedName("rate_usd")
    private final double aVl;
    @SerializedName("min_deal_amount")
    private final double aVm;
    @SerializedName("max_deal_amount")
    private final int aVn;
    @SerializedName("minor_units")
    private final int aVo;
    @SerializedName("is_crypto")
    private final boolean aVp;
    @SerializedName("is_inout")
    private final boolean aVq;
    @SerializedName("code")
    private final String code;
    @SerializedName("description")
    private final String description;
    @SerializedName("id")
    private final long id;
    @SerializedName("image")
    private final String image;
    @SerializedName("is_visible")
    private final boolean isVisible;
    @SerializedName("mask")
    private final String mask;
    @SerializedName("name")
    private final String name;
    @SerializedName("rate")
    private final double rate;
    @SerializedName("symbol")
    private final String symbol;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\n¨\u0006\u001f"}, aXE = {"Lcom/iqoption/core/microservices/configuration/response/Currency$Companion;", "", "()V", "BTC_CURRENCY", "", "getBTC_CURRENCY", "()Ljava/lang/String;", "BTC_CURRENCY_ID", "", "getBTC_CURRENCY_ID", "()I", "CRYPTO_MINOR_UNITS_DEFAULT", "getCRYPTO_MINOR_UNITS_DEFAULT", "EMPTY", "Lcom/iqoption/core/microservices/configuration/response/Currency;", "getEMPTY", "()Lcom/iqoption/core/microservices/configuration/response/Currency;", "ETH_CURRENCY", "getETH_CURRENCY", "ETH_CURRENCY_ID", "getETH_CURRENCY_ID", "MINOR_UNITS_DEFAULT", "getMINOR_UNITS_DEFAULT", "OTM_CURRENCY", "getOTM_CURRENCY", "OTM_CURRENCY_ID", "getOTM_CURRENCY_ID", "OTN_CURRENCY", "getOTN_CURRENCY", "OTN_CURRENCY_ID", "getOTN_CURRENCY_ID", "core_release"})
    /* compiled from: Currency.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11})
    public static class b implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new d(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new d[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if ((Jf().longValue() == dVar.Jf().longValue() ? 1 : null) != null && h.E(this.name, dVar.name) && h.E(this.description, dVar.description) && h.E(this.symbol, dVar.symbol) && h.E(this.mask, dVar.mask)) {
                if ((this.isVisible == dVar.isVisible ? 1 : null) != null) {
                    if ((this.aVj == dVar.aVj ? 1 : null) != null && h.E(this.code, dVar.code)) {
                        if ((this.aVk == dVar.aVk ? 1 : null) != null && Double.compare(this.rate, dVar.rate) == 0 && Double.compare(this.aVl, dVar.aVl) == 0 && Double.compare(this.aVm, dVar.aVm) == 0) {
                            if ((this.aVn == dVar.aVn ? 1 : null) != null) {
                                if ((this.aVo == dVar.aVo ? 1 : null) != null && h.E(this.image, dVar.image)) {
                                    if ((this.aVp == dVar.aVp ? 1 : null) != null) {
                                        if ((this.aVq == dVar.aVq ? 1 : null) != null) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long longValue = Jf().longValue();
        int i = ((int) (longValue ^ (longValue >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.description;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.symbol;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        str = this.mask;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        int i3 = this.isVisible;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.aVj;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        str = this.code;
        i = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.aVk) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.rate);
        i = (i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.aVl);
        i = (i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        doubleToLongBits = Double.doubleToLongBits(this.aVm);
        i = (((((i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.aVn) * 31) + this.aVo) * 31;
        str = this.image;
        if (str != null) {
            i2 = str.hashCode();
        }
        i = (i + i2) * 31;
        i3 = this.aVp;
        if (i3 != 0) {
            i3 = 1;
        }
        i = (i + i3) * 31;
        i3 = this.aVq;
        if (i3 != 0) {
            i3 = 1;
        }
        return i + i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Currency(id=");
        stringBuilder.append(Jf());
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", symbol=");
        stringBuilder.append(this.symbol);
        stringBuilder.append(", mask=");
        stringBuilder.append(this.mask);
        stringBuilder.append(", isVisible=");
        stringBuilder.append(this.isVisible);
        stringBuilder.append(", isTradable=");
        stringBuilder.append(this.aVj);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", unit=");
        stringBuilder.append(this.aVk);
        stringBuilder.append(", rate=");
        stringBuilder.append(this.rate);
        stringBuilder.append(", rateUsd=");
        stringBuilder.append(this.aVl);
        stringBuilder.append(", minDealAmount=");
        stringBuilder.append(this.aVm);
        stringBuilder.append(", maxDealAmount=");
        stringBuilder.append(this.aVn);
        stringBuilder.append(", minorUnits=");
        stringBuilder.append(this.aVo);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", isCrypto=");
        stringBuilder.append(this.aVp);
        stringBuilder.append(", isInOut=");
        stringBuilder.append(this.aVq);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.symbol);
        parcel.writeString(this.mask);
        parcel.writeInt(this.isVisible);
        parcel.writeInt(this.aVj);
        parcel.writeString(this.code);
        parcel.writeInt(this.aVk);
        parcel.writeDouble(this.rate);
        parcel.writeDouble(this.aVl);
        parcel.writeDouble(this.aVm);
        parcel.writeInt(this.aVn);
        parcel.writeInt(this.aVo);
        parcel.writeString(this.image);
        parcel.writeInt(this.aVp);
        parcel.writeInt(this.aVq);
    }

    public d(long j, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, int i, double d, double d2, double d3, int i2, int i3, String str6, boolean z3, boolean z4) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        h.e(str7, "name");
        h.e(str8, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        h.e(str9, "symbol");
        h.e(str10, "mask");
        h.e(str11, "code");
        this.id = j;
        this.name = str7;
        this.description = str8;
        this.symbol = str9;
        this.mask = str10;
        this.isVisible = z;
        this.aVj = z2;
        this.code = str11;
        this.aVk = i;
        this.rate = d;
        this.aVl = d2;
        this.aVm = d3;
        this.aVn = i2;
        this.aVo = i3;
        this.image = str6;
        this.aVp = z3;
        this.aVq = z4;
    }

    /* renamed from: getId */
    public Long Jf() {
        return Long.valueOf(this.id);
    }

    public final String getName() {
        return this.name;
    }

    public final String getMask() {
        return this.mask;
    }

    public /* synthetic */ d(long j, String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, int i, double d, double d2, double d3, int i2, int i3, String str6, boolean z3, boolean z4, int i4, f fVar) {
        int i5 = i4;
        long j2 = (i5 & 1) != 0 ? -1 : j;
        String str7 = (i5 & 2) != 0 ? "" : str;
        String str8 = (i5 & 4) != 0 ? "" : str2;
        String str9 = (i5 & 8) != 0 ? "" : str3;
        String str10 = (i5 & 16) != 0 ? Currencies.REPLACE_CURRENCY_MASK : str4;
        boolean z5 = false;
        boolean z6 = (i5 & 32) != 0 ? false : z;
        boolean z7 = (i5 & 64) != 0 ? false : z2;
        String str11 = (i5 & 128) != 0 ? "" : str5;
        int i6 = (i5 & 256) != 0 ? 1 : i;
        double d4 = (i5 & 512) != 0 ? 0.0d : d;
        double d5 = (i5 & 1024) != 0 ? 0.0d : d2;
        double d6 = (i5 & 2048) != 0 ? 0.0d : d3;
        int i7 = (i5 & 4096) != 0 ? 0 : i2;
        int i8 = (i5 & 8192) != 0 ? aVr : i3;
        String str12 = (i5 & 16384) != 0 ? (String) null : str6;
        boolean z8 = (32768 & i5) != 0 ? false : z3;
        if ((i5 & 65536) == 0) {
            z5 = z4;
        }
        this(j2, str7, str8, str9, str10, z6, z7, str11, i6, d4, d5, d6, i7, i8, str12, z8, z5);
    }

    public final int getMinorUnits() {
        return this.aVo;
    }

    public d() {
        this(-1, null, null, null, null, false, false, null, 0, 0.0d, 0.0d, 0.0d, 0, 0, null, false, false, 131070, null);
    }
}
