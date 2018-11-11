package com.iqoption.charttools;

import com.iqoption.charttools.model.a;
import com.iqoption.charttools.model.indicator.ae;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, aXE = {"Lcom/iqoption/charttools/RemoteLibrary;", "", "categories", "", "Lcom/iqoption/charttools/model/IndicatorCategory;", "indicators", "Lcom/iqoption/charttools/model/indicator/ScriptedIndicator;", "(Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getIndicators", "techtools_release"})
/* compiled from: IndicatorsLibraryManager.kt */
final class p {
    private final List<ae> arF;
    private final List<a> asQ;

    public p(List<a> list, List<ae> list2) {
        h.e(list, "categories");
        h.e(list2, "indicators");
        this.asQ = list;
        this.arF = list2;
    }

    public final List<ae> JT() {
        return this.arF;
    }

    public final List<a> Kj() {
        return this.asQ;
    }
}
