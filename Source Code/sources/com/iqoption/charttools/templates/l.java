package com.iqoption.charttools.templates;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, aXE = {"Lcom/iqoption/charttools/templates/TemplateInputData;", "Landroid/os/Parcelable;", "tabId", "", "chartConfig", "Lcom/iqoption/charttools/model/chart/ChartConfig;", "(Ljava/lang/String;Lcom/iqoption/charttools/model/chart/ChartConfig;)V", "templateId", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Ljava/lang/Long;Lcom/iqoption/charttools/model/chart/ChartConfig;)V", "getChartConfig", "()Lcom/iqoption/charttools/model/chart/ChartConfig;", "getTabId", "()Ljava/lang/String;", "getTemplateId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "techtools_release"})
/* compiled from: TemplateInputData.kt */
public final class l implements Parcelable {
    public static final Creator CREATOR = new a();
    private final String atG;
    private final Long azJ;
    private final com.iqoption.charttools.model.chart.a azK;

    @i(aXC = {1, 1, 11})
    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.e(parcel, "in");
            String readString = parcel.readString();
            com.iqoption.charttools.model.chart.a aVar = null;
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            if (parcel.readInt() != 0) {
                aVar = (com.iqoption.charttools.model.chart.a) com.iqoption.charttools.model.chart.a.CREATOR.createFromParcel(parcel);
            }
            return new l(readString, valueOf, aVar);
        }

        public final Object[] newArray(int i) {
            return new l[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "parcel");
        parcel.writeString(this.atG);
        Long l = this.azJ;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        Parcelable parcelable = this.azK;
        if (parcelable != null) {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public l(String str, Long l, com.iqoption.charttools.model.chart.a aVar) {
        h.e(str, "tabId");
        this.atG = str;
        this.azJ = l;
        this.azK = aVar;
    }

    public final String KI() {
        return this.atG;
    }

    public final Long MW() {
        return this.azJ;
    }

    public final com.iqoption.charttools.model.chart.a MX() {
        return this.azK;
    }

    public l(String str, com.iqoption.charttools.model.chart.a aVar) {
        h.e(str, "tabId");
        h.e(aVar, "chartConfig");
        this(str, null, aVar);
    }

    public l(String str, Long l) {
        h.e(str, "tabId");
        this(str, l, null);
    }
}
