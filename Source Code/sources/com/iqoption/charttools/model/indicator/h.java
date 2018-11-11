package com.iqoption.charttools.model.indicator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.JsonArray;
import com.iqoption.charttools.l;
import com.iqoption.core.ext.f;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u001cHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, aXE = {"Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "Landroid/os/Parcelable;", "meta", "Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "index", "", "isHidden", "", "values", "Lcom/google/gson/JsonArray;", "(Lcom/iqoption/charttools/model/indicator/MetaIndicator;IZLcom/google/gson/JsonArray;)V", "getIndex", "()I", "()Z", "getMeta", "()Lcom/iqoption/charttools/model/indicator/MetaIndicator;", "getValues", "()Lcom/google/gson/JsonArray;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "getParams", "", "getParamsTitle", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "techtools_release"})
/* compiled from: ChartIndicator.kt */
public final class h implements Parcelable {
    public static final Creator CREATOR = new a();
    private final x atH;
    private final JsonArray atL;
    private final boolean aye;
    private final int index;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "in");
            return new h((x) z.ayE.E(parcel), parcel.readInt(), parcel.readInt() != 0, (JsonArray) f.aPt.E(parcel));
        }

        public final Object[] newArray(int i) {
            return new h[i];
        }
    }

    public static /* bridge */ /* synthetic */ h a(h hVar, x xVar, int i, boolean z, JsonArray jsonArray, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            xVar = hVar.atH;
        }
        if ((i2 & 2) != 0) {
            i = hVar.index;
        }
        if ((i2 & 4) != 0) {
            z = hVar.aye;
        }
        if ((i2 & 8) != 0) {
            jsonArray = hVar.atL;
        }
        return hVar.a(xVar, i, z, jsonArray);
    }

    public final h a(x xVar, int i, boolean z, JsonArray jsonArray) {
        kotlin.jvm.internal.h.e(xVar, "meta");
        kotlin.jvm.internal.h.e(jsonArray, "values");
        return new h(xVar, i, z, jsonArray);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (kotlin.jvm.internal.h.E(this.atH, hVar.atH)) {
                if ((this.index == hVar.index ? 1 : null) != null) {
                    return (this.aye == hVar.aye ? 1 : null) != null && kotlin.jvm.internal.h.E(this.atL, hVar.atL);
                }
            }
        }
    }

    public int hashCode() {
        x xVar = this.atH;
        int i = 0;
        int hashCode = (((xVar != null ? xVar.hashCode() : 0) * 31) + this.index) * 31;
        int i2 = this.aye;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (hashCode + i2) * 31;
        JsonArray jsonArray = this.atL;
        if (jsonArray != null) {
            i = jsonArray.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChartIndicator(meta=");
        stringBuilder.append(this.atH);
        stringBuilder.append(", index=");
        stringBuilder.append(this.index);
        stringBuilder.append(", isHidden=");
        stringBuilder.append(this.aye);
        stringBuilder.append(", values=");
        stringBuilder.append(this.atL);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        kotlin.jvm.internal.h.e(parcel, "parcel");
        z.ayE.a(this.atH, parcel, i);
        parcel.writeInt(this.index);
        parcel.writeInt(this.aye);
        f.aPt.a(this.atL, parcel, i);
    }

    public h(x xVar, int i, boolean z, JsonArray jsonArray) {
        kotlin.jvm.internal.h.e(xVar, "meta");
        kotlin.jvm.internal.h.e(jsonArray, "values");
        this.atH = xVar;
        this.index = i;
        this.aye = z;
        this.atL = jsonArray;
    }

    public final x KJ() {
        return this.atH;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean isHidden() {
        return this.aye;
    }

    public final JsonArray Mc() {
        return this.atL;
    }

    public final String Ma() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.atH.Mi());
        String Mb = Mb();
        if ((((CharSequence) Mb).length() > 0 ? 1 : null) != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" (");
            stringBuilder2.append(Mb);
            stringBuilder2.append(')');
            Mb = stringBuilder2.toString();
        } else {
            Mb = "";
        }
        stringBuilder.append(Mb);
        return stringBuilder.toString();
    }

    public final String Mb() {
        return l.asx.b(this);
    }
}
