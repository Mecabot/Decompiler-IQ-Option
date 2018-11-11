package com.iqoption.charttools.model.a;

import com.iqoption.charttools.model.indicator.h;
import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, aXE = {"Lcom/iqoption/charttools/model/template/ChartTemplate;", "", "id", "", "name", "", "config", "Lcom/iqoption/charttools/model/chart/ChartConfig;", "indicators", "", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "figures", "(JLjava/lang/String;Lcom/iqoption/charttools/model/chart/ChartConfig;Ljava/util/List;Ljava/util/List;)V", "getConfig", "()Lcom/iqoption/charttools/model/chart/ChartConfig;", "getFigures", "()Ljava/util/List;", "getId", "()J", "getIndicators", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "techtools_release"})
/* compiled from: ChartTemplate.kt */
public final class a {
    private final List<h> arF;
    private final List<h> asP;
    private final com.iqoption.charttools.model.chart.a azi;
    private final long id;
    private final String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return ((this.id > aVar.id ? 1 : (this.id == aVar.id ? 0 : -1)) == 0 ? 1 : null) != null && kotlin.jvm.internal.h.E(this.name, aVar.name) && kotlin.jvm.internal.h.E(this.azi, aVar.azi) && kotlin.jvm.internal.h.E(this.arF, aVar.arF) && kotlin.jvm.internal.h.E(this.asP, aVar.asP);
        }
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        i = (i + (str != null ? str.hashCode() : 0)) * 31;
        com.iqoption.charttools.model.chart.a aVar = this.azi;
        i = (i + (aVar != null ? aVar.hashCode() : 0)) * 31;
        List list = this.arF;
        i = (i + (list != null ? list.hashCode() : 0)) * 31;
        list = this.asP;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i + i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChartTemplate(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", config=");
        stringBuilder.append(this.azi);
        stringBuilder.append(", indicators=");
        stringBuilder.append(this.arF);
        stringBuilder.append(", figures=");
        stringBuilder.append(this.asP);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public a(long j, String str, com.iqoption.charttools.model.chart.a aVar, List<h> list, List<h> list2) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(list, "indicators");
        kotlin.jvm.internal.h.e(list2, "figures");
        this.id = j;
        this.name = str;
        this.azi = aVar;
        this.arF = list;
        this.asP = list2;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final com.iqoption.charttools.model.chart.a MK() {
        return this.azi;
    }

    public final List<h> JT() {
        return this.arF;
    }

    public final List<h> Kr() {
        return this.asP;
    }
}
