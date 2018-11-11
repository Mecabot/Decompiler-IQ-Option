package com.iqoption.asset.mediators;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import kotlin.i;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;

@i(aXC = {1, 1, 11}, aXD = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J?\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\t\u0010)\u001a\u00020\u0002HÖ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0002HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0002HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u00065"}, aXE = {"Lcom/iqoption/asset/mediators/AssetDisplayData;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "Landroid/os/Parcelable;", "active", "Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "spread", "Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "leverages", "Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "commissionData", "Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "isFavorite", "", "(Lcom/iqoption/core/microservices/tradingengine/response/active/Active;Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;Z)V", "getActive", "()Lcom/iqoption/core/microservices/tradingengine/response/active/Active;", "getCommissionData", "()Lcom/iqoption/core/microservices/risks/response/commission/CommissionData;", "id", "getId", "()Ljava/lang/Integer;", "()Z", "getLeverages", "()Lcom/iqoption/core/microservices/tradingengine/response/leverage/LeverageInfo;", "getSpread", "()Lcom/iqoption/core/microservices/topassets/response/spread/SpreadData;", "spreadPercent", "", "spreadPercent$annotations", "()V", "getSpreadPercent", "()Ljava/lang/Double;", "spreadPercent$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "asset_release"})
/* compiled from: AssetDisplayData.kt */
public final class a implements Parcelable, d<Integer> {
    public static final Creator CREATOR = new a();
    static final /* synthetic */ j[] apP = new j[]{kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.F(a.class), "spreadPercent", "getSpreadPercent()Ljava/lang/Double;"))};
    private final com.iqoption.core.microservices.tradingengine.response.active.a aiJ;
    private final kotlin.d apQ = g.f(new AssetDisplayData$spreadPercent$2(this));
    private final com.iqoption.core.microservices.f.a.a.a apR;
    private final com.iqoption.core.microservices.tradingengine.response.b.a apS;
    private final com.iqoption.core.microservices.risks.response.a.a apT;
    private final boolean apU;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            return new a((com.iqoption.core.microservices.tradingengine.response.active.a) parcel.readParcelable(a.class.getClassLoader()), (com.iqoption.core.microservices.f.a.a.a) parcel.readParcelable(a.class.getClassLoader()), (com.iqoption.core.microservices.tradingengine.response.b.a) parcel.readParcelable(a.class.getClassLoader()), (com.iqoption.core.microservices.risks.response.a.a) parcel.readParcelable(a.class.getClassLoader()), parcel.readInt() != 0);
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
            if (h.E(this.aiJ, aVar.aiJ) && h.E(this.apR, aVar.apR) && h.E(this.apS, aVar.apS) && h.E(this.apT, aVar.apT)) {
                if ((this.apU == aVar.apU ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        com.iqoption.core.microservices.tradingengine.response.active.a aVar = this.aiJ;
        int i = 0;
        int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        com.iqoption.core.microservices.f.a.a.a aVar2 = this.apR;
        hashCode = (hashCode + (aVar2 != null ? aVar2.hashCode() : 0)) * 31;
        com.iqoption.core.microservices.tradingengine.response.b.a aVar3 = this.apS;
        hashCode = (hashCode + (aVar3 != null ? aVar3.hashCode() : 0)) * 31;
        com.iqoption.core.microservices.risks.response.a.a aVar4 = this.apT;
        if (aVar4 != null) {
            i = aVar4.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.apU;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AssetDisplayData(active=");
        stringBuilder.append(this.aiJ);
        stringBuilder.append(", spread=");
        stringBuilder.append(this.apR);
        stringBuilder.append(", leverages=");
        stringBuilder.append(this.apS);
        stringBuilder.append(", commissionData=");
        stringBuilder.append(this.apT);
        stringBuilder.append(", isFavorite=");
        stringBuilder.append(this.apU);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeParcelable(this.aiJ, i);
        parcel.writeParcelable(this.apR, i);
        parcel.writeParcelable(this.apS, i);
        parcel.writeParcelable(this.apT, i);
        parcel.writeInt(this.apU);
    }

    public a(com.iqoption.core.microservices.tradingengine.response.active.a aVar, com.iqoption.core.microservices.f.a.a.a aVar2, com.iqoption.core.microservices.tradingengine.response.b.a aVar3, com.iqoption.core.microservices.risks.response.a.a aVar4, boolean z) {
        h.e(aVar, "active");
        h.e(aVar2, "spread");
        this.aiJ = aVar;
        this.apR = aVar2;
        this.apS = aVar3;
        this.apT = aVar4;
        this.apU = z;
    }

    public final com.iqoption.core.microservices.tradingengine.response.active.a Jg() {
        return this.aiJ;
    }

    public final com.iqoption.core.microservices.f.a.a.a Jh() {
        return this.apR;
    }

    /* renamed from: Je */
    public Integer Jf() {
        return Integer.valueOf(this.aiJ.getActiveId());
    }
}
