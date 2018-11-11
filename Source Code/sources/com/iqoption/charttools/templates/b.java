package com.iqoption.charttools.templates;

import com.iqoption.charttools.model.indicator.h;
import kotlin.TypeCastException;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0015"}, aXE = {"Lcom/iqoption/charttools/templates/FigureItem;", "Lcom/iqoption/charttools/templates/InstrumentAdapterItem;", "name", "", "active", "figure", "Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "id", "(Ljava/lang/String;Ljava/lang/String;Lcom/iqoption/charttools/model/indicator/ChartIndicator;Ljava/lang/String;)V", "getActive", "()Ljava/lang/String;", "getFigure", "()Lcom/iqoption/charttools/model/indicator/ChartIndicator;", "getId", "getName", "equals", "", "other", "", "hashCode", "", "techtools_release"})
/* compiled from: InstrumentItems.kt */
public final class b extends d {
    private final String active;
    private final h azj;
    private final String id;
    private final String name;

    public final String getName() {
        return this.name;
    }

    public final String ML() {
        return this.active;
    }

    public final h MM() {
        return this.azj;
    }

    public /* synthetic */ b(String str, String str2, h hVar, String str3, int i, f fVar) {
        if ((i & 8) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("figure:");
            stringBuilder.append(hVar.getIndex());
            str3 = stringBuilder.toString();
        }
        this(str, str2, hVar, str3);
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }

    public b(String str, String str2, h hVar, String str3) {
        kotlin.jvm.internal.h.e(str, "name");
        kotlin.jvm.internal.h.e(str2, "active");
        kotlin.jvm.internal.h.e(hVar, "figure");
        kotlin.jvm.internal.h.e(str3, "id");
        super();
        this.name = str;
        this.active = str2;
        this.azj = hVar;
        this.id = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((kotlin.jvm.internal.h.E(getClass(), obj != null ? obj.getClass() : null) ^ 1) != 0) {
            return false;
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.iqoption.charttools.templates.FigureItem");
        }
        if ((kotlin.jvm.internal.h.E(this.azj, ((b) obj).azj) ^ 1) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.azj.hashCode();
    }
}
