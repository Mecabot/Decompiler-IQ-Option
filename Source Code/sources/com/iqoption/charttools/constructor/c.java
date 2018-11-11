package com.iqoption.charttools.constructor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.iqoption.charttools.model.indicator.h;
import com.iqoption.charttools.model.indicator.x;
import com.iqoption.charttools.model.indicator.z;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u000bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\rHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, aXE = {"Lcom/iqoption/charttools/constructor/IndicatorSettingsInputData;", "Landroid/os/Parcelable;", "tabId", "", "activeId", "", "indicator", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "postToOutput", "", "(Ljava/lang/String;ILcom/iqoption/charttools/model/indicator/ChartIndicator;Z)V", "(Ljava/lang/String;Lcom/iqoption/charttools/model/indicator/ChartIndicator;Z)V", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "(Ljava/lang/String;ILcom/iqoption/charttools/model/indicator/MetaIndicator;Lcom/iqoption/charttools/model/indicator/ChartIndicator;Z)V", "getActiveId", "()I", "getIndicator", "()Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "getMeta", "()Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getPostToOutput", "()Z", "getTabId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "techtools_release"})
/* compiled from: IndicatorSettingsInputData.kt */
public final class c implements Parcelable {
    public static final Creator CREATOR = new a();
    private final int activeId;
    private final h arE;
    private final String atG;
    private final x atH;
    private final boolean atI;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "in");
            return new c(parcel.readString(), parcel.readInt(), (x) z.ayE.E(parcel), parcel.readInt() != 0 ? (h) h.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
        }

        public final Object[] newArray(int i) {
            return new c[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (kotlin.jvm.internal.h.E(this.atG, cVar.atG)) {
                if ((this.activeId == cVar.activeId ? 1 : null) != null && kotlin.jvm.internal.h.E(this.atH, cVar.atH) && kotlin.jvm.internal.h.E(this.arE, cVar.arE)) {
                    if ((this.atI == cVar.atI ? 1 : null) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.atG;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.activeId) * 31;
        x xVar = this.atH;
        hashCode = (hashCode + (xVar != null ? xVar.hashCode() : 0)) * 31;
        h hVar = this.arE;
        if (hVar != null) {
            i = hVar.hashCode();
        }
        hashCode = (hashCode + i) * 31;
        i = this.atI;
        if (i != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IndicatorSettingsInputData(tabId=");
        stringBuilder.append(this.atG);
        stringBuilder.append(", activeId=");
        stringBuilder.append(this.activeId);
        stringBuilder.append(", meta=");
        stringBuilder.append(this.atH);
        stringBuilder.append(", indicator=");
        stringBuilder.append(this.arE);
        stringBuilder.append(", postToOutput=");
        stringBuilder.append(this.atI);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        parcel.writeString(this.atG);
        parcel.writeInt(this.activeId);
        z.ayE.a(this.atH, parcel, i);
        Parcelable parcelable = this.arE;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.atI);
    }

    public c(String str, int i, x xVar, h hVar, boolean z) {
        kotlin.jvm.internal.h.e(str, "tabId");
        kotlin.jvm.internal.h.e(xVar, "meta");
        this.atG = str;
        this.activeId = i;
        this.atH = xVar;
        this.arE = hVar;
        this.atI = z;
    }

    public final String KI() {
        return this.atG;
    }

    public final int getActiveId() {
        return this.activeId;
    }

    public final x KJ() {
        return this.atH;
    }

    public /* synthetic */ c(String str, int i, x xVar, h hVar, boolean z, int i2, f fVar) {
        if ((i2 & 8) != 0) {
            hVar = (h) null;
        }
        this(str, i, xVar, hVar, (i2 & 16) != 0 ? false : z);
    }

    public final h JS() {
        return this.arE;
    }

    public final boolean KK() {
        return this.atI;
    }

    public /* synthetic */ c(String str, int i, h hVar, boolean z, int i2, f fVar) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        this(str, i, hVar, z);
    }

    public c(String str, int i, h hVar, boolean z) {
        kotlin.jvm.internal.h.e(str, "tabId");
        kotlin.jvm.internal.h.e(hVar, "indicator");
        this(str, i, hVar.KJ(), hVar, z);
    }

    public c(String str, h hVar, boolean z) {
        kotlin.jvm.internal.h.e(str, "tabId");
        kotlin.jvm.internal.h.e(hVar, "indicator");
        this(str, -1, hVar, z);
    }
}
