package com.iqoption.core.microservices.risks.response.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J`\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006/"}, aXE = {"Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "Landroid/os/Parcelable;", "activeId", "", "value", "", "valueVipDiff", "openFixed", "", "openPercent", "buy", "sell", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getActiveId", "()I", "getBuy", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getOpenFixed", "getOpenPercent", "getSell", "getValue", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getValueVipDiff", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "core_release"})
/* compiled from: CommissionData.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new a();
    @SerializedName("value")
    private final Long aXu;
    @SerializedName("value_vip_diff")
    private final Long aXv;
    @SerializedName("open_fixed")
    private final Double aXw;
    @SerializedName("open_percent")
    private final Double aXx;
    @SerializedName("buy")
    private final Double aXy;
    @SerializedName("sell")
    private final Double aXz;
    @SerializedName("active_id")
    private final int activeId;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new a(parcel.readInt(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null);
        }

        public final Object[] newArray(int i) {
            return new a[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return (this.activeId == aVar.activeId ? 1 : null) != null && h.E(this.aXu, aVar.aXu) && h.E(this.aXv, aVar.aXv) && h.E(this.aXw, aVar.aXw) && h.E(this.aXx, aVar.aXx) && h.E(this.aXy, aVar.aXy) && h.E(this.aXz, aVar.aXz);
        }
    }

    public int hashCode() {
        int i = this.activeId * 31;
        Long l = this.aXu;
        int i2 = 0;
        i = (i + (l != null ? l.hashCode() : 0)) * 31;
        l = this.aXv;
        i = (i + (l != null ? l.hashCode() : 0)) * 31;
        Double d = this.aXw;
        i = (i + (d != null ? d.hashCode() : 0)) * 31;
        d = this.aXx;
        i = (i + (d != null ? d.hashCode() : 0)) * 31;
        d = this.aXy;
        i = (i + (d != null ? d.hashCode() : 0)) * 31;
        d = this.aXz;
        if (d != null) {
            i2 = d.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CommissionData(activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", value=");
        stringBuilder.append(this.aXu);
        stringBuilder.append(", valueVipDiff=");
        stringBuilder.append(this.aXv);
        stringBuilder.append(", openFixed=");
        stringBuilder.append(this.aXw);
        stringBuilder.append(", openPercent=");
        stringBuilder.append(this.aXx);
        stringBuilder.append(", buy=");
        stringBuilder.append(this.aXy);
        stringBuilder.append(", sell=");
        stringBuilder.append(this.aXz);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeInt(this.activeId);
        Long l = this.aXu;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        l = this.aXv;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Double d = this.aXw;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        d = this.aXx;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        d = this.aXy;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        d = this.aXz;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
            return;
        }
        parcel.writeInt(0);
    }

    public a(int i, Long l, Long l2, Double d, Double d2, Double d3, Double d4) {
        this.activeId = i;
        this.aXu = l;
        this.aXv = l2;
        this.aXw = d;
        this.aXx = d2;
        this.aXy = d3;
        this.aXz = d4;
    }

    public final int getActiveId() {
        return this.activeId;
    }

    public final Long WE() {
        return this.aXu;
    }
}
